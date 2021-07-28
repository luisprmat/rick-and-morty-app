package co.com.luisprmat.training.rickandmortyapp.episodes;

import android.os.Bundle;

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

public class EpisodesActivity extends BaseActivity {
    private List<Episode> episodes = new ArrayList<>();
    private EpisodeAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes);

        RecyclerView rvEpisodes = findViewById(R.id.rvEpisodes);
        rvEpisodes.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvEpisodes.setLayoutManager(linearLayoutManager);

        adapter = new EpisodeAdapter(this, episodes);
        rvEpisodes.setAdapter(adapter);

        loadEpisodes();
    }

    private void loadEpisodes() {
        showProgress("Cargando episodios");

        RMLoader.getAPI().getEpisodes().enqueue(new Callback<EpisodesResponse>() {
            @Override
            public void onResponse(Call<EpisodesResponse> call, Response<EpisodesResponse> response) {
                hideProgress();
                if (response.isSuccessful() && response.body().getResults() != null) {
                    episodes.clear();
                    episodes.addAll(response.body().getResults());
                    adapter.notifyDataSetChanged();
                } else {
                    showOkDialog("Error cargando episodios");
                }
            }

            @Override
            public void onFailure(Call<EpisodesResponse> call, Throwable t) {
                hideProgress();
                showOkDialog("Error cargando episodios");
            }
        });
    }
}
