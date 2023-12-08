package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.DiamondSpikeBlock;
import inzhefop.extrautilitiesrebirth.block.GoldSpikeBlock;
import inzhefop.extrautilitiesrebirth.block.IronSpikeBlock;
import inzhefop.extrautilitiesrebirth.block.StoneSpikeBlock;
import inzhefop.extrautilitiesrebirth.block.WoodSpikeBlock;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class SpikesProcedureProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure SpikesProcedure!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure SpikesProcedure!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure SpikesProcedure!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure SpikesProcedure!");
         }

      } else if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure SpikesProcedure!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         Entity entity = (Entity)dependencies.get("entity");
         if (DiamondSpikeBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            entity.func_70097_a(DamageSource.field_76377_j, 12.0F);
         } else if (GoldSpikeBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            entity.func_70097_a(DamageSource.field_76377_j, 5.0F);
         } else if (IronSpikeBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            entity.func_70097_a(DamageSource.field_76377_j, 2.0F);
         } else if (WoodSpikeBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            entity.func_70097_a(DamageSource.field_76377_j, 0.5F);
         } else if (StoneSpikeBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            entity.func_70097_a(DamageSource.field_76377_j, 1.2F);
         }

      }
   }
}
