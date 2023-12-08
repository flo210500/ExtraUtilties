package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.EnderMarkerBlock;
import java.util.Map;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EnderQuarryOnBlockRightClickedProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure EnderQuarryOnBlockRightClicked!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure EnderQuarryOnBlockRightClicked!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure EnderQuarryOnBlockRightClicked!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure EnderQuarryOnBlockRightClicked!");
         }

      } else if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure EnderQuarryOnBlockRightClicked!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         Entity entity = (Entity)dependencies.get("entity");
         double zblock = 0.0D;
         double counter1 = 0.0D;
         double yblock = 0.0D;
         double xblock = 0.0D;
         if (((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "state") == 0.0D) {
            for(int index0 = 0; index0 < 6; ++index0) {
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

               if (EnderMarkerBlock.block == world.func_180495_p(new BlockPos(xblock, yblock, zblock)).func_177230_c()) {
                  BlockPos _bp;
                  TileEntity _tileEntity;
                  BlockState _bs;
                  if (!world.func_201670_d()) {
                     _bp = new BlockPos(x, y, z);
                     _tileEntity = world.func_175625_s(_bp);
                     _bs = world.func_180495_p(_bp);
                     if (_tileEntity != null) {
                        _tileEntity.getTileData().func_74757_a("attachedmarker", true);
                     }

                     if (world instanceof World) {
                        ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                     }
                  }

                  if (((<undefinedtype>)(new Object() {
                     public boolean getValue(IWorld world, BlockPos pos, String tag) {
                        TileEntity tileEntity = world.func_175625_s(pos);
                        return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
                     }
                  })).getValue(world, new BlockPos(xblock, yblock, zblock), "complete")) {
                     if (!world.func_201670_d()) {
                        _bp = new BlockPos(x, y, z);
                        _tileEntity = world.func_175625_s(_bp);
                        _bs = world.func_180495_p(_bp);
                        if (_tileEntity != null) {
                           _tileEntity.getTileData().func_74780_a("areaminx", ((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(xblock, yblock, zblock), "minx"));
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
                           _tileEntity.getTileData().func_74780_a("areamaxx", ((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(xblock, yblock, zblock), "maxx"));
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
                           _tileEntity.getTileData().func_74780_a("areaminz", ((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(xblock, yblock, zblock), "minz"));
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
                           _tileEntity.getTileData().func_74780_a("areamaxz", ((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(xblock, yblock, zblock), "maxz"));
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
                           _tileEntity.getTileData().func_74780_a("areamaxy", y - 1.0D);
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
                           _tileEntity.getTileData().func_74780_a("xcoord", ((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(xblock, yblock, zblock), "minx"));
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
                           _tileEntity.getTileData().func_74780_a("ycoord", y - 1.0D);
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
                           _tileEntity.getTileData().func_74780_a("zcoord", ((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(xblock, yblock, zblock), "minz"));
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
                           _tileEntity.getTileData().func_74780_a("areadirect1", ((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(xblock, yblock, zblock), "direc1"));
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
                           _tileEntity.getTileData().func_74780_a("areadirect2", ((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(xblock, yblock, zblock), "direc2"));
                        }

                        if (world instanceof World) {
                           ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                        }
                     }
                     break;
                  }
               }

               ++counter1;
            }

            if (((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "attachedmarker") && !((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "running")) {
               if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
                  ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Anylysing Fence boundardy"), false);
               }

               if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
                  ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Found attached ender-marker"), false);
               }

               if (((<undefinedtype>)(new Object() {
                  public boolean getValue(IWorld world, BlockPos pos, String tag) {
                     TileEntity tileEntity = world.func_175625_s(pos);
                     return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
                  }
               })).getValue(world, new BlockPos(xblock, yblock, zblock), "complete")) {
                  if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
                     ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Succesfully established ender-boundary"), false);
                  }

                  if (!world.func_201670_d()) {
                     BlockPos _bp = new BlockPos(x, y, z);
                     TileEntity _tileEntity = world.func_175625_s(_bp);
                     BlockState _bs = world.func_180495_p(_bp);
                     if (_tileEntity != null) {
                        _tileEntity.getTileData().func_74780_a("state", 1.0D);
                     }

                     if (world instanceof World) {
                        ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                     }
                  }
               } else {
                  if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
                     ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Quarry marker square is incomplete"), false);
                  }

                  if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
                     ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Unable to detect Fence boundary"), false);
                  }
               }
            } else if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "running")) {
               if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
                  ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Anylysing Fence boundardy"), false);
               }

               if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
                  ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Unable to detect Fence boundary"), false);
               }
            } else if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("State: §aActive§f - Scanned blocks: " + Math.round(((<undefinedtype>)(new Object() {
                  public double getValue(IWorld world, BlockPos pos, String tag) {
                     TileEntity tileEntity = world.func_175625_s(pos);
                     return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                  }
               })).getValue(world, new BlockPos(x, y, z), "minedblocks")) + "" + " [" + ((<undefinedtype>)(new Object() {
                  public double getValue(IWorld world, BlockPos pos, String tag) {
                     TileEntity tileEntity = world.func_175625_s(pos);
                     return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                  }
               })).getValue(world, new BlockPos(x, y, z), "xcoord") + "" + " " + ((<undefinedtype>)(new Object() {
                  public double getValue(IWorld world, BlockPos pos, String tag) {
                     TileEntity tileEntity = world.func_175625_s(pos);
                     return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                  }
               })).getValue(world, new BlockPos(x, y, z), "ycoord") + "" + " " + ((<undefinedtype>)(new Object() {
                  public double getValue(IWorld world, BlockPos pos, String tag) {
                     TileEntity tileEntity = world.func_175625_s(pos);
                     return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                  }
               })).getValue(world, new BlockPos(x, y, z), "zcoord") + "]"), true);
            }
         } else if (((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "state") == 2.0D) {
            if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§aQuarry has finished!"), true);
            }
         } else if (((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "state") == 3.0D) {
            if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§cMissing item storage!"), true);
            }
         } else if (((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "state") == 1.0D && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
            ((PlayerEntity)entity).func_146105_b(new StringTextComponent("State: §aActive§f - Scanned blocks: " + Math.round(((<undefinedtype>)(new Object() {
               public double getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
               }
            })).getValue(world, new BlockPos(x, y, z), "minedblocks")) + "" + " [" + ((<undefinedtype>)(new Object() {
               public double getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
               }
            })).getValue(world, new BlockPos(x, y, z), "xcoord") + "" + " " + ((<undefinedtype>)(new Object() {
               public double getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
               }
            })).getValue(world, new BlockPos(x, y, z), "ycoord") + "" + " " + ((<undefinedtype>)(new Object() {
               public double getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
               }
            })).getValue(world, new BlockPos(x, y, z), "zcoord") + "]"), true);
         }

      }
   }
}
