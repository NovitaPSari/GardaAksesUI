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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

if (ServiceType == 'Inquiry') {
	//Member Name
	WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Member Name'), MemberName)
	
	WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Member Name'), MemberName)
	
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Choose - Member Name'))
	
	//Provider Name
	if (ContactLine == 'Customer' && Product == 'Health') {
		WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Provider Name'), ProviderName)
		
		WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Provider Name'), ProviderName)
		
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Choose - Provider Name'))
	} else {
		WebUI.delay(0)
	}
	
	//Sub Service Type
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Sub Service Type'))
	
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Choose - Sub Service Type', [('SubServiceType') : SubServiceType]))
	
	//Remarks
	WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Remarks'), Remarks)
	
	//Need Follow Up
	if (NeedFollowUp == 'Yes') {
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Check Box - Need Follow Up'))
	} else {
		WebUI.delay(0)
	}
	
	//Back
	if (Back == 'Yes') {
		WebUI.click(findTestObject('null'))
	} else {
		WebUI.delay(0)
	}
	
	//Process
	if (Proses == 'Yes') {
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Process'))
	} else {
		WebUI.delay(0)
	}
	
	WebUI.click(findTestObject('null'))
	
} else if (ServiceType == 'Approval Tindakan/Terapi/Obat') {
	//Member Name
	WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Member Name'), MemberName)
	
	WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Member Name'), MemberName)
	
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Choose - Member Name'))
	
	//Sub Service Type
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Sub Service Type'))
	
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Choose - Sub Service Type', [('SubServiceType') : SubServiceType]))
	
	//Remarks
	WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Remarks'), Remarks)
	
	//Need Follow Up
	if (NeedFollowUp == 'Yes') {
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Check Box - Need Follow Up'))
	} else {
		WebUI.delay(0)
	}
	
	//Back
	if (Back == 'Yes') {
		WebUI.click(findTestObject('null'))
	} else {
		WebUI.delay(0)
	}
	
	//Process
	if (Proses == 'Yes') {
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Process'))
	} else {
		WebUI.delay(0)
	}
	
	WebUI.click(findTestObject('null'))
}