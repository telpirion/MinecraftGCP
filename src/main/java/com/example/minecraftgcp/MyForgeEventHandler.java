package com.example.minecraftgcp;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MyForgeEventHandler {


    public MyForgeEventHandler() {
        // Pre load some jokes from Vertex AI / Gemini
        
    }


    @SubscribeEvent
    public void onPlayerAttemptChat(ClientChatEvent event) {
        String message = event.getMessage();
        if (message.contains("joke")) {
            Minecraft mc = Minecraft.getInstance();
            mc.gui.getChat().addMessage(Component.literal("A dog walks into a bar ..."));
        }
    }
}