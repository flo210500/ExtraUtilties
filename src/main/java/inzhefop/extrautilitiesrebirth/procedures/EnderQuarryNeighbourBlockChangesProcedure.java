package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.EnderQuarrySilkTouchUpgrade2Block;
import inzhefop.extrautilitiesrebirth.block.EnderQuarrySilkTouchUpgrade3Block;
import inzhefop.extrautilitiesrebirth.block.EnderQuarrySilkTouchUpgradeBlock;
import inzhefop.extrautilitiesrebirth.block.EnderQuarrySpeedUpgradeBlock;
import inzhefop.extrautilitiesrebirth.block.EnderQuarryWorldHoleUpgradeBlock;
import java.util.Map;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EnderQuarryNeighbourBlockChangesProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure EnderQuarryNeighbourBlockChanges!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure EnderQuarryNeighbourBlockChanges!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure EnderQuarryNeighbourBlockChanges!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure EnderQuarryNeighbourBlockChanges!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         boolean silk = false;
         boolean hole = false;
         boolean rain = false;
         double fortune = 0.0D;
         double zblock = 0.0D;
         double counter1 = 0.0D;
         double yblock = 0.0D;
         double xblock = 0.0D;
         double powerdrain = 0.0D;
         double speed = 0.0D;
         powerdrain = 260.0D;
         speed = 1.0D;
         fortune = 1.0D;

         for(int index0 = 0; index0 < 6; ++index0) {
            if (counter1 == 0.0D) {
               xblock = x;
               yblock = y + 1.0D;
               zblock = z;
            }

            if (counter1 == 1.0D) {
               xblock = x;
               yblock = y - 1.0D;
               zblock = z;
            }

            if (counter1 == 2.0D) {
               xblock = x + 1.0D;
               yblock = y;
               zblock = z;
            }

            if (counter1 == 3.0D) {
               xblock = x - 1.0D;
               yblock = y;
               zblock = z;
            }

            if (counter1 == 4.0D) {
               xblock = x;
               yblock = y;
               zblock = z + 1.0D;
            }

            if (counter1 == 5.0D) {
               xblock = x;
               yblock = y;
               zblock = z - 1.0D;
            }

            if (EnderQuarrySilkTouchUpgrade3Block.block == world.func_180495_p(new BlockPos(xblock, yblock, zblock)).func_177230_c()) {
               speed *= 2.72D;
               powerdrain *= 2.0D;
            }

            if (EnderQuarrySilkTouchUpgrade2Block.block == world.func_180495_p(new BlockPos(xblock, yblock, zblock)).func_177230_c()) {
               speed *= 2.15D;
               powerdrain *= 1.5D;
            }

            if (EnderQuarrySpeedUpgradeBlock.block == world.func_180495_p(new BlockPos(xblock, yblock, zblock)).func_177230_c()) {
               speed *= 1.71D;
               powerdrain *= 1.0D;
            }

            if (EnderQuarrySilkTouchUpgradeBlock.block == world.func_180495_p(new BlockPos(xblock, yblock, zblock)).func_177230_c()) {
               silk = true;
               powerdrain *= 1.5D;
            }

            if (EnderQuarryWorldHoleUpgradeBlock.block == world.func_180495_p(new BlockPos(xblock, yblock, zblock)).func_177230_c()) {
               hole = true;
               powerdrain *= 1.0D;
            }

            ++counter1;
         }

         TileEntity _tileEntity;
         BlockState _bs;
         BlockPos _bp;
         if (!world.func_201670_d()) {
            _bp = new BlockPos(x, y, z);
            _tileEntity = world.func_175625_s(_bp);
            _bs = world.func_180495_p(_bp);
            if (_tileEntity != null) {
               _tileEntity.getTileData().func_74780_a("eqspeed", (double)Math.round(speed));
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
               _tileEntity.getTileData().func_74780_a("eqfortune", (double)Math.round(fortune));
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
               _tileEntity.getTileData().func_74780_a("eqpowerdrain", (double)Math.round(powerdrain * 1.0D));
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
               _tileEntity.getTileData().func_74757_a("eqhole", hole);
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
               _tileEntity.getTileData().func_74757_a("eqsilk", silk);
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
               _tileEntity.getTileData().func_74757_a("eqrainbow", rain);
            }

            if (world instanceof World) {
               ((World)world).func_184138_a(_bp, _bs, _bs, 3);
            }
         }

      }
   }
}
