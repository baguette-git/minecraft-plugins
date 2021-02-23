package Friends.commands;

import Friends.items.FriendsPoppy;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class getFlower implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender instanceof Player){
            Player player = (Player) sender;
            player.getInventory().addItem(new FriendsPoppy().friendsPoppy);
        }
        return true;
    }
}
