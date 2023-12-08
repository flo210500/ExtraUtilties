package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.item.RedstoneCrystalItem;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

public class RedCrystalGainProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure RedCrystalGain!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure RedCrystalGain!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure RedCrystalGain!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure RedCrystalGain!");
         }

      } else if (dependencies.get("blockstate") == null) {
         if (!dependencies.containsKey("blockstate")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency blockstate for procedure RedCrystalGain!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         BlockState blockstate = (BlockState)dependencies.get("blockstate");
         if (Blocks.field_150450_ax == blockstate.func_177230_c() && Math.random() * 100.0D > 85.0D && world instanceof World && !world.func_201670_d()) {
            ItemEntity entityToSpawn = new ItemEntity((World)world, x, y, z, new ItemStack(RedstoneCrystalItem.block));
            entityToSpawn.func_174867_a(10);
            world.func_217376_c(entityToSpawn);
         }

      }
   }

   @EventBusSubscriber
   private static class GlobalTrigger {
      @SubscribeEvent
      public static void onBlockBreak(BreakEvent event) {
         Entity entity = event.getPlayer();
         IWorld world = event.getWorld();
         Map<String, Object> dependencies = new HashMap();
         dependencies.put("xpAmount", event.getExpToDrop());
         dependencies.put("x", event.getPos().func_177958_n());
         dependencies.put("y", event.getPos().func_177956_o());
         dependencies.put("z", event.getPos().func_177952_p());
         dependencies.put("px", entity.func_226277_ct_());
         dependencies.put("py", entity.func_226278_cu_());
         dependencies.put("pz", entity.func_226281_cx_());
         dependencies.put("world", world);
         dependencies.put("entity", entity);
         dependencies.put("blockstate", event.getState());
         dependencies.put("event", event);
         RedCrystalGainProcedure.executeProcedure(dependencies);
      }
   }
}
