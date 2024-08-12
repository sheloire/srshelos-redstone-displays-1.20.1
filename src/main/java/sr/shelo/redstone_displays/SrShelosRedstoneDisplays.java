package sr.shelo.redstone_displays;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SrShelosRedstoneDisplays implements ModInitializer {
	public static final String MOD_ID = "srshelos_redstone_displays";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
	}
}