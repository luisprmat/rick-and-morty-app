package co.com.luisprmat.training.rickandmortyapp.characters;

import java.util.List;

import co.com.luisprmat.training.rickandmortyapp.network.models.BaseResponse;

public class CharactersResponse extends BaseResponse {
    private List<Character> results;

    public List<Character> getResults() {
        return results;
    }
}
