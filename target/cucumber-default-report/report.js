$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@sprint5"
    },
    {
      "name": "@login"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Error message validation while invalid login",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@reporting"
    }
  ]
});
formatter.step({
  "name": "user enter \"\u003cUsername\u003e\" and \"\u003cPassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "user click on login button",
  "keyword": "And "
});
formatter.step({
  "name": "user see \"\u003cErrorMessage\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Username",
        "Password",
        "ErrorMessage"
      ]
    },
    {
      "cells": [
        "Admin",
        "Admin123",
        "Invalid Credentials"
      ]
    },
    {
      "cells": [
        "Hello",
        "Syntax123!",
        "Invalid Credentials"
      ]
    },
    {
      "cells": [
        "Admin",
        "",
        "Password cannot be empty"
      ]
    },
    {
      "cells": [
        "",
        "Syntax123!",
        "Username cannot be empty"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Error message validation while invalid login",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@sprint5"
    },
    {
      "name": "@login"
    },
    {
      "name": "@reporting"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enter \"Admin\" and \"Admin123\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.LoginSteps.user_enter_valid_and(java.lang.String,java.lang.String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: Cannot locate an element using id\u003dtxtUsername\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-SG0CRU7\u0027, ip: \u0027192.168.100.23\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_241\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:327)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:372)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:188)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.clear(Unknown Source)\r\n\tat com.hrms.utils.CommonMethods.sendText(CommonMethods.java:33)\r\n\tat com.hrms.steps.LoginSteps.user_enter_valid_and(LoginSteps.java:70)\r\n\tat ✽.user enter \"Admin\" and \"Admin123\"(file:///C:/Users/Alex/eclipse-workspace/CucumberJenkins/src/test/resources/features/Login.feature:18)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "user click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.LoginSteps.user_click_on_login_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user see \"Invalid Credentials\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.LoginSteps.user_see(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
