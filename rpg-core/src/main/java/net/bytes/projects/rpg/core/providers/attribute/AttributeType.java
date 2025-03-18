package net.bytes.projects.rpg.core.providers.attribute;

/**
 * Interface representing the type of an attribute in the game.
 * An attribute type defines the category or nature of an attribute,
 * such as health, strength, defense, or any other characteristic.
 */
public interface AttributeType {

    /**
     * Retrieves the unique namespace for the attribute type.
     * This namespace acts as an identifier for the specific category or kind of attribute,
     * ensuring its uniqueness within the system.
     *
     * @return the namespace of the attribute type.
     */
    String getNamespace();
}
