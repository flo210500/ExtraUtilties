package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;

public class SorterTitleProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure SorterTitle!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure SorterTitle!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure SorterTitle!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure SorterTitle!");
         }

      } else {
         final IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         if (!world.func_201670_d()) {
            BlockPos _bp = new BlockPos(x, y, z);
            TileEntity _tileEntity = world.func_175625_s(_bp);
            BlockState _bs = world.func_180495_p(_bp);
            if (_tileEntity != null) {
               _tileEntity.getTileData().func_74778_a("mtitle", ((<undefinedtype>)(new Object() {
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
               })).getItemStack(new BlockPos(x, y, z), 16).func_200301_q().getString().substring(1, ((<undefinedtype>)(new Object() {
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
               })).getItemStack(new BlockPos(x, y, z), 16).func_200301_q().getString().length() - 1));
            }

            if (world instanceof World) {
               ((World)world).func_184138_a(_bp, _bs, _bs, 3);
            }
         }

      }
   }
}
