package dragon.me.chameleonAPI.implementations;

import dragon.me.chameleonAPI.ChameleonAPI;
import dragon.me.chameleonAPI.annotations.Skidded;
import dragon.me.chameleonAPI.enums.ChameleonTerminalColors;
import dragon.me.chameleonAPI.interfaces.ChameleonModule;
import dragon.me.chameleonAPI.interfaces.ChameleonSystem;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class ChameleonSystemImpl implements ChameleonModule, ChameleonSystem {

    private int TPS = 0;
    private long second = 0;

    private static BukkitTask tickTimer;
    public static void init(){



        ChameleonModule.implement("Chameleon-system(CS)");
    }


    @Override
    public float getTPS() {
        return TPS;
    }

    @Override
    public float getMSPT() {
        return 0;
    }

    @Override
    public int getMemoryUsage() {
        return 0;
    }

    @Override
    public int getMaxMemory() {
        return 0;
    }

    @Override
    public int getCore() {
        return 0;
    }

    @Override
    public String getStartupFlags() {
        return "";
    }
}
