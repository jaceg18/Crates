package io.github.jaceg18.crates.Commands;

import io.github.jaceg18.crates.Crates;
import io.github.jaceg18.crates.Utility.Crate;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrateCommand extends CommandHandler {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player && sender.isOp()) {
            Player player = (Player) sender;

            if (args.length == 0)
                Information.displayInformation(player);

            if (args.length == 1)
                if (args[0].equalsIgnoreCase("reload"))
                    Crates.crateManager.loadCrates();

            if (args.length == 2)
                switch(args[0])
                {
                    case "create" -> {
                        Crates.crateManager.addCrate(new Crate(args[1]));
                        player.sendMessage("Crate: " + args[1] + " has been created");
                    }
                    case "removeDrop" -> {
                        Crates.crateManager.getCrate(args[1]).removeItem(player.getInventory().getItemInMainHand());
                        player.sendMessage("Drop has been removed");
                    }
                    case "delete" -> {
                        Crates.crateManager.deleteCrate(args[1]);
                        player.sendMessage("Crate: " + args[1] + " has been deleted");
                    }
                    case "info" ->
                        Crates.crateManager.getCrate(args[1]).getInfo(player);

                    case "set" -> {
                        Crates.crateToSet = args[1];
                        Crates.isSetting = true;
                        player.sendMessage("Next block you hit will set the crate");
                    }
                }

            if (args.length == 3)
                switch(args[1])
                {
                    case "addDrop" -> {
                        Crates.crateManager.getCrate(args[1]).addItem(player.getInventory().getItemInMainHand(), Integer.parseInt(args[2]));
                        player.sendMessage("Added drop to crate");
                    }

                    case "rename" -> {
                        Crates.crateManager.getCrate(args[1]).setName(args[2]);
                        player.sendMessage("Crate has been renamed to " + args[2]);
                    }
                }

        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length == 1)
            return StringUtil.copyPartialMatches(args[0], List.of("create", "removeDrop", "addDrop", "delete", "set", "info", "reload"), new ArrayList<>());

        if (args.length == 2)
            switch(args[1]){
                case "create", "removeDrop", "addDrop", "delete", "set", "info" -> {
                    return StringUtil.copyPartialMatches(args[1], Crates.crateManager.getCratesAsString(), new ArrayList<>());
                }

            }

        if (args.length == 3)
            return StringUtil.copyPartialMatches(args[2], List.of("10"), new ArrayList<>());


        return Collections.emptyList();
    }
}
