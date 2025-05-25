package com.joyforge.thelittlethings.thelittlethings.items;

import com.joyforge.thelittlethings.thelittlethings.Thelittlethings;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

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

    public static void init(){
    }

}
