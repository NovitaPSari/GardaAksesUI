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

WebUI.delay(GlobalVariable.Delay7)

//Popup Member Belum Termapping
def InformationMember = WebUI.verifyElementPresent(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Text - Information'), 
    GlobalVariable.Delay1)

if (InformationMember == true) {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - X'))
}

//Patient Information
WebUI.scrollToElement(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Text - Page Claim'), GlobalVariable.Delay1)

//Member + MemberStatus
if (Member == 'Existing') {
    WebUI.setText(findTestObject('Pages/Web/Garda Akses/Claim/Input - Member'), MemberName)

    WebUI.delay(GlobalVariable.Delay1)

    WebUI.setText(findTestObject('Pages/Web/Garda Akses/Claim/Input - Member'), MemberName)
	
	WebUI.delay(GlobalVariable.Delay0)

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Choose - Member', [('MemberName') : MemberName]))

    if (MemberStatus == 'Non Client') {
        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - X'))
    }
	
	WebUI.delay(GlobalVariable.Delay3)
} else if (Member == 'New') {
    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Button - Add New Member'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Button - New Member Type'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Choose - New Member Type', [('NewMemberType') : NewMemberType]))

    WebUI.setText(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Input - New Member Name'), NewMemberName)

    WebUI.setText(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Input - Client Name'), ClientName)
	
	WebUI.delay(GlobalVariable.Delay0)

    WebUI.setText(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Input - Client Name'), ClientName)
	
	WebUI.delay(GlobalVariable.Delay0)

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Choose - Client Name'))

    WebUI.setText(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Input - Employee ID'), EmployeeID)

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Button - Date Picker'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Button - Month Year'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Button - Year'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Button - Prev Year'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Button - Prev Year'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Choose - Year', [('Year') : Year]))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Choose - Month', [('Month') : Month]))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Choose - Date'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Button - Classification'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Choose - Classification', [('Classification') : Classification]))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Button - Gender', [('Gender') : Gender]))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Button - Submit'))

    if (MemberStatus == 'Non Client') {
        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - X'))
    }
} else if (Member == 'Check') {
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Button - Add New Member'))

	def ExistingNewMemberName = WebUI.getAttribute(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Input - New Member Name'),'value')
	
	println 'Ini existing new member ' + ExistingNewMemberName
	
	println 'Ini Membernya ' + NewMemberName
	
	WebUI.verifyMatch(ExistingNewMemberName, NewMemberName, false)
	
	WebUI.delay(GlobalVariable.Delay1)

    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Add New Member/Button - X'))
} else {
    WebUI.delay(0)
}

//FamilyPhoneNo
if (FamilyPhoneNo != null) {
    WebUI.setText(findTestObject('Pages/Web/Garda Akses/Claim/Input - Phone No'), FamilyPhoneNo)
} else {
    WebUI.delay(0)
}

//ProductType
if (ProductType != null) {
    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Button - Product Type'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Choose - Product Type', [('ProductType') : ProductType]))
} else {
    WebUI.delay(0)
}

//GL Type
if (((GLType == 'Awal') || (GLType == 'Revisi')) || (GLType == 'Akhir')) {
    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Button - GL Type'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Choose - GL Type', [('GLType') : GLType]))
} else {
    WebUI.delay(0)
}

//Treatment Information
//Diagnosis
WebUI.delay(GlobalVariable.Delay2)

if (DiagnosisStatus != null) {
    WebUI.scrollToElement(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Text - Page Claim'), GlobalVariable.Delay1)

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Button - Diagnosis'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Diagnosis/Button - Status'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Diagnosis/Choose - Status', [('DiagnosisStatus') : DiagnosisStatus]))

    WebUI.setText(findTestObject('Pages/Web/Garda Akses/Claim/Diagnosis/Input - Diagnosis ID'), DiagnosisID)

    WebUI.delay(GlobalVariable.Delay2)

    WebUI.setText(findTestObject('Pages/Web/Garda Akses/Claim/Diagnosis/Input - Diagnosis ID'), DiagnosisID)
	
	WebUI.delay(GlobalVariable.Delay2)

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Diagnosis/Choose - Diagnosis ID'))

    WebUI.delay(GlobalVariable.Delay2)

    WebDriver driver = DriverFactory.getWebDriver()

    WebUI.switchToFrame(findTestObject('Object Repository/Pages/Web/Garda Akses/Frame'), 3)

    WebElement diagnosis = driver.findElement(By.xpath('//*[@id="DiagnosisInfoPopUpSectionFullText-0"]/div[1]/div/div[3]/a2is-datatable/div[2]/div/table/tbody'))

    List<WebElement> additional_info = diagnosis.findElements(By.tagName('tr'))

    WebUI.switchToDefaultContent()

    int yes = additional_info.size()

    int i = 1

    for (a = i; a <= yes; a++) {
        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Diagnosis/Radio Button - Yes', [('i') : a]))

        WebUI.delay(1)
    }
    
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Diagnosis/Button - Choose'))
	
	WebUI.delay(GlobalVariable.Delay2)

    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Diagnosis/Button - Submit'))
} else {
    WebUI.delay(0)
}

//Account Manager
//def AccountManager = WebUI.verifyElementPresent(findTestObject('Pages/Web/Garda Akses/Claim/Input - Account Manager'), GlobalVariable.Delay0)
//if (AccountManager == true) {
	if (Status == 'Reject') {
	    if (ClientName == 'PT BANK PERMATA TBK' || ClientName == 'ASURANSI ASTRA BUANA') {
	        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Account Manager'))
	
	        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Account Manager/Choose - Account Manager'))
	
	        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Account Manager/Button - Submit'))
	    } else if (ClientName == 'PT SHOWA INDONESIA MANUFACTURING') {
	        WebUI.setText(findTestObject('Pages/Web/Garda Akses/Claim/Input - Account Manager'), 'Mba Mbe')
	    }
	} else {
	    WebUI.delay(0)
	}
//} else {
//    WebUI.delay(0)
//}

//Doctor
if (DoctorName != null) {
    WebUI.scrollToElement(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Text - Page Claim'), GlobalVariable.Delay1)

    WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Input - Doctor Name'), DoctorName)
} else {
    WebUI.delay(0)
}

//Rujuk + Reason
if (Rujuk == 'Yes') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Checkbox - Rujuk'))

    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Reason'))

    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Reason Rujuk/Choose - Reason'))
} else {
    WebUI.delay(0)
}

//Appropriate RB Class
def AppropriateRBClass = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Text - Appropriate RB Class'), 'value')

if (AppropriateRBClass == '') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Appropriate RB Class'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Appropriate RB Class/Button - Room Class'))

    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Appropriate RB Class/Button - Choose'))
} else {
    WebUI.delay(0)
}

//Treatment RB Class
def TreatmentRBClass = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Text - Treatment RB Class'), 'value')

if (TreatmentRBClass == '') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Treatment RB Class'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Treatment RB Class/Button - Room Class'))

    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Treatment RB Class/Button - Choose'))
} else {
    WebUI.delay(0)
}

//NPNFU
if (NPNFU == 'Yes') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/CheckBox - Need Follow Up'))
} else {
    WebUI.delay(0)
}

//TotalBilled
if (GLType == 'Akhir') {
    WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Input - Total Billed'), TotalBilled)
} else {
    WebUI.delay(0)
}

//Status
if (Status == 'PreAdmission') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Pre-Admission'))
} else if (Status == 'InteruptedCall') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Interupted Call'))
} else if (Status == 'Reject') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Reject'))
} else if (Status == 'Process') {
    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Button - Process'))
} else {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Cancel'))
}

//Validasi
if ((((Status == 'PreAdmission') || (Status == 'InteruptedCall')) || (Status == 'Reject')) || (Status == 'Process')) {
    WebUI.verifyElementPresent(findTestObject('Pages/Web/Garda Akses/Claim/Summary/Text - Status', [('Summary') : Summary]), 
        GlobalVariable.Delay3, FailureHandling.STOP_ON_FAILURE)

//    WebUI.verifyElementPresent(findTestObject('Pages/Web/Garda Akses/Claim/Summary/Text - Validasi', [('Validasi') : Validasi]), 
//        GlobalVariable.Delay3, FailureHandling.STOP_ON_FAILURE)

    WebUI.takeScreenshot()

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Button - Close'))
} else {
    WebUI.delay(0)
}

//Store Ticket ID
if (GLType == 'Awal' || GLType == 'Revisi' || GLType == 'Akhir' || Member == 'Existing' || Member == 'New') {
//	if (Member == 'Existing' || Member == 'New') {
		if (InterruptedCall == null) {
			if (GLType == 'Awal') {
				def result = WebUI.getText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Text - Ticket ID'))
			
				GlobalVariable.TicketIDAwal = result.substring(10, 18)
			
				println(GlobalVariable.TicketIDAwal)
			} else if (GLType == 'Revisi') {
				def result = WebUI.getText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Text - Ticket ID'))
			
				GlobalVariable.TicketIDRevisi = result.substring(10, 18)
			
				println(GlobalVariable.TicketIDRevisi)
			} else {
				def result = WebUI.getText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Text - Ticket ID'))
			
				GlobalVariable.TicketIDAkhir = result.substring(10, 18)
			
				println(GlobalVariable.TicketIDAkhir)
			}
			
			WebUI.getText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Text - Ticket ID'))
			
			WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Button - Close'))
		} else {
				if (GLType == 'Awal') {
					def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Text - Interrupted Ticket ID'))
					
					GlobalVariable.TicketIDAwal = result.substring(22, 30)
				
					println(GlobalVariable.TicketIDAwal)
				} else if (GLType == 'Revisi') {
					def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Text - Interrupted Ticket ID'))
				
					GlobalVariable.TicketIDRevisi = result.substring(22, 30)
				
					println(GlobalVariable.TicketIDRevisi)
				} else {
					def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Text - Interrupted Ticket ID'))
				
					GlobalVariable.TicketIDAkhir = result.substring(22, 30)
				
					println(GlobalVariable.TicketIDAkhir)
				}
				
				WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Text - Interrupted Ticket ID'))
				
				WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Button - Interrupted Close'))
			}
//		}
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Tidak Hal Lain Yang di Bantu'))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Puas'))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Ok Show Thanks'))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Ok Close App'))
} else if (Status == 'Reject' || Status == 'PreAdmission' ){
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Tidak Hal Lain Yang di Bantu'))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Puas'))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Ok Show Thanks'))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Ok Close App'))
} else if (Member == 'Check') {
	WebUI.delay(0)
}