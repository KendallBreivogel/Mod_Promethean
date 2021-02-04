package com.example.promethean;

import init.ModStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;

public class PROMConfiguredStructures {
	public static StructureFeature<?, ?> CONFIGURED_PROMETHEAN_LIGHTHOUSE = ModStructures.PROMETHEAN_LIGHTHOUSE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static StructureFeature<?, ?> CONFIGURED_PROMETHEAN_ARENA = ModStructures.PROMETHEAN_ARENA.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static StructureFeature<?, ?> CONFIGURED_PROMETHEAN_STATUE = ModStructures.PROMETHEAN_STATUE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static StructureFeature<?, ?> CONFIGURED_PROMETHEAN_TOMB = ModStructures.PROMETHEAN_TOMB.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static StructureFeature<?, ?> CONFIGURED_PROMETHEAN_AQUEDUCT = ModStructures.PROMETHEAN_AQUEDUCT.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static StructureFeature<?, ?> CONFIGURED_PROMETHEAN_BRIDGE = ModStructures.PROMETHEAN_BRIDGE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static StructureFeature<?, ?> CONFIGURED_PROMETHEAN_CHAPEL = ModStructures.PROMETHEAN_CHAPEL.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static StructureFeature<?, ?> CONFIGURED_PROMETHEAN_MAUSOLEUM = ModStructures.PROMETHEAN_MAUSOLEUM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static StructureFeature<?, ?> CONFIGURED_PROMETHEAN_OBSERVATORY = ModStructures.PROMETHEAN_OBSERVATORY.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	
	public static void registerConfiguredStructures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(Promethean.MODID, "configured_promethean_lighthouse"), CONFIGURED_PROMETHEAN_LIGHTHOUSE);
        Registry.register(registry, new ResourceLocation(Promethean.MODID, "configured_promethean_arena"), CONFIGURED_PROMETHEAN_ARENA);
        Registry.register(registry, new ResourceLocation(Promethean.MODID, "configured_promethean_statue"), CONFIGURED_PROMETHEAN_STATUE);
        Registry.register(registry, new ResourceLocation(Promethean.MODID, "configured_promethean_tomb"), CONFIGURED_PROMETHEAN_TOMB);
        Registry.register(registry, new ResourceLocation(Promethean.MODID, "configured_promethean_aqueduct"), CONFIGURED_PROMETHEAN_AQUEDUCT);
        Registry.register(registry, new ResourceLocation(Promethean.MODID, "configured_promethean_bridge"), CONFIGURED_PROMETHEAN_BRIDGE);
        Registry.register(registry, new ResourceLocation(Promethean.MODID, "configured_promethean_chapel"), CONFIGURED_PROMETHEAN_CHAPEL);
        Registry.register(registry, new ResourceLocation(Promethean.MODID, "configured_promethean_mausoleum"), CONFIGURED_PROMETHEAN_MAUSOLEUM);
        Registry.register(registry, new ResourceLocation(Promethean.MODID, "configured_promethean_observatory"), CONFIGURED_PROMETHEAN_OBSERVATORY);

        // Ok so, this part may be hard to grasp but basically, just add your structure to this to
        // prevent any sort of crash or issue with other mod's custom ChunkGenerators. If they use
        // FlatGenerationSettings.STRUCTURES in it and you don't add your structure to it, the game
        // could crash later when you attempt to add the StructureSeparationSettings to the dimension.
        //
        // (It would also crash with superflat worldtype if you omit the below line
        //  and attempt to add the structure's StructureSeparationSettings to the world)
        //
        // Note: If you want your structure to spawn in superflat, remove the FlatChunkGenerator check
        // in StructureTutorialMain.addDimensionalSpacing and then create a superflat world, exit it,
        // and re-enter it and your structures will be spawning. I could not figure out why it needs
        // the restart but honestly, superflat is really buggy and shouldn't be your main focus in my opinion.
        FlatGenerationSettings.STRUCTURES.put(ModStructures.PROMETHEAN_LIGHTHOUSE.get(), CONFIGURED_PROMETHEAN_LIGHTHOUSE);
        FlatGenerationSettings.STRUCTURES.put(ModStructures.PROMETHEAN_ARENA.get(), CONFIGURED_PROMETHEAN_ARENA);
        FlatGenerationSettings.STRUCTURES.put(ModStructures.PROMETHEAN_STATUE.get(), CONFIGURED_PROMETHEAN_STATUE);
        FlatGenerationSettings.STRUCTURES.put(ModStructures.PROMETHEAN_TOMB.get(), CONFIGURED_PROMETHEAN_TOMB);
        FlatGenerationSettings.STRUCTURES.put(ModStructures.PROMETHEAN_AQUEDUCT.get(), CONFIGURED_PROMETHEAN_AQUEDUCT);
        FlatGenerationSettings.STRUCTURES.put(ModStructures.PROMETHEAN_BRIDGE.get(), CONFIGURED_PROMETHEAN_BRIDGE);
        FlatGenerationSettings.STRUCTURES.put(ModStructures.PROMETHEAN_CHAPEL.get(), CONFIGURED_PROMETHEAN_CHAPEL);
        FlatGenerationSettings.STRUCTURES.put(ModStructures.PROMETHEAN_MAUSOLEUM.get(), CONFIGURED_PROMETHEAN_MAUSOLEUM);
        FlatGenerationSettings.STRUCTURES.put(ModStructures.PROMETHEAN_OBSERVATORY.get(), CONFIGURED_PROMETHEAN_OBSERVATORY);
    }
}
