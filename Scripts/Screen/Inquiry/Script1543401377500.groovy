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

def surveydate = findTestData("Holiday").getValue(1, 1)
def day = surveydate.split("/") [0] as String

WebUI.delay(1)

if (day == '01') {
	day = '1' as String
}else if (day == '02') {
	day = '2' as String
}else if (day == '03') {
	day = '3' as String
}else if (day == '04') {
	day = '4' as String
}else if (day == '05') {
	day = '5' as String
}else if (day == '06') {
	day = '6' as String
}else if (day == '07') {
	day = '7' as String
}else if (day == '08') {
	day = '8' as String
}else if (day == '09') {
	day = '9' as String
}

WebUI.delay(1)

WebUI.click(findTestObject('Inquiry/EXP_PRODUCT'))

WebUI.delay(1)

WebUI.click(findTestObject('Inquiry/LST_PRODUCT_GO'))

WebUI.delay(1)

WebUI.click(findTestObject('Inquiry/EXP_VEHICLE'))

WebUI.delay(1)

WebUI.click(findTestObject('Inquiry/LST_VEHICLE',[('policyno') : GlobalVariable.policyno]))

WebUI.delay(5)

WebUI.click(findTestObject('Inquiry/EXP_SURVEY_TYPE'))

WebUI.delay(1)

WebUI.click(findTestObject('Inquiry/LST_SURVEY_TYPE',[('surveytype') : surveytype]))

WebUI.delay(3)

GlobalVariable.policyholder = WebUI.getAttribute(findTestObject('Object Repository/Inquiry/TXT_POLICY_HOLDER'), 'value')

WebUI.delay(1)

GlobalVariable.policyaddress = WebUI.getAttribute(findTestObject('Object Repository/Inquiry/TXT_POLICY_ADDRESS'), 'value')

WebUI.delay(1)

GlobalVariable.chassisno = WebUI.getAttribute(findTestObject('Object Repository/Inquiry/TXT_CHASSIS_NO'), 'value')

WebUI.delay(1)

GlobalVariable.engineno = WebUI.getAttribute(findTestObject('Object Repository/Inquiry/TXT_ENGINE_NO'), 'value')

WebUI.delay(1)

if (surveytype == 'Survey-in') {
	WebUI.click(findTestObject('Inquiry/BTN_SURVEY_IN_LOCATION'))
	WebUI.delay(5)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/IN Location Detail/EXP_SEARCH_BY'))
	WebUI.delay(1)
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
	GlobalVariable.surveyaddress = WebUI.getText(findTestObject('Object Repository/Inquiry/IN Location Detail/LST_ADDRESS'))
	WebUI.delay(1)
	GlobalVariable.areacode = WebUI.getText(findTestObject('Object Repository/Inquiry/IN Location Detail/LST_AREA_CODE'))

	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/IN Location Detail/LST_SEARCH_RESULT_1'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Claim MV/Claim MV/IN Location Detail/BTN_SELECT'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/BTN_SURVEY_SCHEDULE_IN'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Inquiry/BTN_DAY_SURVEY_IN',[('day') : day]))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/EXP_ENDORSEMENT_CATEGORY'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/LST_ENDORSEMENT_CATEGORY',[('endorsecategory') : endorsecategory]))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/EXP_FU_STATUS'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/LST_FU_CLOSE'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Inquiry/TXT_FU_REMARKS'), 'remarks')
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/BTN_SAVE'))
	WebUI.delay(310)
		def SOAreaCode = findTestData("SurveyOrder").getValue(1, 1) as String
		def SOAddress = findTestData("SurveyOrder").getValue(2, 1) as String
		def NameOnPolicy = findTestData("SurveyOrder").getValue(3, 1) as String
		def ChassisNo = findTestData("SurveyOrder").getValue(4, 1) as String
		def EngineNo = findTestData("SurveyOrder").getValue(5, 1) as String
		def SASAreaCode = findTestData("SurveyOrder").getValue(6, 1) as String
		def SASAddress = findTestData("SurveyOrder").getValue(7, 1) as String
		
		if (SOAreaCode != GlobalVariable.areacode) {
			new forceStop.executeStop().FSTOP()
		}
		if (SOAddress != GlobalVariable.surveyaddress) {
			new forceStop.executeStop().FSTOP()
		}
		if (NameOnPolicy != GlobalVariable.policyholder) {
			new forceStop.executeStop().FSTOP()
		}
		if (ChassisNo != (GlobalVariable.chassisno).trim()) {
			new forceStop.executeStop().FSTOP()
		}
		if (EngineNo != (GlobalVariable.engineno).trim()) {
			new forceStop.executeStop().FSTOP()
		}
		if (SASAreaCode != GlobalVariable.areacode) {
			new forceStop.executeStop().FSTOP()
		}
		if (SASAddress != GlobalVariable.surveyaddress) {
			new forceStop.executeStop().FSTOP()
		}
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/BTN_X'))
	WebUI.delay(1)
}

else if (surveytype == 'Survey-out') {
	WebUI.delay(1)
	if (surveylocation == 'Workshop') {
		WebUI.click(findTestObject('Object Repository/Inquiry/BTN_WORKSHOP_LIST'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/Inquiry/Workshop List/TXT_SEARCH_INPUT'), 'auto 2000 daan mogot')
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Inquiry/Workshop List/BTN_SEARCH'))
		WebUI.delay(1)
		GlobalVariable.postalcode = WebUI.getText(findTestObject('Object Repository/Inquiry/Workshop List/LST_POSTAL_CODE'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Inquiry/Workshop List/LST_SEARCH_RESULT_1'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Inquiry/Workshop List/BTN_SELECT'))
		WebUI.delay(1)
		GlobalVariable.surveyaddress = WebUI.getAttribute(findTestObject('Object Repository/Inquiry/TXT_SURVEY_ADDRESS'), 'value')
		WebUI.delay(1)
	}else if (surveylocation != 'Workshop') {
		WebUI.click(findTestObject('Object Repository/Inquiry/BTN_SURVEY_AREA'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Inquiry/Survey Area/EXP_SEARCH_BY'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Inquiry/Survey Area/LST_SEARCH_BY'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/Inquiry/Survey Area/TXT_SEARCH_INPUT'),'11730')
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Inquiry/Survey Area/BTN_SEARCH'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Inquiry/Survey Area/LST_SEARCH_RESULT_1'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Inquiry/Survey Area/BTN_SELECT'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/Inquiry/TXT_SURVEY_ADDRESS'), 'surveyaddress')
		WebUI.delay(1)
		GlobalVariable.surveyaddress = WebUI.getAttribute(findTestObject('Object Repository/Inquiry/TXT_SURVEY_ADDRESS'), 'value')
		WebUI.delay(1)
	}
	
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/BTN_SURVEY_SCHEDULE_OUT'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/BTN_DAY_SURVEY_OUT',[('day') : day]))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/EXP_SURVEY_CATEGORY_TIME'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/LST_SURVEY_CATEGORY_TIME'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Inquiry/TXT_PHONE_NUMBER'), '08123123123')
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/EXP_ENDORSEMENT_CATEGORY'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/LST_ENDORSEMENT_CATEGORY',[('endorsecategory') : endorsecategory]))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Inquiry/TXT_CUSTOMER_ON_LOCATION'), 'customer')
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Inquiry/TXT_PIC'), 'pic')
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/EXP_FU_STATUS'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/LST_FU_CLOSE'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Inquiry/TXT_FU_REMARKS'), 'remarks')
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/BTN_SAVE'))
	WebUI.delay(310)
	def SOAddress = findTestData("SurveyOrder").getValue(2, 1) as String
	def NameOnPolicy = findTestData("SurveyOrder").getValue(3, 1) as String
	def ChassisNo = findTestData("SurveyOrder").getValue(4, 1) as String
	def EngineNo = findTestData("SurveyOrder").getValue(5, 1) as String
	def SASAddress = findTestData("SurveyOrder").getValue(7, 1) as String
	
	if (SOAddress != GlobalVariable.surveyaddress) {
		new forceStop.executeStop().FSTOP()
	}
	if (NameOnPolicy != GlobalVariable.policyholder) {
		new forceStop.executeStop().FSTOP()
	}
	if (ChassisNo != (GlobalVariable.chassisno).trim()) {
		new forceStop.executeStop().FSTOP()
	}
	if (EngineNo != (GlobalVariable.engineno).trim()) {
		new forceStop.executeStop().FSTOP()
	}
	if (SASAddress != GlobalVariable.surveyaddress) {
		new forceStop.executeStop().FSTOP()
	}
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Inquiry/BTN_X'))
	WebUI.delay(1)
}























