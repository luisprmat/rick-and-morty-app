package co.com.luisprmat.training.rickandmortyapp.characters;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import co.com.luisprmat.training.rickandmortyapp.BaseActivity;
import co.com.luisprmat.training.rickandmortyapp.R;

public class CharactersActivity extends BaseActivity {
    RecyclerView rvCharacters;
    TextView tvEmptyList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rvCharacters = findViewById(R.id.rvCharacters);
        rvCharacters.setHasFixedSize(true);

        tvEmptyList = findViewById(R.id.tvEmptyList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvCharacters.setLayoutManager(linearLayoutManager);
    }
}
