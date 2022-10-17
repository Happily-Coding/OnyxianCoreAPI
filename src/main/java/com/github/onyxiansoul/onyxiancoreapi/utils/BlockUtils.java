package com.github.onyxiansoul.onyxiancoreapi.utils;

import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.Event;

//Final because its not supossed to be subclassed
public final class BlockUtils {
    // private constructor to avoid unnecessary instantiation of the class
    private BlockUtils(){
        
    }
    
    //Metodo que dice si un material es rompible por piston
    public static boolean isBrokenByPistonPush(Material materialToCheck){
        return pistonBreakableMaterials.contains(materialToCheck);
    }
    
    public static boolean isUnaffectedByPistonPush(Material materialToCheck){
        return pistonUnnaffectedMaterials.contains(materialToCheck);
    }
    
    
    private static final Set<Material> pistonBreakableMaterials = Sets.newHashSet(
    Material.CACTUS,
    //Material.BEDS
    Material.CAKE,
    Material.CARVED_PUMPKIN,
    Material.CHORUS_FLOWER,
    Material.CHORUS_PLANT,
    Material.COBWEB,
    Material.COCOA,
    Material.WHEAT,
    //Material.DOORS
    Material.DRAGON_EGG,
    Material.FIRE,
    //Material.flowers
    Material.FLOWER_POT,
    Material.ITEM_FRAME,
    Material.JACK_O_LANTERN,
    Material.LAVA,
    Material.LADDER,
    //Material.leaves
    Material.LILY_PAD,
    Material.MELON,
    //Material.HEADS
    //Material.mushrooms
    Material.NETHER_WART,
    Material.PAINTING,
    //Material.preassureplates
    Material.PUMPKIN,
    Material.COMPARATOR,
    Material.REDSTONE_WIRE,
    Material.SHULKER_BOX,
    Material.SNOW,
    Material.TRIPWIRE_HOOK,
    Material.TURTLE_EGG,
    Material.VINE,
    Material.WATER
    //Material.weightedPreassurePlates
    );
    
    //No se si esto no es de pull
    private static final Set<Material> pistonUnnaffectedMaterials = Sets.newHashSet(
        Material.BARRIER,
        Material.LODESTONE,
        Material.BEDROCK,
        Material.CAMPFIRE,
        Material.COMMAND_BLOCK,
        Material.ENCHANTING_TABLE,
        Material.END_GATEWAY,
        Material.END_PORTAL,
        Material.END_PORTAL_FRAME,
        Material.ENDER_CHEST,
        Material.JIGSAW,
        Material.SOUL_CAMPFIRE,
        Material.SPAWNER,
        Material.NETHER_PORTAL,
        Material.OBSIDIAN,
        Material.CRYING_OBSIDIAN,
        Material.PISTON,//solo extended
        Material.PISTON_HEAD,
        Material.BEEHIVE,
        Material.BEE_NEST,
        Material.DAYLIGHT_DETECTOR,
        Material.LECTERN,
        Material.BARREL,
        Material.BLAST_FURNACE,
        Material.BREWING_STAND,
        Material.CHEST,
        Material.DISPENSER,
        Material.DROPPER,
        Material.FURNACE,
        Material.HOPPER,
        Material.JUKEBOX,
        Material.SMOKER,
        Material.TRAPPED_CHEST
        //Material.BANNERS
        //MATERIAL:SIGNS
        //Material.GlazedTerracotas
        
    );
    
    //POR AHORA NO TIENE SENTIDO
    //private static final Set<Material> interactableBlocks = new HashSet<>();
    
    
       /*private static void generateInteractableBlocksSet(){
        for(Material material: Material.values()){
           
            if(org.bukkit.block.data.type.Switch.class.isAssignableFrom(material.getData())
            ||org.bukkit.block.data.type.
                    ){
                
            }
        }
        
        
                    case ACACIA_BUTTON:
            case ACACIA_DOOR:
            case ACACIA_FENCE:
            case ACACIA_FENCE_GATE:
            case ACACIA_SIGN:
            case ACACIA_STAIRS:
            case ACACIA_TRAPDOOR:
            case ACACIA_WALL_SIGN:
            case ANDESITE_STAIRS:
            case ANVIL:
            case BARREL:
            case BEACON:
            case BEEHIVE:
            case BEE_NEST:
            case BELL:
            case BIRCH_BUTTON:
            case BIRCH_DOOR:
            case BIRCH_FENCE:
            case BIRCH_FENCE_GATE:
            case BIRCH_SIGN:
            case BIRCH_STAIRS:
            case BIRCH_TRAPDOOR:
            case BIRCH_WALL_SIGN:
            case BLACKSTONE_STAIRS:
            case BLACK_BED:
            case BLACK_SHULKER_BOX:
            case BLAST_FURNACE:
            case BLUE_BED:
            case BLUE_SHULKER_BOX:
            case BREWING_STAND:
            case BRICK_STAIRS:
            case BROWN_BED:
            case BROWN_SHULKER_BOX:
            case CAKE:
            case CAMPFIRE:
            case CARTOGRAPHY_TABLE:
            case CAULDRON:
            case CHAIN_COMMAND_BLOCK:
            case CHEST:
            case CHIPPED_ANVIL:
            case COBBLESTONE_STAIRS:
            case COMMAND_BLOCK:
            case COMPARATOR:
            case COMPOSTER:
            case CRAFTING_TABLE:
            case CRIMSON_BUTTON:
            case CRIMSON_DOOR:
            case CRIMSON_FENCE:
            case CRIMSON_FENCE_GATE:
            case CRIMSON_SIGN:
            case CRIMSON_STAIRS:
            case CRIMSON_TRAPDOOR:
            case CRIMSON_WALL_SIGN:
            case CYAN_BED:
            case CYAN_SHULKER_BOX:
            case DAMAGED_ANVIL:
            case DARK_OAK_BUTTON:
            case DARK_OAK_DOOR:
            case DARK_OAK_FENCE:
            case DARK_OAK_FENCE_GATE:
            case DARK_OAK_SIGN:
            case DARK_OAK_STAIRS:
            case DARK_OAK_TRAPDOOR:
            case DARK_OAK_WALL_SIGN:
            case DARK_PRISMARINE_STAIRS:
            case DAYLIGHT_DETECTOR:
            case DIORITE_STAIRS:
            case DISPENSER:
            case DRAGON_EGG:
            case DROPPER:
            case ENCHANTING_TABLE:
            case ENDER_CHEST:
            case END_STONE_BRICK_STAIRS:
            case FLETCHING_TABLE:
            case FLOWER_POT:
            case FURNACE:
            case GRANITE_STAIRS:
            case GRAY_BED:
            case GRAY_SHULKER_BOX:
            case GREEN_BED:
            case GREEN_SHULKER_BOX:
            case GRINDSTONE:
            case HOPPER:
            case IRON_DOOR:
            case IRON_TRAPDOOR:
            case JIGSAW:
            case JUKEBOX:
            case JUNGLE_BUTTON:
            case JUNGLE_DOOR:
            case JUNGLE_FENCE:
            case JUNGLE_FENCE_GATE:
            case JUNGLE_SIGN:
            case JUNGLE_STAIRS:
            case JUNGLE_TRAPDOOR:
            case JUNGLE_WALL_SIGN:
            case LECTERN:
            case LEVER:
            case LIGHT_BLUE_BED:
            case LIGHT_BLUE_SHULKER_BOX:
            case LIGHT_GRAY_BED:
            case LIGHT_GRAY_SHULKER_BOX:
            case LIME_BED:
            case LIME_SHULKER_BOX:
            case LOOM:
            case MAGENTA_BED:
            case MAGENTA_SHULKER_BOX:
            case MOSSY_COBBLESTONE_STAIRS:
            case MOSSY_STONE_BRICK_STAIRS:
            case MOVING_PISTON:
            case NETHER_BRICK_FENCE:
            case NETHER_BRICK_STAIRS:
            case NOTE_BLOCK:
            case OAK_BUTTON:
            case OAK_DOOR:
            case OAK_FENCE:
            case OAK_FENCE_GATE:
            case OAK_SIGN:
            case OAK_STAIRS:
            case OAK_TRAPDOOR:
            case OAK_WALL_SIGN:
            case ORANGE_BED:
            case ORANGE_SHULKER_BOX:
            case PINK_BED:
            case PINK_SHULKER_BOX:
            case POLISHED_ANDESITE_STAIRS:
            case POLISHED_BLACKSTONE_BRICK_STAIRS:
            case POLISHED_BLACKSTONE_BUTTON:
            case POLISHED_BLACKSTONE_STAIRS:
            case POLISHED_DIORITE_STAIRS:
            case POLISHED_GRANITE_STAIRS:
            case POTTED_ACACIA_SAPLING:
            case POTTED_ALLIUM:
            case POTTED_AZURE_BLUET:
            case POTTED_BAMBOO:
            case POTTED_BIRCH_SAPLING:
            case POTTED_BLUE_ORCHID:
            case POTTED_BROWN_MUSHROOM:
            case POTTED_CACTUS:
            case POTTED_CORNFLOWER:
            case POTTED_CRIMSON_FUNGUS:
            case POTTED_CRIMSON_ROOTS:
            case POTTED_DANDELION:
            case POTTED_DARK_OAK_SAPLING:
            case POTTED_DEAD_BUSH:
            case POTTED_FERN:
            case POTTED_JUNGLE_SAPLING:
            case POTTED_LILY_OF_THE_VALLEY:
            case POTTED_OAK_SAPLING:
            case POTTED_ORANGE_TULIP:
            case POTTED_OXEYE_DAISY:
            case POTTED_PINK_TULIP:
            case POTTED_POPPY:
            case POTTED_RED_MUSHROOM:
            case POTTED_RED_TULIP:
            case POTTED_SPRUCE_SAPLING:
            case POTTED_WARPED_FUNGUS:
            case POTTED_WARPED_ROOTS:
            case POTTED_WHITE_TULIP:
            case POTTED_WITHER_ROSE:
            case PRISMARINE_BRICK_STAIRS:
            case PRISMARINE_STAIRS:
            case PUMPKIN:
            case PURPLE_BED:
            case PURPLE_SHULKER_BOX:
            case PURPUR_STAIRS:
            case QUARTZ_STAIRS:
            case REDSTONE_ORE:
            case REDSTONE_WIRE:
            case RED_BED:
            case RED_NETHER_BRICK_STAIRS:
            case RED_SANDSTONE_STAIRS:
            case RED_SHULKER_BOX:
            case REPEATER:
            case REPEATING_COMMAND_BLOCK:
            case RESPAWN_ANCHOR:
            case SANDSTONE_STAIRS:
            case SHULKER_BOX:
            case SMITHING_TABLE:
            case SMOKER:
            case SMOOTH_QUARTZ_STAIRS:
            case SMOOTH_RED_SANDSTONE_STAIRS:
            case SMOOTH_SANDSTONE_STAIRS:
            case SOUL_CAMPFIRE:
            case SPRUCE_BUTTON:
            case SPRUCE_DOOR:
            case SPRUCE_FENCE:
            case SPRUCE_FENCE_GATE:
            case SPRUCE_SIGN:
            case SPRUCE_STAIRS:
            case SPRUCE_TRAPDOOR:
            case SPRUCE_WALL_SIGN:
            case STONECUTTER:
            case STONE_BRICK_STAIRS:
            case STONE_BUTTON:
            case STONE_STAIRS:
            case STRUCTURE_BLOCK:
            case SWEET_BERRY_BUSH:
            case TNT:
            case TRAPPED_CHEST:
            case WARPED_BUTTON:
            case WARPED_DOOR:
            case WARPED_FENCE:
            case WARPED_FENCE_GATE:
            case WARPED_SIGN:
            case WARPED_STAIRS:
            case WARPED_TRAPDOOR:
            case WARPED_WALL_SIGN:
            case WHITE_BED:
            case WHITE_SHULKER_BOX:
            case YELLOW_BED:
            case YELLOW_SHULKER_BOX:
        Material.values()
        //placeEvent.getBlock().getType().isInteractable();
    
    }*/
    
    
    
    //Returnea true si todoas las propiedades son iguales entre materiales
    public boolean areMaterialPropertiesEqual(Material baseMaterial, Material comparedMaterial){
        if(baseMaterial.hasGravity() == comparedMaterial.hasGravity()
        && baseMaterial.isFlammable() == comparedMaterial.isFlammable() //Aka if it can catch fire
        && baseMaterial.isBurnable() == comparedMaterial.isBurnable() //Aka if it can burn away
        && baseMaterial.isOccluding() == comparedMaterial.isOccluding() //aka if it fully blocks your vision
        && baseMaterial.isSolid() == comparedMaterial.isSolid()
        && baseMaterial.getBlastResistance() == comparedMaterial.getBlastResistance()
        && baseMaterial.getHardness() == comparedMaterial.getHardness()
        && baseMaterial.isAir() == comparedMaterial.isAir())
        {return true;}
        return false;

    }
    
    
       public static BlockFace getFacePlacedAgainst(Block blockPlacedAt, Block placedBlock){
        int xDif = blockPlacedAt.getX()- placedBlock.getX();
        int zDif = blockPlacedAt.getZ() - placedBlock.getZ();
        int yDif = blockPlacedAt.getY() - placedBlock.getY();
        if(xDif != 0){
            if (xDif==1){
                return BlockFace.EAST;
            }
            return BlockFace.WEST;
        }
        else if(zDif!=0){
            if(zDif==1){
                return BlockFace.SOUTH;
            }
            return BlockFace.NORTH;
        }
        else if(yDif!=0){
            if(yDif==1){
                return BlockFace.UP;
            }
            return BlockFace.DOWN;
        }
        return null; //Impossible case.
    }
    
    
    
}
    


    /*
    Reflection que puede servir para conseguir isBreakable:
    public static double getBlockHardness(Material m) {
        try {
            String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + ".";
            String name = "org.bukkit.craftbukkit." + version + "util.CraftMagicNumbers";
            Class c = Class.forName(name);
            Object block = c.getMethod("getBlock", Material.class).invoke(c, m);
            return Double.parseDouble(block.getClass().getMethod("g",
                    Class.forName("net.minecraft.server." + version + "World"), Class.forName("net.minecraft.server." + version + "BlockPosition"))
            .invoke(block, (Class)null, (Class)null)+"");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    //De: https://www.spigotmc.org/threads/help-with-reflection.225382/
    //Ademas, kinda piola nms intro: https://bukkit.programmingpedia.net/en/tutorial/9576/nms
    //Otro intro: https://www.spigotmc.org/threads/learn-nms-the-effective-way-overcome-obfuscation-packets-and-version-changing-code.425557/
    //Posiblemente util para obtener mat de string : https://bukkit.org/threads/get-material-by-minecraft-ingame-name.472923/
    
    //Y anti-nms lib para mats: https://www.spigotmc.org/threads/xseries-xmaterial-xparticle-xsound-xpotion-titles-actionbar-etc.378136/
    */
    
    //https://www.spigotmc.org/threads/make-piston-move.417551/