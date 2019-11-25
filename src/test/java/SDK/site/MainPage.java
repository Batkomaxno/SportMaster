package SDK.site;

import org.openqa.selenium.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private By logo = (byId("logoImage"));
    private By search = (byName("text"));
    private By searchResults = (byXpath("/html/body/div[3]/h1"));
    private By yesButton = (byXpath("//input[contains(@value,'Да')]"));


    public void clickYesButton() {$(yesButton).click();}
    public By getLogoImage() { return logo; }
    public void clearSearch() { try {
        $(search).clear(); }
        catch (StaleElementReferenceException e) {
            System.out.println("Не нашел строку поиска"); }
        }
    public void setSearchText(String value) { try {
        $(search).setValue(value);
    } catch (StaleElementReferenceException e) {
            System.out.println("Не нашел строку поиска"); }
    }
    public void clickSearchInput() { $(search).click(); }
    public String getSearchResultsText() { return $(searchResults).getText(); }
    public void clickSearch() { $(byXpath("(//input[contains(@type,'submit')])[1]")).click();}
    public void clickBySearchResult(String value) { $(byXpath("//*[@id=\"productSearchContainer\"]/div/div[2]/div[2]/ul/li[1]/a/div[2]/div[contains(text(),'" + value + "')]")).click(); }
    public boolean getSearchResult(String value) { $(byXpath("//*[@id=\"productSearchContainer\"]/div/div[2]/div[2]/ul/li[1]/a/div[2]/div[contains(text(),'" + value + "')]")).should(visible); return true; }
    public void menuNavigate(String category, String subCategory) {
        $(byId("newMenu")).hover();
        $(byXpath("//span[contains(text(),'" + category + "')]")).hover();
        $(byXpath("(//*[@id=\"newMenu\"]/ul/li/div/div/div/div/ul/li/a[contains(text(),'" + subCategory + "')])[1]")).click();
    }






}
