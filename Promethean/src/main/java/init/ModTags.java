package init;

import com.example.promethean.Promethean;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
	public static final class Blocks {
		public static final ITag.INamedTag<Block> ORES_PROMETHEAN = forge("ores/promethean");
		public static final ITag.INamedTag<Block> STORAGE_BLOCKS_PROMETHEAN = forge("storage_blocks/promethean");
				
		private static ITag.INamedTag<Block> forge(String path) {
			return BlockTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
		}
		
		private static ITag.INamedTag<Block> mod(String path) {
			return BlockTags.makeWrapperTag(new ResourceLocation(Promethean.MODID, path).toString());
		}
	} 
	
	public static final class Items {
		public static final ITag.INamedTag<Item> ORES_PROMETHEAN = forge("ores/promethean");
		public static final ITag.INamedTag<Item> STORAGE_BLOCKS_PROMETHEAN = forge("storage_blocks/promethean");
		public static final ITag.INamedTag<Item> INGOT_PROMETHEAN = forge("ingots/promethean");
		public static final ITag.INamedTag<Item> DUST_PROMETHEAN = forge("dusts/promethean");
		
		private static ITag.INamedTag<Item> forge(String path) {
			return ItemTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
		}
		
		private static ITag.INamedTag<Item> mod(String path) {
			return ItemTags.makeWrapperTag(new ResourceLocation(Promethean.MODID, path).toString());
		}
	}
}
