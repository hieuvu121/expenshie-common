package com.be9expensphie.common.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * settlement-service's answer, and the pivot of the saga.
 *
 * One reply type carrying an outcome, rather than separate Accepted and Refused
 * classes. Two types on one topic only deserializes via __TypeId__ headers, and
 * every consumer factory in this codebase sets VALUE_DEFAULT_TYPE.
 *
 * settlementIds carries the voided ids on ACCEPTED and the blocking completed
 * ids on REFUSED, so the admin can be told exactly which debt stopped them.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseReversalDecided implements DomainEvent {
    private String eventId;
    private String sagaId;
    private Long expenseId;
    private ReversalOutcome outcome;
    private String reason;
    private List<Long> settlementIds;
}
