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

public class SrbijaVozHome_pageClass extends Base_PageClass {
	
	
	
	
	
	public SrbijaVozHome_pageClass(WebDriver driver) {
		super(driver);

	}

	@FindBy(tagName = "h4")
	WebElement subtitleHomePage;

	@FindBy(id = "jedanSmer")
	WebElement checkboxJedanSmer;

	@FindBy(id = "povratna")
	WebElement checkboxPovratnoPutovanje;

	@FindBy(id = "stanicaod")
	WebElement InputField_StanicaOd;
	@FindBy(css = "[title='Beograd-Prokop']")
	WebElement optionStanicaBeogradProkop;

	@FindBy(id = "stanicado")
	WebElement InputField_StanicaDo;
	@FindBy(css = "[title='Novi Sad']")
	WebElement optionStanicaNoviSad;

	@FindBy(id = "stanicadop")
	WebElement InputField_Povratak;

	@FindBy(css = "div[ng-click='open()']")
	WebElement fieldInputDate;
	@FindBy(css = "ul[role='presentation']")
	WebElement calendar;
	@FindBy(css = "button[class*='uib-right']")
	WebElement calendarArrowRight;
	@FindBy(css = ".btn-sm.active")
	WebElement travelDate1;

	@FindBy(id = "selectbasic")
	WebElement drpodownRazredMenu1;

	@FindBy(id = "brput")
	WebElement inputNumberOfPassengers;

	@FindBy(id = "btntrazi")
	WebElement buttonTrazi;

	 @FindBy(css = "div.btn.btn-sv.btn-izaberip")
	 List<WebElement> allButtonsIzaberi;
	
	@FindBy(xpath = "(//div[contains(@class,'btn-izabrano')][normalize-space()='izabrano'])[1]")  ////div[@class='btn  btn-izabrano']
	WebElement greenButtonIzabrano;

	@FindBy(xpath = "//div[contains(@ng-disabled,\"(izabranivoz=='')\")]")
	WebElement buttonDalje;

	@FindBy(css = ".col-md-5 h5:nth-child(2)")
	WebElement subtitle;

	
	
	
	public void clickOnCheckboxJedanSmer() {
		checkboxJedanSmer.click();

	}

	public void typeIntoField_StanicaOd(String input) {
		wait.until(ExpectedConditions.visibilityOf(InputField_StanicaOd)).clear();
		InputField_StanicaOd.sendKeys(input);
		wait.until(ExpectedConditions.textToBePresentInElementValue(InputField_StanicaOd, input));
		wait.until(ExpectedConditions.elementToBeClickable(optionStanicaBeogradProkop)).click();
	}

	public void typeIntoField_StanicaDo(String input) {
		wait.until(ExpectedConditions.visibilityOf(InputField_StanicaDo)).clear();
		InputField_StanicaDo.sendKeys(input);
		wait.until(ExpectedConditions.textToBePresentInElementValue(InputField_StanicaDo, input));
		wait.until(ExpectedConditions.elementToBeClickable(optionStanicaNoviSad)).click();
	}

	public void selectDate() {
		fieldInputDate.click();
		wait.until(ExpectedConditions.visibilityOf(calendar)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class*='uib-right']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-sm.active"))).click();

	}

	public void selectRazred() {
		Select select = new Select(drpodownRazredMenu1);
		select.selectByIndex(1);
	}

	public void NumberOfPassengers(String brojPutnika) {
		inputNumberOfPassengers.clear();
		inputNumberOfPassengers.sendKeys(brojPutnika);
		wait.until(ExpectedConditions.attributeContains(inputNumberOfPassengers, "class", "ng-not-empty"));
	}

	public void clickOnTraziButton() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonTrazi)).click();
	}

	public void clickOnFirstIzaberiButton() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.btn.btn-sv.btn-izaberip")));
		wait.until(ExpectedConditions.elementToBeClickable(allButtonsIzaberi.get(0))).click();
		wait.until(ExpectedConditions.attributeToBe(allButtonsIzaberi.get(0), "class", "btn btn-sv btn-izaberip ng-hide"));
	}

	public String verifyButtonColour() {
		wait.until(ExpectedConditions.attributeToBe(greenButtonIzabrano, "class", "btn  btn-izabrano"));
		wait.until(ExpectedConditions.attributeToBe(greenButtonIzabrano,"background-color", "rgba(14, 136, 12, 1)" ));
		return greenButtonIzabrano.getCssValue("background-color");
	}

	public void clickOnDaljeButton() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonDalje)).click();
	}

	public boolean verifySubtitlePrijava() {
		return subtitle.getText().contains("Prijava");
	}

}
