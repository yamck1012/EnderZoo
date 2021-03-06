package crazypants.enderzoo.entity.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFallenKnight extends RenderSkeleton {

  public static final Factory FACTORY = new Factory();
  
  private static final ResourceLocation texture = new ResourceLocation("enderzoo:entity/fallen_knight.png");

  public RenderFallenKnight(RenderManager p_i46143_1_) {
    super(p_i46143_1_);
  }

  @Override
  protected ResourceLocation getEntityTexture(EntitySkeleton entity) {
    return texture;
  }

  public static class Factory implements IRenderFactory<EntitySkeleton> {

    @Override
    public Render<? super EntitySkeleton> createRenderFor(RenderManager manager) {
      return new RenderFallenKnight(manager);
    }
  }
  
}
