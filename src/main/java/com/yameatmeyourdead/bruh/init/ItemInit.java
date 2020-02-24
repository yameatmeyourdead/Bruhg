package com.yameatmeyourdead.bruh.init;

import java.util.function.Supplier;

import com.yameatmeyourdead.bruh.Bruh;
import com.yameatmeyourdead.bruh.Bruh.BruhItemGroup;
import com.yameatmeyourdead.bruh.objects.items.GunItem;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Bruh.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Bruh.MOD_ID)
public class ItemInit 
{
	//materials
	public static final Item obamium = null;
	public static final Item obamium_ingot = null;
	
	//food
	public static final Item uncooked_obama = null;
	public static final Item cooked_obama = null;
	
	//tools
	public static final Item obamium_sword = null;
	public static final Item obamium_pickaxe = null;
	public static final Item obamium_shovel = null;
	public static final Item obamium_axe = null;
	public static final Item obamium_hoe = null;
	
	//gun
	public static final Item obamium_gun = null;
	
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		//materials
		event.getRegistry().register(new Item(new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium"));
		event.getRegistry().register(new Item(new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium_ingot"));
		
		//food items
		event.getRegistry().register(new Item(new Item.Properties().group(BruhItemGroup.instance).food(new Food.Builder().hunger(2).effect(new EffectInstance(Effects.HUNGER, 6000, 2), 1f).setAlwaysEdible().build())).setRegistryName("uncooked_obama"));
		event.getRegistry().register(new Item(new Item.Properties().group(BruhItemGroup.instance).food(new Food.Builder().hunger(10).saturation(3.0f).effect(new EffectInstance(Effects.REGENERATION, 600, 5), 1f).effect(new EffectInstance(Effects.SATURATION, 40, 5), 1f).setAlwaysEdible().build())).setRegistryName("cooked_obama"));
		
		//tools
		event.getRegistry().register(new SwordItem(ModItemTier.OBAMIUM, 1, -2f, new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.OBAMIUM, -6, -2.4f, new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium_pickaxe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.OBAMIUM, -5, -2.4f, new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium_shovel"));
		event.getRegistry().register(new AxeItem(ModItemTier.OBAMIUM, 3f, -2.6f, new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium_axe"));
		event.getRegistry().register(new HoeItem(ModItemTier.OBAMIUM, 0, new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium_hoe"));
		//event.getRegistry().register(new BowItem(new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium_bow"));
		
		//gun
		event.getRegistry().register(new GunItem(new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium_gun"));
	}
	
	public enum ModItemTier implements IItemTier
	{
		OBAMIUM(4, 1750, 16.0f, 10.0f, 200, () -> {return Ingredient.fromItems(ItemInit.obamium);});
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial)
		{
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}

		@Override
		public float getAttackDamage() {
			return this.attackDamage;
		}

		@Override
		public float getEfficiency() {
			return this.efficiency;
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public int getHarvestLevel() {
			return this.harvestLevel;
		}

		@Override
		public int getMaxUses() {
			return this.maxUses;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
	}
}
