package sr.shelo.redstone_displays.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import sr.shelo.redstone_displays.SrShelosRedstoneDisplays;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sr.shelo.redstone_displays.block.custom.DisplayBlock;

public class ModBlocks {
    public static final Block LED_DISPLAY_4x4 = registerBlock("led_display_4x4",
            new DisplayBlock(FabricBlockSettings.create()
                    .luminance(state -> state.get(Properties.POWER) > 0 ? 5 : 0 )
                    .solidBlock(Blocks::never)
                    .sounds(BlockSoundGroup.GLASS)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(SrShelosRedstoneDisplays.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(SrShelosRedstoneDisplays.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        SrShelosRedstoneDisplays.LOGGER.info("Registering ModBLocks for " + SrShelosRedstoneDisplays.MOD_ID);
    }
}
