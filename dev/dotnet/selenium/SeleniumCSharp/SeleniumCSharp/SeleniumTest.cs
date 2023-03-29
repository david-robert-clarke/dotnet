using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System;
using System.Collections.ObjectModel;
using System.IO;

namespace SeleniumCSharp
{
    public class Tests
    {
        IWebDriver driver;

        [OneTimeSetUp]
        public void Setup()
        {
            var path = Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName;
            driver = new ChromeDriver(path + @"\drivers");
        }

        [Test, Parallelizable]
        public void verifyLoago()
        {
            driver.Navigate().GoToUrl("https://www.browserstack.com/");
            Assert.IsTrue(driver.FindElement(By.Id("logo")).Displayed);
        }

        [Test, Parallelizable]
        public void verifyMenuItemCount()
        {
            ReadOnlyCollection<IWebElement> menuItem = driver.FindElements(By.XPath("//ul[contains(@class,'horizontal-list product-menu')]/li"));
            Assert.That(4, Is.EqualTo(menuItem.Count));
        }

        [Test, Parallelizable]
        public void verifyPricingPage()
        {
            driver.Navigate().GoToUrl("https://browserstack.com/pricing");
            IWebElement contactUsPageHeader = driver.FindElement(By.TagName("h1"));
            Assert.IsTrue(contactUsPageHeader.Text.Contains("Real device cloud of 20,000 + real iOS & Android devices, instantly accessible"));
         }

        [OneTimeTearDown]
        public void TearDown()
        {
            driver.Quit();
        }

    }
}