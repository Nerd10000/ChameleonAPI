package dragon.me.chameleonAPI.interfaces;

import dragon.me.chameleonAPI.enums.ChameleonTerminalColors;
import org.bukkit.Bukkit;

public interface ChameleonModule {

    static void implement(String name){

        Bukkit.getLogger().info(ChameleonTerminalColors.GREEN_BOLD + "[ChameleonAPI]"+ChameleonTerminalColors.RESET + ChameleonTerminalColors.GREEN_BRIGHT + "Initializing module: "+name);
    }
}
