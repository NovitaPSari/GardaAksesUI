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

//Member Info
if (NewComplaint == 'Yes') {
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Button - Search Member'))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Search Member/Input - Member No'))
	
	WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Button - Search Member'), MemberNo)
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Search Member/Button - Search'))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Search Member/Choose - Member'))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Search Member/Button - Select'))
	
} else {
	WebUI.delay(0)
}

//Complaint Category
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Button - Complaint Category'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Choose - Complaint Category', [('ComplaintCategory') : ComplaintCategory]))

//Complaint Sub Category