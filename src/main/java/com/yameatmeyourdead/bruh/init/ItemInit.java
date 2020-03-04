package com.yameatmeyourdead.bruh.init;

import java.util.function.Supplier;

import com.yameatmeyourdead.bruh.Bruh;
import com.yameatmeyourdead.bruh.Bruh.BruhItemGroup;
import com.yameatmeyourdead.bruh.objects.items.GunItem;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;


@Mod.EventBusSubscriber(modid = Bruh.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Bruh.MOD_ID)
public class ItemInit 
{
	//materials
	public static final Item bruhmium = null;
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
	
	//armor
	public static final Item obamium_helmet = null;
	public static final Item obamium_chestplate = null;
	public static final Item obamium_leggings = null;
	public static final Item obamium_boots = null;
	
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		IForgeRegistry<Item> Registry = event.getRegistry();
		
		//materials
		Registry.register(new Item(new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("bruhmium"));
		Registry.register(new Item(new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium"));
		Registry.register(new Item(new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium_ingot"));
		
		//food items
		Registry.register(new Item(new Item.Properties().group(BruhItemGroup.instance).food(new Food.Builder().hunger(2)
				.effect(new EffectInstance(Effects.HUNGER, 6000, 2), 1f).setAlwaysEdible().build()))
						.setRegistryName("uncooked_obama"));
		Registry.register(new Item(new Item.Properties().group(BruhItemGroup.instance)
				.food(new Food.Builder().hunger(10).saturation(3.0f)
						.effect(new EffectInstance(Effects.REGENERATION, 600, 5), 1f)
						.effect(new EffectInstance(Effects.SATURATION, 40, 5), 1f).setAlwaysEdible().build()))
								.setRegistryName("cooked_obama"));
		
		//tools
		Registry.register(
				new SwordItem(ModItemTier.OBAMIUM, 1, -2f, new Item.Properties().group(BruhItemGroup.instance))
						.setRegistryName("obamium_sword"));
		Registry.register(
				new PickaxeItem(ModItemTier.OBAMIUM, -6, -2.4f, new Item.Properties().group(BruhItemGroup.instance))
						.setRegistryName("obamium_pickaxe"));
		Registry.register(
				new ShovelItem(ModItemTier.OBAMIUM, -5, -2.4f, new Item.Properties().group(BruhItemGroup.instance))
						.setRegistryName("obamium_shovel"));
		Registry.register(
				new AxeItem(ModItemTier.OBAMIUM, 3f, -2.6f, new Item.Properties().group(BruhItemGroup.instance))
						.setRegistryName("obamium_axe"));
		Registry.register(new HoeItem(ModItemTier.OBAMIUM, 0, new Item.Properties().group(BruhItemGroup.instance))
				.setRegistryName("obamium_hoe"));
		Registry.register(new ShearsItem(new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium_shears"));
		//event.getRegistry().register(new BowItem(new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium_bow"));
		
		//gun
		Registry.register(new GunItem(new Item.Properties().group(BruhItemGroup.instance)).setRegistryName("obamium_gun"));
	
		//armor
		Registry.register(new ArmorItem(ModArmorMaterial.OBAMIUM, EquipmentSlotType.HEAD, new Item.Properties()
				.group(BruhItemGroup.instance)).setRegistryName("obamium_helmet"));
		Registry.register(new ArmorItem(ModArmorMaterial.OBAMIUM, EquipmentSlotType.CHEST, new Item.Properties()
				.group(BruhItemGroup.instance)).setRegistryName("obamium_chestplate"));
		Registry.register(new ArmorItem(ModArmorMaterial.OBAMIUM, EquipmentSlotType.LEGS, new Item.Properties()
				.group(BruhItemGroup.instance)).setRegistryName("obamium_leggings"));
		Registry.register(new ArmorItem(ModArmorMaterial.OBAMIUM, EquipmentSlotType.FEET, new Item.Properties()
				.group(BruhItemGroup.instance)).setRegistryName("obamium_boots"));
	}
	
	public enum ModArmorMaterial implements IArmorMaterial
	{
		OBAMIUM(Bruh.MOD_ID + ":obamium", 25, new int[] {7,9,11,7}, 420, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.9f, () -> {
			return Ingredient.fromItems(ItemInit.obamium_ingot);});
		
		private static final int[] MAX_DAMAGE_ARRAY = new int[]{16,20,18,15};
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundevent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModArmorMaterial(String nameIn, int maxDamageFactor, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn)
		{
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactor;
			this.damageReductionAmountArray = damageReductionAmountsIn;
			this.enchantability = enchantabilityIn;
			this.soundevent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
		}
		
		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public SoundEvent getSoundEvent() {
			return this.soundevent;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
		
		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public float getToughness() {
			return this.toughness;
		}
	}
	
	
	public enum ModItemTier implements IItemTier
	{
		OBAMIUM(4, 1750, 20.0f, 10.0f, 200, () -> {return Ingredient.fromItems(ItemInit.obamium);});
		
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
