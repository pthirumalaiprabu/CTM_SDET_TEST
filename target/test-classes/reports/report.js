$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ctmcompareenergy.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: thirumalaiprabu@gmail.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary : This is the feature file which contails 3 scenarios of sdet test."
    }
  ],
  "line": 3,
  "name": "Test CTM Energy comparison scenarios",
  "description": "",
  "id": "test-ctm-energy-comparison-scenarios",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Test All Payment and All Tariff types comparison for both Electriciy and Gas with Bill",
  "description": "",
  "id": "test-ctm-energy-comparison-scenarios;test-all-payment-and-all-tariff-types-comparison-for-both-electriciy-and-gas-with-bill",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I am a \"Gas \u0026 Electricity\" customer \"with\" bill from postcode \"PE26YS\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I should be asked whether my suppliers are same",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "My Gas \u0026 Electricity suppliers are \"different\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "My Electricity supplier is \"British\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "My Gas Supplier is \"SSE\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I move to the next page and I \"have\" a economy7 meter and My current electricity usage is in \"kWh\"",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I should be able to see day and night fields related to economy7",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "I leave one of the usage field empty and click Next",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I should see error message \"Complete this section to continue\"",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "I enter the day and night usage in annual cycle and move to the next page and enter the gas usage in pound on a monthly cycle",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I should be asked to select bill date",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "I provide today as bill date and move to the next page and I am interested in All tariffs and All payment types",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "I enter my email id",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I agree to marketing information via email",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I agree to the terms and conditions",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I click GoToPrices",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I should be able to see All Payment types and All tariff types in my results page",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Gas \u0026 Electricity",
      "offset": 8
    },
    {
      "val": "with",
      "offset": 37
    },
    {
      "val": "PE26YS",
      "offset": 63
    }
  ],
  "location": "CTMEnergyComparisonSteps.java:31"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:62"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "different",
      "offset": 36
    }
  ],
  "location": "CTMEnergyComparisonSteps.java:71"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "British",
      "offset": 28
    }
  ],
  "location": "CTMEnergyComparisonSteps.java:85"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "SSE",
      "offset": 20
    }
  ],
  "location": "CTMEnergyComparisonSteps.java:103"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:166"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:175"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Complete this section to continue",
      "offset": 28
    }
  ],
  "location": "CTMEnergyComparisonSteps.java:190"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:199"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:214"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:221"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:236"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:230"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:243"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:249"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:256"
});
formatter.result({
  "status": "skipped"
});
});