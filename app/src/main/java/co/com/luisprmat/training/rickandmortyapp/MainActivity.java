package co.com.luisprmat.training.rickandmortyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import co.com.luisprmat.training.rickandmortyapp.characters.CharactersActivity;
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
        }

        startActivity(i);
    }
}