package me.bendy.strangelove.items;

import me.bendy.strangelove.constants.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemRocket extends Item {
    public static final String uName = Constants.ROCKET;

    public ItemRocket() {
        setUnlocalizedName(uName);
        setCreativeTab(CreativeTabs.tabCombat);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        worldIn.createExplosion(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, 1.0f, true);

        return super.onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
    }
}
