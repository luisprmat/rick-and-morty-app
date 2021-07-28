package co.com.luisprmat.training.rickandmortyapp.commons;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import co.com.luisprmat.training.rickandmortyapp.characters.Character;

public class StorageManager {
    private Context context;
    private static StorageManager storageManager;

    private final String prefsName = "ANDROID_RM_PREFS";
    private final String prefsCharacters = "ANDROID_RM_CHARACTERS_PREFS";

    private Type charactersType;

    public static StorageManager getInstance(Context context) {
        if (storageManager == null)
            storageManager = new StorageManager(context);

        return storageManager;
    }

    private StorageManager(Context context) {
        this.context = context;

        charactersType = new TypeToken<List<Character>>() {}.getType();
    }

    public List<Character> getCharacters() {
        SharedPreferences prefs = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
        String jsonCharacters = prefs.getString(prefsCharacters, "");

        if (jsonCharacters.isEmpty()) {
            return new ArrayList<>();
        } else {
            return new Gson().fromJson(jsonCharacters, charactersType);
        }
    }

    public void addCharacter(Character character) {
        List<Character> characterList = getCharacters();

        characterList.add(character);

        Gson gson = new Gson();
        String jsonObj = gson.toJson(characterList);

        SharedPreferences.Editor editor = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE).edit();
        editor.putString(prefsCharacters, jsonObj);
        editor.apply();
    }
}
