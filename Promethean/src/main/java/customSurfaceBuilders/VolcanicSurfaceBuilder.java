package customSurfaceBuilders;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

import com.mojang.serialization.Codec;

public class VolcanicSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig>{

	public VolcanicSurfaceBuilder(Codec<SurfaceBuilderConfig> codec) {
		super(codec);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
		
		/*int xpos = x & 15;
        int zpos = z & 15;
        BlockPos.Mutable blockpos$Mutable = new BlockPos.Mutable();
        BlockState prevBlockState = defaultBlock;
        
        for (int ypos = 255; ypos >= 0; --ypos) {
			blockpos$Mutable.setPos(xpos, ypos, zpos);
            BlockState currentBlockState = chunkIn.getBlockState(blockpos$Mutable);

            if (currentBlockState.getMaterial() == Material.WATER) {
            	chunkIn.setBlockState(blockpos$Mutable, config.getUnderWaterMaterial(), false);
            }
            
            prevBlockState = currentBlockState;
        }*/
		
	}

}
