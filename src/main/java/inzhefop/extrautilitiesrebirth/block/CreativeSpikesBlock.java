package inzhefop.extrautilitiesrebirth.block;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import inzhefop.extrautilitiesrebirth.procedures.CreativeSpikeProcedureProcedure;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Stream;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.Properties;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class CreativeSpikesBlock extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:creative_spikes")
   public static final Block block = null;

   public CreativeSpikesBlock(ExtrautilitiesrebirthModElements instance) {
      super(instance, 43);
   }

   public void initElements() {
      this.elements.blocks.add(() -> {
         return new CreativeSpikesBlock.CustomBlock();
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
      public static final DirectionProperty FACING;

      public CustomBlock() {
         super(net.minecraft.block.AbstractBlock.Properties.func_200945_a(Material.field_151573_f).func_200947_a(SoundType.field_185852_e).func_200948_a(-1.0F, 3600000.0F).func_235838_a_((s) -> {
            return 0;
         }).harvestLevel(4).harvestTool(ToolType.PICKAXE).func_226896_b_().func_235828_a_((bs, br, bp) -> {
            return false;
         }));
         this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a(FACING, Direction.NORTH));
         this.setRegistryName("creative_spikes");
      }

      public boolean func_200123_i(BlockState state, IBlockReader reader, BlockPos pos) {
         return true;
      }

      public int func_200011_d(BlockState state, IBlockReader worldIn, BlockPos pos) {
         return 0;
      }

      protected void func_206840_a(Builder<Block, BlockState> builder) {
         builder.func_206894_a(new Property[]{FACING});
      }

      public BlockState func_196258_a(BlockItemUseContext context) {
         return (BlockState)this.func_176223_P().func_206870_a(FACING, context.func_195992_f().func_176734_d());
      }

      public BlockState func_185499_a(BlockState state, Rotation rot) {
         return (BlockState)state.func_206870_a(FACING, rot.func_185831_a((Direction)state.func_177229_b(FACING)));
      }

      public BlockState func_185471_a(BlockState state, Mirror mirrorIn) {
         return state.func_185907_a(mirrorIn.func_185800_a((Direction)state.func_177229_b(FACING)));
      }

      public List<ItemStack> func_220076_a(BlockState state, net.minecraft.loot.LootContext.Builder builder) {
         List<ItemStack> dropsOriginal = super.func_220076_a(state, builder);
         return !dropsOriginal.isEmpty() ? dropsOriginal : Collections.singletonList(new ItemStack(this, 1));
      }

      public void func_196262_a(BlockState blockstate, World world, BlockPos pos, Entity entity) {
         super.func_196262_a(blockstate, world, pos, entity);
         int x = pos.func_177958_n();
         int y = pos.func_177956_o();
         int z = pos.func_177952_p();
         CreativeSpikeProcedureProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("entity", entity)).collect(HashMap::new, (_m, _e) -> {
            _m.put(_e.getKey(), _e.getValue());
         }, Map::putAll));
      }

      public void func_176199_a(World world, BlockPos pos, Entity entity) {
         super.func_176199_a(world, pos, entity);
         int x = pos.func_177958_n();
         int y = pos.func_177956_o();
         int z = pos.func_177952_p();
         world.func_180495_p(pos);
         CreativeSpikeProcedureProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("entity", entity)).collect(HashMap::new, (_m, _e) -> {
            _m.put(_e.getKey(), _e.getValue());
         }, Map::putAll));
      }

      static {
         FACING = HorizontalBlock.field_185512_D;
      }
   }
}
