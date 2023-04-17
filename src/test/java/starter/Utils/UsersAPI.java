package starter.Utils;

import java.io.File;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UsersAPI {
    public static String GET_LIST_USERS = Constant.BASE_URL+"/api/users?page={page}";
    public static String GET_SINGLE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String POST_CREATE_USER = Constant.BASE_URL+"/api/users";
    public static String PUT_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constant.BASE_URL+"/api/users/{id}";

    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given()
                    .pathParam("page",page);
    }
    @Step("Get list users with invalid parameter")
    public void getListUsersInvalidParameter(String page){
        SerenityRest.given()
                    .pathParam("page",page);
    }
    @Step("Get single user")
    public void getSingleUsers(int id){
        SerenityRest.given()
                    .pathParam("id",id);
    }
    @Step("Get single user with invalid parameter")
    public void getSingleUserInvalidParameter(String id){
        SerenityRest.given()
                    .pathParam("id",id);
    }
    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }
    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                    .pathParam("id",id)
                    .contentType(ContentType.JSON)
                    .body(json);
    }
    @Step("Put update user with invalid parameter")
    public void putUpdateUserInvalidParameter(String id, File json){
        SerenityRest.given()
                    .pathParam("id",id)
                    .contentType(ContentType.JSON)
                    .body(json);
    }
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                    .pathParam("id",id);
    }
    @Step("Delete user with invalid parameter")
    public void deleteUserInvalidParameter(String id){
        SerenityRest.given().
                pathParam("id",id);
    }
}
