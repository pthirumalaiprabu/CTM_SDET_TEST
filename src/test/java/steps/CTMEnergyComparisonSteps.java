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
		
		electricitySupplier = electricitySupplier.toLowerCase();
		
		for (POPULAR_ENERGY_SUPPLIER supplier : POPULAR_ENERGY_SUPPLIER.values()) {
			
			if(supplier.getUIIconText().toLowerCase().contains(electricitySupplier)){
				new YourSupplier_Page()
				.setElectricitySupplier(supplier);
				
				break;
			}
		}
		
	});
	
	
	
	When("^My Gas Supplier is \"([^\"]*)\"$", (String gasSupplier) -> {
		
		gasSupplier = gasSupplier.toLowerCase();
		
		for (POPULAR_ENERGY_SUPPLIER supplier : POPULAR_ENERGY_SUPPLIER.values()) {
			
			if(supplier.getUIIconText().toLowerCase().contains(gasSupplier)){
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
		
		
		
		if(true){
			
		} else {
			
		}
		
		new YourEnergyElectricity_Page()
		.selectElectricityPaymentType(PAYMENT_TYPE.QUATERLY_DIRECT_DEBIT)
		.isElectricityMainSource(true);
		
		if(true){
			
		} else {
			
		}
		
		

	});
	
	
	/*
	
	
	
	When("^I move to the next page and I \"([^\"]*)\"$" a economy7 meter and My current electricity usage is in \"([^\"]*)\"$", 
			(String economy7Availability, String electricityUsage) -> {
	    
				economy7Availability.
				
		new YourSupplier_Page()
		.clickNext()
		.selectElectricityPlan("Fixed Price July 2018");
		
		
		
		if(true){
			
		} else {
			
		}
		
		new YourEnergyElectricity_Page()
		.selectElectricityPaymentType(PAYMENT_TYPE.QUATERLY_DIRECT_DEBIT)
		.isElectricityMainSource(true);
		
		if(true){
			
		} else {
			
		}
		
	});*/
	

	

	/*When("^I move to the next page and I have a economy7 meter and My current electricity usage is in kWh$", () -> {
		
		new YourSupplier_Page()
		.clickNext()
		.selectElectricityPlan("Fixed Price July 2018")
		.haveEconomy7Meter(true)
		.selectElectricityPaymentType(PAYMENT_TYPE.QUATERLY_DIRECT_DEBIT)
		.isElectricityMainSource(true)
		.setElectricityUsageUnit(ENERGY_USAGE_UNIT.kWH);
		
	});*/

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
			System.out.println("EXXX : " + e.getMessage());
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
		.setTariffPreferece("All")
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
	});
	
	When("^I click GoToPrices$", () -> {
		
		new YourPreferences_Page()
		   .clickGoToPrices();
	});
	
	
	Then("^I should be able to see All Payment types and All tariff types in my results page$", () -> {
	    
		new YourResults_Page()
		.validateAllPaymentTypes()
		.validateAllTariffTypes();
		
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
