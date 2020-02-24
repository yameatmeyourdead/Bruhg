package com.yameatmeyourdead.bruh.objects.items;

import java.util.List;

import com.yameatmeyourdead.bruh.Bruh;
import com.yameatmeyourdead.bruh.util.helpers.KeyboardHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class GunItem extends Item
{
	private boolean isAiming = false;
	
	public GunItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		if(KeyboardHelper.isHoldingShift())
		{
			tooltip.add(new StringTextComponent("Obama shoots liberals"));
		}
		else
		{
			tooltip.add(new StringTextComponent("\u00A77" + "Hold " + "\u00A7e" + "SHIFT" + "\u00A77" + " for more information"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) 
	{
		this.toggleAim();
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	public void toggleAim()
	{
		Bruh.LOGGER.debug("Aim Switch");
		isAiming = !isAiming;
	}
}
