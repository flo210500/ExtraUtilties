package inzhefop.extrautilitiesrebirth.item;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class PrecisionShearsItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:precision_shears")
   public static final Item block = null;

   public PrecisionShearsItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 127);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return (Item)(new ShearsItem((new Properties()).func_200916_a(TabItemGroup.tab).func_200918_c(0)) {
            public int func_77619_b() {
               return 2;
            }

            public float func_150893_a(ItemStack stack, BlockState block) {
               return 8.0F;
            }
         }).setRegistryName("precision_shears");
      });
   }
}
