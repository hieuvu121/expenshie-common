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
public class EmailEvent {
    private String to;
    private String subject;
    private String body;
    private String eventType; // ACTIVATION, FORGOT_PASSWORD
    private Map<String, String> metadata;
}
