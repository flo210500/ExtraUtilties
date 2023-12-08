package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;

public class CreativeEnergyStorageUpdateTickProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure CreativeEnergyStorageUpdateTick!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure CreativeEnergyStorageUpdateTick!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure CreativeEnergyStorageUpdateTick!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure CreativeEnergyStorageUpdateTick!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         double output = 0.0D;
         double GeneratorX = 0.0D;
         double energy = 0.0D;
         TileEntity _ent = world.func_175625_s(new BlockPos(x, y, z));
         int _amount = Integer.MAX_VALUE;
         if (_ent != null) {
            _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
               capability.receiveEnergy(_amount, false);
            });
         }

         output = 2.147483647E9D;
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

         BlockState _bs;
         BlockPos _bp;
         TileEntity _tileEntity;
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
