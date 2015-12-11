package com.katmoo.ast.item;

import com.katmoo.ast.client.gui.GuiManual;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemManual extends ItemAST {
    public ItemManual() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName("manual");
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(StatCollector.translateToLocal(super.getUnlocalizedName() + ".desc0"));
        list.add(StatCollector.translateToLocal(super.getUnlocalizedName() + ".desc1"));
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (world.isRemote) {
            openBook();
        }
        return stack;
    }

    @SideOnly(Side.CLIENT)
    public void openBook() {
        Minecraft.getMinecraft().displayGuiScreen(new GuiManual());
    }
}
