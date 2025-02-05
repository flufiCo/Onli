package tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FooterTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://only.digital/");
    }

    @Test(priority = 1)
    public void testContactLinks() {
        WebElement emailLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'Footer_contacts__s7c9v')]//a[contains(@href, 'mailto:hello@only.digital')]\n")));
        Assert.assertTrue(emailLink.isDisplayed(), "Email link is not displayed");
        Assert.assertEquals(emailLink.getText(), "hello@only.digital", "Email link text is incorrect");

        WebElement phoneLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'Footer_contacts__s7c9v')]//a[contains(@href, 'tel:+7 (495) 740 99 79')]")));
        Assert.assertTrue(phoneLink.isDisplayed(), "Phone link is not displayed");
        Assert.assertEquals(phoneLink.getText(), "+7 (495) 740 99 79", "Phone link text is incorrect");
    }

    @Test(priority = 2)
    public void testCopyrightText() {
        WebElement copyrightText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[@class='h4 Footer_year__nyNCc' and text()='© 2014 - ' and text()='2025']")));
        Assert.assertTrue(copyrightText.isDisplayed(), "Copyright text is not displayed");
        Assert.assertEquals(copyrightText.getText(), "© 2014 - 2025", "Copyright text is incorrect");
    }

    @Test(priority = 3)
    public void testSocialMediaLinks() {
        WebElement behanceLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='Socials_socialsWrap__DPtp_ Footer_socials__C39yX']//a[@href='https://www.behance.net/onlydigitalagency']")));
        Assert.assertTrue(behanceLink.isDisplayed(), "Behance link is not displayed");

        WebElement telegramLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='Socials_socialsWrap__DPtp_ Footer_socials__C39yX']//a[contains(@href, 'https://t.me/onlycreativedigitalagency')]")));
        Assert.assertTrue(telegramLink.isDisplayed(), "Telegram link is not displayed");

        WebElement vkLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='Socials_socialsWrap__DPtp_ Footer_socials__C39yX']//a[contains(@href, 'https://vk.com/onlydigitalagency')]")));
        Assert.assertTrue(vkLink.isDisplayed(), "VK link is not displayed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}