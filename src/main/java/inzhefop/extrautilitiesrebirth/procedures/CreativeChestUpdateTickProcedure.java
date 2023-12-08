package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class CreativeChestUpdateTickProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure CreativeChestUpdateTick!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure CreativeChestUpdateTick!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure CreativeChestUpdateTick!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure CreativeChestUpdateTick!");
         }

      } else {
         final IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         TileEntity _ent = world.func_175625_s(new BlockPos(x, y, z));
         if (_ent != null) {
            int _sltid = true;
            ItemStack _setstack = ((<undefinedtype>)(new Object() {
               public ItemStack getItemStack(BlockPos pos, int sltid) {
                  AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.field_190927_a);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.getStackInSlot(sltid).func_77946_l());
                     });
                  }

                  return (ItemStack)_retval.get();
               }
            })).getItemStack(new BlockPos(x, y, z), 0);
            _setstack.func_190920_e(64);
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               if (capability instanceof IItemHandlerModifiable) {
                  ((IItemHandlerModifiable)capability).setStackInSlot(1, _setstack);
               }

            });
         }

      }
   }
}
