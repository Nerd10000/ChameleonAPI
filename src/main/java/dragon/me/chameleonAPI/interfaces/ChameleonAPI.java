package dragon.me.chameleonAPI.interfaces;

import dragon.me.chameleonAPI.hooks.AdventureCoreHook;
import dragon.me.chameleonAPI.hooks.AdventureJsonSerializerHook;
import dragon.me.chameleonAPI.hooks.AdventureMiniMessageHook;
import dragon.me.chameleonAPI.hooks.SparkHook;
import dragon.me.chameleonAPI.hooks.packets.PacketEventsHook;

public interface ChameleonAPI {

    PacketEventsHook getPacketEvents();
    AdventureCoreHook getAdventureHook();
    AdventureJsonSerializerHook getJsonSerializers();
    AdventureMiniMessageHook getMiniMessageSerializers();
    SparkHook getSystemTools();

}
