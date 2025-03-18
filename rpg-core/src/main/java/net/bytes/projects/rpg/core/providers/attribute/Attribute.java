package net.bytes.projects.rpg.core.providers.attribute;

/**
 * Interface representing an attribute associated with a game object,
 * such as a character or item. Attributes are typically tied to specific values,
 * modifiers, and other gameplay-related mechanics.
 */
public interface Attribute {

    /**
     * Retrieves the type of the attribute.
     * The attribute type defines the category of the attribute (e.g., health, damage, defense).
     *
     * @return the {@link AttributeType} that defines the nature of the attribute.
     */
    AttributeType getType();

    /**
     * Retrieves the modifier associated with this attribute.
     * The modifier determines how the attribute value is adjusted based on certain conditions.
     *
     * @return the {@link AttributeModifier} that provides the current and modified values of the attribute.
     */
    AttributeModifier getModifier();
}
