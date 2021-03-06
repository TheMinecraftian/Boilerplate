/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the BoilerCraft Mod for Minecraft.
 *
 * BoilerCraft is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package boilerplate.common.baseclasses;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import boilerplate.client.ClientHelper;
import boilerplate.common.utils.StringUtils;

/**
 * @author warlordjones
 * 
 */
public class ItemBlockWithDescAndMeta extends ItemBlockWithMetadata
{
	Block block;

	public ItemBlockWithDescAndMeta(Block block)
	{
		super(block, block);
		this.block = block;
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack is)
	{
		return super.getUnlocalizedName() + "." + is.getItemDamage();
	}

	@SuppressWarnings("all")
	@Override
	public void addInformation(ItemStack stack, EntityPlayer entityPlayer, List list, boolean bool)
	{
		if (stack.getItemDamage() > 0)
		{
			if (!StatCollector.translateToLocal(this.block.getUnlocalizedName() + "." + stack.getItemDamage() + ".desc").contains("tile."))
				if (ClientHelper.isShiftKeyDown())
					this.getWrappedDesc(list, stack);
				else
					list.add(ClientHelper.shiftForInfo);
		}
		else
		{
			if (!StatCollector.translateToLocal(this.block.getUnlocalizedName() + ".desc").contains("tile."))
				if (ClientHelper.isShiftKeyDown())
					this.getWrappedDesc(list, stack);
				else
					list.add(ClientHelper.shiftForInfo);
		}
	}

	public void getWrappedDesc(List<String> list, ItemStack stack)
	{
		String[] wrappedDesc;
		if (stack.getItemDamage() > 0)
		{
			wrappedDesc = StringUtils.wrap(StatCollector.translateToLocal(this.getUnlocalizedName() + "." + stack.getItemDamage() + ".desc"), 35);
		}
		else
		{
			wrappedDesc = StringUtils.wrap(StatCollector.translateToLocal(this.getUnlocalizedName() + ".desc"), 35);
		}
		for (String element : wrappedDesc)
			list.add(element.trim());
	}
}
