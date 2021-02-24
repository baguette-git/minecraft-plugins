package Friends.events;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import Friends.Main;
import Friends.items.FriendsPoppy;
import org.bukkit.inventory.EquipmentSlot;

import java.time.LocalDateTime;


public class FriendsFlowerInteractEvent implements Listener {

    String baseMsg = "Received a friend request from: %s";
    Main plugin;

    public FriendsFlowerInteractEvent(Main plugin){
         this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerClick(PlayerInteractEntityEvent e){
        Player player = e.getPlayer();
        EquipmentSlot hand = e.getHand();
        if(hand != null && hand != EquipmentSlot.OFF_HAND)
            return;
        if(FriendsPoppy.isFriendsPoppy(player.getInventory().getItemInMainHand())){
            Entity entity = e.getRightClicked();
            if(entity instanceof Player){
                Player clickedPlayer = (Player) entity;
                player.sendMessage("Sent friend request to: " + clickedPlayer.getName());

                TextComponent space = new TextComponent(" ");

                TextComponent accept = new TextComponent("[ACCEPT]");
                accept.setColor(ChatColor.GREEN);
                accept.setBold(true);
                accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "addFriend " + player.getUniqueId() + " " + LocalDateTime.now().toString()));
                accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Accept friend request from: " + player.getName())));

                TextComponent deny = new TextComponent("[DENY]");
                deny.setColor(ChatColor.RED);
                deny.setBold(true);
                deny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "denyFriend"));
                deny.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Deny friend request from: " + player.getName())));

                accept.addExtra(space);
                accept.addExtra(deny);
                clickedPlayer.sendMessage(String.format(baseMsg, player.getName()));
                clickedPlayer.spigot().sendMessage(accept);
            }
        }
    }

}
