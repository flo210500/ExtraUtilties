package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.block.CursedEarthBlock;
import inzhefop.extrautilitiesrebirth.item.DropofEvilItem;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

public class DropEvilGrassProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure DropEvilGrass!");
         }

      } else if (dependencies.get("x") == null) {
         if (!dependencies.containsKey("x")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency x for procedure DropEvilGrass!");
         }

      } else if (dependencies.get("y") == null) {
         if (!dependencies.containsKey("y")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency y for procedure DropEvilGrass!");
         }

      } else if (dependencies.get("z") == null) {
         if (!dependencies.containsKey("z")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency z for procedure DropEvilGrass!");
         }

      } else if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure DropEvilGrass!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         double x = dependencies.get("x") instanceof Integer ? (double)(Integer)dependencies.get("x") : (Double)dependencies.get("x");
         double y = dependencies.get("y") instanceof Integer ? (double)(Integer)dependencies.get("y") : (Double)dependencies.get("y");
         double z = dependencies.get("z") instanceof Integer ? (double)(Integer)dependencies.get("z") : (Double)dependencies.get("z");
         Entity entity = (Entity)dependencies.get("entity");
         if (DropofEvilItem.block == (entity instanceof LivingEntity ? ((LivingEntity)entity).func_184614_ca() : ItemStack.field_190927_a).func_77973_b() && Blocks.field_196658_i == world.func_180495_p(new BlockPos(x, y, z)).func_177230_c()) {
            (entity instanceof LivingEntity ? ((LivingEntity)entity).func_184614_ca() : ItemStack.field_190927_a).func_190918_g(1);
            world.func_180501_a(new BlockPos(x, y, z), CursedEarthBlock.block.func_176223_P(), 3);
         }

      }
   }

   @EventBusSubscriber
   private static class GlobalTrigger {
      @SubscribeEvent
      public static void onRightClickBlock(RightClickBlock event) {
         PlayerEntity entity = event.getPlayer();
         if (event.getHand() == entity.func_184600_cs()) {
            double i = (double)event.getPos().func_177958_n();
            double j = (double)event.getPos().func_177956_o();
            double k = (double)event.getPos().func_177952_p();
            IWorld world = event.getWorld();
            BlockState state = world.func_180495_p(event.getPos());
            Map<String, Object> dependencies = new HashMap();
            dependencies.put("x", i);
            dependencies.put("y", j);
            dependencies.put("z", k);
            dependencies.put("world", world);
            dependencies.put("entity", entity);
            dependencies.put("direction", event.getFace());
            dependencies.put("blockstate", state);
            dependencies.put("event", event);
            DropEvilGrassProcedure.executeProcedure(dependencies);
         }
      }
   }
}
