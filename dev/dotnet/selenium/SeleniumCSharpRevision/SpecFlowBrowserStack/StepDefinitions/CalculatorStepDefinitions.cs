using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace SpecFlowBrowserStack.StepDefinitions
{
    [Binding]
    public sealed class CalculatorStepDefinitions
    {
        IWebDriver driver;

        [BeforeScenario]
        public void BeforeScenario()
        {
            string path = Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName;
            driver = new ChromeDriver(path + @"\Drivers\");
        }

        [Given("the first number is (.*)")]
        public void GivenTheFirstNumberIs(int number)
        {
            driver.Navigate().GoToUrl("https://www.browserstack.com/");
            driver.FindElement(By.CssSelector("[aria-label=\"Search\"]")).Click();
            driver.FindElement(By.Id("doc-search-box-input")).SendKeys("Specflow");
            driver.FindElement(By.Id("doc-search-box-input")).SendKeys(Keys.Return);
            Assert.That(driver.FindElement(By.CssSelector("[aria-label=\"Selenium with SpecFlow\"]")).Displayed);
        }


    }
}