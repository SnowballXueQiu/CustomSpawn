package snowball_233.vastsea.customspawn;

import snowball_233.vastsea.customspawn.utils.ColorUtils;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listeners implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (CustomSpawn.getInstance().getSpawnConfig().get("spawn") == null) {
            e.getPlayer().sendMessage(ColorUtils.colorMsg("&4&l&c));
        } else {
            e.getPlayer().setGameMode(GameMode.ADVENTURE);
            Location spawnLoc = (Location)CustomSpawn.getInstance().getSpawnConfig().get("spawn");
            e.getPlayer().teleport(spawnLoc);
        }
    }
}