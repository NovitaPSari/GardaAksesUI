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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys1
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.delay(GlobalVariable.Delay6)

//========== Patient Information ==========
//Member
if (Member == 'Existing') {
    WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Input - Member'), 
        MemberName)

    WebUI.delay(GlobalVariable.Delay1)

    WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Input - Member'), 
        MemberName)

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Choose - Member', [('MemberName') : MemberName]))

    WebUI.delay(GlobalVariable.Delay1)

    def MemberBelumTerMapping = WebUI.verifyElementPresent(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Popup - Member Belum Ter-Mapping'), 
        GlobalVariable.Delay2)

    if (MemberBelumTerMapping == true) {
        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - X'))
    } else {
        WebUI.delay(0)
    }
} else if (Member == 'New') {
    WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Button - Add New Member'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - New Member Type'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Choose - New Member Type', 
            [('NewMemberType') : NewMemberType]))

    if (NewMemberType == 'Employee') {
        WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Input - New Member Name'), 
            NewMemberName)

        WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Input - Client Name'), 
            ClientName)

        WebUI.delay(GlobalVariable.Delay1)

        WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Input - Client Name'), 
            ClientName)

        WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Choose - Client Name'))

        WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Input - Employee ID'), EmployeeID)

		//DATE PICKER//
        WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - Date Picker'))

        WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - Month Year'))

        def CurrentYear = WebUI.getText(WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - Year')))

        def int DifferentYear = CurrentYear - Tahun

        for (def index : (0..DifferentYear)) {
			WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - Prev Year'))
        }
		
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Choose - Month', [('Month') : Bulan]))
		
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Choose - Date', [('Date') : Tanggal]))
		//END DATE PICKER//
		
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - Classification'))
		
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Choose - Classification', [('Classification') : Classification]))
		
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - Gender', [('Gender') : Gender]))
		
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - Submit'))
		
    } else if (NewMemberType == 'Spouse') {
	
    //WRITE YOUR CODE HERE//
	
    } else if (NewMemberType == 'Child') {
	
    //WRITE YOUR CODE HERE//
	
    } else {
        WebUI.delay(0)
    }
} else if (Member == 'Check') {

	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Button - Add New Member'))

	def ExistingNewMemberName = WebUI.getAttribute(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Input - New Member Name'),'value')
	
	WebUI.verifyMatch(ExistingNewMemberName, NewMemberName, false)
	
	WebUI.delay(GlobalVariable.Delay1)

	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Add New Member/Button - X'))

} else {
    WebUI.delay(0)
}

//Patient / Family Phone No
def PatientFamilyPhoneNo = WebUI.getAttribute(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Input - Patient, Family Phone No'), 'value')

if (PatientFamilyPhoneNo == ''){
	WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Input - Patient, Family Phone No'), GlobalVariable.PatientFamilyPhoneNo)
} else {
	WebUI.delay(0)
}

//Product Type
WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Button - Product Type'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Choose - Product Type', [('ProductType') : ProductType]))

//GL Type
if (((GLType == 'Awal') || (GLType == 'Revisi')) || (GLType == 'Akhir')) {
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Button - GL Type'))

	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Choose - GL Type', [('GLType') : GLType]))
} else {
	WebUI.delay(0)
}

//Special Condition
if (SpecialCondition == 'Yes') {
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Check Box - Special Condition'))
	
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Button - Reason Special Condition'))
	
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Choose - Reason Special Condition', [('ReasonSpecialCondition') : ReasonSpecialCondition]))
} else {
	WebUI.delay(0)
}

//========== Provider Information ==========
def ProviderName = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Provider Information/Input - Provider Name'), 'value')

if (ProviderName == '' ){
	
}

//========== Treatment Information ==========
//Diagnosis



//========== Room Information ==========

//========== Document Management ==========