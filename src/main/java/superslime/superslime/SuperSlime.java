package superslime.superslime;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SuperSlime implements ModInitializer {

    public static final SuperSlimeBlock SUPER_SLIME = new SuperSlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK));

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("mcstrugs", "super_slime"), SUPER_SLIME);
        Registry.register(Registry.ITEM, new Identifier("mcstrugs" , "super_slime"), new BlockItem(SUPER_SLIME, new Item.Settings().group(ItemGroup.MISC)));
    }
}
