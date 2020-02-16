package com.yameatmeyourdead.bruh.init;

import com.yameatmeyourdead.bruh.Bruh;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Bruh.MOD_ID)
@Mod.EventBusSubscriber(modid = Bruh.MOD_ID, bus = Bus.MOD)
public class BlockInit 
{
	public static final Block example_block = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new Block(Block.Properties.create(Material.SAND).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.METAL)).setRegistryName("example_block"));
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(example_block, new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)).setRegistryName("example_block"));
	}
}
