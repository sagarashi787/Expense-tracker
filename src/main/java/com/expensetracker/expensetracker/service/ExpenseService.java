package com.expensetracker.expensetracker.service;

import com.expensetracker.expensetracker.dto.CreateExpenseRequest;
import com.expensetracker.expensetracker.exception.ExpenseNotFoundException;
import com.expensetracker.expensetracker.model.Expense;
import com.expensetracker.expensetracker.repository.ExpenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
public class ExpenseService {
    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public List<Expense> getAll() {
        return repository.findAll();
    }

    public Page<Expense> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Expense getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException(id));
    }

    @Transactional
    public Expense save(CreateExpenseRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Expense cannot be null");
        }

        Expense expense = new Expense();
        expense.setCategory(request.category());
        expense.setAmount(request.amount());
        expense.setDate(LocalDate.now());
        log.info("Saving expense: {}", request);
        return repository.save(expense);
    }

    @Transactional
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException(id));
        repository.deleteById(id);
        log.info("Deleted expense with id: {}", id);
    }
}