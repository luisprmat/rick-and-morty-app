package co.com.luisprmat.training.rickandmortyapp.characters;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Character {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private CustomData origin;
    private CustomData location;
    private String image;

    @SerializedName("episode")
    private List<String> episodes;
    private String url;
    private String created;

    public Character(String name, String status, String species, String gender, String image) {
        this.name = name;
        this.status = status;
        this.species = species;
        this.gender = gender;
        this.image = image;
    }

    static class CustomData {
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    public CustomData getOrigin() {
        return origin;
    }

    public CustomData getLocation() {
        return location;
    }

    public String getImage() {
        return image;
    }

    public List<String> getEpisodes() {
        return episodes;
    }

    public String getUrl() {
        return url;
    }

    public String getCreated() {
        return created;
    }
}
