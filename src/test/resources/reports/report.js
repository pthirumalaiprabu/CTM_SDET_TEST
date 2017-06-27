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
formatter.before({
  "duration": 31016602347,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Test All Payment and All Tariff types comparison for both Electriciy and Gas with Bill",
  "description": "",
  "id": "test-ctm-energy-comparison-scenarios;test-all-payment-and-all-tariff-types-comparison-for-both-electriciy-and-gas-with-bill",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "I am a \"Gas \u0026 Electricity\" customer \"with\" bill from postcode \"PE26YS\"",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I should be asked whether my suppliers are same",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "My Gas \u0026 Electricity suppliers are \"different\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "My Electricity supplier is \"British\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "My Gas supplier is \"SSE\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I move to the next page and I \"have\" a economy7 meter and My current electricity usage is in \"kWh\"",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I should be able to see day and night fields related to economy7",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "I leave one of the usage field empty and click Next",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I should see error message \"Complete this section to continue\"",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "I enter the day and night usage in annual cycle and move to the next page and enter the gas usage in pound on a monthly cycle",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "I should be asked to select bill date",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "I provide today as bill date and move to the next page and I am interested in All tariffs and All payment types",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "I enter my email id",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I agree to marketing information via email",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I agree to the terms and conditions",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "I click GoToPrices",
  "keyword": "And "
});
formatter.step({
  "line": 24,
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
  "location": "CTMEnergyComparisonSteps.java:32"
});
formatter.result({
  "duration": 5727228458,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:63"
});
formatter.result({
  "duration": 180483157,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "different",
      "offset": 36
    }
  ],
  "location": "CTMEnergyComparisonSteps.java:72"
});
formatter.result({
  "duration": 1034119348,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "British",
      "offset": 28
    }
  ],
  "location": "CTMEnergyComparisonSteps.java:86"
});
formatter.result({
  "duration": 944250791,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SSE",
      "offset": 20
    }
  ],
  "location": "CTMEnergyComparisonSteps.java:102"
});
formatter.result({
  "duration": 906359652,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "have",
      "offset": 31
    },
    {
      "val": "kWh",
      "offset": 94
    }
  ],
  "location": "CTMEnergyComparisonSteps.java:120"
});
formatter.result({
  "duration": 6445307685,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:155"
});
formatter.result({
  "duration": 262816217,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:164"
});
formatter.result({
  "duration": 2695190563,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Complete this section to continue",
      "offset": 28
    }
  ],
  "location": "CTMEnergyComparisonSteps.java:179"
});
formatter.result({
  "duration": 236206574,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:188"
});
formatter.result({
  "duration": 7858523581,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:203"
});
formatter.result({
  "duration": 191367380,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:210"
});
formatter.result({
  "duration": 4629196541,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:225"
});
formatter.result({
  "duration": 825628391,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:219"
});
formatter.result({
  "duration": 896957506,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:232"
});
formatter.result({
  "duration": 1779198177,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:247"
});
formatter.result({
  "duration": 15955647774,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:254"
});
formatter.result({
  "duration": 1870029892,
  "status": "passed"
});
formatter.after({
  "duration": 2564555252,
  "status": "passed"
});
formatter.before({
  "duration": 12602337833,
  "status": "passed"
});
formatter.scenario({
  "line": 28,
  "name": "Test Variable tariff and Monthly direct debit types comparison for Electricity only without Bill",
  "description": "",
  "id": "test-ctm-energy-comparison-scenarios;test-variable-tariff-and-monthly-direct-debit-types-comparison-for-electricity-only-without-bill",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 30,
  "name": "I am a \"Electricity only\" customer \"without\" bill from postcode \"PE26YS\"",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "My Electricity supplier is \"Scottish\"",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "I move to the next page and I \"have\" a economy7 meter and My electricity expense is \"200\" pounds monthly and click Next",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "I am interested in Variable tariffs and Monthly direct debit",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "I enter my email id",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "I agree to marketing information via email",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I agree to the terms and conditions",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "I click GoToPrices",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "I should be able to see Monthly direct debit payment types and Variable tariff types in my results page",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Electricity only",
      "offset": 8
    },
    {
      "val": "without",
      "offset": 36
    },
    {
      "val": "PE26YS",
      "offset": 65
    }
  ],
  "location": "CTMEnergyComparisonSteps.java:32"
});
formatter.result({
  "duration": 5555258584,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Scottish",
      "offset": 28
    }
  ],
  "location": "CTMEnergyComparisonSteps.java:86"
});
formatter.result({
  "duration": 897715484,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "have",
      "offset": 31
    },
    {
      "val": "200",
      "offset": 85
    }
  ],
  "location": "CTMEnergyComparisonSteps.java:268"
});
formatter.result({
  "duration": 5167766163,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:292"
});
formatter.result({
  "duration": 1745715930,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:225"
});
formatter.result({
  "duration": 835289226,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:219"
});
formatter.result({
  "duration": 820278284,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:232"
});
formatter.result({
  "duration": 37845416627,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:247"
});
formatter.result({
  "duration": 11572130015,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:302"
});
formatter.result({
  "duration": 379413752,
  "status": "passed"
});
formatter.after({
  "duration": 647621651,
  "status": "passed"
});
formatter.before({
  "duration": 13867689364,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "Test Variable tariff and Monthly direct debit types comparison for Gas only without Bill",
  "description": "",
  "id": "test-ctm-energy-comparison-scenarios;test-variable-tariff-and-monthly-direct-debit-types-comparison-for-gas-only-without-bill",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 42,
  "name": "I am a \"Gas only\" customer \"without\" bill from postcode \"PE26YS\"",
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "My Gas supplier is \"EDF\"",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "I move to the next page and My gas expense is \"200\" pounds monthly and click Next",
  "keyword": "When "
});
formatter.step({
  "line": 45,
  "name": "I am interested in Variable tariffs and Monthly direct debit",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "I enter my email id",
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "I agree to marketing information via email",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "I agree to the terms and conditions",
  "keyword": "And "
});
formatter.step({
  "line": 49,
  "name": "I click GoToPrices",
  "keyword": "And "
});
formatter.step({
  "line": 50,
  "name": "I should be able to see Monthly direct debit payment types and Variable tariff types in my results page",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Gas only",
      "offset": 8
    },
    {
      "val": "without",
      "offset": 28
    },
    {
      "val": "PE26YS",
      "offset": 57
    }
  ],
  "location": "CTMEnergyComparisonSteps.java:32"
});
formatter.result({
  "duration": 5126175221,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "EDF",
      "offset": 20
    }
  ],
  "location": "CTMEnergyComparisonSteps.java:102"
});
formatter.result({
  "duration": 897823271,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 47
    }
  ],
  "location": "CTMEnergyComparisonSteps.java:311"
});
formatter.result({
  "duration": 4174812383,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:292"
});
formatter.result({
  "duration": 2108805658,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:225"
});
formatter.result({
  "duration": 756182861,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:219"
});
formatter.result({
  "duration": 842090230,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:232"
});
formatter.result({
  "duration": 1666700030,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:247"
});
formatter.result({
  "duration": 11383156286,
  "status": "passed"
});
formatter.match({
  "location": "CTMEnergyComparisonSteps.java:302"
});
formatter.result({
  "duration": 413108494,
  "status": "passed"
});
formatter.after({
  "duration": 495362637,
  "status": "passed"
});
});