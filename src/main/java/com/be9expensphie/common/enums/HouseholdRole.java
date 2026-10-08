package com.be9expensphie.common.enums;

/**
 * A member's role within a household.
 *
 * Shared because it is a shared concept. household-service owns membership and
 * decides the role, but expense-service reads it out of its own projection to
 * answer "is this user an admin?" -- so both compile against the same
 * declaration rather than keeping two that have to be remembered in step.
 *
 * Previously declared independently in both services. Adding a value to one
 * left the other unable to deserialize it, which is the same shape of trap as
 * a native enum column the schema never alters.
 *
 * HouseholdMemberEvent.role stays a String on the wire deliberately: a value
 * this enum does not know should be a handled event, not a deserialization
 * failure that stalls the whole topic.
 */
public enum HouseholdRole {
    ROLE_ADMIN,
    ROLE_MEMBER
}
