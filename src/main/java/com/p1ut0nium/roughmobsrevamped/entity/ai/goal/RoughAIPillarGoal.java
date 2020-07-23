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

import java.util.EnumSet;
import java.util.List;

import com.p1ut0nium.roughmobsrevamped.reference.Constants;
import net.minecraft.block.Blocks;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RoughAIPillarGoal extends Goal {

	public static Logger logger = LogManager.getLogger(Constants.MODID);

	// Entity that does the pillaring
	protected MobEntity entity;

	// Time between block placements
	protected long blockPlacementTime;

	// Last time pillar block was placed
	protected long lastBlockPlacedTime;

	private List<PlayerEntity> players;

	public RoughAIPillarGoal(MobEntity entity, int blockPlacementTime) {
		this.entity = entity;
		this.blockPlacementTime = blockPlacementTime;
		this.lastBlockPlacedTime = 0;

		this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
		//this.setMutexBits(4);
	}

	@Override
	public boolean shouldExecute() {

		if(entity.getAttackTarget() == null) {
			return false;
		}

		// Make sure we are on the ground before we place a block
		if (!entity.onGround) {
			return false;
		}

		boolean canReachTarget = !(entity.getNavigator().noPath() || entity.getNavigator().getPath().isFinished());
		// If player is 1 above zombie, it's better to not pillar since player might be jumping
		boolean isBelowTarget = entity.getAttackTarget().getPosition().getY() > entity.getPosition().getY() + 1;
		boolean isBlockAboveFree = entity.world.isAirBlock(new BlockPos(entity.getPosX(), entity.getPosY() + (double)entity.getEyeHeight() + 1.00, entity.getPosZ()));

		if (!canReachTarget && isBelowTarget && isBlockAboveFree) {
			logger.debug("Executing Pillaring");
			return true;
		}

		return false;
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
			BlockPos blockPosition = this.entity.getPosition();
			this.entity.setPositionAndUpdate(this.entity.getPosX(), this.entity.getPosY() + 1.0, this.entity.getPosZ());
			this.entity.world.setBlockState(blockPosition, Blocks.COBBLESTONE.getDefaultState());
			this.lastBlockPlacedTime = entity.world.getGameTime();
		}

		super.tick();
	}

	@Override
	public void resetTask() {
//		logger.debug("Reset task");
		super.resetTask();
	}
}
