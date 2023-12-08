package inzhefop.extrautilitiesrebirth.item;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import inzhefop.extrautilitiesrebirth.procedures.KikokuLivingEntityIsHitWithToolProcedure;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Stream;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class KikokuItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:kikoku")
   public static final Item block = null;

   public KikokuItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 124);
   }

   public void initElements() {
      this.elements.items.add(() -> {
         return (Item)(new SwordItem(new IItemTier() {
            public int func_200926_a() {
               return 0;
            }

            public float func_200928_b() {
               return 9.0F;
            }

            public float func_200929_c() {
               return 8.0F;
            }

            public int func_200925_d() {
               return 5;
            }

            public int func_200927_e() {
               return 1000;
            }

            public Ingredient func_200924_f() {
               return Ingredient.func_193369_a(new ItemStack[]{new ItemStack(Items.field_151156_bN)});
            }
         }, 3, 1.0F, (new Properties()).func_200916_a(TabItemGroup.tab).func_234689_a_()) {
            public void func_77624_a(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
               super.func_77624_a(itemstack, world, list, flag);
               list.add(new StringTextComponent("§2+4 Armor piercing damage"));
               list.add(new StringTextComponent("§7Thank you RWTema for creating this wonderful mod!"));
            }

            public boolean func_77644_a(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
               boolean retval = super.func_77644_a(itemstack, entity, sourceentity);
               double x = entity.func_226277_ct_();
               double y = entity.func_226278_cu_();
               double z = entity.func_226281_cx_();
               World world = entity.field_70170_p;
               KikokuLivingEntityIsHitWithToolProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("entity", entity)).collect(HashMap::new, (_m, _e) -> {
                  _m.put(_e.getKey(), _e.getValue());
               }, Map::putAll));
               return retval;
            }
         }).setRegistryName("kikoku");
      });
   }
}
