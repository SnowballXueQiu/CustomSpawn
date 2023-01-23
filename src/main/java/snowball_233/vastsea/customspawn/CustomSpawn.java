package snowball_233.vastsea.customspawn;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import utils.SpawnCommand;

public final class CustomSpawn extends JavaPlugin {
    public File spawnFile;

    public FileConfiguration spawnConfig;

    private static CustomSpawn i;

    public FileConfiguration getSpawnConfig() {
        return this.spawnConfig;
    }

    public void reloadSpawnConfig() {
        try {
            this.spawnConfig.save(this.spawnFile);
            this.spawnConfig.load(this.spawnFile);
        } catch (IOException|org.bukkit.configuration.InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static CustomSpawn getInstance() {
        return i;
    }

    public void onEnable() {
        i = this;
        this.spawnFile = new File(getDataFolder(), "spawn.yml");
        if (!this.spawnFile.exists()) {
            Bukkit.getConsoleSender().sendMessage("[CustomSpawn] spawn.yml );
                    saveResource("spawn.yml", false);
            Bukkit.getConsoleSender().sendMessage("[CustomSpawn] );
        }
        this.spawnConfig = (FileConfiguration)YamlConfiguration.loadConfiguration(this.spawnFile);
        Bukkit.getPluginManager().registerEvents(new Listeners(), (Plugin)this);
        getCommand("setspawn").setExecutor(new SpawnCommand());
        Bukkit.getConsoleSender().sendMessage("[CustomSpawn] );
    }

    public void onDisable() {}
}