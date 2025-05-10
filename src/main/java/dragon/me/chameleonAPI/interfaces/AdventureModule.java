package dragon.me.chameleonAPI.interfaces;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;

public interface AdventureModule {

    void assignComponent(String text);

    // JSON //

    GsonComponentSerializer getJsonFormatter();
    String jsonToString();
    void JsonSerializer();

    // MINIMESSAGE //

    MiniMessage getMiniMessageFormatter();
    String miniMessageToString();
    void miniMessageSerializer();

    // BOTH //

    Component getResult();
}
