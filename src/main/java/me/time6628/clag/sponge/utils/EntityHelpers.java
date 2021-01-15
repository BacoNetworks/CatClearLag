package me.time6628.clag.sponge.utils;

import me.time6628.clag.sponge.CatClearLag;
import me.time6628.clag.sponge.EntityRemover;
import me.time6628.clag.sponge.api.Type;
import org.spongepowered.api.entity.ExperienceOrb;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.living.Hostile;
import org.spongepowered.api.entity.living.Living;

import java.util.List;

public class EntityHelpers {

    private final static CatClearLag plugin = CatClearLag.instance;

    public static Integer clearGroundItems() {
        return new EntityRemover<Item>(plugin.getCclService().getPredicate(Type.ITEM), Type.ITEM).removeEntities();
    }

}
