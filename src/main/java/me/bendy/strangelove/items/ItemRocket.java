package me.bendy.strangelove.items;

import me.bendy.strangelove.constants.Constants;
import me.bendy.strangelove.world.RocketExplosion;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

public class ItemRocket extends Item {
    public static final String uName = Constants.ROCKET;

    public ItemRocket() {
        setUnlocalizedName(uName);
        setCreativeTab(CreativeTabs.tabCombat);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        return super.onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        MovingObjectPosition objectPosition = ItemUtility.getTargetBlock(playerIn, 400);
        if (objectPosition != null) {
            BlockPos blockPos = objectPosition.getBlockPos();

            Explosion explosion = new RocketExplosion(worldIn, playerIn, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 5.0f, true, true);
            explosion.doExplosionA();
            explosion.doExplosionB(true);
        }

        return super.onItemRightClick(itemStackIn, worldIn, playerIn);
    }
}
