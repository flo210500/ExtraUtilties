package inzhefop.extrautilitiesrebirth.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GoldenChestGUIGuiWindow extends ContainerScreen<GoldenChestGUIGui.GuiContainerMod> {
   private World world;
   private int x;
   private int y;
   private int z;
   private PlayerEntity entity;
   private static final HashMap guistate;
   private static final ResourceLocation texture;

   public GoldenChestGUIGuiWindow(GoldenChestGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.field_146999_f = 176;
      this.field_147000_g = 216;
   }

   public void func_230430_a_(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
      this.func_230446_a_(ms);
      super.func_230430_a_(ms, mouseX, mouseY, partialTicks);
      this.func_230459_a_(ms, mouseX, mouseY);
   }

   protected void func_230450_a_(MatrixStack ms, float partialTicks, int gx, int gy) {
      RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      Minecraft.func_71410_x().func_110434_K().func_110577_a(texture);
      int k = (this.field_230708_k_ - this.field_146999_f) / 2;
      int l = (this.field_230709_l_ - this.field_147000_g) / 2;
      func_238463_a_(ms, k, l, 0.0F, 0.0F, this.field_146999_f, this.field_147000_g, this.field_146999_f, this.field_147000_g);
      RenderSystem.disableBlend();
   }

   public boolean func_231046_a_(int key, int b, int c) {
      if (key == 256) {
         this.field_230706_i_.field_71439_g.func_71053_j();
         return true;
      } else {
         return super.func_231046_a_(key, b, c);
      }
   }

   public void func_231023_e_() {
      super.func_231023_e_();
   }

   protected void func_230451_b_(MatrixStack ms, int mouseX, int mouseY) {
      this.field_230712_o_.func_238421_b_(ms, "Gold Chest", 7.0F, 6.0F, -12829636);
   }

   public void func_231164_f_() {
      super.func_231164_f_();
      Minecraft.func_71410_x().field_195559_v.func_197967_a(false);
   }

   public void func_231158_b_(Minecraft minecraft, int width, int height) {
      super.func_231158_b_(minecraft, width, height);
      minecraft.field_195559_v.func_197967_a(true);
   }

   static {
      guistate = GoldenChestGUIGui.guistate;
      texture = new ResourceLocation("extrautilitiesrebirth:textures/screens/golden_chest_gui.png");
   }
}
