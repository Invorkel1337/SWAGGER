package swag.pet;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
;
import static swag.pet.PetRequestBodyHelper.*;
import static io.restassured.RestAssured.given;

public class PetStoreAPIClient {
    private static final String PET_ENDPOINT = "https://petstore.swagger.io/v2/pet";

    public static Response createNewPet(PetRequestBody request) {
        return given()
                .contentType(ContentType.JSON)
                .body(request)
                .post(PET_ENDPOINT)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }


    public static Response updatePet(long petId, String newName) {
        PetRequestBody request = createPetRequestBody(petId, newName);
        return given()
                .contentType(ContentType.JSON)
                .body(request)
                .put(PET_ENDPOINT)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }

    public static Response getPetById(long ID_STRING) {
        return given()
                .get(PET_ENDPOINT + "/" + ID_STRING)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }

    public static Response deletePetById(long ID_STRING) {
        return given()
                .delete(PET_ENDPOINT + "/" + ID_STRING)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }

    public static boolean isPetDeleted(long ID_STRING) {
        Response response = given()
                .get(PET_ENDPOINT + "/" + ID_STRING)
                .then()
                .extract().response();
        return response.statusCode() == HttpStatus.SC_NOT_FOUND;
    }
}

