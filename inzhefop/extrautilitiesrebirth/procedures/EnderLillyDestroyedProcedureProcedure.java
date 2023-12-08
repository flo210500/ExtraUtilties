package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.EnderLillyStage1Block;
import java.util.Map;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EnderLillyDestroyedProcedureProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure EnderLillyDestroyedProcedure!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure EnderLillyDestroyedProcedure!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure EnderLillyDestroyedProcedure!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure EnderLillyDestroyedProcedure!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         ItemEntity entityToSpawn;
         if (world instanceof World && !world.func_201670_d()) {
            entityToSpawn = new ItemEntity((World)world, x, y, z, new ItemStack(Items.field_151079_bi));
            entityToSpawn.func_174867_a(10);
            world.func_217376_c(entityToSpawn);
         }

         if (world instanceof World && !world.func_201670_d()) {
            entityToSpawn = new ItemEntity((World)world, x, y, z, new ItemStack(EnderLillyStage1Block.block));
            entityToSpawn.func_174867_a(10);
            world.func_217376_c(entityToSpawn);
         }

      }
   }
}
