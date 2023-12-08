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

public class RainbowGeneratorUpdateTickProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure RainbowGeneratorUpdateTick!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure RainbowGeneratorUpdateTick!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure RainbowGeneratorUpdateTick!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure RainbowGeneratorUpdateTick!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         String generatorstring = "";
         double repeats = 0.0D;
         double running_generators = 0.0D;
         double output = 0.0D;
         double GeneratorX = 0.0D;
         double energy = 0.0D;

         for(int index0 = 0; index0 < 16; ++index0) {
            if (repeats == 0.0D) {
               generatorstring = "culinary";
            } else if (repeats == 1.0D) {
               generatorstring = "death";
            } else if (repeats == 2.0D) {
               generatorstring = "disenchantment";
            } else if (repeats == 3.0D) {
               generatorstring = "ender";
            } else if (repeats == 4.0D) {
               generatorstring = "tnt";
            } else if (repeats == 5.0D) {
               generatorstring = "frosty";
            } else if (repeats == 6.0D) {
               generatorstring = "furnace";
            } else if (repeats == 7.0D) {
               generatorstring = "halitosis";
            } else if (repeats == 8.0D) {
               generatorstring = "neatherstar";
            } else if (repeats == 9.0D) {
               generatorstring = "overclocked";
            } else if (repeats == 10.0D) {
               generatorstring = "pink";
            } else if (repeats == 11.0D) {
               generatorstring = "potion";
            } else if (repeats == 12.0D) {
               generatorstring = "slimey";
            } else if (repeats == 13.0D) {
               generatorstring = "survival";
            } else if (repeats == 14.0D) {
               generatorstring = "redstone";
            } else if (repeats == 15.0D) {
               generatorstring = "magma";
            }

            BlockPos _bp;
            TileEntity _tileEntity;
            BlockState _bs;
            if (((<undefinedtype>)(new Object() {
               public double getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
               }
            })).getValue(world, new BlockPos(x, y, z), generatorstring) >= 1.0D) {
               ++running_generators;
               if (!world.func_201670_d()) {
                  _bp = new BlockPos(x, y, z);
                  _tileEntity = world.func_175625_s(_bp);
                  _bs = world.func_180495_p(_bp);
                  if (_tileEntity != null) {
                     _tileEntity.getTileData().func_74757_a(generatorstring + "_machine", true);
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
               })).getValue(world, new BlockPos(x, y, z), generatorstring) >= 1.0D && !world.func_201670_d()) {
                  _bp = new BlockPos(x, y, z);
                  _tileEntity = world.func_175625_s(_bp);
                  _bs = world.func_180495_p(_bp);
                  if (_tileEntity != null) {
                     _tileEntity.getTileData().func_74780_a(generatorstring, 0.0D);
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
                  _tileEntity.getTileData().func_74757_a(generatorstring + "_machine", false);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }

            ++repeats;
         }

         BlockPos _bp;
         TileEntity _tileEntity;
         BlockState _bs;
         if (running_generators >= 16.0D) {
            output = 2.5E7D;
            if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _tileEntity = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74757_a("rgb_running", true);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }

            TileEntity _ent = world.func_175625_s(new BlockPos(x, y, z));
            int _amount = (int)output;
            if (_ent != null) {
               _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                  capability.receiveEnergy(_amount, false);
               });
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
         } else if (!world.func_201670_d()) {
            _bp = new BlockPos(x, y, z);
            _tileEntity = world.func_175625_s(_bp);
            _bs = world.func_180495_p(_bp);
            if (_tileEntity != null) {
               _tileEntity.getTileData().func_74757_a("rgb_running", false);
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
               _tileEntity.getTileData().func_74778_a("running_gen", Math.round(running_generators) + "");
            }

            if (world instanceof World) {
               ((World)world).func_184138_a(_bp, _bs, _bs, 3);
            }
         }

      }
   }
}
