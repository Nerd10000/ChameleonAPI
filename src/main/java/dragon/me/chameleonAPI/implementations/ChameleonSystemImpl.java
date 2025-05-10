package dragon.me.chameleonAPI.implementations;

import dragon.me.chameleonAPI.ChameleonAPI;
import dragon.me.chameleonAPI.annotations.Skidded;
import dragon.me.chameleonAPI.enums.ChameleonTerminalColors;
import dragon.me.chameleonAPI.hooks.SparkHook;
import dragon.me.chameleonAPI.interfaces.ChameleonModule;
import dragon.me.chameleonAPI.interfaces.ChameleonSystem;
import me.lucko.spark.api.gc.GarbageCollector;
import me.lucko.spark.api.statistic.StatisticWindow;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ChameleonSystemImpl implements ChameleonModule, ChameleonSystem {

    private final SparkHook sparkHook = new SparkHook();

    private float tps = 20.0f;
    private float mspt = 0.0f;
    private int memoryUsage = 0;
    private int maxMemory = 0;
    private int cores = Runtime.getRuntime().availableProcessors();

    public ChameleonSystemImpl(Plugin plugin) {
        startUpdating(plugin);
    }

    private void startUpdating(Plugin plugin) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (sparkHook.getSparkInstance() != null && sparkHook.getSparkInstance().getProvider() != null) {
                    tps = (float) sparkHook.getSparkInstance().getProvider().tps().poll(StatisticWindow.TicksPerSecond.SECONDS_10);
                    mspt = (float) sparkHook.getSparkInstance().getProvider().mspt().poll(StatisticWindow.MillisPerTick.SECONDS_10).mean();
                }
                memoryUsage = (int) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / Math.pow(1024, 3));
                maxMemory = (int) (Runtime.getRuntime().maxMemory() / Math.pow(1024, 3));
            }
        }.runTaskTimerAsynchronously(plugin, 0L, 20L); // updates every second (20 ticks)
    }

    @Override
    public float getTPS() {
        return tps;
    }

    @Override
    public float getMSPT() {
        return mspt;
    }

    @Override
    public int getMemoryUsage() {
        return memoryUsage;
    }

    @Override
    public int getMaxMemory() {
        return maxMemory;
    }

    @Override
    public int getCore() {
        return cores;
    }
}


