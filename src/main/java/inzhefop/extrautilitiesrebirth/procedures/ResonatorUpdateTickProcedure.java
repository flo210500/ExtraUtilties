package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.PolishedStoneBlock;
import inzhefop.extrautilitiesrebirth.block.QuartzburntBlock;
import inzhefop.extrautilitiesrebirth.block.RainbowStoneBlock;
import inzhefop.extrautilitiesrebirth.block.StoneburntBlock;
import inzhefop.extrautilitiesrebirth.item.EnchantedSpeedUpgradeItem;
import inzhefop.extrautilitiesrebirth.item.LunarReactiveDustItem;
import inzhefop.extrautilitiesrebirth.item.RedCoalItem;
import inzhefop.extrautilitiesrebirth.item.SpeedUpgradeItem;
import inzhefop.extrautilitiesrebirth.item.SuperSpeedUpgradeItem;
import inzhefop.extrautilitiesrebirth.item.UpgradeBaseItem;
import inzhefop.extrautilitiesrebirth.item.WirelessRFHeatingCoilItem;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class ResonatorUpdateTickProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure ResonatorUpdateTick!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure ResonatorUpdateTick!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure ResonatorUpdateTick!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure ResonatorUpdateTick!");
         }

      } else {
         final IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         ItemStack output = ItemStack.field_190927_a;
         double requiredfe = 0.0D;
         double mulktiplierx = 0.0D;
         if (PolishedStoneBlock.block.func_199767_j() == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b()) {
            output = new ItemStack(StoneburntBlock.block);
            requiredfe = 8000.0D;
         }

         if (Blocks.field_196581_bI.func_199767_j() == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b()) {
            output = new ItemStack(QuartzburntBlock.block);
            requiredfe = 8000.0D;
         }

         if (StoneburntBlock.block.func_199767_j() == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b()) {
            output = new ItemStack(RainbowStoneBlock.block);
            requiredfe = 64000.0D;
         }

         if (Items.field_196128_bn == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b()) {
            output = new ItemStack(LunarReactiveDustItem.block);
            requiredfe = 16000.0D;
         }

         if (Items.field_151044_h == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b()) {
            output = new ItemStack(RedCoalItem.block);
            requiredfe = 16000.0D;
         }

         if (Blocks.field_150445_bS.func_199767_j() == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b()) {
            output = new ItemStack(UpgradeBaseItem.block);
            requiredfe = 8000.0D;
         }

         if (Blocks.field_150411_aY.func_199767_j() == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b()) {
            output = new ItemStack(WirelessRFHeatingCoilItem.block);
            requiredfe = 16000.0D;
         }

         if (SpeedUpgradeItem.block != ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 2).func_77973_b() && EnchantedSpeedUpgradeItem.block != ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 2).func_77973_b() && SuperSpeedUpgradeItem.block != ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 2).func_77973_b()) {
            mulktiplierx = 0.0D;
         } else {
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
            })).getAmount(world, new BlockPos(x, y, z), 2);
         }

         BlockPos _bp;
         TileEntity _tileEntity;
         BlockState _bs;
         if ((double)((<undefinedtype>)(new Object() {
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
         })).getEnergyStored(world, new BlockPos(x, y, z)) > requiredfe && output.func_77973_b() != Blocks.field_150350_a.func_199767_j() && (output.func_77973_b() == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 1).func_77973_b() || ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, new BlockPos(x, y, z), 1) == 0) && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, new BlockPos(x, y, z), 1) < 64) {
            if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _tileEntity = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74780_a("ticks", ((<undefinedtype>)(new Object() {
                     public double getValue(IWorld world, BlockPos pos, String tag) {
                        TileEntity tileEntity = world.func_175625_s(pos);
                        return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                     }
                  })).getValue(world, new BlockPos(x, y, z), "ticks") + 1.0D + mulktiplierx * 1.5625D);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }

            if (((<undefinedtype>)(new Object() {
               public double getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
               }
            })).getValue(world, new BlockPos(x, y, z), "ticks") >= 100.0D) {
               TileEntity _ent = world.func_175625_s(new BlockPos(x, y, z));
               boolean _sltid;
               if (_ent != null) {
                  _sltid = false;
                  int _amount = true;
                  _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable) {
                        ItemStack _stk = capability.getStackInSlot(0).func_77946_l();
                        _stk.func_190918_g(1);
                        ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                     }

                  });
               }

               _ent = world.func_175625_s(new BlockPos(x, y, z));
               int _amount = (int)requiredfe;
               if (_ent != null) {
                  _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                     capability.extractEnergy(_amount, false);
                  });
               }

               _ent = world.func_175625_s(new BlockPos(x, y, z));
               if (_ent != null) {
                  _sltid = true;
                  output.func_190920_e(((<undefinedtype>)(new Object() {
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
                  })).getAmount(world, new BlockPos(x, y, z), 1) + 1);
                  _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable) {
                        ((IItemHandlerModifiable)capability).setStackInSlot(1, output);
                     }

                  });
               }

               if (!world.func_201670_d()) {
                  _bp = new BlockPos(x, y, z);
                  _tileEntity = world.func_175625_s(_bp);
                  _bs = world.func_180495_p(_bp);
                  if (_tileEntity != null) {
                     _tileEntity.getTileData().func_74780_a("ticks", 0.0D);
                  }

                  if (world instanceof World) {
                     ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                  }
               }
            }
         } else if (!world.func_201670_d()) {
            _bp = new BlockPos(x, y, z);
            _tileEntity = world.func_175625_s(_bp);
            _bs = world.func_180495_p(_bp);
            if (_tileEntity != null) {
               _tileEntity.getTileData().func_74780_a("ticks", 0.0D);
            }

            if (world instanceof World) {
               ((World)world).func_184138_a(_bp, _bs, _bs, 3);
            }
         }

      }
   }
}
