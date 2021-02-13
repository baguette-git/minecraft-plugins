package playertracker.commands;

import playertracker.items.PlayerTracker;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrackerCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender instanceof Player) {
            Player player = (Player) sender;
            player.getInventory().addItem(new PlayerTracker().tracker);
        }
        return true;
    }
}
