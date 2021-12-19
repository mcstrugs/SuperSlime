package superslime.superslime.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import superslime.superslime.SuperSlime;

@Environment(EnvType.CLIENT)
public class SuperSlimeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(SuperSlime.SUPER_SLIME, RenderLayer.getTranslucent());
    }
}
