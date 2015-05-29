package me.bendy.strangelove.items;

import me.bendy.strangelove.constants.Constants;
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

            throwInventory(worldIn, playerIn, blockPos.getX(), blockPos.getY(), blockPos.getZ());
            worldIn.createExplosion(playerIn, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 3.0f, true);
        }

        return super.onItemRightClick(itemStackIn, worldIn, playerIn);
    }

    private void throwInventory(World world, EntityPlayer player, float x, float y, float z) {
        Random rand = new Random();
        int inventorySize = player.inventory.getSizeInventory();
        for (int i = 0; i < inventorySize; i++) {
            ItemStack inventoryStack = player.inventory.getStackInSlot(i);

            if (inventoryStack != null) {
                ItemStack itemStack = new ItemStack(inventoryStack.getItem(), 1);
                EntityItem entityitem = new EntityItem(world, x, y + 1.5f, z, itemStack);

                // Might need some adjustments
                float f = rand.nextFloat() * 0.5F;
                float f1 = rand.nextFloat() * (float)Math.PI * 2.0F;
                entityitem.motionX = (double)(-MathHelper.sin(f1) * f);
                entityitem.motionZ = (double)(MathHelper.cos(f1));
                entityitem.motionY = 0.8;

                player.joinEntityItemWithWorld(entityitem);
            }
        }
    }
}
