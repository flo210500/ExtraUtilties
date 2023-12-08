package inzhefop.extrautilitiesrebirth.block;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import java.util.Collections;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.Properties;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class ChunkLoadingWandBlock extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:chunk_loading_wand")
   public static final Block block = null;

   public ChunkLoadingWandBlock(ExtrautilitiesrebirthModElements instance) {
      super(instance, 17);
   }

   public void initElements() {
      this.elements.blocks.add(() -> {
         return new ChunkLoadingWandBlock.CustomBlock();
      });
      this.elements.items.add(() -> {
         return (Item)(new BlockItem(block, (new Properties()).func_200916_a(TabItemGroup.tab))).setRegistryName(block.getRegistryName());
      });
   }

   @OnlyIn(Dist.CLIENT)
   public void clientLoad(FMLClientSetupEvent event) {
      RenderTypeLookup.setRenderLayer(block, RenderType.func_228643_e_());
   }

   public static class CustomBlock extends Block implements IWaterLoggable {
      public static final DirectionProperty FACING;
      public static final BooleanProperty WATERLOGGED;

      public CustomBlock() {
         super(net.minecraft.block.AbstractBlock.Properties.func_200945_a(Material.field_151575_d).func_200947_a(SoundType.field_185848_a).func_200948_a(5.0F, 50.0F).func_235838_a_((s) -> {
            return 0;
         }).harvestLevel(1).harvestTool(ToolType.AXE).func_226896_b_().func_235828_a_((bs, br, bp) -> {
            return false;
         }));
         this.func_180632_j((BlockState)((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a(FACING, Direction.NORTH)).func_206870_a(WATERLOGGED, false));
         this.setRegistryName("chunk_loading_wand");
      }

      public boolean func_200123_i(BlockState state, IBlockReader reader, BlockPos pos) {
         return state.func_204520_s().func_206888_e();
      }

      public int func_200011_d(BlockState state, IBlockReader worldIn, BlockPos pos) {
         return 0;
      }

      protected void func_206840_a(Builder<Block, BlockState> builder) {
         builder.func_206894_a(new Property[]{FACING, WATERLOGGED});
      }

      public BlockState func_196258_a(BlockItemUseContext context) {
         boolean flag = context.func_195991_k().func_204610_c(context.func_195995_a()).func_206886_c() == Fluids.field_204546_a;
         return (BlockState)((BlockState)this.func_176223_P().func_206870_a(FACING, context.func_195992_f().func_176734_d())).func_206870_a(WATERLOGGED, flag);
      }

      public BlockState func_185499_a(BlockState state, Rotation rot) {
         return (BlockState)state.func_206870_a(FACING, rot.func_185831_a((Direction)state.func_177229_b(FACING)));
      }

      public BlockState func_185471_a(BlockState state, Mirror mirrorIn) {
         return state.func_185907_a(mirrorIn.func_185800_a((Direction)state.func_177229_b(FACING)));
      }

      public FluidState func_204507_t(BlockState state) {
         return (Boolean)state.func_177229_b(WATERLOGGED) ? Fluids.field_204546_a.func_207204_a(false) : super.func_204507_t(state);
      }

      public BlockState func_196271_a(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
         if ((Boolean)state.func_177229_b(WATERLOGGED)) {
            world.func_205219_F_().func_205360_a(currentPos, Fluids.field_204546_a, Fluids.field_204546_a.func_205569_a(world));
         }

         return super.func_196271_a(state, facing, facingState, world, currentPos, facingPos);
      }

      public List<ItemStack> func_220076_a(BlockState state, net.minecraft.loot.LootContext.Builder builder) {
         List<ItemStack> dropsOriginal = super.func_220076_a(state, builder);
         return !dropsOriginal.isEmpty() ? dropsOriginal : Collections.singletonList(new ItemStack(this, 1));
      }

      static {
         FACING = HorizontalBlock.field_185512_D;
         WATERLOGGED = BlockStateProperties.field_208198_y;
      }
   }
}
