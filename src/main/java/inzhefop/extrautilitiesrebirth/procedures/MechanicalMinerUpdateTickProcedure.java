package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.EnderLillyStage1Block;
import inzhefop.extrautilitiesrebirth.block.EnderLillyStage8Block;
import inzhefop.extrautilitiesrebirth.item.EnchantedSpeedUpgradeItem;
import inzhefop.extrautilitiesrebirth.item.SpeedUpgradeItem;
import inzhefop.extrautilitiesrebirth.item.SuperSpeedUpgradeItem;
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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.tags.ItemTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.Direction.AxisDirection;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class MechanicalMinerUpdateTickProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure MechanicalMinerUpdateTick!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure MechanicalMinerUpdateTick!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure MechanicalMinerUpdateTick!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure MechanicalMinerUpdateTick!");
         }

      } else {
         final IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         BlockState targetblock = Blocks.field_150350_a.func_176223_P();
         ItemStack storeditem = ItemStack.field_190927_a;
         double target_x = 0.0D;
         double target_y = 0.0D;
         double target_z = 0.0D;
         double slotnumber = 0.0D;
         double multiplier = 0.0D;
         boolean freeslot = false;
         multiplier = 1.0D;
         if (((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 9).func_77973_b() == SpeedUpgradeItem.block) {
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
            })).getAmount(world, new BlockPos(x, y, z), 9) * 0.4D;
         }

         if (((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 9).func_77973_b() == EnchantedSpeedUpgradeItem.block) {
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
            })).getAmount(world, new BlockPos(x, y, z), 9) * 0.5D;
         }

         if (((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 9).func_77973_b() == SuperSpeedUpgradeItem.block) {
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
            })).getAmount(world, new BlockPos(x, y, z), 9) * 0.6D;
         }

         if (Direction.DOWN == ((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockPos pos) {
               try {
                  BlockState _bs = world.func_180495_p(pos);
                  DirectionProperty property = (DirectionProperty)_bs.func_177230_c().func_176194_O().func_185920_a("facing");
                  return property != null ? (Direction)_bs.func_177229_b(property) : Direction.func_211699_a((Axis)_bs.func_177229_b((EnumProperty)_bs.func_177230_c().func_176194_O().func_185920_a("axis")), AxisDirection.POSITIVE);
               } catch (Exception var4) {
                  return Direction.NORTH;
               }
            }
         })).getDirection(new BlockPos(x, y, z))) {
            targetblock = world.func_180495_p(new BlockPos(x, y - 1.0D, z));
            target_x = x;
            target_y = y - 1.0D;
            target_z = z;
         } else if (Direction.UP == ((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockPos pos) {
               try {
                  BlockState _bs = world.func_180495_p(pos);
                  DirectionProperty property = (DirectionProperty)_bs.func_177230_c().func_176194_O().func_185920_a("facing");
                  return property != null ? (Direction)_bs.func_177229_b(property) : Direction.func_211699_a((Axis)_bs.func_177229_b((EnumProperty)_bs.func_177230_c().func_176194_O().func_185920_a("axis")), AxisDirection.POSITIVE);
               } catch (Exception var4) {
                  return Direction.NORTH;
               }
            }
         })).getDirection(new BlockPos(x, y, z))) {
            targetblock = world.func_180495_p(new BlockPos(x, y + 1.0D, z));
            target_x = x;
            target_y = y + 1.0D;
            target_z = z;
         } else if (Direction.NORTH == ((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockPos pos) {
               try {
                  BlockState _bs = world.func_180495_p(pos);
                  DirectionProperty property = (DirectionProperty)_bs.func_177230_c().func_176194_O().func_185920_a("facing");
                  return property != null ? (Direction)_bs.func_177229_b(property) : Direction.func_211699_a((Axis)_bs.func_177229_b((EnumProperty)_bs.func_177230_c().func_176194_O().func_185920_a("axis")), AxisDirection.POSITIVE);
               } catch (Exception var4) {
                  return Direction.NORTH;
               }
            }
         })).getDirection(new BlockPos(x, y, z))) {
            targetblock = world.func_180495_p(new BlockPos(x, y, z - 1.0D));
            target_x = x;
            target_y = y;
            target_z = z - 1.0D;
         } else if (Direction.WEST == ((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockPos pos) {
               try {
                  BlockState _bs = world.func_180495_p(pos);
                  DirectionProperty property = (DirectionProperty)_bs.func_177230_c().func_176194_O().func_185920_a("facing");
                  return property != null ? (Direction)_bs.func_177229_b(property) : Direction.func_211699_a((Axis)_bs.func_177229_b((EnumProperty)_bs.func_177230_c().func_176194_O().func_185920_a("axis")), AxisDirection.POSITIVE);
               } catch (Exception var4) {
                  return Direction.NORTH;
               }
            }
         })).getDirection(new BlockPos(x, y, z))) {
            targetblock = world.func_180495_p(new BlockPos(x - 1.0D, y, z));
            target_x = x - 1.0D;
            target_y = y;
            target_z = z;
         } else if (Direction.EAST == ((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockPos pos) {
               try {
                  BlockState _bs = world.func_180495_p(pos);
                  DirectionProperty property = (DirectionProperty)_bs.func_177230_c().func_176194_O().func_185920_a("facing");
                  return property != null ? (Direction)_bs.func_177229_b(property) : Direction.func_211699_a((Axis)_bs.func_177229_b((EnumProperty)_bs.func_177230_c().func_176194_O().func_185920_a("axis")), AxisDirection.POSITIVE);
               } catch (Exception var4) {
                  return Direction.NORTH;
               }
            }
         })).getDirection(new BlockPos(x, y, z))) {
            targetblock = world.func_180495_p(new BlockPos(x + 1.0D, y, z));
            target_x = x + 1.0D;
            target_y = y;
            target_z = z;
         } else if (Direction.SOUTH == ((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockPos pos) {
               try {
                  BlockState _bs = world.func_180495_p(pos);
                  DirectionProperty property = (DirectionProperty)_bs.func_177230_c().func_176194_O().func_185920_a("facing");
                  return property != null ? (Direction)_bs.func_177229_b(property) : Direction.func_211699_a((Axis)_bs.func_177229_b((EnumProperty)_bs.func_177230_c().func_176194_O().func_185920_a("axis")), AxisDirection.POSITIVE);
               } catch (Exception var4) {
                  return Direction.NORTH;
               }
            }
         })).getDirection(new BlockPos(x, y, z))) {
            targetblock = world.func_180495_p(new BlockPos(x, y, z + 1.0D));
            target_x = x;
            target_y = y;
            target_z = z + 1.0D;
         }

         if (targetblock.func_177230_c() != Blocks.field_150350_a && targetblock.func_177230_c() != Blocks.field_150357_h && !ItemTags.func_199903_a().func_241834_b(new ResourceLocation("forge:ungrown_ender_lilly_states")).func_230235_a_((new ItemStack(targetblock.func_177230_c())).func_77973_b()) && targetblock.func_177230_c() != Blocks.field_150378_br) {
            BlockPos _bp;
            TileEntity _ent;
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
            })).getEnergyStored(world, new BlockPos(x, y, z)) > Math.pow(4.0D * multiplier, 2.0D)) {
               if (!world.func_201670_d()) {
                  _bp = new BlockPos(x, y, z);
                  _ent = world.func_175625_s(_bp);
                  _bs = world.func_180495_p(_bp);
                  if (_ent != null) {
                     _ent.getTileData().func_74780_a("ticks", ((<undefinedtype>)(new Object() {
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

               TileEntity _ent = world.func_175625_s(new BlockPos(x, y, z));
               int _amount = (int)Math.pow(4.0D * multiplier, 2.0D);
               if (_ent != null) {
                  _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                     capability.extractEnergy(_amount, false);
                  });
               }
            } else if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _ent = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_ent != null) {
                  _ent.getTileData().func_74780_a("ticks", 0.0D);
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
            })).getValue(world, new BlockPos(x, y, z), "ticks") >= 100.0D / multiplier) {
               if (!world.func_201670_d()) {
                  _bp = new BlockPos(x, y, z);
                  _ent = world.func_175625_s(_bp);
                  _bs = world.func_180495_p(_bp);
                  if (_ent != null) {
                     _ent.getTileData().func_74780_a("ticks", 0.0D);
                  }

                  if (world instanceof World) {
                     ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                  }
               }

               if (targetblock.func_177230_c() == EnderLillyStage8Block.block) {
                  world.func_175655_b(new BlockPos(target_x, target_y, target_z), false);

                  ItemStack _setstack;
                  int index1;
                  int _sltid;
                  for(index1 = 0; index1 < 9; ++index1) {
                     if ((((<undefinedtype>)(new Object() {
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
                     })).getItemStack(new BlockPos(x, y, z), (int)slotnumber).func_77973_b() == EnderLillyStage1Block.block.func_199767_j() || ((<undefinedtype>)(new Object() {
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
                     })).getAmount(world, new BlockPos(x, y, z), (int)slotnumber) == 0) && ((<undefinedtype>)(new Object() {
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
                     })).getAmount(world, new BlockPos(x, y, z), (int)slotnumber) < 64) {
                        _ent = world.func_175625_s(new BlockPos(x, y, z));
                        if (_ent != null) {
                           _sltid = (int)slotnumber;
                           _setstack = new ItemStack(EnderLillyStage1Block.block);
                           _setstack.func_190920_e(((<undefinedtype>)(new Object() {
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
                           })).getAmount(world, new BlockPos(x, y, z), (int)slotnumber) + 1);
                           _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                              if (capability instanceof IItemHandlerModifiable) {
                                 ((IItemHandlerModifiable)capability).setStackInSlot(_sltid, _setstack);
                              }

                           });
                        }
                        break;
                     }

                     ++slotnumber;
                  }

                  slotnumber = 0.0D;

                  for(index1 = 0; index1 < 9; ++index1) {
                     if ((((<undefinedtype>)(new Object() {
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
                     })).getItemStack(new BlockPos(x, y, z), (int)slotnumber).func_77973_b() == Items.field_151079_bi || ((<undefinedtype>)(new Object() {
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
                     })).getAmount(world, new BlockPos(x, y, z), (int)slotnumber) == 0) && ((<undefinedtype>)(new Object() {
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
                     })).getAmount(world, new BlockPos(x, y, z), (int)slotnumber) < 64) {
                        _ent = world.func_175625_s(new BlockPos(x, y, z));
                        if (_ent != null) {
                           _sltid = (int)slotnumber;
                           _setstack = new ItemStack(Items.field_151079_bi);
                           _setstack.func_190920_e(((<undefinedtype>)(new Object() {
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
                           })).getAmount(world, new BlockPos(x, y, z), (int)slotnumber) + 1);
                           _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                              if (capability instanceof IItemHandlerModifiable) {
                                 ((IItemHandlerModifiable)capability).setStackInSlot(_sltid, _setstack);
                              }

                           });
                        }
                        break;
                     }

                     ++slotnumber;
                  }
               } else {
                  if (world instanceof World) {
                     Block.func_220075_c(world.func_180495_p(new BlockPos(target_x, target_y, target_z)), (World)world, new BlockPos(target_x, target_y, target_z));
                     world.func_175655_b(new BlockPos(target_x, target_y, target_z), false);
                  }

                  List<Entity> _entfound = (List)world.func_175647_a(Entity.class, new AxisAlignedBB(target_x - 2.0D, target_y - 2.0D, target_z - 2.0D, target_x + 2.0D, target_y + 2.0D, target_z + 2.0D), (Predicate)null).stream().sorted(((<undefinedtype>)(new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparing((_entcnd) -> {
                           return _entcnd.func_70092_e(_x, _y, _z);
                        });
                     }
                  })).compareDistOf(target_x, target_y, target_z)).collect(Collectors.toList());
                  Iterator var32 = _entfound.iterator();

                  while(true) {
                     Entity entityiterator;
                     int index3;
                     do {
                        do {
                           if (!var32.hasNext()) {
                              return;
                           }

                           entityiterator = (Entity)var32.next();
                        } while(Blocks.field_150350_a.func_199767_j() == ((<undefinedtype>)(new Object() {
                           public ItemStack entityToItem(Entity _ent) {
                              return _ent instanceof ItemEntity ? ((ItemEntity)_ent).func_92059_d() : ItemStack.field_190927_a;
                           }
                        })).entityToItem(entityiterator).func_77973_b());

                        storeditem = ((<undefinedtype>)(new Object() {
                           public ItemStack entityToItem(Entity _ent) {
                              return _ent instanceof ItemEntity ? ((ItemEntity)_ent).func_92059_d() : ItemStack.field_190927_a;
                           }
                        })).entityToItem(entityiterator);

                        for(index3 = 0; index3 < 9; ++index3) {
                           if ((((<undefinedtype>)(new Object() {
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
                           })).getItemStack(new BlockPos(x, y, z), (int)slotnumber).func_77973_b() == storeditem.func_77973_b() || ((<undefinedtype>)(new Object() {
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
                           })).getAmount(world, new BlockPos(x, y, z), (int)slotnumber) == 0) && ((<undefinedtype>)(new Object() {
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
                           })).getAmount(world, new BlockPos(x, y, z), (int)slotnumber) < 65 - storeditem.func_190916_E()) {
                              freeslot = true;
                              break;
                           }

                           ++slotnumber;
                        }

                        slotnumber = 0.0D;
                     } while(!freeslot);

                     if (!entityiterator.field_70170_p.func_201670_d()) {
                        entityiterator.func_70106_y();
                     }

                     for(index3 = 0; index3 < 9; ++index3) {
                        if ((((<undefinedtype>)(new Object() {
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
                        })).getItemStack(new BlockPos(x, y, z), (int)slotnumber).func_77973_b() == storeditem.func_77973_b() || ((<undefinedtype>)(new Object() {
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
                        })).getAmount(world, new BlockPos(x, y, z), (int)slotnumber) == 0) && ((<undefinedtype>)(new Object() {
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
                        })).getAmount(world, new BlockPos(x, y, z), (int)slotnumber) < 65 - storeditem.func_190916_E()) {
                           TileEntity _ent = world.func_175625_s(new BlockPos(x, y, z));
                           if (_ent != null) {
                              int _sltid = (int)slotnumber;
                              storeditem.func_190920_e(((<undefinedtype>)(new Object() {
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
                              })).getAmount(world, new BlockPos(x, y, z), (int)slotnumber) + storeditem.func_190916_E());
                              _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                 if (capability instanceof IItemHandlerModifiable) {
                                    ((IItemHandlerModifiable)capability).setStackInSlot(_sltid, storeditem);
                                 }

                              });
                           }
                           break;
                        }

                        ++slotnumber;
                     }

                     slotnumber = 0.0D;
                  }
               }
            }
         }

      }
   }
}
