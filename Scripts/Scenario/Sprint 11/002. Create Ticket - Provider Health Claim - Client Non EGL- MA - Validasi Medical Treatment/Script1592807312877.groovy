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
//import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

//Login//
String UserID = 'LKT'

String Password = 'P@ssw0rd'

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

String ProviderName = 'OJKSH00001 SILOAM HOSPITALS KEBON JERUK'

String ActionCT = 'Next'

//Inquiry//
String Phase = '1'

//Claim
String Member = 'Existing' //Member = Existing  / New / Check

String MemberName = findTestData('MemberNameNonClientMA').getValue(1, 1)

String ProductType = 'Maternity (Persalinan)'

String GLType = 'Awal'

String EditTreatmentPeriodStart = 'No'

String EditTreatmentPeriodEnd = 'No'

String SpecialCondition = 'No'

String SpecialConditionReason = ''

ArrayList Diagnosis = ['New']

ArrayList StatusDiagnosa = ['Initial Primary (Diagnosa Utama)']

ArrayList DiagnosisID = ['O82']

String Gravida = '1'

String Partus = '0'

String Abortus = '0'

String GestationalAge = '34'

String RemarksDiagnosa = 'Testing Diagnosis - Katalon'

String DiagnosisQuestion = 'Kepala bayi masih diatas PAP pada BSC 1x'

String RemarksDiagnosis = 'Testing Additional Info - Katalon'

String MaternityTreatment = 'Persalinan Caesar'

String DoctorName = 'Automation Doctor - Me'

String Rujuk = 'No'

String Reason = ''

ArrayList MTTindakanMedis = ['New']

ArrayList MTDiagnosis = ['SINGLE DELIVERY BY CAESAREAN SECTION']

ArrayList MedicalTreatment = ['']

String UnregisteredMT = 'tindakan tambahan caesar'

String Billed = '15000000'

String AppropriateRBClass = 'VVIP'

String TreatmentRBClass = 'VVIP'

String RoomOptionAvailability = 'On Plan'

String PackagePrice = '1000000'

String TotalBilled = '1000000'

String NeedFollowUp = 'Yes'

String NewDocument = 'No'

String EditDocument = 'No'

String DeleteDocument = 'No'

String ActionGL = 'Process'

ArrayList Validasi = [GlobalVariable.ValidasiMedicalTreatment]

//Exit Confirmation
String ECAction1 = 'Tidak'

String ECAction2 = 'Puas'

String Comment = 'Currently testing by Automation. Thanks. Regards - Me'

//Login
String UserIDFU = 'LKT'

String PasswordFU = 'P@ssw0rd'

//Home
String MenuFU = 'General'

String SubMenuFU = 'Follow Up'

//Follow Up
String FUContactName = 'Siloam Hospitals Kebon Jeruk'

String FUClientName = findTestData('MemberNameLineX').getValue(5, 1)

String FUMemberName = findTestData('MemberNameLineX').getValue(4, 1)

String DiagnosisConfirmation = 'New'

String PIC = 'Doctor'

String EditDateTimeConfirmation = 'No'

String DTC = null

String Confirmation = ''



//Script//
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Login/Login'), [('UserID') : UserID, ('Password') : Password])

//==================== PHASE 1 ====================
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Home/Home'), [('Menu') : Menu, ('SubMenu') : SubMenu])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
		, ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
		, ('InterruptedCall') : InterruptedCall, ('ProviderName') : ProviderName, ('Action') : ActionCT])

CustomKeywords.'querySQL.Query.QueryContactName'()

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry'), [('Phase') : '1'])

WebUI.comment(MemberName)

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim'), [('Member') : Member, ('MemberName') : MemberName
		, ('ProductType') : ProductType, ('GLType') : GLType, ('SpecialCondition') : SpecialCondition, ('EditTreatmentPeriodStart') : EditTreatmentPeriodStart
		, ('EditTreatmentPeriodEnd') : EditTreatmentPeriodEnd, ('Diagnosis') : Diagnosis, ('StatusDiagnosa') : StatusDiagnosa
		, ('DiagnosisID') : DiagnosisID, ('Gravida') : Gravida, ('Partus') : Partus, ('Abortus') : Abortus, ('GestationalAge') : GestationalAge
		, ('RemarksDiagnosa') : RemarksDiagnosa, ('DiagnosisQuestion') : DiagnosisQuestion, ('RemarksDiagnosis') : RemarksDiagnosis
		, ('MaternityTreatment') : MaternityTreatment, ('DoctorName') : DoctorName, ('Rujuk') : Rujuk, ('Reason') : Reason, ('SpecialCondition') : SpecialCondition
		, ('MTTindakanMedis') : MTTindakanMedis, ('MTDiagnosis') : MTDiagnosis, ('MedicalTreatment') : MedicalTreatment, ('UnregisteredMT') : UnregisteredMT, ('Billed') : Billed
		, ('AppropriateRBClass') : AppropriateRBClass
		, ('TreatmentRBClass') : TreatmentRBClass, ('AppropriateRBClass') : AppropriateRBClass, ('TreatmentRBClass') : TreatmentRBClass
		, ('SpecialConditionReason') : SpecialConditionReason, ('RoomOptionAvailability') : RoomOptionAvailability, ('PackagePrice') : PackagePrice
		, ('NewDocument') : NewDocument, ('EditDocument') : EditDocument, ('DeleteDocument') : DeleteDocument, ('ActionGL') : ActionGL
		, ('Validasi') : Validasi, ('Phase') : '1'])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Exit Confirmation/Exit Confirmation'), [('ECAction1') : ECAction1
		, ('ECAction2') : ECAction2, ('Comment') : Comment])

WebUI.comment(GlobalVariable.TicketID1)

String URL = '172.16.94.70'

String DB_Name = 'SEA'

String Query = ('SELECT UPPER(CONCAT(RTRIM(ProviderID), SPACE(1), \'-\', SPACE(1), RTRIM(( ProviderName )))) AS ProviderName, ProviderPhoneNo AS ProviderPhoneNo, ProviderEmail AS ProviderEmail, TicketNo AS TicketNo, UPPER(CONCAT(RTRIM(EmpID), SPACE(1), \'-\', SPACE(1), RTRIM(LTRIM(MemberNo)), SPACE(1), \'-\', SPACE(1), RTRIM(MemberName), SPACE(1), \'-\', SPACE(1), RTRIM(ClientName))) AS MemberName, FamilyPhone AS FamilyPhone, Doctor AS Doctor FROM CONTACTCENTER.TempGL WHERE TicketNo = \'' +
GlobalVariable.TicketID1) + '\' ORDER BY CreatedDate DESC'

ArrayList VerifyTicket1 = [ProviderName, GlobalVariable.PhoneNumber, GlobalVariable.Email, GlobalVariable.TicketID1, MemberName
	, GlobalVariable.PhoneNumber, DoctorName]

GEN5.compareRowDBtoArray(URL, DB_Name, Query, VerifyTicket1)

WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Login/Login'), [('UserID') : UserIDFU, ('Password') : PasswordFU])

WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Home/Home'), [('Menu') : MenuFU, ('SubMenu') : SubMenuFU])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Follow Up/Follow Up - Inquiry'),
	[('FUContactName') : FUContactName
		, ('FUClientName') : FUClientName
		, ('FUMemberName') : FUMemberName])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Follow Up/Follow Up - Provider Health Claim'),
	[('Phase') : '1'
		, ('FUContactName') : FUContactName
		, ('FUClientName') : FUClientName
		, ('FUMemberName') : FUMemberName
		, ('MemberName') : MemberName
		, ('ProductType') : ProductType
		, ('GLType') : GLType
		, ('Provider') : ProviderName
		, ('RoomOptionAvailability') : RoomOptionAvailability
		//=== Batas Default Variable Follow Up ===//
//		, ('DiagnosisConfirmation') : DiagnosisConfirmation
//		, ('PIC') : PIC
//		, ('DoctorName') : DoctorName
//		, ('EditDateTimeConfirmation') : EditDateTimeConfirmation
//		, ('DTC') : DTC
		])