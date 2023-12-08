package inzhefop.extrautilitiesrebirth.block;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import java.util.Collections;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.Properties;
import net.minecraft.loot.LootContext.Builder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class PolishedStoneBlock extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:polished_stone")
   public static final Block block = null;

   public PolishedStoneBlock(ExtrautilitiesrebirthModElements instance) {
      super(instance, 12);
   }

   public void initElements() {
      this.elements.blocks.add(() -> {
         return new PolishedStoneBlock.CustomBlock();
      });
      this.elements.items.add(() -> {
         return (Item)(new BlockItem(block, (new Properties()).func_200916_a(TabItemGroup.tab))).setRegistryName(block.getRegistryName());
      });
   }

   public static class CustomBlock extends Block {
      public CustomBlock() {
         super(net.minecraft.block.AbstractBlock.Properties.func_200945_a(Material.field_151576_e).func_200947_a(SoundType.field_185851_d).func_200948_a(1.0F, 30.0F).func_235838_a_((s) -> {
            return 0;
         }).harvestLevel(1).harvestTool(ToolType.PICKAXE));
         this.setRegistryName("polished_stone");
      }

      public int func_200011_d(BlockState state, IBlockReader worldIn, BlockPos pos) {
         return 15;
      }

      public List<ItemStack> func_220076_a(BlockState state, Builder builder) {
         List<ItemStack> dropsOriginal = super.func_220076_a(state, builder);
         return !dropsOriginal.isEmpty() ? dropsOriginal : Collections.singletonList(new ItemStack(this, 1));
      }
   }
}
