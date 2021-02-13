package playertracker.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerTracker{
    public ItemStack tracker;

    public PlayerTracker(){
        ItemStack item = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.GOLD + "Player Tracker");
        List<String> lore = new ArrayList<>();
        lore.add("This item tracks players");
        meta.setLore(lore);
        item.setItemMeta(meta);
        tracker = item;
    }

    public static boolean isPlayerTracker(ItemStack o){
        return  Objects.requireNonNull(Objects.requireNonNull(o.getItemMeta()).getLore()).contains("This item tracks players") && o.getType() == Material.COMPASS;
    }

}