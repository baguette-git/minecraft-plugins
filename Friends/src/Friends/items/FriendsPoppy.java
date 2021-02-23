package Friends.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FriendsPoppy {
    public ItemStack friendsPoppy;

    public FriendsPoppy(){
        ItemStack item = new ItemStack(Material.POPPY, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Add a friend");
        List<String> lore = new ArrayList<>();
        lore.add("Use this to add friends");
        meta.setLore(lore);
        item.setItemMeta(meta);
        friendsPoppy = item;
    }

    public static boolean isFriendsPoppy(ItemStack item){
        return Objects.requireNonNull(Objects.requireNonNull(item.getItemMeta()).getLore()).contains("Use this to add friends") && item.getType() == Material.POPPY;
    }
}
