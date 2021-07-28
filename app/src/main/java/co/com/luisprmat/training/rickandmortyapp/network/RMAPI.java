package co.com.luisprmat.training.rickandmortyapp.network;

import co.com.luisprmat.training.rickandmortyapp.characters.CharactersResponse;
import co.com.luisprmat.training.rickandmortyapp.episodes.EpisodesResponse;
import co.com.luisprmat.training.rickandmortyapp.locations.LocationsResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RMAPI {
    @GET("character")
    Call<CharactersResponse> getCharacters();

    @GET("location")
    Call<LocationsResponse> getLocations();

    @GET("episode")
    Call<EpisodesResponse> getEpisodes();
}
