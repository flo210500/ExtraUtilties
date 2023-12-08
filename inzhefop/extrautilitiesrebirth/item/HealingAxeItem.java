package inzhefop.extrautilitiesrebirth.item;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class HealingAxeItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:healing_axe")
   public static final Item block = null;

   public HealingAxeItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 125);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return (Item)(new AxeItem(new IItemTier() {
            public int func_200926_a() {
               return 1561;
            }

            public float func_200928_b() {
               return 12.0F;
            }

            public float func_200929_c() {
               return 4.0F;
            }

            public int func_200925_d() {
               return 4;
            }

            public int func_200927_e() {
               return 22;
            }

            public Ingredient func_200924_f() {
               return Ingredient.func_193369_a(new ItemStack[]{new ItemStack(UnstableIngotItem.block)});
            }
         }, 1.0F, 1.0F, (new Properties()).func_200916_a(TabItemGroup.tab).func_234689_a_()) {
         }).setRegistryName("healing_axe");
      });
   }
}
