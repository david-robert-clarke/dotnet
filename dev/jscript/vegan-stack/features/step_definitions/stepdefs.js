const assert = require('assert');
const { Before, Given, When, Then } = require('@cucumber/cucumber');
const pactum = require('pactum');

let spec = pactum.spec();

Before(() => { spec = pactum.spec(); });

Given('I navigate to the homepage', function () {
    // this.homepageUrl = 'http://localhost:8080';
    spec.get('https://api.spoonacular.com/recipes/12345/information?apiKey=0686248802174aed8f7c2cbaf912b4bb');
});

When('I enter search term {string}', async function (searchTerm) {
    // this.searchTerm = searchTerm;
    await spec.toss();
});

Then('the following food item should be available for selection', async function (dataTable) {
    spec.response().should.have.status(200);
    spec.response()

    // for (let i = 0; i < dataTable.hashes().length; i++) {
    //     assert.strictEqual(this.searchTerm, dataTable.hashes()[i].Name);
    // }
});