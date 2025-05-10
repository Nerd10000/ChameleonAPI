package dragon.me.chameleonAPI.implementations;

import dragon.me.chameleonAPI.annotations.SyncOnly;
import dragon.me.chameleonAPI.hooks.AdventureCoreHook;
import dragon.me.chameleonAPI.hooks.AdventureJsonSerializerHook;
import dragon.me.chameleonAPI.hooks.AdventureMiniMessageHook;
import dragon.me.chameleonAPI.interfaces.AdventureModule;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;

import java.util.UUID;

public class AdventureModuleImplementation implements AdventureModule {

    private AdventureMiniMessageHook mmHook = null;
    private AdventureJsonSerializerHook jsonHook = new AdventureJsonSerializerHook();;

    String assigned;
    Component result;



    @Override
    public void assignComponent(String text) {
        assigned = text;
    }

    @Override
    public GsonComponentSerializer getJsonFormatter() {
        return jsonHook.getSerializer();
    }



    @Override
    public String jsonToString() {
        return  assigned.toString();
    }

    @Override
    public void JsonSerializer() {
        result = jsonHook.getSerializer().deserialize(assigned);
    }

    @Override
    public MiniMessage getMiniMessageFormatter() {
        return mmHook.getSerializer();
    }


    @Override
    public String miniMessageToString() {
        return  assigned.toString();
    }

    @Override
    public void miniMessageSerializer() {
       result = mmHook.getSerializer().deserialize(assigned);
    }

    @Override
    public Component getResult() {
        return result;
    }
}
