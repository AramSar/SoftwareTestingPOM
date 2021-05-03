package pages.US;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class SearchResults {
    private WebDriver driver;
    public String url;
    public ArrayList<SingleSearchResult> searchResults;


    public SearchResults(WebDriver driver) {
        this.driver = driver;
        this.url = driver.getCurrentUrl();
        for(WebElement elem: driver.findElements(By.className("sku-item"))){
            this.searchResults.add(new SingleSearchResult(driver, elem));
        }
    }

    public SearchResults clickPriceRange0(boolean select){
        driver.findElement(By.id("currentprice_facet-Less-than-$25-0")).click();
        if (select) {
            new WebDriverWait(driver, 5).until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("facets-wrapper")));
        } else {
            new WebDriverWait(driver, 5).until(
                    ExpectedConditions.invisibilityOfElementLocated(By.className("facets-wrapper")));
        }
        return new SearchResults(driver);
    }
}
