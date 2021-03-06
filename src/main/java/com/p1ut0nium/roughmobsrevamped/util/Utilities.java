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
package com.p1ut0nium.roughmobsrevamped.util;

import java.awt.Color;
import java.util.List;

public abstract class Utilities {
	
	/*
	 * Takes a number from a source range of numbers, then scales that number to fit into a new range of numbers
	 * 
	 * Example:
	 * 500 in the range of 100 to 1000 becomes 0.5 in the range of 0 to 1.0
	 */
	public static double scaleValue(float currentDistance, float oldRangMin, float oldRangeMax, float newRangeMin, double newRangeMax) {
		double oldPercent = (currentDistance - oldRangMin) / (oldRangeMax - oldRangMin);
		double newResult = ((newRangeMax - newRangeMin) * oldPercent) + newRangeMin;
		return newResult;
	}
	
	/*
	 * Returns true if a class is contained within a List
	 * Can take multiple classes to search for as arguments
	 * 
	 * Example usage:
	 * List entities = world.getEntitiesWithinAABB(BossZombie.class, player.getEntityBoundingBox().grow(20)); 
	 * containsInstance(entities, BossZombie.class, BossSkeleton.class);
	 */
	@SafeVarargs
	public static <E> boolean containsInstance(List<E> list, Class<? extends E> ... clazz) {
		for (Class<? extends E> i: clazz) {
			for (E element : list) {
				if (i.isInstance(element)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/*
	 * Returns true if a list contains a player
	 */
	public static <PlayerEntity> boolean containsPlayer(List<PlayerEntity> list, PlayerEntity entity) {
		for (PlayerEntity element : list) {
			if (entity == element) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Convert RGB values (0 to 255) to normalized values (0.0 - 1.0)
	 */
	public static Color normalizeRGB(short colorRed, short colorGreen, short colorBlue) {
		return new Color(colorRed/255.0F, colorGreen/255.0F, colorBlue/255.0F, 255/255.0F);
	}
	
}
