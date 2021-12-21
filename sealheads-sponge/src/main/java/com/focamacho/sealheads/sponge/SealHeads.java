package com.focamacho.sealheads.sponge;

import com.focamacho.sealheads.TextureFetcher;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.RepresentedPlayerData;
import org.spongepowered.api.data.manipulator.mutable.SkullData;
import org.spongepowered.api.data.type.SkullTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.profile.property.ProfileProperty;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@SuppressWarnings("unused")
public class SealHeads {

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
        GameProfile profile = GameProfile.of(UUID.randomUUID());
        profile.getPropertyMap().put("textures", ProfileProperty.of("value", texture));

        ItemStack stack = ItemStack.builder().itemType(ItemTypes.SKULL).build();

        SkullData skullData = Sponge.getDataManager()
                .getManipulatorBuilder(SkullData.class)
                .get().create().set(Keys.SKULL_TYPE, SkullTypes.PLAYER);
        stack.offer(skullData);

        RepresentedPlayerData playerData = Sponge.getDataManager()
                .getManipulatorBuilder(RepresentedPlayerData.class)
                .get().create().set(Keys.REPRESENTED_PLAYER, profile);
        stack.offer(playerData);

        return stack;
    }

}
