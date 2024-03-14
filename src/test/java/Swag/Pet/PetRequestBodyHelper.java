package Swag.Pet;

import Swag.Pet.PetRequestBody;

import static Swag.Pet.PetRequestBody.ParameterValue.Pet.*;

public class PetRequestBodyHelper {
    public static PetRequestBody createNewPetRequest() {
        return new PetRequestBody(
                ID,
                new PetRequestBody.Category(0, "string"),
                NAME,
                new String[]{"string"},
                new PetRequestBody.Tag[]{new PetRequestBody.Tag(0, "string")},
                STATUS
        );
    }

    public static PetRequestBody createPetRequestBody(long petId, String newName) {
        return new PetRequestBody(
                petId,
                new PetRequestBody.Category(0, "string"),
                newName,
                new String[]{"string"},
                new PetRequestBody.Tag[]{new PetRequestBody.Tag(0, "string")},
                "available"
        );
    }
}