package api.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.testng.Assert;


import api.endpoints.*;
import api.payload.PoemEndpoints;
import io.restassured.response.Response;

public class testGetPoemsAPI {
	
	@Test
	public void testgetPoemByTitle() {
		Response response = PoemEndpoints.getTitle("Love's Rose");
		response.then().log().all();
		String title = response.jsonPath().getString("title[0]");
		String author = response.jsonPath().getString("author[0]");
		Assert.
		    assertEquals(response.getStatusCode(), 200); // Assert that status code is 200
		    assertNotNull(title, "Title should not be null");
		    assertEquals("Love's Rose", title, "Title should be 'Love's Rose'");
		    assertNotNull(author, "Author should not be null");
		    assertEquals("Percy Bysshe Shelley", author, "Author should be 'Percy Bysshe Shelley'");
       }
	
	
	@Test
	public void testgetPoemsByAuthor() {
		Response response = PoemEndpoints.getAuthor("Percy Bysshe Shelley");
		response.then().log().all();
		String author = response.jsonPath().getString("author[0]");
		Assert.
		    assertEquals(response.getStatusCode(), 200); // Assert that status code is 200
		    assertNotNull(author, "Author should not be null");
		    assertEquals("Percy Bysshe Shelley", author, "Author should be 'Percy Bysshe Shelley'");
       }
	
	@Test
	public void testgetPoemByLines() {
		Response response = PoemEndpoints.getLines("Latitudeless Place");
		response.then().log().all();
		String title = response.jsonPath().getString("title[0]");
		String author = response.jsonPath().getString("author[0]");
		String linecount = response.jsonPath().getString("linecount[0]");
				
		Assert.
		assertEquals(response.getStatusCode(), 200); // Assert that status code is 200
	    assertNotNull(title, "Title should not be null");
	    assertEquals("Now I knew I lost her --", title, "Title should be 'Now I knew I lost her --'");
	    assertNotNull(author, "Author should not be null");
	    assertEquals("Emily Dickinson", author, "Author should be 'Emily Dickinson'");
	    assertEquals("20", linecount, "linecount should be 20");
       }
	
	@Test
	public void testgetPoemByInvalidTitle() {
		Response response = PoemEndpoints.getTitle("abc13124323");
		response.then().log().all();
		String status =  response.jsonPath().getString("status");
		
    	Assert.
		    assertEquals(response.getStatusCode(), 200); // Assert that status code is 200
		    assertEquals(status, "404");
       }
	
	
	
}
