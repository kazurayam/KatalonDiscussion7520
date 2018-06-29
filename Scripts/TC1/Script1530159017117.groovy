import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.navigateToUrl('http://demoaut-mimic.kazurayam.com/7520_testbed.html')

WebUI.verifyElementPresent(findTestObject('Page_Discussion 7520/td_415074'), 10, FailureHandling.STOP_ON_FAILURE)

List<Map<String,String>> expectedContents = [
	["CID":"1", "Campain":"dummy", "Clicks": "dummy"],
	["CID":"2", "Campain":"dummy", "Clicks": "dummy"],
	["CID":"3", "Campain":"dummy", "Clicks": "dummy"],
	["CID":"4", "Campain":"dummy", "Clicks": "dummy"],
	["CID":"5", "Campain":"dummy", "Clicks": "dummy"],
	["CID":"415074", "Campain":"Money Map Press", "Clicks": "1"]
]

//List<WebElement> TRs =  CustomKeywords.
//    'com.kazurayam.ksbackyard.FindElementsByXPath.getWebElementsAsList'(
//        '/html/body/div[@class="container"]/table/tbody/tr[1]/td/div/div[8]/div/table/tbody/tr')
List<WebElement> TRs = WebUI.findWebElements(findTestObject("Page_/TRs"), 10)

WebUI.comment("TRs.size()=${TRs.size}")

for (int i = 0; i < TRs.size(); i++) {
	// debug print
	List<WebElement> children = TRs[i].findElements(By.xpath('./child::*'))
	for (WebElement child :children) {
		WebUI.comment("indexFound=${i} child.getTagName()=${child.getTagName()} child.getText()=${child.getText()}")
	}
	//
	List<WebElement> TDs = TRs[i].findElements(By.xpath('./td'))
	if (TDs.size() >= 7) {
		String cid     = TDs[2].getText()
		String campain = TDs[3].getText()
		String clicks  = TDs[6].getText()
		WebUI.comment("indexFound=${i}, cid=${cid}, campain=${campain}, clicks=${clicks}")
		WebUI.verifyEqual(cid,     expectedContents[i].CID,     FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(campain, expectedContents[i].Campain, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(clicks,  expectedContents[i].Clicks,  FailureHandling.CONTINUE_ON_FAILURE)
	}
}

WebUI.closeBrowser()

