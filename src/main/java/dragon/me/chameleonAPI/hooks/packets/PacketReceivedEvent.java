package dragon.me.chameleonAPI.hooks.packets;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.exception.PacketProcessException;
import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.packettype.PacketTypeCommon;
import com.github.retrooper.packetevents.protocol.player.User;
import dragon.me.chameleonAPI.math.Timestamp;
import dragon.me.chameleonAPI.math.mojang.AbstractPlayer;

public class PacketReceivedEvent extends PacketReceiveEvent {

    private Object channel;
    private AbstractPlayer abstractPlayer;
    private Object rawByteBuffer;
    private boolean autoProtocolTranslation;


    protected PacketReceivedEvent(Object channel, User user, Object player, Object rawByteBuf, boolean autoProtocolTranslation) throws PacketProcessException {
        super(channel, user, player, rawByteBuf, autoProtocolTranslation);
    }

    protected PacketReceivedEvent(int packetID, PacketTypeCommon packetType, ServerVersion serverVersion, Object channel, User user, Object player, Object byteBuf) throws PacketProcessException {
        super(packetID, packetType, serverVersion, channel, user, player, byteBuf);
    }

    public long getTimestamp(){
        return System.currentTimeMillis();
    }
    public void cancel(){
        super.setCancelled(true);
    }




}
