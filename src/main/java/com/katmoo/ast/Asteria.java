package com.katmoo.ast;

import com.katmoo.ast.handler.ConfigHandler;
import com.katmoo.ast.handler.FMLEventHandler;
import com.katmoo.ast.init.ModItems;
import com.katmoo.ast.proxy.IProxy;
import com.katmoo.ast.ref.RefStr;
import com.katmoo.ast.util.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = RefStr.MOD_ID, name = RefStr.MOD_NAME, version = RefStr.VERSION, guiFactory = RefStr.GUI_FACTORY_CLASS)
public class Asteria {
    @Mod.Instance(RefStr.MOD_ID)
    public static Asteria instance;

    @SidedProxy(clientSide = RefStr.CLIENT_PROXY_CLASS, serverSide = RefStr.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());

        ModItems.init();

        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(FMLEventHandler.INSTANCE);

        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        LogHelper.info("Post Initialization Complete!");
    }
}
