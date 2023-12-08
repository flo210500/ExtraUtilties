package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IWorld;

public class RainbowGeneratorOnBlockRightClickedProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure RainbowGeneratorOnBlockRightClicked!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure RainbowGeneratorOnBlockRightClicked!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure RainbowGeneratorOnBlockRightClicked!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure RainbowGeneratorOnBlockRightClicked!");
         }

      } else if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure RainbowGeneratorOnBlockRightClicked!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         Entity entity = (Entity)dependencies.get("entity");
         if (((<undefinedtype>)(new Object() {
            public boolean getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
            }
         })).getValue(world, new BlockPos(x, y, z), "rgb_running")) {
            if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§l§fRainbow Generator - State: §aRunning§f - Operating at 25 MFE/t"), true);
            }
         } else {
            if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§l§fRainbow Generator - State: §eIdle"), false);
            }

            if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§n§c[" + ((<undefinedtype>)(new Object() {
                  public String getValue(IWorld world, BlockPos pos, String tag) {
                     TileEntity tileEntity = world.func_175625_s(pos);
                     return tileEntity != null ? tileEntity.getTileData().func_74779_i(tag) : "";
                  }
               })).getValue(world, new BlockPos(x, y, z), "running_gen") + "/16] Missing Generators:"), false);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "culinary_machine") && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§7- Culinary Generator"), false);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "death_machine") && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§f- Death Generator"), false);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "disenchantment_machine") && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§7- Disenchantment Generator"), false);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "ender_machine") && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§f- Ender Generator"), false);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "tnt_machine") && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§7- TNT Generator"), false);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "frosty_machine") && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§f- Frosty Generator"), false);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "furnace_machine") && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§7- Furnace Generator"), false);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "halitosis_machine") && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§f- Halitosis Generator"), false);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "neatherstar_machine") && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§7- Neatherstar Generator"), false);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "overclocked_machine") && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§f- Overclocked Generator"), false);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "pink_machine") && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§7- Pink Generator"), false);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "potion_machine") && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§f- Potion Generator"), false);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "slimey_machine") && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§7- Slimey Generator"), false);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "survival_machine") && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§f- Survival Generator"), false);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "redstone_machine") && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§7- Redstone Generator"), false);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(IWorld world, BlockPos pos, String tag) {
                  TileEntity tileEntity = world.func_175625_s(pos);
                  return tileEntity != null ? tileEntity.getTileData().func_74767_n(tag) : false;
               }
            })).getValue(world, new BlockPos(x, y, z), "magma_machine") && entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("§f- Magma Generator"), false);
            }
         }

      }
   }
}
