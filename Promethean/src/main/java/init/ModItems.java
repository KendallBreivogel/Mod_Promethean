package init;

import com.example.promethean.Promethean;

import customItems.weapons.swords.Item_Fire_Sword;
import customItems.weapons.swords.Item_Ice_Sword;
import customItems.weapons.swords.Item_Promethean_Sword;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Promethean.MODID);
	
	public static void register() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ITEMS.register(modEventBus);
	}
	
	public static final RegistryObject<Item> PROMETHEAN_INGOT = ITEMS.register("promethean_ingot", () ->
		new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
	
	
	public static final RegistryObject<Item> PROMETHEAN_DUST = ITEMS.register("promethean_dust", () ->
		new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
	
	public static final RegistryObject<Item_Promethean_Sword> PROMETHEAN_SWORD = ITEMS.register("promethean_sword", () ->
		new Item_Promethean_Sword(ItemTier.GOLD, 4, 1, new Item_Promethean_Sword.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<Item_Ice_Sword> ICE_SWORD = ITEMS.register("ice_sword", () ->
		new Item_Ice_Sword(ItemTier.NETHERITE, 6, 2, new Item_Ice_Sword.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<Item_Fire_Sword> FIRE_SWORD = ITEMS.register("fire_sword", () ->
		new Item_Fire_Sword(ItemTier.NETHERITE, 6, 2, new Item_Fire_Sword.Properties().group(ItemGroup.COMBAT)));
}
