package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.Map;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class ChunkWandOnRightClickProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure ChunkWandOnRightClick!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure ChunkWandOnRightClick!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure ChunkWandOnRightClick!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure ChunkWandOnRightClick!");
         }

      } else if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure ChunkWandOnRightClick!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         Entity entity = (Entity)dependencies.get("entity");
         if (Items.field_151079_bi == (entity instanceof LivingEntity ? ((LivingEntity)entity).func_184614_ca() : ItemStack.field_190927_a).func_77973_b()) {
            if (!world.func_201670_d()) {
               BlockPos _bp = new BlockPos(x, y, z);
               TileEntity _tileEntity = world.func_175625_s(_bp);
               BlockState _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74780_a("load", ((<undefinedtype>)(new Object() {
                     public double getValue(IWorld world, BlockPos pos, String tag) {
                        TileEntity tileEntity = world.func_175625_s(pos);
                        return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                     }
                  })).getValue(world, new BlockPos(x, y, z), "load") + 1.0D);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }

            (entity instanceof LivingEntity ? ((LivingEntity)entity).func_184614_ca() : ItemStack.field_190927_a).func_190918_g(1);
         } else if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
            ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Insert Enderpearls to load the current chunk"), false);
         }

         if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
            ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Remaining Time: " + Math.round(((<undefinedtype>)(new Object() {
               public double getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
               }
            })).getValue(world, new BlockPos(x, y, z), "load") / 1200.0D) + " min"), false);
         }

      }
   }
}
