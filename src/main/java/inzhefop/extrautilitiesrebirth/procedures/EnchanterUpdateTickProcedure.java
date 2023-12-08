package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.BlockOfEnchanedMetalBlock;
import inzhefop.extrautilitiesrebirth.block.BlockOfEvilInfusedIronBlock;
import inzhefop.extrautilitiesrebirth.block.EnderQuarrySilkTouchUpgrade2Block;
import inzhefop.extrautilitiesrebirth.block.EnderQuarrySilkTouchUpgrade3Block;
import inzhefop.extrautilitiesrebirth.block.EnderQuarrySilkTouchUpgradeBlock;
import inzhefop.extrautilitiesrebirth.block.EnderQuarrySpeedUpgradeBlock;
import inzhefop.extrautilitiesrebirth.block.EnderQuarryUpgradeBaseBlock;
import inzhefop.extrautilitiesrebirth.block.MagicalWoodBlock;
import inzhefop.extrautilitiesrebirth.item.EnchantedIngotItem;
import inzhefop.extrautilitiesrebirth.item.EnchantedSpeedUpgradeItem;
import inzhefop.extrautilitiesrebirth.item.EvilInfusedIronIngotItem;
import inzhefop.extrautilitiesrebirth.item.MagicalAppleItem;
import inzhefop.extrautilitiesrebirth.item.SpeedUpgradeItem;
import inzhefop.extrautilitiesrebirth.item.SuperSpeedUpgradeItem;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
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

public class EnchanterUpdateTickProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure EnchanterUpdateTick!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure EnchanterUpdateTick!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure EnchanterUpdateTick!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure EnchanterUpdateTick!");
         }

      } else {
         final IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         ItemStack output = ItemStack.field_190927_a;
         double req_time = 0.0D;
         double req_fe = 0.0D;
         double required_resources = 0.0D;
         double req_bases = 0.0D;
         double res_count = 0.0D;
         double mulktiplierx = 0.0D;
         if (Blocks.field_150342_X.func_199767_j() == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b() && Items.field_196128_bn == ((<undefinedtype>)(new Object() {
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
            output = new ItemStack(MagicalWoodBlock.block);
            req_time = 1600.0D;
            req_fe = 64000.0D;
            required_resources = 1.0D;
            req_bases = 1.0D;
            res_count = 1.0D;
         }

         if (Items.field_151043_k == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b() && Items.field_196128_bn == ((<undefinedtype>)(new Object() {
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
            output = new ItemStack(EnchantedIngotItem.block);
            req_time = 200.0D;
            req_fe = 8000.0D;
            required_resources = 1.0D;
            req_bases = 1.0D;
            res_count = 1.0D;
         }

         if (Blocks.field_150340_R.func_199767_j() == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b() && Items.field_196128_bn == ((<undefinedtype>)(new Object() {
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
            output = new ItemStack(BlockOfEnchanedMetalBlock.block);
            req_time = 600.0D;
            req_fe = 24000.0D;
            required_resources = 9.0D;
            req_bases = 1.0D;
            res_count = 1.0D;
         }

         if (Blocks.field_150339_S.func_199767_j() == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b() && Items.field_151156_bN == ((<undefinedtype>)(new Object() {
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
            output = new ItemStack(BlockOfEvilInfusedIronBlock.block);
            req_time = 4800.0D;
            req_fe = 192000.0D;
            required_resources = 9.0D;
            req_bases = 8.0D;
            res_count = 8.0D;
         }

         if (Items.field_151034_e == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b() && Items.field_196128_bn == ((<undefinedtype>)(new Object() {
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
            output = new ItemStack(MagicalAppleItem.block);
            req_time = 400.0D;
            req_fe = 16000.0D;
            required_resources = 4.0D;
            req_bases = 16.0D;
            res_count = 16.0D;
         }

         if (Items.field_151042_j == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b() && Items.field_151156_bN == ((<undefinedtype>)(new Object() {
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
            output = new ItemStack(EvilInfusedIronIngotItem.block);
            req_time = 1600.0D;
            req_fe = 24000.0D;
            required_resources = 1.0D;
            req_bases = 8.0D;
            res_count = 8.0D;
         }

         if (EnderQuarryUpgradeBaseBlock.block.func_199767_j() == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b() && EnchantmentHelper.func_77506_a(Enchantments.field_185306_r, ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 1)) != 0) {
            output = new ItemStack(EnderQuarrySilkTouchUpgradeBlock.block);
            req_time = 2400.0D;
            req_fe = 64000.0D;
            required_resources = 1.0D;
            req_bases = 1.0D;
            res_count = 1.0D;
         }

         if (EnderQuarrySpeedUpgradeBlock.block.func_199767_j() == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b() && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 1).func_77948_v() && EnchantmentHelper.func_77506_a(Enchantments.field_185305_q, ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 1)) >= 3) {
            output = new ItemStack(EnderQuarrySilkTouchUpgrade2Block.block);
            req_time = 2400.0D;
            req_fe = 64000.0D;
            required_resources = 1.0D;
            req_bases = 1.0D;
            res_count = 1.0D;
         }

         if (EnderQuarrySilkTouchUpgrade2Block.block.func_199767_j() == ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 0).func_77973_b() && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 1).func_77948_v() && EnchantmentHelper.func_77506_a(Enchantments.field_185305_q, ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 1)) >= 5) {
            output = new ItemStack(EnderQuarrySilkTouchUpgrade3Block.block);
            req_time = 2400.0D;
            req_fe = 64000.0D;
            required_resources = 1.0D;
            req_bases = 1.0D;
            res_count = 1.0D;
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
         })).getItemStack(new BlockPos(x, y, z), 3).func_77973_b() && EnchantedSpeedUpgradeItem.block != ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 3).func_77973_b() && SuperSpeedUpgradeItem.block != ((<undefinedtype>)(new Object() {
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
         })).getItemStack(new BlockPos(x, y, z), 3).func_77973_b()) {
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
            })).getAmount(world, new BlockPos(x, y, z), 3);
            req_fe *= (double)(((<undefinedtype>)(new Object() {
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
            })).getAmount(world, new BlockPos(x, y, z), 3) / 12);
         }

         BlockPos _bp;
         TileEntity _tileEntity;
         BlockState _bs;
         if (!world.func_201670_d()) {
            _bp = new BlockPos(x, y, z);
            _tileEntity = world.func_175625_s(_bp);
            _bs = world.func_180495_p(_bp);
            if (_tileEntity != null) {
               _tileEntity.getTileData().func_74780_a("progresstime", req_time);
            }

            if (world instanceof World) {
               ((World)world).func_184138_a(_bp, _bs, _bs, 3);
            }
         }

         if (Blocks.field_150350_a.func_199767_j() != output.func_77973_b()) {
            if ((double)((<undefinedtype>)(new Object() {
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
            })).getAmount(world, new BlockPos(x, y, z), 0) >= req_bases && (double)((<undefinedtype>)(new Object() {
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
            })).getAmount(world, new BlockPos(x, y, z), 1) >= required_resources && (double)((<undefinedtype>)(new Object() {
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
            })).getAmount(world, new BlockPos(x, y, z), 2) < 65.0D - res_count && (double)((<undefinedtype>)(new Object() {
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
            })).getEnergyStored(world, new BlockPos(x, y, z)) >= req_fe && (((<undefinedtype>)(new Object() {
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
            })).getAmount(world, new BlockPos(x, y, z), 2) == 0 || output.func_77973_b() == ((<undefinedtype>)(new Object() {
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
            })).getItemStack(new BlockPos(x, y, z), 2).func_77973_b())) {
               if (!world.func_201670_d()) {
                  _bp = new BlockPos(x, y, z);
                  _tileEntity = world.func_175625_s(_bp);
                  _bs = world.func_180495_p(_bp);
                  if (_tileEntity != null) {
                     _tileEntity.getTileData().func_74780_a("progress", ((<undefinedtype>)(new Object() {
                        public double getValue(IWorld world, BlockPos pos, String tag) {
                           TileEntity tileEntity = world.func_175625_s(pos);
                           return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                        }
                     })).getValue(world, new BlockPos(x, y, z), "progress") + 1.0D + mulktiplierx * 1.54D);
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
               })).getValue(world, new BlockPos(x, y, z), "progress") >= req_time) {
                  TileEntity _ent = world.func_175625_s(new BlockPos(x, y, z));
                  boolean _sltid;
                  if (_ent != null) {
                     _sltid = true;
                     output.func_190920_e((int)((double)((<undefinedtype>)(new Object() {
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
                     })).getAmount(world, new BlockPos(x, y, z), 2) + res_count));
                     _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        if (capability instanceof IItemHandlerModifiable) {
                           ((IItemHandlerModifiable)capability).setStackInSlot(2, output);
                        }

                     });
                  }

                  _ent = world.func_175625_s(new BlockPos(x, y, z));
                  int _amount;
                  if (_ent != null) {
                     _sltid = false;
                     _amount = (int)req_bases;
                     _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        if (capability instanceof IItemHandlerModifiable) {
                           ItemStack _stk = capability.getStackInSlot(0).func_77946_l();
                           _stk.func_190918_g(_amount);
                           ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                        }

                     });
                  }

                  _ent = world.func_175625_s(new BlockPos(x, y, z));
                  int _amount = (int)req_fe;
                  if (_ent != null) {
                     _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                        capability.extractEnergy(_amount, false);
                     });
                  }

                  _ent = world.func_175625_s(new BlockPos(x, y, z));
                  if (_ent != null) {
                     _sltid = true;
                     _amount = (int)required_resources;
                     _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        if (capability instanceof IItemHandlerModifiable) {
                           ItemStack _stk = capability.getStackInSlot(1).func_77946_l();
                           _stk.func_190918_g(_amount);
                           ((IItemHandlerModifiable)capability).setStackInSlot(1, _stk);
                        }

                     });
                  }

                  if (!world.func_201670_d()) {
                     _bp = new BlockPos(x, y, z);
                     _tileEntity = world.func_175625_s(_bp);
                     _bs = world.func_180495_p(_bp);
                     if (_tileEntity != null) {
                        _tileEntity.getTileData().func_74780_a("progress", 0.0D);
                     }

                     if (world instanceof World) {
                        ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                     }
                  }
               }
            }
         } else if (!world.func_201670_d()) {
            _bp = new BlockPos(x, y, z);
            _tileEntity = world.func_175625_s(_bp);
            _bs = world.func_180495_p(_bp);
            if (_tileEntity != null) {
               _tileEntity.getTileData().func_74780_a("progress", 0.0D);
            }

            if (world instanceof World) {
               ((World)world).func_184138_a(_bp, _bs, _bs, 3);
            }
         }

      }
   }
}
