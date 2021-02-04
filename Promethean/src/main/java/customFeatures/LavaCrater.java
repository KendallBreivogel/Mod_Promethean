package customFeatures;

import java.util.Random;

import com.example.promethean.Promethean;
import com.mojang.serialization.Codec;

import init.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;

public class LavaCrater extends Feature<NoFeatureConfig>{

	public LavaCrater(Codec<NoFeatureConfig> codec) {
		super(codec);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos,
			NoFeatureConfig config) {
		generateCrater(reader, generator, rand, pos);
		return false;
	}
	
	private void generateCrater(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos){
		BlockPos.Mutable blockpos$mutable = pos.toMutable();
		//pos= pos.add(rand.nextInt(16)-8, 0, rand.nextInt(16)-8);
		//pos= pos.add(0, generator.getNoiseHeight(pos.getX(), pos.getZ(), Heightmap.Type.WORLD_SURFACE_WG)- 1, 0);
		
		int size= rand.nextInt(16)+ 8;
		if (!isValidLocation(world, generator, pos, size)) {
			return;
		}
		int[][] crater= initCraterLayout(size);
		crater= generateCraterLayout(crater, size/3, rand);
		buildCraterFromLayout(crater, world, generator, pos);
		
		Promethean.LOGGER.debug("LAVA CRATER with size "+ size+ " at " +
                pos.getX() + " " +
                pos.getY() + " " +
                pos.getZ());
	}
	
	private int[][] generateCraterLayout(int[][] layout, int steps, Random rand) {
		//generate pool shape
		for (int i= 0; i< steps- 1; i++) {
			for (int x= 0; x< layout[0].length- 1; x++) {
				for (int y= 0; y< layout.length- 1; y++) {
					if (isAdjacentTo(layout, x, y, 1, false)) {
						if (rand.nextInt(11) < 5) {
							layout[x][y] = 99;
						}
					}
				}
			}
			convertTo(layout, 1);
			//printLayout(layout);
		}
		//Pad with blackstone
		for (int x= 0; x< layout[0].length- 1; x++) {
			for (int y= 0; y< layout.length- 1; y++) {
				if (isAdjacentTo(layout, x, y, 1, true) && layout[x][y] == 0) {
					layout[x][y] = 2;
				}
			}
		}
		//Pad with smoldering sand
		for (int x= 0; x< layout[0].length- 1; x++) {
			for (int y= 0; y< layout.length- 1; y++) {
				if (isAdjacentTo(layout, x, y, 2, false) && layout[x][y] == 0) {
					if (rand.nextInt(11) < 3) {
						layout[x][y] = 3;
					}
				}
			}
		}
		for (int x= 0; x< layout[0].length- 1; x++) {
			for (int y= 0; y< layout.length- 1; y++) {
				if (isAdjacentTo(layout, x, y, 3, false) && layout[x][y] == 0) {
					if (rand.nextInt(11) < 3) {
						layout[x][y] = 99;
					}
				}
			}
		}
		convertTo(layout, 3);
		return layout;
	}
	
	private boolean isAdjacentTo(int[][] layout, int x, int y, int adjacent, boolean strict) {
		if (x> 0) {
			if (layout[x-1][y]== adjacent) return true;
			if (!strict) {
				if (y> 0) {
					if (layout[x-1][y-1]== adjacent) return true;
				}
				if (y< layout.length- 1) {
					if (layout[x-1][y+1]== adjacent) return true;
				}
			}
		}
		if (x< layout[0].length- 1) {
			if (layout[x+1][y]== adjacent) return true;
			if (!strict) {
				if (y> 0) {
					if (layout[x+1][y-1]== adjacent) return true;
				}
				if (y< layout.length- 1) {
					if (layout[x+1][y+1]== adjacent) return true;
				}
			}
		}
		if (y> 0) {
			if (layout[x][y-1]== adjacent) return true;
			if (!strict) {
				if (x> 0) {
					if (layout[x-1][y-1]== adjacent) return true;
				}
				if (x< layout.length- 1) {
					if (layout[x+1][y-1]== adjacent) return true;
				}
			}
		}
		if (y< layout.length- 1) {
			if (layout[x][y+1]== adjacent) return true;
			if (!strict) {
				if (x> 0) {
					if (layout[x-1][y+1]== adjacent) return true;
				}
				if (x< layout.length- 1) {
					if (layout[x+1][y+1]== adjacent) return true;
				}
			}
		}
		return false;
	}
	
	private int[][] initCraterLayout(int size) {
		int[][] crater= new int[size][size];
		for (int x= 0; x< size-1; x++) {
			for (int y= 0; y< size-1; y++) {
				crater[x][y]= 0;
			}
		}
		crater[size/2][size/2]= 1;
		return crater;
	}
	
	private int[][] convertTo(int[][] crater, int convert) {
		for (int x= 0; x< crater[0].length- 1; x++) {
			for (int y= 0; y< crater.length- 1; y++) {
				if (crater[x][y]== 99) {
					crater[x][y]= convert;
				}
			}
		}
		return crater;
	}
	
	private void buildCraterFromLayout(int[][] layout, ISeedReader world, ChunkGenerator generator, BlockPos pos) {
		BlockPos temp= pos;
		for (int x= 0; x< layout[0].length- 1; x++) {
			for (int y= 0; y< layout.length- 1; y++) {
				temp= pos.add(x- (layout[0].length/2), 0, y- (layout.length/2));
				if (layout[x][y]== 1) {
					world.setBlockState(temp, Blocks.LAVA.getDefaultState(), 2);
					temp= temp.add(0, 1, 0);
					world.setBlockState(temp, Blocks.AIR.getDefaultState(), 2);
				} else if (layout[x][y]== 2) {
					world.setBlockState(temp, Blocks.BLACKSTONE.getDefaultState(), 2);
					temp= temp.add(0, 1, 0);
					if (!world.getBlockState(temp).getMaterial().equals(Material.AIR)) world.setBlockState(temp, Blocks.BLACKSTONE.getDefaultState(), 2);
				} else if (layout[x][y]== 3) {
					world.setBlockState(temp, ModBlocks.VOLCANIC_SAND_HOT.get().getDefaultState(), 2);
					temp= temp.add(0, 1, 0);
					if (!world.getBlockState(temp).getMaterial().equals(Material.AIR)) world.setBlockState(temp, ModBlocks.VOLCANIC_SAND_HOT.get().getDefaultState(), 2);
					temp= temp.add(0, -2, 0);
					world.setBlockState(temp, Blocks.BLACKSTONE.getDefaultState(), 2);
				}
			}
		}
	}
	
	private boolean isValidLocation(ISeedReader world, ChunkGenerator generator, BlockPos pos, int size) {
		BlockPos temp= pos;
		for (int x= 0; x< size- 1; x++) {
			for (int y= 0; y< size; y++) {
				temp= pos.add(x- (size/2), 0, y- (size/2));
				if (world.getBlockState(temp).getMaterial().equals(Material.AIR) || world.getBlockState(temp).getMaterial().equals(Material.WATER)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private void printLayout(int[][] layout) {
		Promethean.LOGGER.debug("LAYOUT IS: ");
		for (int x= 0; x< layout[0].length- 1; x++) {
			String temp = "";
			for (int y= 0; y< layout.length- 1; y++) {
				temp = temp + layout[x][y] + " ";
			}
			Promethean.LOGGER.debug(temp);
		}
	}

}
