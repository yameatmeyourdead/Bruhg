package com.yameatmeyourdead.bruh.init;

import com.yameatmeyourdead.bruh.Bruh;
import com.yameatmeyourdead.bruh.Bruh.BruhItemGroup;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Bruh.MOD_ID)
@Mod.EventBusSubscriber(modid = Bruh.MOD_ID, bus = Bus.MOD)
public class BlockInit 
{
	public static final Block obamium_ore = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new Block(Block.Properties.create(Material.SAND).hardnessAndResistance(0.25f,15f).sound(SoundType.STONE)).setRegistryName("obamium_ore"));
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(obamium_ore, new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium_ore"));
	}
}
