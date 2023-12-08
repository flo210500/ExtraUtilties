package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.EnderQuarryBlock;
import java.util.Map;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class FortuneConditionProcedure {
   public static boolean executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure FortuneCondition!");
         }

         return false;
      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure FortuneCondition!");
         }

         return false;
      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure FortuneCondition!");
         }

         return false;
      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure FortuneCondition!");
         }

         return false;
      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         double zblock = 0.0D;
         double counter1 = 0.0D;
         double yblock = 0.0D;
         double xblock = 0.0D;

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

            if (EnderQuarryBlock.block == world.func_180495_p(new BlockPos(xblock, yblock, zblock)).func_177230_c() && ((<undefinedtype>)(new Object() {
               public double getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
               }
            })).getValue(world, new BlockPos(xblock, yblock, zblock), "fortune") != 0.0D) {
               return true;
            }

            ++counter1;
         }

         return false;
      }
   }
}
