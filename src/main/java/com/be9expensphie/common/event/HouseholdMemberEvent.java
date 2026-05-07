package com.be9expensphie.common.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseholdMemberEvent {
    private Long memberId;
    private Long householdId;
    private Long userId;
    private String email;
    private String fullName;
    private String role; // ROLE_ADMIN, ROLE_MEMBER
    private String eventType; // MEMBER_JOINED, MEMBER_LEFT, ROLE_CHANGED
}
