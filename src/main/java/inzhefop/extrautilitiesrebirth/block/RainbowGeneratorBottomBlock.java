package inzhefop.extrautilitiesrebirth.block;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import java.util.Collections;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.Properties;
import net.minecraft.loot.LootContext.Builder;
import net.minecraft.state.properties.SlabType;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class RainbowGeneratorBottomBlock extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:rainbow_generator_bottom")
   public static final Block block = null;

   public RainbowGeneratorBottomBlock(ExtrautilitiesrebirthModElements instance) {
      super(instance, 87);
   }

   public void initElements() {
      this.elements.blocks.add(() -> {
         return new RainbowGeneratorBottomBlock.CustomBlock();
      });
      this.elements.items.add(() -> {
         return (Item)(new BlockItem(block, (new Properties()).func_200916_a(TabItemGroup.tab))).setRegistryName(block.getRegistryName());
      });
   }

   public static class CustomBlock extends SlabBlock {
      public CustomBlock() {
         super(net.minecraft.block.AbstractBlock.Properties.func_200945_a(Material.field_151573_f).func_200947_a(SoundType.field_185852_e).func_200948_a(3.0F, 8000.0F).func_235838_a_((s) -> {
            return 0;
         }).harvestLevel(3).harvestTool(ToolType.PICKAXE));
         this.setRegistryName("rainbow_generator_bottom");
      }

      public List<ItemStack> func_220076_a(BlockState state, Builder builder) {
         List<ItemStack> dropsOriginal = super.func_220076_a(state, builder);
         return !dropsOriginal.isEmpty() ? dropsOriginal : Collections.singletonList(new ItemStack(this, state.func_177229_b(field_196505_a) == SlabType.DOUBLE ? 2 : 1));
      }
   }
}
