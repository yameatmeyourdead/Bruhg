package com.yameatmeyourdead.bruh.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.FindWaterGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class PickleZac extends WaterMobEntity {

	public PickleZac(EntityType<? extends WaterMobEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	@Override
	protected void updateAITasks() {
		super.updateAITasks();
	}
	
	@Override
	public boolean canBeLeashedTo(PlayerEntity player) {
		return true;
	}
	
	@Override
	protected void updateAir(int p_209207_1_) 
	{
		
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FindWaterGoal(this));
		this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1d, 90));
	}
	
	@Override
	public void livingTick() 
	{
		super.livingTick();
	}
	
	@Override
	protected void registerAttributes() 
	{
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4d);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1d);
		
	}
}
