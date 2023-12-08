package inzhefop.extrautilitiesrebirth.procedures;

import com.google.common.collect.UnmodifiableIterator;
import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.EnderCoreBlock;
import inzhefop.extrautilitiesrebirth.block.EnderLillyStage1Block;
import inzhefop.extrautilitiesrebirth.block.EnderLillyStage2Block;
import inzhefop.extrautilitiesrebirth.block.EnderLillyStage3Block;
import inzhefop.extrautilitiesrebirth.block.EnderLillyStage4Block;
import inzhefop.extrautilitiesrebirth.block.EnderLillyStage5Block;
import inzhefop.extrautilitiesrebirth.block.EnderLillyStage6Block;
import inzhefop.extrautilitiesrebirth.block.EnderLillyStage7Block;
import inzhefop.extrautilitiesrebirth.block.EnderLillyStage8Block;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.block.BlockState;
import net.minecraft.state.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class EnderLillyGrowProcedureProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure EnderLillyGrowProcedure!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure EnderLillyGrowProcedure!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure EnderLillyGrowProcedure!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure EnderLillyGrowProcedure!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         double ireterations = 0.0D;
         ireterations = 1.0D;
         if (world.func_180495_p(new BlockPos(x, y - 1.0D, z)).func_177230_c() == EnderCoreBlock.block) {
            ireterations = 2.0D;
         }

         for(int index0 = 0; index0 < (int)ireterations; ++index0) {
            if (world.func_180495_p(new BlockPos(x, y, z)).func_177230_c() == EnderLillyStage7Block.block) {
               world.func_180501_a(new BlockPos(x, y, z), EnderLillyStage8Block.block.func_176223_P(), 3);
            }

            if (world.func_180495_p(new BlockPos(x, y, z)).func_177230_c() == EnderLillyStage6Block.block) {
               world.func_180501_a(new BlockPos(x, y, z), EnderLillyStage7Block.block.func_176223_P(), 3);
            }

            if (world.func_180495_p(new BlockPos(x, y, z)).func_177230_c() == EnderLillyStage5Block.block) {
               world.func_180501_a(new BlockPos(x, y, z), EnderLillyStage6Block.block.func_176223_P(), 3);
            }

            if (world.func_180495_p(new BlockPos(x, y, z)).func_177230_c() == EnderLillyStage4Block.block) {
               world.func_180501_a(new BlockPos(x, y, z), EnderLillyStage5Block.block.func_176223_P(), 3);
            }

            if (world.func_180495_p(new BlockPos(x, y, z)).func_177230_c() == EnderLillyStage3Block.block) {
               world.func_180501_a(new BlockPos(x, y, z), EnderLillyStage4Block.block.func_176223_P(), 3);
            }

            if (world.func_180495_p(new BlockPos(x, y, z)).func_177230_c() == EnderLillyStage2Block.block) {
               world.func_180501_a(new BlockPos(x, y, z), EnderLillyStage3Block.block.func_176223_P(), 3);
            }

            if (world.func_180495_p(new BlockPos(x, y, z)).func_177230_c() == EnderLillyStage1Block.block) {
               BlockPos _bp = new BlockPos(x, y, z);
               BlockState _bs = EnderLillyStage2Block.block.func_176223_P();
               BlockState _bso = world.func_180495_p(_bp);
               UnmodifiableIterator var14 = _bso.func_206871_b().entrySet().iterator();

               while(var14.hasNext()) {
                  Entry<Property<?>, Comparable<?>> entry = (Entry)var14.next();
                  Property _property = _bs.func_177230_c().func_176194_O().func_185920_a(((Property)entry.getKey()).func_177701_a());
                  if (_property != null && _bs.func_177229_b(_property) != null) {
                     try {
                        _bs = (BlockState)_bs.func_206870_a(_property, (Comparable)entry.getValue());
                     } catch (Exception var18) {
                     }
                  }
               }

               world.func_180501_a(_bp, _bs, 3);
            }
         }

      }
   }
}
