package io.github.jaceg18.crates.Utility;

import io.github.jaceg18.crates.Memory.FileManager;

import java.util.ArrayList;
import java.util.List;

public class CrateManager {

    List<Crate> crates;

    FileManager fileManager;
    public CrateManager(){
        crates = new ArrayList<>();
        fileManager = new FileManager();
        loadCrates();
    }

    public void loadCrates(){
        crates = fileManager.loadCrateData();
    }

    public void saveCrates(){
        fileManager.saveCrateData(crates);
    }

    public void addCrate(Crate crate){
        crates.add(crate);
        loadCrates();
    }

    public void deleteCrate(String name){
            crates.remove(getCrate(name));
    }

    public Crate getCrate(String name){
        for (Crate crate : crates)
            if (crate.getName().equalsIgnoreCase(name))
                return crate;

        return null;
    }

    public List<String> getCratesAsString(){
        List<String> crateList = new ArrayList<>();
        for (Crate crate : crates)
            crateList.add(crate.name);

        return crateList;
    }

    public List<Crate> getCrates(){
        return crates;
    }



}
