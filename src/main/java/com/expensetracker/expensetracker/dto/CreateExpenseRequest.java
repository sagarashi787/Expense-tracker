package com.expensetracker.expensetracker.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateExpenseRequest(
        @NotNull
        String category,
        @NotNull @Positive
        BigDecimal amount
)
{}
