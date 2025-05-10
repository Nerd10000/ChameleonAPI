package dragon.me.chameleonAPI.hooks;

import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;

public class AdventureJsonSerializerHook {

    private final GsonComponentSerializer serializer = GsonComponentSerializer.colorDownsamplingGson();

    public AdventureJsonSerializerHook(){

    }

    public GsonComponentSerializer getSerializer() {
        return serializer;
    }
}
