package inzhefop.extrautilitiesrebirth.item.extension;

import inzhefop.extrautilitiesrebirth.item.RedCoalItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class RedCoalFuelItemExtension {
   @EventBusSubscriber
   public static class Fuel {
      @SubscribeEvent
      public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
         ItemStack itemstack = event.getItemStack();
         if (itemstack.func_77973_b() == RedCoalItem.block) {
            event.setBurnTime(11200);
         }

      }
   }
}
