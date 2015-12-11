package com.katmoo.ast.handler;

import com.katmoo.ast.init.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public enum FMLEventHandler {

    INSTANCE;

    private static final String NBT_KEY = "ast.firstjoin";

    @SubscribeEvent
    public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        //if (ConfigHandler.isStartingBookDisabled()) {
        //    return;
        //}

        NBTTagCompound data = event.player.getEntityData();
        NBTTagCompound persistent;
        if (!data.hasKey(EntityPlayer.PERSISTED_NBT_TAG)) {
            data.setTag(EntityPlayer.PERSISTED_NBT_TAG, (persistent = new NBTTagCompound()));
        } else {
            persistent = data.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
        }

        if (!persistent.hasKey(NBT_KEY)) {
            persistent.setBoolean(NBT_KEY, true);
            event.player.inventory.addItemStackToInventory(new ItemStack(ModItems.manual));
        }
    }
}
