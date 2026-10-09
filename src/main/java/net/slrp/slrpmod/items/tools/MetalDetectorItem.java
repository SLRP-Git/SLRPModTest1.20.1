package net.slrp.slrpmod.items.tools;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

// Custom Item Class
// If you want more press either scroll whell on Item or ctrl + h to see other custom items
public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        // "!" used when we are only on the client server !!!
        if(!pContext.getLevel().isClientSide()) {
            // position where we clicked
            BlockPos positionClicked = pContext.getClickedPos();
            // Player identification
            Player player = pContext.getPlayer();

            //resets found block check
            boolean foundBlock = false;

            //get clicked block Y position and go repeat the Y level value so 100,99,98 so on in Y level,
            // with 64 so it goes to deepslate to bedrock on -64Y everytime to check every block below in Y level for Specific block.
            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

                //Check for specific item
                if(isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;
                    
                    break;
                }
            }

            //send info where is the block found
            if(!foundBlock) {
                player.sendSystemMessage(Component.literal("No valuable Found!"));
            }
        }

        //Damage Item when used
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        //animation when interact
        return InteractionResult.SUCCESS;
    }

    //position send to the chat of block
    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.translatable(
                        "message.slrpmod.metal_detector.found",
                        Component.translatable(block.getDescriptionId()),
                        blockPos.getX(),
                        blockPos.getY(),
                        blockPos.getZ()
                )
        );
    }

    //what items gonna try to find
    private boolean isValuableBlock(BlockState state) {
        return state.is(Blocks.IRON_ORE) || state.is(Blocks.DIAMOND_ORE);
    }
}
