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
package com.p1ut0nium.roughmobsrevamped.reference;

import java.util.ArrayList;
import java.util.List;

import com.p1ut0nium.roughmobsrevamped.init.ModEntityTypes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;

public class Constants {
	public static final String MODID = "roughmobsrevamped";
	public static final String MODNAME = "Rough Mobs Revamped";
	public static final String MODVERSION = "@VERSION@";
	public static final String MODUPDATE = "https://api.npoint.io/0d4e5ab77e46896ac842";

	public static final String ROUGHMOBSALL = "roughmobsall";
	public static final String ROUGHMOBSEQUIP = "roughmobsequip";
	public static final String ROUGHMOBSBOSS = "roughmobsboss";
	public static final String ROUGHMOBSABILS = "roughmobsabils";
	public static final String ROUGHMOBSENCHANT = "roughmobsenchant";
	
	public static final String PLAYER_ABILITIES_STAGE = "playerHasAbilitiesStage";
	public static final String PLAYER_EQUIPMENT_STAGE = "playerHasEquipmentStage";
	public static final String PLAYER_BOSS_STAGE = "playerHasBossStage";
	public static final String PLAYER_ENCHANT_STAGE = "playerHasEnchantStage";
	
	public static final String MOD_CONFIG_DIRECTORY = "roughmobsrevamped";
	public static final String MOD_COMPAT_CONFIG_FILENAME = "modcompat.toml";
	public static final String SPAWN_CONDITIONS_CONFIG_FILENAME = "spawnconditions.toml";
	public static final String EQUIPMENT_CONFIG_FILENAME = "equipment.toml";
	public static final String FEATURES_CONFIG_FILENAME = "features.toml";
	public static final String ATTRIBUTES_CONFIG_FILENAME = "attributes.toml";
	public static final String FOG_CONFIG_FILENAME = "fog.toml";

	public static String unique(String id) {
		return MODID + ":" + id;
	}

	public static List<String> getRegNames(List<EntityType<? extends Entity>> entityType) {
		
		List<String> regNames = new ArrayList<String>();
		
		for(EntityType<? extends Entity> clazz : entityType) {
			regNames.add(EntityType.getKey(clazz).toString());
		}
		return regNames;
	}
	
	public static final String[] ZOMBIE_CHAMP_NAMES = {
			"Zombie King", 
			"Flesh King", 
			"Dr. Zomboss", 
			"Azog", 
			"Zon-Goku", 
			"Z0mb3y"
	};
	
	public static final EntityType<?>[] ZOMBIES = {
			EntityType.ZOMBIE,
			EntityType.ZOMBIE_VILLAGER,
			EntityType.HUSK,
			EntityType.ZOMBIE_PIGMAN
	};
	
	public static final EntityType<?>[] ZOMBIE_PIGMEN = {
			EntityType.ZOMBIE_PIGMAN
	};
	
	public static final EntityType<?>[] SPIDERS = {
			EntityType.SPIDER,
			EntityType.CAVE_SPIDER,
	};
	
	public static final EntityType<?>[] BLAZES = {
			EntityType.BLAZE,
	};
	
	public static final EntityType<?>[] HOSTILE_HORSES = {
			EntityType.ZOMBIE_HORSE,
			EntityType.SKELETON_HORSE
	};
	
	public static final Float[] FOG_COLORS = {
			0.1F,
			0.4F,
			0.1F
	};
	
	public static final String[] BOSS_COLORS = {
			"0.0",
			"1.0",
			"0.0"
	};
	
	public static final String[] SEASONS = {
			"SUMMER",
			"AUTUMN",
			"WINTER",
			"SPRING"
	};
	
	public static final int CHANCE_PER_WEAPON_DEFAULT = 3;
	public static final int CHANCE_PER_ARMOR_DEFAULT = 4;
	public static final int CHANCE_PER_ENCHANT_DEFAULT = 8;
	public static final float ENCHANT_MULTIPLIER_DEFAULT = 0.5F;
	public static final float DROP_CHANCE_DEFAULT = 0.085F;
	
	public static final String[] ATTRIBUTE_DEFAULT = {
			"zombie;generic.maxHealth;1;0.5;/;1",
			"zombie_pigman;generic.maxHealth;1;0.5;/;1",
			"zombie_villager;generic.maxHealth;1;0.5;/;1",
			"husk;generic.maxHealth;1;0.5;/;1",
			"skeleton;generic.maxHealth;1;0.5",
			"stray;generic.maxHealth;1;0.5",
			"wither_skeleton;generic.maxHealth;1;1",
			"slime;generic.maxHealth;1;0.5",
			"blaze;generic.maxHealth;1;0.5",
			"magma_cube;generic.maxHealth;1;0.5",
			"wither;generic.maxHealth;1;1",
			"vindication_illager;generic.maxHealth;1;0.5",
			"evocation_illager;generic.maxHealth;1;1",
			"zombie;generic.followRange;0;30",
			"zombie_pigman;generic.followRange;0;30",
			"zombie_villager;generic.followRange;0;30",
			"husk;generic.followRange;0;30",
			"skeleton;generic.followRange;0;30",
			"stray;generic.followRange;0;30",
			"wither_skeleton;generic.followRange;0;30",
	        "creeper;generic.followRange;0;30",
	        "spider;generic.followRange;0;30",
	        "slime;generic.followRange;0;30",
	        "witch;generic.followRange;0;30",
	        "blaze;generic.followRange;0;30",
	        "ghast;generic.followRange;0;30",
	        "magma_cube;generic.followRange;0;30",
	        "vindication_illager;generic.followRange;0;30",
	        "evocation_illager;generic.followRange;0;30",
	        "zombie;generic.knockbackResistance;0;0.5",
	        "zombie_pigman;generic.knockbackResistance;0;0.5",
	        "zombie_villager;generic.knockbackResistance;0;0.5",
	        "husk;generic.knockbackResistance;0;0.5",
	        "vindication_illager;generic.knockbackResistance;0;0.5",
	        "creeper;generic.movementSpeed;1;0.5",
	        "slime;generic.movementSpeed;1;0.5",
	        "magma_cube;generic.movementSpeed;1;0.5"
	};
	
	public static final String[] DEFAULT_DESTROY_BLOCKS = {
	        "minecraft:carrots",
	        "minecraft:potatoes",
	        "minecraft:wheat",
	        "minecraft:nether_wart",
	        "minecraft:beetroots",
	        "minecraft:pumpkin_stem",
	        "minecraft:melon_stem",
	        "minecraft:pumpkin",
	        "minecraft:hay_block",
			"minecraft:torch"
	};
	
	public static final String[] DEFAULT_MAINHAND = {
			"wooden_axe;3;0",
	        "wooden_sword;3;0",
	        "stone_pickaxe;2",
	        "stone_axe;2",
	        "stone_sword;2",
	        "iron_pickaxe;1",
	        "golden_sword;1",
	        "golden_axe;1",
	        "iron_axe;3;-1",
	        "iron_sword;3;-1"
	};
	
	public static final String[] DEFAULT_OFFHAND = {
			"wooden_axe;3;0",
	        "wooden_sword;3;0",
	        "stone_pickaxe;2",
	        "stone_axe;2",
	        "stone_sword;2",
	        "iron_pickaxe;1",
	        "golden_sword;1",
	        "golden_axe;1",
	        "shield;5",
	        "iron_axe;3;-1",
	        "iron_sword;3;-1"
	};
	
	public static final String[] SKELETON_MAINHAND = {
			"bow;1"
	};
	
	public static final String[] DEFAULT_BOOTS = {
	        "leather_boots;3;0",
	        "chainmail_boots;2",
	        "golden_boots;1",
	        "iron_boots;4;-1"
	};
	
	public static final String[] DEFAULT_LEGGINGS = {
	        "leather_leggings;3;0",
	        "chainmail_leggings;2",
	        "golden_leggings;1",
	        "iron_leggings;4;-1"
	};
	
	public static final String[] DEFAULT_CHESTPLATES = {
	        "leather_chestplate;3;0",
	        "chainmail_chestplate;2",
	        "golden_chestplate;1",
	        "iron_chestplate;4;-1"
	};
	
	public static final String[] DEFAULT_HELMETS = {
	        "leather_helmet;3;0",
	        "chainmail_helmet;2",
	        "golden_helmet;1",
	        "iron_helmet;4;-1"
	};
	
	public static final String[] DEFAULT_WEAPON_ENCHANTS = {
	        "sharpness;4",
	        "knockback;2",
	        "smite;2",
	        "bane_of_arthropods;2",
	        "looting;1",
	        "sweeping;1",
	        "fire_aspect;5;-1"
	};
	
	public static final String[] DEFAULT_ARMOR_ENCHANTS = {
	        "protection;4",
	        "feather_falling;3",
	        "respiration;3",
	        "depth_strider;3",
	        "thorns;2",
	        "projectile_protection;2",
	        "fire_protection;2",
	        "blast_protection;2"
	};
	
	public static final String[] DEFAULT_BOSS_MAINHAND = {
	        "diamond_sword;3",
			"diamond_axe;1"
	};
	
	public static final String[] DEFAULT_BOSS_OFFHAND = {
	        "shield;2",
	        "diamond_sword;1",
			"diamond_axe;1"
	};
	
	public static final String[] DEFAULT_BOSS_BOOTS = {
	        "diamond_boots;1"
	};
	
	public static final String[] DEFAULT_BOSS_LEGGINGS = {
	        "diamond_leggings;1"
	};
	
	public static final String[] DEFAULT_BOSS_CHESTPLATES = {
	        "diamond_chestplate;1"
	};
	
	public static final String[] DEFAULT_BOSS_HELMETS = {
	        "diamond_helmet;1"
	};
	public static final String[] DEFAULT_SPAWN_ENTRIES = {
			"wither_skeleton;30;1;5;MONSTER;8",
	        "blaze;30;1;5;MONSTER;8",
	        "magma_cube;30;1;3;MONSTER;8"
	};
	public static final EntityType<?>[] DEFAULT_SPIDER_RIDERS = {
			EntityType.ZOMBIE,
			EntityType.SKELETON,
			EntityType.WITCH
	};
	public static final String[] DEFAULT_WITCH_BUFFS = {
			"strength;1",
			"resistance;2",
			"speed;2"
	};
	public static final String[] DEFAULT_TARGET_BLOCKER = {
			"zombie;*",
			"zombie_pigman;*",
			"zombie_villager;*",
			"husk;*",
			"skeleton;*",
			"stray;*",
			"wither_skeleton;*",
			"slime;*",
			"blaze;*",
			"magma_cube;*",
			"wither;*",
			"vindication_illager;*",
			"evocation_illager;*",
	        "creeper;*",
	        "spider;*",
	        "cave_spider;*",
	        "witch;*",
	        "ghast;*"
	};

	public static final String[] DEFAULT_TARGETS = {
			"pig;zombie",
			"sheep;zombie",
			"sheep;skeleton"
	};
}