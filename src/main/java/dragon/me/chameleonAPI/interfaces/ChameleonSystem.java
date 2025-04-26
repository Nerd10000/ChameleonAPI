package dragon.me.chameleonAPI.interfaces;

public interface ChameleonSystem {

    //void tickTimer();

    float getTPS();

    float getMSPT();

    int  getMemoryUsage();

    int getMaxMemory();

    int getCore();

    String getStartupFlags();
}
