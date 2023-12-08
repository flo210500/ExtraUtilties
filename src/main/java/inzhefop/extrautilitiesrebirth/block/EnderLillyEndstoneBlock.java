package inzhefop.extrautilitiesrebirth.block;

import com.mojang.serialization.Codec;
import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.itemgroup.TabItemGroup;
import inzhefop.extrautilitiesrebirth.procedures.EnderLillyStage1AdditionalGenerationConditionProcedure;
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
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.Properties;
import net.minecraft.loot.LootContext.Builder;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.IRuleTestType;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class EnderLillyEndstoneBlock extends ExtrautilitiesrebirthModElements.ModElement {
   @ObjectHolder("extrautilitiesrebirth:ender_lilly_endstone")
   public static final Block block = null;
   private static Feature<OreFeatureConfig> feature = null;
   private static ConfiguredFeature<?, ?> configuredFeature = null;
   private static IRuleTestType<EnderLillyEndstoneBlock.CustomRuleTest> CUSTOM_MATCH = null;

   public EnderLillyEndstoneBlock(ExtrautilitiesrebirthModElements instance) {
      super(instance, 39);
      MinecraftForge.EVENT_BUS.register(this);
      FMLJavaModLoadingContext.get().getModEventBus().register(new EnderLillyEndstoneBlock.FeatureRegisterHandler());
   }

   public void initElements() {
      this.elements.blocks.add(() -> {
         return new EnderLillyEndstoneBlock.CustomBlock();
      });
      this.elements.items.add(() -> {
         return (Item)(new BlockItem(block, (new Properties()).func_200916_a(TabItemGroup.tab))).setRegistryName(block.getRegistryName());
      });
   }

   @SubscribeEvent
   public void addFeatureToBiomes(BiomeLoadingEvent event) {
      event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> {
         return configuredFeature;
      });
   }

   private static class FeatureRegisterHandler {
      private FeatureRegisterHandler() {
      }

      @SubscribeEvent
      public void registerFeature(Register<Feature<?>> event) {
         EnderLillyEndstoneBlock.CUSTOM_MATCH = (IRuleTestType)Registry.func_218322_a(Registry.field_218363_D, new ResourceLocation("extrautilitiesrebirth:ender_lilly_endstone_match"), () -> {
            return EnderLillyEndstoneBlock.CustomRuleTest.codec;
         });
         EnderLillyEndstoneBlock.feature = new OreFeature(OreFeatureConfig.field_236566_a_) {
            public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {
               RegistryKey<World> dimensionType = world.func_201672_e().func_234923_W_();
               boolean dimensionCriteria = false;
               if (dimensionType == World.field_234920_i_) {
                  dimensionCriteria = true;
               }

               if (!dimensionCriteria) {
                  return false;
               } else {
                  int x = pos.func_177958_n();
                  int y = pos.func_177956_o();
                  int z = pos.func_177952_p();
                  return !EnderLillyStage1AdditionalGenerationConditionProcedure.executeProcedure((Map)Stream.of(new SimpleEntry("world", world), new SimpleEntry("x", x), new SimpleEntry("y", y), new SimpleEntry("z", z)).collect(HashMap::new, (_m, _e) -> {
                     _m.put(_e.getKey(), _e.getValue());
                  }, Map::putAll)) ? false : super.func_241855_a(world, generator, rand, pos, config);
               }
            }
         };
         EnderLillyEndstoneBlock.configuredFeature = (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature)EnderLillyEndstoneBlock.feature.func_225566_b_(new OreFeatureConfig(EnderLillyEndstoneBlock.CustomRuleTest.INSTANCE, EnderLillyEndstoneBlock.block.func_176223_P(), 4)).func_242733_d(64)).func_242728_a()).func_242731_b(32);
         event.getRegistry().register(EnderLillyEndstoneBlock.feature.setRegistryName("ender_lilly_endstone"));
         Registry.func_218322_a(WorldGenRegistries.field_243653_e, new ResourceLocation("extrautilitiesrebirth:ender_lilly_endstone"), EnderLillyEndstoneBlock.configuredFeature);
      }

      // $FF: synthetic method
      FeatureRegisterHandler(Object x0) {
         this();
      }
   }

   private static class CustomRuleTest extends RuleTest {
      static final EnderLillyEndstoneBlock.CustomRuleTest INSTANCE = new EnderLillyEndstoneBlock.CustomRuleTest();
      static final Codec<EnderLillyEndstoneBlock.CustomRuleTest> codec = Codec.unit(() -> {
         return INSTANCE;
      });

      public boolean func_215181_a(BlockState blockAt, Random random) {
         boolean blockCriteria = false;
         if (blockAt.func_177230_c() == Blocks.field_150377_bs) {
            blockCriteria = true;
         }

         return blockCriteria;
      }

      protected IRuleTestType<?> func_215180_a() {
         return EnderLillyEndstoneBlock.CUSTOM_MATCH;
      }
   }

   public static class CustomBlock extends Block {
      public CustomBlock() {
         super(net.minecraft.block.AbstractBlock.Properties.func_200945_a(Material.field_151576_e).func_200947_a(SoundType.field_185851_d).func_200948_a(2.0F, 50.0F).func_235838_a_((s) -> {
            return 0;
         }).harvestLevel(3).harvestTool(ToolType.PICKAXE));
         this.setRegistryName("ender_lilly_endstone");
      }

      public int func_200011_d(BlockState state, IBlockReader worldIn, BlockPos pos) {
         return 15;
      }

      public List<ItemStack> func_220076_a(BlockState state, Builder builder) {
         List<ItemStack> dropsOriginal = super.func_220076_a(state, builder);
         return !dropsOriginal.isEmpty() ? dropsOriginal : Collections.singletonList(new ItemStack(EnderLillyStage1Block.block));
      }
   }
}
