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

import com.keyword.GEN5
import com.keyword.UI

//========== Patient Information ==========
//Member

def PopUpNonClient = WebUI.waitForElementVisible(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Pop Up Non Client/Text - Non Client'), 3)

if (Member == 'Existing') {	
	CustomKeywords.'gardaAkses.CreateGL.InputMemberName'(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Input - Member'), MemberName) 			
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

		WebUI.delay(5)

		WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Input - Client Name'),
			ClientName)
		
		WebUI.delay(5)

		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Choose - Client Name'))

		WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Input - Employee ID'), EmployeeID)

		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Date Picker - DOB'))
		
		GEN5.DatePicker(DOB, findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Date Picker - DOB Month'))
		
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - Classification'))
		
//		=== Ambil Classification paling rendah ===
		
		WebDriver driver = DriverFactory.getWebDriver()
		
		WebUI.switchToFrame(findTestObject('Pages/Web/GEN5/Frame'), 3)
		
		WebElement Classification = driver.findElement(By.xpath('//*[@id="popUpAddNewMembership-0"]/div[1]/div/div[1]/a2is-combo/div/div/div/div'))
		
		List<WebElement> ClassificationList = Classification.findElements(By.tagName('button'))
		
		WebUI.switchToDefaultContent()
		
		String SelectClassificationList = ClassificationList.size()
		
		println SelectClassificationList
		
//		=== END ===
		
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Choose - Classification', [('value') : SelectClassificationList]))
		
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - Gender', [('Value') : Gender]))
		
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - Submit'))
		
		def PopUpNonClient3 = WebUI.waitForElementVisible(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Pop Up Non Client/Text - Non Client'), 3)
		
		if (PopUpNonClient3) {
			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Pop Up Non Client/Button - Close'))
		}
		
		GlobalVariable.NewMemberName = WebUI.getAttribute(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Input - New Member Name'),'value')
		
	} else if (NewMemberType == 'Spouse') {
	
	//WRITE YOUR CODE HERE//
	
	} else if (NewMemberType == 'Child') {
	
	//WRITE YOUR CODE HERE//
	
	}
} else if (Member == 'Check New Member') {
	def ExistingNewMemberName = WebUI.getAttribute(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Input - New Member Name'),'value')
	
	WebUI.verifyMatch(ExistingNewMemberName, GlobalVariable.NewMemberName, false)
}else if (Member == 'Check Member') {
	def ExistingMemberName = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Input - Member'),'value')
	
	WebUI.verifyMatch(ExistingMemberName, MemberName, false)	
}

//Patient / Family Phone No
CustomKeywords.'gardaAkses.General.UpdateFieldText'(
	findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Input - Patient, Family Phone No'), 
	GlobalVariable.PhoneNumber)

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
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Date Picker - Treatment Period Start'))
	
	GEN5.DatePicker(TreatmentPeriodStart, findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Date Picker - Treatment Period Start Month'))
	
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
}

//========== Provider Information ==========
def ProviderName = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Provider Information/Input - Provider Name'), 'value')

if (ProviderName == '' || ProviderName == null){
		
}


//========== Treatment Information ==========
//Diagnosis
def DiagnosaValue = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Input - Diagnosis'), 'value')

if (DiagnosaValue == '') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Look Up - Diagnosis'))
	
	int Repeat = StatusDiagnosa.size()
	
	for (i = 0; i < Repeat; i++) {
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Diagnosis/Combo - Status'))
		
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Diagnosis/List - Status', [('Value') : StatusDiagnosa[i]]))
		
		WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Diagnosis/Input - Diagnosis ID'), DiagnosisID[i])
		
		WebUI.delay(5)
		
		WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Diagnosis/Input - Diagnosis ID'), DiagnosisID[i])
		
		WebUI.delay(5)
		
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Diagnosis/Select - Diagnosis ID'))
		
		GEN5.ProcessingCommand()
		
		WebDriver driver = DriverFactory.getWebDriver()
		
		WebUI.switchToFrame(findTestObject('Pages/Web/GEN5/Frame'), 3)
		
		WebElement diagnosis = driver.findElement(By.xpath('//*[@id="DiagnosisInfoPopUpSectionFullText-0"]/div[1]/div/div[3]/a2is-datatable/div[2]/div/table/tbody'))
		
		List<WebElement> additional_info = diagnosis.findElements(By.tagName('tr'))
		
		WebUI.switchToDefaultContent()
		
		int yes = additional_info.size()
		
		int i = 1
		
		for (a = 1; a <= yes; a++) {
			WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Diagnosis/Radio Button - Yes', [('Value') : a]))
		
			WebUI.delay(1)
		}
		
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Diagnosis/Button - Choose'))
		
		GEN5.ProcessingCommand()
	}		
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Diagnosis/Button - Submit'))
}

//Remarks

//Passed Away

//Doctor
CustomKeywords.'gardaAkses.General.UpdateFieldText'(
	findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Input - Doctor'),
	DoctorName)

//Account Manager
if (Member == 'Check New Member') {
	WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Input - Account Manager'), AccountManager)
}

//Rujuk
if (Rujuk == 'Yes') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Combo - Reason'))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Treatment Information/Combo List - Reason', [('Value') : ReasonReferral]))
}

//========== Room Information ==========
//Appropriate RB Class
String getValueAppropriateRBClass = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Input - Appropriate RB Class - Value'), 'value')

if (getValueAppropriateRBClass != AppropriateRBClass) {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Look Up - Appropriate RB Class'))
	
	GEN5.ProcessingCommand()
	
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Appropriate RB Class/Select - Appropriate RB Class', [('Value') : AppropriateRBClass]))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Appropriate RB Class/Button - Choose'))
}

//Treatment RB Class
String getValueTreatmentRBClass = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Input - Treatment RB Class - Value'), 'value')

if (getValueTreatmentRBClass != TreatmentRBClass) {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Look Up - Treatment RB Class'))
	
	GEN5.ProcessingCommand()
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Treatment RB Class/Select - Treatment RB Class', [('Value') : TreatmentRBClass]))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Treatment RB Class/Button - Choose'))
}

//Room Option / Availability
CustomKeywords.'gardaAkses.General.UpdateFieldCombo'(
	findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Combo - Room Option Availability'), 
	findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Combo List - Room Option Availability', [('Value') : RoomOptionAvailability]), 
	RoomOptionAvailability)

////Appropriate RB Rate
//CustomKeywords.'gardaAkses.General.UpdateFieldText'(
//	findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Input - Appropriate RB Rate'), 
//	AppropriateRBRate)

//GEN5.ProcessingCommand()

////Treatment RB Rate
//CustomKeywords.'gardaAkses.General.UpdateFieldText'(
//	findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Input - Treatment RB Rate'), 
//	TreatmentRBRate)

//GEN5.ProcessingCommand()

//Total Billed
if (GLType == 'Akhir') {
	WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Room Information/Input - Total Billed'), TotalBilled)
}

//========== Document Management ==========
//New Document
if (NewDocument == 'Yes') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Document Management/Button - Create New Document Management'))
	
	GEN5.ProcessingCommand()
}

//Edit Document
if (EditDocument == 'Yes') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Document Management/Button - Edit Document Management'))
}

//Delete Document
if (DeleteDocument == 'Yes') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Document Management/Button - Delete Document Management'))
}

//Action
if (ActionGL == 'Cancel') {
	
} else if (ActionGL == 'Interupted Call') {
	
} else if (ActionGL == 'Pre-Admission') {
	
} else if (ActionGL == 'Process') {
	WebUI.scrollToElement(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Button - Process'), 5)
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Button - Process'))
	
	WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Text - Validasi', [('Value') : Validasi]))	
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Button - Close'))
	
	CustomKeywords.'gardaAkses.GetTicketID.ProviderHealthClaim'(Phase)
} else if (ActionGL == 'Reject') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Button - Reject'))
	
	WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Text - Validasi', [('Value') : Validasi]))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Button - Close'))
}