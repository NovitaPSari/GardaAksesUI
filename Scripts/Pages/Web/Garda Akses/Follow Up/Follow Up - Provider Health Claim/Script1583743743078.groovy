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
import com.keyword.GEN5 as GEN5

//TrID
if (Phase == '1') {
    GlobalVariable.TrID1 = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Text - TrID'))
} else if (Phase == '2') {
    GlobalVariable.TrID2 = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Text - TrID'))
} else if (Phase == '3') {
    GlobalVariable.TrID3 = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Text - TrID'))
} else if (Phase == '4') {
    GlobalVariable.TrID4 = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Text - TrID'))
} else if (Phase == '5') {
    GlobalVariable.TrID5 = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Text - TrID'))
}

//Contact Name
String FUContactNameExist = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Text - Contact Name'))

WebUI.comment(FUContactName)

WebUI.comment(FUContactNameExist)

WebUI.verifyEqual(FUContactName, FUContactNameExist)

//Client Name
String FUClientNameExist = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Text - Client Name'))

WebUI.comment(FUClientName)

WebUI.comment(FUClientNameExist)

WebUI.verifyEqual(FUClientName, FUClientNameExist)

//Member Name 
String FUMemberNameExist = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Text - Member Name'))

WebUI.comment(FUMemberName)

WebUI.comment(FUMemberNameExist)

WebUI.verifyEqual(FUMemberName, FUMemberNameExist)

//=== Guarantee Letter ===
boolean ButtonVerifyGL = WebUI.waitForElementVisible(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Guarantee Letter/Button - Verify'), 
    1, FailureHandling.OPTIONAL)

if (!(ButtonVerifyGL)) {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Menu - Guarantee Letter'))
}

//Member
String MemberNameExist = WebUI.getAttribute(findTestObject('Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Guarantee Letter/Patient Information/Input - Member'), 
    'value')

WebUI.verifyEqual(MemberName, MemberNameExist)

//Patient / Family Phone No
String PatientFamilyPhoneNoExist = WebUI.getAttribute(findTestObject('Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Guarantee Letter/Patient Information/Input - Patient Family Phone No'), 'value')

WebUI.verifyEqual(GlobalVariable.PhoneNumber, PatientFamilyPhoneNoExist)

//Product Type
String ProductTypeExist = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Guarantee Letter/Patient Information/Combo - Product Type'))

WebUI.verifyEqual(ProductType, ProductTypeExist)

//GL Type
String GLTypeExist = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Guarantee Letter/Patient Information/Combo - GL Type'))

WebUI.verifyEqual(GLType, GLTypeExist)

//Provider
String ProviderExist = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Guarantee Letter/Provider Information/Input - Provider'), 
    'value')

WebUI.verifyEqual(Provider, ProviderExist)

//Email
String EmailExist = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Guarantee Letter/Provider Information/Input - Email'), 
    'value')

WebUI.verifyEqual(GlobalVariable.Email, EmailExist)

//Phone
String PhoneExist = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Guarantee Letter/Provider Information/Input - Phone'), 
    'value')

WebUI.verifyEqual(GlobalVariable.PhoneNumber, PhoneExist)

//Room Option / Availability
String RoomOptionAvailabilityExist = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Guarantee Letter/Room Information/Combo - Room Option Availability'))

WebUI.verifyEqual(RoomOptionAvailability, RoomOptionAvailabilityExist)

//Action
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Guarantee Letter/Button - Verify'))

//=== Diagnosis Confirmation ===
if (DiagnosisConfirmation == 'New') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Button - New Diagnosis Confirmation'))

    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Combo - PIC'))

    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Combo List - PIC', 
            [('value') : PIC]))

    GEN5.ProcessingCommand()

    if (PIC == 'Account Manager') {
    } else if (PIC == 'Provider' || PIC == 'Doctor' && DocTypeCL == 'Yes') {
		
		
    } else if (PIC == 'Contact Center') {
	
    } else if (PIC == 'Doctor') {
		//Doctor Name
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Combo - Doctor Name'))
		
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Combo List - Doctor Name', [('value') : DoctorName]))
		
		//Date Time Confirmation
		
		//Confirmation
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Combo - Confirmation'))
		
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Combo List - Confirmation', [('value') : Confirmation]))
		
		//Channel
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Combo - Channel'))
		
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Combo List - Channel', [('value') : Channel]))
		
		//Benefit Coverage
		if (Confirmation != 'Need Confirmation Letter') {
			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Combo - Benefit Coverage'))
		
			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Combo List - Benefit Coverage', [('value') : BenefitCoverage]))
		}
		
		//Remarks
		if (Remarks == 'Yes' && Confirmation != 'Need Confirmation Letter') {
			WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Input - Remarks'), RemarksValue)
		}
		
		//Documents
		if (Confirmation == 'Need Confirmation Letter') {
			if (Document == 'New') {
				WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Button - Document Create New'))
				
				WebUI.click(null)
			}
		}
		
		
		
		//Action Add Confirmation
		if (ActionAC == 'Save') {
			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Button - Save'))
		} else if (ActionAC == 'Cancel') {
			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Button - Cancel')) 
		}
	
    } else if (PIC == 'Head Contact Center') {
        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Head CCO/Combo - Head CCO'))

        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Head CCO/Combo List - Head CCO', 
                [('value') : HeadCCO]))

        if (EditDateTimeConfirmation == 'Yes') {
            WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Head CCO/Date Picker - Date Time Confirmation'))

            GEN5.DatePicker(DTC, null)
        }
    }
} else if (DiagnosisConfirmation == 'Edit') {
} else if (DiagnosisConfirmation == 'Delete') {
}

