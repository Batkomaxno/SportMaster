package SDK.site;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CategoryPage {
    public void selectBrand(String brandName) {$(byXpath("//div/a[contains(text(),'" + brandName + "')]")).click();}
    public void clickOnProduct(String productName) { $(byXpath("//*[@id=\"categoryItemContainer\"]/div/h2/a[contains(text(),'" + productName + "')]")).click();}
}
