package co.com.luisprmat.training.rickandmortyapp.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.com.luisprmat.training.rickandmortyapp.BaseActivity;
import co.com.luisprmat.training.rickandmortyapp.R;
import co.com.luisprmat.training.rickandmortyapp.commons.Constants;
import co.com.luisprmat.training.rickandmortyapp.commons.StorageManager;
import co.com.luisprmat.training.rickandmortyapp.network.RMLoader;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharactersActivity extends BaseActivity {
    RecyclerView rvCharacters;
    TextView tvEmptyList;
    List<Character> characters = new ArrayList<>();
    CharacterAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_characters);

        rvCharacters = findViewById(R.id.rvCharacters);
        rvCharacters.setHasFixedSize(true);

        tvEmptyList = findViewById(R.id.tvEmptyList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvCharacters.setLayoutManager(linearLayoutManager);

        adapter = new CharacterAdapter(this, characters);

        rvCharacters.setAdapter(adapter);

        boolean favs = getIntent().getBooleanExtra(Constants.EXTRA_FAVS, false);

        if (favs) loadCharactersFromFavs();
        else loadCharactersFromNetwork();
    }

    private void loadCharactersFromFavs() {
        List<Character> characterList = StorageManager.getInstance(this).getCharacters();

        if (characterList.isEmpty()) {
            tvEmptyList.setVisibility(View.VISIBLE);
            rvCharacters.setVisibility(View.GONE);
        } else {
            tvEmptyList.setVisibility(View.GONE);
            rvCharacters.setVisibility(View.VISIBLE);

            characters.clear();
            characters.addAll(characterList);
            adapter.notifyDataSetChanged();
        }
    }

    private void loadCharactersFromNetwork() {
        showProgress("Cargando personajes ...");

        RMLoader.getAPI().getCharacters().enqueue(new Callback<CharactersResponse>() {
            @Override
            public void onResponse(Call<CharactersResponse> call, Response<CharactersResponse> response) {
                hideProgress();
                if (response.isSuccessful() && response.body().getResults() != null) {
                    characters.clear();
                    characters.addAll(response.body().getResults());
                    adapter.notifyDataSetChanged();
                } else {
                    showOkDialog("No encontramos presonajes");
                }
            }

            @Override
            public void onFailure(Call<CharactersResponse> call, Throwable t) {
                hideProgress();
                showOkDialog("Error cargando personajes");
            }
        });
    }
}
