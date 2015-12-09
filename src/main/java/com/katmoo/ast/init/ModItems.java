package com.katmoo.ast.init;

import com.katmoo.ast.item.ItemAST;
import com.katmoo.ast.item.ItemManual;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {
    public static final ItemAST manual = new ItemManual();

    public static void init() {
        GameRegistry.registerItem(manual, "manual");
    }
}
