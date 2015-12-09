package com.katmoo.ast.client.gui;

import com.katmoo.ast.handler.ConfigHandler;
import com.katmoo.ast.ref.RefStr;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class ModGuiConfig extends GuiConfig {
    public ModGuiConfig(GuiScreen guiScreen) {
        super(guiScreen,
                new ConfigElement(ConfigHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                RefStr.MOD_ID,
                true,
                true,
                GuiConfig.getAbridgedConfigPath(ConfigHandler.configuration.toString()));
    }
}
