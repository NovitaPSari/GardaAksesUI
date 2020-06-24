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

String ContactName = 'FU Diagnosa CCO 5'

String ContactType = 'Lainnya'

String ServiceType = 'Claim'

String InterruptedCall = 'No'

String ProviderName = 'OJKSH00001 SILOAM HOSPITALS KEBON JERUK'

String ActionCT = 'Next'

//Inquiry//
String Phase = '1'

//Claim
String Member = 'Existing' //Member = Existing  / New / Check

//def QueryMember = 'SELECT TOP 100 UPPER(CONCAT(RTRIM(c.EmpID), SPACE(1), \'-\', SPACE(1), RTRIM(LTRIM(c.MemberNo)), SPACE(1), \'-\', SPACE(1), RTRIM(c.Name), SPACE(1), \'-\', SPACE(1), RTRIM(a.Name))) AS DataDescription FROM profile a INNER JOIN policy b ON a.id = b.clientid INNER JOIN policy_member c ON b.pno = c.pno INNER JOIN Policy_Member_Plan PMP ON b.PNO = PMP.PNO AND c.MNO = PMP.MNO AND PMP.ExcludeF = 0 LEFT JOIN Policy_Plan_Schedule PPS ON PPS.PNO = C.PNO AND pmp.PPlan = PPS.PPlan AND pmp.BAmount = PPS.BAmount INNER JOIN Policy_Classification PC ON B.PNO = PC.PNO AND C.CLASSNO = PC.CLASSNO INNER JOIN PPlan PP ON PMP.PPlan = PP.PPlan INNER JOIN Product Pr ON PP.ProductID = Pr.ProductID LEFT JOIN (SELECT DISTINCT pm.memberno FROM claimh ch INNER JOIN policy_member pm ON ch.MNO = pm.MNo WHERE CAST(GETDATE() AS DATE) BETWEEN start AND finish) X ON X.MemberNo = C.MemberNo LEFT JOIN TREATMENTROOMMODEL TRM ON TRM.CLIENTID = B.CLIENTID WHERE B.PStatus <> \'O\' AND C.MemberNo <> \'\' AND B.EffectiveDate >= \'2013-01-01\' AND CAST(GETDATE() AS DATE) BETWEEN c.PDate AND C.PPDate AND b.RenewalDate >= CAST(GETDATE() - 14 AS DATE) AND X.MemberNo IS NULL AND TRM.CLIENTID IS NOT NULL AND pr.ProductType = \'IP\' AND a.Name LIKE \'%PT Sahabat Finansial Keluarga\' GROUP BY c.MemberNo, c.Name, c.EmpID, a.Name, a.ID'

//ArrayList MemberNameDB = GEN5.getOneColumnDatabase('172.16.94.70', 'SEA', QueryMember, 'DataDescription')

String MemberName = findTestData('MemberNameSahabatFinansialKeluarga').getValue(1, 1)

//String MemberName = MembesrNameDB[i]

String ProductType = 'Inpatient (Rawat Inap)'

String GLType = 'Awal'

String EditTreatmentPeriodStart = 'No'

String TreatmentPeriodStart = '27/Feb/2020'

String EditTreatmentPeriodEnd = 'No'

String SpecialCondition = 'No'

String SpecialConditionReason = ''

ArrayList Diagnosis = ['New']

ArrayList StatusDiagnosa = ['Initial Primary (Diagnosa Utama)']

ArrayList DiagnosisID = ['B00 HERPESVIRAL (HERPES SIMPLEX) INFECTIOUS']

String RemarksDiagnosa = 'Currently testing Remarks Diagnosa by Automation. Thanks. Regards - Me'

String DoctorName = 'Irna Putri Perdana'

String Rujuk = 'No'

String Reason = ''

String AppropriateRBClass = 'STANDARD'

String TreatmentRBClass = 'STANDARD'

String RoomOptionAvailability = 'On Plan'

String NewDocument = 'No'

String EditDocument = 'No'

String DeleteDocument = 'No'

String ActionGL = 'Process'

ArrayList Validasi = [GlobalVariable.ValidasiDiagnosa]

//Exit Confirmation
String ECAction1 = 'Tidak'

String ECAction2 = 'Puas'

String Comment = 'Currently testing by Automation. Thanks. Regards - Me'

//Login
String UserIDFU = 'LSO'

String PasswordFU = 'P@ssw0rd'

//Home
String MenuFU = 'General'

String SubMenuFU = 'Follow Up'

//Follow Up 
String FUContactName = 'Siloam Hospitals Kebon Jeruk'

String FUClientName = findTestData('MemberNameSahabatFinansialKeluarga').getValue(5, 1)

String FUMemberName = findTestData('MemberNameSahabatFinansialKeluarga').getValue(4, 1)

String Coverage = 'Covered'

String DiagnosisConfirmation = 'New'

ArrayList PIC = ['Provider', 'Doctor']

ArrayList Confirmation = ['Document Received', 'Need Confirmation Letter']

String Channel = 'Call'

String Documents = 'New'

String DocumentsType = 'Confirmation Letter'

String DocumentsValidity = 'Dokumen Valid'

String ConfirmationLetterType = 'SC'

String FileDocument = 'File JPEG.jpeg' //Ambil value dari Nama file pada \\it-repository\ProjectDocuments\Katalon Garda Akses

String EditDateTimeConfirmation = 'No'

String DTC = null

String DocTypeCL = 'Yes'

String Remarks = 'No'

String RemarksValue = null

String Mandatory = 'Yes'

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

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim'), [('Member') : Member, ('MemberName') : MemberName
, ('ProductType') : ProductType, ('GLType') : GLType, ('SpecialCondition') : SpecialCondition, ('EditTreatmentPeriodStart') : EditTreatmentPeriodStart
, ('EditTreatmentPeriodEnd') : EditTreatmentPeriodEnd, ('Diagnosis') : Diagnosis, ('StatusDiagnosa') : StatusDiagnosa, ('DiagnosisID') : DiagnosisID
, ('RemarksDiagnosa') : RemarksDiagnosa, ('DoctorName') : DoctorName, ('Rujuk') : Rujuk, ('Reason') : Reason, ('SpecialCondition') : SpecialCondition, ('SpecialConditionReason') : SpecialConditionReason
, ('AppropriateRBClass') : AppropriateRBClass, ('TreatmentRBClass') : TreatmentRBClass, ('RoomOptionAvailability') : RoomOptionAvailability
, ('NewDocument') : NewDocument, ('EditDocument') : EditDocument, ('DeleteDocument') : DeleteDocument, ('ActionGL') : ActionGL
, ('Validasi') : Validasi, ('Phase') : '1'])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Exit Confirmation/Exit Confirmation'), [('ECAction1') : ECAction1
, ('ECAction2') : ECAction2, ('Comment') : Comment])

WebUI.comment(MemberName)

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
	[('UserID') : UserIDFU
	, ('Password') : PasswordFU
	, ('Menu') : MenuFU
	, ('SubMenu') : SubMenuFU
	, ('FUContactName') : FUContactName
	, ('FUClientName') : FUClientName
	, ('FUMemberName') : FUMemberName
	, ('Phase') : '1'
	, ('FUContactName') : FUContactName
	, ('FUClientName') : FUClientName
	, ('FUMemberName') : FUMemberName
	, ('MemberName') : MemberName
	, ('ProductType') : ProductType
	, ('GLType') : GLType
	, ('Provider') : ProviderName
	, ('RoomOptionAvailability') : RoomOptionAvailability
	//=== Batas Default Variable Follow Up ===//
	, ('Coverage') : Coverage
	, ('DiagnosisConfirmation') : DiagnosisConfirmation
	, ('PIC') : PIC
	, ('Confirmation') : Confirmation
	, ('Channel') : Channel
	, ('Documents') : Documents
	, ('DocumentsType') : DocumentsType
	, ('DocumentsValidity') : DocumentsValidity
	, ('FileDocument') : FileDocument
	, ('DoctorName') : DoctorName
	, ('EditDateTimeConfirmation') : EditDateTimeConfirmation
	, ('DTC') : DTC
	, ('Remarks') : Remarks
	, ('RemarksValue') : RemarksValue
	, ('ConfirmationLetterType') : ConfirmationLetterType
	, ('Mandatory') : Mandatory
	, ('Validasi') : ValidasiFU
])