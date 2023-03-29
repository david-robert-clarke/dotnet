import fetch from "node-fetch";
import "regenerator-runtime/runtime";

describe("Getting client items", () => {
  it("retrieves the simple information from the server.js", async () => {
    const GRAPHQL_URL = "http://localhost:9000";
    const response = await fetch(GRAPHQL_URL, {
      method: "POST",
      headers: {
        "content-type": "application/json",
      },
      body: JSON.stringify({
        query: `query {
                greeting
            }`,
      }),
    });

    const data = await response.json();
    expect(data).toMatchSnapshot();
  });
});
