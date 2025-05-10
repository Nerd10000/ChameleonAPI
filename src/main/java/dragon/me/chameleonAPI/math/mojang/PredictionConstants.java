package dragon.me.chameleonAPI.math.mojang;


import dragon.me.chameleonAPI.annotations.AntiCheatStuff;
import dragon.me.chameleonAPI.annotations.Constants;
import lombok.Getter;

@AntiCheatStuff
@Getter
public class PredictionConstants {
    // -- MOVEMENT --
    @Constants
    public static float FRICTION = 0.91f;
    public static double GRAVITY = -0.08;
    public static float SPRINT_SCALE = 1.3f;
    public static float JUMP_POWER = 0.42f;
    public static  double AIR_CONTROL_IN_AIR = 0.02;
    public static double SWIMMING_FRICTION = 0.8;
    public static double SPEED_DECREASE_ON_CROUCH = 0.55;
    public static double MAX_FALL_DELTA = -3.92; // /tick
    public static double UPWARDS_FORCE_ON_SWIMMING = 0.04;

    // -- OTHER --

    public static double MAX_HP = 20.0;
    public static  double MIN_HP = 0.0;
}
