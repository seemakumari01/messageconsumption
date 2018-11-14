package com.messageconsumption.util;

/**
 * Roles Enum class
 * @author Seema
 */
public enum Roles {
    ADMINISTRATOR(0),
    MANAGER(1),
    ACCOUNTANT(2),
    CLEANER(3),
    HEADER_OF_CLEANER(4),
    GUEST_SUPPORT(5),
    PPROPERTY_OWNER(6),
    CONCIERAGE(7);

    private int role;

    private Roles(int role) {
        this.role = role;
    }
}
