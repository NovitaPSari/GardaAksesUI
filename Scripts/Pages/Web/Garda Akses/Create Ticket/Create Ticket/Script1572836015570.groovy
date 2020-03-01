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
import com.keyword.GEN5

WebUI.waitForElementVisible(findTestObject('Pages/Web/Garda Akses/Create Ticket/Radio Button - Contact Line', [('Value') : ContactLine]), 20)

GEN5.ProcessingCommand()

//Contact Line
WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Radio Button - Contact Line', [('Value') : ContactLine]))

//Product
WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Radio Button - Product', [('Value') : Product]))

//Channel Type
WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Combo - Channel Type'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Combo List - Channel Type', [('Value') : ChannelType]))

//Contact Name
WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Contact Name'), ContactName)

//Contact Type
WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Combo - Contact Type'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Combo List - Contact Type', [('Value') : ContactType]))

//Service Type
WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Combo - Service Type'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Combo List - Service Type', [('Value') : ServiceType]))

//Interrupted Contact
if (InterruptedCall == 'Yes') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Check Box - Interrupted Contact'))
} else {
    WebUI.delay(0)
}

//========================= Start Customer =========================
if (ContactLine == 'Customer') {
	//Customer Phone
	if (((ContactLine == 'Customer') && (Product == 'Health') && (ServiceType == 'Complaint'))
		|| ((ContactLine == 'Customer') && (Product == 'Health') && (ChannelType == 'Call') && (ServiceType == 'Inquiry'))
		|| ((ContactLine == 'Customer') && (Product == 'Health') && (ChannelType == 'WhatsApp') && (ServiceType == 'Inquiry'))
		|| ((ContactLine == 'Customer') && (Product == 'Health') && (ChannelType == 'SMS') && (ServiceType == 'Inquiry'))
		|| ((ContactLine == 'Customer') && (Product == 'Health') && (ChannelType == 'Walk In') && (ServiceType == 'Inquiry'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Call') && (ServiceType == 'Claim'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'WhatsApp') && (ServiceType == 'Claim'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'SMS') && (ServiceType == 'Claim'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Walk In') && (ServiceType == 'Claim'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ServiceType == 'Complaint'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Call') && (ServiceType == 'Cancellation'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'WhatsApp') && (ServiceType == 'Cancellation'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'SMS') && (ServiceType == 'Cancellation'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Walk In') && (ServiceType == 'Cancellation'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Call') && (ServiceType == 'Emergency'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'WhatsApp') && (ServiceType == 'Emergency'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'SMS') && (ServiceType == 'Emergency'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Walk In') && (ServiceType == 'Emergency'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Call') && (ServiceType == 'Endorsement'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'WhatsApp') && (ServiceType == 'Endorsement'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'SMS') && (ServiceType == 'Endorsement'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Walk In') && (ServiceType == 'Endorsement'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Call') && (ServiceType == 'Inquiry'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'WhatsApp') && (ServiceType == 'Inquiry'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'SMS') && (ServiceType == 'Inquiry'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Walk In') && (ServiceType == 'Inquiry'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Call') && (ServiceType == 'Payment CC'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'WhatsApp') && (ServiceType == 'Payment CC'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'SMS') && (ServiceType == 'Payment CC'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Walk In') && (ServiceType == 'Payment CC'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Call') && (ServiceType == 'Quotation'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'WhatsApp') && (ServiceType == 'Quotation'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'SMS') && (ServiceType == 'Quotation'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Walk In') && (ServiceType == 'Quotation'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Call') && (ServiceType == 'Renewal'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'WhatsApp') && (ServiceType == 'Renewal'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'SMS') && (ServiceType == 'Renewal'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Walk In') && (ServiceType == 'Renewal'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Call') && (ServiceType == 'Schedule Survey'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'WhatsApp') && (ServiceType == 'Schedule Survey'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'SMS') && (ServiceType == 'Schedule Survey'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Walk In') && (ServiceType == 'Schedule Survey'))) {
	    WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Customer Phone'), GlobalVariable.PhoneNumber)
	} else {
	    WebUI.delay(0)
	}
	
	//Customer Email
	if (((ContactLine == 'Customer') && (Product == 'Health') && (ChannelType == 'Email') && (ServiceType == 'Complaint'))
		|| ((ContactLine == 'Customer') && (Product == 'Health') && (ChannelType == 'Email') && (ServiceType == 'Inquiry'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Email') && (ServiceType == 'Claim'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Email') && (ServiceType == 'Complaint'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Email') && (ServiceType == 'Cancellation'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Email') && (ServiceType == 'Emergency'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Email') && (ServiceType == 'Endorsement'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Email') && (ServiceType == 'Inquiry'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Email') && (ServiceType == 'Payment CC'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Email') && (ServiceType == 'Quotation'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Email') && (ServiceType == 'Renewal'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Email') && (ServiceType == 'Schedule Survey'))) {
	    WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Customer Email'), GlobalVariable.Email)
	} else {
	    WebUI.delay(0)
	}
	
	//Customer Social Media Account
	if (((ContactLine == 'Customer') && (Product == 'Health') && (ChannelType == 'Twitter') && (ServiceType == 'Complaint')) 
	|| ((ContactLine == 'Customer') && (Product == 'Health') && (ChannelType == 'Facebook') && (ServiceType == 'Complaint'))
	|| ((ContactLine == 'Customer') && (Product == 'Health') && (ChannelType == 'Instagram') && (ServiceType == 'Complaint'))
	|| ((ContactLine == 'Customer') && (Product == 'Health') && (ChannelType == 'Media Masa') && (ServiceType == 'Complaint'))
	|| ((ContactLine == 'Customer') && (Product == 'Health') && (ChannelType == 'Surat') && (ServiceType == 'Complaint'))
	|| ((ContactLine == 'Customer') && (Product == 'Health') && (ChannelType == 'Twitter') && (ServiceType == 'Inquiry')) 
	|| ((ContactLine == 'Customer') && (Product == 'Health') && (ChannelType == 'Facebook') && (ServiceType == 'Inquiry'))
	|| ((ContactLine == 'Customer') && (Product == 'Health') && (ChannelType == 'Instagram') && (ServiceType == 'Inquiry'))
	|| ((ContactLine == 'Customer') && (Product == 'Health') && (ChannelType == 'Media Masa') && (ServiceType == 'Inquiry'))
	|| ((ContactLine == 'Customer') && (Product == 'Health') && (ChannelType == 'Surat') && (ServiceType == 'Inquiry'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Twitter') && (ServiceType == 'Claim')) 
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Facebook') && (ServiceType == 'Claim'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Instagram') && (ServiceType == 'Claim'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Media Masa') && (ServiceType == 'Claim'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Surat') && (ServiceType == 'Claim'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Twitter') && (ServiceType == 'Complaint')) 
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Facebook') && (ServiceType == 'Complaint'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Instagram') && (ServiceType == 'Complaint'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Media Masa') && (ServiceType == 'Complaint'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Surat') && (ServiceType == 'Complaint'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Twitter') && (ServiceType == 'Cancellation')) 
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Facebook') && (ServiceType == 'Cancellation'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Instagram') && (ServiceType == 'Cancellation'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Media Masa') && (ServiceType == 'Cancellation'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Surat') && (ServiceType == 'Cancellation'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Twitter') && (ServiceType == 'Emergency')) 
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Facebook') && (ServiceType == 'Emergency'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Instagram') && (ServiceType == 'Emergency'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Media Masa') && (ServiceType == 'Emergency'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Surat') && (ServiceType == 'Emergency'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Twitter') && (ServiceType == 'Endorsement')) 
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Facebook') && (ServiceType == 'Endorsement'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Instagram') && (ServiceType == 'Endorsement'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Media Masa') && (ServiceType == 'Endorsement'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Surat') && (ServiceType == 'Endorsement'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Twitter') && (ServiceType == 'Inquiry')) 
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Facebook') && (ServiceType == 'Inquiry'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Instagram') && (ServiceType == 'Inquiry'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Media Masa') && (ServiceType == 'Inquiry'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Surat') && (ServiceType == 'Inquiry'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Twitter') && (ServiceType == 'Payment CC')) 
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Facebook') && (ServiceType == 'Payment CC'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Instagram') && (ServiceType == 'Payment CC'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Media Masa') && (ServiceType == 'Payment CC'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Surat') && (ServiceType == 'Payment CC'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Twitter') && (ServiceType == 'Quotation')) 
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Facebook') && (ServiceType == 'Quotation'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Instagram') && (ServiceType == 'Quotation'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Media Masa') && (ServiceType == 'Quotation'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Surat') && (ServiceType == 'Quotation'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Twitter') && (ServiceType == 'Renewal')) 
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Facebook') && (ServiceType == 'Renewal'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Instagram') && (ServiceType == 'Renewal'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Media Masa') && (ServiceType == 'Renewal'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Surat') && (ServiceType == 'Renewal'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Twitter') && (ServiceType == 'Schedule Survey')) 
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Facebook') && (ServiceType == 'Schedule Survey'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Instagram') && (ServiceType == 'Schedule Survey'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Media Masa') && (ServiceType == 'Schedule Survey'))
	|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ChannelType == 'Surat') && (ServiceType == 'Schedule Survey'))) {
	    WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Customer Social Media'), 
	        GlobalVariable.SocialMedia)
	} else {
	    WebUI.delay(0)
	}
	
	//Customer Gender
	if (((ContactLine == 'Customer') && (Product == 'Health') && (ServiceType == 'Complaint'))
		|| ((ContactLine == 'Customer') && (Product == 'Health') && (ServiceType == 'Inquiry')) 
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ServiceType == 'Claim'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ServiceType == 'Complaint'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ServiceType == 'Cancellation'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ServiceType == 'Emergency'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ServiceType == 'Endorsement'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ServiceType == 'Inquiry'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ServiceType == 'Payment CC'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ServiceType == 'Quotation'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ServiceType == 'Renewal'))
		|| ((ContactLine == 'Customer') && (Product == 'Non Health') && (ServiceType == 'Schedule Survey'))) {
	    WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Radio Button - Customer Gender', [('Value') : CustomerGender]))
	} else {
	    WebUI.delay(0)
	}
}

//========================== End Customer ==========================

//========================= Start Provider =========================
if (ContactLine == 'Provider') {
	//Provider Name
	if (ContactLine == 'Provider') {
	    CustomKeywords.'gardaAkses.CreateTicket.ProviderName'(ProviderName)
		
		GEN5.ProcessingCommand()
	} else {
	    WebUI.delay(0)
	}
	
	//Provider Phone Number
	if (ContactLine == 'Provider') {
		def PhoneNumber = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Phone Number'), 'Value')
		
		if (PhoneNumber != GlobalVariable.PhoneNumber) {
			WebUI.clearText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Phone Number'))
			
			WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Phone Number'),
					GlobalVariable.PhoneNumber)
		} else {
	    	WebUI.delay(0)
		}    
	} else {
	    WebUI.clearText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Phone Number'))
	}
	
	//Ext
	if (null) {
		def ExtNumber = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Ext'), 'Value')
		
		if (ExtNumber != GlobalVariable.ExtNumber) {
			WebUI.clearText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Ext'))
			
			WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Ext'), GlobalVariable.ExtNumber)
		} else {
			WebUI.delay(0)
		}
	} else {
		WebUI.clearText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Ext'))
	}
	
	//Provider Email
	if (((ContactLine == 'Provider') && (Product == 'Health') && (ChannelType == 'Email') && (ServiceType == 'Approval Tindakan/Terapi/Obat'))
		|| ((ContactLine == 'Provider') && (Product == 'Health') && (ServiceType == 'Claim'))
		|| ((ContactLine == 'Provider') && (Product == 'Health') && (ServiceType == 'Complaint'))
		|| ((ContactLine == 'Provider') && (Product == 'Health') && (ChannelType == 'Email') && (ServiceType == 'Inquiry'))) {
	    
		def EmailProvider = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Email'), 'value')
		
		if (EmailProvider != GlobalVariable.Email) {
			WebUI.clearText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Email'))
			
			WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Email'), GlobalVariable.Email)
		} else {
		WebUI.delay(0)
		}	
	} else {
	    WebUI.clearText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Email'))
	}
	
	//Provider Fax
	if (null) {
	    
		def  FaxProvider = WebUI.getAttribute(findTestObject('Pages/Web/Garda Akses/Create Ticket/Input - Provider Fax'), 'value')
		
		if (FaxProvider != GlobalVariable.FaxNumber) {
			WebUI.clearText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Input - Provider Fax'))
			
			WebUI.setText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Input - Provider Fax'), GlobalVariable.FaxNumber)
		} else {
		WebUI.delay(0)
		}
		
	} else {
	    WebUI.clearText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Input - Provider Fax'))
	}
}

//========================== End Provider ==========================
Action
if (Action == 'Next') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Button - Next'))
} else if (Action == 'Exit') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Button - Exit'))
} else {
    WebUI.delay(0)
}

