package io.github.jaceg18.crates.Memory;

import io.github.jaceg18.crates.Crates;
import io.github.jaceg18.crates.Utility.Crate;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class FileManager {

    File saveBin;

    public FileManager(){
        buildFiles();
    }

    @SuppressWarnings("all")
    private void buildFiles(){
        if (!Crates.getInstance().getDataFolder().exists())
        {
            Crates.getInstance().getDataFolder().mkdir();
            saveBin = new File(Crates.getInstance().getDataFolder(), "crates.bin");
        }
    }

    public List<Crate> saveAndLoad(List<Crate> crates){
        saveCrateData(crates);
        return loadCrateData();
    }

    public void saveCrateData(List<Crate> crates){
        try {
            BukkitObjectOutputStream out = new BukkitObjectOutputStream(new GZIPOutputStream(Files.newOutputStream(saveBin.toPath())));
            out.writeObject(crates);
            out.close();
        } catch (IOException e){e.printStackTrace();}
    }

    @SuppressWarnings("all")
    public List<Crate> loadCrateData(){
        List<Crate> crates = new ArrayList<>();
        try {
            BukkitObjectInputStream in = new BukkitObjectInputStream(new GZIPInputStream(Files.newInputStream(saveBin.toPath())));
            crates = (List<Crate>) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e){e.printStackTrace();}

        return crates;
    }


}
