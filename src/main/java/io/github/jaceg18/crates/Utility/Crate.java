package io.github.jaceg18.crates.Utility;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Crate implements Serializable {
    @Serial
    private static final long serialVersionUID = -1681012206529286330L;

    String name;
    int ID;
    Map<ItemStack, Integer> drops;
    Location location;
    ItemStack key;
    public Crate(String name){
        this.name = name;
        drops = new HashMap<>();
        ID = new Random().nextInt(1000);
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public void setKey(ItemStack key){
        this.key = key;
    }

    public ItemStack getKey(){
        return key;
    }

    public void addItem(ItemStack item, int chance){
        drops.put(item, chance);
    }

    public void removeItem(ItemStack remove){
        drops.remove(remove);
    }

    public ItemStack open(){
        for (Map.Entry<ItemStack, Integer> drop : drops.entrySet())
            if (drop.getValue() > new Random().nextInt(100))
                return drop.getKey();

        return new ItemStack(Material.STICK);
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getID(){
        return ID;
    }

    public void getInfo(Player player){

        boolean hasKey = key != null;

        String[] info = {
                "Name: " + name,
                "ID: " + ID,
                "Key: " + hasKey
        };
       for (String i : info)
           player.sendMessage(i);
    }

}
