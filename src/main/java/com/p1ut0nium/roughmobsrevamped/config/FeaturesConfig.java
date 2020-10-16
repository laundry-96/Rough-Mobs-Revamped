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
package com.p1ut0nium.roughmobsrevamped.config;

import java.util.Arrays;
import java.util.List;

import com.p1ut0nium.roughmobsrevamped.reference.Constants;

import net.minecraft.world.Explosion;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.common.ForgeConfigSpec.EnumValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class FeaturesConfig {
	
	// Blaze
	final BooleanValue blazeFeaturesEnabled;
	final BooleanValue blazePushAttackersAway;
	final BooleanValue blazeFlameTouch;
	final DoubleValue blazePushDamage;
	final DoubleValue blazeDeathExplosionStrength;
	final EnumValue<Explosion.Mode> blazeDeathExplosionType;
	final ConfigValue<List<String>> blazeEntities;

	// Spider
	final BooleanValue spiderFeaturesEnabled;
	final BooleanValue spiderSlownessCreateWeb;
	final IntValue spiderSlownessChance;
	final IntValue spiderSlownessDuration;
	final IntValue spiderRiderChance;
	final IntValue spiderRiderChanceRandom;
	final DoubleValue spiderIgnoreFallDamage;
	final ConfigValue<List<String>> spiderEntities;
	final ConfigValue<List<String>> spiderRiderEntities;

	// Zombie
	final BooleanValue zombieFeaturesEnabled;
	final BooleanValue zombieBabyBurn;
	final BooleanValue zombieHelmetBurn;
	final IntValue zombieHorseChance;
	final IntValue zombieHorseMinY;
	final IntValue zombieHungerChance;
	final IntValue zombieHungerDuration;
	final IntValue zombieLeapChance;
	final IntValue zombieChampionChance;
	final DoubleValue zombieBuilderChance;
	final DoubleValue zombieLeapHeight;
	final ConfigValue<List<String>> zombieEntities;
	final ConfigValue<List<? extends String>> zombieBreakBlocks;
	final ConfigValue<List<? extends String>> zombieChampionNames;
	
	// Zombie Pigman
	final BooleanValue zombiePigmanFeaturesEnabled;
	final BooleanValue zombiePigmanAggressiveTouch;
	final BooleanValue zombiePigmanAlwaysAggressive;
	final IntValue zombiePigmanAggressiveRange;
	final IntValue zombiePigmanAggressiveBlockRange;
	final IntValue zombiePigmanAggressiveBlockChance;
	final ConfigValue<List<String>> zombiePigmanEntities;

	// Hostile Horse
	final BooleanValue hostileHorseFeaturesEnabled;
	final BooleanValue hostileHorseBurn;
	final BooleanValue hostileHorseCanDespawn;
	final IntValue hostileHorseRiderChance;
	final ConfigValue<List<String>> hostileHorseEntities;

	FeaturesConfig(final ForgeConfigSpec.Builder builder) {
		
		// Blaze Features
		
		builder.push("Blaze Features");
		blazeFeaturesEnabled = builder
				.comment("Set to false to disable all Blaze features.")
				.define("Blaze_FeaturesEnabled", true);
		blazePushAttackersAway = builder
				.comment("Set to false to prevent Blazes from pushing attackers away.")
				.define("Blaze_PushAttackersAway", true);
		blazePushDamage = builder
				.comment("The amount of damage done when pushed by a Blaze.")
				.defineInRange("Blaze_PushDamage", 1.0f, 0.0f, Short.MAX_VALUE);
		blazeFlameTouch = builder
				.comment("Set to false to prevent Blazes from igniting entities which touch their hitbox.")
				.define("Blaze_FlameTouch", true);
		blazeDeathExplosionStrength = builder
				.comment("Explosion strength which Blazes create on death.",
						"Set to 0 to disable this feature ")
				.defineInRange("Blaze_DeathExplosionStrength", 1.0f, 0.0f, Short.MAX_VALUE);
		blazeDeathExplosionType = builder
				.comment("The type of explosion that occurs when a Blaze dies:",
						"NONE = no effect other than damage to player",
						"BREAK = break blocks in range; broken blocks drop items",
						"DESTROY = destroy blocks and items")
				.defineEnum("Blaze_DeathExplosionType", Explosion.Mode.NONE);
		blazeEntities = builder
				.comment("Entities which count as Blaze entities")
				.define("Blaze_Entities", Constants.getRegNames(Arrays.asList(Constants.BLAZES)));
		builder.pop();
		
		// Hostile Horse Features
		
		builder.push("Hostile Horse Features");
		hostileHorseFeaturesEnabled = builder
				.comment("Set to false to disable all hostile horse features.")
				.define("HostileHorse_FeaturesEnabled", true);
		hostileHorseBurn = builder
				.comment("Set this to false to prevent undead horses from burning in sunlight (as long as they have no rider).")
				.define("HostileHorse_DaylightBurn", true);
		hostileHorseCanDespawn = builder
				.comment("Set to false to prevent undead horses summoned by this mod from despawning.")
				.define("HostileHorse_CanDespawn", true);
		hostileHorseRiderChance = builder
				.comment("Chance (1 in X) that a random skeleton or zombie starts riding unmounted hostile horses around it.")
				.defineInRange("HostileHorse_RiderChance", 3, 0, Short.MAX_VALUE);
		hostileHorseEntities = builder
				.comment("Entities which count as hostile horses.")
				.define("HostileHorse_Entities", Constants.getRegNames(Arrays.asList(Constants.HOSTILE_HORSES)));
		builder.pop();
		
		// Spider Features
		
		builder.push("Spider Features");
		spiderFeaturesEnabled = builder
				.comment("Enable this to use all Spider features.")
				.define("Spider_FeaturesEnabled", true);
		spiderRiderChance = builder
				.comment("Chance (1 in X) for a spider to spawn with another entity riding it.",
						"Set to 0 to disable this feature.")
				.defineInRange("Spider_SpawnedRiderChance", 10, 0, Short.MAX_VALUE);
		spiderRiderChanceRandom = builder
				.comment("Chance (1 in X) that a randomly spawned entity from the RiderEntities list can start riding on random spiders.",
						"Set to 0 to disable this feature.")
				.defineInRange("Spider_StartRidingChance", 10, 0, Short.MAX_VALUE);
		spiderSlownessChance = builder
				.comment("Chance (1 in X) for a spider to apply the slowness effect on attack.",
						"Set to 0 to disable this feature.")
				.defineInRange("Spider_SlownessChance", 1, 0, Short.MAX_VALUE);
		spiderSlownessDuration = builder
				.comment("Duration in seconds of the applied slowness effect.")
				.defineInRange("Spider_SlownessDuration", 10, 0, Short.MAX_VALUE);
		spiderSlownessCreateWeb = builder
				.comment("Set this to false to prevent spiders from creating webs on slowed targets.")
				.define("Spider_SlownessWeb", true);
		spiderIgnoreFallDamage = builder
				.comment("The fall damage spiders take is multiplied by this value (0.0 means no fall damage, 1.0 means normal full damage).")
				.defineInRange("Spider_IgnoreFallDamageMultiplier", 0.0F, 0.0F, 1.0F);
		spiderEntities = builder
				.comment("Entities which count as Spiders.")
				.define("Spider_Entities", Constants.getRegNames(Arrays.asList(Constants.SPIDERS)));
		spiderRiderEntities = builder
				.comment("Entities which may ride on spiders.")
				.define("Spider_RiderEntities", Constants.getRegNames(Arrays.asList(Constants.DEFAULT_SPIDER_RIDERS)));
		builder.pop();
		
		// Zombie Features
		
		builder.push("Zombie Features");
		zombieFeaturesEnabled = builder
				.comment("Enable this to use all Zombie features.")
				.define("Zombie_FeaturesEnabled", true);
		zombieBabyBurn = builder
				.comment("Set this to false to prevent baby zombies from burning in sunlight.")
				.define("Zombie_BabyBurns", true);
		zombieHelmetBurn = builder
				.comment("Set this to true to make all zombies burn in sunlight even if they wear a helmet.")
				.define("Zombie_HelmetBurn", true);
		zombieHorseChance = builder
				.comment("Chance (1 in X) that a zombie spawns riding a zombie horse.",
						"Set to 0 to disable this feature.")
				.defineInRange("Zombie_HorseChance", 10, 0, Short.MAX_VALUE);
		zombieHorseMinY = builder
				.comment("Minimum Y position above which zombie horses may spawn.")
				.defineInRange("Zombie_HorseMinY", 63, 0, Short.MAX_VALUE);
		zombieHungerChance = builder
				.comment("Chance (1 in X) for a zombie to apply the hunger effect on attack.",
						"Set to 0 to disable this feature.")
				.defineInRange("Zombie_HungerChance", 1, 0, Short.MAX_VALUE);
		zombieHungerDuration = builder
				.comment("Duration in seconds of the applied hunger effect.")
				.defineInRange("Zombie_HungerDuration", 10, 0, Short.MAX_VALUE);
		zombieLeapChance = builder
				.comment("Chance (1 in X) for a zombie to leap to the target.",
						"Set to 0 to disable this feature.")
				.defineInRange("Zombie_LeapChance", 5, 0, Short.MAX_VALUE);
		zombieLeapHeight = builder
				.comment("Amount of blocks the zombie jumps on leap attack.")
				.defineInRange("Zombie_LeapHeight", 0.2F, 0.0F, Byte.MAX_VALUE);
		zombieChampionChance = builder
				.comment("Chance (1 in X) for a newly spawned zombie to become a Zombie Champion")
				.defineInRange("Zombie_ChampionChance", 200, 0, Short.MAX_VALUE);
		zombieEntities = builder
				.comment("Entities which count as Zombies.")
				.define("Zombie_Entities", Constants.getRegNames(Arrays.asList(Constants.ZOMBIES)));
		zombieBreakBlocks = builder
				.comment("Blocks which can be destroyed by zombies if they have no attack target.",
						"Delete all lines to disable this feature.")
				.defineList("Zombie_BreakBlocks", Arrays.asList(Constants.DEFAULT_DESTROY_BLOCKS), RoughConfig.ELEMENT_STRING_VALIDATOR);
		zombieChampionNames = builder
				.comment("A list of names to be used by Zombie Champions.")
				.defineList("Zombie_ChampionNames", Arrays.asList(Constants.ZOMBIE_CHAMP_NAMES), RoughConfig.ELEMENT_STRING_VALIDATOR);
		zombieBuilderChance = builder
				.comment("Percent chance that a specific zombie can pillar and bridge",
						"Set to 0.0 to disable this feature")
				.defineInRange("Zombie_BuilderChance", .7F, 0.0F, 1.0F);
		builder.pop();
	
		// Zombie Pigman Features
	
		builder.push("Zombie Pigman Features");
		zombiePigmanFeaturesEnabled = builder
				.comment("Enable this to use all Zombie Pigman features.")
				.define("ZombiePigman_FeaturesEnabled", true);
		zombiePigmanAggressiveTouch = builder
				.comment("Set to false to prevent zombie pigman from getting aggressive if the player touches its hitbox.")
				.define("ZombiePigman_AggressiveTouch", false);
		zombiePigmanAlwaysAggressive = builder
				.comment("Set to true for zombie pigmen to always be aggressive.")
				.define("ZombiePigman_AlwaysAggressive", false);
		zombiePigmanAggressiveRange = builder
				.comment("The range at which zombie pigmen will be aggressive to the player..")
				.defineInRange("ZombiePigman_AggressiveRange", 10, 0, Short.MAX_VALUE);
		zombiePigmanAggressiveBlockRange = builder
				.comment("Block radius in which zombie pigman get aggressive if the player breaks blocks.")
				.defineInRange("ZombiePigman_AggressiveBlockRange", 20, 1, Short.MAX_VALUE);
		zombiePigmanAggressiveBlockChance = builder
				.comment("Chance (1 in X) that a zombie pigman gets aggressive if the player breaks nearby blocks.")
				.defineInRange("ZombiePigman_AggressiveBlockChance", 10, 0, Short.MAX_VALUE);
		zombiePigmanEntities = builder
				.comment("Entities which count as Zombie Pigmen.")
				.define("ZombiePigman_Entities", Constants.getRegNames(Arrays.asList(Constants.ZOMBIE_PIGMEN)));
		builder.pop();
	}
}