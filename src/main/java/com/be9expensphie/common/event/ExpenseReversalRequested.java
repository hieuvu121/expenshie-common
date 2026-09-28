package com.be9expensphie.common.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Asks settlement-service whether an approved expense may be reversed.
 *
 * A command rather than a fact, despite implementing DomainEvent -- it expects
 * an answer and only one service can give it. It implements DomainEvent because
 * it travels through the outbox and needs an eventId for dedup, not because it
 * is a past-tense business event.
 *
 * sagaId is not eventId. eventId identifies this message and is regenerated on
 * every publish attempt; sagaId identifies the reversal process and stays the
 * same across re-requests, which is what makes a retry answerable.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseReversalRequested implements DomainEvent {
    private String eventId;
    private String sagaId;
    private Long householdId;
    private Long expenseId;
    private Long requestedByMemberId;
}
