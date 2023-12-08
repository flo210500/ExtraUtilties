package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.Map;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.Direction.AxisDirection;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class Sorterchest1returnProcedure {
   public static boolean executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure Sorterchest1return!");
         }

         return false;
      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure Sorterchest1return!");
         }

         return false;
      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure Sorterchest1return!");
         }

         return false;
      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure Sorterchest1return!");
         }

         return false;
      } else {
         final IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         ItemStack storeditem = ItemStack.field_190927_a;
         BlockState targetblock = Blocks.field_150350_a.func_176223_P();
         double target_x = 0.0D;
         double target_y = 0.0D;
         double target_z = 0.0D;
         double multiplier = 0.0D;
         double slotnumber = 0.0D;
         if (Direction.NORTH == ((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockPos pos) {
               try {
                  BlockState _bs = world.func_180495_p(pos);
                  DirectionProperty property = (DirectionProperty)_bs.func_177230_c().func_176194_O().func_185920_a("facing");
                  return property != null ? (Direction)_bs.func_177229_b(property) : Direction.func_211699_a((Axis)_bs.func_177229_b((EnumProperty)_bs.func_177230_c().func_176194_O().func_185920_a("axis")), AxisDirection.POSITIVE);
               } catch (Exception var4) {
                  return Direction.NORTH;
               }
            }
         })).getDirection(new BlockPos(x, y, z))) {
            world.func_180495_p(new BlockPos(x + 1.0D, y, z));
            target_x = x + 1.0D;
            target_y = y;
            target_z = z;
         } else if (Direction.WEST == ((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockPos pos) {
               try {
                  BlockState _bs = world.func_180495_p(pos);
                  DirectionProperty property = (DirectionProperty)_bs.func_177230_c().func_176194_O().func_185920_a("facing");
                  return property != null ? (Direction)_bs.func_177229_b(property) : Direction.func_211699_a((Axis)_bs.func_177229_b((EnumProperty)_bs.func_177230_c().func_176194_O().func_185920_a("axis")), AxisDirection.POSITIVE);
               } catch (Exception var4) {
                  return Direction.NORTH;
               }
            }
         })).getDirection(new BlockPos(x, y, z))) {
            world.func_180495_p(new BlockPos(x, y, z - 1.0D));
            target_x = x;
            target_y = y;
            target_z = z - 1.0D;
         } else if (Direction.EAST == ((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockPos pos) {
               try {
                  BlockState _bs = world.func_180495_p(pos);
                  DirectionProperty property = (DirectionProperty)_bs.func_177230_c().func_176194_O().func_185920_a("facing");
                  return property != null ? (Direction)_bs.func_177229_b(property) : Direction.func_211699_a((Axis)_bs.func_177229_b((EnumProperty)_bs.func_177230_c().func_176194_O().func_185920_a("axis")), AxisDirection.POSITIVE);
               } catch (Exception var4) {
                  return Direction.NORTH;
               }
            }
         })).getDirection(new BlockPos(x, y, z))) {
            world.func_180495_p(new BlockPos(x, y, z + 1.0D));
            target_x = x;
            target_y = y;
            target_z = z + 1.0D;
         } else if (Direction.SOUTH == ((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockPos pos) {
               try {
                  BlockState _bs = world.func_180495_p(pos);
                  DirectionProperty property = (DirectionProperty)_bs.func_177230_c().func_176194_O().func_185920_a("facing");
                  return property != null ? (Direction)_bs.func_177229_b(property) : Direction.func_211699_a((Axis)_bs.func_177229_b((EnumProperty)_bs.func_177230_c().func_176194_O().func_185920_a("axis")), AxisDirection.POSITIVE);
               } catch (Exception var4) {
                  return Direction.NORTH;
               }
            }
         })).getDirection(new BlockPos(x, y, z))) {
            world.func_180495_p(new BlockPos(x - 1.0D, y, z));
            target_x = x - 1.0D;
            target_y = y;
            target_z = z;
         }

         return !(((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos) {
               TileEntity tileEntity = world.func_175625_s(pos);
               double slots = 0.0D;
               if (tileEntity instanceof IInventory) {
                  slots = (double)((IInventory)tileEntity).func_70302_i_();
               }

               return slots;
            }
         })).getValue(world, new BlockPos((int)target_x, (int)target_y, (int)target_z)) > 0.0D);
      }
   }
}
