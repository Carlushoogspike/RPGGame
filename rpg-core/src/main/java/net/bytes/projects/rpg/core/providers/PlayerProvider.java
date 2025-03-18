package net.bytes.projects.rpg.core.providers;

import net.bytes.projects.rpg.core.data.DataTransformer;
import net.bytes.projects.rpg.core.providers.attribute.Attribute;

import java.util.Set;
import java.util.UUID;

/**
 * Interface representing a player in the game. A player is typically characterized by
 * a unique identifier, display name, level, experience points, and various attributes
 * that define their capabilities and stats in the game.
 */
public interface PlayerProvider extends DataTransformer<PlayerProvider> {

    /**
     * Retrieves the unique identifier of the player.
     * The unique ID is used to distinguish the player from other players in the system.
     *
     * @return the UUID of the player.
     */
    UUID getUniqueId();

    /**
     * Retrieves the display name of the player.
     * This is the name shown to others in the game or user interface, typically representing
     * the player's chosen name or alias.
     *
     * @return the display name of the player.
     */
    String getDisplayName();

    /**
     * Retrieves the level of the player.
     * The level typically represents the player's progression or experience in the game.
     * Higher levels usually correlate with greater strength, abilities, or access to more content.
     *
     * @return the level of the player.
     */
    int getLevel();

    /**
     * Retrieves the current experience points (XP) of the player.
     * XP is often accumulated as the player completes actions, quests, or challenges,
     * and is used to progress to higher levels.
     *
     * @return the current XP of the player.
     */
    double getXp();

    /**
     * Retrieves the set of attributes associated with the player.
     * Attributes define various statistics or abilities that the player possesses,
     * such as health, strength, agility, defense, etc.
     *
     * @return a set of {@link Attribute} objects representing the player's attributes.
     */
    Set<Attribute> getAttributes();
}
