package com.be9expensphie.common.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailEvent implements DomainEvent {
    private String to;
    private String subject;
    private String body;
    private String eventType; // ACTIVATION, FORGOT_PASSWORD
    private Map<String, String> metadata;

    /*
     * Set by OutboxWriter, or by EmailProducer on the forgot-password path
     * which does not use one. email-service dedups on it.
     *
     * LAST on purpose: @AllArgsConstructor is called positionally
     * (new EmailEvent(to, subject, body, eventType, null)), so inserting this
     * field anywhere else would silently rebind those arguments.
     */
    private String eventId;
}
