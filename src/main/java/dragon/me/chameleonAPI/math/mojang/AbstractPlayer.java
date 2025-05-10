package dragon.me.chameleonAPI.math.mojang;

import com.carrotsearch.sizeof.RamUsageEstimator;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import dragon.me.chameleonAPI.annotations.Abstract;
import dragon.me.chameleonAPI.annotations.AntiCheatStuff;
import dragon.me.chameleonAPI.annotations.Async;
import dragon.me.chameleonAPI.implementations.AsyncImplementation;
import dragon.me.chameleonAPI.math.Delta;
import dragon.me.chameleonAPI.math.Position;
import dragon.me.chameleonAPI.math.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@AntiCheatStuff //Kinda
@Abstract //Extendable
@Getter @Setter
public class AbstractPlayer {

    protected UUID playerID;
    protected String name;
    protected Position position;
    protected Position lastPosition;

    protected Delta currentMotion;
    protected Delta lastMotion;
    protected boolean isSneaking;
    protected boolean isSprinting;

    protected UUID worldID;
    protected Inventory inventory;

    protected Cache<Timestamp, PacketReceiveEvent> packetOrder = Caffeine.newBuilder().expireAfterAccess(5, TimeUnit.SECONDS)
            .maximumSize(1000)
            .build();

    public  AbstractPlayer(UUID uuid){
        this.playerID = uuid;
        this.name = Bukkit.getPlayer(uuid).getName();


        //this.position = new Position(0,0,0,0,0);
    }

    public Player toPlayer(){
        return  Bukkit.getPlayer(playerID);
    }

    //Used in the packets
    public void addToOrder(PacketReceiveEvent wrapper){
        packetOrder.put(Timestamp.from(),wrapper);
    }
    public PacketReceiveEvent getLastMovementPacket(){


        AbstractPlayer player = AsyncImplementation.createProxy(this);

        return  player.a();

    }
    //Sorry I didn't have a name for it. ¯\_(ツ)_/¯
    @Async
    private PacketReceiveEvent a() {
        Timestamp current = Timestamp.from();
        PacketReceiveEvent lastMovementEvent = null;
        long latestTime = Long.MIN_VALUE;

        // Loop through the map to find the latest movement packet before the current timestamp
        for (Map.Entry<Timestamp, PacketReceiveEvent> entry : packetOrder.asMap().entrySet()) {
            Timestamp timestamp = entry.getKey();
            PacketReceiveEvent event = entry.getValue();

            // Ensure the timestamp is before the current time
            if (timestamp.getTime() < current.getTime()) {
                // Compare timestamps manually
                if (timestamp.getTime() > latestTime && isMovementPacket(event)) {
                    lastMovementEvent = event;
                    latestTime = timestamp.getTime();
                }
            }
        }

        return lastMovementEvent;
    }

    private boolean isMovementPacket(PacketReceiveEvent event) {
        return event.getPacketType() == PacketType.Play.Client.PLAYER_FLYING ||
                event.getPacketType() == PacketType.Play.Client.PLAYER_POSITION ||
                event.getPacketType() == PacketType.Play.Client.PLAYER_ROTATION ||
                event.getPacketType() == PacketType.Play.Client.PLAYER_POSITION_AND_ROTATION;
    }

}
