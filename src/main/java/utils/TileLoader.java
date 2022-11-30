package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import engine.tile.Tile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TileLoader {

    private final ArrayList<Tile> allTiles;

    public TileLoader() {
        allTiles = new ArrayList<>();
    }

    public void loadTileList(String filename) throws FileNotFoundException {
        BufferedReader file = new BufferedReader(new FileReader(filename));
        Type jsonListType = new TypeToken<List<Tile>>(){}.getType();
        List<Tile> jsonList = new Gson().fromJson(file, jsonListType);
        allTiles.addAll(jsonList);
    }

    public ArrayList<Tile> getTileList() {
        return new ArrayList<>(this.allTiles);
    }
}