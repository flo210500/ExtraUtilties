package inzhefop.extrautilitiesrebirth.block;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.procedures.EnderLillyGrowProcedureProcedure;
import inzhefop.extrautilitiesrebirth.procedures.EnderLillyStage1BlockValidPlacementConditionProcedure;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Stream;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.Properties;
import net.minecraft.loot.LootContext.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class EnderLillyStage5Block extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:ender_lilly_stage_5")
   public static final Block block = null;

   public EnderLillyStage5Block(ExtrautilitiesrebirthModElements instance) {
      super(instance, 165);
   }

   public void initElements() {
      this.elements.blocks.add(() -> {
         return new EnderLillyStage5Block.CustomBlock();
      });
      this.elements.items.add(() -> {
         return (Item)(new BlockItem(block, (new Properties()).func_200916_a((ItemGroup)null))).setRegistryName(block.getRegistryName());
      });
   }

   @OnlyIn(Dist.CLIENT)
   public void clientLoad(FMLClientSetupEvent event) {
      RenderTypeLookup.setRenderLayer(block, RenderType.func_228643_e_());
   }

   public static class CustomBlock extends Block {
      public CustomBlock() {
         super(net.minecraft.block.AbstractBlock.Properties.func_200945_a(Material.field_151585_k).func_200947_a(SoundType.field_185850_c).func_200948_a(0.0F, 0.0F).func_235838_a_((s) -> {
            return 0;
         }).func_200942_a().func_226896_b_().func_235828_a_((bs, br, bp) -> {
            return false;
         }));
         this.setRegistryName("ender_lilly_stage_5");
      }

      public boolean func_200123_i(BlockState state, IBlockReader reader, BlockPos pos) {
         return true;
      }

      public int func_200011_d(BlockState state, IBlockReader worldIn, BlockPos pos) {
         return 0;
      }

      public VoxelShape func_220053_a(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
         Vector3d offset = state.func_191059_e(world, pos);
         return VoxelShapes.func_216384_a(func_208617_a(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D), new VoxelShape[0]).func_197751_a(offset.field_72450_a, offset.field_72448_b, offset.field_72449_c);
      }

      public boolean func_196260_a(BlockState blockstate, IWorldReader worldIn, BlockPos pos) {
         if (worldIn instanceof IWorld) {
            IWorld world = (IWorld)worldIn;
            int x = pos.func_177958_n();
            int y = pos.func_177956_o();
            int z = pos.func_177952_p();
            return EnderLillyStage1BlockValidPlacementConditionProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("x", x), new SimpleEntry("y", y), new SimpleEntry("z", z)).collect(HashMap::new, (_m, _e) -> {
               _m.put(_e.getKey(), _e.getValue());
            }, Map::putAll));
         } else {
            return super.func_196260_a(blockstate, worldIn, pos);
         }
      }

      public BlockState func_196271_a(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
         return !state.func_196955_c(world, currentPos) ? Blocks.field_150350_a.func_176223_P() : super.func_196271_a(state, facing, facingState, world, currentPos, facingPos);
      }

      public List<ItemStack> func_220076_a(BlockState state, Builder builder) {
         List<ItemStack> dropsOriginal = super.func_220076_a(state, builder);
         return !dropsOriginal.isEmpty() ? dropsOriginal : Collections.singletonList(new ItemStack(EnderLillyStage1Block.block));
      }

      public void func_220082_b(BlockState blockstate, World world, BlockPos pos, BlockState oldState, boolean moving) {
         super.func_220082_b(blockstate, world, pos, oldState, moving);
         int x = pos.func_177958_n();
         int y = pos.func_177956_o();
         int z = pos.func_177952_p();
         world.func_205220_G_().func_205360_a(pos, this, 3000);
      }

      public void func_225534_a_(BlockState blockstate, ServerWorld world, BlockPos pos, Random random) {
         super.func_225534_a_(blockstate, world, pos, random);
         int x = pos.func_177958_n();
         int y = pos.func_177956_o();
         int z = pos.func_177952_p();
         EnderLillyGrowProcedureProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("x", x), new SimpleEntry("y", y), new SimpleEntry("z", z)).collect(HashMap::new, (_m, _e) -> {
            _m.put(_e.getKey(), _e.getValue());
         }, Map::putAll));
         world.func_205220_G_().func_205360_a(pos, this, 3000);
      }
   }
}
