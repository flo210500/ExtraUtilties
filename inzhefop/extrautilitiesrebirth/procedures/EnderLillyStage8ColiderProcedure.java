package inzhefop.extrautilitiesrebirth.procedures;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;

public class EnderLillyStage8ColiderProcedure {
   public static void executeProcedure(Map<String, Object> dependencies) {
      if (dependencies.get("entity") == null) {
         if (!dependencies.containsKey("entity")) {
            ExtrautilitiesrebirthMod.LOGGER.warn("Failed to load dependency entity for procedure EnderLillyStage8Colider!");
         }

      } else {
         Entity entity = (Entity)dependencies.get("entity");
         entity.func_70097_a(DamageSource.field_76377_j, 1.0F);
      }
   }
}
