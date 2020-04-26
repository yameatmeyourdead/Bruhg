package com.yameatmeyourdead.bruh.util;

import com.yameatmeyourdead.bruh.Bruh;
import com.yameatmeyourdead.bruh.client.entity.render.PickleZacRender;
import com.yameatmeyourdead.bruh.init.ModEntityTypes;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Bruh.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber 
{
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event)
	{
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PICKLE_ZAC.get(), PickleZacRender::new);
	}
}
