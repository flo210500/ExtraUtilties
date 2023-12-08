package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.ItemTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class EnderQuarryUpdateTickProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure EnderQuarryUpdateTick!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure EnderQuarryUpdateTick!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure EnderQuarryUpdateTick!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure EnderQuarryUpdateTick!");
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
         multiplier = Math.pow(2.0D, (double)Math.round(((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "eqspeed")) * 0.15D);

         for(int index0 = 0; index0 < (int)multiplier; ++index0) {
            int index2;
            if (((<undefinedtype>)(new Object() {
               public double getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
               }
            })).getValue(world, new BlockPos(x, y, z), "state") == 1.0D) {
               TileEntity _ent;
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
                  index2 = (int)(((<undefinedtype>)(new Object() {
                     public double getValue(IWorld world, BlockPos pos, String tag) {
                        TileEntity tileEntity = world.func_175625_s(pos);
                        return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                     }
                  })).getValue(world, new BlockPos(x, y, z), "eqpowerdrain") * multiplier);
                  if (_ent != null) {
                     _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                        capability.extractEnergy(index2, false);
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

                  if (!((<undefinedtype>)(new Object() {
                     public boolean getValue(IWorld world, BlockPos pos, String tag) {
                        TileEntity tileEntity = world.func_175625_s(pos);
                        return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
                     }
                  })).getValue(world, new BlockPos(x, y, z), "eqsilk")) {
                     if (Blocks.field_150357_h.func_199767_j() != (new ItemStack(world.func_180495_p(new BlockPos(miningx, miningy, miningz)).func_177230_c())).func_77973_b()) {
                        if (Blocks.field_150350_a.func_199767_j() != (new ItemStack(world.func_180495_p(new BlockPos(miningx, miningy, miningz)).func_177230_c())).func_77973_b()) {
                           fullblock = true;
                        }

                        if (world instanceof World) {
                           Block.func_220075_c(world.func_180495_p(new BlockPos(miningx, miningy, miningz)), (World)world, new BlockPos(miningx, miningy, miningz));
                           world.func_175655_b(new BlockPos(miningx, miningy, miningz), false);
                        }

                        List<Entity> _entfound = (List)world.func_175647_a(Entity.class, new AxisAlignedBB(miningx - 4.0D, miningy - 4.0D, miningz - 4.0D, miningx + 4.0D, miningy + 4.0D, miningz + 4.0D), (Predicate)null).stream().sorted(((<undefinedtype>)(new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparing((_entcnd) -> {
                                 return _entcnd.func_70092_e(_x, _y, _z);
                              });
                           }
                        })).compareDistOf(miningx, miningy, miningz)).collect(Collectors.toList());
                        Iterator var42 = _entfound.iterator();

                        while(var42.hasNext()) {
                           Entity entityiterator = (Entity)var42.next();
                           if (Blocks.field_150350_a.func_199767_j() != ((<undefinedtype>)(new Object() {
                              public ItemStack entityToItem(Entity _ent) {
                                 return _ent instanceof ItemEntity ? ((ItemEntity)_ent).func_92059_d() : ItemStack.field_190927_a;
                              }
                           })).entityToItem(entityiterator).func_77973_b() && Blocks.field_150357_h.func_199767_j() != ((<undefinedtype>)(new Object() {
                              public ItemStack entityToItem(Entity _ent) {
                                 return _ent instanceof ItemEntity ? ((ItemEntity)_ent).func_92059_d() : ItemStack.field_190927_a;
                              }
                           })).entityToItem(entityiterator).func_77973_b()) {
                              if (ItemTags.func_199903_a().func_241834_b(new ResourceLocation("forge:ores")).func_230235_a_((new ItemStack(world.func_180495_p(new BlockPos(miningx, miningy, miningz)).func_177230_c())).func_77973_b()) && (new ItemStack(world.func_180495_p(new BlockPos(miningx, miningy, miningz)).func_177230_c())).func_77973_b() != ((<undefinedtype>)(new Object() {
                                 public ItemStack entityToItem(Entity _ent) {
                                    return _ent instanceof ItemEntity ? ((ItemEntity)_ent).func_92059_d() : ItemStack.field_190927_a;
                                 }
                              })).entityToItem(entityiterator).func_77973_b()) {
                                 multiplier = ((<undefinedtype>)(new Object() {
                                    public double getValue(IWorld world, BlockPos pos, String tag) {
                                       TileEntity tileEntity = world.func_175625_s(pos);
                                       return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                                    }
                                 })).getValue(world, new BlockPos(x, y, z), "eqfortune");
                              }

                              TileEntity _ent = world.func_175625_s(new BlockPos(x, y, z));
                              if (_ent != null) {
                                 int _sltid = false;
                                 ItemStack _setstack = ((<undefinedtype>)(new Object() {
                                    public ItemStack entityToItem(Entity _ent) {
                                       return _ent instanceof ItemEntity ? ((ItemEntity)_ent).func_92059_d() : ItemStack.field_190927_a;
                                    }
                                 })).entityToItem(entityiterator);
                                 _setstack.func_190920_e((int)((double)((<undefinedtype>)(new Object() {
                                    public ItemStack entityToItem(Entity _ent) {
                                       return _ent instanceof ItemEntity ? ((ItemEntity)_ent).func_92059_d() : ItemStack.field_190927_a;
                                    }
                                 })).entityToItem(entityiterator).func_190916_E() * multiplier));
                                 _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                    if (capability instanceof IItemHandlerModifiable) {
                                       ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                                    }

                                 });
                              }

                              if (!entityiterator.field_70170_p.func_201670_d()) {
                                 entityiterator.func_70106_y();
                              }
                           }
                        }
                     }
                  } else if (Blocks.field_150350_a.func_199767_j() != (new ItemStack(world.func_180495_p(new BlockPos(miningx, miningy, miningz)).func_177230_c())).func_77973_b() && Blocks.field_150357_h.func_199767_j() != (new ItemStack(world.func_180495_p(new BlockPos(miningx, miningy, miningz)).func_177230_c())).func_77973_b()) {
                     fullblock = true;
                     _ent = world.func_175625_s(new BlockPos(x, y, z));
                     if (_ent != null) {
                        int _sltid = false;
                        ItemStack _setstack = new ItemStack(world.func_180495_p(new BlockPos(miningx, miningy, miningz)).func_177230_c());
                        _setstack.func_190920_e((int)((double)(new ItemStack(world.func_180495_p(new BlockPos(miningx, miningy, miningz)).func_177230_c())).func_190916_E() * multiplier));
                        _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           if (capability instanceof IItemHandlerModifiable) {
                              ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                           }

                        });
                     }

                     world.func_180501_a(new BlockPos(miningx, miningy, miningz), Blocks.field_150350_a.func_176223_P(), 3);
                  }

                  if (world instanceof ServerWorld) {
                     ((ServerWorld)world).func_195598_a(ParticleTypes.field_197599_J, miningx + 0.5D, miningy + 0.5D, miningz + 0.5D, 5, 0.3D, 0.3D, 0.3D, 0.0D);
                  }

                  if (!((<undefinedtype>)(new Object() {
                     public boolean getValue(IWorld world, BlockPos pos, String tag) {
                        TileEntity tileEntity = world.func_175625_s(pos);
                        return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
                     }
                  })).getValue(world, new BlockPos(x, y, z), "eqhole") && fullblock) {
                     world.func_180501_a(new BlockPos(miningx, miningy, miningz), Blocks.field_150346_d.func_176223_P(), 3);
                  }

                  if (miningy >= 6.0D) {
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

            if (((<undefinedtype>)(new Object() {
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
            })).getAmount(world, new BlockPos(x, y, z), 0) > 0) {
               for(int index1 = 0; index1 < 6; ++index1) {
                  if (counter1 == 0.0D) {
                     xblock = x;
                     yblock = y + 1.0D;
                     zblock = z;
                  }

                  if (counter1 == 1.0D) {
                     xblock = x;
                     yblock = y - 1.0D;
                     zblock = z;
                  }

                  if (counter1 == 2.0D) {
                     xblock = x + 1.0D;
                     yblock = y;
                     zblock = z;
                  }

                  if (counter1 == 3.0D) {
                     xblock = x - 1.0D;
                     yblock = y;
                     zblock = z;
                  }

                  if (counter1 == 4.0D) {
                     xblock = x;
                     yblock = y;
                     zblock = z + 1.0D;
                  }

                  if (counter1 == 5.0D) {
                     xblock = x;
                     yblock = y;
                     zblock = z - 1.0D;
                  }

                  BlockState _bs;
                  BlockPos _bp;
                  TileEntity _ent;
                  if (((<undefinedtype>)(new Object() {
                     public boolean get_coinsidencia(ItemStack item_value, int x_value, int y_value, int z_value) {
                        int cont_value_ = 0;
                        boolean get_encr = false;

                        for(int index0 = 0; index0 < (int)((<undefinedtype>)(new Object() {
                           public double getValue(IWorld worldx, BlockPos pos) {
                              TileEntity tileEntity = worldx.func_175625_s(pos);
                              double slots = 0.0D;
                              if (tileEntity instanceof IInventory) {
                                 slots = (double)((IInventory)tileEntity).func_70302_i_();
                              }

                              return slots;
                           }
                        })).getValue(world, new BlockPos(x_value, y_value, z_value)); ++index0) {
                           if (item_value.func_77973_b() == ((<undefinedtype>)(new Object() {
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
                           })).getItemStack(new BlockPos(x_value, y_value, z_value), cont_value_).func_77973_b() && !get_encr) {
                              get_encr = true;
                           }

                           ++cont_value_;
                        }

                        return get_encr;
                     }
                  })).get_coinsidencia(new ItemStack(Blocks.field_150350_a), (int)xblock, (int)yblock, (int)zblock) || ((<undefinedtype>)(new Object() {
                     public boolean get_coinsidencia(ItemStack item_value, int x_value, int y_value, int z_value) {
                        int cont_value_ = 0;
                        boolean get_encr = false;

                        for(int index0 = 0; index0 < (int)((<undefinedtype>)(new Object() {
                           public double getValue(IWorld worldx, BlockPos pos) {
                              TileEntity tileEntity = worldx.func_175625_s(pos);
                              double slots = 0.0D;
                              if (tileEntity instanceof IInventory) {
                                 slots = (double)((IInventory)tileEntity).func_70302_i_();
                              }

                              return slots;
                           }
                        })).getValue(world, new BlockPos(x_value, y_value, z_value)); ++index0) {
                           if (item_value.func_77973_b() == ((<undefinedtype>)(new Object() {
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
                           })).getItemStack(new BlockPos(x_value, y_value, z_value), cont_value_).func_77973_b() && !get_encr) {
                              get_encr = true;
                           }

                           ++cont_value_;
                        }

                        return get_encr;
                     }
                  })).get_coinsidencia(((<undefinedtype>)(new Object() {
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
                  })).getItemStack(new BlockPos(x, y, z), 0), (int)xblock, (int)yblock, (int)zblock)) {
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

                     for(index2 = 0; index2 < (int)((<undefinedtype>)(new Object() {
                        public double getValue(IWorld world, BlockPos pos) {
                           TileEntity tileEntity = world.func_175625_s(pos);
                           double slots = 0.0D;
                           if (tileEntity instanceof IInventory) {
                              slots = (double)((IInventory)tileEntity).func_70302_i_();
                           }

                           return slots;
                        }
                     })).getValue(world, new BlockPos((int)xblock, (int)yblock, (int)zblock)); ++index2) {
                        if (((<undefinedtype>)(new Object() {
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
                        })).getAmount(world, new BlockPos(xblock, yblock, zblock), (int)slot) <= 64 - ((<undefinedtype>)(new Object() {
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
                        })).getItemStack(new BlockPos(x, y, z), 0).func_190916_E() && (((<undefinedtype>)(new Object() {
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
                        })).getAmount(world, new BlockPos(xblock, yblock, zblock), (int)slot) == 0 || ((<undefinedtype>)(new Object() {
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
                        })).getItemStack(new BlockPos(xblock, yblock, zblock), (int)slot).func_77973_b() == ((<undefinedtype>)(new Object() {
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
                        })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b())) {
                           _ent = world.func_175625_s(new BlockPos(xblock, yblock, zblock));
                           ItemStack _setstack;
                           if (_ent != null) {
                              int _sltid = (int)slot;
                              _setstack = ((<undefinedtype>)(new Object() {
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
                              _setstack.func_190920_e(((<undefinedtype>)(new Object() {
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
                              })).getItemStack(new BlockPos(xblock, yblock, zblock), (int)slot).func_190916_E() + ((<undefinedtype>)(new Object() {
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
                              })).getItemStack(new BlockPos(x, y, z), 0).func_190916_E());
                              _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                 if (capability instanceof IItemHandlerModifiable) {
                                    ((IItemHandlerModifiable)capability).setStackInSlot(_sltid, _setstack);
                                 }

                              });
                           }

                           _ent = world.func_175625_s(new BlockPos(x, y, z));
                           if (_ent != null) {
                              int _sltid = false;
                              _setstack = new ItemStack(Blocks.field_150350_a);
                              _setstack.func_190920_e(1);
                              _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                 if (capability instanceof IItemHandlerModifiable) {
                                    ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                                 }

                              });
                           }

                           STOP = true;
                           break;
                        }

                        ++slot;
                     }

                     slot = 0.0D;
                  }

                  if (STOP) {
                     break;
                  }

                  ++counter1;
                  if (counter1 == 6.0D && !world.func_201670_d()) {
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
               }
            }
         }

      }
   }
}
