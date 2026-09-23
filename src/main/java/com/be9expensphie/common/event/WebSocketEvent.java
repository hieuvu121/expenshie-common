package com.be9expensphie.common.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebSocketEvent implements DomainEvent {

    /** Set by OutboxWriter. Consumers dedup on this. */
    private String eventId;
    private String destination; // e.g. /topic/households/1/expense
    private String payload;     // JSON-serialized event payload
}
