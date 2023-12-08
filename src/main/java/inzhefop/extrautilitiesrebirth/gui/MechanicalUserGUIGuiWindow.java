package inzhefop.extrautilitiesrebirth.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.energy.CapabilityEnergy;

@OnlyIn(Dist.CLIENT)
public class MechanicalUserGUIGuiWindow extends ContainerScreen<MechanicalUserGUIGui.GuiContainerMod> {
   private World world;
   private int x;
   private int y;
   private int z;
   private PlayerEntity entity;
   private static final HashMap guistate;
   private static final ResourceLocation texture;

   public MechanicalUserGUIGuiWindow(MechanicalUserGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.field_146999_f = 176;
      this.field_147000_g = 166;
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
      Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("extrautilitiesrebirth:textures/screens/upgrade_icon.png"));
      func_238463_a_(ms, this.field_147003_i + 8, this.field_147009_r + 19, 0.0F, 0.0F, 16, 16, 16, 16);
      Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("extrautilitiesrebirth:textures/screens/energy_bar_holder.png"));
      func_238463_a_(ms, this.field_147003_i + 150, this.field_147009_r + 7, 0.0F, 0.0F, 18, 72, 18, 72);
      double energy = (double)(((<undefinedtype>)(new Object() {
         public int getEnergyStored(IWorld world, BlockPos pos) {
            AtomicInteger _retval = new AtomicInteger(0);
            TileEntity _ent = world.func_175625_s(pos);
            if (_ent != null) {
               _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                  _retval.set(capability.getEnergyStored());
               });
            }

            return _retval.get();
         }
      })).getEnergyStored(this.world, new BlockPos(this.x, this.y, this.z)) * 70 / ((<undefinedtype>)(new Object() {
         public int getMaxEnergyStored(IWorld world, BlockPos pos) {
            AtomicInteger _retval = new AtomicInteger(0);
            TileEntity _ent = world.func_175625_s(pos);
            if (_ent != null) {
               _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                  _retval.set(capability.getMaxEnergyStored());
               });
            }

            return _retval.get();
         }
      })).getMaxEnergyStored(this.world, new BlockPos(this.x, this.y, this.z)));
      int ebf = (int)energy;
      Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("extrautilitiesrebirth:textures/screens/energybarfill.png"));
      func_238463_a_(ms, this.field_147003_i + 151, this.field_147009_r + 8, 0.0F, 0.0F, 16, 70, 16, 70);
      Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("extrautilitiesrebirth:textures/screens/gray.png"));
      func_238463_a_(ms, this.field_147003_i + 151, this.field_147009_r + 8, 0.0F, 0.0F, 16, 70 - ebf, 16, 70 - ebf);
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
      this.field_230712_o_.func_238421_b_(ms, "Machanical User", 7.0F, 5.0F, -12829636);
      this.field_230712_o_.func_238421_b_(ms, "" + ((<undefinedtype>)(new Object() {
         public String getValue(BlockPos pos, String tag) {
            TileEntity tileEntity = MechanicalUserGUIGuiWindow.this.world.func_175625_s(pos);
            return tileEntity != null ? tileEntity.getTileData().func_74779_i(tag) : "";
         }
      })).getValue(new BlockPos(this.x, this.y, this.z), "mode") + "", 51.0F, 67.0F, -12829636);
   }

   public void func_231164_f_() {
      super.func_231164_f_();
      Minecraft.func_71410_x().field_195559_v.func_197967_a(false);
   }

   public void func_231158_b_(Minecraft minecraft, int width, int height) {
      super.func_231158_b_(minecraft, width, height);
      minecraft.field_195559_v.func_197967_a(true);
      this.func_230480_a_(new Button(this.field_147003_i + 7, this.field_147009_r + 61, 40, 20, new StringTextComponent("Toggle"), (e) -> {
         ExtrautilitiesrebirthMod.PACKET_HANDLER.sendToServer(new MechanicalUserGUIGui.ButtonPressedMessage(0, this.x, this.y, this.z));
         MechanicalUserGUIGui.handleButtonAction(this.entity, 0, this.x, this.y, this.z);
      }));
   }

   static {
      guistate = MechanicalUserGUIGui.guistate;
      texture = new ResourceLocation("extrautilitiesrebirth:textures/screens/mechanical_user_gui.png");
   }
}
