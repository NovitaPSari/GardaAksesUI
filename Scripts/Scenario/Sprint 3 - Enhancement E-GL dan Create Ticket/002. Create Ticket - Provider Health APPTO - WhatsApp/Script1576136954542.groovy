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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

//Login//
def UserID = 'DNS'

def Password = 'Password95'

//Create Ticket//
def ContactLine = 'Provider'

def Product = 'Health'

def ChannelType = 'WhatsApp' //Bebas

def ContactName = findTestData('ContactName').getValue(1, 1)

def ContactType = 'Lainnya' //Bebas

def ServiceType = 'Approval Tindakan/Terapi/Obat'

def InterruptedCall = null //Yes or Null

def ProviderName = 'OJKSH00001'

def ActionCT = 'Next'

//Inquiry//
def MemberName = findTestData('MemberNameAll').getValue(1, 1)

def SubServiceType = 'Approve Tindakan/Terapi/Obat'

String MedicalTreatment = 'Rontgen'

def Remarks = 'Currently testing by Automation. Thanks. Regards - Me'

def NeedFollowUp = null

def ActionAPPTO = 'Proses'

def Phase = '1'

def ECAction1 = 'Tidak'

def ECAction2 = 'Puas'

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Login/Login'), [('UserID') : UserID, ('Password') : Password])

WebUI.callTestCase(findTestCase('null'), [:])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), 
	[('ContactLine') : ContactLine, 
		('Product') : Product, 
		('ChannelType') : ChannelType, 
		('ContactName') : ContactName, 
		('ContactType') : ContactType, 
		('ServiceType') : ServiceType, 
		('InterruptedCall') : InterruptedCall,
		('ProviderName') : ProviderName,
		('Action') : ActionCT])

CustomKeywords.'querySQL.Query.QueryContactName'()

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Approval Tindakan Terapi Obat'), 
	[('ServiceType') : ServiceType, 
		('MemberName') : MemberName, 
		('SubServiceType') : SubServiceType, 
		('MedicalTreatment') : MedicalTreatment, 
		('Remarks') : Remarks, 
		('NeedFollowUp') : NeedFollowUp, 
		('Action') : ActionAPPTO, 
		('Phase') : Phase, 
		('ECAction1') : ECAction1, 
		('ECAction2') : ECAction2])