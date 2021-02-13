package playertracker.events;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;


import java.util.List;
import java.util.Objects;


public class PlayerTrackerEvent implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR)){
            Player player = e.getPlayer();
            //if(Objects.requireNonNull(Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getLore()).contains("\"This item tracks players\"")) {
            if(playertracker.items.PlayerTracker.isPlayerTracker(player.getInventory().getItemInMainHand())) {
                player.sendMessage("Tracking nearest player");

                List<Player> players = Objects.requireNonNull(e.getPlayer().getLocation().getWorld()).getPlayers();

                Player nearestCandidate = player;
                Location loc = player.getLocation();


                int old_distance = 3000000;

                for (Player p : players) {
                    if (loc.distance(p.getLocation()) < old_distance && p != player) {
                        nearestCandidate = p;
                        old_distance = (int) loc.distance(p.getLocation());
                    }
                }

                player.sendMessage("Nearest Player: " + nearestCandidate.getName());

                if (nearestCandidate == player) {
                    return;
                }

                EnderSignal es = (EnderSignal) Objects.requireNonNull(player.getLocation().getWorld()).spawnEntity(player.getEyeLocation(), EntityType.ENDER_SIGNAL);
                es.setTargetLocation(nearestCandidate.getLocation());
                es.setDropItem(false);
            }
        }
    }
}