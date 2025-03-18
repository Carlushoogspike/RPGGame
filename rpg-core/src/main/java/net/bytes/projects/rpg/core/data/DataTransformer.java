package net.bytes.projects.rpg.core.data;

import java.util.Map;

/**
 * Interface representing a generic section class that provides methods to deserialize
 * objects to and from a map of string key-value pairs. This is useful for serializing
 * and deserializing data between different representations, such as saving game state
 * or reading from configuration files.
 *
 * @param <O> The type of object that the section class works with.
 */
public interface DataTransformer<O> {

    /**
     * Serializes the object into a map of key-value pairs. This method should convert the
     * object into a map representation where each key is a string, and the associated value
     * is another string, representing the data for that object.
     *
     * @return a map containing the serialized data of the object, with string keys and values.
     */
    Map<String, String> deserializeToMap();

    /**
     * Deserializes the object from the provided map of key-value pairs. This method should
     * convert the map back into an object of type O, based on the data contained within the map.
     *
     * @param map a map of string key-value pairs containing the serialized data.
     * @return an object of type O that represents the deserialized data from the map.
     */
    O serializeFromMap(Map<String, String> map);
}
