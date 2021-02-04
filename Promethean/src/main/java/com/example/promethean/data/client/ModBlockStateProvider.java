package com.example.promethean.data.client;

import com.example.promethean.Promethean;

import init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider{

	public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, Promethean.MODID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(ModBlocks.PROMETHEAN_ORE.get());
		simpleBlock(ModBlocks.PROMETHEAN_BLOCK.get());
	}
	
	
	
}
