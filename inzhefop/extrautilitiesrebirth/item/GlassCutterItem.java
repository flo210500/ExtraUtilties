package inzhefop.extrautilitiesrebirth.item;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import inzhefop.extrautilitiesrebirth.procedures.GlassCutterRightclickedOnBlockProcedure;
import java.util.HashMap;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Stream;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.item.Item.Properties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class GlassCutterItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:glass_cutter")
   public static final Item block = null;

   public GlassCutterItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 119);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return new GlassCutterItem.ItemCustom();
      });
   }

   public static class ItemCustom extends Item {
      public ItemCustom() {
         super((new Properties()).func_200916_a(TabItemGroup.tab).func_200918_c(256).func_208103_a(Rarity.COMMON));
         this.setRegistryName("glass_cutter");
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

      public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
         ActionResultType retval = super.onItemUseFirst(stack, context);
         World world = context.func_195991_k();
         BlockPos pos = context.func_195995_a();
         PlayerEntity entity = context.func_195999_j();
         Direction direction = context.func_196000_l();
         BlockState blockstate = world.func_180495_p(pos);
         int x = pos.func_177958_n();
         int y = pos.func_177956_o();
         int z = pos.func_177952_p();
         ItemStack itemstack = context.func_195996_i();
         GlassCutterRightclickedOnBlockProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("x", x), new SimpleEntry("y", y), new SimpleEntry("z", z), new SimpleEntry("blockstate", blockstate), new SimpleEntry("entity", entity), new SimpleEntry("itemstack", itemstack)).collect(HashMap::new, (_m, _e) -> {
            _m.put(_e.getKey(), _e.getValue());
         }, Map::putAll));
         return retval;
      }
   }
}
