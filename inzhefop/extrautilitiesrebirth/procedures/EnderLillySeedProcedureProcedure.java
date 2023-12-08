package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.EnderLillyStage1Block;
import java.util.HashMap;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Stream;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class EnderLillySeedProcedureProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure EnderLillySeedProcedure!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure EnderLillySeedProcedure!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure EnderLillySeedProcedure!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure EnderLillySeedProcedure!");
         }

      } else if (dependencies.get("itemstack") == null) {
         if (!dependencies.containsKey("itemstack")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency itemstack for procedure EnderLillySeedProcedure!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         ItemStack itemstack = (ItemStack)dependencies.get("itemstack");
         if (world.func_180495_p(new BlockPos(x, y, z)).func_177230_c() == Blocks.field_150377_bs) {
            itemstack.func_190918_g(1);
            world.func_180501_a(new BlockPos(x, y + 1.0D, z), EnderLillyStage1Block.block.func_176223_P(), 3);
            EnderLillyGrowProcedureProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("x", x), new SimpleEntry("y", y + 1.0D), new SimpleEntry("z", z)).collect(HashMap::new, (_m, _e) -> {
               _m.put(_e.getKey(), _e.getValue());
            }, Map::putAll));
         }

      }
   }
}
