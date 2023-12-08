package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.HashMap;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Stream;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class FireAxeBlockDestroyedWithToolProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure FireAxeBlockDestroyedWithTool!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure FireAxeBlockDestroyedWithTool!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure FireAxeBlockDestroyedWithTool!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure FireAxeBlockDestroyedWithTool!");
         }

      } else if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure FireAxeBlockDestroyedWithTool!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         Entity entity = (Entity)dependencies.get("entity");
         if (world.func_180495_p(new BlockPos(x, y, z)).func_185904_a() == Material.field_151575_d) {
            if (world.func_180495_p(new BlockPos(x, y + 1.0D, z)).func_185904_a() == Material.field_151575_d) {
               FireAxeProcedureProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("entity", entity), new SimpleEntry("x", x), new SimpleEntry("y", y + 1.0D), new SimpleEntry("z", z)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
            }

            if (world.func_180495_p(new BlockPos(x, y - 1.0D, z)).func_185904_a() == Material.field_151575_d) {
               FireAxeProcedureProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("entity", entity), new SimpleEntry("x", x), new SimpleEntry("y", y - 1.0D), new SimpleEntry("z", z)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
            }

            if (world.func_180495_p(new BlockPos(x + 1.0D, y, z)).func_185904_a() == Material.field_151575_d) {
               FireAxeProcedureProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("entity", entity), new SimpleEntry("x", x + 1.0D), new SimpleEntry("y", y), new SimpleEntry("z", z)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
            }

            if (world.func_180495_p(new BlockPos(x - 1.0D, y, z)).func_185904_a() == Material.field_151575_d) {
               FireAxeProcedureProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("entity", entity), new SimpleEntry("x", x - 1.0D), new SimpleEntry("y", y), new SimpleEntry("z", z)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
            }

            if (world.func_180495_p(new BlockPos(x, y, z - 1.0D)).func_185904_a() == Material.field_151575_d) {
               FireAxeProcedureProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("entity", entity), new SimpleEntry("x", x), new SimpleEntry("y", y), new SimpleEntry("z", z - 1.0D)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
            }

            if (world.func_180495_p(new BlockPos(x, y, z + 1.0D)).func_185904_a() == Material.field_151575_d) {
               FireAxeProcedureProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("entity", entity), new SimpleEntry("x", x), new SimpleEntry("y", y), new SimpleEntry("z", z + 1.0D)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
            }
         }

      }
   }
}
