package mods.metadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
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
super(id, Material.iron);
setCreativeTab(ModMetadata.tab_metadata);
setHardness(0.3F);
setResistance(1.0F);
setTextureName(ModMetadata.MODID + ":block_metadata");
setUnlocalizedName("block_metadata");
}

public int quantityDropped(Random random) {
return 0;
}

@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
ArrayList<ItemStack> ret = super.getBlockDropped(world, x, y, z, metadata, fortune);
ret.add(new ItemStack(ModMetadata.block_metadata, 1, metadata));
return ret;
}

public int idPicked(World world, int x, int y, int z) {
return 0;
}

public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
return new ItemStack(world.getBlockId(x, y, z), 1, world.getBlockMetadata(x, y, z));
}

@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
world.setBlockMetadataWithNotify(x, y, z, is.getItemDamage(), 3);
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
