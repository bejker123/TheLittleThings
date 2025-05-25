package com.joyforge.thelittlethings.thelittlethings.items;

import com.joyforge.thelittlethings.thelittlethings.Thelittlethings;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BannerPatternsComponent;
import net.minecraft.component.type.BlocksAttacksComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Optional;

public class ModItems {
    public static Item register(Item item, Identifier id){
        return Registry.register(Registries.ITEM,id,item);
    }

    public static final Identifier LIGHT_FOOTED_LEATHER_BOOTS_ID = Thelittlethings.id("light_footed_leather_boots");

    public static final RegistryKey<Item> LIGHT_FOOTED_LEATHER_BOOTS_KEY = RegistryKey.of(RegistryKeys.ITEM,LIGHT_FOOTED_LEATHER_BOOTS_ID);

    public static final LightFootedLeatherBoots LIGHT_FOOTED_LEATHER_BOOTS = (LightFootedLeatherBoots) register(
            new LightFootedLeatherBoots(new Item.Settings()
                    .registryKey(LIGHT_FOOTED_LEATHER_BOOTS_KEY)
                    .armor(ArmorMaterials.LEATHER, EquipmentType.BOOTS)),
            LIGHT_FOOTED_LEATHER_BOOTS_ID
    );

    public static final Identifier TURTLE_SHIELD_ID = Thelittlethings.id("turtle_shield");

    public static final RegistryKey<Item> TURTLE_SHIELD_KEY = RegistryKey.of(RegistryKeys.ITEM,TURTLE_SHIELD_ID);

    public static final TurtleShield TURTLE_SHIELD = (TurtleShield) register(
            new TurtleShield(new Item.Settings()
                    .registryKey(TURTLE_SHIELD_KEY)
                    .maxDamage(336)
                    .component(DataComponentTypes.BANNER_PATTERNS, BannerPatternsComponent.DEFAULT)
                    .repairable(ItemTags.WOODEN_TOOL_MATERIALS)
                    .equippableUnswappable(EquipmentSlot.OFFHAND)
                    .component(
                            DataComponentTypes.BLOCKS_ATTACKS,
                            new BlocksAttacksComponent(
                                    0.25F,
                                    1.0F,
                                    List.of(new BlocksAttacksComponent.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                                    new BlocksAttacksComponent.ItemDamage(3.0F, 1.0F, 1.0F),
                                    Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                                    Optional.of(SoundEvents.ITEM_SHIELD_BLOCK),
                                    Optional.of(SoundEvents.ITEM_SHIELD_BREAK)
                            )
                    )
                    .component(DataComponentTypes.BREAK_SOUND, SoundEvents.ITEM_SHIELD_BREAK)
                    .armor(ArmorMaterials.TURTLE_SCUTE, EquipmentType.CHESTPLATE)
            ),
            TURTLE_SHIELD_ID
    );

    public static void init(){
    }

}
