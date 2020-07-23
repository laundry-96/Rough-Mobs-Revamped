/*
 * Rough Mobs Revamped for Minecraft Forge 1.14.4
 *
 * This is a complete revamp of Lellson's Rough Mobs 2
 *
 * Author: p1ut0nium_94
 * Website: https://www.curseforge.com/minecraft/mc-mods/rough-mobs-revamped
 * Source: https://github.com/p1ut0nium-git/Rough-Mobs-Revamped/tree/1.14.4
 *
 */
package com.p1ut0nium.roughmobsrevamped.entity.ai.goal;

import com.p1ut0nium.roughmobsrevamped.reference.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EnumSet;
import java.util.List;

public class RoughAIBridgeGoal extends Goal {

	public static Logger logger = LogManager.getLogger(Constants.MODID);

	// Entity that does the bridging
	protected MobEntity entity;

	// Time between block placements
	protected long blockPlacementTime;

	// Last time a block was placed
	protected long lastBlockPlacedTime;

	private List<PlayerEntity> players;

	public RoughAIBridgeGoal(MobEntity entity, int blockPlacementTime) {
		this.entity = entity;
		this.blockPlacementTime = blockPlacementTime;
		this.lastBlockPlacedTime = 0;

		this.setMutexFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
		//this.setMutexBits(4);
	}

	@Override
	public boolean shouldExecute() {

		if(entity.getAttackTarget() == null) {
			return false;
		}

		if(!entity.onGround) {
			return false;
		}

		boolean isDoneExecutingPreviousPath = !(entity.getNavigator().noPath() || entity.getNavigator().getPath().isFinished() && !entity.getNavigator().getPath().reachesTarget());
		boolean shouldReplace = !entity.getPosition().equals(calculateBlockPlacement());
		boolean replaceable = entity.world.isBlockPresent(calculateBlockPlacement());

		return isDoneExecutingPreviousPath && replaceable;
	}

	protected BlockPos calculateBlockPlacement() {
		BlockPos blockPlacementPosition = entity.getPosition();
		entity.getLookController().setLookPositionWithEntity(entity.getAttackTarget(), 360, 360);
		Direction facing = entity.getHorizontalFacing();

		if(facing.equals(Direction.NORTH))
			blockPlacementPosition = blockPlacementPosition.add(0, 0, -1);
		if(facing.equals(Direction.EAST))
			blockPlacementPosition = blockPlacementPosition.add(1, 0, 0);
		if(facing.equals(Direction.SOUTH))
			blockPlacementPosition = blockPlacementPosition.add(0, 0, 1);
		if(facing.equals(Direction.WEST))
			blockPlacementPosition = blockPlacementPosition.add(-1, 0, 0);

		return blockPlacementPosition;
	}

	@Override
	public boolean shouldContinueExecuting() {
		return this.shouldExecute();
	}

	@Override
	public void startExecuting() {
		this.lastBlockPlacedTime = 0;
	}

	@Override
	public void tick() {

		if(!entity.onGround)
			return;

//		logger.debug("Current game time: " + entity.world.getGameTime());
//		logger.debug("Last pillar placed time: " + this.pillarTime);
//		logger.debug("Time in between pillars: " + this.pillarTime);

		if (entity.world.getGameTime() > this.lastBlockPlacedTime + this.blockPlacementTime) {
			BlockPos blockPosition = calculateBlockPlacement();
			logger.debug("Entity postion: " + entity.getPosition());
			logger.debug("Block to Place position: " + calculateBlockPlacement());
			this.entity.world.setBlockState(blockPosition.down(), Blocks.COBBLESTONE.getDefaultState());
			this.entity.setPositionAndUpdate(blockPosition.getX() + 0.5, blockPosition.getY() + 0.0, blockPosition.getZ() + 0.5);
			//this.entity.getNavigator().tryMoveToXYZ(blockPosition.getX() + 0.5, blockPosition.getY() + 0.0, blockPosition.getZ() + 0.5, 1.0);
			this.lastBlockPlacedTime = entity.world.getGameTime();
		}

		entity.getNavigator().updatePath();

		super.tick();
	}

	@Override
	public void resetTask() {
//		logger.debug("Reset task");
		super.resetTask();
	}

}
