package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.item.AdvancedChickenWingRingItem;
import inzhefop.extrautilitiesrebirth.item.ChickenWingRingItem;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class PlayerJumpsProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("world") == null) {
         if (!dependencies.containsKey("world")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency world for procedure PlayerJumps!");
         }

      } else if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerJumps!");
         }

      } else {
         IWorld world = (IWorld)dependencies.get("world");
         Entity entity = (Entity)dependencies.get("entity");
         boolean damagedone = false;
         AtomicReference _iitemhandlerref;
         int _idx;
         ItemStack itemstackiterator;
         if (entity instanceof PlayerEntity && ((PlayerEntity)entity).field_71071_by.func_70431_c(new ItemStack(AdvancedChickenWingRingItem.block))) {
            _iitemhandlerref = new AtomicReference();
            entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               _iitemhandlerref.set(capability);
            });
            if (_iitemhandlerref.get() != null) {
               for(_idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                  itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).func_77946_l();
                  if (AdvancedChickenWingRingItem.block == itemstackiterator.func_77973_b() && !damagedone) {
                     entity.func_213293_j(entity.func_213322_ci().func_82615_a() * 1.25D, entity.func_213322_ci().func_82617_b() * 1.25D, entity.func_70040_Z().field_72449_c * 1.25D);
                     damagedone = true;
                     if (itemstackiterator.func_96631_a(1, new Random(), (ServerPlayerEntity)null)) {
                        itemstackiterator.func_190918_g(1);
                        itemstackiterator.func_196085_b(0);
                     }
                  }
               }
            }
         } else if (entity instanceof PlayerEntity && ((PlayerEntity)entity).field_71071_by.func_70431_c(new ItemStack(ChickenWingRingItem.block))) {
            _iitemhandlerref = new AtomicReference();
            entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               _iitemhandlerref.set(capability);
            });
            if (_iitemhandlerref.get() != null) {
               for(_idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                  itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).func_77946_l();
                  if (ChickenWingRingItem.block == itemstackiterator.func_77973_b() && !damagedone) {
                     entity.func_213293_j(entity.func_213322_ci().func_82615_a() * 1.1D, entity.func_213322_ci().func_82617_b() * 1.1D, entity.func_70040_Z().field_72449_c * 1.1D);
                     damagedone = true;
                  }
               }
            }
         }

      }
   }

   @EventBusSubscriber
   private static class GlobalTrigger {
      @SubscribeEvent
      public static void onEntityJump(LivingJumpEvent event) {
         LivingEntity entity = event.getEntityLiving();
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
         dependencies.put("event", event);
         PlayerJumpsProcedure.executeProcedure(dependencies);
      }
   }
}
