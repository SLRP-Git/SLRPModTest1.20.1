package net.slrp.slrpmod.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.slrp.slrpmod.SLRPSHITMOD;
import net.slrp.slrpmod.block.ModBlocks;
import net.slrp.slrpmod.items.tools.MetalDetectorItem;

public class ModCreativeTabs {

    //Creates register for new creative tab
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SLRPSHITMOD.MOD_ID);

    //Adds Icon thats item and items to the tab
    public static final RegistryObject<CreativeModeTab> SLRP_TAB = CREATIVE_MODE_TABS.register("slrp_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SKERO.get()))
                    .title(Component.translatable("creativetab.slrp_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        //Adding Items to the tab
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModItems.SKERO.get());
                        pOutput.accept(ModItems.RAW_SAPPHIRE.get());
                        pOutput.accept(ModItems.PALICE.get());

                        //Adding Food to the tab
                        pOutput.accept(ModItems.RYZE_S_HOVEZIM.get());

                        //Adding Tools to the tab
                        pOutput.accept(ModItems.METAL_DETECTOR.get());

                        //Adding Blocks to the tab
                        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.PALICE_BLOCK.get());

                        //Adding Custom Blocks to the tab
                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                    }))
                    .build());

    //Register the tab to bus in main java (SLRPSHITMOD)
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
