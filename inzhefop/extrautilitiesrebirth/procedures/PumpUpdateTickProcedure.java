package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;

public class PumpUpdateTickProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure PumpUpdateTick!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure PumpUpdateTick!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure PumpUpdateTick!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure PumpUpdateTick!");
         }

      } else {
         final IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         boolean STOP = false;
         boolean fullblock = false;
         double multiplier = 0.0D;
         double counter1 = 0.0D;
         double yblock = 0.0D;
         double xblock = 0.0D;
         double slot = 0.0D;
         double usedpower = 0.0D;
         double repetitions = 0.0D;
         double zblock = 0.0D;
         double miningz = 0.0D;
         double miningy = 0.0D;
         double miningx = 0.0D;
         double airdistance = 0.0D;
         double energy = 0.0D;
         BlockPos _bp;
         TileEntity _ent;
         BlockState _bs;
         if (((<undefinedtype>)(new Object() {
            public int getFluidTankLevel(BlockPos pos, int tank) {
               AtomicInteger _retval = new AtomicInteger(0);
               TileEntity _ent = world.func_175625_s(pos);
               if (_ent != null) {
                  _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.getFluidInTank(tank).getAmount());
                  });
               }

               return _retval.get();
            }
         })).getFluidTankLevel(new BlockPos(x, y, z), 1) < ((<undefinedtype>)(new Object() {
            public int getFluidTankCapacity(BlockPos pos, int tank) {
               AtomicInteger _retval = new AtomicInteger(0);
               TileEntity _ent = world.func_175625_s(pos);
               if (_ent != null) {
                  _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.getTankCapacity(tank));
                  });
               }

               return _retval.get();
            }
         })).getFluidTankCapacity(new BlockPos(x, y, z), 1)) {
            if (((<undefinedtype>)(new Object() {
               public double getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
               }
            })).getValue(world, new BlockPos(x, y, z), "state") != 2.0D && ((<undefinedtype>)(new Object() {
               public double getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
               }
            })).getValue(world, new BlockPos(x, y, z), "state") != 0.0D && !world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _ent = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_ent != null) {
                  _ent.getTileData().func_74780_a("state", 1.0D);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }
         } else if (((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "state") != 2.0D && ((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "state") != 0.0D && !world.func_201670_d()) {
            _bp = new BlockPos(x, y, z);
            _ent = world.func_175625_s(_bp);
            _bs = world.func_180495_p(_bp);
            if (_ent != null) {
               _ent.getTileData().func_74780_a("state", 3.0D);
            }

            if (world instanceof World) {
               ((World)world).func_184138_a(_bp, _bs, _bs, 3);
            }
         }

         multiplier = Math.pow(2.0D, (double)Math.round(((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "eqspeed")) * 0.15D);

         for(int index0 = 0; index0 < (int)multiplier; ++index0) {
            if (((<undefinedtype>)(new Object() {
               public double getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
               }
            })).getValue(world, new BlockPos(x, y, z), "state") == 1.0D) {
               BlockState _bs;
               BlockPos _bp;
               TileEntity _tileEntity;
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
               })).getEnergyStored(world, new BlockPos(x, y, z)) >= ((<undefinedtype>)(new Object() {
                  public double getValue(IWorld world, BlockPos pos, String tag) {
                     TileEntity tileEntity = world.func_175625_s(pos);
                     return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                  }
               })).getValue(world, new BlockPos(x, y, z), "eqpowerdrain") * multiplier) {
                  _ent = world.func_175625_s(new BlockPos(x, y, z));
                  int _amount = (int)(((<undefinedtype>)(new Object() {
                     public double getValue(IWorld world, BlockPos pos, String tag) {
                        TileEntity tileEntity = world.func_175625_s(pos);
                        return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                     }
                  })).getValue(world, new BlockPos(x, y, z), "eqpowerdrain") * multiplier);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                        capability.extractEnergy(_amount, false);
                     });
                  }

                  usedpower += ((<undefinedtype>)(new Object() {
                     public double getValue(IWorld world, BlockPos pos, String tag) {
                        TileEntity tileEntity = world.func_175625_s(pos);
                        return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                     }
                  })).getValue(world, new BlockPos(x, y, z), "eqpowerdrain") * Math.pow(repetitions, 3.0D);
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
                        })).getValue(world, new BlockPos(x, y, z), "ticks") + 1.0D);
                     }

                     if (world instanceof World) {
                        ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                     }
                  }
               }

               if (((<undefinedtype>)(new Object() {
                  public double getValue(IWorld world, BlockPos pos, String tag) {
                     TileEntity tileEntity = world.func_175625_s(pos);
                     return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                  }
               })).getValue(world, new BlockPos(x, y, z), "ticks") >= 20.0D / ((<undefinedtype>)(new Object() {
                  public double getValue(IWorld world, BlockPos pos, String tag) {
                     TileEntity tileEntity = world.func_175625_s(pos);
                     return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                  }
               })).getValue(world, new BlockPos(x, y, z), "eqspeed")) {
                  multiplier = 1.0D;
                  miningx = ((<undefinedtype>)(new Object() {
                     public double getValue(IWorld world, BlockPos pos, String tag) {
                        TileEntity tileEntity = world.func_175625_s(pos);
                        return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                     }
                  })).getValue(world, new BlockPos(x, y, z), "xcoord");
                  miningy = ((<undefinedtype>)(new Object() {
                     public double getValue(IWorld world, BlockPos pos, String tag) {
                        TileEntity tileEntity = world.func_175625_s(pos);
                        return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                     }
                  })).getValue(world, new BlockPos(x, y, z), "ycoord");
                  miningz = ((<undefinedtype>)(new Object() {
                     public double getValue(IWorld world, BlockPos pos, String tag) {
                        TileEntity tileEntity = world.func_175625_s(pos);
                        return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                     }
                  })).getValue(world, new BlockPos(x, y, z), "zcoord");
                  if (!world.func_201670_d()) {
                     _bp = new BlockPos(x, y, z);
                     _tileEntity = world.func_175625_s(_bp);
                     _bs = world.func_180495_p(_bp);
                     if (_tileEntity != null) {
                        _tileEntity.getTileData().func_74780_a("minedblocks", ((<undefinedtype>)(new Object() {
                           public double getValue(IWorld world, BlockPos pos, String tag) {
                              TileEntity tileEntity = world.func_175625_s(pos);
                              return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                           }
                        })).getValue(world, new BlockPos(x, y, z), "minedblocks") + 1.0D);
                     }

                     if (world instanceof World) {
                        ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                     }
                  }

                  if (Blocks.field_150350_a != world.func_204610_c(new BlockPos(miningx, miningy, miningz)).func_206883_i().func_177230_c()) {
                     short _amount;
                     if (Blocks.field_150355_j == world.func_204610_c(new BlockPos(miningx, miningy, miningz)).func_206883_i().func_177230_c() && !((<undefinedtype>)(new Object() {
                        public boolean getValue(IWorld world, BlockPos pos, String tag) {
                           TileEntity tileEntity = world.func_175625_s(pos);
                           return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
                        }
                     })).getValue(world, new BlockPos(x, y, z), "lava")) {
                        if (!world.func_201670_d()) {
                           _bp = new BlockPos(x, y, z);
                           _tileEntity = world.func_175625_s(_bp);
                           _bs = world.func_180495_p(_bp);
                           if (_tileEntity != null) {
                              _tileEntity.getTileData().func_74757_a("water", true);
                           }

                           if (world instanceof World) {
                              ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                           }
                        }

                        _ent = world.func_175625_s(new BlockPos(x, y, z));
                        _amount = 1000;
                        if (_ent != null) {
                           _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                              capability.fill(new FluidStack(Fluids.field_204546_a, _amount), FluidAction.EXECUTE);
                           });
                        }

                        if (((<undefinedtype>)(new Object() {
                           public boolean getValue(IWorld world, BlockPos pos, String tag) {
                              TileEntity tileEntity = world.func_175625_s(pos);
                              return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
                           }
                        })).getValue(world, new BlockPos(x, y, z), "eqhole")) {
                           world.func_180501_a(new BlockPos(miningx, miningy, miningz), Blocks.field_150350_a.func_176223_P(), 3);
                        } else {
                           world.func_180501_a(new BlockPos(miningx, miningy, miningz), Blocks.field_150348_b.func_176223_P(), 3);
                        }
                     }

                     if (Blocks.field_150353_l == world.func_204610_c(new BlockPos(miningx, miningy, miningz)).func_206883_i().func_177230_c() && !((<undefinedtype>)(new Object() {
                        public boolean getValue(IWorld world, BlockPos pos, String tag) {
                           TileEntity tileEntity = world.func_175625_s(pos);
                           return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
                        }
                     })).getValue(world, new BlockPos(x, y, z), "water")) {
                        if (!world.func_201670_d()) {
                           _bp = new BlockPos(x, y, z);
                           _tileEntity = world.func_175625_s(_bp);
                           _bs = world.func_180495_p(_bp);
                           if (_tileEntity != null) {
                              _tileEntity.getTileData().func_74757_a("lava", true);
                           }

                           if (world instanceof World) {
                              ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                           }
                        }

                        _ent = world.func_175625_s(new BlockPos(x, y, z));
                        _amount = 1000;
                        if (_ent != null) {
                           _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                              capability.fill(new FluidStack(Fluids.field_204547_b, _amount), FluidAction.EXECUTE);
                           });
                        }

                        if (((<undefinedtype>)(new Object() {
                           public boolean getValue(IWorld world, BlockPos pos, String tag) {
                              TileEntity tileEntity = world.func_175625_s(pos);
                              return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
                           }
                        })).getValue(world, new BlockPos(x, y, z), "eqsilk")) {
                           world.func_180501_a(new BlockPos(miningx, miningy, miningz), Blocks.field_150350_a.func_176223_P(), 3);
                        } else {
                           world.func_180501_a(new BlockPos(miningx, miningy, miningz), Blocks.field_150348_b.func_176223_P(), 3);
                        }
                     }
                  }

                  if (miningy >= 0.0D) {
                     --miningy;
                  } else {
                     miningy = ((<undefinedtype>)(new Object() {
                        public double getValue(IWorld world, BlockPos pos, String tag) {
                           TileEntity tileEntity = world.func_175625_s(pos);
                           return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                        }
                     })).getValue(world, new BlockPos(x, y, z), "areamaxy");
                     if (((<undefinedtype>)(new Object() {
                        public double getValue(IWorld world, BlockPos pos, String tag) {
                           TileEntity tileEntity = world.func_175625_s(pos);
                           return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                        }
                     })).getValue(world, new BlockPos(x, y, z), "areadirect1") == 1.0D) {
                        if (miningz > ((<undefinedtype>)(new Object() {
                           public double getValue(IWorld world, BlockPos pos, String tag) {
                              TileEntity tileEntity = world.func_175625_s(pos);
                              return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                           }
                        })).getValue(world, new BlockPos(x, y, z), "areamaxz")) {
                           --miningz;
                        } else {
                           miningz = ((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(x, y, z), "areaminz");
                           if (((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(x, y, z), "areadirect2") == 2.0D) {
                              if (miningx < ((<undefinedtype>)(new Object() {
                                 public double getValue(IWorld world, BlockPos pos, String tag) {
                                    TileEntity tileEntity = world.func_175625_s(pos);
                                    return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                                 }
                              })).getValue(world, new BlockPos(x, y, z), "areamaxx")) {
                                 ++miningx;
                              } else if (!world.func_201670_d()) {
                                 _bp = new BlockPos(x, y, z);
                                 _tileEntity = world.func_175625_s(_bp);
                                 _bs = world.func_180495_p(_bp);
                                 if (_tileEntity != null) {
                                    _tileEntity.getTileData().func_74780_a("state", 2.0D);
                                 }

                                 if (world instanceof World) {
                                    ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                                 }
                              }
                           }

                           if (((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(x, y, z), "areadirect2") == 4.0D) {
                              if (miningx > ((<undefinedtype>)(new Object() {
                                 public double getValue(IWorld world, BlockPos pos, String tag) {
                                    TileEntity tileEntity = world.func_175625_s(pos);
                                    return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                                 }
                              })).getValue(world, new BlockPos(x, y, z), "areamaxx")) {
                                 --miningx;
                              } else if (!world.func_201670_d()) {
                                 _bp = new BlockPos(x, y, z);
                                 _tileEntity = world.func_175625_s(_bp);
                                 _bs = world.func_180495_p(_bp);
                                 if (_tileEntity != null) {
                                    _tileEntity.getTileData().func_74780_a("state", 2.0D);
                                 }

                                 if (world instanceof World) {
                                    ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                                 }
                              }
                           }
                        }
                     }

                     if (((<undefinedtype>)(new Object() {
                        public double getValue(IWorld world, BlockPos pos, String tag) {
                           TileEntity tileEntity = world.func_175625_s(pos);
                           return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                        }
                     })).getValue(world, new BlockPos(x, y, z), "areadirect1") == 3.0D) {
                        if (miningz < ((<undefinedtype>)(new Object() {
                           public double getValue(IWorld world, BlockPos pos, String tag) {
                              TileEntity tileEntity = world.func_175625_s(pos);
                              return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                           }
                        })).getValue(world, new BlockPos(x, y, z), "areamaxz")) {
                           ++miningz;
                        } else {
                           miningz = ((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(x, y, z), "areaminz");
                           if (((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(x, y, z), "areadirect2") == 2.0D) {
                              if (miningx < ((<undefinedtype>)(new Object() {
                                 public double getValue(IWorld world, BlockPos pos, String tag) {
                                    TileEntity tileEntity = world.func_175625_s(pos);
                                    return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                                 }
                              })).getValue(world, new BlockPos(x, y, z), "areamaxx")) {
                                 ++miningx;
                              } else if (!world.func_201670_d()) {
                                 _bp = new BlockPos(x, y, z);
                                 _tileEntity = world.func_175625_s(_bp);
                                 _bs = world.func_180495_p(_bp);
                                 if (_tileEntity != null) {
                                    _tileEntity.getTileData().func_74780_a("state", 2.0D);
                                 }

                                 if (world instanceof World) {
                                    ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                                 }
                              }
                           }

                           if (((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(x, y, z), "areadirect2") == 4.0D) {
                              if (miningx > ((<undefinedtype>)(new Object() {
                                 public double getValue(IWorld world, BlockPos pos, String tag) {
                                    TileEntity tileEntity = world.func_175625_s(pos);
                                    return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                                 }
                              })).getValue(world, new BlockPos(x, y, z), "areamaxx")) {
                                 --miningx;
                              } else if (!world.func_201670_d()) {
                                 _bp = new BlockPos(x, y, z);
                                 _tileEntity = world.func_175625_s(_bp);
                                 _bs = world.func_180495_p(_bp);
                                 if (_tileEntity != null) {
                                    _tileEntity.getTileData().func_74780_a("state", 2.0D);
                                 }

                                 if (world instanceof World) {
                                    ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                                 }
                              }
                           }
                        }
                     }
                  }

                  if (!world.func_201670_d()) {
                     _bp = new BlockPos(x, y, z);
                     _tileEntity = world.func_175625_s(_bp);
                     _bs = world.func_180495_p(_bp);
                     if (_tileEntity != null) {
                        _tileEntity.getTileData().func_74780_a("xcoord", miningx);
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
                        _tileEntity.getTileData().func_74780_a("ycoord", miningy);
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
                        _tileEntity.getTileData().func_74780_a("zcoord", miningz);
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
                        _tileEntity.getTileData().func_74780_a("ticks", 0.0D);
                     }

                     if (world instanceof World) {
                        ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                     }
                  }
               }
            }
         }

         TileEntity _ent;
         int _amount;
         if (((<undefinedtype>)(new Object() {
            public boolean getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
            }
         })).getValue(world, new BlockPos(x, y, z), "water")) {
            energy = (double)((<undefinedtype>)(new Object() {
               public int drainTankSimulate(IWorld world, BlockPos pos, int amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.DOWN).ifPresent((capability) -> {
                        _retval.set(capability.drain(amount, FluidAction.SIMULATE).getAmount());
                     });
                  }

                  return _retval.get();
               }
            })).drainTankSimulate(world, new BlockPos(x, y, z), 100000);
            energy = (double)((<undefinedtype>)(new Object() {
               public int fillTankSimulate(IWorld world, BlockPos pos, int amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.fill(new FluidStack(Fluids.field_204546_a, amount), FluidAction.SIMULATE));
                     });
                  }

                  return _retval.get();
               }
            })).fillTankSimulate(world, new BlockPos(x, y + 1.0D, z), (int)energy);
            _ent = world.func_175625_s(new BlockPos(x, y, z));
            _amount = (int)energy;
            if (_ent != null) {
               _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.drain(_amount, FluidAction.EXECUTE);
               });
            }

            _ent = world.func_175625_s(new BlockPos(x, y + 1.0D, z));
            _amount = (int)energy;
            if (_ent != null) {
               _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.DOWN).ifPresent((capability) -> {
                  capability.fill(new FluidStack(Fluids.field_204546_a, _amount), FluidAction.EXECUTE);
               });
            }
         }

         if (((<undefinedtype>)(new Object() {
            public boolean getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
            }
         })).getValue(world, new BlockPos(x, y, z), "lava")) {
            energy = (double)((<undefinedtype>)(new Object() {
               public int drainTankSimulate(IWorld world, BlockPos pos, int amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.DOWN).ifPresent((capability) -> {
                        _retval.set(capability.drain(amount, FluidAction.SIMULATE).getAmount());
                     });
                  }

                  return _retval.get();
               }
            })).drainTankSimulate(world, new BlockPos(x, y, z), 100000);
            energy = (double)((<undefinedtype>)(new Object() {
               public int fillTankSimulate(IWorld world, BlockPos pos, int amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  TileEntity _ent = world.func_175625_s(pos);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.fill(new FluidStack(Fluids.field_204547_b, amount), FluidAction.SIMULATE));
                     });
                  }

                  return _retval.get();
               }
            })).fillTankSimulate(world, new BlockPos(x, y + 1.0D, z), (int)energy);
            _ent = world.func_175625_s(new BlockPos(x, y, z));
            _amount = (int)energy;
            if (_ent != null) {
               _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.drain(_amount, FluidAction.EXECUTE);
               });
            }

            _ent = world.func_175625_s(new BlockPos(x, y + 1.0D, z));
            _amount = (int)energy;
            if (_ent != null) {
               _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.DOWN).ifPresent((capability) -> {
                  capability.fill(new FluidStack(Fluids.field_204547_b, _amount), FluidAction.EXECUTE);
               });
            }
         }

      }
   }
}
