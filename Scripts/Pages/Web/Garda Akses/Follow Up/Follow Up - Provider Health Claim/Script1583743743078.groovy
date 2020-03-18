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
import com.keyword.UI as UI

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

//Client Name
String FUClientNameExist = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Text - Client Name'))

//Member Name 
String FUMemberNameExist = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Text - Member Name'))

while (FUContactNameExist != FUContactName || FUClientNameExist != FUClientName || FUMemberNameExist != FUMemberName) {
	
	QueryFinish = 'UPDATE dbo.CALLIN SET CallStatus = \'Finished\' WHERE TrID in (\''+ GlobalVariable.TrID1 +'\')'
	
	GEN5.updateValueDatabase("172.16.94.70", "SEA", "QueryFinish")
	
	QueryUpdatePIC = 'UPDATE  ContactCenter.FollowUpTicketHistory SET UserID = \'LKT\' WHERE FollowUpTicketHistoryID IN ( \'' + GlobalVariable.TrID1 +'\')'
	
	GEN5.updateValueDatabase("172.16.94.70", "SEA", "QueryUpdatePIC")

	WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Login/Login'), [('UserID') : UserIDFU, ('Password') : PasswordFU])
	
	WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Home/Home'), [('Menu') : MenuFU, ('SubMenu') : SubMenuFU])
	
	WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Follow Up/Follow Up - Inquiry'),
		[('FUContactName') : FUContactName
			, ('FUClientName') : FUClientName
			, ('FUMemberName') : FUMemberName])
		
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
	FUContactNameExist = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Text - Contact Name'))
	
	//Client Name
	FUClientNameExist = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Text - Client Name'))
	
	//Member Name
	FUMemberNameExist = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Text - Member Name'))	
}
	
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

GEN5.ProcessingCommand()

//Diagnosis
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis/Combo - Coverage'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis/Combo List - Coverage',[('value') : Coverage]))

//=== Diagnosis Confirmation ===
def PICSize = PIC.size()

for (i = 0; i < PICSize; i++) {
	if (DiagnosisConfirmation == 'New') {
		WebUI.scrollToElement(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Button - New Diagnosis Confirmation'), 2)
		
	    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Button - New Diagnosis Confirmation'))
		
		GEN5.ProcessingCommand()
	
	    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Combo - PIC'))
	
	    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Combo List - PIC', 
	            [('value') : PIC[i]]))
	
	    GEN5.ProcessingCommand()
	
	    if (PIC[i] == 'Account Manager') {
			
	    } else if (PIC[i] == 'Provider') {
			//Confirmation
			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Combo - Confirmation'))
			
			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Combo List - Confirmation', [('value') : Confirmation[i]]))
			
			//Channel
			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Combo - Channel'))
			
			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Combo List - Channel', [('value') : Channel]))
			
			//Documents
			if (Documents == 'New') {
				WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Button - Document Create New'))
				
				//Documents Type
				WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Upload Document/Combo - Document Type'))
				
				WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Upload Document/Combo List Search - Documents Type'), DocumentsType)
				
				WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Upload Document/Combo List - Documents Type', [('value') : DocumentsType]))
				
				//Documents Validity
				WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Upload Document/Combo - Documents Validity'))
				
				WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Upload Document/Combo List - Documents Validity', [('value') : DocumentsValidity]))
				
				//Confirmation Letter Type
				if (DocumentsType == 'Confirmation Letter') {
					WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Upload Document/Combo - Confirmation Letter Type'))
					
					WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Upload Document/Combo List Search - Confirmation Letter Type'), ConfirmationLetterType)
					
					WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Upload Document/Combo List - Confirmation Letter Type', [('value') : ConfirmationLetterType]))
				}
				
				//Browse
				WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Upload Document/Button - Browse'))
				
				WebUI.delay(GlobalVariable.Delay1)
				
				UI.UploadFile("\\\\it-repository\\ProjectDocuments\\Katalon Garda Akses", FileDocument)
				
				//Upload
				WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Upload Document/Button - Upload'))
				
				//Save
				WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Upload Document/Button - Save'))
			
			} else if (Documents == 'Edit') {
			
			} else if (Documents == 'Delete') {
			
			}
				
			WebUI.scrollToElement(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Button - Save'), 2)
			
			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Button - Save'))
			
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Text - Insert Successfully'), 1)
			
			GEN5.ProcessingCommand()
		} else if (PIC[i] == 'Contact Center') {
		
	    } else if (PIC[i] == 'Doctor') {
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
			
			//Remarks
			if (Remarks == 'Yes') {
				WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Input - Remarks'), RemarksValue)
			}
			
			//Documents
			if (Confirmation == 'Need Confirmation Letter') {
				if (Document == 'New') {
					WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Button - Document Create New'))
					
					//Confirmation Letter Type
					WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Combo - Confirmation Letter Type'))
					
					WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Combo List Search - Confirmation Letter Type'), ConfirmationLetterType)
					
					WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Combo List - Confirmation Letter Type', [('value') : ConfirmationLetterType]))
					
					//Mandatory
					WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Combo - Mandatory'))
					
					WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Combo List - Mandatory', [('value') : Mandatory]))
					
					//Save
					WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Doctor/Button - Save'))
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
}

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim/Follow Up Outbound/Diagnosis Confirmation/Add Confirmation/Provider/Button - Save'))