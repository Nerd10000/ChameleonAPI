package dragon.me.chameleonAPI;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class ChameleonAPI extends JavaPlugin {
    private  static Plugin plugin;
    private static Logger LOGGER = LogManager.getLogger();



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

    public static Logger getLOGGER() {
        return LOGGER;
    }
}
