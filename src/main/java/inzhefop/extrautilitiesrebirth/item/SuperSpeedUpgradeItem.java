package inzhefop.extrautilitiesrebirth.item;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class SuperSpeedUpgradeItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:super_speed_upgrade")
   public static final Item block = null;

   public SuperSpeedUpgradeItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 118);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return new SuperSpeedUpgradeItem.ItemCustom();
      });
   }

   public static class ItemCustom extends Item {
      public ItemCustom() {
         super((new Properties()).func_200916_a(TabItemGroup.tab).func_200917_a(64).func_208103_a(Rarity.COMMON));
         this.setRegistryName("super_speed_upgrade");
      }

      public UseAction func_77661_b(ItemStack itemstack) {
         return UseAction.EAT;
      }

      public int func_77619_b() {
         return 0;
      }

      public float func_150893_a(ItemStack par1ItemStack, BlockState par2Block) {
         return 1.0F;
      }

      @OnlyIn(Dist.CLIENT)
      public boolean func_77636_d(ItemStack itemstack) {
         return true;
      }
   }
}
