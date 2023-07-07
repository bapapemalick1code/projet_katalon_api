import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import sun.security.provider.certpath.OCSPResponse.ResponseStatus

import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper as JsonSlurper



//WS.sendRequestAndVerify(findTestObject('Rest API/Grocery/Register new client', [('username') : 'milk', ('email') : 'milk6@gmail.com']))

def response = WS.sendRequestAndVerify(findTestObject('Rest API/Grocery/Register new client', [('username') : 'milk', ('email') : 'milko4@gmail.com']))

def jsonSlurper = new JsonSlurper()

def object = jsonSlurper.parseText(response.getResponseBodyContent())

println('token checked = ' + object)

def brtoken = object.accessToken

println('token checked after parse = ' + brtoken)

WS.sendRequest(findTestObject('Rest API/Grocery/New Order', [('bearerToken') : brtoken]))

