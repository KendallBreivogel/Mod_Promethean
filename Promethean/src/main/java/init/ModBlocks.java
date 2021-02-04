package init;

import java.util.function.Supplier;
import com.example.promethean.Promethean;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Promethean.MODID);
	
	public static void register() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		BLOCKS.register(modEventBus);
	}
	
	private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
		return BLOCKS.register(name, block);
	}
	
	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
		RegistryObject<T> ret = registerNoItem(name, block);
		ModItems.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
		return ret;
	}
	
	public static int getLightValueDim(BlockState state) {
		return 7;
	}
	public static int getLightValueMid(BlockState state) {
		return 10;
	}
	public static int getLightValueBright(BlockState state) {
		return 15;
	}
	
	public static final RegistryObject<Block> PROMETHEAN_ORE = register("promethean_ore", () -> new Block(Block.Properties.create(Material.ROCK)
			.hardnessAndResistance(3.0F, 3.0F)
			.sound(SoundType.STONE)
			.setLightLevel(ModBlocks::getLightValueDim)));
	public static final RegistryObject<Block> PROMETHEAN_BLOCK = register("promethean_block", () -> new Block(Block.Properties.create(Material.IRON)
			.hardnessAndResistance(3.0F, 10.0F)
			.sound(SoundType.METAL)
			.setLightLevel(ModBlocks::getLightValueMid)));
	public static final RegistryObject<Block> PROMETHEAN_LAMP = register("promethean_lamp", () -> new Block(Block.Properties.create(Material.GLASS)
			.hardnessAndResistance(1.0F, 3.0F)
			.sound(SoundType.GLASS)
			.setLightLevel(ModBlocks::getLightValueBright)));
	public static final RegistryObject<Block> STAR_BLOCK = register("star_block", () -> new Block(Block.Properties.create(Material.GLASS)
			.hardnessAndResistance(100.0F, 0.5F)
			.sound(SoundType.GLASS)));
	public static final RegistryObject<Block> VOLCANIC_SAND = register("volcanic_sand", () -> new Block(Block.Properties.create(Material.SAND)
			.hardnessAndResistance(0.5F, 0.5F)
			.sound(SoundType.SAND)));
	public static final RegistryObject<Block> VOLCANIC_SAND_HOT = register("volcanic_sand_hot", () -> new Block(Block.Properties.create(Material.SAND)
			.hardnessAndResistance(0.5F, 0.5F)
			.sound(SoundType.SAND)));


}
