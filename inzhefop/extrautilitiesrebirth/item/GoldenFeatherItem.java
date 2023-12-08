package inzhefop.extrautilitiesrebirth.item;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class GoldenFeatherItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:golden_feather")
   public static final Item block = null;

   public GoldenFeatherItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 143);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return new GoldenFeatherItem.ItemCustom();
      });
   }

   public static class ItemCustom extends Item {
      public ItemCustom() {
         super((new Properties()).func_200916_a(TabItemGroup.tab).func_200917_a(64).func_208103_a(Rarity.COMMON));
         this.setRegistryName("golden_feather");
      }

      public int func_77619_b() {
         return 0;
      }

      public float func_150893_a(ItemStack par1ItemStack, BlockState par2Block) {
         return 1.0F;
      }
   }
}
