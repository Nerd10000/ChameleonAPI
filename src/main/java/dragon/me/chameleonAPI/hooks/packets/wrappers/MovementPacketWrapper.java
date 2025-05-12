package dragon.me.chameleonAPI.hooks.packets.wrappers;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerFlying;
import dragon.me.chameleonAPI.math.Delta;
import dragon.me.chameleonAPI.math.mojang.AbstractPlayer;

public class MovementPacketWrapper extends WrapperPlayClientPlayerFlying {

    private  PacketReceiveEvent e;
    private AbstractPlayer abstractPlayer;
    private Delta last,d;
    public MovementPacketWrapper(PacketReceiveEvent event) {
        super(event);
        e = event.clone();
    }


    public MovementPacketWrapper(boolean positionChanged, boolean rotationChanged, boolean onGround, Location location) {
        super(positionChanged, rotationChanged, onGround, location);
    }

    public MovementPacketWrapper(boolean positionChanged, boolean rotationChanged, boolean onGround, boolean horizontalCollision, Location location) {
        super(positionChanged, rotationChanged, onGround, horizontalCollision, location);
    }

    @Override
    public boolean hasPositionChanged() {
        return super.hasPositionChanged();
    }

    public AbstractPlayer getAbstractPlayerImplementation(){
        return abstractPlayer = new AbstractPlayer(e.getUser().getUUID());
    }
    public Delta getLastDelta(){
        return last;
    }

    public Delta getDelta(){
        last = d;
        WrapperPlayClientPlayerFlying p1 = new WrapperPlayClientPlayerFlying(e);
        WrapperPlayClientPlayerFlying p2 = new WrapperPlayClientPlayerFlying(getLastMovePacket());

        d = new Delta(p1.getLocation().getX() - p2.getLocation().getX(),
                p1.getLocation().getY() - p2.getLocation().getY(),p1.getLocation().getZ(),  - p2.getLocation().getZ());
        return d;

    }

    private PacketReceiveEvent getLastMovePacket(){
        return  abstractPlayer.getLastMovementPacket();
    }




}
