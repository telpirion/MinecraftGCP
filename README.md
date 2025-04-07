# MinecraftGCP
A Minecraft server mod running on Google Cloud.

## Development journal

1. [Install Minecraft.](https://www.minecraft.net/en-us/download)

1. Log in with Microsoft account.

1. [Download Minecraft Forge MDK.](https://files.minecraftforge.net/net/minecraftforge/forge/)

1. Open MDK folder.

1. Depending on your IDE, you might need to explicitly build the project to 
   be able to run it. (Some IDEs will handle this for you.)

1. Replace all instances of `examplemod` with the name of your mod.

1. Run the mod by invoking `runClient` Gradle task.

1. If you get a null pointer exception, check that you have replaced all
   instances of the `examplemod` in the mod, including in the Java files.

### 2025-04-07 (Day 1)

Things I learned today:

+ To add a Google Cloud client library to the dependencies, you need to add them
  to the build.gradle `dependencies` field like so:

  ```
  implementation platform('com.google.cloud:libraries-bom:26.59.0')
  implementation fg.deobf("com.google.cloud:google-cloud-vertexai:1.20.1")
  ```

  - [Docs](https://docs.minecraftforge.net/en/fg-6.x/dependencies/)

+ To register an event in the mod, you need to register to either the Forge
  or mod bus. Best to create a new class and `@SubscribeEvent` in the new
  class.

  ```java
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

  ```