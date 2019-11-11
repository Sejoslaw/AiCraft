package com.github.sejoslaw.aicraft;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.World;

public class EntityAiGoal extends Goal {
    protected Entity entity;
    protected World world;

    public EntityAiGoal(Entity entity) {
        this.entity = entity;
        this.world = this.entity.world;
    }

    public boolean shouldExecute() {
        return true;
    }
}
