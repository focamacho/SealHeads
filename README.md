# Seal Heads [![](https://jitpack.io/v/seal-island/sealheads.svg)](https://jitpack.io/#seal-island/sealheads)
API for fetching Skins from the Mojang's API and creating heads for Bukkit and Sponge.
<br>
This API manually fetches the players UUID and Skin from the Mojang's API, allowing it to work in offline mode servers.
<br>
<br>
Mainly created because of [MC-132437](https://bugs.mojang.com/browse/MC-132437).
## Index

- [Seal Heads](#Seal-Heads)
    * [First Steps](#First-Steps)
    * [Using the API](#Using-the-API)

## First Steps
To start using the API, you'll need to setup the dependency in your project. Here is some examples for Gradle and Maven:
<br>
Do not forget to replace *VERSION* with the desired version of the API. Check what is the latest version in the [releases](https://github.com/Seal-Island/SealHeads/releases) tab.

**Maven**
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
```xml
<dependency>
    <groupId>com.github.seal-island.sealheads</groupId>
    <artifactId>bukkit</artifactId> <!-- Replace "bukkit" with "sponge" if desired. -->
    <version>VERSION</version>
</dependency>
```

**Gradle**
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.seal-island.sealheads:bukkit:VERSION' // Replace "bukkit" with "sponge" if desired.
}
```

## Using the API

All you need to do is use the static methods of the class `SealHeads`.
<br><br>
Obs: As this API fetches the UUID and Skin from the Mojang's API, it is recommended to use the methods in an async way, avoiding lag spikes caused by the delay of the requests to the Mojang's API.
<br>
This API has some methods that receive an ExecutorService and returns an CompletableFuture to make your life easier.

```java
//The package will be com.focamacho.sealmenus.sponge for Sponge.
import com.focamacho.sealmenus.bukkit.SealHeads;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Executors;

public class ExamplePlugin {

    {
        // Fetches the UUID and Skin from the Mojang's API, and returns the head ItemStack.
        // If an error occurred or the player doesn't exist, returns Optional.empty().
        Optional<ItemStack> focamachoHead = SealHeads.getHead("Focamacho");

        // Fetches the UUID and Skin from the Mojang's API, and returns the skin string.
        // If an error occurred or the player doesn't exist, returns Optional.empty().
        Optional<String> focamachoSkin = SealHeads.getTexture("Focamacho");

        // Fetches the Skin from the Mojang's API using the provided UUID, and returns the head ItemStack.
        // If an error occurred or the player doesn't exist, returns Optional.empty().
        Optional<ItemStack> jebHead = SealHeads.getHead(UUID.fromString("45f50155-c09f-4fdc-b5ce-e30af2ebd1f0"));

        // Fetches the UUID and Skin from the Mojang's API using the provided ExecutorService
        // and returns the head ItemStack.
        // If an error occurred or the player doesn't exist, returns Optional.empty().
        ExecutorService service = Executors.newSingleThreadExecutor();
        CompletableFuture<Optional<ItemStack>> notchHead = SealHeads.getHead("Notch", service);
        
        // Creates a head ItemStack using the provided Skin texture.
        ItemStack dinnerboneHead = SealHeads.createHeadFromTexture("e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODc2NDk3YzI4MGY0MGFkNmUxYjQ2YWM1MjFkZmViYTJjYTU1ZThkNGUyOTVjYzQ4NWVhYjQ1NzAwYzc0YmE3OSJ9fX0=");
    }

}
```