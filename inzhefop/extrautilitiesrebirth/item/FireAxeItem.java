package inzhefop.extrautilitiesrebirth.item;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import inzhefop.extrautilitiesrebirth.procedures.FireAxeBlockDestroyedWithToolProcedure;
import java.util.HashMap;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Stream;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class FireAxeItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:fire_axe")
   public static final Item block = null;

   public FireAxeItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 123);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return (Item)(new AxeItem(new IItemTier() {
            public int func_200926_a() {
               return 0;
            }

            public float func_200928_b() {
               return 14.0F;
            }

            public float func_200929_c() {
               return 6.0F;
            }

            public int func_200925_d() {
               return 4;
            }

            public int func_200927_e() {
               return 2;
            }

            public Ingredient func_200924_f() {
               return Ingredient.func_193369_a(new ItemStack[]{new ItemStack(Items.field_234757_kL_)});
            }
         }, 1.0F, 1.0F, (new Properties()).func_200916_a(TabItemGroup.tab).func_234689_a_()) {
            public boolean func_179218_a(ItemStack itemstack, World world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
               boolean retval = super.func_179218_a(itemstack, world, blockstate, pos, entity);
               int x = pos.func_177958_n();
               int y = pos.func_177956_o();
               int z = pos.func_177952_p();
               FireAxeBlockDestroyedWithToolProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("x", x), new SimpleEntry("y", y), new SimpleEntry("z", z), new SimpleEntry("entity", entity)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
               return retval;
            }
         }).setRegistryName("fire_axe");
      });
   }
}
