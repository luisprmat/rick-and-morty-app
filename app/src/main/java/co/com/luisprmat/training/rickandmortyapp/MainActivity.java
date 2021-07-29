package co.com.luisprmat.training.rickandmortyapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;

import co.com.luisprmat.training.rickandmortyapp.characters.CharactersActivity;
import co.com.luisprmat.training.rickandmortyapp.commons.Constants;
import co.com.luisprmat.training.rickandmortyapp.episodes.EpisodesActivity;
import co.com.luisprmat.training.rickandmortyapp.locations.Location;
import co.com.luisprmat.training.rickandmortyapp.locations.LocationsActivity;

public class MainActivity extends BaseActivity {
    private enum BTEvent {
        CHARACTERS, FAVS, EPISODES, PLACES
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btCharacters).setOnClickListener(v -> buttonEvent(BTEvent.CHARACTERS));
        findViewById(R.id.btPlaces).setOnClickListener(v -> buttonEvent(BTEvent.PLACES));
        findViewById(R.id.btEpisodes).setOnClickListener(v -> buttonEvent(BTEvent.EPISODES));
        findViewById(R.id.btFavs).setOnClickListener(v -> buttonEvent(BTEvent.FAVS));


    }

    private  void buttonEvent(BTEvent btEvent) {
        Intent i = null;

        switch (btEvent) {
            case CHARACTERS:
                i = new Intent(MainActivity.this, CharactersActivity.class);
                break;

            case PLACES:
                i = new Intent(MainActivity.this, LocationsActivity.class);
                break;

            case EPISODES:
                i = new Intent(MainActivity.this, EpisodesActivity.class);
                break;

            case FAVS:
                i = new Intent(MainActivity.this, CharactersActivity.class);
                i.putExtra(Constants.EXTRA_FAVS, true);
                break;
        }

        startActivity(i);
    }
}