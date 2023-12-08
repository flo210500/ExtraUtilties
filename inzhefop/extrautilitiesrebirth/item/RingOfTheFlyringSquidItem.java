package inzhefop.extrautilitiesrebirth.item;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class RingOfTheFlyringSquidItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:ring_of_the_flying_squid")
   public static final Item block = null;

   public RingOfTheFlyringSquidItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 416);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return new RingOfTheFlyringSquidItem.ItemCustom();
      });
   }

   public static class ItemCustom extends Item {
      public ItemCustom() {
         super((new Properties()).func_200916_a((ItemGroup)null).func_200918_c(12000).func_208103_a(Rarity.COMMON));
         this.setRegistryName("ring_of_the_flying_squid");
      }

      public int func_77619_b() {
         return 0;
      }

      public float func_150893_a(ItemStack par1ItemStack, BlockState par2Block) {
         return 1.0F;
      }
   }
}
