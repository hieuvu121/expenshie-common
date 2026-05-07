package com.be9expensphie.common.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseEvent {
    private Long expenseId;
    private Long householdId;
    private String status;         // PENDING, APPROVED, REJECTED
    private BigDecimal amount;
    private String currency;
    private String category;
    private String description;
    private String method;         // EQUAL, AMOUNT

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Long createdByMemberId;
    private List<SplitDetail> splits;
    private String eventType; // EXPENSE_CREATED, EXPENSE_APPROVED, EXPENSE_UPDATED, EXPENSE_REJECTED

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class SplitDetail {
        private Long memberId;
        private BigDecimal amount;
    }
}
