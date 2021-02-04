package init;

import com.example.promethean.Promethean;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import customStructures.PrometheanAqueductStructure;
import customStructures.PrometheanArenaStructure;
import customStructures.PrometheanBridgeStructure;
import customStructures.PrometheanChapelStructure;
import customStructures.PrometheanLighthouseStructure;
import customStructures.PrometheanMausoleumStructure;
import customStructures.PrometheanObservatoryStructure;
import customStructures.PrometheanStatueStructure;
import customStructures.PrometheanTombStructure;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModStructures {
	public static final DeferredRegister<Structure<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, Promethean.MODID);
	
	public static final RegistryObject<Structure<NoFeatureConfig>> PROMETHEAN_LIGHTHOUSE = registerStructure("promethean_lighthouse", () -> (new PrometheanLighthouseStructure(NoFeatureConfig.field_236558_a_)));
	public static final RegistryObject<Structure<NoFeatureConfig>> PROMETHEAN_ARENA = registerStructure("promethean_arena", () -> (new PrometheanArenaStructure(NoFeatureConfig.field_236558_a_)));
	public static final RegistryObject<Structure<NoFeatureConfig>> PROMETHEAN_STATUE = registerStructure("promethean_statue", () -> (new PrometheanStatueStructure(NoFeatureConfig.field_236558_a_)));
	public static final RegistryObject<Structure<NoFeatureConfig>> PROMETHEAN_TOMB = registerStructure("promethean_tomb", () -> (new PrometheanTombStructure(NoFeatureConfig.field_236558_a_)));
	public static final RegistryObject<Structure<NoFeatureConfig>> PROMETHEAN_AQUEDUCT = registerStructure("promethean_aqueduct", () -> (new PrometheanAqueductStructure(NoFeatureConfig.field_236558_a_)));
	public static final RegistryObject<Structure<NoFeatureConfig>> PROMETHEAN_BRIDGE = registerStructure("promethean_bridge", () -> (new PrometheanBridgeStructure(NoFeatureConfig.field_236558_a_)));
	public static final RegistryObject<Structure<NoFeatureConfig>> PROMETHEAN_CHAPEL = registerStructure("promethean_chapel", () -> (new PrometheanChapelStructure(NoFeatureConfig.field_236558_a_)));
	public static final RegistryObject<Structure<NoFeatureConfig>> PROMETHEAN_MAUSOLEUM = registerStructure("promethean_mausoleum", () -> (new PrometheanMausoleumStructure(NoFeatureConfig.field_236558_a_)));
	public static final RegistryObject<Structure<NoFeatureConfig>> PROMETHEAN_OBSERVATORY = registerStructure("promethean_observatory", () -> (new PrometheanObservatoryStructure(NoFeatureConfig.field_236558_a_)));
	
	private static <T extends Structure<?>> RegistryObject<T> registerStructure(String name, Supplier<T> structure) {
		return DEFERRED_REGISTRY_STRUCTURE.register(name, structure);
	}
	
	public static void setupStructures() {
		setupMapSpacingAndLand(
				PROMETHEAN_LIGHTHOUSE.get(), /* The instance of the structure */
				new StructureSeparationSettings(75 /* maximum distance apart in chunks between spawn attempts */,
						30 /* minimum distance apart in chunks between spawn attempts */,
						456745675 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
				true);
		setupMapSpacingAndLand(
				PROMETHEAN_ARENA.get(), /* The instance of the structure */
				new StructureSeparationSettings(200 /* maximum distance apart in chunks between spawn attempts */,
						100 /* minimum distance apart in chunks between spawn attempts */,
						234345345 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
				true);
		setupMapSpacingAndLand(
				PROMETHEAN_STATUE.get(), /* The instance of the structure */
				new StructureSeparationSettings(175 /* maximum distance apart in chunks between spawn attempts */,
						130 /* minimum distance apart in chunks between spawn attempts */,
						456546346 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
				true);
		setupMapSpacingAndLand(
				PROMETHEAN_TOMB.get(), /* The instance of the structure */
				new StructureSeparationSettings(55 /* maximum distance apart in chunks between spawn attempts */,
						30 /* minimum distance apart in chunks between spawn attempts */,
						345667832 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
				true);
		setupMapSpacingAndLand(
				PROMETHEAN_AQUEDUCT.get(), /* The instance of the structure */
				new StructureSeparationSettings(100 /* maximum distance apart in chunks between spawn attempts */,
						45 /* minimum distance apart in chunks between spawn attempts */,
						145745345 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
				true);
		setupMapSpacingAndLand(
				PROMETHEAN_BRIDGE.get(), /* The instance of the structure */
				new StructureSeparationSettings(125 /* maximum distance apart in chunks between spawn attempts */,
						75 /* minimum distance apart in chunks between spawn attempts */,
						567834567 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
				true);
		setupMapSpacingAndLand(
				PROMETHEAN_CHAPEL.get(), /* The instance of the structure */
				new StructureSeparationSettings(165 /* maximum distance apart in chunks between spawn attempts */,
						100 /* minimum distance apart in chunks between spawn attempts */,
						345678467 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
				true);
		setupMapSpacingAndLand(
				PROMETHEAN_MAUSOLEUM.get(), /* The instance of the structure */
				new StructureSeparationSettings(55 /* maximum distance apart in chunks between spawn attempts */,
						30 /* minimum distance apart in chunks between spawn attempts */,
						567856645 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
				true);
		setupMapSpacingAndLand(
				PROMETHEAN_OBSERVATORY.get(), /* The instance of the structure */
				new StructureSeparationSettings(125 /* maximum distance apart in chunks between spawn attempts */,
						75 /* minimum distance apart in chunks between spawn attempts */,
						567234831 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
				true);
	}
	
	public static <F extends Structure<?>> void setupMapSpacingAndLand(
			F structure,
			StructureSeparationSettings structureSeparationSettings,
			boolean transformSurroundingLand)
	{
		Structure.NAME_STRUCTURE_BIMAP.put(structure.getRegistryName().toString(), structure);

		if(transformSurroundingLand){
			Structure.field_236384_t_ =
					ImmutableList.<Structure<?>>builder()
					.addAll(Structure.field_236384_t_)
					.add(structure)
					.build();
		}
		
		DimensionStructuresSettings.field_236191_b_ =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.field_236191_b_)
                        .put(structure, structureSeparationSettings)
                        .build();
	}
}
