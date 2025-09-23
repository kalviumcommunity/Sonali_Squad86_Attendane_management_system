package com.school;

/**
 * Interface for objects that can be serialized to a single-line data string.
 */
public interface Storable {
    /**
     * Convert the object to a single-line CSV-ish string suitable for saving.
     * Example: "id,name,grade"
     */
    String toDataString();
}
