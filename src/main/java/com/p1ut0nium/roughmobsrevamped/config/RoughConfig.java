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

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

import com.p1ut0nium.roughmobsrevamped.core.RoughMobsRevamped;
import com.p1ut0nium.roughmobsrevamped.reference.Constants;

import net.minecraft.world.Explosion.Mode;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod.EventBusSubscriber
public class RoughConfig {
	
	public static HashMap<String, Boolean> featuresEnabled = new HashMap<>();
	public static HashMap<String, List<String>> entities = new HashMap<>();
	
	// Mod Compat Config
	
	public static boolean useAllStages;
	public static boolean useEquipmentStage;
	public static boolean useBossStage;
	public static boolean useAbilitiesStage;
	public static boolean useEnchantStage;
	
	public static List<String> seasonWhiteList;
	
	// Spawn Conditions Config
	
	public static boolean mustBeUnderground;
	public static int minPlayerLevel;
	public static int maxSpawnHeight;
	public static int minDistFromSpawn;
	
	// Equipment Config
	
	public static int chancePerWeapon;
	public static int chancePerArmor;
	public static int chancePerEnchantment;
	public static float enchantMultiplier;
	public static float dropChance;
	
	public static List<? extends String> equipMainhand;
	public static List<? extends String> equipOffhand;
	public static List<? extends String> equipHelmet;
	public static List<? extends String> equipChestplate;
	public static List<? extends String> equipLeggings;
	public static List<? extends String> equipBoots;
	public static List<? extends String> equipWeaponEnchants;
	public static List<? extends String> equipArmorEnchants;
	
	public static boolean chanceTimeMultiplier;
	public static boolean chanceDistMultiplier;
	public static int distThreshold;
	public static boolean disableBabyZombieEquipment;
	
	// Features Config
	
	public static boolean blazeFeaturesEnabled;
	public static boolean blazePushAttackersAway;
	public static boolean blazeFlameTouch;
	public static float blazePushDamage;
	public static float blazeDeathExplosionStrength;
	public static Mode blazeDeathExplosionType;
	public static List<String> blazeEntities;
	
	public static boolean spiderFeaturesEnabled;
	public static boolean spiderSlownessCreateWeb;
	public static int spiderRiderChance;
	public static int spiderRiderChanceRandom;
	public static int spiderSlownessChance;
	public static int spiderSlownessDuration;
	public static float spiderIgnoreFallDamage;
	public static List<String> spiderEntities;
	public static List<String> spiderRiderEntities;
	
	public static boolean zombieFeaturesEnabled;
	public static boolean zombieBabyBurn;
	public static boolean zombieHelmetBurn;
	public static int zombieHorseChance;
	public static int zombieHorseMinY;
	public static int zombieHungerChance;
	public static int zombieHungerDuration;
	public static int zombieLeapChance;
	public static int zombieChampionChance;
	public static float zombieBuilderChance;
	public static float zombieLeapHeight;
	public static List<String> zombieEntities;
	public static List<? extends String> zombieBreakBlocks;
	public static List<? extends String> zombieChampionNames;
	
	public static boolean zombiePigmanFeaturesEnabled;
	public static boolean zombiePigmanAggressiveTouch;
	public static boolean zombiePigmanAlwaysAggressive;
	public static int zombiePigmanAggressiveRange;
	public static int zombiePigmanAggressiveBlockRange;
	public static int zombiePigmanAggressiveBlockChance;
	public static List<String> zombiePigmanEntities;
	
	public static boolean hostileHorseFeaturesEnabled;
	public static boolean hostileHorseBurn;
	public static boolean hostileHorseCanDespawn;
	public static int hostileHorseRiderChance;
	public static List<String> hostileHorseEntities;
	
	// Attributes Config
	
	public static List<? extends String> attributes;
	
	// Fog Config
	
	public static boolean bossFogEnabled;
	public static List<Float> bossFogColor;
	public static int bossFogMaxDist;
	public static int bossFogStartDist;
	public static int bossFogFarPlane;
	public static float bossFogFarPlaneScale;
	
	public static boolean bossFogDoTEnabled;
	public static boolean bossFogDoTWarning;
	public static boolean bossFogPlayerCough;
	public static int bossFogDoTDelay;
	public static int bossFogDoTWarningTime;
	public static int bossFogDoTDamage;

	// Setup config directory
	
	public static void init() {
		
		Path configPath = FMLPaths.CONFIGDIR.get();
		Path roughConfigPath = Paths.get(configPath.toAbsolutePath().toString(), Constants.MOD_CONFIG_DIRECTORY);
		
		try {
			Files.createDirectory(roughConfigPath);
		} catch (FileAlreadyExistsException e) {
			// Do nothing
		} catch (IOException e) {
			RoughMobsRevamped.LOGGER.error("Failed to create config directory.", e);
		}
	}
	
	// Register all config files
	
    public static void register(final ModLoadingContext context) {
        context.registerConfig(ModConfig.Type.COMMON, ConfigHolder.MODCOMPAT_SPEC, Constants.MOD_CONFIG_DIRECTORY + "/" + Constants.MOD_COMPAT_CONFIG_FILENAME);
        context.registerConfig(ModConfig.Type.COMMON, ConfigHolder.SPAWNCONDITIONS_SPEC, Constants.MOD_CONFIG_DIRECTORY + "/" + Constants.SPAWN_CONDITIONS_CONFIG_FILENAME);
        context.registerConfig(ModConfig.Type.COMMON, ConfigHolder.EQUIPMENT_SPEC, Constants.MOD_CONFIG_DIRECTORY + "/" + Constants.EQUIPMENT_CONFIG_FILENAME);
        context.registerConfig(ModConfig.Type.COMMON, ConfigHolder.FEATURES_SPEC, Constants.MOD_CONFIG_DIRECTORY + "/" + Constants.FEATURES_CONFIG_FILENAME);
        context.registerConfig(ModConfig.Type.COMMON, ConfigHolder.ATTRIBUTES_SPEC, Constants.MOD_CONFIG_DIRECTORY + "/" + Constants.ATTRIBUTES_CONFIG_FILENAME);
        context.registerConfig(ModConfig.Type.COMMON, ConfigHolder.FOG_SPEC, Constants.MOD_CONFIG_DIRECTORY + "/" + Constants.FOG_CONFIG_FILENAME);
    }
    
    public static final Predicate<Object> ENTITY_CLASS_VALIDATOR = (obj) -> {
    	List<Object> entityClasses = Arrays.asList(obj);
        try {
        	entityClasses.stream()
        	.filter(e -> e.getClass().equals(String.class))
        	.allMatch(e -> e.toString().endsWith(".class"));
        }
        catch (Exception e) {
            // Element is not a class, so return invalid
            return false;
        }

        return true;
    };
    
    public static final Predicate<Object> ELEMENT_STRING_VALIDATOR = (obj) -> {
    	List<Object> elements = Arrays.asList(obj);
        try {
        	elements.stream()
        	.allMatch(e -> e.getClass().equals(String.class));
        }
        catch (Exception e) {
            // Element is not a string, so return invalid
            return false;
        }

        return true;
    };
}
