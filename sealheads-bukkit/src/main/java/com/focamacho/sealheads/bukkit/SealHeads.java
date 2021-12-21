package com.focamacho.sealheads.bukkit;

import com.focamacho.sealheads.TextureFetcher;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@SuppressWarnings("unused")
public class SealHeads {

    private static Field profileField;

    /* Head methods */

    /**
     * Fetch the player's UUID and Skin from the
     * Mojang's API, and creates a head ItemStack
     * containing the player's skin.
     *
     * @param player the player's name.
     * @return the head ItemStack, or Optional.empty() if
     * the player doesn't exist or an error occurred.
     */
    public static Optional<ItemStack> getHead(String player) {
        Optional<String> texture = getTexture(player);
        return texture.map(SealHeads::createHeadFromTexture);
    }

    /**
     * Fetch the player's Skin from the Mojang's API
     * and creates a head ItemStack containing
     * the player's skin.
     *
     * @param player the player's uuid.
     * @return the head ItemStack, or Optional.empty() if
     * the player doesn't exist or an error occurred.
     */
    public static Optional<ItemStack> getHead(UUID player) {
        Optional<String> texture = getTexture(player);
        return texture.map(SealHeads::createHeadFromTexture);
    }

    /**
     * Fetch the player's UUID and Skin from the
     * Mojang's API, and creates a head ItemStack
     * containing the player's skin.
     *
     * @param player the player.
     * @return the head ItemStack, or Optional.empty() if
     * the player doesn't exist or an error occurred.
     */
    public static Optional<ItemStack> getHead(Player player) {
        return getHead(player.getName());
    }

    /**
     * Fetch the player's UUID and Skin from the
     * Mojang's API, and creates a head ItemStack
     * containing the player's skin.
     *
     * This method allows you to provide an ExecutorService
     * and request the head in an async way. Very useful if
     * you want to avoid the "lag" caused by the requests
     * to the Mojang's API.
     *
     * @param player the player's name.
     * @return the head ItemStack, or Optional.empty() if
     * the player doesn't exist or an error occurred.
     */
    public static CompletableFuture<Optional<ItemStack>> getHead(String player, ExecutorService service) {
        CompletableFuture<Optional<ItemStack>> future = new CompletableFuture<>();
        service.execute(() -> {
            Optional<ItemStack> head = getHead(player);
            future.complete(head);
        });
        return future;
    }

    /**
     * Fetch the player's Skin from the Mojang's API
     * and creates a head ItemStack containing
     * the player's skin.
     *
     * This method allows you to provide an ExecutorService
     * and request the head in an async way. Very useful if
     * you want to avoid the "lag" caused by the requests
     * to the Mojang's API.
     *
     * @param player the player's uuid.
     * @return the head ItemStack, or Optional.empty() if
     * the player doesn't exist or an error occurred.
     */
    public static CompletableFuture<Optional<ItemStack>> getHead(UUID player, ExecutorService service) {
        CompletableFuture<Optional<ItemStack>> future = new CompletableFuture<>();
        service.execute(() -> {
            Optional<ItemStack> head = getHead(player);
            future.complete(head);
        });
        return future;
    }

    /**
     * Fetch the player's UUID and Skin from the
     * Mojang's API, and creates a head ItemStack
     * containing the player's skin.
     *
     * This method allows you to provide an ExecutorService
     * and request the head in an async way. Very useful if
     * you want to avoid the "lag" caused by the requests
     * to the Mojang's API.
     *
     * @param player the player.
     * @return the head ItemStack, or Optional.empty() if
     * the player doesn't exist or an error occurred.
     */
    public static CompletableFuture<Optional<ItemStack>> getHead(Player player, ExecutorService service) {
        CompletableFuture<Optional<ItemStack>> future = new CompletableFuture<>();
        service.execute(() -> {
            Optional<ItemStack> head = getHead(player);
            future.complete(head);
        });
        return future;
    }

    /* Texture methods */

    /**
     * Fetch the player's UUID and Skin from the
     * Mojang's API, and returns it.
     *
     * @param player the player's name.
     * @return the player's skin or Optional.empty() if
     * the player doesn't exist or an error occurred.
     */
    public static Optional<String> getTexture(String player) {
        return TextureFetcher.getTexture(player);
    }

    /**
     * Fetch the player's Skin from the
     * Mojang's API, and returns it.
     *
     * @param player the player's uuid.
     * @return the player's skin or Optional.empty() if
     * the player doesn't exist or an error occurred.
     */
    public static Optional<String> getTexture(UUID player) {
        return TextureFetcher.getTexture(player);
    }

    /**
     * Fetch the player's UUID and Skin from the
     * Mojang's API, and returns it.
     *
     * @param player the player.
     * @return the player's skin or Optional.empty() if
     * the player doesn't exist or an error occurred.
     */
    public static Optional<String> getTexture(Player player) {
        return getTexture(player.getName());
    }

    /**
     * Fetch the player's UUID and Skin from the
     * Mojang's API, and returns it.
     *
     * This method allows you to provide an ExecutorService
     * and request the head in an async way. Very useful if
     * you want to avoid the "lag" caused by the requests
     * to the Mojang's API.
     *
     * @param player the player's name.
     * @return the player's skin or Optional.empty() if
     * the player doesn't exist or an error occurred.
     */
    public static CompletableFuture<Optional<String>> getTexture(String player, ExecutorService service) {
        CompletableFuture<Optional<String>> future = new CompletableFuture<>();
        service.execute(() -> {
            Optional<String> texture = getTexture(player);
            future.complete(texture);
        });
        return future;
    }

    /**
     * Fetch the player's Skin from the
     * Mojang's API, and returns it.
     *
     * This method allows you to provide an ExecutorService
     * and request the head in an async way. Very useful if
     * you want to avoid the "lag" caused by the requests
     * to the Mojang's API.
     *
     * @param player the player's uuid.
     * @return the player's skin or Optional.empty() if
     * the player doesn't exist or an error occurred.
     */
    public static CompletableFuture<Optional<String>> getTexture(Player player, ExecutorService service) {
        CompletableFuture<Optional<String>> future = new CompletableFuture<>();
        service.execute(() -> {
            Optional<String> texture = getTexture(player);
            future.complete(texture);
        });
        return future;
    }

    /**
     * Fetch the player's UUID and Skin from the
     * Mojang's API, and returns it.
     *
     * This method allows you to provide an ExecutorService
     * and request the head in an async way. Very useful if
     * you want to avoid the "lag" caused by the requests
     * to the Mojang's API.
     *
     * @param player the player.
     * @return the player's skin or Optional.empty() if
     * the player doesn't exist or an error occurred.
     */
    public static CompletableFuture<Optional<String>> getTexture(UUID player, ExecutorService service) {
        CompletableFuture<Optional<String>> future = new CompletableFuture<>();
        service.execute(() -> {
            Optional<String> texture = getTexture(player);
            future.complete(texture);
        });
        return future;
    }

    /**
     * Creates a head ItemStack using the provided
     * skin.
     *
     * @param texture the texture to use as skin
     *                for the head.
     * @return the head ItemStack.
     */
    public static ItemStack createHeadFromTexture(String texture) {
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("value", texture));

        ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) stack.getItemMeta();

        try {
            if(profileField == null) profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullMeta, profile);
        } catch(NoSuchFieldException | IllegalAccessException exception) {
            exception.printStackTrace();
        }

        stack.setItemMeta(skullMeta);

        return stack;
    }

}
