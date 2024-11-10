package testClases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pageClasses.SrbijaVozHome_pageClass;
import pageClasses.SrbijaVozLogin_pageClass;

public class BaseTestClass {

	WebDriver driver;
	WebDriverWait wait;
	SrbijaVozHome_pageClass homePage;
	SrbijaVozLogin_pageClass loginPage;

	@BeforeTest
	public void initialization() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		homePage = new SrbijaVozHome_pageClass(driver);
		loginPage = new SrbijaVozLogin_pageClass(driver);
	}

	@AfterTest
	public void closeDriver() {
		driver.quit();
	}

}
