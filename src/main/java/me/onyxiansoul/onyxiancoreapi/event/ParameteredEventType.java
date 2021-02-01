package me.onyxiansoul.onyxiancoreapi.event;

import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

//Enum que tiene todos los tipos de evento, cada uno con metodos que pemriten obtener sus parametros.
//WARNING. No todos los metodos van a tener todos los parametros, antes de usarlos mirar la ENUM y asegurarse de que no deevuelva null!
public enum ParameteredEventType {
    BLOCK_DAMAGE{
        @Override
        public Player getTriggerPlayer(Event e) {
            return ((BlockDamageEvent)e).getPlayer();
        }
        @Override
        public List<Block> getAffectedBlocks(Event e) {
           List<Block> blocksList = new ArrayList<>();
           System.out.println("Parametered event type:");
           System.out.println("About to return:" +(Arrays.asList(((BlockDamageEvent)e).getBlock())).toString() );
           return Arrays.asList(((BlockDamageEvent)e).getBlock());
        }
    },
    BLOCK_BREAK{
        @Override
        public Player getTriggerPlayer(Event e) {
            return ((BlockBreakEvent)e).getPlayer();
        }
        @Override
        public List<Block> getAffectedBlocks(Event e) {
            return Arrays.asList(((BlockBreakEvent)e).getBlock() );
        }
    },
    BLOCK_BURN{
        @Override
        public List<Block> getAffectedBlocks(Event e) {
            return Arrays.asList(((BlockBurnEvent)e).getBlock() );
        }
    },
    BLOCK_PUSH{
        @Override
        public Player getTriggerPlayer(Event e) {
            return null; //Impossible to get it from this event
        }
        @Override
        public List<Block> getAffectedBlocks(Event e) {
            return ((BlockPistonExtendEvent) e).getBlocks();
        }
        @Override
        public BlockFace getPistonMovementDirection(Event e) {
            return ((BlockPistonExtendEvent) e).getDirection();
        }
    },
    BLOCK_PULL{
        @Override
        public Player getTriggerPlayer(Event e) {
            return null; //Impossible to get it from this event
        }
        @Override
        public List<Block> getAffectedBlocks(Event e) {
           return  ((BlockPistonRetractEvent) e).getBlocks();
        }
        @Override
        public BlockFace getPistonMovementDirection(Event e) {
            return ((BlockPistonRetractEvent) e).getDirection();
        }
    },
    BLOCK_INTERACT{
        @Override
        public Player getTriggerPlayer(Event e) {
            return ((PlayerInteractEvent)e).getPlayer();
        }
        @Override
        public List<Block> getAffectedBlocks(Event e) {
            return Arrays.asList(((PlayerInteractEvent)e).getClickedBlock());
        }
    },
    BLOCK_PLACE{ //Tiene sentido? no era mejor el interact?
        @Override
        public Player getTriggerPlayer(Event e) {
            return ((BlockPlaceEvent)e).getPlayer();
        }
        @Override
        public List<Block> getAffectedBlocks(Event e) {
           return Arrays.asList(((BlockPlaceEvent)e).getBlockPlaced());
        }
    },
    /*SHIFT_BLOCK_PLACE{
        @Override
        public Player getTriggerPlayer(Event e) {
            return ((BlockPlaceEvent)e).getPlayer();
        }
        @Override
        public List<Block> getAffectedBlocks(Event e) {
           return Arrays.asList(((BlockPlaceEvent)e).getBlockPlaced());
        }
    },*/
    BLOCK_EXPLOSION{
        @Override
        public Player getTriggerPlayer(Event e) {
            return null;
        }
        @Override
        public List<Block> getAffectedBlocks(Event e) {
            return ((EntityExplodeEvent)e).blockList();
        }
        @Override
        public EntityType explosionCause(Event e){
            return  ((EntityExplodeEvent)e).getEntityType();
        }
    };

    public static final Map<String,ParameteredEventType> CONFIG_ALIASES = ImmutableMap.of("LEFT_CLICK_BLOCK", BLOCK_DAMAGE, "RIGHT_CLICK_BLOCK", BLOCK_INTERACT);
    //Lista de los getters para cualquier parametro que puedan tener los eventos.
    public Player getTriggerPlayer(Event e) { return null; }  //Gets the player that caused the event
    public List<Block> getAffectedBlocks(Event e) { return null; } //Gets a list of all affected blocks
    public BlockFace getPistonMovementDirection(Event e) {return null; } //Gets the direction the blocks are moved to
    public EntityType explosionCause(Event e){ return null; } //Get the explosion cause if the event has one.
    

    
    
}

