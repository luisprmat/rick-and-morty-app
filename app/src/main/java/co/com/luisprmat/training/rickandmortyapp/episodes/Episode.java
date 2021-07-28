package co.com.luisprmat.training.rickandmortyapp.episodes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Episode {
    private String name;
    @SerializedName("air_date") private String airDate;
    private String episode;
    private List<String> characters;
    private String url;
    private String created;

    public String getName() {
        return name;
    }

    public String getAirDate() {
        return airDate;
    }

    public String getEpisode() {
        return episode;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public String getUrl() {
        return url;
    }

    public String getCreated() {
        return created;
    }
}
