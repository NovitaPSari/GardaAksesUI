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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys1
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

WebUI.delay(GlobalVariable.Delay1)

//WebDriver driver = DriverFactory.getWebDriver()
//
//WebUI.switchToFrame(findTestObject('Object Repository/Pages/Web/Garda Akses/Frame'), 3)
//
//WebElement diagnosis = driver.findElement(By.xpath('//*[@id="DiagnosisInfoPopUpSectionFullText-0"]/div[1]/div/div[3]/a2is-datatable/div[2]/div/table/tbody'))
//
//List<WebElement> additional_info = diagnosis.findElements(By.tagName('tr'))
//
//int yes = additional_info.size()

int yes = CustomKeywords.'gardaAkses.Count.Additional_Info'()

println yes

int i = 1

for (a = i ; a < yes ; a++){
	
	println a
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Diagnosis/Radio Button - Yes', [('i') : a]))

	WebUI.delay(1)
	
	println a

}