package io.github.jaceg18.crates.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Information {

    public static void displayInformation(Player player){
        player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "               Custom Crates - v1");
        player.sendMessage(ChatColor.GRAY + "-Developed by ftJace");
        player.sendMessage("--------------------------------------");
        player.sendMessage(ChatColor.GREEN + "/crates - for help menu");
        player.sendMessage(ChatColor.GREEN + "/crates info <crate> - display info on crate");
        player.sendMessage(ChatColor.GREEN + "/crates create <crate> - create a create (color codes not supported yet)");
        player.sendMessage(ChatColor.GREEN + "/crates addDrop <crate> <chance> (1-100) - Adds item in hand - only supports whole numbers");
        player.sendMessage(ChatColor.GREEN + "/crates removeDrop <crate> - Removes item in hand");
        player.sendMessage(ChatColor.GREEN + "/crates rename <crate> <name> - Renames a crate");
        player.sendMessage(ChatColor.GREEN + "/crates delete <crate> - deletes a crate");
        player.sendMessage(ChatColor.GREEN + "/crates reload - reloads the crates plugin");
        player.sendMessage(ChatColor.GREEN + "/crates set <crate> - next block hit will set the block as crate");
    }


}
