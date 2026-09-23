package com.be9expensphie.common.event;

/**
 * An event the outbox can stamp with an identity.
 *
 * Exists so OutboxWriter can set the id on the payload rather than only on the
 * row it writes. Before this the id lived in outbox_event and nowhere else, so
 * consumers had nothing to dedup on and the at-least-once publisher's
 * duplicates were indistinguishable from genuinely new events.
 *
 * Implemented only by events that actually travel through an outbox.
 * HouseholdMemberEvent and the AI events deliberately do not: nothing would
 * ever set their id, and a field that is always null reads as a bug.
 */
public interface DomainEvent {
    String getEventId();

    void setEventId(String eventId);
}
