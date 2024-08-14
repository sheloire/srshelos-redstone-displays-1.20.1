package sr.shelo.redstone_displays.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DisplayBlock extends Block {
    public static final IntProperty POWER = Properties.POWER;
    public static final DirectionProperty HORIZONTAL_FACING = Properties.HORIZONTAL_FACING;

    public DisplayBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState()
                .with(HORIZONTAL_FACING, Direction.NORTH)
                .with(POWER, 0)
        );
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(POWER, ctx.getWorld().getReceivedRedstonePower(ctx.getBlockPos()));
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient) {
            int current_power = state.get(POWER);
            int received_power = world.getReceivedRedstonePower(pos);
            if (current_power != received_power) {
                world.setBlockState(pos, state.with(POWER, received_power), Block.NOTIFY_LISTENERS);
            }
        }
    }

//    @Override
//    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
//        return true;
//    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWER, HORIZONTAL_FACING);
    }
}
