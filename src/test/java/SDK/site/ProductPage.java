package SDK.site;

import org.openqa.selenium.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductPage {
    private By addToBasketDisabled = (byXpath("//a[contains(@data-selenium,'add_to_basket')and(contains(@class,'disabled'))]"));
    private By addToBasketEnabled = (byXpath("//a[contains(@data-selenium,'add_to_basket')]"));
    private By buyOneClickButton = (byXpath("//button[contains(text(),'Купить в 1 клик')]"));

    public boolean getAddToBasketDisabled() { $(addToBasketDisabled).exists(); return true;}
    public boolean getAddToBasketEnabled() { $(addToBasketEnabled).exists(); return true;}
    public boolean getBuyOneClickButton() { $(buyOneClickButton).exists(); return true;}

}
