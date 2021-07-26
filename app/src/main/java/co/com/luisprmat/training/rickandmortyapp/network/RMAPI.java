package co.com.luisprmat.training.rickandmortyapp.network;

import co.com.luisprmat.training.rickandmortyapp.characters.CharactersResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RMAPI {
    @GET("character")
    Call<CharactersResponse> getCharacters();
}
