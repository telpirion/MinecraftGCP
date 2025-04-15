package com.telpirion.minecraftplugin;

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Joke {
  private ArrayList<String> jokes = new ArrayList<>();

  public Joke() {}

  public String getJoke() throws IOException {
    String projectId = "erschmid-test-291318";
    String location = "us-central1";
    String modelName = "gemini-2.0-flash-001";
    String textPrompt = "Tell me a joke";
    //return "this is an unfunny joke";
    return this.populateJoke(projectId, location, modelName, textPrompt);
  }

  private String populateJoke(String projectId, String location, String modelName, String textPrompt) throws IOException {
    Logger.getLogger("JOKE: ").info("Populating joke...");
    try (VertexAI vertexAI = new VertexAI(projectId, location)) {
      GenerativeModel model = new GenerativeModel(modelName, vertexAI);

      GenerateContentResponse response = model.generateContent(textPrompt);
      String output = ResponseHandler.getText(response);
      Logger.getLogger("JOKE: ").info(output);
      return output;
    }
  }
}
