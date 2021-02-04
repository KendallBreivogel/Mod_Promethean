package com.example.promethean.data.client;

import com.example.promethean.Promethean;

import init.ModItems;
import init.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider{

	public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
		super(dataGenerator, blockTagProvider, Promethean.MODID, existingFileHelper);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void registerTags() {
		copy(ModTags.Blocks.ORES_PROMETHEAN, ModTags.Items.ORES_PROMETHEAN);
		copy(Tags.Blocks.ORES, Tags.Items.ORES);
		copy(ModTags.Blocks.STORAGE_BLOCKS_PROMETHEAN, ModTags.Items.STORAGE_BLOCKS_PROMETHEAN);
		copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
		
		getOrCreateBuilder(ModTags.Items.INGOT_PROMETHEAN).add(ModItems.PROMETHEAN_INGOT.get());
		getOrCreateBuilder(Tags.Items.INGOTS).add(ModItems.PROMETHEAN_INGOT.get());
	}

}
