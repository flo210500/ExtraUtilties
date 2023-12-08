package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.item.GlassCutterItem;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class GlassCutterRightclickedOnBlockProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure GlassCutterRightclickedOnBlock!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure GlassCutterRightclickedOnBlock!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure GlassCutterRightclickedOnBlock!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure GlassCutterRightclickedOnBlock!");
         }

      } else if (dependencies.get("blockstate") == null) {
         if (!dependencies.containsKey("blockstate")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency blockstate for procedure GlassCutterRightclickedOnBlock!");
         }

      } else if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure GlassCutterRightclickedOnBlock!");
         }

      } else if (dependencies.get("itemstack") == null) {
         if (!dependencies.containsKey("itemstack")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency itemstack for procedure GlassCutterRightclickedOnBlock!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         BlockState blockstate = (BlockState)dependencies.get("blockstate");
         Entity entity = (Entity)dependencies.get("entity");
         ItemStack itemstack = (ItemStack)dependencies.get("itemstack");
         if (blockstate.func_185904_a() == Material.field_151592_s) {
            world.func_180501_a(new BlockPos(x, y, z), Blocks.field_150350_a.func_176223_P(), 3);
            if (world instanceof World && !world.func_201670_d()) {
               ItemEntity entityToSpawn = new ItemEntity((World)world, x, y, z, new ItemStack(blockstate.func_177230_c()));
               entityToSpawn.func_174867_a(10);
               world.func_217376_c(entityToSpawn);
            }

            if (itemstack.func_96631_a(1, new Random(), (ServerPlayerEntity)null)) {
               itemstack.func_190918_g(1);
               itemstack.func_196085_b(0);
            }

            if (GlassCutterItem.block == itemstack.func_77973_b() && entity instanceof PlayerEntity) {
               ((PlayerEntity)entity).func_184811_cZ().func_185145_a(itemstack.func_77973_b(), 10);
            }
         }

      }
   }
}
