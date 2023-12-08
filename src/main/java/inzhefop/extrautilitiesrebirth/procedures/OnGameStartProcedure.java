package inzhefop.extrautilitiesrebirth.procedures;

import java.util.Collections;
import java.util.Map;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;

public class OnGameStartProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      System.out.println("Extra Utilities Reborn successfully loaded!");
   }

   @EventBusSubscriber(
      bus = Bus.MOD,
      value = {Dist.DEDICATED_SERVER}
   )
   private static class GlobalTrigger {
      @SubscribeEvent
      public static void init(FMLDedicatedServerSetupEvent event) {
         OnGameStartProcedure.executeProcedure(Collections.emptyMap());
      }
   }
}
