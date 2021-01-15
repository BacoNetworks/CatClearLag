package me.time6628.clag.sponge.handlers;

import me.time6628.clag.sponge.CatClearLag;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Hostile;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.SpawnEntityEvent;
import org.spongepowered.api.world.Chunk;

import java.util.Optional;

/**
 * Created by TimeTheCat on 1/15/2017.
 */
public class MobEventHandler {
    private final CatClearLag plugin = CatClearLag.instance;

    @Listener
    public void onMobSpawn(SpawnEntityEvent event) {
        int hostileCount = 0;
        for (Entity entity : event.getEntities()) {
            if (entity instanceof Hostile) {
                Optional<Chunk> chunk = entity.getWorld().getChunk(entity.getLocation().getChunkPosition());
                if (chunk.isPresent()) {
                    hostileCount += 1;
                    for (Entity entity1 : chunk.get().getEntities()) {
                        if (entity1 instanceof Hostile) {
                            hostileCount += 1;
                        }
                    }
                    if (hostileCount >= plugin.getMobLimitPerChunk()) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
