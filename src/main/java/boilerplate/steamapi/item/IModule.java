/**
 * This class was created by BrassGoggledCoders modding team. 
 * This class is available as part of the Steamcraft 2 Mod for Minecraft.
 *
 * Steamcraft 2 is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 * Steamcraft 2 is based on the original Steamcraft Mod created by Proloe.
 * Steamcraft (c) Proloe 2011
 * (http://www.minecraftforum.net/topic/251532-181-steamcraft-source-code-releasedmlv054wip/)
 * 
 */
package boilerplate.steamapi.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

// TODO: Auto-generated Javadoc
/**
 * The Interface IModule.
 */
public interface IModule
{
	// Localized Name
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName();

	// Unlocalized Name
	/**
	 * Gets the module id.
	 *
	 * @return the module id
	 */
	public String getModuleId();

	// The Effect this module has
	/**
	 * Apply module effect.
	 *
	 * @param world the world
	 * @param player the player
	 * @param stack the stack
	 * @return true, if successful
	 */
	public boolean applyModuleEffect(World world, EntityPlayer player, ItemStack stack);

	/**
	 * Whenever applyArmorEffect returns true, this amount of steam will be
	 * consumed from canisters in the player's inventory. The effect will not be
	 * run if the player does not have enough steam.
	 *
	 * @return the steam consumed on effect
	 */
	public int getSteamConsumedOnEffect();

	/**
	 * Whenever applyArmorEffect returns true, this amount of RF will be
	 * consumed from electric storage items in the player's inventory. The
	 * effect will not be run if the player does not have enough RF.
	 *
	 * @return the energy consumed on effect
	 */
	public int getEnergyConsumedOnEffect();
}
