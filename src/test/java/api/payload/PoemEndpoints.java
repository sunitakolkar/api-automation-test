package api.payload;

import api.endpoints.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class PoemEndpoints {
	public static Response getAuthor(String author){
		Response response = given()
		   .pathParam("author",author)
		
		.when()
		.get(Routes.get_author_url);
		return response;
	}
	
	public static Response getTitle(String title){
		Response response = given()
		   .pathParam("title",title)
		
		.when()
		.get(Routes.get_title_url);
		return response;
	}
	
	public static Response getLines(String lines){
		Response response = given()
		   .pathParam("lines",lines)
		
		.when()
		.get(Routes.get_lines_url);
		return response;
	}

}
