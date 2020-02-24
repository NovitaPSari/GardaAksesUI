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

//========== Patient Information ==========
//Member
if (Member == 'Existing') {
	WebUI.comment(MemberName)
	
	WebUI.getAttribute(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Input - Member'), 'value')
	
	CustomKeywords.'gardaAkses.CreateGL.InputMemberName'(
		findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Input - Member'), 
		MemberName)
		
	
} else if (Member == 'New') {
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Button - Add New Member'))

	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - New Member Type'))

	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Choose - New Member Type',
			[('Value') : NewMemberType]))

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

		CustomKeywords.'gardaAkses.CreateGL.DatePicketStart'(Tanggal, Bulan, Tahun)
		
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - Classification'))
		
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Choose - Classification', [('Value') : Classification]))
		
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - Gender', [('Value') : Gender]))
		
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
CustomKeywords.'gardaAkses.General.UpdateFieldText'(
	findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Input - Patient, Family Phone No'), 
	GlobalVariable.PatientFamilyPhoneNo)

//Product Type
CustomKeywords.'gardaAkses.General.UpdateFieldCombo'(
	findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Button - Product Type'), 
	findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Choose - Product Type', [('Value') : ProductType]),
	ProductType)

//GL Type
CustomKeywords.'gardaAkses.General.UpdateFieldCombo'(
	findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Button - GL Type'),
	findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Choose - GL Type', [('Value') : GLType]),
	GLType)

//Treatment Period Start
if (EditTreatmentPeriodStart == 'Yes') {
	WebUI.click(null)
}

//Treatment Period End
if (EditTreatmentPeriodEnd == 'Yes' && GLType == 'Akhir') {
	WebUI.click(null)
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

if (ProviderName == '' || ProviderName == null){
	
	
	
} else {
	WebUI.delay(0)
}


//========== Treatment Information ==========
//Diagnosis
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Look Up - Diagnosis'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Diagnosis/Combo - Status'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Diagnosis/List - Status', [('Value') : StatusDiagnosa]))

WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Diagnosis/Input - Diagnosis ID'), DiagnosisID)

WebUI.delay(5)

WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Diagnosis/Input - Diagnosis ID'), DiagnosisID)

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Diagnosis/Select - Diagnosis ID'))

CustomKeywords.'gardaAkses.General.waitProcessingCommand'()

WebDriver driver = DriverFactory.getWebDriver()

WebUI.switchToFrame(findTestObject('Object Repository/Pages/Web/Garda Akses/Frame'), 3)

WebElement diagnosis = driver.findElement(By.xpath('//*[@id="DiagnosisInfoPopUpSectionFullText-0"]/div[1]/div/div[3]/a2is-datatable/div[2]/div/table/tbody'))

List<WebElement> additional_info = diagnosis.findElements(By.tagName('tr'))

WebUI.switchToDefaultContent()

int yes = additional_info.size()

int i = 1

for (a = i; a <= yes; a++) {
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Diagnosis/Radio Button - Yes', [('Value') : a]))

	WebUI.delay(1)
}

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Diagnosis/Button - Choose'))

CustomKeywords.'gardaAkses.General.waitProcessingCommand'()

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Diagnosis/Button - Submit'))


//Remarks

//Passed Away

//Doctor
CustomKeywords.'gardaAkses.General.UpdateFieldText'(
	findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Input - Doctor'),
	DoctorName)

//Rujuk
if (Rujuk == 'Yes') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Combo - Reason'))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Combo List - Reason', [('Value') : ReasonReferral]))
} else {
	WebUI.delay(0)
}


//========== Room Information ==========
////Appropriate RB Class
//String getValueAppropriateRBClass = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Input - Appropriate RB Class - Value'), 'value')
//
//if (getValueAppropriateRBClass != AppropriateRBClass) {
//	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Look Up - Appropriate RB Class'))
//	
//	CustomKeywords.'gardaAkses.General.waitProcessingCommand'()
//	
//	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Appropriate RB Class/Select - Appropriate RB Class', [('Value') : AppropriateRBClass]))
//	
//	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Appropriate RB Class/Button - Choose'))
//} else {
//	WebUI.delay(0)
//}
//
////Treatment RB Class
//String getValueTreatmentRBClass = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Input - Treatment RB Class - Value'), 'value')
//
//if (getValueTreatmentRBClass != TreatmentRBClass) {
//	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Look Up - Treatment RB Class'))
//	
//	CustomKeywords.'gardaAkses.General.waitProcessingCommand'()
//	
//	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Treatment RB Class/Select - Treatment RB Class', [('Value') : TreatmentRBClass]))
//	
//	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Treatment RB Class/Button - Choose'))
//} else {
//	WebUI.delay(0)
//}

//Room Option / Availability
CustomKeywords.'gardaAkses.General.UpdateFieldCombo'(
	findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Combo - Room Option Availability'), 
	findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Combo List - Room Option Availability', [('Value') : RoomOptionAvailability]), 
	RoomOptionAvailability)

////Appropriate RB Rate
//CustomKeywords.'gardaAkses.General.UpdateFieldText'(
//	findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Input - Appropriate RB Rate'), 
//	AppropriateRBRate)

//CustomKeywords.'gardaAkses.General.waitProcessingCommand'()

////Treatment RB Rate
//CustomKeywords.'gardaAkses.General.UpdateFieldText'(
//	findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Input - Treatment RB Rate'), 
//	TreatmentRBRate)

//CustomKeywords.'gardaAkses.General.waitProcessingCommand'()

//Total Billed
if (GLType == 'Akhir') {
	WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Input - Total Billed'), TotalBilled)
} else {
	WebUI.delay(0)
}

//========== Document Management ==========
//New Document
if (NewDocument == 'Yes') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Document Management/Button - Create New Document Management'))
	
	CustomKeywords.'gardaAkses.General.waitProcessingCommand'()
} else {
	WebUI.delay(0)
}

//Edit Document
if (EditDocument == 'Yes') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Document Management/Button - Edit Document Management'))
} else {
	WebUI.delay(0)
}

//Delete Document
if (DeleteDocument == 'Yes') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Document Management/Button - Delete Document Management'))
} else {
	WebUI.delay(0)
}

//Action
if (ActionGL == 'Cancel') {
	
} else if (ActionGL == 'Interupted Call') {
	
} else if (ActionGL == 'Pre-Admission') {
	
} else if (ActionGL == 'Process') {
	WebUI.scrollToElement(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Button - Process'), 5)
	
	WebUI.delay(10)
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Button - Process'))
	
	WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Text - Validasi', [('Value') : Validasi]))	
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Button - Close'))
	
	CustomKeywords.'gardaAkses.GetTicketID.ProviderHealthClaim'(Phase)
} else {
	WebUI.delay(0)
}