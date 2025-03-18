package net.bytes.projects.rpg.core.exceptions;

public class FieldParserException extends RuntimeException {

    public FieldParserException(String fieldName) {
        super("Couldn't possible find the field with name '" + fieldName + "'");
    }

}
