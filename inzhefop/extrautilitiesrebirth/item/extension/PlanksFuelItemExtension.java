package inzhefop.extrautilitiesrebirth.item.extension;

import inzhefop.extrautilitiesrebirth.block.MagicalPlanksBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class PlanksFuelItemExtension {
   @EventBusSubscriber
   public static class Fuel {
      @SubscribeEvent
      public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
         ItemStack itemstack = event.getItemStack();
         if (itemstack.func_77973_b() == MagicalPlanksBlock.block.func_199767_j()) {
            event.setBurnTime(3200);
         }

      }
   }
}
