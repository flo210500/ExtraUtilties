package inzhefop.extrautilitiesrebirth.item;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.item.Item.Properties;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class EvilInfusedIronIngotItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:evil_infused_iron_ingot")
   public static final Item block = null;

   public EvilInfusedIronIngotItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 140);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return new EvilInfusedIronIngotItem.ItemCustom();
      });
   }

   public static class ItemCustom extends Item {
      public ItemCustom() {
         super((new Properties()).func_200916_a(TabItemGroup.tab).func_200917_a(64).func_208103_a(Rarity.COMMON));
         this.setRegistryName("evil_infused_iron_ingot");
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
         list.add(new StringTextComponent("§7Enchanter: 8x Iron Ingot + Netherstar [64000]"));
      }
   }
}
