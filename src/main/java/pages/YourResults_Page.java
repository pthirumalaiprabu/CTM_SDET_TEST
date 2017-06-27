package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.BY_TYPE;
import utils.PAYMENT_TYPE;
import utils.TARIFF_TYPE;
import wrappers.GenericWrapper;

/**
 * Page class for the page : YourResults_Page
 * All the user actions to be performed on this page is created as reusable methods which will act on a repository of objects on this page. 
 * 
 * @author Thiru
 */
public class YourResults_Page extends GenericWrapper {
	
	
	private String pageHeader = "Your Results";
	private String searchingForYourPricesOverlayID = "interstitial-overlay";
	
	@FindBy(how = How.XPATH, using = ".//label[@for='filter-payment-type']")
    private WebElement allPaymentTypeFilter;
	
	@FindBy(how = How.XPATH, using = ".//label[@for='filter-monthly-payment-type']")
    private WebElement monthlyDirectDebitPaymentTypeFilter;
	
	@FindBy(how = How.XPATH, using = ".//label[@for='filter-quarterly-payment-type']")
    private WebElement quarterlyDirectDebitPaymentTypeFilter;
	
	@FindBy(how = How.XPATH, using = ".//label[@for='filter-por-payment-type']")
    private WebElement payOnReceiptPaymentTypeFilter;
	
	@FindBy(how = How.XPATH, using = ".//label[@for='filter-all-tariff']")
    private WebElement allTariffTypeFilter;
	
	@FindBy(how = How.XPATH, using = ".//label[@for='filter-fixed-tariff']")
    private WebElement fixedTariffTypeFilter;
	
	@FindBy(how = How.XPATH, using = ".//label[@for='filter-variable-tariff']")
    private WebElement variableTariffTypeFilter;
	
	
	/**
	 * Constructor which will initialize page factory with the driver and performs basic validation of the page.
	 * Incase if the validation is failed, it will throw exception.
	 */
	public YourResults_Page(){
        
		PageFactory.initElements(driver, this);
		
		addExplicitWait(getLocator(searchingForYourPricesOverlayID, BY_TYPE.ID), "invisible", 120);
		
        if(!softTextCheck(pageHeader)){
        	 throw new RuntimeException("The expected page header : " + pageHeader + " not found on the current page.");
        } 
    }
	
	
	/**
	 * This method validates whether the results in the current page contains all the payment types.
	 * This derives the number of results from the filters and if each type of the payment has more than one result, then it will return true.
	 * Else, it will fail.
	 * 
	 * @return
	 */
	public YourResults_Page validateAllPaymentTypes(){
		
		String allPaymentTypes =  getText(allPaymentTypeFilter);
		int allPaymentTypesCount = Integer.parseInt(allPaymentTypes.substring(allPaymentTypes.indexOf('(')+1, allPaymentTypes.lastIndexOf(')')));
				
		String monthlyDirectDebits =  getText(monthlyDirectDebitPaymentTypeFilter);
		int monthlyDirectDebitsCount = Integer.parseInt(monthlyDirectDebits.substring(monthlyDirectDebits.indexOf('(')+1, monthlyDirectDebits.lastIndexOf(')')));
				
		String quarterlyDirectDebits =  getText(quarterlyDirectDebitPaymentTypeFilter);
		int quarterlyDirectDebitsCount = Integer.parseInt(quarterlyDirectDebits.substring(quarterlyDirectDebits.indexOf('(')+1, quarterlyDirectDebits.lastIndexOf(')')));
				
		String payOnReceipts =  getText(payOnReceiptPaymentTypeFilter);
		int payOnReceiptsCount = Integer.parseInt(payOnReceipts.substring(payOnReceipts.indexOf('(')+1, payOnReceipts.lastIndexOf(')')));
				
		if(!(allPaymentTypesCount>0 && monthlyDirectDebitsCount>0 && quarterlyDirectDebitsCount>0 && payOnReceiptsCount>0)){
			throw new RuntimeException("All payment types are not found in the results");
		}
		
		return this;
	}
	
	
	/**
	 * This method validates whether the results in the current page contains all the tariff types.
	 * This derives the number of results from the filters and if each type of the tariff has more than one result, then it will return true.
	 * Else, it will fail.
	 * 
	 * @return
	 */
	public YourResults_Page validateAllTariffTypes(){
		
		String allTariffTypes =  getText(allTariffTypeFilter);
		int allTariffTypesCount = Integer.parseInt(allTariffTypes.substring(allTariffTypes.indexOf('(')+1, allTariffTypes.lastIndexOf(')')));
				
		String fixedTariffTypes =  getText(fixedTariffTypeFilter);
		int fixedTariffTypesCount = Integer.parseInt(fixedTariffTypes.substring(fixedTariffTypes.indexOf('(')+1, fixedTariffTypes.lastIndexOf(')')));
				
		String variableTariffTypes =  getText(variableTariffTypeFilter);
		int variableTariffTypesCount = Integer.parseInt(variableTariffTypes.substring(variableTariffTypes.indexOf('(')+1, variableTariffTypes.lastIndexOf(')')));
				
						
		if(!(allTariffTypesCount>0 && fixedTariffTypesCount>0 && variableTariffTypesCount>0)){
			throw new RuntimeException("All tariff types are not found in the results");
		}
		
		return this;
	}
	
	
	/**
	 * This method checks if the given payment type is already checked in the filters on the left side of the screen.
	 * if not checked, it will fail by throwing a runtime exception.
	 * 
	 * @param paymentType
	 * @return
	 */
	public YourResults_Page isPaymentTypeFilterCheckedFor(PAYMENT_TYPE paymentType){
		
		if(paymentType == PAYMENT_TYPE.ALL_PAYMENT_TYPES){
			
			if(!getAttribute(allPaymentTypeFilter, "class").contains("checked")){
				
				throw new RuntimeException("All Payment types filter is not checked on the left side filter.");
				
			}
			
		} else if (paymentType == PAYMENT_TYPE.MONTHLY_DIRECT_DEBIT){
			
			if(!getAttribute(monthlyDirectDebitPaymentTypeFilter, "class").contains("checked")){
				
				throw new RuntimeException("Monthly direct debit filter is not checked on the left side filter.");
				
			}
			
		} else if (paymentType == PAYMENT_TYPE.QUATERLY_DIRECT_DEBIT){
			
			if(!getAttribute(quarterlyDirectDebitPaymentTypeFilter, "class").contains("checked")){
				
				throw new RuntimeException("Quarterly direct debit filter is not checked on the left side filter.");
				
			}
			
		} else if (paymentType == PAYMENT_TYPE.PAY_ON_RECEIPT_OF_BILL){
			
			if(!getAttribute(payOnReceiptPaymentTypeFilter, "class").contains("checked")){
				
				throw new RuntimeException("Pay on reciept of bill filter is not checked on the left side filter.");
				
			}
			
		} else {
			
			throw new RuntimeException("The provided payment type does not match for this function.");
		}
		
		return this;
	}
	
	
	
	/**
	 * This method checks if the given tariff type is already checked in the filters on the left side of the screen.
	 * if not checked, it will fail by throwing a runtime exception.
	 * 
	 * @param tariffType
	 * @return
	 */
	public YourResults_Page isTariffTypeFilterCheckedFor(TARIFF_TYPE tariffType){
		
		if(tariffType == TARIFF_TYPE.ALL){
			
			if(!getAttribute(allTariffTypeFilter, "class").contains("checked")){
				
				throw new RuntimeException("All Tariff types filter is not checked on the left side filter.");
				
			}
			
		} else if (tariffType == TARIFF_TYPE.FIXED){
			
			if(!getAttribute(fixedTariffTypeFilter, "class").contains("checked")){
				
				throw new RuntimeException("Fixed tariff type filter is not checked on the left side filter.");
				
			}
			
		} else if (tariffType == TARIFF_TYPE.VARIABLE){
			
			if(!getAttribute(variableTariffTypeFilter, "class").contains("checked")){
				
				throw new RuntimeException("Variable tariff type filter is not checked on the left side filter.");
				
			}
			
		} else {
			
			throw new RuntimeException("The provided tariff type does not match for this function.");
		}
		
		
		return this;
	}

}
