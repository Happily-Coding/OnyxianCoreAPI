package com.github.onyxiansoul.onyxiancoreapi.actionable_system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.NotNull;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

/** The base for any RuntimeSupplier aka any class that from an object is able to return useful data for at least one of the methods in this class.All Onyxian plugins that require obtaining data have their unique implementation of this class
 * Only onyxian plugins should extend this interface directly.
 * All other plugins should extend the implementation located on the api of one of the onyxianPlugins.
 * @param <TriggerT> The type of object(usually an event), that triggered the reaction.
 * @param <TriggeredT> The type of object that reacted to the trigger (for example a block evolution)
 */
public abstract class RuntimeSupplier<TriggerT, TriggeredT> {
  
  protected final TriggerT trigger;
  protected final TriggeredT triggered;
  protected final Map<String,Object> supplierStorage;

  public RuntimeSupplier(@NotNull TriggerT trigger, @NotNull TriggeredT triggered){
    this.trigger = trigger;
    this.triggered = triggered;
    this.supplierStorage = new HashMap<>();
  }

  /**Get the class required by this supplier
   * @return  The class of the event
   * Deprecated because it may be removed.
   */
  @Nullable @Deprecated
  public abstract Class<?> getRequiredSourceType();

  /**Get the name of the data obtainer, it will be used as a unique ID when registering the data obtainer And as string signal, when reading the config file.
   * Please, DO NOT include EVENT, OBTAINER or DATA_OBTAINER in the name & separate worlds with underscores.
   * This will help mantain naming consistency, and make it easier for users configurating the plugin.
   * @return the Config String signal and Unique identifier for this data obtainer. */
  @NotNull
  public abstract String getDataObtainerName();

  /** Get the blocks affected by this event.
   * @param e = an event of this type
   * @return  The blocks affected by this event.Should always have a block. Can'trigger be null or empty*/
  @Nullable
  public List<Block> getAffectedBlocks() {return null;}

  /** Get the Player who triggered the event
   * @param e = an event of this type
   * @return The player who triggered the event. Can be null if the event wasn'trigger caused by a player.
   */
  @Nullable
  public Player getTriggerPlayer() { return null ; }

  /**Get the Explosion cause of this event
   * @param e = an event of this type
   * @return The Entity that generated the explosion. Will be null if it the event wasn'trigger caused by an explosion or if the explosion wasn'trigger caused by an entity.
   */
  @Nullable
  public EntityType getExplosionCause(){ return null; }

  /**Get the amount of Exp dropped by the event
   * @param e = an event of this type
   * @return amount of Exp dropped by the event. Will be null if it the event doesn'trigger drop xp.
   */
  @Nullable
  public Integer getExpDropped(){ return null; }

  /**Check if the event causes the drop of items.
   * @param e = an event of this type
   * @return true if the event drops items, false if it doesnt
   */
  @NotNull
  public boolean isItemDropper(){ return false; }

  /**Gets the block face which was interacted with (in one way or another), when the event was triggered
   * @param e = an event of this type
   * @return the block face which was interacted with (in one way or another), when the event was triggered. (null by default)
   */
  @Nullable
  public BlockFace getBlockFace() { return null; } 

  /**Check if the block is instabroken as a result of the event.
   * @param e = an event of this type
   * @return false if the event doesn'trigger break the block instantly or doesn'trigger break the block at all.
   */
  @NotNull
  public boolean isBlockInstaBroken() { return false; } 

  /**Get the list of blockStates which are involved on an event. 
   * Blocks represent the current status of a cube in a location of a world.
   * Like blocks, blockstates represent the material + blockData of a location,
   * but unlike blocks, they may represent a previous, current, future or possible cube for a location.
   * Thats why some events, which deal with changing status of a block, such as replacements will
   * in addition to blocks have blockStates involved in the event, representing either the past or future of a cube.
   * @param e = an event of this type
   * @return the list of blockStates which are involved on an event. Usually a single entry, representing the past or future of a cube.
  */
  @Nullable
  public List<BlockState> getInvolvedStates(){ return null; }

  /**Get the element uses as its source, and whose interpretation it allows*/
  @NotNull
  public TriggerT getTrigger(){
    return trigger;
  }
  
  /**Gets the element that was triggered by the trigger, that needs this runtime supplier to be able to react to the trigger.*/
  public TriggeredT getTriggered(){
    return triggered;
  }
  
  /**Gets the storage specific for this runtime supplier. Since a runtime supplier is created for each event, keep in mind it will be cleared across events
   * Also keep in mind, a runtime supplier is created for each triggered, and therefore, this storage isn't shared between them.
   * This storage is mainly meant for when you need an action to get and store a value, that will be used by other actions (inside the same triggered element) 
   */
  public @NotNull Map<String,?> getStorage(){
    return supplierStorage;
  }
    
}
