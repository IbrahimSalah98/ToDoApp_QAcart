package com.qacart.todo.api;

import com.qacart.todo.objects.User;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginApi {
    private Cookies restAssueredCookies;
    private String accessToken ;
    private String userID ;

    public String getToken (){
        return this.accessToken;
    }
    public String getUserID (){
        return this.userID;
    }


    public Cookies getCookies (){
        return this.restAssueredCookies;
    }
    public void logIn(){
        User user = new User("himasalah646@gmail.com", "Hima2015" ){

        };


        //giveng
        Response response = given()
                .baseUri("https://todo.qacart.com")
                .header("Content-Type","application/json")
                .body(user)
                .log().all()


//when
                .when()
                .post("/api/v1/users/login")

                //then
                .then()
                .log().all()
                .extract().response();

        if (response.statusCode() != 201)
        {
            System.out.println("Wrong");
        }

         restAssueredCookies = response.getDetailedCookies();
        accessToken = response.path("access_token");
        userID = response.path("userID");

        if (response.statusCode() != 201)
        {
            throw new RuntimeException("Wrong");
            // System.out.println("Wrong");
        }



    }
}
