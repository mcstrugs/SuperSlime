package superslime.superslime;


import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.TransparentBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SuperSlimeBlock extends TransparentBlock {
   public SuperSlimeBlock(Settings settings) {
       super(settings);
   }

   @Override
   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
       return VoxelShapes.cuboid(0f,0f,0f,1f,0.5f,1f);
   }

   @Override
    public void onEntityLand(BlockView world, Entity entity) {
       this.bounce(entity);
    }

    private void bounce(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (vec3d.y < 0.0) {
            double d = 1.5;
            entity.setVelocity(vec3d.x * d, -vec3d.y * d, vec3d.z * d);
        }
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
       entity.setVelocity(entity.getVelocity().multiply(25, 1.01, 25).add(0,1,0));
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.handleFallDamage(fallDistance, 0f, DamageSource.FALL);
    }
}
