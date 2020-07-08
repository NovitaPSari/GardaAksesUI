import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
//import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
//import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.keyword.GEN5 as GEN5
import com.keyword.UI as UI

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

//String ContactName = findTestData('ContactName').getValue(1, 1)

String ContactName = 'Treatment Detail NBH 1'

String ContactType = 'Lainnya'

String ServiceType = 'Claim'

String InterruptedCall = 'No'

String ProviderName = 'OJKSH00001 SILOAM HOSPITALS KEBON JERUK'

String ActionCT = 'Next'

//Inquiry//
String Phase = '1'

//Claim
String Member = 'Existing' //Member = Existing  / New / Check

//String MemberName = findTestData('MemberNameSahabatFinansialKeluarga').getValue(1, 1)

String MemberName = '2000123 - R/00113893 - RAHMA YULIZA S.SO - DENSO INDONESIA - SUNTER'

//String MemberName = MembesrNameDB[i]

String ProductType = 'Maternity (Persalinan)'

String GLType = 'Akhir'

String EditTreatmentPeriodStart = 'No'

String TreatmentPeriodStart = '27/Feb/2020'

String EditTreatmentPeriodEnd = 'No'

String SpecialCondition = 'No'

String SpecialConditionReason = ''

ArrayList Diagnosis = ['New', 'New']

ArrayList StatusDiagnosa = ['Initial Primary (Diagnosa Utama)', 'Initial Secondary (Diagnosa Tambahan)']

ArrayList DiagnosisID = ['O80', 'B00']

String Gravida = '1'

String Partus = '0'

String Abortus = '1'

String GestationalAge = '12'

String RemarksDiagnosa = 'Currently testing Remarks Diagnosa by Automation. Thanks. Regards - Me'

String DiagnosisQuestion = 'Kepala bayi masih diatas PAP pada BSC 1x'

String RemarksDiagnosis = 'Testing Additional Info - Katalon'

String MaternityTreatment = 'Caesarean Delivery'

String DoctorName = 'Irna Putri Perdana'

String Rujuk = 'No'

String Reason = ''

String TotalBilled = ''

String AppropriateRBClass = 'STANDARD'

String TreatmentRBClass = 'STANDARD'

String RoomOptionAvailability = 'On Plan'

String PackagePrice = '123456'

String NeedFollowUp = ''

String NewDocument = 'No'

String EditDocument = 'No'

String DeleteDocument = 'No'

String ActionGL = 'Process'

ArrayList Validasi = [GlobalVariable.ValidasiDiagnosa]

//Exit Confirmation
String ECAction1 = 'Tidak'

String ECAction2 = 'Puas'

String Comment = 'Currently testing by Automation. Thanks. Regards - Me'

ArrayList ValidasiFU = [GlobalVariable.ValidasiDijaminkan]

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Login/Login'), [('UserID') : UserID, ('Password') : Password])

//==================== PHASE 1 ====================
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Home/Home'), [('Menu') : Menu, ('SubMenu') : SubMenu])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
        , ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
        , ('InterruptedCall') : InterruptedCall, ('ProviderName') : ProviderName, ('Action') : ActionCT])

CustomKeywords.'querySQL.Query.QueryContactName'()

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry'), [('Phase') : '1'])

//WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim'), [('Member') : Member, ('MemberName') : MemberName
//        , ('ProductType') : ProductType, ('GLType') : GLType, ('SpecialCondition') : SpecialCondition, ('EditTreatmentPeriodStart') : EditTreatmentPeriodStart
//        , ('EditTreatmentPeriodEnd') : EditTreatmentPeriodEnd, ('Diagnosis') : Diagnosis, ('StatusDiagnosa') : StatusDiagnosa
//        , ('DiagnosisID') : DiagnosisID, ('RemarksDiagnosa') : RemarksDiagnosa, ('DoctorName') : DoctorName, ('TotalBilled') : TotalBilled
//        , ('Rujuk') : Rujuk, ('Reason') : Reason, ('SpecialCondition') : SpecialCondition, ('SpecialConditionReason') : SpecialConditionReason
//        , ('AppropriateRBClass') : AppropriateRBClass, ('TreatmentRBClass') : TreatmentRBClass, ('RoomOptionAvailability') : RoomOptionAvailability
//        , ('NeedFollowUp') : NeedFollowUp, ('NewDocument') : NewDocument, ('EditDocument') : EditDocument, ('DeleteDocument') : DeleteDocument
//        , ('ActionGL') : ActionGL, ('Validasi') : Validasi, ('Phase') : '1'])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim'), [('Member') : Member, ('MemberName') : MemberName
	, ('ProductType') : ProductType, ('GLType') : GLType, ('SpecialCondition') : SpecialCondition, ('EditTreatmentPeriodStart') : EditTreatmentPeriodStart
	, ('TreatmentPeriodStart') : TreatmentPeriodStart, ('EditTreatmentPeriodEnd') : EditTreatmentPeriodEnd, ('Diagnosis') : Diagnosis, ('StatusDiagnosa') : StatusDiagnosa
	, ('DiagnosisID') : DiagnosisID, ('Gravida') : Gravida, ('Partus') : Partus, ('Abortus') : Abortus, ('GestationalAge') : GestationalAge
	, ('RemarksDiagnosa') : RemarksDiagnosa, ('DiagnosisQuestion') : DiagnosisQuestion, ('RemarksDiagnosis') : RemarksDiagnosis, ('MaternityTreatment') : MaternityTreatment
	, ('DoctorName') : DoctorName, ('Rujuk') : Rujuk, ('Reason') : Reason, ('SpecialCondition') : SpecialCondition, ('AppropriateRBClass') : AppropriateRBClass
	, ('TreatmentRBClass') : TreatmentRBClass, ('AppropriateRBClass') : AppropriateRBClass, ('TreatmentRBClass') : TreatmentRBClass
	, ('SpecialConditionReason') : SpecialConditionReason, ('RoomOptionAvailability') : RoomOptionAvailability, ('PackagePrice') : PackagePrice
	, ('NewDocument') : NewDocument, ('EditDocument') : EditDocument, ('DeleteDocument') : DeleteDocument, ('ActionGL') : ActionGL
	, ('Validasi') : Validasi, ('Phase') : '1'])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Exit Confirmation/Exit Confirmation'), [('ECAction1') : ECAction1
        , ('ECAction2') : ECAction2, ('Comment') : Comment])

WebUI.comment(MemberName)

WebUI.comment(GlobalVariable.TicketID1)

