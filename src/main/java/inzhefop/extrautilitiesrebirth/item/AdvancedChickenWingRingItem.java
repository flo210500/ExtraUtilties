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
public class AdvancedChickenWingRingItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:advanced_chicken_wing_ring")
   public static final Item block = null;

   public AdvancedChickenWingRingItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 151);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return new AdvancedChickenWingRingItem.ItemCustom();
      });
   }

   public static class ItemCustom extends Item {
      public ItemCustom() {
         super((new Properties()).func_200916_a(TabItemGroup.tab).func_200918_c(256).func_208103_a(Rarity.UNCOMMON));
         this.setRegistryName("advanced_chicken_wing_ring");
      }

      public int func_77619_b() {
         return 0;
      }

      public float func_150893_a(ItemStack par1ItemStack, BlockState par2Block) {
         return 1.0F;
      }
   }
}
