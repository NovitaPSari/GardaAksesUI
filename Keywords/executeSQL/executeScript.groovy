package executeSQL

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class executeScript {
	@Keyword

	def checksurveyin () {
		///// DRIVER NAME
		if (GlobalVariable.driver != findTestData("AAB").getValue(5, 1)) {
			println (GlobalVariable.driver)
			println (findTestData("AAB").getValue(5,1))
			//new forceStop.executeStop().FSTOP()
		}
		if (GlobalVariable.driver != findTestData("InboundCall").getValue(5, 1)) {
			new forceStop.executeStop().FSTOP()
		}
		///// LOCATION ACCIDENT
		if (findTestData("InboundCall").getValue(6, 1) != 'locationaccident') {
			new forceStop.executeStop().FSTOP()
		}
		if (findTestData("InboundCall").getValue(4, 1) != 'locationaccident') {
			new forceStop.executeStop().FSTOP()
		}
		///// ACCIDENT INFORMATION
		if (findTestData("InboundCall").getValue(7, 1) != 'accidentinfo') {
			new forceStop.executeStop().FSTOP()
		}
		if (findTestData("AAB").getValue(6, 1) != 'accidentinfo') {
			new forceStop.executeStop().FSTOP()
		}
		///// REMARKS
		if (findTestData("InboundCall").getValue(8, 1) != 'remarks') {
			new forceStop.executeStop().FSTOP()
		}
		if (findTestData("AAB").getValue(11, 1) != 'remarks') {
			new forceStop.executeStop().FSTOP()
		}
		///// CLAIMEE_NAME
		if (findTestData("AAB").getValue(2, 1) != 'BTE') {
			new forceStop.executeStop().FSTOP()
		}
		///// CLAIMEE_PHONE
		if (findTestData("AAB").getValue(3, 1) != '21232323') {
			new forceStop.executeStop().FSTOP()
		}
		///// SURVEY_DATE
		if (findTestData("AAB").getValue(7, 1) != findTestData("Holiday").getValue(1, 1)) {
			new forceStop.executeStop().FSTOP()
		}
		///// REGION & AREA CODE
		if (findTestData("AAB").getValue(9, 1) != 'GD0001') {
			new forceStop.executeStop().FSTOP()
		}
		if (findTestData("AAB").getValue(10, 1) != 'RD0001') {
			new forceStop.executeStop().FSTOP()
		}
	}
}


