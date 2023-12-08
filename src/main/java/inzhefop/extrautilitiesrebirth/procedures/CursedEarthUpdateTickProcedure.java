package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.CursedEarthBlock;
import java.util.Map;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class CursedEarthUpdateTickProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure CursedEarthUpdateTick!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure CursedEarthUpdateTick!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure CursedEarthUpdateTick!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure CursedEarthUpdateTick!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         double entityrng = 0.0D;
         entityrng = Math.floor(Math.random() * 100.0D);
         if (entityrng == 1.0D) {
            if (world instanceof ServerWorld) {
               Entity entityToSpawn = new CreeperEntity(EntityType.field_200797_k, (World)world);
               entityToSpawn.func_70012_b(x, y + 1.0D, z, world.func_201674_k().nextFloat() * 360.0F, 0.0F);
               if (entityToSpawn instanceof MobEntity) {
                  ((MobEntity)entityToSpawn).func_213386_a((ServerWorld)world, world.func_175649_E(entityToSpawn.func_233580_cy_()), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
               }

               world.func_217376_c(entityToSpawn);
            }
         } else if (entityrng == 2.0D) {
            if (world instanceof ServerWorld) {
               Entity entityToSpawn = new BlazeEntity(EntityType.field_200792_f, (World)world);
               entityToSpawn.func_70012_b(x, y + 1.0D, z, world.func_201674_k().nextFloat() * 360.0F, 0.0F);
               if (entityToSpawn instanceof MobEntity) {
                  ((MobEntity)entityToSpawn).func_213386_a((ServerWorld)world, world.func_175649_E(entityToSpawn.func_233580_cy_()), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
               }

               world.func_217376_c(entityToSpawn);
            }
         } else if (entityrng == 3.0D) {
            if (world instanceof ServerWorld) {
               Entity entityToSpawn = new SpiderEntity(EntityType.field_200748_an, (World)world);
               entityToSpawn.func_70012_b(x, y + 1.0D, z, world.func_201674_k().nextFloat() * 360.0F, 0.0F);
               if (entityToSpawn instanceof MobEntity) {
                  ((MobEntity)entityToSpawn).func_213386_a((ServerWorld)world, world.func_175649_E(entityToSpawn.func_233580_cy_()), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
               }

               world.func_217376_c(entityToSpawn);
            }
         } else if (entityrng == 4.0D && world instanceof ServerWorld) {
            Entity entityToSpawn = new SkeletonEntity(EntityType.field_200741_ag, (World)world);
            entityToSpawn.func_70012_b(x, y + 1.0D, z, world.func_201674_k().nextFloat() * 360.0F, 0.0F);
            if (entityToSpawn instanceof MobEntity) {
               ((MobEntity)entityToSpawn).func_213386_a((ServerWorld)world, world.func_175649_E(entityToSpawn.func_233580_cy_()), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
            }

            world.func_217376_c(entityToSpawn);
         }

         if (10.0D > ((<undefinedtype>)(new Object() {
            public double getValue(IWorld world, BlockPos pos, String tag) {
               TileEntity tileEntity = world.func_175625_s(pos);
               return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
            }
         })).getValue(world, new BlockPos(x, y, z), "cycle")) {
            TileEntity _tileEntity;
            BlockState _bs;
            BlockPos _bp;
            if (!world.func_201670_d()) {
               _bp = new BlockPos(x, y, z);
               _tileEntity = world.func_175625_s(_bp);
               _bs = world.func_180495_p(_bp);
               if (_tileEntity != null) {
                  _tileEntity.getTileData().func_74780_a("cycle", ((<undefinedtype>)(new Object() {
                     public double getValue(IWorld world, BlockPos pos, String tag) {
                        TileEntity tileEntity = world.func_175625_s(pos);
                        return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                     }
                  })).getValue(world, new BlockPos(x, y, z), "cycle") + 1.0D);
               }

               if (world instanceof World) {
                  ((World)world).func_184138_a(_bp, _bs, _bs, 3);
               }
            }

            if (world.func_180495_p(new BlockPos(x + 1.0D, y, z)).func_177230_c() == Blocks.field_196658_i) {
               world.func_180501_a(new BlockPos(x + 1.0D, y, z), CursedEarthBlock.block.func_176223_P(), 3);
               if (!world.func_201670_d()) {
                  _bp = new BlockPos(x + 1.0D, y, z);
                  _tileEntity = world.func_175625_s(_bp);
                  _bs = world.func_180495_p(_bp);
                  if (_tileEntity != null) {
                     _tileEntity.getTileData().func_74780_a("cycle", ((<undefinedtype>)(new Object() {
                        public double getValue(IWorld world, BlockPos pos, String tag) {
                           TileEntity tileEntity = world.func_175625_s(pos);
                           return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                        }
                     })).getValue(world, new BlockPos(x, y, z), "cycle"));
                  }

                  if (world instanceof World) {
                     ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                  }
               }
            } else if (world.func_180495_p(new BlockPos(x - 1.0D, y, z)).func_177230_c() == Blocks.field_196658_i) {
               world.func_180501_a(new BlockPos(x - 1.0D, y, z), CursedEarthBlock.block.func_176223_P(), 3);
               if (!world.func_201670_d()) {
                  _bp = new BlockPos(x - 1.0D, y, z);
                  _tileEntity = world.func_175625_s(_bp);
                  _bs = world.func_180495_p(_bp);
                  if (_tileEntity != null) {
                     _tileEntity.getTileData().func_74780_a("cycle", ((<undefinedtype>)(new Object() {
                        public double getValue(IWorld world, BlockPos pos, String tag) {
                           TileEntity tileEntity = world.func_175625_s(pos);
                           return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                        }
                     })).getValue(world, new BlockPos(x, y, z), "cycle"));
                  }

                  if (world instanceof World) {
                     ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                  }
               }
            } else if (world.func_180495_p(new BlockPos(x, y, z + 1.0D)).func_177230_c() == Blocks.field_196658_i) {
               world.func_180501_a(new BlockPos(x, y, z + 1.0D), CursedEarthBlock.block.func_176223_P(), 3);
               if (!world.func_201670_d()) {
                  _bp = new BlockPos(x, y, z + 1.0D);
                  _tileEntity = world.func_175625_s(_bp);
                  _bs = world.func_180495_p(_bp);
                  if (_tileEntity != null) {
                     _tileEntity.getTileData().func_74780_a("cycle", ((<undefinedtype>)(new Object() {
                        public double getValue(IWorld world, BlockPos pos, String tag) {
                           TileEntity tileEntity = world.func_175625_s(pos);
                           return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                        }
                     })).getValue(world, new BlockPos(x, y, z), "cycle"));
                  }

                  if (world instanceof World) {
                     ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                  }
               }
            } else if (world.func_180495_p(new BlockPos(x, y, z - 1.0D)).func_177230_c() == Blocks.field_196658_i) {
               world.func_180501_a(new BlockPos(x, y, z - 1.0D), CursedEarthBlock.block.func_176223_P(), 3);
               if (!world.func_201670_d()) {
                  _bp = new BlockPos(x, y, z - 1.0D);
                  _tileEntity = world.func_175625_s(_bp);
                  _bs = world.func_180495_p(_bp);
                  if (_tileEntity != null) {
                     _tileEntity.getTileData().func_74780_a("cycle", ((<undefinedtype>)(new Object() {
                        public double getValue(IWorld world, BlockPos pos, String tag) {
                           TileEntity tileEntity = world.func_175625_s(pos);
                           return tileEntity != null ? tileEntity.getTileData().func_74769_h(tag) : -1.0D;
                        }
                     })).getValue(world, new BlockPos(x, y, z), "cycle"));
                  }

                  if (world instanceof World) {
                     ((World)world).func_184138_a(_bp, _bs, _bs, 3);
                  }
               }
            }
         }

      }
   }
}
