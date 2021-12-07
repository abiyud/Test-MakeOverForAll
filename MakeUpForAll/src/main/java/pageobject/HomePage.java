package pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	public WebDriver driver;
	private static final int TIMEOUT = 30;
	
	@FindBy(xpath = "//*[@id='nav-item-10']//button")
	WebElement btnSearch;
	
	@FindBy(xpath = "//*[contains(@class,'search-input')]/input[@name='search']")
	WebElement inptSearch;
	
	@FindBy(xpath = "//html")
	WebElement blankSpace;
	
	@FindBy(xpath = "//*[@class='close']")
	WebElement btnClosePopUp;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;

        PageFactory.initElements(driver, this);

	}
	
	public void search(String strSearch) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(inptSearch));
		inptSearch.sendKeys(strSearch);
		inptSearch.sendKeys(Keys.ENTER);
	}
	
	public void clickClosePopUp() {
		btnClosePopUp.click();
	}
	
	public void clickBtnSearch() {
		btnSearch.click();
	}
	
	public void clickBlnkSpace() {
		blankSpace.click();
	}
	
	public void hitEnter() {
		btnSearch.sendKeys(Keys.ENTER);
	}
	
	
}
