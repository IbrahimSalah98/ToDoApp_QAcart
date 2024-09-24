package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {
    private static List<Cookie>  restAssueredCookies;
    private static String accessToken ;
    private static String userID ;
    private static String firstName ;
    private static String lastName ;



    public String getFirstName(){
        return this.firstName ;
    }

    public String getLastName(){
        return this.lastName;
    }







    public String getToken (){
        return this.accessToken;
    }
    public String getUserID (){
        return this.userID;
    }


    public List<Cookie> getCookies (){
        return this.restAssueredCookies;
    }
    public void register(){
        User user = new UserUtils().generateRandomUser();




        //giveng
        Response response = given()
                .baseUri("https://todo.qacart.com")
                .header("Content-Type","application/json")
                .body(user)
                .log().all()


//when
                .when()
                .post(EndPoint.API_REGISTER_ENDPOIND)

                //then
                .then()
                .log().all()
                .extract().response();

        if (response.statusCode() != 201)
        {
            throw new RuntimeException("Wrong");
            // System.out.println("Wrong");
        }

        restAssueredCookies = response.getDetailedCookies().asList();
        accessToken = response.path("access_token");
        userID = response.path("userID");

        firstName = response.path("firstName");

        lastName = response.path("lastName");





    }
}
