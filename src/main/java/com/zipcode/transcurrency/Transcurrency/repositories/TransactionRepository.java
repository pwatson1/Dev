package com.zipcode.transcurrency.Transcurrency.repositories;

import com.zipcode.transcurrency.Transcurrency.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
