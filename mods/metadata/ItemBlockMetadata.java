package mods.metadata;

import net.minecraft.item.ItemMultiTextureTile;

public class ItemBlockMetadata extends ItemMultiTextureTile {

	public ItemBlockMetadata(int id) {
		super(id, ModMetadata.block_metadata, BlockMetadata.metadata);
	}

}
