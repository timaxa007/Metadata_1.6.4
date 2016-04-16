package mods.metadata;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMetadata extends Block {

	public static final String[] metadata = new String[] {
		"meta_1", 
		"meta_2", 
		"meta_3", 
		"meta_4", 
		"meta_5", 
		"meta_6", 
		"meta_7", 
		"meta_8", 
		"meta_9", 
		"meta_10", 
		"meta_11", 
		"meta_12", 
		"meta_13", 
		"meta_14", 
		"meta_15", 
		"meta_16"
	};

	@SideOnly(Side.CLIENT)
	private Icon[] icon_array;

	public BlockMetadata(int id) {
		super(id, Material.circuits);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(0.3F);
		setResistance(1.0F);
		setTextureName(ModMetadata.MODID + ":block_metadata");
		setUnlocalizedName("block_metadata");
	}

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		if (metadata >= 0 && metadata < BlockMetadata.metadata.length) {
			return icon_array[metadata];
		}
		return super.getIcon(side, metadata);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int id, CreativeTabs table, List list) {
		for (int j = 0; j < metadata.length; ++j) {
			list.add(new ItemStack(id, 1, j));
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		super.registerIcons(ir);
		icon_array = new Icon[metadata.length];
		for (int i = 0; i < metadata.length; ++i) {
			icon_array[i] = ir.registerIcon(getTextureName() + "/" + metadata[i]);
		}
	}

}
