package dragon.me.chameleonAPI.hooks;

import dragon.me.chameleonAPI.ChameleonAPI;
import dragon.me.chameleonAPI.enums.ChameleonTerminalColors;
import me.lucko.spark.api.Spark;
import org.apache.logging.log4j.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

public class SparkHook {

    private RegisteredServiceProvider<Spark> sparkInstance;
    private Logger logger = ChameleonAPI.getLOGGER();
    private  boolean thrownError;
    public SparkHook(){

        sparkInstance = Bukkit.getServicesManager().getRegistration(Spark.class);

        if (sparkInstance == null){
            logger.error("[MODULES >> SYSTEM TOOLS] Chameleon couldn't find Spark! This feature is unavailable right now!");
            thrownError = true;
        }else {
            thrownError = false;
        }

    }

    public RegisteredServiceProvider<Spark> getSparkInstance() {
        return sparkInstance;
    }
}
