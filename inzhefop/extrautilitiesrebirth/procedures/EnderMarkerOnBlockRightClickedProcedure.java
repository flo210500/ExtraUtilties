package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.EnderMarkerBlock;
import java.util.Map;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EnderMarkerOnBlockRightClickedProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure EnderMarkerOnBlockRightClicked!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure EnderMarkerOnBlockRightClicked!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure EnderMarkerOnBlockRightClicked!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure EnderMarkerOnBlockRightClicked!");
         }

      } else if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure EnderMarkerOnBlockRightClicked!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         Entity entity = (Entity)dependencies.get("entity");
         double x_axe = 0.0D;
         double seconddirec = 0.0D;
         double scansize = 0.0D;
         double maxz = 0.0D;
         double maxx = 0.0D;
         double z_axe = 0.0D;
         double firstdirec = 0.0D;
         double minx = 0.0D;
         double minz = 0.0D;
         boolean south = false;
         boolean north = false;
         boolean east = false;
         boolean west = false;
         boolean complete = false;
         scansize = 512.0D;
         z_axe = 0.0D;
         north = false;
         east = false;
         south = false;
         west = false;
         minz = z - 1.0D;

         int index3;
         for(index3 = 0; index3 < (int)scansize; ++index3) {
            --z_axe;
            if (EnderMarkerBlock.block == world.func_180495_p(new BlockPos(x, y, z + z_axe)).func_177230_c()) {
               maxz = z + z_axe + 1.0D;
               north = true;
               firstdirec = 1.0D;
               break;
            }
         }

         x_axe = 0.0D;
         minx = x - 1.0D;

         for(index3 = 0; index3 < (int)scansize; ++index3) {
            --x_axe;
            if (EnderMarkerBlock.block == world.func_180495_p(new BlockPos(x + x_axe, y, z)).func_177230_c()) {
               maxx = x + x_axe + 1.0D;
               seconddirec = 4.0D;
               west = true;
               break;
            }
         }

         if (!north) {
            z_axe = 0.0D;
            minz = z + 1.0D;

            for(index3 = 0; index3 < (int)scansize; ++index3) {
               ++z_axe;
               if (EnderMarkerBlock.block == world.func_180495_p(new BlockPos(x, y, z + z_axe)).func_177230_c()) {
                  south = true;
                  maxz = z + z_axe - 1.0D;
                  firstdirec = 3.0D;
                  break;
               }
            }
         }

         if (!west) {
            x_axe = 0.0D;
            minx = x + 1.0D;

            for(index3 = 0; index3 < (int)scansize; ++index3) {
               ++x_axe;
               if (EnderMarkerBlock.block == world.func_180495_p(new BlockPos(x + x_axe, y, z)).func_177230_c()) {
                  east = true;
                  maxx = x + x_axe - 1.0D;
                  seconddirec = 2.0D;
                  break;
               }
            }
         }

         if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
            ((PlayerEntity)entity).func_146105_b(new StringTextComponent("==== Scanning (Radius: " + Math.round(scansize) + ") ===="), false);
         }

         if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
            ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Marker [1] at " + x + "" + " " + y + "" + " " + z), false);
         }

         if (!north && !south) {
            if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Missing Marker [2]"), false);
            }
         } else if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
            ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Marker [2] at " + x + "" + " " + y + "" + " " + (z + z_axe)), false);
         }

         if (!east && !west) {
            if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Missing Marker [3]"), false);
            }
         } else if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
            ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Marker [3] at " + (x + x_axe) + "" + " " + y + "" + " " + z), false);
         }

         if ((north || south) && (east || west)) {
            if (EnderMarkerBlock.block == world.func_180495_p(new BlockPos(x + x_axe, y, z + z_axe)).func_177230_c()) {
               if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
                  ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Marker [4] at " + (x + x_axe) + "" + " " + y + "" + " " + (z + z_axe)), false);
               }

               complete = true;
            } else if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Missing Marker [4] at " + (x + x_axe) + "" + " " + y + "" + " " + (z + z_axe)), false);
            }
         } else if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
            ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Missing Marker [4]"), false);
         }

         TileEntity _tileEntity;
         BlockState _bs;
         BlockPos _bp;
         if (complete) {
            if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("State: §aComplete"), false);
            }

            if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _tileEntity = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74757_a("complete", true);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }

            if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _tileEntity = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74780_a("minx", minx);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }

            if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _tileEntity = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74780_a("minz", minz);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }

            if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _tileEntity = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74780_a("maxx", maxx);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }

            if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _tileEntity = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74780_a("maxz", maxz);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }

            if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _tileEntity = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74780_a("direc1", firstdirec);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }

            if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _tileEntity = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74780_a("direc2", seconddirec);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }
         } else {
            if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("State: §cMissing Markers"), false);
            }

            if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _tileEntity = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74757_a("complete", false);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }
         }

      }
   }
}
