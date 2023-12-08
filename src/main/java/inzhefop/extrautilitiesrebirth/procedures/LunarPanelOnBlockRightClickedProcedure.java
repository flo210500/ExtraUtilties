package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IWorld;
import net.minecraftforge.energy.CapabilityEnergy;

public class LunarPanelOnBlockRightClickedProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure LunarPanelOnBlockRightClicked!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure LunarPanelOnBlockRightClicked!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure LunarPanelOnBlockRightClicked!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure LunarPanelOnBlockRightClicked!");
         }

      } else if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure LunarPanelOnBlockRightClicked!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         Entity entity = (Entity)dependencies.get("entity");
         double energy = 0.0D;
         if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
            ((PlayerEntity)entity).func_146105_b(new StringTextComponent(Math.round((float)((<undefinedtype>)(new Object() {
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
            })).getEnergyStored(world, new BlockPos(x, y, z))) + " FE / " + "" + Math.round((float)((<undefinedtype>)(new Object() {
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
            })).getMaxEnergyStored(world, new BlockPos(x, y, z))) + " FE"), false);
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
            })).extractEnergySimulate(world, new BlockPos(x, y, z), 1000);
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
            TileEntity _ent = world.func_175625_s(new BlockPos(x, y, z));
            int _amount = (int)energy;
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

      }
   }
}
