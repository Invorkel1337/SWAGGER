package Swag.Test.Pet;

import Swag.Pet.PetRequestBody;
import Swag.Pet.PetRequestBodyHelper;
import Swag.Pet.PetStoreAPIClient;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Swag.Pet.PetRequestBody.ParameterValue.Pet.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PetStoreAPITest {
    @Test
    @Description("Создание нового Pet")
    @DisplayName("Post /pet code 200")
    public void testCreateNewPet() {
        PetRequestBody request = PetRequestBodyHelper.createNewPetRequest();

        Response response = PetStoreAPIClient.createNewPet(request);

        response.then().body("name", equalTo(NAME));
        response.then().body("id", equalTo(ID));
    }
    @Test
    @Description("Обновление данных Pet")
    @DisplayName("Put /pet code 200")
    public void testUpdateExistingPet() {
        long petIdToUpdate  = ID_2;
        String newName      = NAME_NEW;

        Response response = PetStoreAPIClient.updatePet(petIdToUpdate, newName);


        response.then().statusCode(200);
        response.then().body("name", equalTo(newName));
        response.then().body("id", equalTo((int)petIdToUpdate));

    }
    @Test
    @Description("Получение id и name Pet")
    @DisplayName("Get /pet code 200")
    public void testGetPetById() {

        Response response = PetStoreAPIClient.getPetById(ID);
        response.then().body("name", equalTo(NAME));
        response.then().body("id", equalTo(ID));
    }
    @Test
    @Description("Удаление pet по id")
    @DisplayName("Delete /pet code 200")
    public void testDeletePetById() {

        PetStoreAPIClient.deletePetById(ID);
        assertTrue(PetStoreAPIClient.isPetDeleted(ID));
    }
}


