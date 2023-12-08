package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.energy.CapabilityEnergy;

public class GUITestProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure GUITest!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure GUITest!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure GUITest!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure GUITest!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         double power = 0.0D;
         boolean cross = false;
         power = (double)((<undefinedtype>)(new Object() {
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
         })).getEnergyStored(world, new BlockPos(x, y, z)) / 333.33D;
         ((<undefinedtype>)(new Object() {
            public boolean getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
            }
         })).getValue(world, new BlockPos(x, y, z), "valid");
      }
   }
}
