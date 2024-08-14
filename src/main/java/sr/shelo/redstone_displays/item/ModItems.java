package sr.shelo.redstone_displays.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import sr.shelo.redstone_displays.SrShelosRedstoneDisplays;
import sr.shelo.redstone_displays.block.ModBlocks;

public class ModItems {

    private static void additemsToRedstoneTab(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.LED_DISPLAY_4x4);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SrShelosRedstoneDisplays.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SrShelosRedstoneDisplays.LOGGER.info("Registering Mod Items for " + SrShelosRedstoneDisplays.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(ModItems::additemsToRedstoneTab);
    }
}
