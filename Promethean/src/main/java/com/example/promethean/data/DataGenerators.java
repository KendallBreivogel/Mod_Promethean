package com.example.promethean.data;

import com.example.promethean.Promethean;
import com.example.promethean.data.client.ModBlockStateProvider;
import com.example.promethean.data.client.ModBlockTagsProvider;
import com.example.promethean.data.client.ModItemModelProvider;
import com.example.promethean.data.client.ModItemTagsProvider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@EventBusSubscriber(modid = Promethean.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
	
	
	private DataGenerators() {}
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		
		gen.addProvider(new ModBlockStateProvider(gen, existingFileHelper));
		gen.addProvider(new ModItemModelProvider(gen, existingFileHelper));
		
		ModBlockTagsProvider blockTags= new ModBlockTagsProvider(gen, existingFileHelper);
		gen.addProvider(blockTags);
		gen.addProvider(new ModItemTagsProvider(gen, blockTags, existingFileHelper));
	}
}
