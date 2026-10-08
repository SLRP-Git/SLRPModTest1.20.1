package net.slrp.slrpmod.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slrp.slrpmod.SLRPSHITMOD;
import net.slrp.slrpmod.items.tools.MetalDetectorItem;

public class ModItems {
    //Register ModItems
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SLRPSHITMOD.MOD_ID);

    //Register SKERO Item to ModItems
    public static final RegistryObject<Item> SKERO = ITEMS.register("skero",
            () -> new Item(new Item.Properties()));
    //Register SAPPHIRE Item to ModItems
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    //Register RAW SAPPHIRE Item to ModItems
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));
    //Register PALICE Item to ModItems
    public static final RegistryObject<Item> PALICE = ITEMS.register("palice",
            () -> new Item(new Item.Properties()));
    //Register METALDETECTOR CUSTOM! Item to ModItems
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));


    //Register Items to main java (SLRPSHITMOD)
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
