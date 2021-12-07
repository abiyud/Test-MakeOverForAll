package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	public WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getTextResult(String text) {
		return driver.findElements(By.xpath("//*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"+text+"') and contains(@class,'card-title')]"));
	}
	
	public WebElement getTextFound(String text) {
		return driver.findElement(By.xpath("//*[contains(@class,'search-text-found')]//strong"));
	}
	
	public boolean getText(WebElement element) {
		return element.isDisplayed();
	}
}
