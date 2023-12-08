package inzhefop.extrautilitiesrebirth.item;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import inzhefop.extrautilitiesrebirth.procedures.OverworldPortalOnBlockRightClickedProcedure;
import java.util.HashMap;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Stream;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.Item.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class PortableGlobeItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:portable_globe")
   public static final Item block = null;

   public PortableGlobeItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 132);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return new PortableGlobeItem.ItemCustom();
      });
   }

   public static class ItemCustom extends Item {
      public ItemCustom() {
         super((new Properties()).func_200916_a(TabItemGroup.tab).func_200917_a(1).func_208103_a(Rarity.UNCOMMON));
         this.setRegistryName("portable_globe");
      }

      public int func_77619_b() {
         return 0;
      }

      public float func_150893_a(ItemStack par1ItemStack, BlockState par2Block) {
         return 1.0F;
      }

      public ActionResult<ItemStack> func_77659_a(World world, PlayerEntity entity, Hand hand) {
         ActionResult<ItemStack> ar = super.func_77659_a(world, entity, hand);
         ItemStack itemstack = (ItemStack)ar.func_188398_b();
         double x = entity.func_226277_ct_();
         double y = entity.func_226278_cu_();
         double z = entity.func_226281_cx_();
         OverworldPortalOnBlockRightClickedProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("x", x), new SimpleEntry("y", y), new SimpleEntry("z", z), new SimpleEntry("entity", entity)).collect(HashMap::new, (_m, _e) -> {
            _m.put(_e.getKey(), _e.getValue());
         }, Map::putAll));
         return ar;
      }
   }
}
