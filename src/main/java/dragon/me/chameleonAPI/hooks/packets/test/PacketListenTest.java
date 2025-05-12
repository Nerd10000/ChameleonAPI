package dragon.me.chameleonAPI.hooks.packets.test;

import dragon.me.chameleonAPI.hooks.packets.PacketReceivedEvent;
import dragon.me.chameleonAPI.hooks.packets.wrappers.MovementPacketWrapper;
import dragon.me.chameleonAPI.interfaces.IncomingPacketListener;

public class PacketListenTest extends IncomingPacketListener {

    @Override
    public void handle(PacketReceivedEvent e) {
        MovementPacketWrapper wrapper = new MovementPacketWrapper(e);

    }
}
