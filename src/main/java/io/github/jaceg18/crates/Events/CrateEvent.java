package io.github.jaceg18.crates.Events;

import io.github.jaceg18.crates.Crates;
import io.github.jaceg18.crates.Utility.Crate;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

public class CrateEvent implements Listener {

    @EventHandler
    public void CrateHitEvent(BlockDamageEvent e){
        if (Crates.isSetting && Crates.crateToSet != null)
            Crates.crateManager.getCrate(Crates.crateToSet).setLocation(e.getBlock().getLocation());

        for (Crate crate : Crates.crateManager.getCrates())
            if (crate.getKey() != null)
                if (e.getPlayer().getInventory().getItemInMainHand().equals(crate.getKey()))
                {
                    e.getPlayer().getInventory().addItem(crate.open());
                    e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount()-1);
                    e.getPlayer().sendMessage("You have opened a " + crate.getName() + " crate!");

                }
    }


}
