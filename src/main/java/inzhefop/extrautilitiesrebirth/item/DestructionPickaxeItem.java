package inzhefop.extrautilitiesrebirth.item;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class DestructionPickaxeItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:destruction_pickaxe")
   public static final Item block = null;

   public DestructionPickaxeItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 130);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return (Item)(new PickaxeItem(new IItemTier() {
            public int func_200926_a() {
               return 6244;
            }

            public float func_200928_b() {
               return 9.0F;
            }

            public float func_200929_c() {
               return 3.0F;
            }

            public int func_200925_d() {
               return 4;
            }

            public int func_200927_e() {
               return 6;
            }

            public Ingredient func_200924_f() {
               return Ingredient.func_193369_a(new ItemStack[]{new ItemStack(UnstableIngotItem.block)});
            }
         }, 1, -3.0F, (new Properties()).func_200916_a(TabItemGroup.tab).func_234689_a_()) {
         }).setRegistryName("destruction_pickaxe");
      });
   }
}
