package testClases;

import org.testng.annotations.DataProvider;

public class SrbijaVoz_TestData {
	
	
	public String incorrectEmailInput = "posao.gmail@";
	@DataProvider(name = "incorrectEmailData")
    public Object[][] incorrectLogin() {
        return new Object[][] {
        	{"plainaddress"},
	        {"email@domain@domain.com"},
	        {"@hotmail.com"},
	        {"email@.com"},
	        {"email@ domain.com"}
	        };
	}     
	public String incorrectEmailInput() {
		
		return incorrectEmailInput;
}

}