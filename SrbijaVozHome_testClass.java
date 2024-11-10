package testClases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Button;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class SrbijaVozHome_testClass  extends BaseTestClass{

	
	@BeforeMethod
	public void navigation() {
		driver.navigate().to(" https://webapi1.srbvoz.rs/ekarta/app/#!/home");
		
	}
	
	
	@AfterMethod
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	
	
	@Test
	public void verifySearchingForTrainTicket () {
		
		homePage.clickOnCheckboxJedanSmer();
		homePage.typeIntoField_StanicaOd("be");
		homePage.typeIntoField_StanicaDo("no");
		homePage.selectDate();
		homePage.selectRazred();
		homePage.NumberOfPassengers("5");
		homePage.clickOnTraziButton();
		homePage.clickOnFirstIzaberiButton();
		String actualButtonColour = homePage.verifyButtonColour();
		String expectedButtonColour = "rgba(14, 136, 12, 1)";
		assertEquals(actualButtonColour,expectedButtonColour, "Button is not green colour");
		homePage.clickOnDaljeButton();
		assertTrue(homePage.verifySubtitlePrijava(), "The subtitle does not contains text Prijava");
		
	}
	

	
	
	
	
	
	
	
	
	
	
}
