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
import java.util.function.Consumer;

import com.p1ut0nium.roughmobsrevamped.core.RoughMobsRevamped;
import com.p1ut0nium.roughmobsrevamped.reference.Constants;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RoughAISunlightBurnGoal extends Goal {
	public static Logger logger = LogManager.getLogger(Constants.MODID);
	protected LivingEntity entity;
	protected boolean helmetMode;
	protected Consumer<LivingEntity> consumer;

	public RoughAISunlightBurnGoal(LivingEntity entity, boolean helmetMode) {

		this.entity = entity;
		this.helmetMode = helmetMode;
		this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.TARGET));
		// TODO this.setMutexBits(4);
		this.consumer = new Consumer<LivingEntity>() {
			@Override
			public void accept(LivingEntity livingEntity) {
				logger.info("Inside accept, don't think we need to do anything though");
			}

			@Override
			public Consumer<LivingEntity> andThen(Consumer<? super LivingEntity> after) {
				logger.info("Inside andThen, don't think we need to do anything though");
				return this;
			}
		};
	}
	
	@Override
	public boolean shouldExecute() {

		float f = entity.getBrightness();

		boolean isInSun = entity.world.isDaytime() && f > 0.5F && entity.world.canBlockSeeSky(new BlockPos(entity.getPosX(), entity.getPosY() + (double)entity.getEyeHeight(), entity.getPosZ()));

		// If we aren't in the sun, we don't need to worry about executing
		if (!isInSun)
			return false;

		// Get the Helmet Equipment slot
		ItemStack itemstack = entity.getItemStackFromSlot(EquipmentSlotType.HEAD);

		// If we do not have a helmet
		if (itemstack != null && !itemstack.isEmpty()) {
			if (helmetMode)
				return !entity.isBurning();

			if (itemstack.isDamageable()) {
				itemstack.damageItem(entity.world.rand.nextInt(2), this.entity, this.consumer);
			}

			return false;
		}

		return !helmetMode && !entity.isBurning();
	}
	
	@Override
	public void tick() {
		entity.setFire(8);
	}
}