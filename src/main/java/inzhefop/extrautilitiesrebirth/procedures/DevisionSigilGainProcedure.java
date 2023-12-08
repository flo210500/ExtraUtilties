package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.item.DevisionSigilItem;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

public class DevisionSigilGainProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure DevisionSigilGain!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure DevisionSigilGain!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure DevisionSigilGain!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure DevisionSigilGain!");
         }

      } else if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure DevisionSigilGain!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         Entity entity = (Entity)dependencies.get("entity");
         if (("Wither".equals(entity.func_145748_c_().getString()) || "Enderdragon".equals(entity.func_145748_c_().getString())) && world instanceof World && !world.func_201670_d()) {
            ItemEntity entityToSpawn = new ItemEntity((World)world, x, y, z, new ItemStack(DevisionSigilItem.block));
            entityToSpawn.func_174867_a(10);
            entityToSpawn.func_174873_u();
            world.func_217376_c(entityToSpawn);
         }

      }
   }

   @EventBusSubscriber
   private static class GlobalTrigger {
      @SubscribeEvent
      public static void onEntityDeath(LivingDeathEvent event) {
         if (event != null && event.getEntity() != null) {
            Entity entity = event.getEntity();
            Entity sourceentity = event.getSource().func_76346_g();
            double i = entity.func_226277_ct_();
            double j = entity.func_226278_cu_();
            double k = entity.func_226281_cx_();
            World world = entity.field_70170_p;
            Map<String, Object> dependencies = new HashMap();
            dependencies.put("x", i);
            dependencies.put("y", j);
            dependencies.put("z", k);
            dependencies.put("world", world);
            dependencies.put("entity", entity);
            dependencies.put("sourceentity", sourceentity);
            dependencies.put("event", event);
            DevisionSigilGainProcedure.executeProcedure(dependencies);
         }

      }
   }
}
