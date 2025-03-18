package net.bytes.projects.rpg.core.providers.item;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/**
 * Interface representing a generic item provider in the game. This interface defines
 * the basic attributes and functionalities of an item, including its namespace, durability,
 * and whether it's consumable or equipable. It provides access to the respective attributes
 * for consumable and equipable items.
 */
public interface ItemProvider {

    /**
     * Retrieves the unique namespace of the item. The namespace is one of the key attributes
     * that helps in identifying the item uniquely within the game context.
     *
     * @return the namespace of the item, which is a unique identifier.
     */
    @NotNull
    String getNamespace();

    /**
     * Retrieves the current durability of the item. Durability typically decreases as the item is used.
     *
     * @return the current durability of the item, which can be a value between 0 and the maximum durability.
     */
    double getCurrentDurability();

    /**
     * Retrieves the maximum durability of the item. This is the highest value the item's durability can reach.
     * The durability is usually capped at this value.
     *
     * @return the maximum durability of the item, which should be between 0 and 2048.
     */
    @Range(from = 0, to = 2048)
    short getMaxDurability();

    /**
     * Checks if the item is consumable. Consumable items can typically be used up or consumed during gameplay.
     *
     * @return true if the item is consumable, false otherwise.
     */
    boolean isConsumable();

    /**
     * Retrieves the attributes related to the consumable nature of the item. This will contain additional details
     * that define how the item behaves when used as a consumable.
     *
     * @return an instance of {@link ItemAttributeConsumable} that provides specific attributes for consumable items.
     */
    ItemAttributeConsumable getAttributeConsumable();

    /**
     * Checks if the item is equipable. Equipable items can be equipped by a player, such as weapons, armor, etc.
     *
     * @return true if the item is equipable, false otherwise.
     */
    boolean isEquipable();

    /**
     * Retrieves the attributes related to the equipable nature of the item. This will contain additional details
     * that define how the item behaves when equipped by a player or character.
     *
     * @return an instance of {@link ItemAttributeEquipable} that provides specific attributes for equipable items.
     */
    ItemAttributeEquipable getAttributeEquipable();

}
