package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.SolarPanelBlock;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;

public class SolarPanelUpdateTickProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure SolarPanelUpdateTick!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure SolarPanelUpdateTick!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure SolarPanelUpdateTick!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure SolarPanelUpdateTick!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         double energy = 0.0D;
         TileEntity _ent;
         if (world.func_175710_j(new BlockPos(x, y, z)) && world instanceof World && ((World)world).func_72935_r()) {
            _ent = world.func_175625_s(new BlockPos(x, y, z));
            int _amount = 10;
            if (_ent != null) {
               _ent.getCapability(CapabilityEnergy.ENERGY, (Direction)null).ifPresent((capability) -> {
                  capability.receiveEnergy(_amount, false);
               });
            }
         }

         int _amount;
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
            })).extractEnergySimulate(world, new BlockPos(x, y, z), 100000);
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

         if (SolarPanelBlock.block == world.func_180495_p(new BlockPos(x + 1.0D, y, z)).func_177230_c() && ((<undefinedtype>)(new Object() {
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
            })).extractEnergySimulate(world, new BlockPos(x, y, z), 100000);
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
               _ent.getCapability(CapabilityEnergy.ENERGY, Direction.UP).ifPresent((capability) -> {
                  capability.receiveEnergy(_amount, false);
               });
            }
         }

         if (SolarPanelBlock.block == world.func_180495_p(new BlockPos(x, y, z + 1.0D)).func_177230_c() && ((<undefinedtype>)(new Object() {
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
            })).extractEnergySimulate(world, new BlockPos(x, y, z), 100000);
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
               _ent.getCapability(CapabilityEnergy.ENERGY, Direction.UP).ifPresent((capability) -> {
                  capability.receiveEnergy(_amount, false);
               });
            }
         }

      }
   }
}
