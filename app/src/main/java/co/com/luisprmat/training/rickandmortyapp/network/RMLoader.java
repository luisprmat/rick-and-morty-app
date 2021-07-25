package co.com.luisprmat.training.rickandmortyapp.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RMLoader {
    private static RMAPI api;
    private static RMLoader loader;
    private final String URL_BASE = "https://rickandmortyapi.com/api/";

    // Singleton pattern
    public static RMAPI getAPI() {
        if (loader == null) loader = new RMLoader();
        return api;
    }

    private RMLoader() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        api = retrofit.create(RMAPI.class);
    }
}
