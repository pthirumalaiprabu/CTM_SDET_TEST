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
 * Page class for the page : YourEnergyElectricity
 * All the user actions to be performed on this page is created as reusable methods which will act on a repository of objects on this page. 
 * 
 * @author Thiru
 *
 */
public class YourEnergyElectricity_Page extends GenericWrapper {
	
	private String pageHeader1 = "Your Energy";
	private String pageHeader2 = "Electricity";
	private String haveEconomy7MeterOptionGenericXPath = ".//input[@id='economy-7-#CAPTION#']/following-sibling::span[1]";
	private String isElectricityMainSourceOptionGenericXPath = ".//input[@id='electricity-main-heating-#CAPTION#']/following-sibling::span[1]";
	
	@CacheLookup
	@FindBy(how = How.ID, using = "electricity-tariff-additional-info")
    private WebElement electricityPlanDropDown;
	
	@CacheLookup
	@FindBy(how = How.ID, using = "electricity-payment-method-dropdown-link")
    private WebElement electricityPaymentTypeDropDown;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = ".//input[@id='kwhSpend']/following-sibling::span[1]")
    private WebElement kWhUnitIcon;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = ".//input[@id='poundSpend']/following-sibling::span[1]")
    private WebElement poundUnitIcon;
	
	@FindBy(how = How.ID, using = "electricity-usage")
    private WebElement generalElectriciyUsageTextBox;
	
	@FindBy(how = How.ID, using = "electricity-spend")
    private WebElement generalElectriciySpendTextBox;
	
	@FindBy(how = How.ID, using = "economy-7-day-usage")
    private WebElement economy7DayUsageTextBox;
	
	@FindBy(how = How.ID, using = "economy-7-night-usage")
    private WebElement economy7NightUsageTextBox;
	    
    @FindBy(how = How.ID, using = "electricity-usage-dropdown")
    private WebElement generalElectriciyUsageCycleDropDown;
    
    @FindBy(how = How.ID, using = "electricity-spend-dropdown")
    private WebElement generalElectriciySpendCycleDropDown;
    
    @FindBy(how = How.ID, using = "economy-7-day-usage-dropdown")
    private WebElement economy7DayUsageCycleDropDown;
    
    @FindBy(how = How.ID, using = "goto-your-energy")
    private WebElement nextButton;
	

	
	/**
	 * Constructor which will initialize page factory with the driver and performs basic validation of the page.
	 * Incase if the validation is failed, it will throw exception.
	 */
	public YourEnergyElectricity_Page(){
        
		PageFactory.initElements(driver, this);
		
        if(!(softTextCheck(pageHeader1) && softTextCheck(pageHeader2))){
        	throw new RuntimeException("The expected page header : " + pageHeader1 + " or " + pageHeader2 + " not found on the current page.");
        } 
    }
	
	
	/**
	 * This method selects the electricity plan from the dropdown.
	 * 
	 * @param electricityPlan
	 * @return
	 */
	public YourEnergyElectricity_Page selectElectricityPlan(String electricityPlan){
		
		simpleUserAction(electricityPlanDropDown, UA_TYPE.SELECT_DROPDOWN_OPTION, electricityPlan);
		return this;
	}
	
	
	/**
	 * This method selects yes/no for 'have economy 7 meter?' question based on the boolean input passed.
	 * 
	 * @param option
	 * @return
	 */
	public YourEnergyElectricity_Page haveEconomy7Meter(boolean option){
		
		if(option){
			simpleUserAction(getLocator(haveEconomy7MeterOptionGenericXPath.replaceAll("#CAPTION#", "yes"), BY_TYPE.XPATH), UA_TYPE.CLICK, null);
    	} else{
    		simpleUserAction(getLocator(haveEconomy7MeterOptionGenericXPath.replaceAll("#CAPTION#", "no"), BY_TYPE.XPATH), UA_TYPE.CLICK, null);
    	}
    	
    	return this;
	}
	
	
	
	/**
	 * This method selects the given electricity payment type from the drop down.
	 * 
	 * @param paymentType
	 * @return
	 */
	public YourEnergyElectricity_Page selectElectricityPaymentType(PAYMENT_TYPE paymentType){
		
		simpleUserAction(electricityPaymentTypeDropDown, UA_TYPE.SELECT_DROPDOWN_OPTION, paymentType.getVisibleText());
		return this;
	}
	
	
	/**
	 * This method selects yes/no for 'is electriciy main source of heating?' question based on the boolean input passed.
	 * 
	 * @param option
	 * @return
	 */
	public YourEnergyElectricity_Page isElectricityMainSource(boolean option){
		
		if(option){
			simpleUserAction(getLocator(isElectricityMainSourceOptionGenericXPath.replaceAll("#CAPTION#", "yes"), BY_TYPE.XPATH), UA_TYPE.CLICK, null);
    	} else{
    		simpleUserAction(getLocator(isElectricityMainSourceOptionGenericXPath.replaceAll("#CAPTION#", "no"), BY_TYPE.XPATH), UA_TYPE.CLICK, null);
    	}
		return this;
	}
	
	
	
	/**
	 * This method sets given energyUsageUnit as electriciy usage unit.
	 * 
	 * @param energyUsageUnit
	 * @return
	 */
	public YourEnergyElectricity_Page setElectricityUsageUnit(ENERGY_USAGE_UNIT energyUsageUnit){
		
		if(energyUsageUnit == ENERGY_USAGE_UNIT.kWH){
			simpleUserAction(kWhUnitIcon, UA_TYPE.CLICK, null);
		} else{
			simpleUserAction(poundUnitIcon, UA_TYPE.CLICK, null);
		}
		
		return this;
	}
	
	
	
	/**
	 * This method sets the general electricity usage(not economy7)
	 * This will select the given energyUsageUnit, types the given usage and selects the given usageCycle
	 * 
	 * @param energyUsageUnit
	 * @param usage
	 * @param usageCycle
	 * @return
	 */
	public YourEnergyElectricity_Page setGeneralElectricityUsage(ENERGY_USAGE_UNIT energyUsageUnit, String usage, USAGE_CYCLE usageCycle){
		
		if(energyUsageUnit == ENERGY_USAGE_UNIT.kWH){
			simpleUserAction(kWhUnitIcon, UA_TYPE.CLICK, null);
		} else{
			simpleUserAction(poundUnitIcon, UA_TYPE.CLICK, null);
		}
		
		if(energyUsageUnit == ENERGY_USAGE_UNIT.kWH){
			simpleUserAction(generalElectriciyUsageTextBox, UA_TYPE.CLICK_AND_TYPE, usage);
			simpleUserAction(generalElectriciyUsageCycleDropDown, UA_TYPE.SELECT_DROPDOWN_OPTION, usageCycle.getVisibleText());
		} else{
			simpleUserAction(generalElectriciySpendTextBox, UA_TYPE.CLICK_AND_TYPE, usage);
			simpleUserAction(generalElectriciySpendCycleDropDown, UA_TYPE.SELECT_DROPDOWN_OPTION, usageCycle.getVisibleText());
		}
	
		return this;
	}
	
	
	/**
	 * This method validates the given text on this page.
	 * If not found, it throws exception.
	 * 
	 * @param text
	 * @return
	 */
	public YourEnergyElectricity_Page validateText(String text){
    	
    	hardTextCheck(text);
    	return this;
    }
	
	
	
	
	/**
	 * This method clicks next button on this page.
	 * 
	 * @return
	 */
	public YourEnergyGas_Page clickNext(){
    	
    	simpleUserAction(nextButton, UA_TYPE.CLICK, null);
    	return new YourEnergyGas_Page();
    }
	
	
	
	/**
	 * This method validates if economy7 related text boxes(day & night) are displayed on this page. 
	 * If not, it will throw exception.
	 * 
	 * @return
	 */
	public YourEnergyElectricity_Page validateEconomy7RelatedFields(){
		
		if(!(economy7DayUsageTextBox.isDisplayed() && economy7NightUsageTextBox.isDisplayed())){
			throw new RuntimeException("Validation Failed. Economy7 related field(s) is/are missing");
		}
		
		return this;
	}
	
	
	
	/**
	 * This method will set the electriciy usage for economy7 related fields.
	 * It will select the given energyUsageUnit
	 * It will set the dayUsage and select dayUsageCycle
	 * It will set the nightUsage.
	 * If any of the day or night usage is null or empty, it will not set it.
	 * If the energyUsageUnit is pounds, then it will call setGeneralElectricityUsage(energyUsageUnit, dayUsage, dayUsageCycle)
	 * 
	 * @param energyUsageUnit
	 * @param dayUsage
	 * @param dayUsageCycle
	 * @param nightUsage
	 * @return
	 */
	public YourEnergyElectricity_Page setEconomy7ElectricityUsage(ENERGY_USAGE_UNIT energyUsageUnit, String dayUsage, USAGE_CYCLE dayUsageCycle, String nightUsage){
		
		if(energyUsageUnit == ENERGY_USAGE_UNIT.kWH){
			simpleUserAction(kWhUnitIcon, UA_TYPE.CLICK, null);
		} else{
			simpleUserAction(poundUnitIcon, UA_TYPE.CLICK, null);
		}
		
		if(energyUsageUnit == ENERGY_USAGE_UNIT.kWH){

			simpleUserAction(economy7DayUsageCycleDropDown, UA_TYPE.SELECT_DROPDOWN_OPTION, dayUsageCycle.getVisibleText());
			
			if(!(dayUsage == null || dayUsage.equals(""))){
				simpleUserAction(economy7DayUsageTextBox, UA_TYPE.CLICK_AND_TYPE, dayUsage);
			}
			
			if(!(nightUsage == null || nightUsage.equals(""))){
				simpleUserAction(economy7NightUsageTextBox, UA_TYPE.CLICK_AND_TYPE, nightUsage);
			}
			
		} else{
			setGeneralElectricityUsage(energyUsageUnit, dayUsage, dayUsageCycle);
		}
	
		return this;
	}
	

}
