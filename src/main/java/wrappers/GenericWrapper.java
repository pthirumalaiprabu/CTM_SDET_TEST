package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidCookieDomainException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BY_TYPE;
import utils.TestWork;
import utils.UA_TYPE;

/**
 * Wrapper class which contains all the reusable selenium utility functions.
 * This will be used by all the page classes and also step definition class.
 * @author Thiru
 *
 */
public class GenericWrapper {
	
	protected static WebDriver driver;
	private static Properties prop;
	private String applicationURL, chromeDriverPath, irDriverPath, geckoDriverPath;
	
	
	/**
	 * Constructor where all the basic configurations are set.
	 */
	public GenericWrapper() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("src/test/resources/config.properties")));
			applicationURL = prop.getProperty("URL");
			chromeDriverPath = prop.getProperty("CHROMEDRIVERPATH");
			irDriverPath = prop.getProperty("IEDRIVERPATH");
			geckoDriverPath = prop.getProperty("GECKODRIVERPATH");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * This method invokes the application with the applicationURL on the given browser argument.
	 * After launching the application, the browser will be maximized and the timeout limits are set. 
	 * 
	 * @param browser
	 * @return
	 */
	protected boolean invokeApp(String browser) {
		boolean bReturn = false;
		try {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				driver = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", irDriverPath);
				driver = new InternetExplorerDriver();
			} else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", geckoDriverPath);
				driver = new FirefoxDriver();
			} 
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(applicationURL);

			bReturn = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bReturn;
	}

	
	
	
	
	/**
	 * Deletes all cookies of the current driver object.
	 */
	protected void deleteAllCookie() {
		try {
			driver.manage().deleteAllCookies();
		} catch (InvalidCookieDomainException e) {
			throw new InvalidCookieDomainException("Unable to delete cookies");
		}
	}
	
	
	
	
	





    /**
     * Pauses the java thread by milliSeconds milliSeconds.
     *
     * @param milliSeconds
     */
	protected void delay(int milliSeconds) {

        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException ex) {
        }

    }





    /**
     * This method checks whether the given text is present in the current page. This will search only in the current frame.
     * If the frame is going to be different, it should have been switched before.
     * Incase if the text is not found, it will return false.
     *
     * @param text
     * @return true if found, false if not found.
     */
	protected boolean softTextCheck(String text) {

        delay(100);

        List<WebElement> matchedElements = driver.findElements(By.xpath(".//*[text()[contains(.,'" + text + "')]]"));
        if(matchedElements.size() > 0) {
            return true;
        } else {
        	return false;
        }
    }
	
	
	
	
	
	
	/**
	 * Same as that of softTextCheck method but this will throw exception when the searched text is not found.
	 * If found, it will return true.
	 * 
	 * @param text
	 * @return
	 */
	protected boolean hardTextCheck(String text) {

        delay(100);

        List<WebElement> matchedElements = driver.findElements(By.xpath(".//*[text()[contains(.,'" + text + "')]]"));

        if(matchedElements.size() > 0) {

            return true;

        } else {
        	throw new RuntimeException("The expected text not found in the page : " + text);
        }
    }














    /**
     * Does a simple user action of uaType on a web element with a given elementLocator. Wraps the user action under the given transactionName.
     *
     * @param transactionName
     * @param elementLocator
     * @param uaType
     * @param value
     */
	protected void simpleUserAction(By elementLocator, UA_TYPE uaType, String value) {

        delay(100);
        try {
            WebElement element = driver.findElement(elementLocator);
            simpleUserAction(element, uaType, value, null);
        } catch (StaleElementReferenceException e) {
            delay(2000);

            e.printStackTrace();
            WebElement element = driver.findElement(elementLocator);
            simpleUserAction(element, uaType, value, null);
        }
    }








    /**
     * Does a simple user action of uaType on a web element with a given elementLocator. Wraps the user action under the given transactionName.
     * Also does the given testwork before ending the transaction.
     *
     * @param transactionName
     * @param elementLocator
     * @param uaType
     * @param value
     * @param testWork
     */
	protected void simpleUserAction(By elementLocator, UA_TYPE uaType, String value,
            TestWork testWork) {

        delay(100);
        try {
            WebElement element = driver.findElement(elementLocator);
            simpleUserAction(element, uaType, value, testWork);
        } catch (StaleElementReferenceException e) {
            delay(2000);

            e.printStackTrace();
            WebElement element = driver.findElement(elementLocator);
            simpleUserAction(element, uaType, value, testWork);
        }

    }






    /**
     * Does a simple user action of uaType on a web element. Wraps the user action under the given transactionName.
     *
     * @param transactionName
     * @param element
     * @param uaType
     * @param value
     */
	protected void simpleUserAction(WebElement element, UA_TYPE uaType, String value) {

        delay(100);
        simpleUserAction(element, uaType, value, null);

    }





    /**
     * Does a simple user action of uaType on a web element element. After the user action is done, it will implement the testwork provided.
     * Wraps the user action under the given transactionName.
     *
     * @param transactionName
     * @param element
     * @param uaType
     * @param value
     * @param testWork
     */
	protected void simpleUserAction(WebElement element, UA_TYPE uaType, String value,
            TestWork testWork) {

        delay(100);

        switch (uaType) {

    	        case TYPE:
    	        	element.clear();
    	            element.sendKeys(value);
    	            break;

    	        case CLICK_AND_TYPE:
    	        	element.clear();
    	            element.click();
    	            element.sendKeys(value);
    	            break;

    	        case CLICK:
    	            addExplicitWait(element, "clickable", 30); // clickable,presence,visibility
    	            element.click();
    	            break;

    	        case SELECT_DROPDOWN_OPTION:
    	            selectDropDownByVisibleText(element, value);
    	            break;

	        }

        if (testWork != null){
            testWork.test();
        }


    }






    /**
     * Explicitly wait for the given timeoutInSeconds until the given condition satisfies on the element.
     *
     * @param element
     * @param condition
     * @param intTimeoutInSeconds
     */
	protected void addExplicitWait(WebElement element, String condition, int timeoutInSeconds) {

        delay(100);

        WebDriverWait driverWait = new WebDriverWait(driver, timeoutInSeconds, 250L);

        try {

            if (condition.toLowerCase().equals("visible")) {
                driverWait.until(ExpectedConditions.visibilityOf(element));

            } else if (condition.toLowerCase().equals("clickable")) {
                driverWait.until(ExpectedConditions.elementToBeClickable(element));
            } 

        } catch (NoSuchElementException e) {

            throw new NoSuchElementException("The web element : " + element.toString() + " not found.");

        } catch (UnsupportedCommandException e) {

            throw new NoSuchElementException(
                    "The condition : " + condition + " given to check the element : " + element.toString() + " is invalid.");
        }

    }





    /**
     * Explicitly wait for the given intTimeoutInSeconds until the given condition satisfies on the element with the given locator.
     *
     * @param element
     * @param condition
     * @param intTimeoutInSeconds
     */
	protected void addExplicitWait(By locator, String condition, int timeoutInSeconds) {

        WebDriverWait driverWait = new WebDriverWait(driver, timeoutInSeconds, 250L);
        try {

            if (condition.toLowerCase().equals("visible")) {
                driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));

            } else if (condition.toLowerCase().equals("clickable")) {
                driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));

            } else if (condition.toLowerCase().equals("presence")) {
                driverWait.until(ExpectedConditions.presenceOfElementLocated(locator));

            } else if(condition.toLowerCase().equals("invisible")){
                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            } else if(condition.toLowerCase().equals("texttobepresent")){
                   driverWait.until(ExpectedConditions.textMatches(locator, Pattern.compile("[.]+",Pattern.DOTALL)));
            }

        } catch (NoSuchElementException e) {

            throw new NoSuchElementException(
                    "The element with" + locator.toString().replace("By.", " ") + " not found");
        } catch (UnsupportedCommandException e) {

            throw new NoSuchElementException("The condition given to check the elemnt with"
                    + locator.toString().replace("By.", " ") + " is invalid");
        }
    }






    /**
     * Selects the visibleText from the drop down webElement.
     *
     * @param webElement
     * @param visibleText
     */
	protected void selectDropDownByVisibleText(WebElement webElement, String visibleText) {

        delay(100);

        try {
            Select dropDown = new Select(webElement);
            dropDown.selectByVisibleText(visibleText);
            dropDown.selectByVisibleText(visibleText);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Not able to select text : " + visibleText + " from the dropdown.");
        }
    }





    










    /**
     * Returns the BY.locator for the given locator string and BY_TYPE.
     *
     * @param locator
     * @param type
     * @return
     */
	protected By getLocator(String locator, BY_TYPE type) {

        delay(100);

        switch (type) {

	        case XPATH:
	            return By.xpath(locator);

	        case LINKTEXT:
	            return By.linkText(locator);

	        case ID:
	            return By.id(locator);

	        case CSSSELECTOR:
	            return By.cssSelector(locator);

	        case CLASSNAME:
	            return By.className(locator);

	        case NAME:
	            return By.name(locator);

	        case PARTIALLINKTEXT:
	            return By.partialLinkText(locator);

	        case TAGNAME:
	            return By.tagName(locator);
        }

        throw new IllegalArgumentException("Invalid By Type, Please provide correct locator type");
    }





    /**
     * Returns the text value of the web element for the given BY locator.
     *
     * @param locator
     * @return
     */
	protected String getText(By locator) {

        delay(100);

        String text = null;

        try {
            text = driver.findElement(locator).getText();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(
                    "Unable to get the text. The element with" + locator.toString().replace("By.", " ") + " not found");
        }

        return text;
    }








    /**
     * Returns the text value of the given web element.
     *
     * @param locator
     * @return
     */
	protected String getText(WebElement element) {

        delay(100);

        String text = null;

        try {
            text = element.getText();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(
                    "Unable to get the text. The element " + element.toString() + " not found");
        }

        return text;
    }


	

	/**
	 * Gets the value set for the attribute for the webelemet with the locator.
	 * 
	 * @param locator
	 * @param attribute
	 * @return
	 */
	public String getAttribute(By locator, String attribute) {
        String attributeValue;
        try {
            attributeValue = driver.findElement(locator).getAttribute(attribute);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("The element with" + locator.toString() + " not found");
        }

        return attributeValue;
    }







    /**
     * Gets the value set for the attribute for the webelemet element.
     * 
     * @param element
     * @param attribute
     * @return
     */
    public String getAttribute(WebElement element, String attribute) {
        String attributeValue;
        try {
            attributeValue = element.getAttribute(attribute);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("The element " + element.toString() + " not found");
        }

        return attributeValue;
    }




	/**
	 * Closes current browser window.
	 */
	protected void closeCurrentBrowser(){
    	driver.close();
    }
    
    
	/**
	 * Closes all the windows opened by the driver and the driver object is quit.
	 */
	protected void quitDriver(){
    	driver.quit();
    }
	
	
	/**
	 * This method returns the webelement for the given locator.
	 * 
	 * @param locator
	 * @return
	 */
	protected WebElement getWebElement(By locator){
		
		return driver.findElement(locator);
		
	}

}
