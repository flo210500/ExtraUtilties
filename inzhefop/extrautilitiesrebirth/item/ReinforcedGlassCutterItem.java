package inzhefop.extrautilitiesrebirth.item;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import inzhefop.extrautilitiesrebirth.procedures.GlassCutterRightclickedOnBlockProcedure;
import java.util.HashMap;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Stream;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.item.Item.Properties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class ReinforcedGlassCutterItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:reinforced_glass_cutter")
   public static final Item block = null;

   public ReinforcedGlassCutterItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 120);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return new ReinforcedGlassCutterItem.ItemCustom();
      });
   }

   public static class ItemCustom extends Item {
      public ItemCustom() {
         super((new Properties()).func_200916_a(TabItemGroup.tab).func_200917_a(64).func_208103_a(Rarity.UNCOMMON));
         this.setRegistryName("reinforced_glass_cutter");
      }

      public int func_77619_b() {
         return 0;
      }

      public float func_150893_a(ItemStack par1ItemStack, BlockState par2Block) {
         return 1.0F;
      }

      public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
         ActionResultType retval = super.onItemUseFirst(stack, context);
         World world = context.func_195991_k();
         BlockPos pos = context.func_195995_a();
         PlayerEntity entity = context.func_195999_j();
         Direction direction = context.func_196000_l();
         BlockState blockstate = world.func_180495_p(pos);
         int x = pos.func_177958_n();
         int y = pos.func_177956_o();
         int z = pos.func_177952_p();
         ItemStack itemstack = context.func_195996_i();
         GlassCutterRightclickedOnBlockProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("x", x), new SimpleEntry("y", y), new SimpleEntry("z", z), new SimpleEntry("blockstate", blockstate), new SimpleEntry("entity", entity), new SimpleEntry("itemstack", itemstack)).collect(HashMap::new, (_m, _e) -> {
            _m.put(_e.getKey(), _e.getValue());
         }, Map::putAll));
         return retval;
      }
   }
}
