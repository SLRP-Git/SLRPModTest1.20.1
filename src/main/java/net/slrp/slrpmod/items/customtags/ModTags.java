package net.slrp.slrpmod.items.customtags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.slrp.slrpmod.SLRPSHITMOD;

public class ModTags {
    //For Blocks
    public static class Blocks {
        //Create TagKey for metal detector as a example
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");

        //Create made tags for blocks
        private  static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(SLRPSHITMOD.MOD_ID, name));
        }
    }

    //For Items
    public static class Items {

        //Create made tags for items
        private  static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(SLRPSHITMOD.MOD_ID, name));
        }
    }
}
