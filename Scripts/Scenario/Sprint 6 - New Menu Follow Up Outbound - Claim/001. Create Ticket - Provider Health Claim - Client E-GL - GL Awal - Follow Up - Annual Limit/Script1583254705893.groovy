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

String MemberName = '00091 - A/00136451 - ANANG MAZFUAD - PT Sahabat Finansial Keluarga'

//String MemberName = '00003 - M/00080165 - MUHAMMAD KURNIAWAN - PT Sahabat Finansial Keluarga'

//String MemberName = '00038 - L/00016180 - LIM BUI HO - PT Sahabat Finansial Keluarga'

String ProductType = 'Inpatient'

String GLType = 'Awal'

String EditTreatmentPeriodStart = 'Yes'

String TreatmentPeriodStart = '23/Feb/2020'

String EditTreatmentPeriodEnd = 'No'

String SpecialCondition = 'No'

String SpecialConditionReason = ''

ArrayList StatusDiagnosa = ['Initial Primary']

ArrayList DiagnosisID = ['A09']

String DoctorName = 'Automation Doctor - Me'

String Rujuk = 'No'

String Reason = ''

String AppropriateRBClass = 'STANDARD'

String TreatmentRBClass = 'STANDARD'

String RoomOptionAvailability = 'NAPS - Room Not Available'

String NewDocument = 'No'

String EditDocument = 'No'

String DeleteDocument = 'No'

String ActionGL = 'Process'

String Validasi = GlobalVariable.ValidasiAnnualLimit

//Exit Confirmation
String ECAction1 = 'Tidak'

String ECAction2 = 'Puas'

String Comment = 'Currently testing by Automation. Thanks. Regards - Me'

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Login/Login'), 
	[('UserID') : UserID
		, ('Password') : Password])

//==================== PHASE 1 ====================
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Home/Home'), 
	[('Menu') : Menu
		, ('SubMenu') : SubMenu])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), 
	[('ContactLine') : ContactLine
		, ('Product') : Product
        , ('ChannelType') : ChannelType
		, ('ContactName') : ContactName
		, ('ContactType') : ContactType
		, ('ServiceType') : ServiceType
        , ('InterruptedCall') : InterruptedCall
		, ('ProviderName') : ProviderName
		, ('Action') : ActionCT])

CustomKeywords.'querySQL.Query.QueryContactName'()

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry'), 
	[('Phase') : '1'])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim'), 
	[('Member') : Member
		, ('MemberName') : MemberName
        , ('ProductType') : ProductType
		, ('GLType') : GLType
		, ('SpecialCondition') : SpecialCondition
		, ('EditTreatmentPeriodStart') : EditTreatmentPeriodStart
		, ('TreatmentPeriodStart') : TreatmentPeriodStart
		, ('EditTreatmentPeriodEnd') : EditTreatmentPeriodEnd
		, ('StatusDiagnosa') : StatusDiagnosa
        , ('DiagnosisID') : DiagnosisID
		, ('DoctorName') : DoctorName
		, ('Rujuk') : Rujuk
		, ('Reason') : Reason
		, ('SpecialCondition') : SpecialCondition
		, ('SpecialConditionReason') : SpecialConditionReason
		
		, ('AppropriateRBClass') : AppropriateRBClass
		, ('TreatmentRBClass') : TreatmentRBClass
		
		, ('RoomOptionAvailability') : RoomOptionAvailability
		, ('NewDocument') : NewDocument
		, ('EditDocument') : EditDocument
		, ('DeleteDocument') : DeleteDocument
		, ('ActionGL') : ActionGL
		, ('Validasi') : Validasi
		, ('Phase') : '1'])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Exit Confirmation/Exit Confirmation'), 
	[('ECAction1') : ECAction1
        , ('ECAction2') : ECAction2
		, ('Comment') : Comment])

WebUI.comment(GlobalVariable.TicketID1)