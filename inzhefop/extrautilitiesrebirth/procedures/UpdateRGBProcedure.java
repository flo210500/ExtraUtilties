package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.CulinaryGeneratorBlock;
import inzhefop.extrautilitiesrebirth.block.DeathGeneratorBlock;
import inzhefop.extrautilitiesrebirth.block.DisenchantmentGeneratorBlock;
import inzhefop.extrautilitiesrebirth.block.EnderGeneratorBlock;
import inzhefop.extrautilitiesrebirth.block.FrostyGenerator1Block;
import inzhefop.extrautilitiesrebirth.block.FurnaceGeneratorBlock;
import inzhefop.extrautilitiesrebirth.block.HalitosisGeneratorBlock;
import inzhefop.extrautilitiesrebirth.block.MagmaGeneratorBlock;
import inzhefop.extrautilitiesrebirth.block.NetherstarGeneratorBlock;
import inzhefop.extrautilitiesrebirth.block.OverclockedGeneratorBlock;
import inzhefop.extrautilitiesrebirth.block.PinkGeneratorBlock;
import inzhefop.extrautilitiesrebirth.block.PotionGenerator1Block;
import inzhefop.extrautilitiesrebirth.block.RainbowGeneratorBlock;
import inzhefop.extrautilitiesrebirth.block.RedstoneGeneratorBlock;
import inzhefop.extrautilitiesrebirth.block.SlimeyGeneratorBlock;
import inzhefop.extrautilitiesrebirth.block.SurvivalGeneratorBlock;
import inzhefop.extrautilitiesrebirth.block.TNTGeneratorBlock;
import java.util.Map;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class UpdateRGBProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure UpdateRGB!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure UpdateRGB!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure UpdateRGB!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure UpdateRGB!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         double rgb_x_loc = 0.0D;
         double RGB_y_loc = 0.0D;
         double RGB_z_loc = 0.0D;
         String generator_string = "";
         if (CulinaryGeneratorBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            generator_string = "culinary";
         } else if (DeathGeneratorBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            generator_string = "death";
         } else if (DisenchantmentGeneratorBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            generator_string = "disenchantment";
         } else if (EnderGeneratorBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            generator_string = "ender";
         } else if (TNTGeneratorBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            generator_string = "tnt";
         } else if (FrostyGenerator1Block.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            generator_string = "frosty";
         } else if (FurnaceGeneratorBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            generator_string = "furnace";
         } else if (HalitosisGeneratorBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            generator_string = "halitosis";
         } else if (NetherstarGeneratorBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            generator_string = "neatherstar";
         } else if (OverclockedGeneratorBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            generator_string = "overclocked";
         } else if (PinkGeneratorBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            generator_string = "pink";
         } else if (PotionGenerator1Block.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            generator_string = "potion";
         } else if (SlimeyGeneratorBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            generator_string = "slimey";
         } else if (SurvivalGeneratorBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            generator_string = "survival";
         } else if (RedstoneGeneratorBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            generator_string = "redstone";
         } else if (MagmaGeneratorBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            generator_string = "magma";
         }

         rgb_x_loc = ((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "rbg_x");
         RGB_y_loc = ((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "rbg_y");
         RGB_z_loc = ((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "rbg_z");
         if (RainbowGeneratorBlock.block == world.func_180495_p(new BlockPos(rgb_x_loc, RGB_y_loc, RGB_z_loc)).func_177230_c() && !world.func_201670_d()) {
            BlockPos _bp = new BlockPos(rgb_x_loc, RGB_y_loc, RGB_z_loc);
            TileEntity _tileEntity = world.func_175625_s(_bp);
            BlockState _bs = world.func_180495_p(_bp);
            if (_tileEntity != null) {
               _tileEntity.getTileData().func_74780_a(generator_string, ((<undefinedtype>)(new Object() {
                  public double getValue(IWorld world, BlockPos pos, String tag) {
                     TileEntity tileEntity = world.func_175625_s(pos);
                     return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                  }
               })).getValue(world, new BlockPos(rgb_x_loc, RGB_y_loc, RGB_z_loc), generator_string) + 1.0D);
            }

            if (world instanceof World) {
               ((World)world).func_184138_a(_bp, _bs, _bs, 3);
            }
         }

      }
   }
}
