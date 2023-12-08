package inzhefop.extrautilitiesrebirth.gui;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthMod;
import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.fml.network.NetworkEvent.Context;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class EnderQuarryGUIGui extends ExtrautilitiesrebirthModElements.ModElement {
   public static HashMap guistate = new HashMap();
   private static ContainerType<EnderQuarryGUIGui.GuiContainerMod> containerType = null;

   public EnderQuarryGUIGui(ExtrautilitiesrebirthModElements instance) {
      super(instance, 425);
      this.elements.addNetworkMessage(EnderQuarryGUIGui.ButtonPressedMessage.class, EnderQuarryGUIGui.ButtonPressedMessage::buffer, EnderQuarryGUIGui.ButtonPressedMessage::new, EnderQuarryGUIGui.ButtonPressedMessage::handler);
      this.elements.addNetworkMessage(EnderQuarryGUIGui.GUISlotChangedMessage.class, EnderQuarryGUIGui.GUISlotChangedMessage::buffer, EnderQuarryGUIGui.GUISlotChangedMessage::new, EnderQuarryGUIGui.GUISlotChangedMessage::handler);
      containerType = new ContainerType(new EnderQuarryGUIGui.GuiContainerModFactory());
      FMLJavaModLoadingContext.get().getModEventBus().register(new EnderQuarryGUIGui.ContainerRegisterHandler());
   }

   @OnlyIn(Dist.CLIENT)
   public void initElements() {
      DeferredWorkQueue.runLater(() -> {
         ScreenManager.func_216911_a(containerType, EnderQuarryGUIGuiWindow::new);
      });
   }

   static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
      World world = entity.field_70170_p;
      if (world.func_175667_e(new BlockPos(x, y, z))) {
         ;
      }
   }

   private static void handleSlotAction(PlayerEntity entity, int slotID, int changeType, int meta, int x, int y, int z) {
      World world = entity.field_70170_p;
      if (world.func_175667_e(new BlockPos(x, y, z))) {
         ;
      }
   }

   public static class GUISlotChangedMessage {
      int slotID;
      int x;
      int y;
      int z;
      int changeType;
      int meta;

      public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
         this.slotID = slotID;
         this.x = x;
         this.y = y;
         this.z = z;
         this.changeType = changeType;
         this.meta = meta;
      }

      public GUISlotChangedMessage(PacketBuffer buffer) {
         this.slotID = buffer.readInt();
         this.x = buffer.readInt();
         this.y = buffer.readInt();
         this.z = buffer.readInt();
         this.changeType = buffer.readInt();
         this.meta = buffer.readInt();
      }

      public static void buffer(EnderQuarryGUIGui.GUISlotChangedMessage message, PacketBuffer buffer) {
         buffer.writeInt(message.slotID);
         buffer.writeInt(message.x);
         buffer.writeInt(message.y);
         buffer.writeInt(message.z);
         buffer.writeInt(message.changeType);
         buffer.writeInt(message.meta);
      }

      public static void handler(EnderQuarryGUIGui.GUISlotChangedMessage message, Supplier<Context> contextSupplier) {
         Context context = (Context)contextSupplier.get();
         context.enqueueWork(() -> {
            PlayerEntity entity = context.getSender();
            int slotID = message.slotID;
            int changeType = message.changeType;
            int meta = message.meta;
            int x = message.x;
            int y = message.y;
            int z = message.z;
            EnderQuarryGUIGui.handleSlotAction(entity, slotID, changeType, meta, x, y, z);
         });
         context.setPacketHandled(true);
      }
   }

   public static class ButtonPressedMessage {
      int buttonID;
      int x;
      int y;
      int z;

      public ButtonPressedMessage(PacketBuffer buffer) {
         this.buttonID = buffer.readInt();
         this.x = buffer.readInt();
         this.y = buffer.readInt();
         this.z = buffer.readInt();
      }

      public ButtonPressedMessage(int buttonID, int x, int y, int z) {
         this.buttonID = buttonID;
         this.x = x;
         this.y = y;
         this.z = z;
      }

      public static void buffer(EnderQuarryGUIGui.ButtonPressedMessage message, PacketBuffer buffer) {
         buffer.writeInt(message.buttonID);
         buffer.writeInt(message.x);
         buffer.writeInt(message.y);
         buffer.writeInt(message.z);
      }

      public static void handler(EnderQuarryGUIGui.ButtonPressedMessage message, Supplier<Context> contextSupplier) {
         Context context = (Context)contextSupplier.get();
         context.enqueueWork(() -> {
            PlayerEntity entity = context.getSender();
            int buttonID = message.buttonID;
            int x = message.x;
            int y = message.y;
            int z = message.z;
            EnderQuarryGUIGui.handleButtonAction(entity, buttonID, x, y, z);
         });
         context.setPacketHandled(true);
      }
   }

   public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
      World world;
      PlayerEntity entity;
      int x;
      int y;
      int z;
      private IItemHandler internal;
      private Map<Integer, Slot> customSlots = new HashMap();
      private boolean bound = false;

      public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
         super(EnderQuarryGUIGui.containerType, id);
         this.entity = inv.field_70458_d;
         this.world = inv.field_70458_d.field_70170_p;
         this.internal = new ItemStackHandler(3);
         BlockPos pos = null;
         if (extraData != null) {
            pos = extraData.func_179259_c();
            this.x = pos.func_177958_n();
            this.y = pos.func_177956_o();
            this.z = pos.func_177952_p();
         }

         if (pos != null) {
            if (extraData.readableBytes() == 1) {
               byte hand = extraData.readByte();
               ItemStack itemstack;
               if (hand == 0) {
                  itemstack = this.entity.func_184614_ca();
               } else {
                  itemstack = this.entity.func_184592_cb();
               }

               itemstack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  this.internal = capability;
                  this.bound = true;
               });
            } else if (extraData.readableBytes() > 1) {
               extraData.readByte();
               Entity entity = this.world.func_73045_a(extraData.func_150792_a());
               if (entity != null) {
                  entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     this.internal = capability;
                     this.bound = true;
                  });
               }
            } else {
               TileEntity ent = inv.field_70458_d != null ? inv.field_70458_d.field_70170_p.func_175625_s(pos) : null;
               if (ent != null) {
                  ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     this.internal = capability;
                     this.bound = true;
                  });
               }
            }
         }

         this.customSlots.put(0, this.func_75146_a(new SlotItemHandler(this.internal, 0, 62, 38) {
            public boolean func_75214_a(ItemStack stack) {
               return false;
            }
         }));
         this.customSlots.put(1, this.func_75146_a(new SlotItemHandler(this.internal, 1, 80, 38) {
            public boolean func_75214_a(ItemStack stack) {
               return false;
            }
         }));
         this.customSlots.put(2, this.func_75146_a(new SlotItemHandler(this.internal, 2, 98, 38) {
            public boolean func_75214_a(ItemStack stack) {
               return false;
            }
         }));

         int si;
         for(si = 0; si < 3; ++si) {
            for(int sj = 0; sj < 9; ++sj) {
               this.func_75146_a(new Slot(inv, sj + (si + 1) * 9, 8 + sj * 18, 84 + si * 18));
            }
         }

         for(si = 0; si < 9; ++si) {
            this.func_75146_a(new Slot(inv, si, 8 + si * 18, 142));
         }

      }

      public Map<Integer, Slot> get() {
         return this.customSlots;
      }

      public boolean func_75145_c(PlayerEntity player) {
         return true;
      }

      public ItemStack func_82846_b(PlayerEntity playerIn, int index) {
         ItemStack itemstack = ItemStack.field_190927_a;
         Slot slot = (Slot)this.field_75151_b.get(index);
         if (slot != null && slot.func_75216_d()) {
            ItemStack itemstack1 = slot.func_75211_c();
            itemstack = itemstack1.func_77946_l();
            if (index < 3) {
               if (!this.func_75135_a(itemstack1, 3, this.field_75151_b.size(), true)) {
                  return ItemStack.field_190927_a;
               }

               slot.func_75220_a(itemstack1, itemstack);
            } else if (!this.func_75135_a(itemstack1, 0, 3, false)) {
               if (index < 30) {
                  if (!this.func_75135_a(itemstack1, 30, this.field_75151_b.size(), true)) {
                     return ItemStack.field_190927_a;
                  }
               } else if (!this.func_75135_a(itemstack1, 3, 30, false)) {
                  return ItemStack.field_190927_a;
               }

               return ItemStack.field_190927_a;
            }

            if (itemstack1.func_190916_E() == 0) {
               slot.func_75215_d(ItemStack.field_190927_a);
            } else {
               slot.func_75218_e();
            }

            if (itemstack1.func_190916_E() == itemstack.func_190916_E()) {
               return ItemStack.field_190927_a;
            }

            slot.func_190901_a(playerIn, itemstack1);
         }

         return itemstack;
      }

      protected boolean func_75135_a(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
         boolean flag = false;
         int i = startIndex;
         if (reverseDirection) {
            i = endIndex - 1;
         }

         Slot slot1;
         ItemStack itemstack;
         if (stack.func_77985_e()) {
            while(!stack.func_190926_b()) {
               if (reverseDirection) {
                  if (i < startIndex) {
                     break;
                  }
               } else if (i >= endIndex) {
                  break;
               }

               slot1 = (Slot)this.field_75151_b.get(i);
               itemstack = slot1.func_75211_c();
               if (slot1.func_75214_a(itemstack) && !itemstack.func_190926_b() && func_195929_a(stack, itemstack)) {
                  int j = itemstack.func_190916_E() + stack.func_190916_E();
                  int maxSize = Math.min(slot1.func_75219_a(), stack.func_77976_d());
                  if (j <= maxSize) {
                     stack.func_190920_e(0);
                     itemstack.func_190920_e(j);
                     slot1.func_75215_d(itemstack);
                     flag = true;
                  } else if (itemstack.func_190916_E() < maxSize) {
                     stack.func_190918_g(maxSize - itemstack.func_190916_E());
                     itemstack.func_190920_e(maxSize);
                     slot1.func_75215_d(itemstack);
                     flag = true;
                  }
               }

               if (reverseDirection) {
                  --i;
               } else {
                  ++i;
               }
            }
         }

         if (!stack.func_190926_b()) {
            if (reverseDirection) {
               i = endIndex - 1;
            } else {
               i = startIndex;
            }

            while(true) {
               if (reverseDirection) {
                  if (i < startIndex) {
                     break;
                  }
               } else if (i >= endIndex) {
                  break;
               }

               slot1 = (Slot)this.field_75151_b.get(i);
               itemstack = slot1.func_75211_c();
               if (itemstack.func_190926_b() && slot1.func_75214_a(stack)) {
                  if (stack.func_190916_E() > slot1.func_75219_a()) {
                     slot1.func_75215_d(stack.func_77979_a(slot1.func_75219_a()));
                  } else {
                     slot1.func_75215_d(stack.func_77979_a(stack.func_190916_E()));
                  }

                  slot1.func_75218_e();
                  flag = true;
                  break;
               }

               if (reverseDirection) {
                  --i;
               } else {
                  ++i;
               }
            }
         }

         return flag;
      }

      public void func_75134_a(PlayerEntity playerIn) {
         super.func_75134_a(playerIn);
         if (!this.bound && playerIn instanceof ServerPlayerEntity) {
            int i;
            if (!playerIn.func_70089_S() || playerIn instanceof ServerPlayerEntity && ((ServerPlayerEntity)playerIn).func_193105_t()) {
               for(i = 0; i < this.internal.getSlots(); ++i) {
                  playerIn.func_71019_a(this.internal.extractItem(i, this.internal.getStackInSlot(i).func_190916_E(), false), false);
               }
            } else {
               for(i = 0; i < this.internal.getSlots(); ++i) {
                  playerIn.field_71071_by.func_191975_a(playerIn.field_70170_p, this.internal.extractItem(i, this.internal.getStackInSlot(i).func_190916_E(), false));
               }
            }
         }

      }

      private void slotChanged(int slotid, int ctype, int meta) {
         if (this.world != null && this.world.func_201670_d()) {
            ExtrautilitiesrebirthMod.PACKET_HANDLER.sendToServer(new EnderQuarryGUIGui.GUISlotChangedMessage(slotid, this.x, this.y, this.z, ctype, meta));
            EnderQuarryGUIGui.handleSlotAction(this.entity, slotid, ctype, meta, this.x, this.y, this.z);
         }

      }
   }

   public static class GuiContainerModFactory implements IContainerFactory {
      public EnderQuarryGUIGui.GuiContainerMod create(int id, PlayerInventory inv, PacketBuffer extraData) {
         return new EnderQuarryGUIGui.GuiContainerMod(id, inv, extraData);
      }
   }

   private static class ContainerRegisterHandler {
      private ContainerRegisterHandler() {
      }

      @SubscribeEvent
      public void registerContainer(Register<ContainerType<?>> event) {
         event.getRegistry().register(EnderQuarryGUIGui.containerType.setRegistryName("ender_quarry_gui"));
      }

      // $FF: synthetic method
      ContainerRegisterHandler(Object x0) {
         this();
      }
   }
}
