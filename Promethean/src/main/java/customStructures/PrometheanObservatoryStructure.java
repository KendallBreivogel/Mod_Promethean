package customStructures;

import com.example.promethean.Promethean;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;
import org.apache.logging.log4j.Level;

import java.util.List;

public class PrometheanObservatoryStructure extends Structure<NoFeatureConfig>{
	public PrometheanObservatoryStructure(Codec<NoFeatureConfig> codec) {
		super(codec);
		//Structure.NAME_STRUCTURE_BIMAP.put(this.getRegistryName().toString(), this);
	}
	
	@Override
    public  IStartFactory<NoFeatureConfig> getStartFactory() {
        return PrometheanObservatoryStructure.Start::new;
    }
	
	@Override
	public GenerationStage.Decoration getDecorationStage() {
		return GenerationStage.Decoration.SURFACE_STRUCTURES;
	}
	
    private static final List<MobSpawnInfo.Spawners> STRUCTURE_MONSTERS = ImmutableList.of(
            new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 9),
            new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 9)
    );
    @Override
    public List<MobSpawnInfo.Spawners> getDefaultSpawnList() {
        return STRUCTURE_MONSTERS;
    }

    private static final List<MobSpawnInfo.Spawners> STRUCTURE_CREATURES = ImmutableList.of(
            new MobSpawnInfo.Spawners(EntityType.BAT, 30, 10, 15)
    );
    @Override
    public List<MobSpawnInfo.Spawners> getDefaultCreatureSpawnList() {
        return STRUCTURE_CREATURES;
    }
    /**
     * Handles calling up the structure's pieces class and height that structure will spawn at.
     */
    public static class Start extends StructureStart<NoFeatureConfig>  {
    	public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
    		super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
    	}


    	@Override
    	public void func_230364_a_(DynamicRegistries dynamicRegistryManager, ChunkGenerator chunkGenerator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig config) {

    		// Turns the chunk coordinates into actual coordinates we can use. (Gets center of that chunk)
    		int x = (chunkX << 4) + 7;
    		int z = (chunkZ << 4) + 7;

            BlockPos blockpos = new BlockPos(x, 0, z);

            JigsawManager.func_242837_a(
                    dynamicRegistryManager,
                    new VillageConfig(() -> dynamicRegistryManager.getRegistry(Registry.JIGSAW_POOL_KEY)
                            .getOrDefault(new ResourceLocation(Promethean.MODID, "promethean_observatory/start_pool")),
                            10),
                    AbstractVillagePiece::new,
                    chunkGenerator,
                    templateManagerIn,
                    blockpos, // Position of the structure. Y value is ignored if last parameter is set to true.
                    this.components, // The list that will be populated with the jigsaw pieces after this method.
                    this.rand,
                    false,
                    true);
            
            
            MutableBoundingBox mutableboundingbox = this.components.get(0).getBoundingBox();
            int i = (mutableboundingbox.maxX + mutableboundingbox.minX) / 2;
            int j = (mutableboundingbox.maxZ + mutableboundingbox.minZ) / 2;
            if (chunkGenerator.getNoiseHeight(i, j, Heightmap.Type.WORLD_SURFACE_WG) <= 0) {
            	Promethean.LOGGER.debug("Observatory generated low at "+ chunkGenerator.getNoiseHeight(i, j, Heightmap.Type.WORLD_SURFACE_WG));
            }


            //this.components.forEach(piece -> piece.offset(0, 1, 0));
            this.components.forEach(piece -> piece.getBoundingBox().minY -= 1);
            

            this.recalculateStructureSize();

            Promethean.LOGGER.debug("Observatory at " +
                            this.components.get(0).getBoundingBox().minX + " " +
                            this.components.get(0).getBoundingBox().minY + " " +
                            this.components.get(0).getBoundingBox().minZ);
        }
    }
}