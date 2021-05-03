package SearchTests;
import base.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US.SearchResults;
import pages.US.SingleSearchResult;

public class SearchTests extends BaseTest {

    private pages.US.Home home;

    @BeforeMethod
    public void beforeMethod(){
        home = countryPage.selectUS().closeModal();
    }

    @Test
    public void testAddingQuery() {
        home.addSearchQuery("flash drive");
        assertEquals(home.getQuery(), "flash drive");
    }

    @Test
    public void testGettingResults() {
        // To get the screenshot
        home.addSearchQuery("flash drive");
        SearchResults e = home.clickSearchButton();
        for(SingleSearchResult s: e.searchResults){
            System.out.println(s.name);
        }
        assertTrue(false);
    }
}
