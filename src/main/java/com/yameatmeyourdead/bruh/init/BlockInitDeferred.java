package com.yameatmeyourdead.bruh.init;

import com.yameatmeyourdead.bruh.Bruh;
import com.yameatmeyourdead.bruh.objects.blocks.ObamiumBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInitDeferred {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Bruh.MOD_ID);

	public static final RegistryObject<Block> OBAMIUM_ORE = BLOCKS.register("obamium_ore",
			() -> new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.25f, 15.6f).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> OBAMIUM_BLOCK = BLOCKS.register("block_of_obamium",
			() -> new ObamiumBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5f, 25f)
					.harvestLevel(3).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
}
