package inzhefop.extrautilitiesrebirth.block;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.procedures.QuantumQuarryActuatorOnBlockRightClickedProcedure;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Stream;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.Properties;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class QuantumQuarryActuatorBlock extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:quantum_quarry_actuator")
   public static final Block block = null;

   public QuantumQuarryActuatorBlock(ExtrautilitiesrebirthModElements instance) {
      super(instance, 424);
   }

   public void initElements() {
      this.elements.blocks.add(() -> {
         return new QuantumQuarryActuatorBlock.CustomBlock();
      });
      this.elements.items.add(() -> {
         return (Item)(new BlockItem(block, (new Properties()).func_200916_a((ItemGroup)null))).setRegistryName(block.getRegistryName());
      });
   }

   public static class CustomBlock extends Block {
      public static final DirectionProperty FACING;

      public CustomBlock() {
         super(net.minecraft.block.AbstractBlock.Properties.func_200945_a(Material.field_151573_f).func_200947_a(SoundType.field_185852_e).func_200948_a(2.0F, 800.0F).func_235838_a_((s) -> {
            return 0;
         }).harvestLevel(3).harvestTool(ToolType.PICKAXE).func_235861_h_());
         this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a(FACING, Direction.NORTH));
         this.setRegistryName("quantum_quarry_actuator");
      }

      @OnlyIn(Dist.CLIENT)
      public void func_190948_a(ItemStack itemstack, IBlockReader world, List<ITextComponent> list, ITooltipFlag flag) {
         super.func_190948_a(itemstack, world, list, flag);
         list.add(new StringTextComponent("§c§lWIP!"));
      }

      public int func_200011_d(BlockState state, IBlockReader worldIn, BlockPos pos) {
         return 15;
      }

      protected void func_206840_a(Builder<Block, BlockState> builder) {
         builder.func_206894_a(new Property[]{FACING});
      }

      public BlockState func_196258_a(BlockItemUseContext context) {
         return (BlockState)this.func_176223_P().func_206870_a(FACING, context.func_196010_d().func_176734_d());
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

      public ActionResultType func_225533_a_(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity, Hand hand, BlockRayTraceResult hit) {
         super.func_225533_a_(blockstate, world, pos, entity, hand, hit);
         int x = pos.func_177958_n();
         int y = pos.func_177956_o();
         int z = pos.func_177952_p();
         double hitX = hit.func_216347_e().field_72450_a;
         double hitY = hit.func_216347_e().field_72448_b;
         double hitZ = hit.func_216347_e().field_72449_c;
         Direction direction = hit.func_216354_b();
         QuantumQuarryActuatorOnBlockRightClickedProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("x", x), new SimpleEntry("y", y), new SimpleEntry("z", z), new SimpleEntry("entity", entity)).collect(HashMap::new, (_m, _e) -> {
            _m.put(_e.getKey(), _e.getValue());
         }, Map::putAll));
         return ActionResultType.SUCCESS;
      }

      static {
         FACING = DirectionalBlock.field_176387_N;
      }
   }
}
