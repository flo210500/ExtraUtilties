package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.RainbowGeneratorBlock;
import inzhefop.extrautilitiesrebirth.block.WirelessFEBatteryBlock;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

public class WrenchClickedOnBlockProcedureProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure WrenchClickedOnBlockProcedure!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure WrenchClickedOnBlockProcedure!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure WrenchClickedOnBlockProcedure!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure WrenchClickedOnBlockProcedure!");
         }

      } else if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure WrenchClickedOnBlockProcedure!");
         }

      } else if (dependencies.get("itemstack") == null) {
         if (!dependencies.containsKey("itemstack")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency itemstack for procedure WrenchClickedOnBlockProcedure!");
         }

      } else {
         final IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         Entity entity = (Entity)dependencies.get("entity");
         ItemStack itemstack = (ItemStack)dependencies.get("itemstack");
         double airdistance = 0.0D;
         BlockPos _bp;
         TileEntity _tileEntity;
         BlockState _bs;
         if (RainbowGeneratorBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            itemstack.func_196082_o().func_74780_a("x", x);
            itemstack.func_196082_o().func_74780_a("y", y);
            itemstack.func_196082_o().func_74780_a("z", z);
            itemstack.func_196082_o().func_74780_a("wrenchmode", 1.0D);
            itemstack.func_200302_a(new StringTextComponent("§r§fWrench [Rainbow Gen at " + x + "" + " " + y + " " + "" + z + "]"));
            if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("[Rainbow Gen at " + x + "" + " " + y + " " + "" + z + "]"), true);
            }
         } else if (ItemTags.func_199903_a().func_241834_b(new ResourceLocation("forge:generator_eur")).func_230235_a_((new ItemStack(world.func_180495_p(new BlockPos(x, y, z)).func_177230_c())).func_77973_b())) {
            if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _tileEntity = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74780_a("rbg_x", itemstack.func_196082_o().func_74769_h("x"));
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
                  _tileEntity.getTileData().func_74780_a("rbg_y", itemstack.func_196082_o().func_74769_h("y"));
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
                  _tileEntity.getTileData().func_74780_a("rbg_z", itemstack.func_196082_o().func_74769_h("z"));
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }

            if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Binded Rainbow Generator to " + (new ItemStack(world.func_180495_p(new BlockPos(x, y, z)).func_177230_c())).func_200301_q().getString()), false);
            }
         }

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
         })).getFluidTankLevel(new BlockPos(x, y, z), 1) > 0 && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
            ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Fluid: " + Math.round((float)((<undefinedtype>)(new Object() {
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
            })).getFluidTankLevel(new BlockPos(x, y, z), 1)) + " mB"), false);
         }

         if (RainbowGeneratorBlock.block != world.func_180495_p(new BlockPos(x, y, z)).func_177230_c() && WirelessFEBatteryBlock.block != world.func_180495_p(new BlockPos(x, y, z)).func_177230_c() && !ItemTags.func_199903_a().func_241834_b(new ResourceLocation("forge:generator_eur")).func_230235_a_((new ItemStack(world.func_180495_p(new BlockPos(x, y, z)).func_177230_c())).func_77973_b()) && ((<undefinedtype>)(new Object() {
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
         })).getMaxEnergyStored(world, new BlockPos(x, y, z)) > 0) {
            itemstack.func_196082_o().func_74780_a("reciever_x", x);
            itemstack.func_196082_o().func_74780_a("reciever_y", y);
            itemstack.func_196082_o().func_74780_a("reciever_z", z);
            if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Set Energy Reciever to " + (new ItemStack(world.func_180495_p(new BlockPos(x, y, z)).func_177230_c())).func_200301_q().getString()), false);
            }
         } else if (WirelessFEBatteryBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            if (itemstack.func_196082_o().func_74769_h("reciever_y") != 0.0D) {
               if (((<undefinedtype>)(new Object() {
                  public double getValue(IWorld world, BlockPos pos, String tag) {
                     TileEntity tileEntity = world.func_175625_s(pos);
                     return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                  }
               })).getValue(world, new BlockPos(x, y, z), "connections") < 10.0D) {
                  airdistance = Math.sqrt(Math.pow(itemstack.func_196082_o().func_74769_h("reciever_x") - x, 2.0D) + Math.pow(itemstack.func_196082_o().func_74769_h("reciever_y") - y, 2.0D) + Math.pow(itemstack.func_196082_o().func_74769_h("reciever_z") - z, 2.0D));
                  if (airdistance < 10.0D) {
                     if (!world.func_201670_d()) {
                        _bp = new BlockPos(x, y, z);
                        _tileEntity = world.func_175625_s(_bp);
                        _bs = world.func_180495_p(_bp);
                        if (_tileEntity != null) {
                           _tileEntity.getTileData().func_74780_a("connections", ((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(x, y, z), "connections") + 1.0D);
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
                           _tileEntity.getTileData().func_74780_a("connection" + Math.round(((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(x, y, z), "connections")) + "x", itemstack.func_196082_o().func_74769_h("reciever_x"));
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
                           _tileEntity.getTileData().func_74780_a("connection" + Math.round(((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(x, y, z), "connections")) + "y", itemstack.func_196082_o().func_74769_h("reciever_y"));
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
                           _tileEntity.getTileData().func_74780_a("connection" + Math.round(((<undefinedtype>)(new Object() {
                              public double getValue(IWorld world, BlockPos pos, String tag) {
                                 TileEntity tileEntity = world.func_175625_s(pos);
                                 return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                              }
                           })).getValue(world, new BlockPos(x, y, z), "connections")) + "z", itemstack.func_196082_o().func_74769_h("reciever_z"));
                        }

                        if (world instanceof World) {
                           ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                        }
                     }

                     if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
                        ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Successfully established connection to " + (new ItemStack(world.func_180495_p(new BlockPos(itemstack.func_196082_o().func_74769_h("reciever_x"), itemstack.func_196082_o().func_74769_h("reciever_y"), itemstack.func_196082_o().func_74769_h("reciever_z"))).func_177230_c())).func_200301_q().getString() + "" + " [Distance: " + Math.round(airdistance) + " blocks]"), false);
                     }

                     if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
                        ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Connections: " + Math.round(((<undefinedtype>)(new Object() {
                           public double getValue(IWorld world, BlockPos pos, String tag) {
                              TileEntity tileEntity = world.func_175625_s(pos);
                              return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                           }
                        })).getValue(world, new BlockPos(x, y, z), "connections")) + "/10"), false);
                     }
                  } else if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
                     ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Distance between Reciever and FE Battery too large!" + " [Distance: " + Math.round(airdistance) + " blocks]"), false);
                  }
               } else if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
                  ((PlayerEntity)entity).func_146105_b(new StringTextComponent("This FE Transmitter cannot establish anymore connections! [10/10]"), false);
               }
            } else if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("A energy reciever was not set previously"), false);
            }
         }

      }
   }
}
