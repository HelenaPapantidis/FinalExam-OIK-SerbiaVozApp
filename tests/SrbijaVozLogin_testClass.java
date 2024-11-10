package testClases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SrbijaVozLogin_testClass extends BaseTestClass {

	@BeforeMethod
	public void navigation() {
		driver.navigate().to("https://webapi1.srbvoz.rs/ekarta/app/#!/login");

	}

	@AfterMethod
	public void deleteCookie() {
		driver.manage().deleteAllCookies();
	}

	@Test
	public void verifyPageSubtitle() {

		String actualSubtitle = loginPage.getSubtitleText();
		String expectedMessage = "PRIJAVA NA SISTEM ILI REGISTRACIJA";
		assertEquals(actualSubtitle, expectedMessage);
	}

	@Test
	public void verifyRegistration_withInvalidEmail() {

		loginPage.typeFirstName("Helen");
		loginPage.typeLastname("Papa");
		loginPage.selectBirthDate("15", "Sep", "1990");
		loginPage.typeTelefon("065987425");
		loginPage.typeInvalidEmail("mili@example.c");
		loginPage.typeLozinka("Sifra01&#");
		loginPage.selectPovlastice("SRB+PLUS K-13");
		loginPage.typeBrojPovlastice("120");
		loginPage.selectCheckboxInfo();
		loginPage.selectCheckboxPromo();
        loginPage.click_RegistracijaButton();
        assertTrue(loginPage.verifyMessageMolimoVasSacekajte(), "Message is not displayed");

	}

	@Test
	public void verifyCheckboxes() {
		 List<WebElement> allCheckboxes = loginPage.getAllCheckboxes();
	        WebElement checkbox1 = loginPage.getCheckbox1();
	        checkbox1.click();

	        SoftAssert softAssert = new SoftAssert();

	        for (WebElement oneCheckbox : allCheckboxes) {
	            if (oneCheckbox.equals(checkbox1)) {
	                softAssert.assertTrue(oneCheckbox.isSelected(), "Checkbox 1 should be selected");
	            } else {
	                softAssert.assertFalse(oneCheckbox.isSelected());
	                oneCheckbox.click();
	                softAssert.assertTrue(oneCheckbox.isSelected());
	            }
	            softAssert.assertTrue(oneCheckbox.isSelected(), "All checkboxes are not selected");
	        }
	        softAssert.assertAll();
	}
	
	 @Test(dataProvider = "incorrectEmailData", dataProviderClass = SrbijaVoz_TestData.class)
	    public void verifyRegistration_withIncorrectEmail(String invalidEmail) {
		  SoftAssert softAssert = new SoftAssert();
		    loginPage.typeFirstName("Helena");
	        loginPage.typeLastname("Papantidis");
	        loginPage.selectBirthDate("15", "Sep", "1990");
	        loginPage.typeTelefon("065987425");
	        loginPage.typeInvalidEmail(invalidEmail);
	        loginPage.typeLozinka("Sifra01&#");
	        loginPage.selectPovlastice("SRB+PLUS K-13");
	        loginPage.typeBrojPovlastice("120");
	        loginPage.selectCheckboxInfo();
	        loginPage.selectCheckboxPromo();
	        loginPage.click_RegistracijaButton();
	       
	        softAssert.assertTrue(loginPage.verifyMessageMolimoVasSacekajte(), "Message is not displayed");
	  
	        softAssert.assertAll();
	 }
	
	 
}
