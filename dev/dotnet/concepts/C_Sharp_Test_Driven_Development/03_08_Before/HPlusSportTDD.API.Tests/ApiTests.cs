using HPlusSportTDD.API.Controllers;
using Microsoft.AspNetCore.Mvc;

namespace HPlusSportTDD.API.Tests;

public class Tests
{
    [SetUp]
    public void Setup()
    {
    }

    [Test]
    public void ShouldReturnAllArticles()
    {
        var articleController = new ArticlesController();
        var results = articleController.GetAll();
        foreach (var result in results)
        {
            Console.WriteLine(value: $"{result.Id} {result.Name} {result.Price}");
        }
        Assert.AreEqual(3, results.Count());

    }

    [Test]
    public void ShouldReturnASingleArticle()
    {
        var articleController = new ArticlesController();
        var article = articleController.GetSingle(1);
        Assert.IsInstanceOf(typeof(OkObjectResult), article);
    }

    [Test]
    public void ShouldNotReturnAnArticle()
    {
        var articleController = new ArticlesController();
        var article = articleController.GetSingle(10);
        Assert.AreEqual(404, (article as StatusCodeResult)?.StatusCode);
    }

}