package inzhefop.extrautilitiesrebirth;

import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("extrautilitiesrebirth")
public class ExtrautilitiesrebirthMod {
   public static final Logger LOGGER = LogManager.getLogger(ExtrautilitiesrebirthMod.class);
   private static final String PROTOCOL_VERSION = "1";
   public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation("extrautilitiesrebirth", "extrautilitiesrebirth"), () -> {
      return "1";
   }, "1"::equals, "1"::equals);
   public ExtrautilitiesrebirthModElements elements = new ExtrautilitiesrebirthModElements();

   public ExtrautilitiesrebirthMod() {
      FMLJavaModLoadingContext.get().getModEventBus().register(this);
      FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
      FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientLoad);
      MinecraftForge.EVENT_BUS.register(new ExtrautilitiesrebirthMod.ExtrautilitiesrebirthModFMLBusEvents(this));
   }

   private void init(FMLCommonSetupEvent event) {
      this.elements.getElements().forEach((element) -> {
         element.init(event);
      });
   }

   public void clientLoad(FMLClientSetupEvent event) {
      this.elements.getElements().forEach((element) -> {
         element.clientLoad(event);
      });
   }

   @SubscribeEvent
   public void registerBlocks(Register<Block> event) {
      event.getRegistry().registerAll((IForgeRegistryEntry[])this.elements.getBlocks().stream().map(Supplier::get).toArray((x$0) -> {
         return new Block[x$0];
      }));
   }

   @SubscribeEvent
   public void registerItems(Register<Item> event) {
      event.getRegistry().registerAll((IForgeRegistryEntry[])this.elements.getItems().stream().map(Supplier::get).toArray((x$0) -> {
         return new Item[x$0];
      }));
   }

   @SubscribeEvent
   public void registerEntities(Register<EntityType<?>> event) {
      event.getRegistry().registerAll((IForgeRegistryEntry[])this.elements.getEntities().stream().map(Supplier::get).toArray((x$0) -> {
         return new EntityType[x$0];
      }));
   }

   @SubscribeEvent
   public void registerEnchantments(Register<Enchantment> event) {
      event.getRegistry().registerAll((IForgeRegistryEntry[])this.elements.getEnchantments().stream().map(Supplier::get).toArray((x$0) -> {
         return new Enchantment[x$0];
      }));
   }

   @SubscribeEvent
   public void registerSounds(Register<SoundEvent> event) {
      this.elements.registerSounds(event);
   }

   private static class ExtrautilitiesrebirthModFMLBusEvents {
      private final ExtrautilitiesrebirthMod parent;

      ExtrautilitiesrebirthModFMLBusEvents(ExtrautilitiesrebirthMod parent) {
         this.parent = parent;
      }

      @SubscribeEvent
      public void serverLoad(FMLServerStartingEvent event) {
         this.parent.elements.getElements().forEach((element) -> {
            element.serverLoad(event);
         });
      }
   }
}
