package co.com.luisprmat.training.rickandmortyapp.episodes;

import java.util.List;

import co.com.luisprmat.training.rickandmortyapp.network.models.BaseResponse;

public class EpisodesResponse extends BaseResponse {
    private List<Episode> results;

    public List<Episode> getResults() {
        return results;
    }
}
