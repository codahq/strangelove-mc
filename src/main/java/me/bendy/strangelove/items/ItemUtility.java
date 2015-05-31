package me.bendy.strangelove.items;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class ItemUtility {
    public static MovingObjectPosition getTargetBlock(EntityPlayer player, int distance) {
        Vec3 posVec = new Vec3(player.posX, player.posY + player.getEyeHeight(), player.posZ);
        Vec3 lookVec = player.getLookVec();
        lookVec = posVec.addVector(distance * lookVec.xCoord, distance * lookVec.yCoord, distance * lookVec.zCoord);
        MovingObjectPosition mop = player.worldObj.rayTraceBlocks(posVec, lookVec);
        return mop;
    }
}
