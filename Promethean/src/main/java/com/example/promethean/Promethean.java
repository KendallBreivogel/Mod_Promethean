package com.example.promethean;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import init.ModBiomes;
import init.ModBlocks;
import init.ModFeatures;
import init.ModItems;
import init.ModStructures;
import init.ModSurfaceBuilders;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.BiomeManager;
import net.minecraft.world.biome.Biome;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("promethean")
public class Promethean
{
	public static final String MODID = "promethean";
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	public Promethean() {
		
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ModBlocks.register();
		ModItems.register();
		ModBiomes.BIOMES.register(modEventBus);
		ModSurfaceBuilders.SURFACE_BUILDERS.register(modEventBus);
		ModFeatures.FEATURES.register(modEventBus);
		ModStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
		LOGGER.debug("Hello from kendall's first mod!");
		
        modEventBus.addListener(this::setup);
        
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);
        
        forgeBus.addListener(EventPriority.HIGH, this::biomeModification);
        
        BiomeManager.BiomeEntry BE= new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Promethean.MODID, "volcanic")), 100);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, BE);
	}
	
	public void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ModStructures.setupStructures();
            PROMConfiguredStructures.registerConfiguredStructures();
            PROMConfiguredFeatures.registerConfiguredFeatures();
        });
    }
	
	public void biomeModification(final BiomeLoadingEvent event) {
        // Add our structure to all biomes including other modded biomes.
        // You can skip or add only to certain biomes based on stuff like biome category,
        // temperature, scale, precipitation, mod id, etc. All kinds of options!
        //
        // You can even use the BiomeDictionary as well! To use BiomeDictionary, do
        // RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName()) to get the biome's
        // registrykey. Then that can be fed into the dictionary to get the biome's types.
		if (event.getCategory().equals(Biome.Category.BEACH)) {
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_LIGHTHOUSE);
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_OBSERVATORY);
		}
		if (event.getCategory().equals(Biome.Category.SWAMP)) {
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_LIGHTHOUSE);
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_STATUE);
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_TOMB);
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_MAUSOLEUM);
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_CHAPEL);
		}
		if (event.getCategory().equals(Biome.Category.FOREST)) {
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_LIGHTHOUSE);
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_STATUE);
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_MAUSOLEUM);
		}
		if (event.getCategory().equals(Biome.Category.DESERT)) {
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_ARENA);
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_TOMB);
		}
		if (event.getCategory().equals(Biome.Category.PLAINS)) {
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_LIGHTHOUSE);
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_ARENA);
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_TOMB);
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_CHAPEL);
		}
		if (event.getCategory().equals(Biome.Category.TAIGA)) {
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_STATUE);
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_MAUSOLEUM);
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_CHAPEL);
		}
		if (event.getCategory().equals(Biome.Category.EXTREME_HILLS)) {
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_LIGHTHOUSE);
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_OBSERVATORY);
		}
		if (event.getName().equals("volcanic")) {
			event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_LIGHTHOUSE);
		}
		event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_BRIDGE);
		event.getGeneration().getStructures().add(() -> PROMConfiguredStructures.CONFIGURED_PROMETHEAN_AQUEDUCT);
    }
	
	public void addDimensionalSpacing(final WorldEvent.Load event) {
        if(event.getWorld() instanceof ServerWorld){
            ServerWorld serverWorld = (ServerWorld)event.getWorld();

            // Prevent spawning our structure in Vanilla's superflat world as
            // people seem to want their superflat worlds free of modded structures.
            // Also that vanilla superflat is really tricky and buggy to work with in my experience.
            if(serverWorld.getChunkProvider().getChunkGenerator() instanceof FlatChunkGenerator &&
                serverWorld.getDimensionKey().equals(World.OVERWORLD)){
                return;
            }

            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_());
            // putIfAbsent so people can override the spacing with dimension datapacks themselves if they wish to customize spacing more precisely per dimension.
            tempMap.putIfAbsent(ModStructures.PROMETHEAN_LIGHTHOUSE.get(), DimensionStructuresSettings.field_236191_b_.get(ModStructures.PROMETHEAN_LIGHTHOUSE.get()));
            tempMap.putIfAbsent(ModStructures.PROMETHEAN_ARENA.get(), DimensionStructuresSettings.field_236191_b_.get(ModStructures.PROMETHEAN_ARENA.get()));
            tempMap.putIfAbsent(ModStructures.PROMETHEAN_STATUE.get(), DimensionStructuresSettings.field_236191_b_.get(ModStructures.PROMETHEAN_STATUE.get()));
            tempMap.putIfAbsent(ModStructures.PROMETHEAN_TOMB.get(), DimensionStructuresSettings.field_236191_b_.get(ModStructures.PROMETHEAN_TOMB.get()));
            tempMap.putIfAbsent(ModStructures.PROMETHEAN_AQUEDUCT.get(), DimensionStructuresSettings.field_236191_b_.get(ModStructures.PROMETHEAN_AQUEDUCT.get()));
            tempMap.putIfAbsent(ModStructures.PROMETHEAN_BRIDGE.get(), DimensionStructuresSettings.field_236191_b_.get(ModStructures.PROMETHEAN_BRIDGE.get()));
            tempMap.putIfAbsent(ModStructures.PROMETHEAN_CHAPEL.get(), DimensionStructuresSettings.field_236191_b_.get(ModStructures.PROMETHEAN_CHAPEL.get()));
            tempMap.putIfAbsent(ModStructures.PROMETHEAN_MAUSOLEUM.get(), DimensionStructuresSettings.field_236191_b_.get(ModStructures.PROMETHEAN_MAUSOLEUM.get()));
            tempMap.putIfAbsent(ModStructures.PROMETHEAN_OBSERVATORY.get(), DimensionStructuresSettings.field_236191_b_.get(ModStructures.PROMETHEAN_OBSERVATORY.get()));
            serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;
        }
   }
}
