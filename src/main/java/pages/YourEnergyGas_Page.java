package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.BY_TYPE;
import utils.ENERGY_USAGE_UNIT;
import utils.PAYMENT_TYPE;
import utils.UA_TYPE;
import utils.USAGE_CYCLE;
import wrappers.GenericWrapper;

/**
 * Page class for the page : YourEnergyGas_Page
 * All the user actions to be performed on this page is created as reusable methods which will act on a repository of objects on this page. 
 * 
 * @author Thiru
 */
public class YourEnergyGas_Page extends GenericWrapper {
	
	private String pageHeader1 = "Your Energy";
	private String isGasMainSourceOptionGenericXPath = ".//input[@id='gas-main-heating-#CAPTION#']/following-sibling::span[1]";
	
	@CacheLookup
	@FindBy(how = How.ID, using = "gas-tariff-additional-info")
    private WebElement gasTariffDropDown;
	
	@FindBy(how = How.ID, using = "gas-payment-method-dropdown-link")
    private WebElement gasPaymentTypeDropDown;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = ".//input[@id='kwhSpendG']/following-sibling::span[1]")
    private WebElement kWhUnitIcon;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = ".//input[@id='poundSpendG']/following-sibling::span[1]")
    private WebElement poundUnitIcon;
	
	@FindBy(how = How.ID, using = "gas-usage")
    private WebElement gasUsageTextBox;
	
	@FindBy(how = How.ID, using = "gas-spend")
    private WebElement gasSpendTextBox;
	    
    @FindBy(how = How.ID, using = "type-of-Gas-bill-usage-dropdown")
    private WebElement gasUsageCycleDropDown;
    
    @FindBy(how = How.ID, using = "type-of-Gas-bill-dropdown")
    private WebElement gasSpendCycleDropDown;
    
    @FindBy(how = How.ID, using = "goto-your-energy")
    private WebElement nextButton;
    
    @FindBy(how = How.ID, using = "gas-bill-day")
    private WebElement gasBillDateField;
    
    @FindBy(how = How.XPATH, using = ".//table[@id='gas-bill-day_table']/following-sibling::div[1]//button[@class='picker__button--today']")
    private WebElement gasBillDateToday;
    
    @FindBy(how = How.ID, using = "gas-current-spend")
    private WebElement gasCurrentSpendTextBox;
    
    @FindBy(how = How.ID, using = "gas-current-spend-period")
    private WebElement gasCurrentSpendCycyleDropDown;
	
	
	/**
	 * Constructor which will initialize page factory with the driver and performs basic validation of the page.
	 * Incase if the validation is failed, it will throw exception.
	 */
	public YourEnergyGas_Page(){
        
		PageFactory.initElements(driver, this);
		
		if(!(softTextCheck(pageHeader1))){
	        throw new RuntimeException("The expected page header : " + pageHeader1 + " or the expected gasTariffDropdown not found on the current page.");
	    } 
    }
	
	
	
	/**
	 * Selects the provided gas tariff from the gas tariff drop down.
	 * 
	 * @param gasTariff
	 * @return
	 */
	public YourEnergyGas_Page selectGasTariff(String gasTariff){
		
		simpleUserAction(gasTariffDropDown, UA_TYPE.SELECT_DROPDOWN_OPTION, gasTariff);
		return this;
	}
	
	
	/**
	 * Selects the given paymentType from the gas payment drop down
	 * 
	 * @param paymentType
	 * @return
	 */
	public YourEnergyGas_Page selectPaymentType(PAYMENT_TYPE paymentType){
		
		simpleUserAction(gasPaymentTypeDropDown, UA_TYPE.SELECT_DROPDOWN_OPTION, paymentType.getVisibleText());
		return this;
	}
	
	
	/**
	 * This method selects yes/no for 'is Gas main source of heating?' question based on the boolean input passed.
	 * 
	 * @param option
	 * @return
	 */
	public YourEnergyGas_Page isGasMainSource(boolean option){
		
		if(option){
			simpleUserAction(getLocator(isGasMainSourceOptionGenericXPath.replaceAll("#CAPTION#", "yes"), BY_TYPE.XPATH), UA_TYPE.CLICK, null);
    	} else{
    		simpleUserAction(getLocator(isGasMainSourceOptionGenericXPath.replaceAll("#CAPTION#", "no"), BY_TYPE.XPATH), UA_TYPE.CLICK, null);
    	}
		return this;
	}
	
	/**
	 * This method sets the given energyUsageUnit as the usage unit for gas usage.
	 * 
	 * @param energyUsageUnit
	 * @return
	 */
	public YourEnergyGas_Page setGasUsageUnit(ENERGY_USAGE_UNIT energyUsageUnit){
		
		if(energyUsageUnit == ENERGY_USAGE_UNIT.kWH){
			simpleUserAction(kWhUnitIcon, UA_TYPE.CLICK, null);
		} else{
			simpleUserAction(poundUnitIcon, UA_TYPE.CLICK, null);
		}
		
		return this;
	}
	
	
	/**
	 * This method sets the gas usage
	 * This will select the given energyUsageUnit, types the given usage and selects the given usageCycle for gas.
	 * 
	 * @param energyUsageUnit
	 * @param usage
	 * @param usageCycle
	 * @return
	 */
	public YourEnergyGas_Page setCurrentGasUsage(ENERGY_USAGE_UNIT energyUsageUnit, String usage, USAGE_CYCLE usageCycle){
		
		
		if(energyUsageUnit == ENERGY_USAGE_UNIT.kWH){
			simpleUserAction(kWhUnitIcon, UA_TYPE.CLICK, null);
		} else if(energyUsageUnit == ENERGY_USAGE_UNIT.pound) {
			simpleUserAction(poundUnitIcon, UA_TYPE.CLICK, null);
		}
		
		if(energyUsageUnit == ENERGY_USAGE_UNIT.kWH){
			simpleUserAction(gasUsageTextBox, UA_TYPE.CLICK_AND_TYPE, usage);
			simpleUserAction(gasUsageCycleDropDown, UA_TYPE.SELECT_DROPDOWN_OPTION, usageCycle.getVisibleText());
		} else if(energyUsageUnit == ENERGY_USAGE_UNIT.pound) {
			simpleUserAction(gasSpendTextBox, UA_TYPE.CLICK_AND_TYPE, usage);
			simpleUserAction(gasSpendCycleDropDown, UA_TYPE.SELECT_DROPDOWN_OPTION, usageCycle.getVisibleText());
		}else{
			simpleUserAction(gasCurrentSpendTextBox, UA_TYPE.CLICK_AND_TYPE, usage);
			simpleUserAction(gasCurrentSpendCycyleDropDown, UA_TYPE.SELECT_DROPDOWN_OPTION, usageCycle.getVisibleText());
		}
	
		return this;
	}
	
	
	/**
	 * This method clicks next button on this page.
	 * 
	 * @return
	 */
	public YourPreferences_Page clickNext(){
    	
    	simpleUserAction(nextButton, UA_TYPE.CLICK, null);
    	return new YourPreferences_Page();
    }
	
	
	/**
	 * This method validates whether the billdate field is present on this page. It will internally check if it is displayed.
	 * If it is not present, it will throw exception.
	 * 
	 * @return
	 */
	public YourEnergyGas_Page validateGasBillDateField(){
		
		if(!gasBillDateField.isDisplayed()){
			throw new RuntimeException("Validation Failed. Bill Date related field is missing");
		}
		return this;
	}
	
	
	/**
	 * This method sets the date on the gas bill date field. Currently this will pick only today's date if the date passed is "today"
	 * 
	 * @param date
	 * @return
	 */
	public YourEnergyGas_Page setGasBillDate(String date){
		
		if(date.equalsIgnoreCase("today")){
			simpleUserAction(gasBillDateField, UA_TYPE.CLICK, null);
			simpleUserAction(gasBillDateToday, UA_TYPE.CLICK, null);
		}
		
		return this;
	}
	

}
