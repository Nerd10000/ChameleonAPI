package dragon.me.chameleonAPI.hooks;

import net.kyori.adventure.text.minimessage.MiniMessage;

public class AdventureMiniMessageHook {

    private MiniMessage message = MiniMessage.miniMessage();



    public AdventureMiniMessageHook(){

    }

    public MiniMessage getSerializer() {
        return message;
    }
}
