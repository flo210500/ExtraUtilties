package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.Map;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class TrashCanUpdateTickProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure TrashCanUpdateTick!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure TrashCanUpdateTick!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure TrashCanUpdateTick!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure TrashCanUpdateTick!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         TileEntity _ent = world.func_175625_s(new BlockPos(x, y, z));
         boolean _sltid;
         ItemStack _setstack;
         if (_ent != null) {
            _sltid = false;
            _setstack = new ItemStack(Blocks.field_150350_a);
            _setstack.func_190920_e(1);
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               if (capability instanceof IItemHandlerModifiable) {
                  ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
               }

            });
         }

         _ent = world.func_175625_s(new BlockPos(x, y, z));
         if (_ent != null) {
            _sltid = true;
            _setstack = new ItemStack(Blocks.field_150350_a);
            _setstack.func_190920_e(1);
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               if (capability instanceof IItemHandlerModifiable) {
                  ((IItemHandlerModifiable)capability).setStackInSlot(1, _setstack);
               }

            });
         }

         _ent = world.func_175625_s(new BlockPos(x, y, z));
         if (_ent != null) {
            _sltid = true;
            _setstack = new ItemStack(Blocks.field_150350_a);
            _setstack.func_190920_e(1);
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               if (capability instanceof IItemHandlerModifiable) {
                  ((IItemHandlerModifiable)capability).setStackInSlot(2, _setstack);
               }

            });
         }

         _ent = world.func_175625_s(new BlockPos(x, y, z));
         if (_ent != null) {
            _sltid = true;
            _setstack = new ItemStack(Blocks.field_150350_a);
            _setstack.func_190920_e(1);
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               if (capability instanceof IItemHandlerModifiable) {
                  ((IItemHandlerModifiable)capability).setStackInSlot(3, _setstack);
               }

            });
         }

         _ent = world.func_175625_s(new BlockPos(x, y, z));
         if (_ent != null) {
            _sltid = true;
            _setstack = new ItemStack(Blocks.field_150350_a);
            _setstack.func_190920_e(1);
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               if (capability instanceof IItemHandlerModifiable) {
                  ((IItemHandlerModifiable)capability).setStackInSlot(4, _setstack);
               }

            });
         }

         _ent = world.func_175625_s(new BlockPos(x, y, z));
         if (_ent != null) {
            _sltid = true;
            _setstack = new ItemStack(Blocks.field_150350_a);
            _setstack.func_190920_e(1);
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               if (capability instanceof IItemHandlerModifiable) {
                  ((IItemHandlerModifiable)capability).setStackInSlot(5, _setstack);
               }

            });
         }

         _ent = world.func_175625_s(new BlockPos(x, y, z));
         if (_ent != null) {
            _sltid = true;
            _setstack = new ItemStack(Blocks.field_150350_a);
            _setstack.func_190920_e(1);
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               if (capability instanceof IItemHandlerModifiable) {
                  ((IItemHandlerModifiable)capability).setStackInSlot(6, _setstack);
               }

            });
         }

         _ent = world.func_175625_s(new BlockPos(x, y, z));
         if (_ent != null) {
            _sltid = true;
            _setstack = new ItemStack(Blocks.field_150350_a);
            _setstack.func_190920_e(1);
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               if (capability instanceof IItemHandlerModifiable) {
                  ((IItemHandlerModifiable)capability).setStackInSlot(7, _setstack);
               }

            });
         }

         _ent = world.func_175625_s(new BlockPos(x, y, z));
         if (_ent != null) {
            _sltid = true;
            _setstack = new ItemStack(Blocks.field_150350_a);
            _setstack.func_190920_e(1);
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               if (capability instanceof IItemHandlerModifiable) {
                  ((IItemHandlerModifiable)capability).setStackInSlot(8, _setstack);
               }

            });
         }

      }
   }
}
