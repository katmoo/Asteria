package com.katmoo.ast.client.gui.pages;

import com.katmoo.ast.client.gui.GuiManual;
import net.minecraft.util.StatCollector;

public class PageIndex extends GuiManual {

    private static final int PAGES = 1;

    @Override
    public void drawScreen(int mouseX, int mouseY, float renderPartials) {
        int bookXStart = (width - 192) / 2;

        fontRendererObj.drawSplitString(StatCollector.translateToLocal("ast.page:manual.cover01"), bookXStart + 37, 3 + 15, 115, 0x000000);

        super.drawScreen(mouseX, mouseY, renderPartials);
    }
}
