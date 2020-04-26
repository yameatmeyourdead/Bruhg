package com.yameatmeyourdead.bruh.client.entity.render;

import com.yameatmeyourdead.bruh.Bruh;
import com.yameatmeyourdead.bruh.client.entity.model.PickleZacModel;
import com.yameatmeyourdead.bruh.entities.PickleZac;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PickleZacRender extends MobRenderer<PickleZac,PickleZacModel<PickleZac>>
{
	protected static final ResourceLocation TEXTURE = new ResourceLocation(Bruh.MOD_ID,"textures/entities/picklezac.png");
	
	public PickleZacRender(EntityRendererManager renderManagerIn)
	{
		super(renderManagerIn, new PickleZacModel<PickleZac>(), 0.25f);
	}
	
	@Override
	public ResourceLocation getEntityTexture(PickleZac entity) 
	{
		return TEXTURE;
	}
}