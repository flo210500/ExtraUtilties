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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class DevisionSigilItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:devision_sigil")
   public static final Item block = null;

   public DevisionSigilItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 131);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return new DevisionSigilItem.ItemCustom();
      });
   }

   public static class ItemCustom extends Item {
      public ItemCustom() {
         super((new Properties()).func_200916_a(TabItemGroup.tab).func_200918_c(256).func_208103_a(Rarity.UNCOMMON));
         this.setRegistryName("devision_sigil");
      }

      public UseAction func_77661_b(ItemStack itemstack) {
         return UseAction.EAT;
      }

      public boolean func_77634_r() {
         return true;
      }

      public ItemStack getContainerItem(ItemStack itemstack) {
         ItemStack retval = new ItemStack(this);
         retval.func_196085_b(itemstack.func_77952_i() + 1);
         return retval.func_77952_i() >= retval.func_77958_k() ? ItemStack.field_190927_a : retval;
      }

      public boolean isRepairable(ItemStack itemstack) {
         return false;
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

      public void func_77624_a(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
         super.func_77624_a(itemstack, world, list, flag);
         list.add(new StringTextComponent("§7ACTIVE"));
         list.add(new StringTextComponent("§7Can be obtained by killing a Wither or an Enderdragon"));
      }
   }
}
