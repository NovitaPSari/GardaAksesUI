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

GEN5.ProcessingCommand()

boolean ButtonStart = WebUI.waitForElementVisible(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up Inquiry/Button - Start'), 
    1, FailureHandling.OPTIONAL)

	int i = 1
	
	while (i <= 5) {	
		if (!ButtonStart) {
			String CheckTrID = 'SELECT TOP 1 TrID, TicketNo, Doctor FROM CONTACTCENTER.eGLGardaAkses WHERE TicketNo = \'' + GlobalVariable.TicketID1 + '\' ORDER BY CreatedDate DESC'
				
			String TrID = GEN5.getValueDatabase("172.16.94.70", "SEA", CheckTrID, "TrID")
			
			WebUI.comment(TrID)
			
			QueryUpdatePIC = 'UPDATE ContactCenter.FollowUpTicketHistory SET UserID = \'LKT\' WHERE TrID IN (\''+ TrID + '\')'	
			
			GEN5.updateValueDatabase("172.16.94.70", "SEA", QueryUpdatePIC)
			
			WebUI.delay(GlobalVariable.Delay2)
			
			ButtonStart = WebUI.waitForElementVisible(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up Inquiry/Button - Start'),
				1, FailureHandling.OPTIONAL)
		}
		i++
	}

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up Inquiry/Button - Start'), FailureHandling.OPTIONAL)

