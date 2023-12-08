package inzhefop.extrautilitiesrebirth;

import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.Clone;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent.Context;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class ExtrautilitiesrebirthModVariables {
   public static ItemStack item_nether;
   public static ItemStack item_overworld;
   public static double quarry_offset_x;
   public static double quarry_offset_z;
   @CapabilityInject(ExtrautilitiesrebirthModVariables.PlayerVariables.class)
   public static Capability<ExtrautilitiesrebirthModVariables.PlayerVariables> PLAYER_VARIABLES_CAPABILITY;

   public ExtrautilitiesrebirthModVariables(ExtrautilitiesrebirthModElements elements) {
      elements.addNetworkMessage(ExtrautilitiesrebirthModVariables.WorldSavedDataSyncMessage.class, ExtrautilitiesrebirthModVariables.WorldSavedDataSyncMessage::buffer, ExtrautilitiesrebirthModVariables.WorldSavedDataSyncMessage::new, ExtrautilitiesrebirthModVariables.WorldSavedDataSyncMessage::handler);
      elements.addNetworkMessage(ExtrautilitiesrebirthModVariables.PlayerVariablesSyncMessage.class, ExtrautilitiesrebirthModVariables.PlayerVariablesSyncMessage::buffer, ExtrautilitiesrebirthModVariables.PlayerVariablesSyncMessage::new, ExtrautilitiesrebirthModVariables.PlayerVariablesSyncMessage::handler);
      FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
   }

   private void init(FMLCommonSetupEvent event) {
      CapabilityManager.INSTANCE.register(ExtrautilitiesrebirthModVariables.PlayerVariables.class, new ExtrautilitiesrebirthModVariables.PlayerVariablesStorage(), ExtrautilitiesrebirthModVariables.PlayerVariables::new);
   }

   @SubscribeEvent
   public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
      if (!event.getPlayer().field_70170_p.func_201670_d()) {
         WorldSavedData mapdata = ExtrautilitiesrebirthModVariables.MapVariables.get(event.getPlayer().field_70170_p);
         WorldSavedData worlddata = ExtrautilitiesrebirthModVariables.WorldVariables.get(event.getPlayer().field_70170_p);
         if (mapdata != null) {
            ExtrautilitiesrebirthMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> {
               return (ServerPlayerEntity)event.getPlayer();
            }), new ExtrautilitiesrebirthModVariables.WorldSavedDataSyncMessage(0, mapdata));
         }

         if (worlddata != null) {
            ExtrautilitiesrebirthMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> {
               return (ServerPlayerEntity)event.getPlayer();
            }), new ExtrautilitiesrebirthModVariables.WorldSavedDataSyncMessage(1, worlddata));
         }
      }

   }

   @SubscribeEvent
   public void onPlayerChangedDimension(PlayerChangedDimensionEvent event) {
      if (!event.getPlayer().field_70170_p.func_201670_d()) {
         WorldSavedData worlddata = ExtrautilitiesrebirthModVariables.WorldVariables.get(event.getPlayer().field_70170_p);
         if (worlddata != null) {
            ExtrautilitiesrebirthMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> {
               return (ServerPlayerEntity)event.getPlayer();
            }), new ExtrautilitiesrebirthModVariables.WorldSavedDataSyncMessage(1, worlddata));
         }
      }

   }

   @SubscribeEvent
   public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
      if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer)) {
         event.addCapability(new ResourceLocation("extrautilitiesrebirth", "player_variables"), new ExtrautilitiesrebirthModVariables.PlayerVariablesProvider());
      }

   }

   @SubscribeEvent
   public void onPlayerLoggedInSyncPlayerVariables(PlayerLoggedInEvent event) {
      if (!event.getPlayer().field_70170_p.func_201670_d()) {
         ((ExtrautilitiesrebirthModVariables.PlayerVariables)event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).syncPlayerVariables(event.getPlayer());
      }

   }

   @SubscribeEvent
   public void onPlayerRespawnedSyncPlayerVariables(PlayerRespawnEvent event) {
      if (!event.getPlayer().field_70170_p.func_201670_d()) {
         ((ExtrautilitiesrebirthModVariables.PlayerVariables)event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).syncPlayerVariables(event.getPlayer());
      }

   }

   @SubscribeEvent
   public void onPlayerChangedDimensionSyncPlayerVariables(PlayerChangedDimensionEvent event) {
      if (!event.getPlayer().field_70170_p.func_201670_d()) {
         ((ExtrautilitiesrebirthModVariables.PlayerVariables)event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables())).syncPlayerVariables(event.getPlayer());
      }

   }

   @SubscribeEvent
   public void clonePlayer(Clone event) {
      ExtrautilitiesrebirthModVariables.PlayerVariables original = (ExtrautilitiesrebirthModVariables.PlayerVariables)event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables());
      ExtrautilitiesrebirthModVariables.PlayerVariables clone = (ExtrautilitiesrebirthModVariables.PlayerVariables)event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables());
      clone.overworld_portal_x = original.overworld_portal_x;
      clone.overworld_portal_y = original.overworld_portal_y;
      clone.overworld_portal_z = original.overworld_portal_z;
      if (!event.isWasDeath()) {
      }

   }

   static {
      item_nether = ItemStack.field_190927_a;
      item_overworld = ItemStack.field_190927_a;
      quarry_offset_x = 1000000.0D;
      quarry_offset_z = 1000000.0D;
      PLAYER_VARIABLES_CAPABILITY = null;
   }

   public static class PlayerVariablesSyncMessage {
      public ExtrautilitiesrebirthModVariables.PlayerVariables data;

      public PlayerVariablesSyncMessage(PacketBuffer buffer) {
         this.data = new ExtrautilitiesrebirthModVariables.PlayerVariables();
         (new ExtrautilitiesrebirthModVariables.PlayerVariablesStorage()).readNBT((Capability)null, (ExtrautilitiesrebirthModVariables.PlayerVariables)this.data, (Direction)null, buffer.func_150793_b());
      }

      public PlayerVariablesSyncMessage(ExtrautilitiesrebirthModVariables.PlayerVariables data) {
         this.data = data;
      }

      public static void buffer(ExtrautilitiesrebirthModVariables.PlayerVariablesSyncMessage message, PacketBuffer buffer) {
         buffer.func_150786_a((CompoundNBT)(new ExtrautilitiesrebirthModVariables.PlayerVariablesStorage()).writeNBT((Capability)null, (ExtrautilitiesrebirthModVariables.PlayerVariables)message.data, (Direction)null));
      }

      public static void handler(ExtrautilitiesrebirthModVariables.PlayerVariablesSyncMessage message, Supplier<Context> contextSupplier) {
         Context context = (Context)contextSupplier.get();
         context.enqueueWork(() -> {
            if (!context.getDirection().getReceptionSide().isServer()) {
               ExtrautilitiesrebirthModVariables.PlayerVariables variables = (ExtrautilitiesrebirthModVariables.PlayerVariables)Minecraft.func_71410_x().field_71439_g.getCapability(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new ExtrautilitiesrebirthModVariables.PlayerVariables());
               variables.overworld_portal_x = message.data.overworld_portal_x;
               variables.overworld_portal_y = message.data.overworld_portal_y;
               variables.overworld_portal_z = message.data.overworld_portal_z;
            }

         });
         context.setPacketHandled(true);
      }
   }

   public static class PlayerVariables {
      public double overworld_portal_x = 0.0D;
      public double overworld_portal_y = 0.0D;
      public double overworld_portal_z = 0.0D;

      public void syncPlayerVariables(Entity entity) {
         if (entity instanceof ServerPlayerEntity) {
            ExtrautilitiesrebirthMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> {
               return (ServerPlayerEntity)entity;
            }), new ExtrautilitiesrebirthModVariables.PlayerVariablesSyncMessage(this));
         }

      }
   }

   private static class PlayerVariablesStorage implements IStorage<ExtrautilitiesrebirthModVariables.PlayerVariables> {
      private PlayerVariablesStorage() {
      }

      public INBT writeNBT(Capability<ExtrautilitiesrebirthModVariables.PlayerVariables> capability, ExtrautilitiesrebirthModVariables.PlayerVariables instance, Direction side) {
         CompoundNBT nbt = new CompoundNBT();
         nbt.func_74780_a("overworld_portal_x", instance.overworld_portal_x);
         nbt.func_74780_a("overworld_portal_y", instance.overworld_portal_y);
         nbt.func_74780_a("overworld_portal_z", instance.overworld_portal_z);
         return nbt;
      }

      public void readNBT(Capability<ExtrautilitiesrebirthModVariables.PlayerVariables> capability, ExtrautilitiesrebirthModVariables.PlayerVariables instance, Direction side, INBT inbt) {
         CompoundNBT nbt = (CompoundNBT)inbt;
         instance.overworld_portal_x = nbt.func_74769_h("overworld_portal_x");
         instance.overworld_portal_y = nbt.func_74769_h("overworld_portal_y");
         instance.overworld_portal_z = nbt.func_74769_h("overworld_portal_z");
      }

      // $FF: synthetic method
      PlayerVariablesStorage(Object x0) {
         this();
      }
   }

   private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
      private final LazyOptional<ExtrautilitiesrebirthModVariables.PlayerVariables> instance;

      private PlayerVariablesProvider() {
         Capability var10001 = ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY;
         var10001.getClass();
         this.instance = LazyOptional.of(var10001::getDefaultInstance);
      }

      public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
         return cap == ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY ? this.instance.cast() : LazyOptional.empty();
      }

      public INBT serializeNBT() {
         return ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), (Direction)null);
      }

      public void deserializeNBT(INBT nbt) {
         ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(ExtrautilitiesrebirthModVariables.PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), (Direction)null, nbt);
      }

      // $FF: synthetic method
      PlayerVariablesProvider(Object x0) {
         this();
      }
   }

   public static class WorldSavedDataSyncMessage {
      public int type;
      public WorldSavedData data;

      public WorldSavedDataSyncMessage(PacketBuffer buffer) {
         this.type = buffer.readInt();
         this.data = (WorldSavedData)(this.type == 0 ? new ExtrautilitiesrebirthModVariables.MapVariables() : new ExtrautilitiesrebirthModVariables.WorldVariables());
         this.data.func_76184_a(buffer.func_150793_b());
      }

      public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
         this.type = type;
         this.data = data;
      }

      public static void buffer(ExtrautilitiesrebirthModVariables.WorldSavedDataSyncMessage message, PacketBuffer buffer) {
         buffer.writeInt(message.type);
         buffer.func_150786_a(message.data.func_189551_b(new CompoundNBT()));
      }

      public static void handler(ExtrautilitiesrebirthModVariables.WorldSavedDataSyncMessage message, Supplier<Context> contextSupplier) {
         Context context = (Context)contextSupplier.get();
         context.enqueueWork(() -> {
            if (!context.getDirection().getReceptionSide().isServer()) {
               if (message.type == 0) {
                  ExtrautilitiesrebirthModVariables.MapVariables.clientSide = (ExtrautilitiesrebirthModVariables.MapVariables)message.data;
               } else {
                  ExtrautilitiesrebirthModVariables.WorldVariables.clientSide = (ExtrautilitiesrebirthModVariables.WorldVariables)message.data;
               }
            }

         });
         context.setPacketHandled(true);
      }
   }

   public static class MapVariables extends WorldSavedData {
      public static final String DATA_NAME = "extrautilitiesrebirth_mapvars";
      public double quarry_x = 0.0D;
      public double quarry_z = 0.0D;
      public double quarry_y = 0.0D;
      static ExtrautilitiesrebirthModVariables.MapVariables clientSide = new ExtrautilitiesrebirthModVariables.MapVariables();

      public MapVariables() {
         super("extrautilitiesrebirth_mapvars");
      }

      public MapVariables(String s) {
         super(s);
      }

      public void func_76184_a(CompoundNBT nbt) {
         this.quarry_x = nbt.func_74769_h("quarry_x");
         this.quarry_z = nbt.func_74769_h("quarry_z");
         this.quarry_y = nbt.func_74769_h("quarry_y");
      }

      public CompoundNBT func_189551_b(CompoundNBT nbt) {
         nbt.func_74780_a("quarry_x", this.quarry_x);
         nbt.func_74780_a("quarry_z", this.quarry_z);
         nbt.func_74780_a("quarry_y", this.quarry_y);
         return nbt;
      }

      public void syncData(IWorld world) {
         this.func_76185_a();
         if (world instanceof World && !world.func_201670_d()) {
            ExtrautilitiesrebirthMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new ExtrautilitiesrebirthModVariables.WorldSavedDataSyncMessage(0, this));
         }

      }

      public static ExtrautilitiesrebirthModVariables.MapVariables get(IWorld world) {
         return world instanceof IServerWorld ? (ExtrautilitiesrebirthModVariables.MapVariables)((IServerWorld)world).func_201672_e().func_73046_m().func_71218_a(World.field_234918_g_).func_217481_x().func_215752_a(ExtrautilitiesrebirthModVariables.MapVariables::new, "extrautilitiesrebirth_mapvars") : clientSide;
      }
   }

   public static class WorldVariables extends WorldSavedData {
      public static final String DATA_NAME = "extrautilitiesrebirth_worldvars";
      static ExtrautilitiesrebirthModVariables.WorldVariables clientSide = new ExtrautilitiesrebirthModVariables.WorldVariables();

      public WorldVariables() {
         super("extrautilitiesrebirth_worldvars");
      }

      public WorldVariables(String s) {
         super(s);
      }

      public void func_76184_a(CompoundNBT nbt) {
      }

      public CompoundNBT func_189551_b(CompoundNBT nbt) {
         return nbt;
      }

      public void syncData(IWorld world) {
         this.func_76185_a();
         if (world instanceof World && !world.func_201670_d()) {
            SimpleChannel var10000 = ExtrautilitiesrebirthMod.PACKET_HANDLER;
            PacketDistributor var10001 = PacketDistributor.DIMENSION;
            World var10002 = (World)world;
            ((World)world).getClass();
            var10000.send(var10001.with(var10002::func_234923_W_), new ExtrautilitiesrebirthModVariables.WorldSavedDataSyncMessage(1, this));
         }

      }

      public static ExtrautilitiesrebirthModVariables.WorldVariables get(IWorld world) {
         return world instanceof ServerWorld ? (ExtrautilitiesrebirthModVariables.WorldVariables)((ServerWorld)world).func_217481_x().func_215752_a(ExtrautilitiesrebirthModVariables.WorldVariables::new, "extrautilitiesrebirth_worldvars") : clientSide;
      }
   }
}
