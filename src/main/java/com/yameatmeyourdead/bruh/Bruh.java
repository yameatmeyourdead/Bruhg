package com.yameatmeyourdead.bruh;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yameatmeyourdead.bruh.init.BlockInitDeferred;
import com.yameatmeyourdead.bruh.init.ItemInitDeferred;
import com.yameatmeyourdead.bruh.init.ModEntityTypes;
import com.yameatmeyourdead.bruh.world.gen.BruhOreGen;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;


@Mod("bruh")
@Mod.EventBusSubscriber(modid = Bruh.MOD_ID, bus = Bus.MOD)
public class Bruh
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "bruh";
    public static Bruh instance;
    
    public Bruh() 
    {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        
        ItemInitDeferred.ITEMS.register(modEventBus);
        BlockInitDeferred.BLOCKS.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        
        instance = this;
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	BlockInitDeferred.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
    		final Item.Properties properties = new Item.Properties().group(BruhItemGroup.instance);
    		final BlockItem blockItem = new BlockItem(block, properties);
    		blockItem.setRegistryName(block.getRegistryName());
    		registry.register(blockItem);
    	});
    	
    	//TODO: REMOVE
    	LOGGER.debug("Registered BlockItems");
    }
    
    private void setup(final FMLCommonSetupEvent event)
    {
    	
    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {
        
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) 
    {
    	
    }
    
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event)
    {
    	BruhOreGen.generateOre();
    }
    
    
    public static class BruhItemGroup extends ItemGroup
    {
    	public static final BruhItemGroup instance = new BruhItemGroup(ItemGroup.GROUPS.length, "bruhtab");
    	private BruhItemGroup(int index, String label)
    	{
    		super(index, label);
    	}

    	@Override
    	public ItemStack createIcon()
    	{
    		return new ItemStack(BlockInitDeferred.OBAMIUM_ORE.get());
    	}
    }
}

