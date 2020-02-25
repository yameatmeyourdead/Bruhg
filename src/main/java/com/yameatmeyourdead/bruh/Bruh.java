package com.yameatmeyourdead.bruh;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yameatmeyourdead.bruh.init.BlockInit;
import com.yameatmeyourdead.bruh.world.gen.BruhOreGen;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


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
        instance = this;
        
        MinecraftForge.EVENT_BUS.register(this);
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
    		return new ItemStack(BlockInit.obamium_ore);
    	}
    }
}

