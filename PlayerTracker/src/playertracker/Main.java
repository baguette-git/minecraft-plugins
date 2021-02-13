package playertracker;

import playertracker.commands.TrackerCommand;
import playertracker.events.PlayerTrackerEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new PlayerTrackerEvent(), this);
        Objects.requireNonNull(getCommand("tracker")).setExecutor(new TrackerCommand());
        getLogger().info("shithole is fucking goofed");
    }
}