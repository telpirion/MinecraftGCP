package com.example.minecraftgcp;

import java.io.IOException;

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.GenerativeModel;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MyForgeEventHandler {


    public MyForgeEventHandler() {
        // Pre load some jokes from Vertex AI / Gemini
        try {
            getDadJokes("erschmid-test-291318");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private String getDadJokes(String projectId) throws IOException {
        String location = "us-west1";
        String modelName = "gemini-2.0-flash-001";
        try (VertexAI vertexAI = new VertexAI(projectId, location)) {
            GenerativeModel model = new GenerativeModel(modelName, vertexAI);
            GenerateContentResponse response = model.generateContent("Tell me 5 dad jokes");
            return "a dog walks into a bar";
        }
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