package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.BY_TYPE;
import utils.PAYMENT_TYPE;
import utils.UA_TYPE;
import wrappers.GenericWrapper;

/**
 * Page class for the page : YourPreferences_Page
 * All the user actions to be performed on this page is created as reusable methods which will act on a repository of objects on this page. 
 *  
 * @author Thiru
 */
public class YourPreferences_Page extends GenericWrapper {
	
	private String pageHeader = "Your Preferences";
	private String paymentTypePreferenceOptionGenericXPath = ".//span[@class='icon #CAPTION#']";
	
	@CacheLookup
	@FindBy(how = How.CSS, using = "span[class='icon fixed-rate-1']")
    private WebElement fixedTariffIcon;
	
	@CacheLookup
	@FindBy(how = How.CSS, using = "span[class='icon variable-bill-1']")
    private WebElement variableTariffIcon;
	
	@CacheLookup
	@FindBy(how = How.CSS, using = "span[class='icon tariff-all']")
    private WebElement allTariffsIcon;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = ".//input[@id='Email']")
    private WebElement emailTextBox;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = ".//label[@for='marketingPreference']/span[2]")
    private WebElement marketingPreferenceCheckBox;
	
	@FindBy(how = How.XPATH, using = ".//label[@for='marketingPreference']")
    private WebElement marketingPreferenceStatus;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = ".//label[@for='terms']/span[2]")
    private WebElement agreeTermsAndConditionsCheckBox;
	
	@FindBy(how = How.XPATH, using = ".//label[@for='terms']")
    private WebElement agreeTermsAndConditionsStatus;
	
	@FindBy(how = How.ID, using = "email-submit")
    private WebElement goToPricesButton;
	
	
	
	/**
	 * Constructor which will initialize page factory with the driver and performs basic validation of the page.
	 * Incase if the validation is failed, it will throw exception.
	 */
	public YourPreferences_Page(){
        
		PageFactory.initElements(driver, this);
		
        if(!softTextCheck(pageHeader)){
        	 throw new RuntimeException("The expected page header : " + pageHeader + " not found on the current page.");
        } 
    }
	
	
	
	/**
	 * This method sets the give tariffPreference for the results.
	 * 
	 * @param tariffPreference
	 * @return
	 */
	public YourPreferences_Page setTariffPreferece(String tariffPreference){
		
		if(tariffPreference.toLowerCase().contains("fixed")){
			simpleUserAction(fixedTariffIcon, UA_TYPE.CLICK, null);
		} else if(tariffPreference.toLowerCase().contains("variable")){
			simpleUserAction(variableTariffIcon, UA_TYPE.CLICK, null);
		} else if(tariffPreference.toLowerCase().contains("all")){
			simpleUserAction(allTariffsIcon, UA_TYPE.CLICK, null);
		}
		
		return this;
	}
	
	
	
	
	
	
	/**
	 * This method sets the given paymentPreference for the results.
	 * 
	 * @param paymentType
	 * @return
	 */
	public YourPreferences_Page setPaymentPreference(PAYMENT_TYPE paymentType){
		
		switch(paymentType){
		
		case MONTHLY_DIRECT_DEBIT:
			simpleUserAction(getLocator(paymentTypePreferenceOptionGenericXPath.replaceAll("#CAPTION#", "annual-1"), BY_TYPE.XPATH), UA_TYPE.CLICK, null);
			break;
			
		case QUATERLY_DIRECT_DEBIT:
			simpleUserAction(getLocator(paymentTypePreferenceOptionGenericXPath.replaceAll("#CAPTION#", "quarterly-1"), BY_TYPE.XPATH), UA_TYPE.CLICK, null);
			break;
			
		case PAY_ON_RECEIPT_OF_BILL:
			simpleUserAction(getLocator(paymentTypePreferenceOptionGenericXPath.replaceAll("#CAPTION#", "bill-1"), BY_TYPE.XPATH), UA_TYPE.CLICK, null);
			break;
			
		case ALL_PAYMENT_TYPES:
			simpleUserAction(getLocator(paymentTypePreferenceOptionGenericXPath.replaceAll("#CAPTION#", "payment-all"), BY_TYPE.XPATH), UA_TYPE.CLICK, null);
			break;
			
		default:
			break;
		}
	
		return this;
	}
	
	
	/**
	 * This method sets the given emailId in the email id text box.
	 * 
	 * @param emailId
	 * @return
	 */
	public YourPreferences_Page setEmailAddress(String emailId){
		simpleUserAction(emailTextBox, UA_TYPE.CLICK_AND_TYPE, emailId);
		return this;
	}
	
	
	
	
	/**
	 * This method agrees for the 'marketing related information can be sent via email' option by clicking the checkbox.
	 * 
	 * @param option
	 * @return
	 */
	public YourPreferences_Page agreeMarketingInformationViaEmail(boolean option){
		
		boolean currentStatus = getAttribute(marketingPreferenceStatus, "class").contains("checked") ? true:false;
		
		if(option){
			if(!currentStatus){
				simpleUserAction(marketingPreferenceCheckBox, UA_TYPE.CLICK, null);
			}
		}else{
			if(currentStatus){
				simpleUserAction(marketingPreferenceCheckBox, UA_TYPE.CLICK, null);
			}
		}
		
		
		return this;
	}
	
	
	/**
	 * This method agrees the terms and conditions by clicking the check box.
	 * 
	 * @param option
	 * @return
	 */
	public YourPreferences_Page agreeTermsAndConditions(boolean option){
		
		boolean currentStatus = getAttribute(agreeTermsAndConditionsStatus, "class").contains("checked") ? true:false;
		
		if(option){
			if(!currentStatus){
				simpleUserAction(agreeTermsAndConditionsCheckBox, UA_TYPE.CLICK, null);
			}
		}else{
			if(currentStatus){
				simpleUserAction(agreeTermsAndConditionsCheckBox, UA_TYPE.CLICK, null);
			}
		}
		
		return this;
	}
	
	
	/**
	 * This method clicks on the button 'GoToPrices'
	 * 
	 * @return
	 */
	public YourResults_Page clickGoToPrices(){
		
		simpleUserAction(goToPricesButton, UA_TYPE.CLICK, null);
		return new YourResults_Page();
	}

}
