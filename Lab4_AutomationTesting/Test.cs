using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace Lab4_AutomationTesting
{
    class Test
    {
        private static IWebDriver myChromeDriver;

        static void Main(string[] args)
        {
            myChromeDriver = new ChromeDriver("X:\\Universitate\\Anul 3\\Semestrul_ll\\Testarea_Software\\Laboratoare\\Lab_4\\Lab4_AutomationTesting");

            SearchForComputer("https://www.aliexpress.com/", new ElementPath().aliexpressInputTextSearchField, new ElementPath().aliexpressHeader);
        }

        //Se cauta elementul "computer" si se verifica daca header-ul se afiseaza
        static void SearchForComputer(string siteAddress, string inputSearchTextField, string aliexpressHeader)
        {
            myChromeDriver.Manage().Window.Maximize();
            myChromeDriver.Navigate().GoToUrl(siteAddress);
            if (siteAddress == "https://9gag.com/")
            {
                myChromeDriver.FindElement(By.XPath("//a[@class='search']")).Click();
            }
            var searchingElement = myChromeDriver.FindElement(By.XPath(inputSearchTextField));
            searchingElement.Click();
            searchingElement.SendKeys("computer");
            searchingElement.SendKeys(Keys.Enter);

            //Daca header-ul a fost gasit se afiseaza mesajul afirmativ
            if (myChromeDriver.FindElement(By.XPath(aliexpressHeader)) != null)
            {
                Console.WriteLine("\n\nAliexpress Header is displayed\n\n");
                Console.ReadLine();
            }
            else
            {
                Console.WriteLine("Aliexpress Header is not displayed");
                Console.ReadLine();
            }
        }
    }
}
