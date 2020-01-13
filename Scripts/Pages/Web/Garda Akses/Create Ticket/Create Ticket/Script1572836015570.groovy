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

WebUI.delay(GlobalVariable.Delay5)

//Contact Line
WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Radio Button - Contact Line', [('ContactLine') : ContactLine]))

//Product
WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Radio Button - Product', [('Product') : Product]))

//Channel Type
WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Button - Channel Type'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Choose - Channel Type', [('ChannelType') : ChannelType]))

//Contact Name
WebUI.setText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Input - Contact Name'), ContactName)

def AutoComplete = WebUI.verifyElementPresent(findTestObject('Pages/Web/Garda Akses/Create Ticket/Choose - Auto Complete Contact Name'), 
    GlobalVariable.Delay1)

if (AutoComplete == true) {
	WebUI.delay(GlobalVariable.Delay0)
	
    WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Choose - Auto Complete Contact Name'))
} else {
    WebUI.delay(0)
}

//Contact Type
WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Button - Contact Type'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Choose - Contact Type', [('ContactType') : ContactType]))

//Service Type
WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Button - Service Type'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Choose - Service Type', [('ServiceType') : ServiceType]))

//Interrupted Contact
if (InterruptedCall == 'Yes') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Check Box - Interrupted Contact'))
} else {
    WebUI.delay(0)
}

//========================= Start Customer =========================
//Customer Phone
if ((((((((((((ContactLine == 'Customer') && (ChannelType == 'Call')) || 
	((ContactLine == 'Customer') && (ChannelType == 'WhatsApp'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'SMS'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Walk In'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Email'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Twitter'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Facebook'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Instagram'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Media Masa'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Surat'))) ||
	((ContactLine == 'Customer') && (ChannelType == 'Lembaga'))) {
    WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Customer Phone'), GlobalVariable.ProviderPhoneNumber)
} else {
    WebUI.delay(0)
}

//Customer Email
if ((ContactLine == 'Customer') && (ChannelType == 'Email')) {
    WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Customer Email'), GlobalVariable.ProviderEmail)
} else {
    WebUI.delay(0)
}

//Customer Social Media Account
if ((((((ContactLine == 'Customer') && (ChannelType == 'Twitter')) || 
	((ContactLine == 'Customer') && (ChannelType == 'Facebook'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Instagram'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Media Masa'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Surat'))) {
    WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Customer Social Media'), 
        CustomerSocialMedia)
} else {
    WebUI.delay(0)
}

//Customer Gender
if ((((((((((((ContactLine == 'Customer') && (ChannelType == 'Call')) || 
	((ContactLine == 'Customer') && (ChannelType == 'WhatsApp'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'SMS'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Walk In'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Email'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Twitter'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Facebook'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Instagram'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Media Masa'))) || 
	((ContactLine == 'Customer') && (ChannelType == 'Surat'))) ||
	((ContactLine == 'Customer') && (ChannelType == 'Lembaga'))) {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Button - Customer Gender', [('CustomerGender') : CustomerGender]))
} else {
    WebUI.delay(0)
}
//========================== End Customer ==========================

//========================= Start Provider =========================
//Provider Name
if ((((((((((((((((((((((((((((((((((((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Call')) && (ServiceType == 'Approval Tindakan/Terapi/Obat')) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'WhatsApp')) && (ServiceType == 'Approval Tindakan/Terapi/Obat'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'SMS')) && (ServiceType == 'Approval Tindakan/Terapi/Obat'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Email')) && (ServiceType == 'Approval Tindakan/Terapi/Obat'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Chatbot')) && (ServiceType == 'Approval Tindakan/Terapi/Obat'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Live chat')) && (ServiceType == 'Approval Tindakan/Terapi/Obat'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Website')) && (ServiceType == 'Approval Tindakan/Terapi/Obat'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Call')) && (ServiceType == 'Claim'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'WhatsApp')) && (ServiceType == 'Claim'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'SMS')) && (ServiceType == 'Claim'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Email')) && (ServiceType == 'Claim'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Chatbot')) && (ServiceType == 'Claim'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Live chat')) && (ServiceType == 'Claim'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Website')) && (ServiceType == 'Claim'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Call')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'WhatsApp')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'SMS')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Email')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Chatbot')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Live chat')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Website')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Call')) && (ServiceType == 'Inquiry'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'WhatsApp')) && (ServiceType == 'Inquiry'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'SMS')) && (ServiceType == 'Inquiry'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Email')) && (ServiceType == 'Inquiry'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Chatbot')) && (ServiceType == 'Inquiry'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Live chat')) && (ServiceType == 'Inquiry'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Website')) && (ServiceType == 'Inquiry'))) || 
	((((ContactLine == 'Provider') && (Product == 'Non Health')) && (ChannelType == 'Call')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Non Health')) && (ChannelType == 'WhatsApp')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Non Health')) && (ChannelType == 'SMS')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Non Health')) && (ChannelType == 'Email')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Non Health')) && (ChannelType == 'Chatbot')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Non Health')) && (ChannelType == 'Live chat')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Non Health')) && (ChannelType == 'Website')) && (ServiceType == 'Complaint'))) {
    WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Name'), ProviderName)

    WebUI.delay(GlobalVariable.Delay0)

    WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Name'), ProviderName)
	
	WebUI.delay(GlobalVariable.Delay0)

    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Choose - Auto Complete Provider Name'))
} else {
    WebUI.delay(0)
}

//Provider Phone Number
if ((((((((((((((((((((((((((((((((((((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Call')) && (ServiceType == 'Approval Tindakan/Terapi/Obat')) ||
	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'WhatsApp')) && (ServiceType == 'Approval Tindakan/Terapi/Obat'))) ||
 	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'SMS')) && (ServiceType == 'Approval Tindakan/Terapi/Obat'))) ||
  	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Email')) && (ServiceType == 'Approval Tindakan/Terapi/Obat'))) ||
   	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Chatbot')) && (ServiceType == 'Approval Tindakan/Terapi/Obat'))) ||
	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Live chat')) && (ServiceType == 'Approval Tindakan/Terapi/Obat'))) ||
 	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Website')) && (ServiceType == 'Approval Tindakan/Terapi/Obat'))) ||
  	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Call')) && (ServiceType == 'Claim'))) ||
   	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'WhatsApp')) && (ServiceType == 'Claim'))) ||
	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'SMS')) && (ServiceType == 'Claim'))) ||
 	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Email')) && (ServiceType == 'Claim'))) ||
  	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Chatbot')) && (ServiceType == 'Claim'))) ||
   	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Live chat')) && (ServiceType == 'Claim'))) ||
	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Website')) && (ServiceType == 'Claim'))) ||
 	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Call')) && (ServiceType == 'Complaint'))) ||
  	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'WhatsApp')) && (ServiceType == 'Complaint'))) ||
   	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'SMS')) && (ServiceType == 'Complaint'))) ||
	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Email')) && (ServiceType == 'Complaint'))) ||
 	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Chatbot')) && (ServiceType == 'Complaint'))) ||
  	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Live chat')) && (ServiceType == 'Complaint'))) ||
   	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Website')) && (ServiceType == 'Complaint'))) ||
	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Call')) && (ServiceType == 'Inquiry'))) ||
 	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'WhatsApp')) && (ServiceType == 'Inquiry'))) ||
  	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'SMS')) && (ServiceType == 'Inquiry'))) ||
   	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Email')) && (ServiceType == 'Inquiry'))) ||
	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Chatbot')) && (ServiceType == 'Inquiry'))) ||
 	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Live chat')) && (ServiceType == 'Inquiry'))) ||
	 ((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Website')) && (ServiceType == 'Inquiry'))) ||
	 ((((ContactLine == 'Provider') && (Product == 'Non Health')) && (ChannelType == 'Call')) && (ServiceType == 'Complaint'))) ||
	 ((((ContactLine == 'Provider') && (Product == 'Non Health')) && (ChannelType == 'WhatsApp')) && (ServiceType == 'Complaint'))) ||
	 ((((ContactLine == 'Provider') && (Product == 'Non Health')) && (ChannelType == 'SMS')) && (ServiceType == 'Complaint'))) ||
	 ((((ContactLine == 'Provider') && (Product == 'Non Health')) && (ChannelType == 'Email')) && (ServiceType == 'Complaint'))) ||
	 ((((ContactLine == 'Provider') && (Product == 'Non Health')) && (ChannelType == 'Chatbot')) && (ServiceType == 'Complaint'))) ||
	 ((((ContactLine == 'Provider') && (Product == 'Non Health')) && (ChannelType == 'Live chat')) && (ServiceType == 'Complaint'))) ||
	 ((((ContactLine == 'Provider') && (Product == 'Non Health')) && (ChannelType == 'Website')) && (ServiceType == 'Complaint'))) {
	 WebUI.clearText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Phone Number'))
	 
	 WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Phone Number'), GlobalVariable.ProviderPhoneNumber)
} else {
    WebUI.delay(0)
}

//Provider Email
if (((((((((((((((((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Email')) && (ServiceType == 'Approval Tindakan/Terapi/Obat')) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Call')) && (ServiceType == 'Claim'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'WhatsApp')) && (ServiceType == 'Claim'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'SMS')) && (ServiceType == 'Claim'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Email')) && (ServiceType == 'Claim'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Chatbot')) && (ServiceType == 'Claim'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Live chat')) && (ServiceType == 'Claim'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Website')) && (ServiceType == 'Claim'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Call')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'WhatsApp')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'SMS')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Email')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Chatbot')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Live chat')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Website')) && (ServiceType == 'Complaint'))) || 
	((((ContactLine == 'Provider') && (Product == 'Health')) && (ChannelType == 'Email')) && (ServiceType == 'Inquiry'))) {
	WebUI.clearText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Email'))
	
    WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Email'), GlobalVariable.ProviderEmail)
} else {
    WebUI.delay(0)
}

//========================== End Provider ==========================
//Action
if (Action == 'Next') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Button - Next'))
} else if (Action == 'Exit') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Button - Exit'))
} else {
	WebUI.delay(0)
}


