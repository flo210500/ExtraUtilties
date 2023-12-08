package inzhefop.extrautilitiesrebirth.item;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.gui.GoldenBagGUIGui;
import inzhefop.extrautilitiesrebirth.gui.GoldenBagGUIGuiWindow;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import io.netty.buffer.Unpooled;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.item.Item.Properties;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class GoldenBagOfHoldingItem extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:golden_bag_of_holding")
   public static final Item block = null;

   public GoldenBagOfHoldingItem(ExtrautilitiesrebirthModElements instance) {
      super(instance, 122);
      MinecraftForge.EVENT_BUS.register(this);
   }

   @SubscribeEvent
   @OnlyIn(Dist.CLIENT)
   public void onItemDropped(ItemTossEvent event) {
      if (event.getEntityItem().func_92059_d().func_77973_b() == block && Minecraft.func_71410_x().field_71462_r instanceof GoldenBagGUIGuiWindow) {
         Minecraft.func_71410_x().field_71439_g.func_71053_j();
      }

   }

   public void initElements() {
      this.elements.items.add(() -> {
         return new GoldenBagOfHoldingItem.ItemCustom();
      });
   }

   private static class InventoryCapability implements ICapabilitySerializable<CompoundNBT> {
      private final LazyOptional<ItemStackHandler> inventory;

      private InventoryCapability() {
         this.inventory = LazyOptional.of(this::createItemHandler);
      }

      public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
         return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? this.inventory.cast() : LazyOptional.empty();
      }

      public CompoundNBT serializeNBT() {
         return this.getItemHandler().serializeNBT();
      }

      public void deserializeNBT(CompoundNBT nbt) {
         this.getItemHandler().deserializeNBT(nbt);
      }

      private ItemStackHandler createItemHandler() {
         return new ItemStackHandler(54) {
            public int getSlotLimit(int slot) {
               return 64;
            }

            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
               return stack.func_77973_b() != GoldenBagOfHoldingItem.block;
            }

            public void setSize(int size) {
            }
         };
      }

      private ItemStackHandler getItemHandler() {
         return (ItemStackHandler)this.inventory.orElseThrow(RuntimeException::new);
      }

      // $FF: synthetic method
      InventoryCapability(Object x0) {
         this();
      }
   }

   public static class ItemCustom extends Item {
      public ItemCustom() {
         super((new Properties()).func_200916_a(TabItemGroup.tab).func_200917_a(1).func_234689_a_().func_208103_a(Rarity.COMMON));
         this.setRegistryName("golden_bag_of_holding");
      }

      public UseAction func_77661_b(ItemStack itemstack) {
         return UseAction.EAT;
      }

      public int func_77619_b() {
         return 0;
      }

      public float func_150893_a(ItemStack par1ItemStack, BlockState par2Block) {
         return 1.0F;
      }

      public void func_77624_a(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
         super.func_77624_a(itemstack, world, list, flag);
         list.add(new StringTextComponent("§7Immune to Fire"));
      }

      public ActionResult<ItemStack> func_77659_a(World world, PlayerEntity entity, final Hand hand) {
         ActionResult<ItemStack> ar = super.func_77659_a(world, entity, hand);
         ItemStack itemstack = (ItemStack)ar.func_188398_b();
         final double x = entity.func_226277_ct_();
         final double y = entity.func_226278_cu_();
         final double z = entity.func_226281_cx_();
         if (entity instanceof ServerPlayerEntity) {
            NetworkHooks.openGui((ServerPlayerEntity)entity, new INamedContainerProvider() {
               public ITextComponent func_145748_c_() {
                  return new StringTextComponent("Golden Bag Of Holding");
               }

               public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
                  PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
                  packetBuffer.func_179255_a(new BlockPos(x, y, z));
                  packetBuffer.writeByte(hand == Hand.MAIN_HAND ? 0 : 1);
                  return new GoldenBagGUIGui.GuiContainerMod(id, inventory, packetBuffer);
               }
            }, (buf) -> {
               buf.func_179255_a(new BlockPos(x, y, z));
               buf.writeByte(hand == Hand.MAIN_HAND ? 0 : 1);
            });
         }

         return ar;
      }

      public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT compound) {
         return new GoldenBagOfHoldingItem.InventoryCapability();
      }

      public CompoundNBT getShareTag(ItemStack stack) {
         CompoundNBT nbt = super.getShareTag(stack);
         if (nbt != null) {
            stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               nbt.func_218657_a("Inventory", ((ItemStackHandler)capability).serializeNBT());
            });
         }

         return nbt;
      }

      public void readShareTag(ItemStack stack, @Nullable CompoundNBT nbt) {
         super.readShareTag(stack, nbt);
         if (nbt != null) {
            stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               ((ItemStackHandler)capability).deserializeNBT((CompoundNBT)nbt.func_74781_a("Inventory"));
            });
         }

      }
   }
}
