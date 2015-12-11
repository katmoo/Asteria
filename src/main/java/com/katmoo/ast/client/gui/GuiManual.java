package com.katmoo.ast.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class GuiManual extends GuiScreen {

    static final ResourceLocation texture = new ResourceLocation("ast:textures/gui/manual.png");

    private static final int BUTTON_NEXT = 0;
    private static final int BUTTON_PREV = 1;

    private int pageIndex = 0;
    private GuiManualChangePage nextPage;
    private GuiManualChangePage prevPage;

    /*public final String unlocalizedName;
    public GuiManual(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
    }

    public List<GuiManual> pages = new ArrayList<GuiManual>();

    public GuiManual setPages(GuiManual... pages) {
        for(GuiManual page : pages) {
            page.unlocalizedName = "ast.page." + getLazyUnlocalizedName() + page.unlocalizedName;
        }

        return super.setPages(pages);
    }*/

    @Override
    public void initGui() {
        super.initGui();
        @SuppressWarnings("unchecked")
        List<GuiButton> buttons = buttonList;

        int bookXBegin = (width - 192) / 2;

        buttons.add(nextPage = new GuiManualChangePage(BUTTON_NEXT, bookXBegin + 120, 2 + 154, false));
        buttons.add(prevPage = new GuiManualChangePage(BUTTON_PREV, bookXBegin + 38, 2 + 154, true));
        updateButtonState();
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        switch (button.id) {
            case BUTTON_NEXT:
                ++pageIndex;
                break;
            case BUTTON_PREV:
                --pageIndex;
                break;
        }
        updateButtonState();
    }

    private void updateButtonState() {
        //nextPage.visible = pageIndex < pages.size() - 1;
        prevPage.visible = pageIndex > 0;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float renderPartials) {
        int bookXStart = (width - 192) / 2;
        mc.renderEngine.bindTexture(texture);
        drawTexturedModalRect(bookXStart, 2, 0, 0, 192, 192);

        super.drawScreen(mouseX, mouseY, renderPartials);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    protected void keyTyped(char c, int key) {
        char lowerCase = Character.toLowerCase(c);
        if (key == Keyboard.KEY_ESCAPE) {
            mc.displayGuiScreen(null);
        }
    }
}
