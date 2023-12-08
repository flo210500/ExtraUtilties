package inzhefop.extrautilitiesrebirth.item;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class EthericSwordItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:etheric_sword")
   public static final Item block = null;

   public EthericSwordItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 129);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return (Item)(new SwordItem(new IItemTier() {
            public int func_200926_a() {
               return 1561;
            }

            public float func_200928_b() {
               return 12.0F;
            }

            public float func_200929_c() {
               return 5.0F;
            }

            public int func_200925_d() {
               return 4;
            }

            public int func_200927_e() {
               return 50;
            }

            public Ingredient func_200924_f() {
               return Ingredient.func_193369_a(new ItemStack[]{new ItemStack(UnstableIngotItem.block)});
            }
         }, 3, 15.0F, (new Properties()).func_200916_a(TabItemGroup.tab).func_234689_a_()) {
         }).setRegistryName("etheric_sword");
      });
   }
}
