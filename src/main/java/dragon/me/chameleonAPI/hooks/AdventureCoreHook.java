package dragon.me.chameleonAPI.hooks;

import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;

public class AdventureCoreHook {

    private BukkitAudiences audiences;

    public AdventureCoreHook(){

    }

    public  @Nonnull BukkitAudiences audiences(){
        if (this.audiences == null){
            throw  new RuntimeException("Couldn't load Adventure :(");
        }
        return this.audiences;
    }

    public void load(Plugin plugin) {
        this.audiences = BukkitAudiences.create(plugin);
    }

    public void disable(){
        if (audiences !=null){
            audiences.close();
            audiences = null;
        }
    }
}
