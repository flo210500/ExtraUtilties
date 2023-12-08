package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.item.EnchantedSpeedUpgradeItem;
import inzhefop.extrautilitiesrebirth.item.SpeedUpgradeItem;
import inzhefop.extrautilitiesrebirth.item.SuperSpeedUpgradeItem;
import java.util.HashMap;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;
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

public class SlimeyGeneratorUpdateTickProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure SlimeyGeneratorUpdateTick!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure SlimeyGeneratorUpdateTick!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure SlimeyGeneratorUpdateTick!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure SlimeyGeneratorUpdateTick!");
         }

      } else {
         final IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         boolean itemvalid = false;
         double multiplier = 0.0D;
         double burntime = 0.0D;
         double energytick = 0.0D;
         double output = 0.0D;
         double GeneratorX = 0.0D;
         double energy = 0.0D;
         BlockPos _bp;
         TileEntity _tileEntity;
         BlockState _bs;
         TileEntity _ent;
         int _amount;
         if (!((<undefinedtype>)(new Object() {
            public boolean getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
            }
         })).getValue(world, new BlockPos(x, y, z), "redinv") || ((<undefinedtype>)(new Object() {
            public boolean getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
            }
         })).getValue(world, new BlockPos(x, y, z), "redinv") && world instanceof World && ((World)world).func_175640_z(new BlockPos(x, y, z))) {
            itemvalid = ((<undefinedtype>)(new Object() {
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
            })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b() == Blocks.field_180399_cE.func_199767_j() || ((<undefinedtype>)(new Object() {
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
            })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b() == Items.field_151123_aH;
            multiplier = 1.0D;
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
            })).getItemStack(new BlockPos(x, y, z), 1).func_77973_b()) {
               multiplier = (double)((<undefinedtype>)(new Object() {
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
               })).getAmount(world, new BlockPos(x, y, z), 1) * 1.05D;
            }

            if (EnchantedSpeedUpgradeItem.block == ((<undefinedtype>)(new Object() {
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
            })).getItemStack(new BlockPos(x, y, z), 1).func_77973_b()) {
               multiplier = (double)((<undefinedtype>)(new Object() {
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
               })).getAmount(world, new BlockPos(x, y, z), 1) * 1.1D;
            }

            if (SuperSpeedUpgradeItem.block == ((<undefinedtype>)(new Object() {
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
            })).getItemStack(new BlockPos(x, y, z), 1).func_77973_b()) {
               multiplier = (double)((<undefinedtype>)(new Object() {
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
               })).getAmount(world, new BlockPos(x, y, z), 1) * 1.2D;
            }

            burntime = 100.0D;
            energytick = 300.0D * multiplier;
            if (((<undefinedtype>)(new Object() {
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
            })).getEnergyStored(world, new BlockPos(x, y, z)) < ((<undefinedtype>)(new Object() {
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
            })).getMaxEnergyStored(world, new BlockPos(x, y, z)) && itemvalid && ((<undefinedtype>)(new Object() {
               public double getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
               }
            })).getValue(world, new BlockPos(x, y, z), "time") <= 0.0D) {
               if (!world.func_201670_d()) {
                  _bp = new BlockPos(x, y, z);
                  _tileEntity = world.func_175625_s(_bp);
                  _bs = world.func_180495_p(_bp);
                  if (_tileEntity != null) {
                     _tileEntity.getTileData().func_74780_a("time", burntime);
                  }

                  if (world instanceof World) {
                     ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                  }
               }

               _ent = world.func_175625_s(new BlockPos(x, y, z));
               if (_ent != null) {
                  int _sltid = false;
                  int _amount = true;
                  _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable) {
                        ItemStack _stk = capability.getStackInSlot(0).func_77946_l();
                        _stk.func_190918_g(1);
                        ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                     }

                  });
               }
            }

            if (((<undefinedtype>)(new Object() {
               public double getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
               }
            })).getValue(world, new BlockPos(x, y, z), "time") > 0.0D) {
               UpdateRGBProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("x", x), new SimpleEntry("y", y), new SimpleEntry("z", z)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
               if (!world.func_201670_d()) {
                  _bp = new BlockPos(x, y, z);
                  _tileEntity = world.func_175625_s(_bp);
                  _bs = world.func_180495_p(_bp);
                  if (_tileEntity != null) {
                     _tileEntity.getTileData().func_74780_a("time", ((<undefinedtype>)(new Object() {
                        public double getValue(IWorld world, BlockPos pos, String tag) {
                           TileEntity tileEntity = world.func_175625_s(pos);
                           return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                        }
                     })).getValue(world, new BlockPos(x, y, z), "time") - 1.0D * multiplier);
                  }

                  if (world instanceof World) {
                     ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                  }
               }

               _ent = world.func_175625_s(new BlockPos(x, y, z));
               _amount = (int)energytick;
               if (_ent != null) {
                  _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                     capability.receiveEnergy(_amount, false);
                  });
               }
            }

            if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _tileEntity = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74757_a("valid", itemvalid || ((<undefinedtype>)(new Object() {
                     public double getValue(IWorld world, BlockPos pos, String tag) {
                        TileEntity tileEntity = world.func_175625_s(pos);
                        return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                     }
                  })).getValue(world, new BlockPos(x, y, z), "time") > 0.0D);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }

            if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _tileEntity = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74780_a("progress2", ((<undefinedtype>)(new Object() {
                     public double getValue(IWorld world, BlockPos pos, String tag) {
                        TileEntity tileEntity = world.func_175625_s(pos);
                        return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                     }
                  })).getValue(world, new BlockPos(x, y, z), "time") / burntime * 22.0D);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }
         }

         if (((<undefinedtype>)(new Object() {
            public boolean canReceiveEnergy(IWorld world, BlockPos pos) {
               AtomicBoolean _retval = new AtomicBoolean(false);
               TileEntity _ent = world.func_175625_s(pos);
               if (_ent != null) {
                  _ent.getCapability(CapabilityEnergy.ENERGY, Direction.WEST).ifPresent((capability) -> {
                     _retval.set(capability.canReceive());
                  });
               }

               return _retval.get();
            }
         })).canReceiveEnergy(world, new BlockPos(x + 1.0D, y, z))) {
            energy = (double)((<undefinedtype>)(new Object() {
               public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.extractEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).extractEnergySimulate(world, new BlockPos(x, y, z), (int)output);
            energy = (double)((<undefinedtype>)(new Object() {
               public int receiveEnergySimulate(IWorld world, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityEnergy.ENERGY, Direction.WEST).ifPresent((capability) -> {
                        _retval.set(capability.receiveEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).receiveEnergySimulate(world, new BlockPos(x + 1.0D, y, z), (int)energy);
            _ent = world.func_175625_s(new BlockPos(x, y, z));
            _amount = (int)energy;
            if (_ent != null) {
               _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                  capability.extractEnergy(_amount, false);
               });
            }

            _ent = world.func_175625_s(new BlockPos(x + 1.0D, y, z));
            _amount = (int)energy;
            if (_ent != null) {
               _ent.getCapability(CapabilityEnergy.ENERGY, Direction.WEST).ifPresent((capability) -> {
                  capability.receiveEnergy(_amount, false);
               });
            }
         }

         output = 100000.0D;
         if (((<undefinedtype>)(new Object() {
            public boolean canReceiveEnergy(IWorld world, BlockPos pos) {
               AtomicBoolean _retval = new AtomicBoolean(false);
               TileEntity _ent = world.func_175625_s(pos);
               if (_ent != null) {
                  _ent.getCapability(CapabilityEnergy.ENERGY, Direction.EAST).ifPresent((capability) -> {
                     _retval.set(capability.canReceive());
                  });
               }

               return _retval.get();
            }
         })).canReceiveEnergy(world, new BlockPos(x - 1.0D, y, z))) {
            energy = (double)((<undefinedtype>)(new Object() {
               public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.extractEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).extractEnergySimulate(world, new BlockPos(x, y, z), (int)output);
            energy = (double)((<undefinedtype>)(new Object() {
               public int receiveEnergySimulate(IWorld world, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityEnergy.ENERGY, Direction.EAST).ifPresent((capability) -> {
                        _retval.set(capability.receiveEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).receiveEnergySimulate(world, new BlockPos(x - 1.0D, y, z), (int)energy);
            _ent = world.func_175625_s(new BlockPos(x, y, z));
            _amount = (int)energy;
            if (_ent != null) {
               _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                  capability.extractEnergy(_amount, false);
               });
            }

            _ent = world.func_175625_s(new BlockPos(x - 1.0D, y, z));
            _amount = (int)energy;
            if (_ent != null) {
               _ent.getCapability(CapabilityEnergy.ENERGY, Direction.EAST).ifPresent((capability) -> {
                  capability.receiveEnergy(_amount, false);
               });
            }
         }

         if (((<undefinedtype>)(new Object() {
            public boolean canReceiveEnergy(IWorld world, BlockPos pos) {
               AtomicBoolean _retval = new AtomicBoolean(false);
               TileEntity _ent = world.func_175625_s(pos);
               if (_ent != null) {
                  _ent.getCapability(CapabilityEnergy.ENERGY, Direction.NORTH).ifPresent((capability) -> {
                     _retval.set(capability.canReceive());
                  });
               }

               return _retval.get();
            }
         })).canReceiveEnergy(world, new BlockPos(x, y, z + 1.0D))) {
            energy = (double)((<undefinedtype>)(new Object() {
               public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.extractEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).extractEnergySimulate(world, new BlockPos(x, y, z), (int)output);
            energy = (double)((<undefinedtype>)(new Object() {
               public int receiveEnergySimulate(IWorld world, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityEnergy.ENERGY, Direction.NORTH).ifPresent((capability) -> {
                        _retval.set(capability.receiveEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).receiveEnergySimulate(world, new BlockPos(x, y, z + 1.0D), (int)energy);
            _ent = world.func_175625_s(new BlockPos(x, y, z));
            _amount = (int)energy;
            if (_ent != null) {
               _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                  capability.extractEnergy(_amount, false);
               });
            }

            _ent = world.func_175625_s(new BlockPos(x, y, z + 1.0D));
            _amount = (int)energy;
            if (_ent != null) {
               _ent.getCapability(CapabilityEnergy.ENERGY, Direction.NORTH).ifPresent((capability) -> {
                  capability.receiveEnergy(_amount, false);
               });
            }
         }

         if (((<undefinedtype>)(new Object() {
            public boolean canReceiveEnergy(IWorld world, BlockPos pos) {
               AtomicBoolean _retval = new AtomicBoolean(false);
               TileEntity _ent = world.func_175625_s(pos);
               if (_ent != null) {
                  _ent.getCapability(CapabilityEnergy.ENERGY, Direction.SOUTH).ifPresent((capability) -> {
                     _retval.set(capability.canReceive());
                  });
               }

               return _retval.get();
            }
         })).canReceiveEnergy(world, new BlockPos(x, y, z - 1.0D))) {
            energy = (double)((<undefinedtype>)(new Object() {
               public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.extractEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).extractEnergySimulate(world, new BlockPos(x, y, z), (int)output);
            energy = (double)((<undefinedtype>)(new Object() {
               public int receiveEnergySimulate(IWorld world, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityEnergy.ENERGY, Direction.SOUTH).ifPresent((capability) -> {
                        _retval.set(capability.receiveEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).receiveEnergySimulate(world, new BlockPos(x, y, z - 1.0D), (int)energy);
            _ent = world.func_175625_s(new BlockPos(x, y, z));
            _amount = (int)energy;
            if (_ent != null) {
               _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                  capability.extractEnergy(_amount, false);
               });
            }

            _ent = world.func_175625_s(new BlockPos(x, y, z - 1.0D));
            _amount = (int)energy;
            if (_ent != null) {
               _ent.getCapability(CapabilityEnergy.ENERGY, Direction.SOUTH).ifPresent((capability) -> {
                  capability.receiveEnergy(_amount, false);
               });
            }
         }

         if (((<undefinedtype>)(new Object() {
            public boolean canReceiveEnergy(IWorld world, BlockPos pos) {
               AtomicBoolean _retval = new AtomicBoolean(false);
               TileEntity _ent = world.func_175625_s(pos);
               if (_ent != null) {
                  _ent.getCapability(CapabilityEnergy.ENERGY, Direction.DOWN).ifPresent((capability) -> {
                     _retval.set(capability.canReceive());
                  });
               }

               return _retval.get();
            }
         })).canReceiveEnergy(world, new BlockPos(x, y + 1.0D, z))) {
            energy = (double)((<undefinedtype>)(new Object() {
               public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.extractEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).extractEnergySimulate(world, new BlockPos(x, y, z), (int)output);
            energy = (double)((<undefinedtype>)(new Object() {
               public int receiveEnergySimulate(IWorld world, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityEnergy.ENERGY, Direction.DOWN).ifPresent((capability) -> {
                        _retval.set(capability.receiveEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).receiveEnergySimulate(world, new BlockPos(x, y + 1.0D, z), (int)energy);
            _ent = world.func_175625_s(new BlockPos(x, y, z));
            _amount = (int)energy;
            if (_ent != null) {
               _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                  capability.extractEnergy(_amount, false);
               });
            }

            _ent = world.func_175625_s(new BlockPos(x, y + 1.0D, z));
            _amount = (int)energy;
            if (_ent != null) {
               _ent.getCapability(CapabilityEnergy.ENERGY, Direction.DOWN).ifPresent((capability) -> {
                  capability.receiveEnergy(_amount, false);
               });
            }
         }

         if (((<undefinedtype>)(new Object() {
            public boolean canReceiveEnergy(IWorld world, BlockPos pos) {
               AtomicBoolean _retval = new AtomicBoolean(false);
               TileEntity _ent = world.func_175625_s(pos);
               if (_ent != null) {
                  _ent.getCapability(CapabilityEnergy.ENERGY, Direction.UP).ifPresent((capability) -> {
                     _retval.set(capability.canReceive());
                  });
               }

               return _retval.get();
            }
         })).canReceiveEnergy(world, new BlockPos(x, y - 1.0D, z))) {
            energy = (double)((<undefinedtype>)(new Object() {
               public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.extractEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).extractEnergySimulate(world, new BlockPos(x, y, z), (int)output);
            energy = (double)((<undefinedtype>)(new Object() {
               public int receiveEnergySimulate(IWorld world, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityEnergy.ENERGY, Direction.UP).ifPresent((capability) -> {
                        _retval.set(capability.receiveEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).receiveEnergySimulate(world, new BlockPos(x, y - 1.0D, z), (int)energy);
            _ent = world.func_175625_s(new BlockPos(x, y, z));
            _amount = (int)energy;
            if (_ent != null) {
               _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                  capability.extractEnergy(_amount, false);
               });
            }

            _ent = world.func_175625_s(new BlockPos(x, y - 1.0D, z));
            _amount = (int)energy;
            if (_ent != null) {
               _ent.getCapability(CapabilityEnergy.ENERGY, Direction.UP).ifPresent((capability) -> {
                  capability.receiveEnergy(_amount, false);
               });
            }
         }

         if (((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "burnticks") > 0.0D) {
            if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _tileEntity = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74778_a("production", "Output: " + Math.round(output) + " Fe/t");
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }
         } else if (!world.func_201670_d()) {
            _bp = new BlockPos(x, y, z);
            _tileEntity = world.func_175625_s(_bp);
            _bs = world.func_180495_p(_bp);
            if (_tileEntity != null) {
               _tileEntity.getTileData().func_74778_a("production", "Output: 0 Fe/t");
            }

            if (world instanceof World) {
               ((World)world).func_184138_a(_bp, _bs, _bs, 3);
            }
         }

         if (!world.func_201670_d()) {
            _bp = new BlockPos(x, y, z);
            _tileEntity = world.func_175625_s(_bp);
            _bs = world.func_180495_p(_bp);
            if (_tileEntity != null) {
               _tileEntity.getTileData().func_74778_a("seconds", Math.round(((<undefinedtype>)(new Object() {
                  public double getValue(IWorld world, BlockPos pos, String tag) {
                     TileEntity tileEntity = world.func_175625_s(pos);
                     return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                  }
               })).getValue(world, new BlockPos(x, y, z), "burnticks") / 20.0D) + "s");
            }

            if (world instanceof World) {
               ((World)world).func_184138_a(_bp, _bs, _bs, 3);
            }
         }

      }
   }
}
