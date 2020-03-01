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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

//Login//
String UserID = 'DNS'

String Password = 'Password95'

//Home
String Menu = 'General'

String SubMenu = 'Create Ticket'

//Create Ticket//
String ContactLine = 'Provider'

String Product = 'Health'

String ChannelType = 'Call'

String ContactName = findTestData('ContactName').getValue(1, 1)

String ContactType = 'Farmasi'

String ServiceType = 'Claim'

String InterruptedCall = 'No'

String ProviderName = 'OJKSH00001'

String ActionCT = 'Next'

//Inquiry//
String Phase = '1'

//Claim
String Member = 'Existing' //Member = Existing  / New / Check

String MemberName = findTestData('MemberNameClient').getValue(1, 1)

String ProductType = 'Inpatient'

String GLType = 'Awal'

String EditTreatmentPeriodStart = 'No'

String EditTreatmentPeriodEnd = 'No'

String SpecialCondition = 'No'

String SpecialConditionReason = ''

String StatusDiagnosaP = 'Initial Primary'

String DiagnosisID = 'B00 HERPESVIRAL (HERPES SIMPLEX) INFECTIOUS'

String DoctorName = 'Automation Doctor - Me'

String Rujuk = 'No'

String Reason = ''

String RoomOptionAvailability = 'On Plan'

String TotalBilled = '1000000'

String NewDocument = 'No'

String EditDocument = 'No'

String DeleteDocument = 'No'

String ActionGL = 'Process'

String Validasi = GlobalVariable.ValidasiDiagnosa

//Phase 2
String Member2 = 'Check Member'

String StatusDiagnosaS = 'Initial Secondary'

String DiagnosisID2 = 'A09'

String ActionGL2 = 'Reject'

String Validasi2 = GlobalVariable.ValidasiReject



//Exit Confirmation
String ECAction1 = 'Tidak'

String ECAction2 = 'Puas'

String Comment = 'Currently testing by Automation. Thanks. Regards - Me'

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Login/Login'), [('UserID') : UserID, ('Password') : Password])

//==================== PHASE 1 ====================
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Home/Home'), [('Menu') : Menu, ('SubMenu') : SubMenu])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
        , ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
        , ('InterruptedCall') : InterruptedCall, ('ProviderName') : ProviderName, ('Action') : ActionCT])

CustomKeywords.'querySQL.Query.QueryContactName'()

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry'), [('Phase') : '1'])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim'), [('Member') : Member, ('MemberName') : MemberName
        , ('ProductType') : ProductType, ('GLType') : GLType, ('SpecialCondition') : SpecialCondition, ('EditTreatmentPeriodStart') : EditTreatmentPeriodStart
        , ('EditTreatmentPeriodEnd') : EditTreatmentPeriodEnd, ('StatusDiagnosa') : StatusDiagnosaP, ('DiagnosisID') : DiagnosisID
        , ('DoctorName') : DoctorName, ('Rujuk') : Rujuk, ('Reason') : Reason, ('SpecialCondition') : SpecialCondition, ('SpecialConditionReason') : SpecialConditionReason
        , ('RoomOptionAvailability') : RoomOptionAvailability, ('NewDocument') : NewDocument, ('EditDocument') : EditDocument
        , ('DeleteDocument') : DeleteDocument, ('ActionGL') : ActionGL, ('Validasi') : Validasi, ('Phase') : '1'])

WebUI.comment(GlobalVariable.TicketID1)

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Exit Confirmation/Exit Confirmation'), [('ECAction1') : ECAction1
        , ('ECAction2') : ECAction2, ('Comment') : Comment])

//==================== PHASE 2 ====================
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Home/Home'), [('SubMenu') : SubMenu])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
        , ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
        , ('InterruptedCall') : InterruptedCall, ('ProviderName') : ProviderName, ('Action') : ActionCT])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry'), [('Phase') : '2'])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim'), 
	[('Member') : Member2
		, ('MemberName') : MemberName
        , ('ProductType') : ProductType
		, ('GLType') : GLType
		, ('SpecialCondition') : SpecialCondition
		, ('EditTreatmentPeriodStart') : EditTreatmentPeriodStart
        , ('EditTreatmentPeriodEnd') : EditTreatmentPeriodEnd
		, ('StatusDiagnosa') : StatusDiagnosaS
		, ('DiagnosisID') : DiagnosisID2
        , ('DoctorName') : DoctorName
		, ('Rujuk') : Rujuk
		, ('Reason') : Reason
		, ('SpecialCondition') : SpecialCondition
		, ('SpecialConditionReason') : SpecialConditionReason
        , ('RoomOptionAvailability') : RoomOptionAvailability
		, ('NewDocument') : NewDocument
		, ('EditDocument') : EditDocument
        , ('DeleteDocument') : DeleteDocument
		, ('ActionGL') : ActionGL2
		, ('Validasi') : Validasi2
		, ('Phase') : '2'])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Exit Confirmation/Exit Confirmation'), [('ECAction1') : ECAction1
        , ('ECAction2') : ECAction2, ('Comment') : Comment])

WebUI.comment(GlobalVariable.TicketID2)