package com.yameatmeyourdead.bruh.init;

import com.yameatmeyourdead.bruh.Bruh;
import com.yameatmeyourdead.bruh.Bruh.BruhItemGroup;
import com.yameatmeyourdead.bruh.objects.blocks.ObamiumBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Bruh.MOD_ID)
@Mod.EventBusSubscriber(modid = Bruh.MOD_ID, bus = Bus.MOD)
public class BlockInit 
{
	public static final Block obamium_ore = null;
	public static final Block block_of_obamium = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		IForgeRegistry<Block> Registry = event.getRegistry();
		
		//ores
		Registry.register(new Block(Block.Properties.create(Material.SAND).hardnessAndResistance(0.25f,15f).harvestLevel(3).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)).setRegistryName("obamium_ore"));
		
		//blocks
		Registry.register(new ObamiumBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5f, 25f).harvestLevel(3).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)).setRegistryName("block_of_obamium"));
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{
		IForgeRegistry<Item> Registry = event.getRegistry();
		Registry.register(new BlockItem(obamium_ore, new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium_ore"));
		Registry.register(new BlockItem(block_of_obamium, new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("block_of_obamium"));
	}
}
