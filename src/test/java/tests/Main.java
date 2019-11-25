package tests;

import SDK.site.CategoryPage;
import SDK.site.MainPage;
import SDK.site.ProductPage;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.ScreenShooter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;

import static java.util.concurrent.TimeUnit.*;


@Listeners({ScreenShooter.class})
public class Main {

    public class SelenideTest {

    RemoteWebDriver driver;
    @BeforeTest
    public WebDriver browser() {
        DesiredCapabilities chrome = new DesiredCapabilities();
        chrome.setBrowserName("chrome");
        chrome.setVersion("77.0");
        chrome.setCapability("enableVNC", true);
        chrome.setCapability("enableVideo", false);

        try {
            driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    chrome
            );
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3, SECONDS);
            driver.manage().timeouts().pageLoadTimeout(10, SECONDS);
            driver.get("https://www.sportmaster.ru/");
            WebDriverRunner.setWebDriver(driver);
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    //Поиск коньков через поисковую строку, но он их не находит через поиск
    @Test
    public void main001() {

        //driver.get("https://www.sportmaster.ru/");
        //getWebDriver().navigate().to("https://www.sportmaster.ru/");
        //open("https://www.sportmaster.ru/");
        MainPage main = new MainPage();
        main.clickYesButton();
        Assert.assertNotNull(main.getLogoImage());
        main.clearSearch();
        main.setSearchText("Bauer BTH18 SUPREME 2S PRO");
        main.clickSearch();
        String text = main.getSearchResultsText();
        System.out.println(text);
        Assert.assertTrue(main.getSearchResultsText().contains("По запросу «Bauer BTH18 SUPREME 2S PRO» найдено 0 товаров"), "Результаты поиска");

        //Поиск через вспылвающий поиск
        String search = "BTH18 SUPREME 2S PRO";
        main.clearSearch();
        main.setSearchText(search);
        Assert.assertTrue(main.getSearchResult(search));
        main.clickBySearchResult(search);
        ProductPage product = new ProductPage();
        Assert.assertTrue(product.getAddToBasketDisabled(), "Проверка что кнопка в корзину недоступна");

        //Проверим коньки которые есть в наличии
        String search1 = "BTH18 SUPREME S27";
        main.clearSearch();
        main.setSearchText(search1);
        Assert.assertTrue(main.getSearchResult(search1));
        main.clickBySearchResult(search1);
        Assert.assertTrue(product.getAddToBasketEnabled(), "Проверка что кнопка в корзину доступна");
        Assert.assertTrue(product.getBuyOneClickButton(),"Проверка кнопки купить в 1 клик");

        //Переходим в коньки через меню
        driver.get("https://www.sportmaster.ru/");
        main.menuNavigate("Ледовые коньки и хоккей", "Коньки");
        CategoryPage category = new CategoryPage();
        category.selectBrand("Bauer");
        category.clickOnProduct(search1);
        Assert.assertTrue(product.getAddToBasketEnabled(), "Проверка что кнопка в корзину доступна");
        Assert.assertTrue(product.getBuyOneClickButton(),"Проверка кнопки купить в 1 клик");
    }
}
}
