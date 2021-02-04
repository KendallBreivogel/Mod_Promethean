package com.example.promethean.data.client;

import com.example.promethean.Promethean;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider{
	public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Promethean.MODID, existingFileHelper);
	}
	
	private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
	
	@Override
	protected void registerModels() {
		withExistingParent("promethean_ore", modLoc("block/promethean_ore"));
		withExistingParent("promethean_block", modLoc("block/promethean_block"));
		
		ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
		
		builder(itemGenerated, "promethean_ingot");
	}
}
