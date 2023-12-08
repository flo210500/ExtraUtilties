package inzhefop.extrautilitiesrebirth.block;

import com.mojang.datafixers.types.Type;
import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import inzhefop.extrautilitiesrebirth.procedures.EnderQuarryNeighbourBlockChangesProcedure;
import inzhefop.extrautilitiesrebirth.procedures.EnderQuarryOnBlockRightClickedProcedure;
import inzhefop.extrautilitiesrebirth.procedures.EnderQuarryUpdateTickProcedure;
import inzhefop.extrautilitiesrebirth.procedures.EnderThermicPumpBlockAddedProcedure;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.Properties;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.NonNullList;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class EnderQuarryBlock extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:ender_quarry")
   public static final Block block = null;
   @ObjectHolder("extrautilitiesrebirth:ender_quarry")
   public static final TileEntityType<EnderQuarryBlock.CustomTileEntity> tileEntityType = null;

   public EnderQuarryBlock(ExtrautilitiesrebirthModElements instance) {
      super(instance, 89);
      FMLJavaModLoadingContext.get().getModEventBus().register(new EnderQuarryBlock.TileEntityRegisterHandler());
   }

   public void initElements() {
      this.elements.blocks.add(() -> {
         return new EnderQuarryBlock.CustomBlock();
      });
      this.elements.items.add(() -> {
         return (Item)(new BlockItem(block, (new Properties()).func_200916_a(TabItemGroup.tab))).setRegistryName(block.getRegistryName());
      });
   }

   public static class CustomTileEntity extends LockableLootTileEntity implements ISidedInventory {
      private NonNullList<ItemStack> stacks;
      private final LazyOptional<? extends IItemHandler>[] handlers;
      private final EnergyStorage energyStorage;

      protected CustomTileEntity() {
         super(EnderQuarryBlock.tileEntityType);
         this.stacks = NonNullList.func_191197_a(1, ItemStack.field_190927_a);
         this.handlers = SidedInvWrapper.create(this, Direction.values());
         this.energyStorage = new EnergyStorage(10000000, 10000000, 10000000, 0) {
            public int receiveEnergy(int maxReceive, boolean simulate) {
               int retval = super.receiveEnergy(maxReceive, simulate);
               if (!simulate) {
                  CustomTileEntity.this.func_70296_d();
                  CustomTileEntity.this.field_145850_b.func_184138_a(CustomTileEntity.this.field_174879_c, CustomTileEntity.this.field_145850_b.func_180495_p(CustomTileEntity.this.field_174879_c), CustomTileEntity.this.field_145850_b.func_180495_p(CustomTileEntity.this.field_174879_c), 2);
               }

               return retval;
            }

            public int extractEnergy(int maxExtract, boolean simulate) {
               int retval = super.extractEnergy(maxExtract, simulate);
               if (!simulate) {
                  CustomTileEntity.this.func_70296_d();
                  CustomTileEntity.this.field_145850_b.func_184138_a(CustomTileEntity.this.field_174879_c, CustomTileEntity.this.field_145850_b.func_180495_p(CustomTileEntity.this.field_174879_c), CustomTileEntity.this.field_145850_b.func_180495_p(CustomTileEntity.this.field_174879_c), 2);
               }

               return retval;
            }
         };
      }

      public void func_230337_a_(BlockState blockState, CompoundNBT compound) {
         super.func_230337_a_(blockState, compound);
         if (!this.func_184283_b(compound)) {
            this.stacks = NonNullList.func_191197_a(this.func_70302_i_(), ItemStack.field_190927_a);
         }

         ItemStackHelper.func_191283_b(compound, this.stacks);
         if (compound.func_74781_a("energyStorage") != null) {
            CapabilityEnergy.ENERGY.readNBT(this.energyStorage, (Direction)null, compound.func_74781_a("energyStorage"));
         }

      }

      public CompoundNBT func_189515_b(CompoundNBT compound) {
         super.func_189515_b(compound);
         if (!this.func_184282_c(compound)) {
            ItemStackHelper.func_191282_a(compound, this.stacks);
         }

         compound.func_218657_a("energyStorage", CapabilityEnergy.ENERGY.writeNBT(this.energyStorage, (Direction)null));
         return compound;
      }

      public SUpdateTileEntityPacket func_189518_D_() {
         return new SUpdateTileEntityPacket(this.field_174879_c, 0, this.func_189517_E_());
      }

      public CompoundNBT func_189517_E_() {
         return this.func_189515_b(new CompoundNBT());
      }

      public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
         this.func_230337_a_(this.func_195044_w(), pkt.func_148857_g());
      }

      public int func_70302_i_() {
         return this.stacks.size();
      }

      public boolean func_191420_l() {
         Iterator var1 = this.stacks.iterator();

         ItemStack itemstack;
         do {
            if (!var1.hasNext()) {
               return true;
            }

            itemstack = (ItemStack)var1.next();
         } while(itemstack.func_190926_b());

         return false;
      }

      public ITextComponent func_213907_g() {
         return new StringTextComponent("ender_quarry");
      }

      public int func_70297_j_() {
         return 64;
      }

      public Container func_213906_a(int id, PlayerInventory player) {
         return ChestContainer.func_216992_a(id, player, this);
      }

      public ITextComponent func_145748_c_() {
         return new StringTextComponent("Ender Quarry");
      }

      protected NonNullList<ItemStack> func_190576_q() {
         return this.stacks;
      }

      protected void func_199721_a(NonNullList<ItemStack> stacks) {
         this.stacks = stacks;
      }

      public boolean func_94041_b(int index, ItemStack stack) {
         return index != 0;
      }

      public int[] func_180463_a(Direction side) {
         return IntStream.range(0, this.func_70302_i_()).toArray();
      }

      public boolean func_180462_a(int index, ItemStack stack, @Nullable Direction direction) {
         return this.func_94041_b(index, stack);
      }

      public boolean func_180461_b(int index, ItemStack stack, Direction direction) {
         return index != 0;
      }

      public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
         if (!this.field_145846_f && facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return this.handlers[facing.ordinal()].cast();
         } else {
            return !this.field_145846_f && capability == CapabilityEnergy.ENERGY ? LazyOptional.of(() -> {
               return this.energyStorage;
            }).cast() : super.getCapability(capability, facing);
         }
      }

      public void func_145843_s() {
         super.func_145843_s();
         LazyOptional[] var1 = this.handlers;
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            LazyOptional<? extends IItemHandler> handler = var1[var3];
            handler.invalidate();
         }

      }
   }

   public static class CustomBlock extends Block {
      public static final DirectionProperty FACING;

      public CustomBlock() {
         super(net.minecraft.block.AbstractBlock.Properties.func_200945_a(Material.field_151573_f).func_200947_a(SoundType.field_185852_e).func_200948_a(2.2F, 800.0F).func_235838_a_((s) -> {
            return 0;
         }).harvestLevel(2).harvestTool(ToolType.PICKAXE));
         this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a(FACING, Direction.NORTH));
         this.setRegistryName("ender_quarry");
      }

      public int func_200011_d(BlockState state, IBlockReader worldIn, BlockPos pos) {
         return 15;
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

      public void func_220082_b(BlockState blockstate, World world, BlockPos pos, BlockState oldState, boolean moving) {
         super.func_220082_b(blockstate, world, pos, oldState, moving);
         int x = pos.func_177958_n();
         int y = pos.func_177956_o();
         int z = pos.func_177952_p();
         world.func_205220_G_().func_205360_a(pos, this, 1);
         EnderThermicPumpBlockAddedProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("x", x), new SimpleEntry("y", y), new SimpleEntry("z", z)).collect(HashMap::new, (_m, _e) -> {
            _m.put(_e.getKey(), _e.getValue());
         }, Map::putAll));
      }

      public void func_220069_a(BlockState blockstate, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
         super.func_220069_a(blockstate, world, pos, neighborBlock, fromPos, moving);
         int x = pos.func_177958_n();
         int y = pos.func_177956_o();
         int z = pos.func_177952_p();
         if (world.func_175687_A(new BlockPos(x, y, z)) > 0) {
         }

         EnderQuarryNeighbourBlockChangesProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("x", x), new SimpleEntry("y", y), new SimpleEntry("z", z)).collect(HashMap::new, (_m, _e) -> {
            _m.put(_e.getKey(), _e.getValue());
         }, Map::putAll));
      }

      public void func_225534_a_(BlockState blockstate, ServerWorld world, BlockPos pos, Random random) {
         super.func_225534_a_(blockstate, world, pos, random);
         int x = pos.func_177958_n();
         int y = pos.func_177956_o();
         int z = pos.func_177952_p();
         EnderQuarryUpdateTickProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("x", x), new SimpleEntry("y", y), new SimpleEntry("z", z)).collect(HashMap::new, (_m, _e) -> {
            _m.put(_e.getKey(), _e.getValue());
         }, Map::putAll));
         world.func_205220_G_().func_205360_a(pos, this, 1);
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
         EnderQuarryOnBlockRightClickedProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("x", x), new SimpleEntry("y", y), new SimpleEntry("z", z), new SimpleEntry("entity", entity)).collect(HashMap::new, (_m, _e) -> {
            _m.put(_e.getKey(), _e.getValue());
         }, Map::putAll));
         return ActionResultType.SUCCESS;
      }

      public INamedContainerProvider func_220052_b(BlockState state, World worldIn, BlockPos pos) {
         TileEntity tileEntity = worldIn.func_175625_s(pos);
         return tileEntity instanceof INamedContainerProvider ? (INamedContainerProvider)tileEntity : null;
      }

      public boolean hasTileEntity(BlockState state) {
         return true;
      }

      public TileEntity createTileEntity(BlockState state, IBlockReader world) {
         return new EnderQuarryBlock.CustomTileEntity();
      }

      public boolean func_189539_a(BlockState state, World world, BlockPos pos, int eventID, int eventParam) {
         super.func_189539_a(state, world, pos, eventID, eventParam);
         TileEntity tileentity = world.func_175625_s(pos);
         return tileentity == null ? false : tileentity.func_145842_c(eventID, eventParam);
      }

      public void func_196243_a(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
         if (state.func_177230_c() != newState.func_177230_c()) {
            TileEntity tileentity = world.func_175625_s(pos);
            if (tileentity instanceof EnderQuarryBlock.CustomTileEntity) {
               InventoryHelper.func_180175_a(world, pos, (EnderQuarryBlock.CustomTileEntity)tileentity);
               world.func_175666_e(pos, this);
            }

            super.func_196243_a(state, world, pos, newState, isMoving);
         }

      }

      public boolean func_149740_M(BlockState state) {
         return true;
      }

      public int func_180641_l(BlockState blockState, World world, BlockPos pos) {
         TileEntity tileentity = world.func_175625_s(pos);
         return tileentity instanceof EnderQuarryBlock.CustomTileEntity ? Container.func_94526_b((EnderQuarryBlock.CustomTileEntity)tileentity) : 0;
      }

      static {
         FACING = HorizontalBlock.field_185512_D;
      }
   }

   private static class TileEntityRegisterHandler {
      private TileEntityRegisterHandler() {
      }

      @SubscribeEvent
      public void registerTileEntity(Register<TileEntityType<?>> event) {
         event.getRegistry().register(net.minecraft.tileentity.TileEntityType.Builder.func_223042_a(EnderQuarryBlock.CustomTileEntity::new, new Block[]{EnderQuarryBlock.block}).func_206865_a((Type)null).setRegistryName("ender_quarry"));
      }

      // $FF: synthetic method
      TileEntityRegisterHandler(Object x0) {
         this();
      }
   }
}
