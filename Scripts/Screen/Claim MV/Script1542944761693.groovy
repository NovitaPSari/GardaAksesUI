import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.Variable as Variable
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.delay(1)

def surveydate = findTestData("Holiday").getValue(1, 1)
def day = surveydate.split("/") [0] as String

WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/EXP_PRODUCT'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/LST_PRODUCT_GO'))

WebUI.delay(3)

WebUI.click(findTestObject('Claim MV/Claim MV/EXP_VEHICLE'))

WebUI.delay(3)

WebUI.click(findTestObject('Claim MV/Claim MV/LST_VEHICLE', [('policyno') : GlobalVariable.policyno]))

WebUI.delay(5)

GlobalVariable.driver = WebUI.getAttribute(findTestObject('Object Repository/Claim MV/Claim MV/TXT_DRIVER'), 'value')

WebUI.delay(1)

WebUI.click(findTestObject('Claim MV/Claim MV/EXP_SURVEY_TYPE'))

WebUI.delay(1)

WebUI.click(findTestObject('Claim MV/Claim MV/LST_SURVEY_TYPE', [('surveytype') : surveytype]))

WebUI.delay(3)

if (surveytype == 'Survey-in') {
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/BTN_SURVEY_IN_LOCATION'))
	WebUI.delay(3)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/IN Location Detail/EXP_SEARCH_BY'))
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/IN Location Detail/LST_SEARCH_BY',[('searchby') : surveylocation]))
	WebUI.delay(1)
	
	if (surveylocation.toUpperCase() == 'GARDA CENTER') {
		def locationname = 'pacific place'
		WebUI.setText(findTestObject('Object Repository/Claim MV/Claim MV/IN Location Detail/TXT_SEARCH_BY_INPUT'), locationname)
	}else if (surveylocation.toUpperCase() == 'WORKSHOP') {
		def locationname = 'auto 2000 sunter'
		WebUI.setText(findTestObject('Object Repository/Claim MV/Claim MV/IN Location Detail/TXT_SEARCH_BY_INPUT'), locationname)
	}else if (surveylocation.toUpperCase() == 'BRANCH') {
		def locationname = 'tb simatupang'
		WebUI.setText(findTestObject('Object Repository/Claim MV/Claim MV/IN Location Detail/TXT_SEARCH_BY_INPUT'), locationname)
	}else if (surveylocation.toUpperCase() == 'RO') {
		def locationname = 'ro aceh'
		WebUI.setText(findTestObject('Object Repository/Claim MV/Claim MV/IN Location Detail/TXT_SEARCH_BY_INPUT'), locationname)
	}
	
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/IN Location Detail/BTN_SEARCH'))
	WebUI.delay(7)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/IN Location Detail/LST_SEARCH_RESULT_1'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/IN Location Detail/BTN_SELECT'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/BTN_SURVEY_SCHEDULE_IN'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/BTN_DAY_SURVEY',[('day') : day]))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Claim MV/Claim MV/TXT_LOCATION_ACCIDENT'), 'locationaccident')
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Claim MV/Claim MV/TXT_ACCIDENT_INFO'), 'accidentinfo')
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/EXP_CAUSE_LOSS'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/LST_CAUSE_DITABRAK'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/CHK_SEND_SMS'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/EXP_FU_STATUS'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/LST_FU_CLOSE'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Claim MV/Claim MV/TXT_FU_REMARKS'), 'remarks')
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/BTN_SAVE'))
	WebUI.delay(310)
	CustomKeywords.'executeSQL.executeScript.checksurveyin'()
	WebUI.delay(1)
	if (surveylocation.toUpperCase() == 'GARDA CENTER') {
		CustomKeywords.'executeSQL.executeScript.checksurveyingc'()
		WebUI.delay(1)
	}else if (surveylocation.toUpperCase() == 'WORKSHOP') {
		CustomKeywords.'executeSQL.executeScript.checksurveyinws'()
		WebUI.delay(1)
	}else if (surveylocation.toUpperCase() == 'BRANCH') {
		CustomKeywords.'executeSQL.executeScript.checksurveyinbr'()
		WebUI.delay(1)
	}else if (surveylocation.toUpperCase() == 'RO') {
		CustomKeywords.'executeSQL.executeScript.checksurveyinro'()
		WebUI.delay(1)
	}
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/BTN_SAVE_OK'))
	WebUI.delay(10)
}
else if (surveytype == 'Survey-out') {
	if (surveylocation == 'Workshop') {
		WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/BTN_WORKSHOP_LIST'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('Object Repository/Claim MV/Claim MV/OUT Workshop/TXT_SEARCH_INPUT'), 'auto 2000 ciledug')
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/OUT Workshop/BTN_SEARCH'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/OUT Workshop/LST_SEARCH_RESULT_1'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/OUT Workshop/BTN_SELECT'))
		WebUI.delay(1)
	}
	else if (surveylocation != 'Workshop') {
		WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/BTN_POSTAL_CODE'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/OUT Postal Code/EXP_SEARCH_BY'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/OUT Postal Code/LST_SEARCH_BY',[('searchby') : 'Postal Code']))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/Claim MV/Claim MV/OUT Postal Code/TXT_SEARCH_BY_INPUT'), '12270')
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/OUT Postal Code/BTN_SEARCH'))
		WebUI.delay(8)
		WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/OUT Postal Code/LST_SEARCH_RESULT_1'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/OUT Postal Code/BTN_ADD'))
		WebUI.delay(3)
	}
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/BTN_SURVEY_SCHEDULE_IN'))
	WebUI.delay(3)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/BTN_DAY_SURVEY',[('day') : day]))
	WebUI.delay(3)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/EXP_SURVEY_TIME'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/LST_SURVEY_TIME'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Claim MV/Claim MV/TXT_LOCATION_ACCIDENT'), 'locationaccident')
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Claim MV/Claim MV/TXT_ACCIDENT_INFO'), 'accidentinfo')
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/EXP_CAUSE_LOSS'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/LST_CAUSE_DITABRAK'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Claim MV/Claim MV/TXT_CUST_ON_LOCATION'), 'customeronlocation')
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Claim MV/Claim MV/TXT_PIC_PHONE'), '081818181')
	WebUI.delay(1)
	if (surveylocation != 'Workshop') {
		WebUI.setText(findTestObject('Object Repository/Claim MV/Claim MV/TXT_SURVEY_ADDRESS'), 'survey address')
		WebUI.delay(1)
	}
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/CHK_SEND_SMS'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/EXP_FU_STATUS'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/LST_FU_CLOSE'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Claim MV/Claim MV/TXT_FU_REMARKS'), 'remarks')
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/BTN_SAVE'))
	WebUI.delay(310)
	CustomKeywords.'executeSQL.executeScript.checksurveyout'()
	if (surveylocation == 'Workshop') {
		WebUI.delay(1)
		CustomKeywords.'executeSQL.executeScript.checkregionareaoutworkshop'()
	}
	if (surveylocation != 'Workshop') {
		WebUI.delay(1)
		CustomKeywords.'executeSQL.executeScript.checkregionareaout'()
	}
	WebUI.delay(1)
	if (surveylocation != 'Workshop') {
		CustomKeywords.'executeSQL.executeScript.checksurveyaddress'()
		WebUI.delay(1)
	}
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/BTN_SAVE_OK'))
	WebUI.delay(10)
}



















