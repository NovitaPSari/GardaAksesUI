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
		def driverAAB = findTestData("AAB").getValue(5, 1) as String
		def driverGA = findTestData("InboundCall").getValue(5, 1) as String
		def locationAAB = findTestData("AAB").getValue(4, 1) as String
		def locationGA = findTestData("InboundCall").getValue(6, 1) as String
		def accidentAAB = findTestData("AAB").getValue(6, 1) as String
		def accidentGA = findTestData("InboundCall").getValue(7, 1) as String
		def remarksGA = findTestData("InboundCall").getValue(8, 1) as String
		def remarksAAB = findTestData("AAB").getValue(11, 1) as String
		def claimeephone = findTestData("AAB").getValue(3, 1) as String
		def claimeename = findTestData("AAB").getValue(2, 1) as String
		def surveydateAAB = findTestData("AAB").getValue(7, 1) as String
		def surveydateGA = findTestData("Holiday").getValue(1, 1) as String
		def surveytypecode = findTestData("InboundCall").getValue(9, 1) as String

		///// DRIVER NAME
		if (GlobalVariable.driver != driverAAB) {
			new forceStop.executeStop().FSTOP()
		}
		if (GlobalVariable.driver != driverGA) {
			new forceStop.executeStop().FSTOP()
		}
		///// LOCATION ACCIDENT
		if (locationGA != 'locationaccident') {
			new forceStop.executeStop().FSTOP()
		}
		if (locationAAB != 'locationaccident') {
			new forceStop.executeStop().FSTOP()
		}
		///// ACCIDENT INFORMATION
		if (accidentGA != 'accidentinfo') {
			new forceStop.executeStop().FSTOP()
		}
		if (accidentAAB != 'accidentinfo') {
			new forceStop.executeStop().FSTOP()
		}
		///// REMARKS
		if (remarksGA != 'remarks') {
			new forceStop.executeStop().FSTOP()
		}
		if (remarksAAB != 'remarks') {
			new forceStop.executeStop().FSTOP()
		}
		///// CLAIMEE_NAME
		if (claimeename != 'BTE') {
			new forceStop.executeStop().FSTOP()
		}
		///// CLAIMEE_PHONE
		if (claimeephone != '21232323') {
			new forceStop.executeStop().FSTOP()
		}
		///// SURVEY_DATE
		if (surveydateAAB != surveydateGA) {
			new forceStop.executeStop().FSTOP()
		}
		///// SURVEY TYPE CODE
		if (surveytypecode != 'ST1') {
			new forceStop.executeStop().FSTOP()
		}
	}

	@Keyword
	def checksurveyingc () {
		def regioncode = findTestData("AAB").getValue(10, 1) as String
		def areacode = findTestData("AAB").getValue(9, 1) as String

		///// REGION & AREA CODE
		if (areacode != 'GD0001') {
			new forceStop.executeStop().FSTOP()
		}
		if (regioncode != 'RD0001') {
			new forceStop.executeStop().FSTOP()
		}
	}

	@Keyword
	def checksurveyinws () {
		def regioncode = findTestData("AAB").getValue(10, 1) as String
		def areacode = findTestData("AAB").getValue(9, 1) as String

		///// REGION & AREA CODE
		if (areacode != 'GD0001') {
			new forceStop.executeStop().FSTOP()
		}
		if (regioncode != 'RD0001') {
			new forceStop.executeStop().FSTOP()
		}
	}

	@Keyword
	def checksurveyinbr () {
		def regioncode = findTestData("AAB").getValue(10, 1) as String
		def areacode = findTestData("AAB").getValue(9, 1) as String

		///// REGION & AREA CODE
		if (areacode != 'GD0001') {
			new forceStop.executeStop().FSTOP()
		}
		if (regioncode != 'RD0001') {
			new forceStop.executeStop().FSTOP()
		}
	}

	@Keyword
	def checksurveyinro () {
		def regioncode = findTestData("AAB").getValue(10, 1) as String
		def areacode = findTestData("AAB").getValue(9, 1) as String

		///// REGION & AREA CODE
		if (areacode != 'GD0001') {
			new forceStop.executeStop().FSTOP()
		}
		if (regioncode != 'RD0001') {
			new forceStop.executeStop().FSTOP()
		}
	}

	@Keyword
	def checksurveyout () {
		def driverAAB = findTestData("AAB").getValue(5, 1) as String
		def driverGA = findTestData("InboundCallOut").getValue(5, 1) as String
		def locationAAB = findTestData("AAB").getValue(4, 1) as String
		def locationGA = findTestData("InboundCallOut").getValue(6, 1) as String
		def accidentAAB = findTestData("AAB").getValue(6, 1) as String
		def accidentGA = findTestData("InboundCallOut").getValue(7, 1) as String
		def remarksGA = findTestData("InboundCallOut").getValue(8, 1) as String
		def remarksAAB = findTestData("AAB").getValue(11, 1) as String
		def claimeephone = findTestData("AAB").getValue(3, 1) as String
		def claimeename = findTestData("AAB").getValue(2, 1) as String
		def surveydateAAB = findTestData("AAB").getValue(7, 1) as String
		def surveydateGA = findTestData("Holiday").getValue(1, 1) as String
		def customeronloc = findTestData("InboundCallOut").getValue(10, 1) as String
		def phoneonloc = findTestData("InboundCallOut").getValue(11, 1) as String
		def surveytypecode = findTestData("InboundCallOut").getValue(13, 1) as String

		///// DRIVER NAME
		if (GlobalVariable.driver != driverAAB) {
			new forceStop.executeStop().FSTOP()
		}
		if (GlobalVariable.driver != driverGA) {
			new forceStop.executeStop().FSTOP()
		}
		///// LOCATION ACCIDENT
		if (locationGA != 'locationaccident') {
			new forceStop.executeStop().FSTOP()
		}
		if (locationAAB != 'locationaccident') {
			new forceStop.executeStop().FSTOP()
		}
		///// ACCIDENT INFORMATION
		if (accidentGA != 'accidentinfo') {
			new forceStop.executeStop().FSTOP()
		}
		if (accidentAAB != 'accidentinfo') {
			new forceStop.executeStop().FSTOP()
		}
		///// REMARKS
		if (remarksGA != 'remarks') {
			new forceStop.executeStop().FSTOP()
		}
		if (remarksAAB != 'remarks') {
			new forceStop.executeStop().FSTOP()
		}
		///// CLAIMEE_NAME
		if (claimeename != 'BTE') {
			new forceStop.executeStop().FSTOP()
		}
		///// CLAIMEE_PHONE
		if (claimeephone != '21232323') {
			new forceStop.executeStop().FSTOP()
		}
		///// SURVEY_DATE
		if (surveydateAAB != surveydateGA) {
			new forceStop.executeStop().FSTOP()
		}
		///// CUSTOMER ON LOCATION
		if (customeronloc != 'customeronlocation') {
			new forceStop.executeStop().FSTOP()
		}
		///// PHONE ON LOCATION
		if (phoneonloc != '081818181') {
			new forceStop.executeStop().FSTOP()
		}
		///// SURVEY TYPE CODE
		if (surveytypecode != 'ST2') {
			new forceStop.executeStop().FSTOP()
		}
	}

	@Keyword
	def checksurveyaddress() {
		def surveyaddress = findTestData("InboundCallOut").getValue(14, 1) as String

		if (surveyaddress != 'survey address')
			new forceStop.executeStop().FSTOP()
	}

	@Keyword
	def checkregionareaoutworkshop() {
		def regioncode = findTestData("AAB").getValue(10, 1) as String
		def areacode = findTestData("AAB").getValue(9, 1) as String
		def workshopcode = findTestData("InboundCallOut").getValue(9, 1) as String
		//def postalcode = findTestData("InboundCallOut").getValue(12, 1) as String

		///// REGION & AREA CODE
		if (areacode != 'GS0162') {
			new forceStop.executeStop().FSTOP()
		}
		if (regioncode != 'RS4042') {
			new forceStop.executeStop().FSTOP()
		}
		///// WORKSHOP
		if (workshopcode != '160908321') {
			new forceStop.executeStop().FSTOP()
		}
		///// POSTAL CODE
		//if (postalcode != '12270') {
		//	new forceStop.executeStop().FSTOP()
		//}
	}

	@Keyword
	def checkregionareaout() {
		def regioncode = findTestData("AAB").getValue(10, 1) as String
		def areacode = findTestData("AAB").getValue(9, 1) as String
		//def postalcode = findTestData("InboundCallOut").getValue(12, 1) as String

		///// REGION & AREA CODE
		if (areacode != 'GS0162') {
			new forceStop.executeStop().FSTOP()
		}
		if (regioncode != 'RS4042') {
			new forceStop.executeStop().FSTOP()
		}
		///// POSTAL CODE
		//if (postalcode != '12270') {
		//	new forceStop.executeStop().FSTOP()
		//}
	}

}


