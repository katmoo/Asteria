package com.katmoo.ast.creativetab;

import com.katmoo.ast.ref.RefStr;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabAST {
    public static CreativeTabs AST_TAB = new CreativeTabs(RefStr.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return Items.nether_star;
        }
    };
}
