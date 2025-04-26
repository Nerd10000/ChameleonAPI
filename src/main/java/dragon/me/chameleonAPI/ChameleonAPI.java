package dragon.me.chameleonAPI;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChameleonAPI extends JavaPlugin {
    private  static Plugin plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
