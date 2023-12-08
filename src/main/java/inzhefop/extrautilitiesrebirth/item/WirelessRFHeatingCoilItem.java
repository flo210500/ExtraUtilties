package inzhefop.extrautilitiesrebirth.item;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.item.Item.Properties;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class WirelessRFHeatingCoilItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:wireless_rf_heating_coil")
   public static final Item block = null;

   public WirelessRFHeatingCoilItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 225);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return new WirelessRFHeatingCoilItem.ItemCustom();
      });
   }

   public static class ItemCustom extends Item {
      public ItemCustom() {
         super((new Properties()).func_200916_a((ItemGroup)null).func_200917_a(64).func_208103_a(Rarity.COMMON));
         this.setRegistryName("wireless_rf_heating_coil");
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

      public void func_77624_a(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
         super.func_77624_a(itemstack, world, list, flag);
         list.add(new StringTextComponent("§7Resonator: Iron Bars [16000 FE]"));
      }
   }
}
