package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.AngelBlockBlock;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceContext.BlockMode;
import net.minecraft.util.math.RayTraceContext.FluidMode;
import net.minecraft.world.GameType;
import net.minecraft.world.IWorld;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

public class AngelBlockprocedureProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure AngelBlockprocedure!");
         }

      } else if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure AngelBlockprocedure!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         Entity entity = (Entity)dependencies.get("entity");
         if (AngelBlockBlock.block.func_199767_j() == (entity instanceof LivingEntity ? ((LivingEntity)entity).func_184614_ca() : ItemStack.field_190927_a).func_77973_b()) {
            world.func_180501_a(new BlockPos(entity.field_70170_p.func_217299_a(new RayTraceContext(entity.func_174824_e(1.0F), entity.func_174824_e(1.0F).func_72441_c(entity.func_70676_i(1.0F).field_72450_a * 3.0D, entity.func_70676_i(1.0F).field_72448_b * 3.0D, entity.func_70676_i(1.0F).field_72449_c * 3.0D), BlockMode.OUTLINE, FluidMode.NONE, entity)).func_216350_a().func_177958_n(), entity.field_70170_p.func_217299_a(new RayTraceContext(entity.func_174824_e(1.0F), entity.func_174824_e(1.0F).func_72441_c(entity.func_70676_i(1.0F).field_72450_a * 3.0D, entity.func_70676_i(1.0F).field_72448_b * 3.0D, entity.func_70676_i(1.0F).field_72449_c * 3.0D), BlockMode.OUTLINE, FluidMode.NONE, entity)).func_216350_a().func_177956_o(), entity.field_70170_p.func_217299_a(new RayTraceContext(entity.func_174824_e(1.0F), entity.func_174824_e(1.0F).func_72441_c(entity.func_70676_i(1.0F).field_72450_a * 3.0D, entity.func_70676_i(1.0F).field_72448_b * 3.0D, entity.func_70676_i(1.0F).field_72449_c * 3.0D), BlockMode.OUTLINE, FluidMode.NONE, entity)).func_216350_a().func_177952_p()), AngelBlockBlock.block.func_176223_P(), 3);
            if (!((<undefinedtype>)(new Object() {
               public boolean checkGamemode(Entity _ent) {
                  if (_ent instanceof ServerPlayerEntity) {
                     return ((ServerPlayerEntity)_ent).field_71134_c.func_73081_b() == GameType.CREATIVE;
                  } else if (_ent instanceof PlayerEntity && _ent.field_70170_p.func_201670_d()) {
                     NetworkPlayerInfo _npi = Minecraft.func_71410_x().func_147114_u().func_175102_a(((AbstractClientPlayerEntity)_ent).func_146103_bH().getId());
                     return _npi != null && _npi.func_178848_b() == GameType.CREATIVE;
                  } else {
                     return false;
                  }
               }
            })).checkGamemode(entity)) {
               (entity instanceof LivingEntity ? ((LivingEntity)entity).func_184614_ca() : ItemStack.field_190927_a).func_190918_g(1);
            }
         }

      }
   }

   @EventBusSubscriber
   private static class GlobalTrigger {
      @SubscribeEvent
      public static void onRightClickItem(RightClickItem event) {
         PlayerEntity entity = event.getPlayer();
         if (event.getHand() == entity.func_184600_cs()) {
            double i = (double)event.getPos().func_177958_n();
            double j = (double)event.getPos().func_177956_o();
            double k = (double)event.getPos().func_177952_p();
            IWorld world = event.getWorld();
            Map<String, Object> dependencies = new HashMap();
            dependencies.put("x", i);
            dependencies.put("y", j);
            dependencies.put("z", k);
            dependencies.put("world", world);
            dependencies.put("entity", entity);
            dependencies.put("event", event);
            AngelBlockprocedureProcedure.executeProcedure(dependencies);
         }
      }
   }
}
