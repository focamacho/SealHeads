package com.focamacho.sealheads;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import java.util.UUID;

public class TextureFetcher {

    private static final Gson gson = new GsonBuilder().create();

    public static Optional<String> getTexture(UUID uuid) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s", uuid.toString().replace("-", ""))).openConnection();
            connection.setReadTimeout(5000);

            JsonObject user = gson.fromJson(new InputStreamReader(connection.getInputStream()), JsonObject.class);
            for (JsonElement propertyElement : user.get("properties").getAsJsonArray()) {
                JsonObject property = propertyElement.getAsJsonObject();
                if(property.get("name").getAsString().equals("textures")) {
                    return Optional.of(property.get("value").getAsString());
                }
            }
        } catch(NullPointerException | FileNotFoundException ignored) {
            // Ignored exceptions - user doesn't exists
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return Optional.empty();
    }

    public static Optional<String> getTexture(String name) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(String.format("https://api.mojang.com/users/profiles/minecraft/%s", name)).openConnection();
            connection.setReadTimeout(5000);

            JsonObject player = gson.fromJson(new InputStreamReader(connection.getInputStream()), JsonObject.class);
            String userId = player.get("id").getAsString();

            return getTexture(UUID.fromString(userId.replaceAll("(.{8})(.{4})(.{4})(.{4})(.+)", "$1-$2-$3-$4-$5")));
        } catch(NullPointerException | FileNotFoundException ignored) {
            // Ignored exceptions - user doesn't exists
        } catch(IOException exception) {
            exception.printStackTrace();
        }

        return Optional.empty();
    }

}
