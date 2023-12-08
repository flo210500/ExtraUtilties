package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;

public class AngelRingMessageProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure AngelRingMessage!");
         }

      } else {
         Entity entity = (Entity)dependencies.get("entity");
         if (entity instanceof PlayerEntity && !entity.field_70170_p.func_201670_d()) {
            ((PlayerEntity)entity).func_146105_b(new StringTextComponent("Download: =>§bhttps://www.curseforge.com/minecraft/mc-mods/angel-ring"), false);
         }

      }
   }
}
