package com.yameatmeyourdead.bruh.init;

import com.yameatmeyourdead.bruh.Bruh;
import com.yameatmeyourdead.bruh.entities.PickleZac;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
			Bruh.MOD_ID);

	public static final RegistryObject<EntityType<PickleZac>> PICKLE_ZAC = ENTITY_TYPES
			.register("picklezac",
					() -> EntityType.Builder.<PickleZac>create(PickleZac::new, EntityClassification.CREATURE)
						.size(0.9f, 1.3f)
						.build(new ResourceLocation(Bruh.MOD_ID, "picklezac").toString()));
}