package pageClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Factory;

public class SrbijaVozLogin_pageClass extends Base_PageClass {

	public SrbijaVozLogin_pageClass(WebDriver driver) {
		super(driver);
	}

	// elementi

	@FindBy(tagName = "h4")
	WebElement subtitleLoginPage;

	@FindBy(id = "firstName")
	WebElement inputField_name;

	@FindBy(id = "lastName")
	WebElement inputField_lastName;

	@FindBy(xpath = "//select[@ng-model='date']")
	WebElement dayDropdown;

	@FindBy(xpath = "//select[@ng-model='month']")
	WebElement monthDropdown;

	@FindBy(xpath = "//select[@ng-model='year']")
	WebElement yearDropdown;

	@FindBy(id = "telefon")
	WebElement inputField_Telefon;

	@FindBy(id = "email")
	WebElement inputField_Email;

	@FindBy(id = "passwordr")
	WebElement inputField_Lozinka;

	@FindBy(xpath = "//select[@ng-model='registration.sifra_povlastice']")
	WebElement dropdownMenuPovlastice;

	
	@FindBy(id = "povlasticaBroj")
	WebElement inputFieldBrojPovlastice;
	
	@FindBy(css = "input[name='promo']")
	WebElement checkboxPromo;

	@FindBy(name = "info")
	WebElement checkboxInfo;

	@FindBy(xpath = "//div[contains(text(),'REGISTRACIJA')]")
	WebElement button_Registracija;
	
	@FindBy(css = "div.bg-danger")
	WebElement messageMolimoVasSacekajte;
	
	@FindBy(css = "[type=\"checkbox\"]")
	List<WebElement> allCheckboxes; 

	// metode

	public String getSubtitleText() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h4")));
		return subtitleLoginPage.getText();
	}

	public void typeFirstName(String firstName) {
		wait.until(ExpectedConditions.visibilityOf(inputField_name)).clear();
		inputField_name.sendKeys(firstName);
		wait.until(ExpectedConditions.textToBePresentInElementValue(inputField_name, firstName));

	}

	public void typeLastname(String lastname) {
		wait.until(ExpectedConditions.visibilityOf(inputField_lastName)).clear();
		inputField_lastName.sendKeys(lastname);
		wait.until(ExpectedConditions.textToBePresentInElementValue(inputField_lastName, lastname));
	}

	public void selectBirthDate(String day, String month, String year) {
        // Odabir dana
        Select selectDay = new Select(dayDropdown);
        selectDay.selectByVisibleText(day);

        // Odabir meseca
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(month);

        // Odabir godine
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText(year);
    }

	public void typeTelefon(String telefon) {
		wait.until(ExpectedConditions.visibilityOf(inputField_Telefon)).clear();
		inputField_Telefon.sendKeys(telefon);
		wait.until(ExpectedConditions.textToBePresentInElementValue(inputField_Telefon, telefon));

	}

	public void typeInvalidEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(inputField_Email)).clear();
		inputField_Email.sendKeys(email);
		wait.until(ExpectedConditions.textToBePresentInElementValue(inputField_Email, email));
	}

	public void typeLozinka(String password) {
		wait.until(ExpectedConditions.visibilityOf(inputField_Lozinka)).clear();
		inputField_Lozinka.sendKeys(password);
		wait.until(ExpectedConditions.textToBePresentInElementValue(inputField_Lozinka, password));

	}

	public void selectPovlastice(String value) {
		Select SelectPovlastice = new Select(dropdownMenuPovlastice);
		SelectPovlastice.selectByVisibleText(value);
	}

	
	public void typeBrojPovlastice(String broj) {
		inputFieldBrojPovlastice.sendKeys(broj);
	}
	
	
	
	public void selectCheckboxPromo() {
		wait.until(ExpectedConditions.elementToBeClickable(checkboxPromo)).click();

	}

	public void selectCheckboxInfo() {
		wait.until(ExpectedConditions.elementToBeClickable(checkboxInfo)).click();
	}

	public void click_RegistracijaButton() {
		wait.until(ExpectedConditions.elementToBeClickable(button_Registracija)).click();

	}

    public boolean verifyMessageMolimoVasSacekajte() {
       wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.bg-danger")));
        return  messageMolimoVasSacekajte.isDisplayed();
    }

	public boolean verifyPromoCheckbox() {
		return checkboxPromo.isSelected();
	}

	public boolean verifyInfoCheckbox() {
		return checkboxInfo.isSelected();
	}

	
	 public List<WebElement> getAllCheckboxes() {
	        return allCheckboxes;
	    }

	    public WebElement getCheckbox1() {
	        return checkboxPromo;
	    }
	
	
	
	
	
	
	
}
