package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.gui.NormalGUIGui;
import io.netty.buffer.Unpooled;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IWorld;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.fml.network.NetworkHooks;

public class MagmaGeneratorOnBlockRightClickedProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure MagmaGeneratorOnBlockRightClicked!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure MagmaGeneratorOnBlockRightClicked!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure MagmaGeneratorOnBlockRightClicked!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure MagmaGeneratorOnBlockRightClicked!");
         }

      } else if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure MagmaGeneratorOnBlockRightClicked!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         Entity entity = (Entity)dependencies.get("entity");
         if (Items.field_151129_at == (entity instanceof LivingEntity ? ((LivingEntity)entity).func_184614_ca() : ItemStack.field_190927_a).func_77973_b()) {
            TileEntity _ent = world.func_175625_s(new BlockPos(x, y, z));
            int _amount = 1000;
            if (_ent != null) {
               _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.fill(new FluidStack(Fluids.field_204547_b, _amount), FluidAction.EXECUTE);
               });
            }

            if (entity instanceof LivingEntity) {
               ItemStack _setstack = new ItemStack(Items.field_151133_ar);
               _setstack.func_190920_e(1);
               ((LivingEntity)entity).func_184611_a(Hand.MAIN_HAND, _setstack);
               if (entity instanceof ServerPlayerEntity) {
                  ((ServerPlayerEntity)entity).field_71071_by.func_70296_d();
               }
            }
         } else if (entity instanceof ServerPlayerEntity) {
            final BlockPos _bpos = new BlockPos(x, y, z);
            NetworkHooks.openGui((ServerPlayerEntity)entity, new INamedContainerProvider() {
               public ITextComponent func_145748_c_() {
                  return new StringTextComponent("NormalGUI");
               }

               public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
                  return new NormalGUIGui.GuiContainerMod(id, inventory, (new PacketBuffer(Unpooled.buffer())).func_179255_a(_bpos));
               }
            }, _bpos);
         }

      }
   }
}
