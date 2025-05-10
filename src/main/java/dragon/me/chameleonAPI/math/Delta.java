package dragon.me.chameleonAPI.math;

public class Delta {
    private final double dx, dy, dz;
    private final float dyaw, dpitch;

    public Delta(double dx, double dy, double dz, float dyaw, float dpitch) {
        this.dx = dx;
        this.dy = dy;
        this.dz = dz;
        this.dyaw = dyaw;
        this.dpitch = dpitch;
    }

    public Delta(double dx, double dy, double dz, double v) {
        this.dx = dx;
        this.dy = dy;
        this.dz = dz;
        this.dyaw = 0;
        this.dpitch = 0;
    }

    // Position deltas
    public double dx() { return dx; }
    public double dy() { return dy; }
    public double dz() { return dz; }

    // Rotation deltas
    public float dyaw() { return dyaw; }
    public float dpitch() { return dpitch; }

    // Vector/magnitude utility
    public double horizontalDistance() {
        return Math.sqrt(dx * dx + dz * dz);
    }

    public double distance() {
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public boolean isStationary() {
        return dx == 0 && dy == 0 && dz == 0 && dyaw == 0 && dpitch == 0;
    }

    public boolean isPositionOnly() {
        return dyaw == 0 && dpitch == 0 && (dx != 0 || dy != 0 || dz != 0);
    }

    public boolean isRotationOnly() {
        return dx == 0 && dy == 0 && dz == 0 && (dyaw != 0 || dpitch != 0);
    }

    public boolean isMovingVertically() {
        return dy != 0;
    }

    public boolean isMovingHorizontally() {
        return dx != 0 || dz != 0;
    }

    public boolean isRotating() {
        return dyaw != 0 || dpitch != 0;
    }

    // Optionally add toString() for debugging
    @Override
    public String toString() {
        return String.format("Δx=%.3f, Δy=%.3f, Δz=%.3f, Δyaw=%.2f, Δpitch=%.2f", dx, dy, dz, dyaw, dpitch);
    }
}
