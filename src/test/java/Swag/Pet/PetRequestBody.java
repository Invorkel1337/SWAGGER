package Swag.Pet;

public class PetRequestBody {
    private final long id;
    private final Category category;
    private String name;
    private final String[] photoUrls;
    private final Tag[] tags;
    private final String status;


public interface ParameterValue{
    interface Pet{
        int ID              =20001;
        int ID_2            =200;
        String ID_STRING    = "petId";
        String ID_EMPTY     = "";
        String NAME         = "Debil";
        String NAME_NEW     = "namePetNew";
        String STATUS       = "availible";
    }
}
///Геттеры и сеттеры
    public PetRequestBody(long id, Category category, String name, String[] photoUrls, Tag[] tags, String status) {
        this.id         = id;
        this.category   = category;
        this.name       = name;
        this.photoUrls  = photoUrls;
        this.tags       = tags;
        this.status     = status;
    }



    public long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public Tag[] getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }


    public static class Category {
        private final long id;
        private final String name;

        public Category(long id, String name) {
            this.id     = id;
            this.name   = name;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tag {
        private final long id;
        private final String name;

        public Tag(long id, String name) {
            this.id     = id;
            this.name   = name;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}

