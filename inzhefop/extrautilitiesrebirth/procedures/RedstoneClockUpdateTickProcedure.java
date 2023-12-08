package inzhefop.extrautilitiesrebirth.procedures;

import com.google.common.collect.UnmodifiableIterator;
import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.RedstoneClockBlock;
import inzhefop.extrautilitiesrebirth.block.RedstoneClockOffBlock;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.Property;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class RedstoneClockUpdateTickProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure RedstoneClockUpdateTick!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure RedstoneClockUpdateTick!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure RedstoneClockUpdateTick!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure RedstoneClockUpdateTick!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         BlockPos _bp;
         TileEntity _tileEntity;
         BlockState _bs;
         if (!world.func_201670_d()) {
            _bp = new BlockPos(x, y, z);
            _tileEntity = world.func_175625_s(_bp);
            _bs = world.func_180495_p(_bp);
            if (_tileEntity != null) {
               _tileEntity.getTileData().func_74780_a("ticks", ((<undefinedtype>)(new Object() {
                  public double getValue(IWorld world, BlockPos pos, String tag) {
                     TileEntity tileEntity = world.func_175625_s(pos);
                     return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                  }
               })).getValue(world, new BlockPos(x, y, z), "ticks") + 1.0D);
            }

            if (world instanceof World) {
               ((World)world).func_184138_a(_bp, _bs, _bs, 3);
            }
         }

         if (((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "ticks") >= 18.0D) {
            UnmodifiableIterator var11;
            Entry entry;
            Property _property;
            BlockState _bs;
            TileEntity _te;
            CompoundNBT _bnbt;
            if (RedstoneClockBlock.block == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
               _bp = new BlockPos(x, y, z);
               _bs = RedstoneClockOffBlock.block.func_176223_P();
               _bs = world.func_180495_p(_bp);
               var11 = _bs.func_206871_b().entrySet().iterator();

               while(var11.hasNext()) {
                  entry = (Entry)var11.next();
                  _property = _bs.func_177230_c().func_176194_O().func_185920_a(((Property)entry.getKey()).func_177701_a());
                  if (_property != null && _bs.func_177229_b(_property) != null) {
                     try {
                        _bs = (BlockState)_bs.func_206870_a(_property, (Comparable)entry.getValue());
                     } catch (Exception var18) {
                     }
                  }
               }

               _te = world.func_175625_s(_bp);
               _bnbt = null;
               if (_te != null) {
                  _bnbt = _te.func_189515_b(new CompoundNBT());
                  _te.func_145843_s();
               }

               world.func_180501_a(_bp, _bs, 3);
               if (_bnbt != null) {
                  _te = world.func_175625_s(_bp);
                  if (_te != null) {
                     try {
                        _te.func_230337_a_(_bs, _bnbt);
                     } catch (Exception var17) {
                     }
                  }
               }
            } else {
               if (!world.func_201670_d()) {
                  _bp = new BlockPos(x, y, z);
                  _tileEntity = world.func_175625_s(_bp);
                  _bs = world.func_180495_p(_bp);
                  if (_tileEntity != null) {
                     _tileEntity.getTileData().func_74757_a("power", false);
                  }

                  if (world instanceof World) {
                     ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                  }
               }

               _bp = new BlockPos(x, y, z);
               _bs = RedstoneClockBlock.block.func_176223_P();
               _bs = world.func_180495_p(_bp);
               var11 = _bs.func_206871_b().entrySet().iterator();

               while(var11.hasNext()) {
                  entry = (Entry)var11.next();
                  _property = _bs.func_177230_c().func_176194_O().func_185920_a(((Property)entry.getKey()).func_177701_a());
                  if (_property != null && _bs.func_177229_b(_property) != null) {
                     try {
                        _bs = (BlockState)_bs.func_206870_a(_property, (Comparable)entry.getValue());
                     } catch (Exception var16) {
                     }
                  }
               }

               _te = world.func_175625_s(_bp);
               _bnbt = null;
               if (_te != null) {
                  _bnbt = _te.func_189515_b(new CompoundNBT());
                  _te.func_145843_s();
               }

               world.func_180501_a(_bp, _bs, 3);
               if (_bnbt != null) {
                  _te = world.func_175625_s(_bp);
                  if (_te != null) {
                     try {
                        _te.func_230337_a_(_bs, _bnbt);
                     } catch (Exception var15) {
                     }
                  }
               }
            }

            if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _tileEntity = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74780_a("ticks", 0.0D);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }
         }

      }
   }
}
