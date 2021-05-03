package pages.US;

import org.openqa.selenium.*;

public class Home implements pages.Home {
    private WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public Cart clickCart(){
        driver.findElement(By.className("cart-link")).click();
        return new Cart(driver);
    }

    public void addSearchQuery(String query){
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value', arguments[1])",locateSearchBar(), query);
    }

    public String getQuery(){
        return locateSearchBar().getAttribute("value");
    }

    public SearchResults enterSearch(){
        locateSearchBar().sendKeys(Keys.ENTER);
        return new SearchResults(driver);
    }

    public SearchResults clickSearchButton(){
        driver.findElement(By.className("header-search-button")).click();
        return new SearchResults(driver);
    }

    private WebElement locateSearchBar(){
        return driver.findElement(By.xpath("//*[@id=\"header-block\"]/div[2]/div[1]/div/div[2]/div/div[1]/div/div/form"));
    }
}
