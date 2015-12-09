package com.katmoo.ast.item;

public class ItemManual extends ItemAST {
    public ItemManual() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName("manual");
    }
}
