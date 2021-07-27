package co.com.luisprmat.training.rickandmortyapp.characters;

import android.os.Bundle;

import androidx.annotation.Nullable;

import co.com.luisprmat.training.rickandmortyapp.BaseActivity;
import co.com.luisprmat.training.rickandmortyapp.R;

public class CharacterDetailActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);
    }
}
