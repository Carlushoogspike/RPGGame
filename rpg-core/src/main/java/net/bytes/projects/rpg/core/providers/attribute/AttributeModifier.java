package net.bytes.projects.rpg.core.providers.attribute;

/**
 * Interface representing the modifier of an attribute.
 * The attribute modifier defines the current, maximum, and minimum values for an attribute,
 * allowing for dynamic changes during gameplay (e.g., buffs, debuffs, or scaling).
 */
public interface AttributeModifier {

    /**
     * Retrieves the current value of the attribute.
     * This value represents the present state of the attribute, which can change over time
     * due to gameplay mechanics like items, effects, or abilities.
     *
     * @return the current value of the attribute.
     */
    double getCurrent();

    /**
     * Sets the current value of the attribute.
     * This allows for modifications to the attribute's value in real-time based on game events.
     *
     * @param current the new current value of the attribute.
     */
    void setCurrent(double current);

    /**
     * Retrieves the maximum possible value of the attribute.
     * This represents the highest possible value that the attribute can reach, often capped by game mechanics.
     *
     * @return the maximum value of the attribute.
     */
    double getMax();

    /**
     * Sets the maximum value of the attribute.
     * This method allows you to adjust the upper limit of the attribute, typically due to level-ups, items, etc.
     *
     * @param max the new maximum value for the attribute.
     */
    void setMax(double max);

    /**
     * Retrieves the minimum possible value of the attribute.
     * This value represents the lowest possible value for the attribute, often constrained by game mechanics.
     *
     * @return the minimum value of the attribute.
     */
    double getMin();

    /**
     * Sets the minimum value of the attribute.
     * This method allows you to adjust the lower limit of the attribute, typically due to debuffs or other gameplay mechanics.
     *
     * @param min the new minimum value for the attribute.
     */
    void setMin(double min);
}
