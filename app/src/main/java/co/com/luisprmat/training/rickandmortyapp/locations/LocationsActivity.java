package co.com.luisprmat.training.rickandmortyapp.locations;

import android.os.Bundle;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.com.luisprmat.training.rickandmortyapp.BaseActivity;
import co.com.luisprmat.training.rickandmortyapp.R;
import co.com.luisprmat.training.rickandmortyapp.network.RMLoader;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

//        loadLocationsFromLocal();

        loadLocationsFromNetwork();
    }

    private void loadLocationsFromNetwork() {
        showProgress("Cargando lugares ...");

        RMLoader.getAPI().getLocations().enqueue(new Callback<LocationsResponse>() {
            @Override
            public void onResponse(Call<LocationsResponse> call, Response<LocationsResponse> response) {
                hideProgress();

                if (response.isSuccessful() && response.body().getResults() != null) {
                    locations.clear();
                    locations.addAll(response.body().getResults());
                    adapter.notifyDataSetChanged();
                } else {
                    showOkDialog("No hay lugares para mostrar");
                }
            }

            @Override
            public void onFailure(Call<LocationsResponse> call, Throwable t) {
                hideProgress();
                showOkDialog("Error cargando lugares");
            }
        });
    }

    private void loadLocationsFromLocal() {
        locations.clear();
        locations.add(new Location("The Menagerie", "Menagerie", "unknown"));
        locations.add(new Location("Rick's Battery Microverse", "Microverse", "Replacement Dimension"));
        locations.add(new Location("Testicle Monster Dimension", "Dimension", "Testicle Monster Dimension"));

        adapter.notifyDataSetChanged();
    }
}
