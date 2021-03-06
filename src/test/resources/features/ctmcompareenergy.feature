#Author: thirumalaiprabu@gmail.com
#Keywords Summary : This is the feature file which contails 3 scenarios of sdet test.
Feature: Test CTM Energy comparison scenarios

  
    Scenario: Test All Payment and All Tariff types comparison for both Electriciy and Gas with Bill

    Given I am a "Gas & Electricity" customer "with" bill from postcode "PE26YS"
    Then I should be asked whether my suppliers are same
    When My Gas & Electricity suppliers are "different"
    And My Electricity supplier is "British"
    And My Gas supplier is "SSE"
    When I move to the next page and I "have" a economy7 meter and My current electricity usage is in "kWh"
    Then I should be able to see day and night fields related to economy7
    When I leave one of the usage field empty and click Next
    Then I should see error message "Complete this section to continue"
    When I enter the day and night usage in annual cycle and move to the next page and enter the gas usage in pound on a monthly cycle
    Then I should be asked to select bill date
    When I provide today as bill date and move to the next page and I am interested in All tariffs and All payment types
    And I enter my email id
    And I agree to marketing information via email
    And I agree to the terms and conditions
    And I click GoToPrices
    Then I should be able to see All Payment types and All tariff types in my results page



    Scenario: Test Variable tariff and Monthly direct debit types comparison for Electricity only without Bill
    
    Given I am a "Electricity only" customer "without" bill from postcode "PE26YS"
    And My Electricity supplier is "Scottish"
    When I move to the next page and I "have" a economy7 meter and My electricity expense is "200" pounds monthly and click Next
    When I am interested in Variable tariffs and Monthly direct debit
    And I enter my email id
    And I agree to marketing information via email
    And I agree to the terms and conditions
    And I click GoToPrices
    Then I should be able to see Monthly direct debit payment types and Variable tariff types in my results page
    
   Scenario: Test Variable tariff and Monthly direct debit types comparison for Gas only without Bill
    
    Given I am a "Gas only" customer "without" bill from postcode "PE26YS"
    And My Gas supplier is "EDF"
    When I move to the next page and My gas expense is "200" pounds monthly and click Next
    When I am interested in Variable tariffs and Monthly direct debit
    And I enter my email id
    And I agree to marketing information via email
    And I agree to the terms and conditions
    And I click GoToPrices
    Then I should be able to see Monthly direct debit payment types and Variable tariff types in my results page

    
    
    
  
    