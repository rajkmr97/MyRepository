$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/RAJKUMAR/eclipse-workspace/Cucumber/Myntra_BDD/Myntra_BDD/features/login.feature");
formatter.feature({
  "name": "Login Myntra",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Login with Valid Credentials",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User is on Myntra Home Page",
  "keyword": "Given "
});
formatter.step({
  "name": "User Navigate to Login Page",
  "keyword": "When "
});
formatter.step({
  "name": "User enters \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User successfully Logged in",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "Password"
      ]
    },
    {
      "cells": [
        "ramkmrshiv@gmail.com",
        "9988776655"
      ]
    },
    {
      "cells": [
        "baladharini@gmail.com",
        "9941898416"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login with Valid Credentials",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User is on Myntra Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "Login_StepDef.user_is_on_Myntra_Home_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Navigate to Login Page",
  "keyword": "When "
});
formatter.match({
  "location": "Login_StepDef.user_Navigate_to_Login_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters \"ramkmrshiv@gmail.com\" and \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.match({
  "location": "Login_StepDef.user_enters_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User successfully Logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "Login_StepDef.user_successfully_Logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with Valid Credentials",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User is on Myntra Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "Login_StepDef.user_is_on_Myntra_Home_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Navigate to Login Page",
  "keyword": "When "
});
formatter.match({
  "location": "Login_StepDef.user_Navigate_to_Login_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters \"baladharini@gmail.com\" and \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.match({
  "location": "Login_StepDef.user_enters_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User successfully Logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "Login_StepDef.user_successfully_Logged_in()"
});
formatter.result({
  "status": "passed"
});
});