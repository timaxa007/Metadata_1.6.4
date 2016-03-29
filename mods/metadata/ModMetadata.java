package mods.metadata;

import net.minecraft.block.Block;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod (modid = ModMetadata.MODID, name = ModMetadata.MODNAME, version = ModMetadata.VERSION)

public class ModMetadata {

	public static final String MODID = "metadata";
	public static final String MODNAME = "Metadata";
	public static final String VERSION = "0.1a";

	@Instance(ModMetadata.MODID)
	public static ModMetadata instance;

	public static Block block_metadata;
	public static int block_metadata_id;

	@EventHandler
	public void init(FMLInitializationEvent event) {

		block_metadata = new BlockMetadata(block_metadata_id);
		GameRegistry.registerBlock(block_metadata, ItemBlockMetadata.class, "block_metadata");

	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		int idblock = 2600;

		block_metadata_id = config.getBlock("block_metadata", idblock++).getInt();

		config.save();

	}

}