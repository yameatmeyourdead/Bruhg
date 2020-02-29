package com.yameatmeyourdead.bruh.world.gen;

import com.yameatmeyourdead.bruh.init.BlockInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class BruhOreGen {
	public static void generateOre()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			ConfiguredPlacement customConfig = Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(3, 5, 5, 30));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
					.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
							BlockInit.obamium_ore.getDefaultState(), 8)).func_227228_a_(customConfig));
		}
	}
}
