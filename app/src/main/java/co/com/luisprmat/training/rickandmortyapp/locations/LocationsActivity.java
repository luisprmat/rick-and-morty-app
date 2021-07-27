package co.com.luisprmat.training.rickandmortyapp.locations;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.com.luisprmat.training.rickandmortyapp.BaseActivity;
import co.com.luisprmat.training.rickandmortyapp.R;

public class LocationsActivity extends BaseActivity {
    List<Location> locations = new ArrayList<>();
    LocationsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);

        getSupportActionBar().setTitle("Lugares");

        RecyclerView rvLocations = findViewById(R.id.rvLocations);
        rvLocations.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvLocations.setLayoutManager(linearLayoutManager);

        adapter = new LocationsAdapter(this, locations);

        rvLocations.setAdapter(adapter);

        populateLocationsMockup();
    }

    private void populateLocationsMockup() {
        locations.clear();
        locations.add(new Location("The Menagerie", "Menagerie", "unknown"));
        locations.add(new Location("Rick's Battery Microverse", "Microverse", "Replacement Dimension"));
        locations.add(new Location("Testicle Monster Dimension", "Dimension", "Testicle Monster Dimension"));

        adapter.notifyDataSetChanged();
    }
}
