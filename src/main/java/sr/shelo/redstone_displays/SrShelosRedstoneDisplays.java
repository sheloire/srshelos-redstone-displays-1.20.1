package sr.shelo.redstone_displays;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sr.shelo.redstone_displays.block.ModBlocks;
import sr.shelo.redstone_displays.item.ModItems;

public class SrShelosRedstoneDisplays implements ModInitializer {
	public static final String MOD_ID = "srshelos_redstone_displays";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}