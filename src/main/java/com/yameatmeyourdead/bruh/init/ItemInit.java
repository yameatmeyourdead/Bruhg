package com.yameatmeyourdead.bruh.init;

import com.yameatmeyourdead.bruh.Bruh;
import com.yameatmeyourdead.bruh.Bruh.BruhItemGroup;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Bruh.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Bruh.MOD_ID)
public class ItemInit 
{
	public static final Item example_item = null;
	public static final Item Obamium = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new Item(new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("example_item"));
		event.getRegistry().register(new Item(new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium"));
		
		event.getRegistry().register(new Item(new Item.Properties().group(BruhItemGroup.instance).food(new Food.Builder().hunger(2).effect(new EffectInstance(Effects.HUNGER, 5.0f)), 1f)))));
		event.getRegistry().register(new Item(new Item.Properties().group(BruhItemGroup.instance).food(new Food.Builder().hunger(10).saturation(3.0f).build())).setRegistryName("cooked_obama"));
	}
}
