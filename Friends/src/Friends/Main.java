package Friends;

import Friends.commands.addFriend;
import Friends.commands.getFlower;
import Friends.events.FriendsFlowerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new FriendsFlowerInteractEvent(this), this);
        Objects.requireNonNull(getCommand("friendsFlower")).setExecutor(new getFlower());
        getLogger().info("Friends plugin is now active");
        Objects.requireNonNull(getCommand("addFriend")).setExecutor(new addFriend());
    }
}