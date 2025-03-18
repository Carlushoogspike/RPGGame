package net.bytes.projects.rpg.core.providers.item;

import net.bytes.projects.rpg.core.providers.attribute.AttributeType;

/**
 * Interface representing the attributes of an equipable item. Equipable items are those that can be
 * worn or equipped by a player or character, such as armor, weapons, or accessories.
 * This interface provides methods to access various behaviors and attributes related to equipable items.
 */
public interface ItemAttributeEquipable {

    /**
     * Retrieves the type of attribute associated with this equipable item.
     * This can be used to determine what kind of attribute the equipable item provides, such as health bonuses, attack damage, etc.
     *
     * @return the {@link AttributeType} that defines the nature of the equipable item's attribute.
     */
    AttributeType getTypeOfAttribute();

    /**
     * Retrieves the value of the attribute that is received per tick while the item is equipped.
     * For example, this could represent how much health or energy the player gains per tick while wearing a piece of armor or a weapon.
     *
     * @return the value received per tick while the item is equipped.
     */
    double getReceivePerTicks();

    /**
     * Retrieves the tick rate at which the equipable item provides its attribute effect.
     * This could be used for items that provide buffs or debuffs over time, such as health regeneration or damage absorption.
     *
     * @return the number of ticks after which the equipable item provides its attribute effect.
     */
    long getConsumesTick();
}
