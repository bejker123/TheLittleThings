package com.joyforge.thelittlethings.thelittlethings;

import com.joyforge.thelittlethings.thelittlethings.items.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thelittlethings implements ModInitializer {

    public static String MOD_ID = "thelittlethings";

    public static Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier id(String id) {
        return Identifier.of(MOD_ID,id);
    }

    @Override
    public void onInitialize() {
        ModItems.init();
    }
}
