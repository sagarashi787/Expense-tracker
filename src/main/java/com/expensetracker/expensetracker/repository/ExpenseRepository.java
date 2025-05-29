package com.expensetracker.expensetracker.repository;

import com.expensetracker.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Опционально, но рекомендуется
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Пример кастомного метода
    List<Expense> findByCategory(String category);
}