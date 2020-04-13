import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import com.keyword.UI

/*
String NameGA = findTestData('null').getValue(1, 3) 
String EmployeeID = findTestData('Training Katalon 2').getva
//Yang pertama Colom, yang kedua row berapa.

WebUI.comment(NameGA)
*/

//String test = UI.getValueDatabase("172.16.94.48", "LiTT", "SELECT * FROM dbo.Otosales", "Value")
//String test2 = UI.getValueDatabase("172.16.94.48", "LiTT", "SELECT * FROM dbo.Otosales", "Parameters")
//
//println (test)
//println (test2)

int a = UI.test ('SELECT * FROM dbo.Qatalon_Testsuites QT INNER JOIN dbo.Qatalon_Application QA ON QA.App_ID = QT.App_ID')

println (a)

