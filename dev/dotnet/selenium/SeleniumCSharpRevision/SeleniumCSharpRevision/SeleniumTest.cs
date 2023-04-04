

using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace SeleniumCSharpRevision
{
    public class UI_Tests
    {
        IWebDriver driver;

        [SetUp]
        public void Setup()
        {

            string path = Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName;
            driver = new ChromeDriver(path + @"\drivers\");
        }

        [Test]
        public void VerifySearchButton()
        {
            driver.Navigate().GoToUrl("https://www.browserstack.com/");
            driver.FindElement(By.CssSelector("[aria-label=\"Search\"]")).Click();
            driver.FindElement(By.Id("doc-search-box-input")).SendKeys("Specflow");
            driver.FindElement(By.Id("doc-search-box-input")).SendKeys(Keys.Return);
            Assert.That(driver.FindElement(By.CssSelector("[aria-label=\"Selenium with SpecFlow\"]")).Displayed);
            //Assert.IsTrue(driver.FindElement(By.CssSelector("[aria-label=\"Search\"]")).Displayed);
        }
    }
}