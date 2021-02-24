package Friends.commands;

import com.sun.istack.internal.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.time.LocalDateTime;
import java.util.UUID;

public class addFriend implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        UUID playerUUID = UUID.fromString(args[0]);
        LocalDateTime requestTime = LocalDateTime.parse(args[1]);
        if(requestTime.plusMinutes(1).isAfter(LocalDateTime.now())){
            Player player = (Player) sender;
            player.sendMessage("Request expired");
            return false;
        }

        if (!(sender instanceof Player)) {
            Player player = (Player) sender;
            Player addedPlayer = Bukkit.getPlayer(playerUUID);
            return true;
        }
        return false;
    }
}
