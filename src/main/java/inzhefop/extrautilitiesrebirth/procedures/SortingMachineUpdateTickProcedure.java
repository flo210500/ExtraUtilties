package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.item.EnchantedSpeedUpgradeItem;
import inzhefop.extrautilitiesrebirth.item.SpeedUpgradeItem;
import inzhefop.extrautilitiesrebirth.item.SuperSpeedUpgradeItem;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.IInventory;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class SortingMachineUpdateTickProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure SortingMachineUpdateTick!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure SortingMachineUpdateTick!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure SortingMachineUpdateTick!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure SortingMachineUpdateTick!");
         }

      } else {
         final IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         BlockState chest1 = Blocks.field_150350_a.func_176223_P();
         BlockState chest2 = Blocks.field_150350_a.func_176223_P();
         BlockState targetblock = Blocks.field_150350_a.func_176223_P();
         double target_x = 0.0D;
         double target_y = 0.0D;
         double target_z = 0.0D;
         double slotcounter1 = 0.0D;
         double target_x2 = 0.0D;
         double target_y2 = 0.0D;
         double target_z2 = 0.0D;
         double multiplier = 0.0D;
         chest1 = Blocks.field_150350_a.func_176223_P();
         chest2 = Blocks.field_150350_a.func_176223_P();
         BlockPos _bp;
         TileEntity _tileEntity;
         BlockState _bs;
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

         SorterTitleProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("x", x), new SimpleEntry("y", y), new SimpleEntry("z", z)).collect(HashMap::new, (_m, _e) -> {
            _m.put(_e.getKey(), _e.getValue());
         }, Map::putAll));
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
         })).getItemStack(new BlockPos(x, y, z), 15).func_77973_b() != SpeedUpgradeItem.block && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 15).func_77973_b() != EnchantedSpeedUpgradeItem.block && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 15).func_77973_b() != SuperSpeedUpgradeItem.block) {
            multiplier = 0.0D;
         } else {
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
            })).getAmount(world, new BlockPos(x, y, z), 15);
         }

         if (((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "ticks") >= 20.0D - multiplier) {
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

            if (Direction.NORTH == ((<undefinedtype>)(new Object() {
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
               targetblock = world.func_180495_p(new BlockPos(x, y, z - 1.0D));
               target_x = x;
               target_y = y;
               target_z = z - 1.0D;
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
               targetblock = world.func_180495_p(new BlockPos(x, y, z + 1.0D));
               target_x = x;
               target_y = y;
               target_z = z + 1.0D;
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
               targetblock = world.func_180495_p(new BlockPos(x - 1.0D, y, z));
               target_x = x - 1.0D;
               target_y = y;
               target_z = z;
            }

            if (((<undefinedtype>)(new Object() {
               public double getValue(IWorld world, BlockPos pos) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  double slots = 0.0D;
                  if (tileEntity instanceof IInventory) {
                     slots = (double)((IInventory)tileEntity).func_70302_i_();
                  }

                  return slots;
               }
            })).getValue(world, new BlockPos((int)target_x, (int)target_y, (int)target_z)) > 0.0D) {
               chest1 = targetblock;
            }

            if (Direction.NORTH == ((<undefinedtype>)(new Object() {
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
               target_x2 = x - 1.0D;
               target_y2 = y;
               target_z2 = z;
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
               targetblock = world.func_180495_p(new BlockPos(x, y, z + 1.0D));
               target_x2 = x;
               target_y2 = y;
               target_z2 = z + 1.0D;
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
               targetblock = world.func_180495_p(new BlockPos(x, y, z - 1.0D));
               target_x2 = x;
               target_y2 = y;
               target_z2 = z - 1.0D;
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
               targetblock = world.func_180495_p(new BlockPos(x + 1.0D, y, z));
               target_x2 = x + 1.0D;
               target_y2 = y;
               target_z2 = z;
            }

            if (((<undefinedtype>)(new Object() {
               public double getValue(IWorld world, BlockPos pos) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  double slots = 0.0D;
                  if (tileEntity instanceof IInventory) {
                     slots = (double)((IInventory)tileEntity).func_70302_i_();
                  }

                  return slots;
               }
            })).getValue(world, new BlockPos((int)target_x2, (int)target_y2, (int)target_z2)) > 0.0D) {
               chest2 = targetblock;
            }

            if (Blocks.field_150350_a != chest1.func_177230_c() && Blocks.field_150350_a != chest2.func_177230_c() && Items.field_151057_cb == ((<undefinedtype>)(new Object() {
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
            })).getItemStack(new BlockPos(x, y, z), 16).func_77973_b() && !((<undefinedtype>)(new Object() {
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
            })).getItemStack(new BlockPos(x, y, z), 16).func_200301_q().getString().length() - 1).contains("*")) {
               for(slotcounter1 = 0.0D; slotcounter1 < 15.0D; ++slotcounter1) {
                  double cant_value;
                  double total_slots;
                  double slot_final;
                  double slot_value;
                  double calculo_value;
                  double cont_value;
                  double z_value;
                  double y_value;
                  double x_value;
                  double max_value;
                  ItemStack item_value;
                  ItemStack saved_stack;
                  int index0;
                  int index2;
                  int _sltid;
                  boolean get_encr;
                  boolean romper_value;
                  double total_value;
                  TileEntity _ent;
                  boolean _amount;
                  TileEntity _ent;
                  if (ItemTags.func_199903_a().func_241834_b(new ResourceLocation(((<undefinedtype>)(new Object() {
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
                  })).getItemStack(new BlockPos(x, y, z), 16).func_200301_q().getString().length() - 1).toLowerCase(Locale.ENGLISH))).func_230235_a_(((<undefinedtype>)(new Object() {
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
                  })).getItemStack(new BlockPos(x, y, z), (int)slotcounter1).func_77973_b())) {
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
                     })).getAmount(world, new BlockPos(target_x2, target_y2, target_z2), (int)(((<undefinedtype>)(new Object() {
                        public double getValue(IWorld world, BlockPos pos) {
                           TileEntity tileEntity = world.func_175625_s(pos);
                           double slots = 0.0D;
                           if (tileEntity instanceof IInventory) {
                              slots = (double)((IInventory)tileEntity).func_70302_i_();
                           }

                           return slots;
                        }
                     })).getValue(world, new BlockPos((int)target_x2, (int)target_y2, (int)target_z2)) - 1.0D)) == 0) {
                        get_encr = false;
                        romper_value = false;
                        total_value = 0.0D;
                        cant_value = 0.0D;
                        total_slots = 0.0D;
                        slot_final = 0.0D;
                        slot_value = 0.0D;
                        calculo_value = 0.0D;
                        cont_value = 0.0D;
                        z_value = 0.0D;
                        y_value = 0.0D;
                        x_value = 0.0D;
                        max_value = 0.0D;
                        item_value = ItemStack.field_190927_a;
                        saved_stack = ItemStack.field_190927_a;
                        x_value = target_x2;
                        y_value = target_y2;
                        z_value = target_z2;
                        cant_value = 1.0D;
                        item_value = ((<undefinedtype>)(new Object() {
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
                        })).getItemStack(new BlockPos(x, y, z), (int)slotcounter1);
                        total_slots = ((<undefinedtype>)(new Object() {
                           public double getValue(IWorld world, BlockPos pos) {
                              TileEntity tileEntity = world.func_175625_s(pos);
                              double slots = 0.0D;
                              if (tileEntity instanceof IInventory) {
                                 slots = (double)((IInventory)tileEntity).func_70302_i_();
                              }

                              return slots;
                           }
                        })).getValue(world, new BlockPos((int)target_x2, (int)target_y2, (int)target_z2));

                        for(index0 = 0; index0 < (int)total_slots; ++index0) {
                           if (cant_value > 0.0D) {
                              cont_value = 0.0D;
                              get_encr = false;
                              romper_value = false;

                              for(index2 = 0; index2 < (int)total_slots; ++index2) {
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
                                 })).getItemStack(new BlockPos((int)x_value, (int)y_value, (int)z_value), (int)cont_value).func_77973_b() && !get_encr && ((<undefinedtype>)(new Object() {
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
                                 })).getAmount(world, new BlockPos((int)x_value, (int)y_value, (int)z_value), (int)cont_value) < item_value.func_77976_d()) {
                                    get_encr = true;
                                 }

                                 ++cont_value;
                              }

                              cont_value = 0.0D;

                              for(index2 = 0; index2 < (int)total_slots; ++index2) {
                                 if (!romper_value) {
                                    slot_final = (double)((<undefinedtype>)(new Object() {
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
                                    })).getAmount(world, new BlockPos((int)x_value, (int)y_value, (int)z_value), (int)cont_value);
                                    if (slot_final == 0.0D && !get_encr) {
                                       total_value = cant_value;
                                       calculo_value = cant_value;
                                       romper_value = true;
                                       saved_stack = item_value;
                                    }

                                    if (get_encr && slot_final > 0.0D && ((<undefinedtype>)(new Object() {
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
                                    })).getItemStack(new BlockPos((int)x_value, (int)y_value, (int)z_value), (int)cont_value).func_77973_b() == item_value.func_77973_b() && slot_final < (double)item_value.func_77976_d()) {
                                       calculo_value = (double)item_value.func_77976_d() - slot_final;
                                       if (calculo_value < 0.0D) {
                                          calculo_value *= -1.0D;
                                       }

                                       if (calculo_value > cant_value) {
                                          calculo_value = cant_value;
                                       }

                                       total_value = slot_final + calculo_value;
                                       romper_value = true;
                                       saved_stack = ((<undefinedtype>)(new Object() {
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
                                       })).getItemStack(new BlockPos((int)x_value, (int)y_value, (int)z_value), (int)cont_value);
                                    }

                                    slot_value = cont_value;
                                 }

                                 ++cont_value;
                              }

                              cant_value -= calculo_value;
                              if (cant_value < 0.0D) {
                                 cant_value *= -1.0D;
                              }

                              _ent = world.func_175625_s(new BlockPos((int)x_value, (int)y_value, (int)z_value));
                              if (_ent != null) {
                                 _sltid = (int)slot_value;
                                 saved_stack.func_190920_e((int)total_value);
                                 _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                    if (capability instanceof IItemHandlerModifiable) {
                                       ((IItemHandlerModifiable)capability).setStackInSlot(_sltid, saved_stack);
                                    }

                                 });
                              }

                              if (cant_value == 0.0D) {
                                 break;
                              }
                           }
                        }

                        _ent = world.func_175625_s(new BlockPos(x, y, z));
                        if (_ent != null) {
                           index2 = (int)slotcounter1;
                           _amount = true;
                           _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                              if (capability instanceof IItemHandlerModifiable) {
                                 ItemStack _stk = capability.getStackInSlot(index2).func_77946_l();
                                 _stk.func_190918_g(1);
                                 ((IItemHandlerModifiable)capability).setStackInSlot(index2, _stk);
                              }

                           });
                        }
                     }
                  } else if (((<undefinedtype>)(new Object() {
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
                  })).getAmount(world, new BlockPos(target_x, target_y, target_z), (int)(((<undefinedtype>)(new Object() {
                     public double getValue(IWorld world, BlockPos pos) {
                        TileEntity tileEntity = world.func_175625_s(pos);
                        double slots = 0.0D;
                        if (tileEntity instanceof IInventory) {
                           slots = (double)((IInventory)tileEntity).func_70302_i_();
                        }

                        return slots;
                     }
                  })).getValue(world, new BlockPos((int)target_x, (int)target_y, (int)target_z)) - 1.0D)) == 0) {
                     get_encr = false;
                     romper_value = false;
                     total_value = 0.0D;
                     cant_value = 0.0D;
                     total_slots = 0.0D;
                     slot_final = 0.0D;
                     slot_value = 0.0D;
                     calculo_value = 0.0D;
                     cont_value = 0.0D;
                     z_value = 0.0D;
                     y_value = 0.0D;
                     x_value = 0.0D;
                     max_value = 0.0D;
                     item_value = ItemStack.field_190927_a;
                     saved_stack = ItemStack.field_190927_a;
                     x_value = target_x;
                     y_value = target_y;
                     z_value = target_z;
                     cant_value = 1.0D;
                     item_value = ((<undefinedtype>)(new Object() {
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
                     })).getItemStack(new BlockPos(x, y, z), (int)slotcounter1);
                     total_slots = ((<undefinedtype>)(new Object() {
                        public double getValue(IWorld world, BlockPos pos) {
                           TileEntity tileEntity = world.func_175625_s(pos);
                           double slots = 0.0D;
                           if (tileEntity instanceof IInventory) {
                              slots = (double)((IInventory)tileEntity).func_70302_i_();
                           }

                           return slots;
                        }
                     })).getValue(world, new BlockPos((int)target_x, (int)target_y, (int)target_z));

                     for(index0 = 0; index0 < (int)total_slots; ++index0) {
                        if (cant_value > 0.0D) {
                           cont_value = 0.0D;
                           get_encr = false;
                           romper_value = false;

                           for(index2 = 0; index2 < (int)total_slots; ++index2) {
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
                              })).getItemStack(new BlockPos((int)x_value, (int)y_value, (int)z_value), (int)cont_value).func_77973_b() && !get_encr && ((<undefinedtype>)(new Object() {
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
                              })).getAmount(world, new BlockPos((int)x_value, (int)y_value, (int)z_value), (int)cont_value) < item_value.func_77976_d()) {
                                 get_encr = true;
                              }

                              ++cont_value;
                           }

                           cont_value = 0.0D;

                           for(index2 = 0; index2 < (int)total_slots; ++index2) {
                              if (!romper_value) {
                                 slot_final = (double)((<undefinedtype>)(new Object() {
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
                                 })).getAmount(world, new BlockPos((int)x_value, (int)y_value, (int)z_value), (int)cont_value);
                                 if (slot_final == 0.0D && !get_encr) {
                                    total_value = cant_value;
                                    calculo_value = cant_value;
                                    romper_value = true;
                                    saved_stack = item_value;
                                 }

                                 if (get_encr && slot_final > 0.0D && ((<undefinedtype>)(new Object() {
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
                                 })).getItemStack(new BlockPos((int)x_value, (int)y_value, (int)z_value), (int)cont_value).func_77973_b() == item_value.func_77973_b() && slot_final < (double)item_value.func_77976_d()) {
                                    calculo_value = (double)item_value.func_77976_d() - slot_final;
                                    if (calculo_value < 0.0D) {
                                       calculo_value *= -1.0D;
                                    }

                                    if (calculo_value > cant_value) {
                                       calculo_value = cant_value;
                                    }

                                    total_value = slot_final + calculo_value;
                                    romper_value = true;
                                    saved_stack = ((<undefinedtype>)(new Object() {
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
                                    })).getItemStack(new BlockPos((int)x_value, (int)y_value, (int)z_value), (int)cont_value);
                                 }

                                 slot_value = cont_value;
                              }

                              ++cont_value;
                           }

                           cant_value -= calculo_value;
                           if (cant_value < 0.0D) {
                              cant_value *= -1.0D;
                           }

                           _ent = world.func_175625_s(new BlockPos((int)x_value, (int)y_value, (int)z_value));
                           if (_ent != null) {
                              _sltid = (int)slot_value;
                              saved_stack.func_190920_e((int)total_value);
                              _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                 if (capability instanceof IItemHandlerModifiable) {
                                    ((IItemHandlerModifiable)capability).setStackInSlot(_sltid, saved_stack);
                                 }

                              });
                           }

                           if (cant_value == 0.0D) {
                              break;
                           }
                        }
                     }

                     _ent = world.func_175625_s(new BlockPos(x, y, z));
                     if (_ent != null) {
                        index2 = (int)slotcounter1;
                        _amount = true;
                        _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           if (capability instanceof IItemHandlerModifiable) {
                              ItemStack _stk = capability.getStackInSlot(index2).func_77946_l();
                              _stk.func_190918_g(1);
                              ((IItemHandlerModifiable)capability).setStackInSlot(index2, _stk);
                           }

                        });
                     }
                  }
               }
            }
         }

      }
   }
}
