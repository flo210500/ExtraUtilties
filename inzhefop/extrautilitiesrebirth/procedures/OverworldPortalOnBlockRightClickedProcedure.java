package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModVariables;
import inzhefop.extrautilitiesrebirth.item.PortableGlobeItem;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.server.ServerWorld;

public class OverworldPortalOnBlockRightClickedProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure OverworldPortalOnBlockRightClicked!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure OverworldPortalOnBlockRightClicked!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure OverworldPortalOnBlockRightClicked!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure OverworldPortalOnBlockRightClicked!");
         }

      } else if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure OverworldPortalOnBlockRightClicked!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         Entity entity = (Entity)dependencies.get("entity");
         if (World.field_234918_g_ == (world instanceof World ? ((World)world).func_234923_W_() : World.field_234918_g_)) {
            entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.overworld_portal_x = x;
               capability.syncPlayerVariables(entity);
            });
            double _setval = y + 1.0D;
            entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.overworld_portal_y = _setval;
               capability.syncPlayerVariables(entity);
            });
            entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.overworld_portal_z = z;
               capability.syncPlayerVariables(entity);
            });
            if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
               ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Set overworld-return-position"), false);
            }
         }

         if (World.field_234918_g_ != (world instanceof World ? ((World)world).func_234923_W_() : World.field_234918_g_)) {
            Entity _ent = entity;
            if (!entity.field_70170_p.field_72995_K && entity instanceof ServerPlayerEntity) {
               RegistryKey<World> destinationType = World.field_234918_g_;
               ServerWorld nextWorld = entity.func_184102_h().func_71218_a(destinationType);
               if (nextWorld != null) {
                  ((ServerPlayerEntity)entity).field_71135_a.func_147359_a(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0.0F));
                  ((ServerPlayerEntity)entity).func_200619_a(nextWorld, (double)nextWorld.func_241135_u_().func_177958_n(), (double)(nextWorld.func_241135_u_().func_177956_o() + 1), (double)nextWorld.func_241135_u_().func_177952_p(), entity.field_70177_z, entity.field_70125_A);
                  ((ServerPlayerEntity)entity).field_71135_a.func_147359_a(new SPlayerAbilitiesPacket(((ServerPlayerEntity)entity).field_71075_bZ));
                  Iterator var12 = ((ServerPlayerEntity)entity).func_70651_bq().iterator();

                  while(var12.hasNext()) {
                     EffectInstance effectinstance = (EffectInstance)var12.next();
                     ((ServerPlayerEntity)_ent).field_71135_a.func_147359_a(new SPlayEntityEffectPacket(_ent.func_145782_y(), effectinstance));
                  }

                  ((ServerPlayerEntity)_ent).field_71135_a.func_147359_a(new SPlaySoundEventPacket(1032, BlockPos.field_177992_a, 0, false));
               }
            }

            if (!(((ExtrautilitiesrebirthModVariables.PlayerVariables)entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).overworld_portal_y <= 0.0D)) {
               entity.func_70634_a(((ExtrautilitiesrebirthModVariables.PlayerVariables)entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).overworld_portal_x + 0.5D, ((ExtrautilitiesrebirthModVariables.PlayerVariables)entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).overworld_portal_y + 0.5D, ((ExtrautilitiesrebirthModVariables.PlayerVariables)entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).overworld_portal_z + 0.5D);
               if (entity instanceof ServerPlayerEntity) {
                  ((ServerPlayerEntity)entity).field_71135_a.func_175089_a(((ExtrautilitiesrebirthModVariables.PlayerVariables)entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).overworld_portal_x + 0.5D, ((ExtrautilitiesrebirthModVariables.PlayerVariables)entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).overworld_portal_y + 0.5D, ((ExtrautilitiesrebirthModVariables.PlayerVariables)entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).overworld_portal_z + 0.5D, entity.field_70177_z, entity.field_70125_A, Collections.emptySet());
               }
            } else {
               entity.func_70634_a(((ExtrautilitiesrebirthModVariables.PlayerVariables)entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).overworld_portal_x + 0.5D, (double)world.func_201676_a(Type.MOTION_BLOCKING_NO_LEAVES, (int)((ExtrautilitiesrebirthModVariables.PlayerVariables)entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).overworld_portal_x, (int)((ExtrautilitiesrebirthModVariables.PlayerVariables)entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).overworld_portal_z) + 0.5D, ((ExtrautilitiesrebirthModVariables.PlayerVariables)entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).overworld_portal_z + 0.5D);
               if (entity instanceof ServerPlayerEntity) {
                  ((ServerPlayerEntity)entity).field_71135_a.func_175089_a(((ExtrautilitiesrebirthModVariables.PlayerVariables)entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).overworld_portal_x + 0.5D, (double)world.func_201676_a(Type.MOTION_BLOCKING_NO_LEAVES, (int)((ExtrautilitiesrebirthModVariables.PlayerVariables)entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).overworld_portal_x, (int)((ExtrautilitiesrebirthModVariables.PlayerVariables)entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).overworld_portal_z) + 0.5D, ((ExtrautilitiesrebirthModVariables.PlayerVariables)entity.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).overworld_portal_z + 0.5D, entity.field_70177_z, entity.field_70125_A, Collections.emptySet());
               }
            }

            if (PortableGlobeItem.block == (entity instanceof LivingEntity ? ((LivingEntity)entity).func_184614_ca() : ItemStack.field_190927_a).func_77973_b() && entity instanceof PlayerEntity) {
               ((PlayerEntity)entity).func_184811_cZ().func_185145_a((entity instanceof LivingEntity ? ((LivingEntity)entity).func_184614_ca() : ItemStack.field_190927_a).func_77973_b(), 12000);
            }

            if (PortableGlobeItem.block == (entity instanceof LivingEntity ? ((LivingEntity)entity).func_184592_cb() : ItemStack.field_190927_a).func_77973_b() && entity instanceof PlayerEntity) {
               ((PlayerEntity)entity).func_184811_cZ().func_185145_a((entity instanceof LivingEntity ? ((LivingEntity)entity).func_184592_cb() : ItemStack.field_190927_a).func_77973_b(), 12000);
            }
         }

      }
   }
}
