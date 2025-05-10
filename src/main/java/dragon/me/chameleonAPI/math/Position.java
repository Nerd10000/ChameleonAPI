package dragon.me.chameleonAPI.math;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

import java.util.UUID;

public class Position {

    private double x, y, z;
    private float yaw, pitch;



    public Position(double x, double y, double z) {
        this(x, y, z, 0f, 0f);
    }

    public Position(double x, double y, double z, float yaw, float pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    // Getters
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }
    public float getYaw() { return yaw; }
    public float getPitch() { return pitch; }

    // Setters
    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setRotation(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
    }

    // Distance utilities
    public double distance(Position other) {
        double dx = x - other.x;
        double dy = y - other.y;
        double dz = z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public double horizontalDistance(Position other) {
        double dx = x - other.x;
        double dz = z - other.z;
        return Math.sqrt(dx * dx + dz * dz);
    }

    // Delta computation
    public Delta toDelta(Position last) {
        return new Delta(x - last.x, y - last.y, z - last.z, yaw - last.yaw, pitch - last.pitch);
    }

    @Override
    public String toString() {
        return String.format("Position[x=%.3f, y=%.3f, z=%.3f, yaw=%.2f, pitch=%.2f]", x, y, z, yaw, pitch);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position other)) return false;
        return Double.compare(x, other.x) == 0 &&
                Double.compare(y, other.y) == 0 &&
                Double.compare(z, other.z) == 0 &&
                Float.compare(yaw, other.yaw) == 0 &&
                Float.compare(pitch, other.pitch) == 0;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(x);
        result = 31 * result + Double.hashCode(y);
        result = 31 * result + Double.hashCode(z);
        result = 31 * result + Float.hashCode(yaw);
        result = 31 * result + Float.hashCode(pitch);
        return result;
    }
    public Vector toBukkitVector(){
        return  new Vector(x,y,z);
    }

    public Block getPositionAsBlock(String worldName){
        return toBukkitVector().toLocation(Bukkit.getWorld(worldName)).getBlock();
    }
}
