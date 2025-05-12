package dragon.me.chameleonAPI.interfaces;

import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import dragon.me.chameleonAPI.hooks.packets.PacketReceivedEvent;

public abstract class IncomingPacketListener extends PacketListenerAbstract {

    public void handle(PacketReceivedEvent e){
        onPacketReceive(e);
    }

    //Used as base
    @Override
    public void onPacketReceive(PacketReceiveEvent event) {
        super.onPacketReceive(event);
    }
}
