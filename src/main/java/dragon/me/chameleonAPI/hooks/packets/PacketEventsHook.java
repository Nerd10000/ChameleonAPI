package dragon.me.chameleonAPI.hooks.packets;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListener;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.packettype.PacketTypeConstant;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerFlying;
import dragon.me.chameleonAPI.ChameleonAPI;
import dragon.me.chameleonAPI.annotations.Async;
import dragon.me.chameleonAPI.implementations.AsyncImplementation;
import dragon.me.chameleonAPI.math.Timestamp;
import dragon.me.chameleonAPI.math.mojang.AbstractPlayer;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;

public class PacketEventsHook implements PacketListener {



    public PacketEventsHook(){

    }

    public void enable() {
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(ChameleonAPI.getPlugin()));

        PacketEventsHook proxy = AsyncImplementation.createProxy(this);
        PacketEvents.getAPI().getEventManager().registerListener(proxy, PacketListenerPriority.NORMAL);
    }


    @Async
    @Override
    public void onPacketReceive(PacketReceiveEvent event) {
        AbstractPlayer abp = new AbstractPlayer(event.getUser().getUUID());
        abp.addToOrder(event);
    }


}
