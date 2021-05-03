package pages.US;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleSearchResult {
    private WebDriver driver;
    private WebElement result;
    public Double price;
    public String name;

    public SingleSearchResult(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.result = element;
        this.price = Double.parseDouble(result.findElement(
                By.xpath("//*[starts-with(@id, \"pricing-price\")]")).
                getText().substring(1));
        this.name = result.findElement(By.className("sku-header")).getText();
        System.out.println(this.price);
    }

    public void addToCart(){
        result.findElement(By.xpath("//*[starts-with(@id, \"fulfillment-add-to-cart-button\")]")).click();
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOf(driver.findElement(By.className("c-overlay-fullscreen"))));
    }
}
