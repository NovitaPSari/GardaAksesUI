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

WebUI.delay(1)

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

WebUI.click(findTestObject('Object Repository/Schedule Survey/EXP_PRODUCT'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Schedule Survey/LST_PRODUCT_GO'))

WebUI.delay(1)

if (customercategory == 'Others') {
	WebUI.setText(findTestObject('Object Repository/Schedule Survey/TXT_VEHICLE'), 'Vehicle')
}else {
	WebUI.click(findTestObject('Object Repository/Schedule Survey/EXP_VEHICLE'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Schedule Survey/LST_VEHICLE',[('policyno') : GlobalVariable.policyno]))
}

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Schedule Survey/EXP_SURVEY_CATEGORY'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Schedule Survey/LST_SURVEY_CATEGORY',[('surveycategory') : surveycategory]))

WebUI.delay(1)

if (surveylocation == 'Workshop') {
	WebUI.click(findTestObject('Object Repository/Schedule Survey/BTN_WORKSHOP'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Schedule Survey/Workshop/TXT_SEARCH_INPUT'), 'auto 2000 daan mogot')
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Schedule Survey/Workshop/BTN_SEARCH'))
	WebUI.delay(3)
	WebUI.click(findTestObject('Object Repository/Schedule Survey/Workshop/LST_SEARCH_RESULT_1'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Schedule Survey/Workshop/BTN_SELECT'))
}
else {
	WebUI.click(findTestObject('Object Repository/Schedule Survey/BTN_SURVEY_AREA'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Schedule Survey/Survey Area - Postal Code/EXP_SEARCH_BY'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Schedule Survey/Survey Area - Postal Code/LST_SEARCH_BY'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Schedule Survey/Survey Area - Postal Code/TXT_SEARCH_INPUT'),'11730')
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Schedule Survey/Survey Area - Postal Code/BTN_SEARCH'))
	WebUI.delay(3)
	WebUI.click(findTestObject('Object Repository/Schedule Survey/Survey Area - Postal Code/LST_SEARCH_RESULT_1'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Schedule Survey/Survey Area - Postal Code/BTN_SELECT'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Schedule Survey/TXT_SURVEY_ADDRESS'), 'surveyaddress')
}

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Schedule Survey/BTN_SURVEY_SCHEDULE'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Schedule Survey/BTN_SURVEY_DAY',[('day') : day]))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Schedule Survey/EXP_SURVEY_TIME'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Schedule Survey/LST_SURVEY_TIME'))

WebUI.delay(1)

WebUI.setText(findTestObject('Object Repository/Schedule Survey/TXT_CUSTOMER_ON_LOCATION'), 'customeronlocation')

WebUI.delay(1)

WebUI.setText(findTestObject('Object Repository/Schedule Survey/TXT_PIC_PHONE_NO'), '08123123123')

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Schedule Survey/EXP_FU_STATUS'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Schedule Survey/LST_FU_CLOSE'))

WebUI.delay(1)

WebUI.setText(findTestObject('Object Repository/Schedule Survey/TXT_REMARKS'), 'remarks')

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Schedule Survey/BTN_SAVE'))

WebUI.delay(310)

def SOAddress = findTestData("SurveyOrder").getValue(2, 1)
def SASAddress = findTestData("SurveyOrder").getValue(7, 1)
def surveycategorycode = findTestData("InboundCallOut").getValue(15, 1)
def customeronloc = findTestData("SurveyOrder").getValue(8, 1)
def phoneonloc = findTestData("SurveyOrder").getValue(9, 1)
def SORemarks = findTestData("SurveyOrder").getValue(10, 1)
def SASRemarks = findTestData("SurveyOrder").getValue(11, 1)

if (surveycategory == 'Acceptance') {
	if (surveycategorycode != 'SC1') {
		new forceStop.executeStop().FSTOP()
	}
}
else if (surveycategory == 'Claim') {
	if (surveycategorycode != 'SC2') {
		new forceStop.executeStop().FSTOP()
	}
}
else if (surveycategory == 'Additional Survey Claim') {
	if (surveycategorycode != 'SC3') {
		new forceStop.executeStop().FSTOP()
	}
}
else if (surveycategory == 'Loss Location Survey') {
	if (surveycategorycode != 'SC4') {
		new forceStop.executeStop().FSTOP()
	}
}
else if (surveycategory == 'Renewal') {
	if (surveycategorycode != 'SC5') {
		new forceStop.executeStop().FSTOP()
	}
}
else if (surveycategory == 'Endorsement') {
	if (surveycategorycode != 'SC6') {
		new forceStop.executeStop().FSTOP()
	}
}
else if (surveycategory == 'Complaint') {
	if (surveycategorycode != 'SC7') {
		new forceStop.executeStop().FSTOP()
	}
}

if (surveylocation != 'Workshop') {
	if (SOAddress != 'surveyaddress') {
		new forceStop.executeStop().FSTOP()
	}
	if (SASAddress != 'surveyaddress') {
		new forceStop.executeStop().FSTOP()
	}
}

if (customeronloc != 'customeronlocation') {
	new forceStop.executeStop().FSTOP()
}

if (phoneonloc != '08123123123') {
	new forceStop.executeStop().FSTOP()
}

if (SORemarks != 'remarks') {
	new forceStop.executeStop().FSTOP()
}

if (SASRemarks != 'remarks') {
	new forceStop.executeStop().FSTOP()
}

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Schedule Survey/BTN_OK'))

WebUI.delay(1)






