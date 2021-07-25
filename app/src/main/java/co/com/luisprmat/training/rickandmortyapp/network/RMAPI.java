package co.com.luisprmat.training.rickandmortyapp.network;

import co.com.luisprmat.training.rickandmortyapp.network.models.BaseResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RMAPI {
    @GET("characters")
    Call<BaseResponse> getCharacters();
}
