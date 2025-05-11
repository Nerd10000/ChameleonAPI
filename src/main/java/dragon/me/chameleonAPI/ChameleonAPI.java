package dragon.me.chameleonAPI;

import dragon.me.chameleonAPI.hooks.AdventureCoreHook;
import dragon.me.chameleonAPI.hooks.AdventureJsonSerializerHook;
import dragon.me.chameleonAPI.hooks.AdventureMiniMessageHook;
import dragon.me.chameleonAPI.hooks.SparkHook;
import dragon.me.chameleonAPI.hooks.packets.PacketEventsHook;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class ChameleonAPI extends JavaPlugin implements dragon.me.chameleonAPI.interfaces.ChameleonAPI {
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

    @Override
    public PacketEventsHook getPacketEvents() {
        return new PacketEventsHook();
    }

    @Override
    public AdventureCoreHook getAdventureHook() {
        return new AdventureCoreHook();
    }

    @Override
    public AdventureJsonSerializerHook getJsonSerializers() {
        return  new AdventureJsonSerializerHook();
    }

    @Override
    public AdventureMiniMessageHook getMiniMessageSerializers() {
        return new AdventureMiniMessageHook();
    }

    @Override
    public SparkHook getSystemTools() {
        return new SparkHook();
    }
}
