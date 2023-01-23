package snowball_233.vastsea.customspawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import snowball_233.vastsea.customspawn.utils.ColorUtils;

public class SpawnCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ColorUtils.colorMsg("&c));
            return true;
        }
        Player p = (Player)sender;
        if (!sender.hasPermission("customspawn.admin")) {
            p.sendMessage(ColorUtils.colorMsg("&c));
            return true;
        }
        if (args.length >= 0) {
            CustomSpawn.getInstance().getSpawnConfig().set("spawn", p.getLocation());
            CustomSpawn.getInstance().reloadSpawnConfig();
            int x = (int)p.getLocation().getX();
            int y = (int)p.getLocation().getY();
            int z = (int)p.getLocation().getZ();
            p.sendMessage(ColorUtils.colorMsg("&a(" + x + "," + y + "," + z + ")"));
            return true;
        }
        return false;
    }
}
