package com.github.sejoslaw.aicraft;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(AiCraft.MODID)
public class AiCraft {
    public static final String MODID = "aicraft";

    public AiCraft() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onMonsterConstructing(EntityEvent.EntityConstructing event) {
        Entity entity = event.getEntity();

        if (!(entity instanceof IMob) && !(entity instanceof MobEntity)) {
            return;
        }

        MobEntity mob = (MobEntity) entity;

        mob.targetSelector.addGoal(1, new MonsterAiGoal(mob));
    }

    @SubscribeEvent
    public void onVillagerConstructing(EntityEvent.EntityConstructing event) {
        Entity entity = event.getEntity();

        if (!(entity instanceof VillagerEntity)) {
            return;
        }

        VillagerEntity villager = (VillagerEntity) entity;

        villager.goalSelector.addGoal(1, new VillagerAiGoal(villager));
    }
}
