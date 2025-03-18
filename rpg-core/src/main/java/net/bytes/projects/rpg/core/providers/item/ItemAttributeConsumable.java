package net.bytes.projects.rpg.core.providers.item;

import net.bytes.projects.rpg.core.providers.attribute.AttributeType;

/**
 * Interface representing the attributes of a consumable item. Consumable items can have various behaviors
 * related to consumption during different actions such as handling, attacking, or defending.
 * This interface provides methods to access those behaviors and attributes.
 */
public interface ItemAttributeConsumable {

    /**
     * Retrieves the type of attribute associated with this consumable item.
     * This can be used to determine what kind of consumable the item represents, such as health potions, mana potions, etc.
     *
     * @return the {@link AttributeType} that defines the nature of the consumable item's attribute.
     */
    AttributeType getTypeOfAttribute();

    /**
     * Checks if the item consumes its value when handled by the player (e.g., during use or activation).
     *
     * @return true if the item consumes its value when handled, false otherwise.
     */
    boolean isConsumesOnHandle();

    /**
     * Retrieves the value consumed by the item when handled by the player.
     * For example, this could represent how much health or mana is consumed when the item is used.
     *
     * @return the value consumed when the item is handled (used or activated).
     */
    double getConsumeOnHandleValue();

    /**
     * Checks if the item consumes its value when used during an attack action.
     * For example, some consumable items might reduce their own durability or attributes when used in combat.
     *
     * @return true if the item consumes its value during an attack, false otherwise.
     */
    boolean isConsumesOnAttack();

    /**
     * Retrieves the value consumed by the item during an attack.
     * This can represent things like the amount of charges used when the item is employed in combat.
     *
     * @return the value consumed during an attack.
     */
    double getConsumeOnAttackValue();

    /**
     * Checks if the item consumes its value when used during a defense action.
     * This could be used for consumables that are used as a defensive item (e.g., shields or defensive potions).
     *
     * @return true if the item consumes its value during defense, false otherwise.
     */
    boolean isConsumesOnDefense();

    /**
     * Retrieves the value consumed by the item during a defense action.
     * This might represent a shield item or defensive consumable that is consumed when the player defends.
     *
     * @return the value consumed during defense.
     */
    double getConsumeOnDefenseValue();

    /**
     * Retrieves the tick rate at which the consumable item consumes its value over time.
     * This could be used for consumables that consume their value at regular intervals, like regeneration items.
     *
     * @return the number of ticks after which the consumable item's value is consumed.
     */
    long getConsumesTick();
}
