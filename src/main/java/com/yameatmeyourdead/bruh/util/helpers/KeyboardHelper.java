package com.yameatmeyourdead.bruh.util.helpers;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class KeyboardHelper 
{
	private static final long WINDOW = Minecraft.getInstance().func_228018_at_().getHandle();
	
	@OnlyIn(Dist.CLIENT)
	public static boolean isHoldingShift()
	{
		return InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_SHIFT) || InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_RIGHT_SHIFT);
	}
}
