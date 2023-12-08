package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.energy.CapabilityEnergy;

public class TestProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure Test!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure Test!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure Test!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure Test!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         double fdf = 0.0D;
         double energy = 0.0D;
         fdf = ((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "progress") * 22.0D / ((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "progresstime");
         if (fdf > 22.0D) {
            fdf = 22.0D;
         }

         energy = (double)(((<undefinedtype>)(new Object() {
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
         })).getEnergyStored(world, new BlockPos(x, y, z)) * 70 / ((<undefinedtype>)(new Object() {
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
         })).getMaxEnergyStored(world, new BlockPos(x, y, z)));
      }
   }
}
