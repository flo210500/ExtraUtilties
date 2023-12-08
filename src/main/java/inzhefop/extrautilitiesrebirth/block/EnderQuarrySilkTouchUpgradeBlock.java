package inzhefop.extrautilitiesrebirth.block;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import java.util.Collections;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.Properties;
import net.minecraft.loot.LootContext.Builder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class EnderQuarrySilkTouchUpgradeBlock extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:ender_quarry_silk_touch_upgrade")
   public static final Block block = null;

   public EnderQuarrySilkTouchUpgradeBlock(ExtrautilitiesrebirthModElements instance) {
      super(instance, 105);
   }

   public void initElements() {
      this.elements.blocks.add(() -> {
         return new EnderQuarrySilkTouchUpgradeBlock.CustomBlock();
      });
      this.elements.items.add(() -> {
         return (Item)(new BlockItem(block, (new Properties()).func_200916_a(TabItemGroup.tab))).setRegistryName(block.getRegistryName());
      });
   }

   @OnlyIn(Dist.CLIENT)
   public void clientLoad(FMLClientSetupEvent event) {
      RenderTypeLookup.setRenderLayer(block, RenderType.func_228643_e_());
   }

   public static class CustomBlock extends Block {
      public CustomBlock() {
         super(net.minecraft.block.AbstractBlock.Properties.func_200945_a(Material.field_151573_f).func_200947_a(SoundType.field_185852_e).func_200948_a(1.5F, 100.0F).func_235838_a_((s) -> {
            return 0;
         }).harvestLevel(2).harvestTool(ToolType.PICKAXE).func_226896_b_().func_235828_a_((bs, br, bp) -> {
            return false;
         }));
         this.setRegistryName("ender_quarry_silk_touch_upgrade");
      }

      @OnlyIn(Dist.CLIENT)
      public void func_190948_a(ItemStack itemstack, IBlockReader world, List<ITextComponent> list, ITooltipFlag flag) {
         super.func_190948_a(itemstack, world, list, flag);
         list.add(new StringTextComponent("§7Enchanter: Ender Quarry Upgrade Base + Tool [Enchantment: Silk -Touch]"));
      }

      public boolean func_200123_i(BlockState state, IBlockReader reader, BlockPos pos) {
         return true;
      }

      public int func_200011_d(BlockState state, IBlockReader worldIn, BlockPos pos) {
         return 0;
      }

      public VoxelShape func_220053_a(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
         Vector3d offset = state.func_191059_e(world, pos);
         return VoxelShapes.func_216384_a(func_208617_a(1.0D, 1.0D, 1.0D, 15.0D, 15.0D, 15.0D), new VoxelShape[0]).func_197751_a(offset.field_72450_a, offset.field_72448_b, offset.field_72449_c);
      }

      public List<ItemStack> func_220076_a(BlockState state, Builder builder) {
         List<ItemStack> dropsOriginal = super.func_220076_a(state, builder);
         return !dropsOriginal.isEmpty() ? dropsOriginal : Collections.singletonList(new ItemStack(this, 1));
      }
   }
}
