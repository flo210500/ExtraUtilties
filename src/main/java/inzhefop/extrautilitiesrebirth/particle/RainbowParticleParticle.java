package inzhefop.extrautilitiesrebirth.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class RainbowParticleParticle {
   public static final BasicParticleType particle = new BasicParticleType(false);

   @SubscribeEvent
   public static void registerParticleType(Register<ParticleType<?>> event) {
      event.getRegistry().register(particle.setRegistryName("rainbow_particle"));
   }

   @OnlyIn(Dist.CLIENT)
   @SubscribeEvent
   public static void registerParticle(ParticleFactoryRegisterEvent event) {
      Minecraft.func_71410_x().field_71452_i.func_215234_a(particle, RainbowParticleParticle.CustomParticleFactory::new);
   }

   @OnlyIn(Dist.CLIENT)
   private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
      private final IAnimatedSprite spriteSet;

      public CustomParticleFactory(IAnimatedSprite spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         return new RainbowParticleParticle.CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
      }
   }

   @OnlyIn(Dist.CLIENT)
   private static class CustomParticle extends SpriteTexturedParticle {
      private final IAnimatedSprite spriteSet;

      protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
         super(world, x, y, z);
         this.spriteSet = spriteSet;
         this.func_187115_a(0.2F, 0.2F);
         this.field_70544_f *= 0.4F;
         this.field_70547_e = 5;
         this.field_70545_g = 0.0F;
         this.field_190017_n = false;
         this.field_187129_i = vx * 1.0D;
         this.field_187130_j = vy * 1.0D;
         this.field_187131_k = vz * 1.0D;
         this.func_217568_a(spriteSet);
      }

      public IParticleRenderType func_217558_b() {
         return IParticleRenderType.field_217603_c;
      }

      public void func_189213_a() {
         super.func_189213_a();
      }
   }
}
