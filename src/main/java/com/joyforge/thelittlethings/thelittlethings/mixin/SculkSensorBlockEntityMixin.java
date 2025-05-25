package com.joyforge.thelittlethings.thelittlethings.mixin;

import com.joyforge.thelittlethings.thelittlethings.Thelittlethings;
import com.joyforge.thelittlethings.thelittlethings.items.LightFootedLeatherBoots;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.entity.SculkSensorBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(SculkSensorBlockEntity.VibrationCallback.class)
public class SculkSensorBlockEntityMixin {

    @Inject(method = "accept",at = @At("HEAD"), cancellable = true)
    void onAccepts(ServerWorld world, BlockPos pos, RegistryEntry<GameEvent> event, Entity sourceEntity, Entity entity, float distance, CallbackInfo ci){
        if(sourceEntity instanceof LivingEntity livingEntity){
            var ret = event.getKeyOrValue();
            var leftRaw = ret.left();
            if(leftRaw.isPresent()){
                var left = leftRaw.get();
                if(Objects.equals(left.getValue().toString(), "minecraft:step")){
                    ItemStack stack = livingEntity.getEquippedStack(EquipmentSlot.FEET);
                    if(stack.getItem() instanceof LightFootedLeatherBoots){
                        ci.cancel();
                        Thelittlethings.LOGGER.info("{}, didn't stepped.",sourceEntity);
                    }else{
                        Thelittlethings.LOGGER.info("{}, stepped.",sourceEntity);
                    }
                }
            }
        }
    }
}
