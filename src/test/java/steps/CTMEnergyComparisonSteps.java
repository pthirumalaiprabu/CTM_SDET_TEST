package steps;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java8.En;
import pages.YourEnergyElectricity_Page;
import pages.YourEnergyGas_Page;
import pages.YourPreferences_Page;
import pages.YourResults_Page;
import pages.YourSupplier_Page;
import utils.ENERGY_TYPE;
import utils.ENERGY_USAGE_UNIT;
import utils.PAYMENT_TYPE;
import utils.POPULAR_ENERGY_SUPPLIER;
import utils.TARIFF_TYPE;
import utils.USAGE_CYCLE;
import wrappers.GenericWrapper;

/**
 * Step definition class.
 * 
 * @author Thiru
 */
public class CTMEnergyComparisonSteps extends GenericWrapper implements En  {
	
	public CTMEnergyComparisonSteps(){
		
	
	Given("^I am a \"([^\"]*)\" customer \"([^\"]*)\" bill from postcode \"([^\"]*)\"$", (String energyType, String billAvaialability, String postcode) -> {
			
		new YourSupplier_Page()
		.findPostcode(postcode);
			
		if(billAvaialability.toLowerCase().contains("without")){
			new YourSupplier_Page()
			.haveBill(false);
		}else{
			new YourSupplier_Page()
			.haveBill(true);
		}
			
		if(energyType.toLowerCase().contains("gas") && energyType.toLowerCase().contains("electricity")){
			new YourSupplier_Page()
			.setEnergyTypeToCompare(ENERGY_TYPE.BOTH);
		}else if(energyType.toLowerCase().contains("gas")){
			new YourSupplier_Page()
			.setEnergyTypeToCompare(ENERGY_TYPE.GAS);
		}else if(energyType.toLowerCase().contains("electricity")){
			new YourSupplier_Page()
			.setEnergyTypeToCompare(ENERGY_TYPE.ELECTRICITY);
		}else{
			new YourSupplier_Page()
			.setEnergyTypeToCompare(ENERGY_TYPE.BOTH);
		}
	});
	
	

	
	Then("^I should be asked whether my suppliers are same$", () -> {
		
		new YourSupplier_Page()
		.validateSameSupplierQuestion();
		
	});
	
	
	
	When("^My Gas & Electricity suppliers are \"([^\"]*)\"$", (String supplierOption) -> {
		
		if(supplierOption.toLowerCase().contains("same")){
			new YourSupplier_Page()
			.isSupplierSame(true);	
		}else{
			new YourSupplier_Page()
			.isSupplierSame(false);
		}

	});

	
	
	When("^My Electricity supplier is \"([^\"]*)\"$", (String electricitySupplier) -> {
		
		for (POPULAR_ENERGY_SUPPLIER supplier : POPULAR_ENERGY_SUPPLIER.values()) {
			
			if(supplier.getUIIconText().toLowerCase().contains(electricitySupplier.toLowerCase())){
				new YourSupplier_Page()
				.setElectricitySupplier(supplier);
				
				break;
			}
		}
		
	});
	
	
	
	When("^My Gas supplier is \"([^\"]*)\"$", (String gasSupplier) -> {
		
		for (POPULAR_ENERGY_SUPPLIER supplier : POPULAR_ENERGY_SUPPLIER.values()) {
			
			if(supplier.getUIIconText().toLowerCase().contains(gasSupplier.toLowerCase())){
				new YourSupplier_Page()
				.setGasSupplier(supplier);
				
				break;
			}
		}
	});
	
	
	
	
	
	
	When("^I move to the next page and I \"([^\"]*)\" a economy7 meter and My current electricity usage is in \"([^\"]*)\"$", (String economy7Availability, String electricityUsage) -> {
		
		economy7Availability = economy7Availability.toLowerCase();
		electricityUsage = electricityUsage.toLowerCase();
		
		new YourSupplier_Page()
		.clickNext()
		.selectElectricityPlan("Fixed Price July 2018");
		
		
		if(economy7Availability.contains("do not")){
			new YourEnergyElectricity_Page()
			.haveEconomy7Meter(false);
		} else {
			new YourEnergyElectricity_Page()
			.haveEconomy7Meter(true);
		}
		
		
		new YourEnergyElectricity_Page()
		.selectElectricityPaymentType(PAYMENT_TYPE.QUATERLY_DIRECT_DEBIT)
		.isElectricityMainSource(true);
		
		if(electricityUsage.contains("kwh")){
			new YourEnergyElectricity_Page()
			.setElectricityUsageUnit(ENERGY_USAGE_UNIT.kWH);
		} else {
			new YourEnergyElectricity_Page()
			.setElectricityUsageUnit(ENERGY_USAGE_UNIT.pound);
		}
	});
	
	
	

	Then("^I should be able to see day and night fields related to economy7$", () -> {
	    
		new YourEnergyElectricity_Page()
		.validateEconomy7RelatedFields();
		
	});
	
	
	
	When("^I leave one of the usage field empty and click Next$", () -> {
		
		try {
			new YourEnergyElectricity_Page()
			.setEconomy7ElectricityUsage(ENERGY_USAGE_UNIT.kWH, "500", USAGE_CYCLE.ANNUALLY, null)
			.clickNext();
		} catch (RuntimeException e) {

			if(!(e.getMessage().contains("not found on the current page."))){
				throw new RuntimeException(e.getMessage());
			}
		}
	});

	
	Then("^I should see error message \"([^\"]*)\"$", (String errorMessage) -> {

		new YourEnergyElectricity_Page()
		.validateText(errorMessage);
		
	});
	


	When("^I enter the day and night usage in annual cycle and move to the next page and enter the gas usage in pound on a monthly cycle$", () -> {
		
		new YourEnergyElectricity_Page()
		.setEconomy7ElectricityUsage(ENERGY_USAGE_UNIT.kWH, "500", USAGE_CYCLE.ANNUALLY, "1000")
		.clickNext()
		.selectGasTariff("Standard Paper Billing")
		.selectPaymentType(PAYMENT_TYPE.MONTHLY_DIRECT_DEBIT)
		.isGasMainSource(false)
		.setGasUsageUnit(ENERGY_USAGE_UNIT.pound)
		.setCurrentGasUsage(ENERGY_USAGE_UNIT.pound,"200", USAGE_CYCLE.MONTHLY);

	});

	

	Then("^I should be asked to select bill date$", () -> {
	    
		new YourEnergyGas_Page()
		.validateGasBillDateField();	
		
	});

	When("^I provide today as bill date and move to the next page and I am interested in All tariffs and All payment types$", () -> {
		
		new YourEnergyGas_Page()
		.setGasBillDate("today")
		.clickNext()
		.setTariffPreferece(TARIFF_TYPE.ALL)
		.setPaymentPreference(PAYMENT_TYPE.ALL_PAYMENT_TYPES);
	});

	When("^I agree to marketing information via email$", () -> {
	   
		new YourPreferences_Page()
		.agreeMarketingInformationViaEmail(true);
	});

	When("^I enter my email id$", () -> {
		
	   new YourPreferences_Page()
	   .setEmailAddress("test@test.com");
	   
	});

	When("^I agree to the terms and conditions$", () -> {
		
		new YourPreferences_Page()
		   .agreeTermsAndConditions(true);
		 
		//Put under try/catch block, as the question to refine results is displayed in the YourPreference_Page intermittently.
		try {
			new YourPreferences_Page()
			.likeToRefineResults(false);
		} catch (Exception e) {

		}
		   
	});
	
	When("^I click GoToPrices$", () -> {
		
		new YourPreferences_Page()
		   .clickGoToPrices();
	});
	
	
	Then("^I should be able to see All Payment types and All tariff types in my results page$", () -> {
	    
		new YourResults_Page()
		.validateAllPaymentTypes()
		.validateAllTariffTypes()
		.isPaymentTypeFilterCheckedFor(PAYMENT_TYPE.ALL_PAYMENT_TYPES)
		.isTariffTypeFilterCheckedFor(TARIFF_TYPE.ALL);
	});
	
	
	


	
	When("^I move to the next page and I \"([^\"]*)\" a economy7 meter and My electricity expense is \"([^\"]*)\" pounds monthly and click Next$", (String economy7Availability, String electricityExpese) -> {

		economy7Availability = economy7Availability.toLowerCase();
		
		new YourSupplier_Page()
		.clickNext();
		
		if(economy7Availability.contains("do not")){
			new YourEnergyElectricity_Page()
			.haveEconomy7Meter(false);
		} else {
			new YourEnergyElectricity_Page()
			.haveEconomy7Meter(true);
		}
		
		new YourEnergyElectricity_Page()
		.setGeneralElectricityUsage(null, "250", USAGE_CYCLE.QUARTERLY)
		.clickNext();
		
	});
	
	
	
	
	When("^I am interested in Variable tariffs and Monthly direct debit$", () -> {
	    
		new YourPreferences_Page()
		.setTariffPreferece(TARIFF_TYPE.VARIABLE)
		.setPaymentPreference(PAYMENT_TYPE.MONTHLY_DIRECT_DEBIT);
		
		
	});
	
	
	Then("^I should be able to see Monthly direct debit payment types and Variable tariff types in my results page$", () -> {

		new YourResults_Page()
		.isPaymentTypeFilterCheckedFor(PAYMENT_TYPE.MONTHLY_DIRECT_DEBIT)
		.isTariffTypeFilterCheckedFor(TARIFF_TYPE.VARIABLE);
		
	});
	
	
	When("^I move to the next page and My gas expense is \"([^\"]*)\" pounds monthly and click Next$", (String expense) -> {
		
		new YourSupplier_Page()
		.clickNext();
		
		new YourEnergyGas_Page()
		.setCurrentGasUsage(null, expense, USAGE_CYCLE.ANNUALLY)
		.clickNext();
		
	});
	
	
	}
	
	
	@cucumber.api.java.Before
	public void beforeScenario() {
		invokeApp("firefox");
		deleteAllCookie();
	}

	@cucumber.api.java.After
	public void afterScenario(Scenario scenario) {
		
		if(scenario.isFailed()){
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		
	    quitDriver();
	}

}
