package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.BY_TYPE;
import utils.ENERGY_TYPE;
import utils.POPULAR_ENERGY_SUPPLIER;
import utils.UA_TYPE;
import wrappers.GenericWrapper;


/**
 * Page class for the page : YourSupplier_Page
 * All the user actions to be performed on this page is created as reusable methods which will act on a repository of objects on this page. 
 *  
 * @author Thiru
 */
public class YourSupplier_Page extends GenericWrapper {
	
	private String pageHeader = "Your Supplier";
	private String findPostcodeButtonID = "find-postcode";
	private String electricitySupplierIconGenericXPath = ".//span[contains(text(),'Who supplies your electricity?')]/..//span[@class=' icon top-6-#CAPTION#']";
	private String gasSupplierIconGenericXPath = ".//span[contains(text(),'Who supplies your gas?')]/..//span[@class='icon top-6-#CAPTION#']";
	private String haveBillOptionGenericCSSPath = "span[class='icon have-bill-#CAPTION#']";
	private String isSupplierSameOptionGenericXPath = ".//input[@id='same-supplier-#CAPTION#']/following-sibling::span[1]";
	private String sameSupplierQuestionText = "Is your gas & electricity from the same supplier?";
	
	@CacheLookup
	@FindBy(how = How.ID, using = "your-postcode")
    private WebElement postcodeTextBox;
	
	@CacheLookup
	@FindBy(how = How.ID, using = "find-postcode")
    private WebElement findPostcodeButton;
	
	@CacheLookup
	@FindBy(how = How.CSS, using = "span[class='icon energy-gas-electricity']")
    private WebElement gasAndElectricityIcon;
	
	@CacheLookup
	@FindBy(how = How.CSS, using = "span[class='icon energy-electricity']")
    private WebElement electricityOnlyIcon;
	
	@CacheLookup
	@FindBy(how = How.CSS, using = "span[class='icon energy-gas']")
    private WebElement gasOnlyIcon;
	
	@FindBy(how = How.ID, using = "goto-your-supplier-details")
    private WebElement nextButton;
	
	
    /**
     * Constructor which will initialize page factory with the driver and performs basic validation of the page.
	 * Incase if the validation is failed, it will throw exception.
     */
    public YourSupplier_Page(){
    	
        PageFactory.initElements(driver, this);
         
        if(!softTextCheck(pageHeader)){
        	throw new RuntimeException("The expected page header : " + pageHeader + " not found on the current page.");
        }
   }
    
    
    /**
     * This method enters the given postcode in the postcode textbox and click findPostcode button.
     * 
     * @param postcode
     * @return
     */
    public YourSupplier_Page findPostcode(String postcode){
  	
    	simpleUserAction(postcodeTextBox, UA_TYPE.CLICK_AND_TYPE, postcode);
    	simpleUserAction(findPostcodeButton, UA_TYPE.CLICK, null,() -> addExplicitWait(getLocator(findPostcodeButtonID, BY_TYPE.ID), "invisible", 60));
    	return this;
    }
    
    
    
    /**
     * This method selects yes/no for 'have bill?' question based on the boolean input passed.
     * 
     * @param option
     * @return
     */
    public YourSupplier_Page haveBill(boolean option){
    	
    	if(option){
    		simpleUserAction(getLocator(haveBillOptionGenericCSSPath.replaceAll("#CAPTION#", "yes"), BY_TYPE.CSSSELECTOR), UA_TYPE.CLICK, null);
    	} else{
    		simpleUserAction(getLocator(haveBillOptionGenericCSSPath.replaceAll("#CAPTION#", "no"), BY_TYPE.CSSSELECTOR), UA_TYPE.CLICK, null);
    	}
    	
    	return this;
    }
    
    
    /**
     * This method sets the given energyType to compare.
     * 
     * @param energyType
     * @return
     */
    public YourSupplier_Page setEnergyTypeToCompare(ENERGY_TYPE energyType){
    	
    	switch(energyType){
    	
    	case GAS:
    		simpleUserAction(gasOnlyIcon, UA_TYPE.CLICK, null);
    		break;
    		
    	case ELECTRICITY:
    		simpleUserAction(electricityOnlyIcon, UA_TYPE.CLICK, null);
    		break;
    	
    	case BOTH:
    		simpleUserAction(gasAndElectricityIcon, UA_TYPE.CLICK, null);
    		break;
    	}
    	
    	return this;
    }
    
    
    
    /**
     * This method selects yes/no for 'is supplier same for gas and electricity?' question based on the boolean input passed.
     *  
     * @param option
     * @return
     */
    public YourSupplier_Page isSupplierSame(boolean option){
    	
    	if(option){
    		simpleUserAction(getLocator(isSupplierSameOptionGenericXPath.replaceAll("#CAPTION#", "yes"), BY_TYPE.XPATH), UA_TYPE.CLICK, null);
    	} else{
    		simpleUserAction(getLocator(isSupplierSameOptionGenericXPath.replaceAll("#CAPTION#", "no"), BY_TYPE.XPATH), UA_TYPE.CLICK, null);
    	}
    	
    	return this;
     }
    
    
    /**
     * This method sets the given energySupplier as electricity supplier.
     * 
     * @param energySupplier
     * @return
     */
    public YourSupplier_Page setElectricitySupplier(POPULAR_ENERGY_SUPPLIER energySupplier){
      	
    	simpleUserAction(getLocator(electricitySupplierIconGenericXPath.replaceAll("#CAPTION#", energySupplier.getUIIconText()), BY_TYPE.XPATH), UA_TYPE.CLICK, null);
    	return this;
   }
    
    
    /**
     * This method sets the given energySupplier as gas supplier.
     * 
     * @param energySupplier
     * @return
     */
    public YourSupplier_Page setGasSupplier(POPULAR_ENERGY_SUPPLIER energySupplier){
      	
    	simpleUserAction(getLocator(gasSupplierIconGenericXPath.replaceAll("#CAPTION#", energySupplier.getUIIconText()), BY_TYPE.XPATH), UA_TYPE.CLICK, null);
    	return this;
   }
    
    
    /**
     * This method clicks Next button on this page.
     * 
     * @return
     */
    public YourEnergyElectricity_Page clickNext(){
    	
    	simpleUserAction(nextButton, UA_TYPE.CLICK, null);
    	return new YourEnergyElectricity_Page();
    }
    
    
    /**
     * This method validates if the same supplier question exist in the page.
     * If not found, it will throw exception.
     * 
     * @return
     */
    public YourSupplier_Page validateSameSupplierQuestion(){
    	
    	if(!softTextCheck(sameSupplierQuestionText)){
    		throw new RuntimeException("Validation Failed. The question : "+sameSupplierQuestionText+" not found on the current page.");
    	}
    	return this;
    }
}
