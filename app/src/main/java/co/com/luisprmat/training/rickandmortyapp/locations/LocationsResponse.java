package co.com.luisprmat.training.rickandmortyapp.locations;

import java.util.List;

import co.com.luisprmat.training.rickandmortyapp.network.models.BaseResponse;

public class LocationsResponse extends BaseResponse {
    private List<Location> results;

    public List<Location> getResults() {
        return results;
    }
}
