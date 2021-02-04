package com.example.promethean.data.client;

import com.example.promethean.Promethean;

import init.ModBlocks;
import init.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider{

	public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
		super(generatorIn, Promethean.MODID, existingFileHelper);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void registerTags() {
		getOrCreateBuilder(ModTags.Blocks.ORES_PROMETHEAN).add(ModBlocks.PROMETHEAN_ORE.get());
		getOrCreateBuilder(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_PROMETHEAN);
		getOrCreateBuilder(ModTags.Blocks.STORAGE_BLOCKS_PROMETHEAN).add(ModBlocks.PROMETHEAN_BLOCK.get());
		getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_PROMETHEAN);
	}

}
