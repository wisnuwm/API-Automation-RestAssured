package starter.StepDef;

import java.io.File;

import org.seleniumhq.jetty9.server.Authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;
import starter.Utils.ReqresResponses;
import starter.Utils.UsersAPI;

import static org.hamcrest.Matchers.equalTo;

public class UsersStepDef {
    @Steps
    UsersAPI usersAPI;

    //get list users scenario 1
    @Given("Get list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPage(int page) {
        usersAPI.getListUsers(page);
    }
    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(UsersAPI.GET_LIST_USERS);
    }
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @And("Response body page should be contain page {int}")
    public void responseBodyPageShouldBeContainPage(int page) {
        SerenityRest.and().body(ReqresResponses.PAGE, equalTo(page));
    }
    @And("Validate get list user json schema")
    public void validateGetListUserJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA +"/ListUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }
    //get list users scenario 2
    @Given("Get list users with exceed page {int}")
    public void getListUsersWithExceedPage(int page) {
        usersAPI.getListUsers(page);
    }
    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
    //get list users scenario 3
    @Given("Get list users with invalid parameter page {string}")
    public void getListUsersWithInvalidParameterPage(String page) {
        usersAPI.getListUsersInvalidParameter(page);
    }
    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    //get single user scenario 1
    @Given("Get single users with valid parameter id {int}")
    public void getSingleUsersWithValidParameterId(int id) {
        usersAPI.getSingleUsers(id);
    }
    @When("Send request get single users")
    public void sendRequestGetSingleUsers() {
        SerenityRest.when().get(UsersAPI.GET_SINGLE_USER);
    }
    @And("Response body page should be contain id {int}")
    public void responseBodyPageShouldBeContainId(int id) {
        SerenityRest.and().body(ReqresResponses.DATA_ID, equalTo(id));
    }
    @And("Validate get single user json schema")
    public void validateGetSingleUserJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA +"/SingleUserJSONSchemma.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }
    //get single user scenario 2
    @Given("Get single users with not found user id {int}")
    public void getSingleUsersWithNotFoundUserId(int id) {
        usersAPI.getSingleUsers(id);
    }
    //get single user scenario 3
    @Given("Get single users with invalid parameter id {string}")
    public void getSingleUsersWithInvalidParameterId(String id) {
        usersAPI.getSingleUserInvalidParameter(id);
    }

    //post create new user scenario 1
    @Given("Create new user with valid json")
    public void createNewUserWithValidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/ValidUsersReqBody.json");
        usersAPI.postCreateUser(jsonReq);
    }
    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(UsersAPI.POST_CREATE_USER);
    }
    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }
    @And("Response body name should be {string} and job is {string}")
    public void responseBodyNameShouldBeAndJobIs(String name, String job) {
        SerenityRest.then()
                    .body(ReqresResponses.NAME,equalTo(name))
                    .body(ReqresResponses.JOB,equalTo(job));
    }
    //post create new user scenario 2
    @Given("Create new user with invalid json")
    public void createNewUserWithInvalidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/InvalidUsersReqBody.json");
        usersAPI.postCreateUser(jsonReq);
    }
    //post create new user scenario 3
    @Given("Create new user with not completed json")
    public void createNewUserWithNotCompletedJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/NotCompletedUsersReqBody.json");
        usersAPI.postCreateUser(jsonReq);
    }

    //put update user scenario 1
    @Given("Update user with valid json and parameter id {int}")
    public void updateUserWithValidJsonAndParameterId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/ValidUsersReqBody.json");
        usersAPI.putUpdateUser(id,jsonReq);
    }
    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(UsersAPI.PUT_UPDATE_USER);
    }
    //put update user scenario 2
    @Given("Update user with valid json and not found parameter user id {int}")
    public void updateUserWithValidJsonAndNotFoundParameterUserId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/ValidUsersReqBody.json");
        usersAPI.putUpdateUser(id,jsonReq);
    }
    //put update user scenario 3
    @Given("Update user with invalid json and valid parameter id {int}")
    public void updateUserWithInvalidJsonAndValidParameterId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/InvalidUsersReqBody.json");
        usersAPI.putUpdateUser(id,jsonReq);
    }
    //put update user scenario 4
    @Given("Update user with valid json and invalid parameter id {string}")
    public void updateUserWithValidJsonAndInvalidParameterId(String id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/ValidUsersReqBody.json");
        usersAPI.putUpdateUserInvalidParameter(id,jsonReq);
    }
    //put update user scenario 5
    @Given("Update user with invalid json and invalid parameter id {string}")
    public void updateUserWithInvalidJsonAndInvalidParameterId(String id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/InvalidUsersReqBody.json");
        usersAPI.putUpdateUserInvalidParameter(id,jsonReq);
    }

    //delete user scenario 1
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        usersAPI.deleteUser(id);
    }
    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(UsersAPI.DELETE_USER);
    }
    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidId(String id) {
        usersAPI.deleteUserInvalidParameter(id);
    }
    //delete user scenario 2
    @Given("Delete user with not found user id {int}")
    public void deleteUserWithNotFoundUserId(int id) {
        usersAPI.deleteUser(id);
    }
}
