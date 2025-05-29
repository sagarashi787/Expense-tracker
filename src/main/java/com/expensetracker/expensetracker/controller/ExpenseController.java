package com.expensetracker.expensetracker.controller;

import com.expensetracker.expensetracker.dto.CreateExpenseRequest;
import com.expensetracker.expensetracker.dto.CreateExpenseResponse;
import com.expensetracker.expensetracker.model.Expense;
import com.expensetracker.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Expense> getExpenses() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Expense getExpense(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<Expense>  save(@RequestBody @Valid CreateExpenseRequest request) {
        Expense save = service.save(request);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable Long id) {
        service.delete(id);
    }
}