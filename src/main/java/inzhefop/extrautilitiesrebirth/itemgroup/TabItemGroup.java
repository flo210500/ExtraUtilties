package inzhefop.extrautilitiesrebirth.itemgroup;

import inzhefop.extrautilitiesrebirth.ExtrautilitiesrebirthModElements;
import inzhefop.extrautilitiesrebirth.block.CreativeInvSampleBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@ExtrautilitiesrebirthModElements.ModElement.Tag
public class TabItemGroup extends ExtrautilitiesrebirthModElements.ModElement {
   public static ItemGroup tab;

   public TabItemGroup(ExtrautilitiesrebirthModElements instance) {
      super(instance, 154);
   }

   public void initElements() {
      tab = new ItemGroup("tabtab") {
         @OnlyIn(Dist.CLIENT)
         public ItemStack func_78016_d() {
            return new ItemStack(CreativeInvSampleBlock.block);
         }

         @OnlyIn(Dist.CLIENT)
         public boolean hasSearchBar() {
            return false;
         }
      };
   }
}
