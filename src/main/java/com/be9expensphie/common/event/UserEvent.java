package com.be9expensphie.common.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEvent implements DomainEvent {

    /** Set by OutboxWriter. Consumers dedup on this. */
    private String eventId;
    private Long userId;
    private String email;
    private String fullName;
    private String eventType; // USER_REGISTERED, USER_UPDATED
}
