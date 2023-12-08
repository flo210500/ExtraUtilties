package inzhefop.extrautilitiesrebirth.item;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.procedures.AngelRingMessageProcedure;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Stream;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.item.Item.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class AngelRingItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:angel_ring")
   public static final Item block = null;

   public AngelRingItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 152);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return new AngelRingItem.ItemCustom();
      });
   }

   public static class ItemCustom extends Item {
      public ItemCustom() {
         super((new Properties()).func_200916_a((ItemGroup)null).func_200917_a(1).func_208103_a(Rarity.COMMON));
         this.setRegistryName("angel_ring");
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
         list.add(new StringTextComponent("§fSeparately available as §eAngel Ring §fby DenisMasterHerobrine"));
         list.add(new StringTextComponent("§7Right-click for the link!"));
      }

      public ActionResult<ItemStack> func_77659_a(World world, PlayerEntity entity, Hand hand) {
         ActionResult<ItemStack> ar = super.func_77659_a(world, entity, hand);
         ItemStack itemstack = (ItemStack)ar.func_188398_b();
         double x = entity.func_226277_ct_();
         double y = entity.func_226278_cu_();
         double z = entity.func_226281_cx_();
         AngelRingMessageProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("entity", entity)).collect(HashMap::new, (_m, _e) -> {
            _m.put(_e.getKey(), _e.getValue());
         }, Map::putAll));
         return ar;
      }
   }
}
