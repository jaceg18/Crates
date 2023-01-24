package io.github.jaceg18.crates;

import io.github.jaceg18.crates.Commands.CrateCommand;
import io.github.jaceg18.crates.Utility.CrateManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Crates extends JavaPlugin {
    private static Crates instance;
    public static CrateManager crateManager = new CrateManager();
    public static boolean isSetting = false;
    public static String crateToSet = null;

    @Override
    public void onEnable() {
        instance = this;

        Objects.requireNonNull(getCommand("crates")).setExecutor(new CrateCommand());
    }
    public static Crates getInstance(){
        return instance;
    }

}
