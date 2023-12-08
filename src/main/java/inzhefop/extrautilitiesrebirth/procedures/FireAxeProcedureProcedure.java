package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.HashMap;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Stream;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class FireAxeProcedureProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure FireAxeProcedure!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure FireAxeProcedure!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure FireAxeProcedure!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure FireAxeProcedure!");
         }

      } else if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure FireAxeProcedure!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         Entity entity = (Entity)dependencies.get("entity");
         double y_var = 0.0D;
         if (world.func_180495_p(new BlockPos(x, y, z)).func_185904_a() == Material.field_151575_d && world instanceof World) {
            Block.func_220075_c(world.func_180495_p(new BlockPos(x, y, z)), (World)world, new BlockPos(x, y, z));
            world.func_175655_b(new BlockPos(x, y, z), false);
         }

         y_var = -1.0D;

         for(int index0 = 0; index0 < 3; ++index0) {
            if (world.func_180495_p(new BlockPos(x, y + y_var, z)).func_185904_a() == Material.field_151575_d) {
               executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("entity", entity), new SimpleEntry("x", x), new SimpleEntry("y", y + y_var), new SimpleEntry("z", z)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
            }

            if (world.func_180495_p(new BlockPos(x + 1.0D, y + y_var, z)).func_185904_a() == Material.field_151575_d) {
               executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("entity", entity), new SimpleEntry("x", x + 1.0D), new SimpleEntry("y", y + y_var), new SimpleEntry("z", z)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
            }

            if (world.func_180495_p(new BlockPos(x - 1.0D, y + y_var, z)).func_185904_a() == Material.field_151575_d) {
               executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("entity", entity), new SimpleEntry("x", x - 1.0D), new SimpleEntry("y", y + y_var), new SimpleEntry("z", z)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
            }

            if (world.func_180495_p(new BlockPos(x + 1.0D, y + y_var, z + 1.0D)).func_185904_a() == Material.field_151575_d) {
               executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("entity", entity), new SimpleEntry("x", x + 1.0D), new SimpleEntry("y", y + y_var), new SimpleEntry("z", z + 1.0D)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
            }

            if (world.func_180495_p(new BlockPos(x + 1.0D, y + y_var, z - 1.0D)).func_185904_a() == Material.field_151575_d) {
               executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("entity", entity), new SimpleEntry("x", x + 1.0D), new SimpleEntry("y", y + y_var), new SimpleEntry("z", z - 1.0D)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
            }

            if (world.func_180495_p(new BlockPos(x - 1.0D, y + y_var, z + 1.0D)).func_185904_a() == Material.field_151575_d) {
               executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("entity", entity), new SimpleEntry("x", x - 1.0D), new SimpleEntry("y", y + y_var), new SimpleEntry("z", z + 1.0D)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
            }

            if (world.func_180495_p(new BlockPos(x - 1.0D, y + y_var, z - 1.0D)).func_185904_a() == Material.field_151575_d) {
               executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("entity", entity), new SimpleEntry("x", x - 1.0D), new SimpleEntry("y", y + y_var), new SimpleEntry("z", z - 1.0D)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
            }

            if (world.func_180495_p(new BlockPos(x, y + y_var, z - 1.0D)).func_185904_a() == Material.field_151575_d) {
               executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("entity", entity), new SimpleEntry("x", x), new SimpleEntry("y", y + y_var), new SimpleEntry("z", z - 1.0D)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
            }

            if (world.func_180495_p(new BlockPos(x, y + y_var, z + 1.0D)).func_185904_a() == Material.field_151575_d) {
               executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("entity", entity), new SimpleEntry("x", x), new SimpleEntry("y", y + y_var), new SimpleEntry("z", z + 1.0D)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
            }

            ++y_var;
         }

      }
   }
}
