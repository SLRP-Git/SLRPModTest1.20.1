package net.slrp.slrpmod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slrp.slrpmod.SLRPSHITMOD;
import net.slrp.slrpmod.items.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    //Creates Blocks for forge register
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SLRPSHITMOD.MOD_ID);

    //Creates Unique Block Object sapphire_block with Properties of IronBlock with sound of Amethyst
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registryObject("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> SKERO_BLOCK = registryObject("skero_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AZALEA_LEAVES).sound(SoundType.AZALEA_LEAVES)));

    //Creates Ore Block with expirience and acting as a stone
    public static final RegistryObject<Block> SAPPHIRE_ORE = registryObject("sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));


    //First Register Block, Second Line Register the Block Item, Third Return The Block
    private static <T extends Block> RegistryObject<T> registryObject(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    //Register it to items because it doesnt exist as item it self
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    //Send It to eventBus for main java to read
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
