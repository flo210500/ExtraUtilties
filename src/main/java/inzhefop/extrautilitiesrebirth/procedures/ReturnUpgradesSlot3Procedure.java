package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.item.EnchantedSpeedUpgradeItem;
import inzhefop.extrautilitiesrebirth.item.SpeedUpgradeItem;
import inzhefop.extrautilitiesrebirth.item.SuperSpeedUpgradeItem;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.items.CapabilityItemHandler;

public class ReturnUpgradesSlot3Procedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure ReturnUpgradesSlot3!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure ReturnUpgradesSlot3!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure ReturnUpgradesSlot3!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure ReturnUpgradesSlot3!");
         }

      } else {
         final IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         double mulktiplierx = 0.0D;
         if (SpeedUpgradeItem.block == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 3).func_77973_b() && EnchantedSpeedUpgradeItem.block == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 3).func_77973_b() && SuperSpeedUpgradeItem.block == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 3).func_77973_b()) {
            mulktiplierx = (double)((<undefinedtype>)(new Object() {
               public int getAmount(IWorld world, BlockPos pos, int sltid) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.getStackInSlot(sltid).func_190916_E());
                     });
                  }

                  return _retval.get();
               }
            })).getAmount(world, new BlockPos(x, y, z), 3);
         }

         mulktiplierx = 0.0D;
      }
   }
}
