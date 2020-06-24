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
import com.keyword.GEN5

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

String ProviderName = 'OJKSH00001 SILOAM HOSPITALS KEBON JERUK'

String ValidasiProviderName = 'OJKSH00001 - SILOAM HOSPITALS KEBON JERUK'

String ActionCT = 'Next'

//Inquiry//
String Phase = '1'

//Claim
String Member = 'New' //Member = Existing  / New / Check

String NewMemberType = 'Employee'

String NewMemberName = findTestData('NewMemberName').getValue(1, 1)

String ClientName = 'PT Ardendi Jaya Sentosa'

String EmployeeID = findTestData('NewEmployeeID').getValue(1, 1)

String DOB = '01/Aug/2019'

String Gender = 'Female'

String ProductType = 'Maternity (Persalinan)'

String GLType = 'Awal'

String EditTreatmentPeriodStart = 'No'

String EditTreatmentPeriodEnd = 'No'

String SpecialCondition = 'No'

String SpecialConditionReason = ''

ArrayList Diagnosis = ['New']

ArrayList StatusDiagnosaP = ['Initial Primary (Diagnosa Utama)']

ArrayList DiagnosisID = ['O80 SINGLE SPONTANEOUS DELIVERY/NORMAL DELIVERY']

String Gravida = '1'

String Partus = '1'

String Abortus = '1'

String GestationalAge = '20'

String RemarksDiagnosa = 'Testing New Member MA Client E-GL - Katalon'

String DiagnosisQuestion = ''

String RemarksDiagnosis = ''

String MaternityTreatment = 'Persalinan Normal dengan Dokter'

String DoctorName = 'Automation Doctor - Me'

String Rujuk = 'No'

String Reason = ''

String AppropriateRBClass = 'BASIC'

String TreatmentRBClass = 'BASIC'

String RoomOptionAvailability = 'On Plan'

String PackagePrice = '1000000'

String TotalBilled = '1000000'

String NewDocument = 'No'

String EditDocument = 'No'

String DeleteDocument = 'No'

String ActionGL = 'Process'

ArrayList Validasi = [GlobalVariable.ValidasiNewMember]

////Phase 2
//String Member2 = 'Check New Member'
//
//String AccountManager = 'Automation NBH'
//
//ArrayList Validasi2 = [GlobalVariable.ValidasiDijaminkan]

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

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim'),
	[('Member') : Member
		, ('NewMemberType') : NewMemberType
		, ('NewMemberName') : NewMemberName
		, ('ClientName') : ClientName
		, ('EmployeeID') : EmployeeID
		, ('DOB') : DOB
		, ('Gender') : Gender
		, ('ProductType') : ProductType
		, ('GLType') : GLType
		, ('SpecialCondition') : SpecialCondition
		, ('EditTreatmentPeriodStart') : EditTreatmentPeriodStart
		, ('EditTreatmentPeriodEnd') : EditTreatmentPeriodEnd
		, ('Diagnosis') : Diagnosis
		, ('StatusDiagnosa') : StatusDiagnosaP
		, ('DiagnosisID') : DiagnosisID
		, ('Gravida') : Gravida
		, ('Partus') : Partus
		, ('Abortus') : Abortus
		, ('GestationalAge') : GestationalAge
        , ('RemarksDiagnosa') : RemarksDiagnosa
		, ('DiagnosisQuestion') : DiagnosisQuestion
		, ('RemarksDiagnosis') : RemarksDiagnosis
		, ('MaternityTreatment') : MaternityTreatment
		, ('DoctorName') : DoctorName
		, ('Rujuk') : Rujuk
		, ('Reason') : Reason
		, ('SpecialCondition') : SpecialCondition
		, ('SpecialConditionReason') : SpecialConditionReason
		, ('AppropriateRBClass') : AppropriateRBClass
		, ('TreatmentRBClass') : TreatmentRBClass
		, ('RoomOptionAvailability') : RoomOptionAvailability
		, ('PackagePrice') : PackagePrice
		, ('NewDocument') : NewDocument
		, ('EditDocument') : EditDocument
		, ('DeleteDocument') : DeleteDocument
		, ('ActionGL') : ActionGL
		, ('Validasi') : Validasi
		, ('Phase') : '1'])

WebUI.comment(GlobalVariable.TicketID1)

CustomKeywords.'querySQL.Query.QueryContactName'()

CustomKeywords.'querySQL.Query.QueryEmployeeID'()

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Exit Confirmation/Exit Confirmation'), [('ECAction1') : ECAction1
        , ('ECAction2') : ECAction2, ('Comment') : Comment])

String URL = '172.16.94.70'
String DB_Name = 'SEA'
String Query = 'SELECT UPPER(CONCAT(RTRIM(ProviderID), SPACE(1), \'-\', SPACE(1), RTRIM(( ProviderName )))) AS ProviderName, ProviderPhoneNo AS ProviderPhoneNo, ProviderEmail AS ProviderEmail, TicketNo AS TicketNo, FamilyPhone AS FamilyPhone, Doctor AS Doctor FROM CONTACTCENTER.TempGL WHERE TicketNo = \'' + GlobalVariable.TicketID1 +'\' ORDER BY CreatedDate DESC'
ArrayList VerifyTicket1 = [ValidasiProviderName, GlobalVariable.PhoneNumber, GlobalVariable.Email, GlobalVariable.TicketID1, GlobalVariable.PhoneNumber, DoctorName]
GEN5.compareRowDBtoArray(URL, DB_Name, Query, VerifyTicket1)

//Phase 2
//WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Home/Home'), [('Menu') : Menu, ('SubMenu') : SubMenu])
//
//WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
//		, ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
//		, ('InterruptedCall') : InterruptedCall, ('ProviderName') : ProviderName, ('Action') : ActionCT])
//
//WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry'), [('Phase') : '2'])
//
//WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim'),
//	[('Member') : Member2
//		, ('ProductType') : ProductType
//		, ('GLType') : GLType
//		, ('SpecialCondition') : SpecialCondition
//		, ('EditTreatmentPeriodStart') : EditTreatmentPeriodStart
//		, ('EditTreatmentPeriodEnd') : EditTreatmentPeriodEnd
//		, ('StatusDiagnosa') : StatusDiagnosaP
//		, ('DiagnosisID') : DiagnosisID
//		, ('DoctorName') : DoctorName
//		, ('Rujuk') : Rujuk
//		, ('Reason') : Reason
//		, ('SpecialCondition') : SpecialCondition
//		, ('SpecialConditionReason') : SpecialConditionReason
//		, ('AppropriateRBClass') : AppropriateRBClass
//		, ('TreatmentRBClass') : TreatmentRBClass
//		, ('RoomOptionAvailability') : RoomOptionAvailability
//		, ('NewDocument') : NewDocument
//		, ('EditDocument') : EditDocument
//		, ('DeleteDocument') : DeleteDocument
//		, ('AccountManager') : AccountManager
//		, ('ActionGL') : ActionGL
//		, ('Validasi') : Validasi2
//		, ('Phase') : '2'])
//
//WebUI.comment(GlobalVariable.TicketID2)
//
//String Query2 = 'SELECT UPPER(CONCAT(RTRIM(ProviderID), SPACE(1), \'-\', SPACE(1), RTRIM(( ProviderName )))) AS ProviderName, ProviderPhoneNo AS ProviderPhoneNo, ProviderEmail AS ProviderEmail, TicketNo AS TicketNo, FamilyPhone AS FamilyPhone, Doctor AS Doctor FROM CONTACTCENTER.TempGL WHERE TicketNo = \'' + GlobalVariable.TicketID2 +'\' ORDER BY CreatedDate DESC'
//ArrayList VerifyTicket2 = [ProviderName, GlobalVariable.PhoneNumber, GlobalVariable.Email, GlobalVariable.TicketID2, GlobalVariable.PhoneNumber, DoctorName]
//GEN5.compareRowDBtoArray(URL, DB_Name, Query2, VerifyTicket2)
//
//WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Exit Confirmation/Exit Confirmation'), [('ECAction1') : ECAction1
//		, ('ECAction2') : ECAction2, ('Comment') : Comment])