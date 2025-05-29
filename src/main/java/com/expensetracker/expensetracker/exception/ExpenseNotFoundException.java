package com.expensetracker.expensetracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExpenseNotFoundException extends RuntimeException {
    public ExpenseNotFoundException(Long id) {
        super("Expense not found with id: " + id);
    }
}

//public class ExpenseNotFoundException extends RuntimeException {
//    public ExpenseNotFoundException(String message) {
//        super(message);
//    }
//}