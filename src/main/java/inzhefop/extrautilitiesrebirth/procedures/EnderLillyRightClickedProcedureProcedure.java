package inzhefop.extrautilitiesrebirth.procedures;

import com.google.common.collect.UnmodifiableIterator;
import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.EnderLillyStage1Block;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EnderLillyRightClickedProcedureProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure EnderLillyRightClickedProcedure!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure EnderLillyRightClickedProcedure!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure EnderLillyRightClickedProcedure!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure EnderLillyRightClickedProcedure!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         BlockPos _bp = new BlockPos(x, y, z);
         BlockState _bs = EnderLillyStage1Block.block.func_176223_P();
         BlockState _bso = world.func_180495_p(_bp);
         UnmodifiableIterator var11 = _bso.func_206871_b().entrySet().iterator();

         while(var11.hasNext()) {
            Entry<Property<?>, Comparable<?>> entry = (Entry)var11.next();
            Property _property = _bs.func_177230_c().func_176194_O().func_185920_a(((Property)entry.getKey()).func_177701_a());
            if (_property != null && _bs.func_177229_b(_property) != null) {
               try {
                  _bs = (BlockState)_bs.func_206870_a(_property, (Comparable)entry.getValue());
               } catch (Exception var15) {
               }
            }
         }

         world.func_180501_a(_bp, _bs, 3);
         if (world instanceof World && !world.func_201670_d()) {
            ItemEntity entityToSpawn = new ItemEntity((World)world, x, y, z, new ItemStack(Items.field_151079_bi));
            entityToSpawn.func_174867_a(10);
            world.func_217376_c(entityToSpawn);
         }

      }
   }
}
