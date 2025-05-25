package com.joyforge.thelittlethings.thelittlethings.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class TurtleShield extends ShieldItem {
    public TurtleShield(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if(slot != EquipmentSlot.CHEST){
            return;
        }
        if(!entity.isTouchingWater()){
            return;
        }
        if(entity instanceof LivingEntity livingEntity){
            if(livingEntity.hasStatusEffect(StatusEffects.DOLPHINS_GRACE)){
                return;
            }
            livingEntity.addStatusEffect(
                    new StatusEffectInstance(
                            StatusEffects.DOLPHINS_GRACE,
                            100
                    )
            );
        }
    }
}
