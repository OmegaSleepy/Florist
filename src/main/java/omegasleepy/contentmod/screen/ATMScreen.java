package omegasleepy.contentmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import omegasleepy.contentmod.MainLogic;

public class ATMScreen extends HandledScreen<ATMScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(MainLogic.MOD_ID, "textures/gui/atm_gui.png");

    public ATMScreen (ATMScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init () {
        super.init();
        titleX = (this.width - this.backgroundWidth) / 2;
        titleY = (this.height - this.backgroundHeight) / 2;
        playerInventoryTitleX = (this.width - this.backgroundWidth) / 2 + 200;
    }

    @Override
    protected void drawBackground (DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionColorProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);
    }

    private void renderProgressArrow (DrawContext context, float x, float y) {
        if(handler.isCrafting()){
            context.drawTexture(TEXTURE, x + 85, y + 30, 176, 0, 8, handler.getScaledProgress());
        }
    }

    @Override
    public void render (DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context,mouseX,mouseY);
    }
}
