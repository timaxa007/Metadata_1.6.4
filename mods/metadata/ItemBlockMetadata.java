package mods.metadata;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMetadata extends ItemBlock {

public ItemBlockMetadata(int id) {
super(id);
setMaxDamage(0);
setHasSubtypes(true);
}

public String getUnlocalizedName(ItemStack is) {
int metadata = is.getItemDamage();
if (metadata >= 0 && metadata < BlockMetadata.metadata.length) {
return super.getUnlocalizedName() + "." + BlockMetadata.metadata[metadata];
}
return super.getUnlocalizedName();
}

}
