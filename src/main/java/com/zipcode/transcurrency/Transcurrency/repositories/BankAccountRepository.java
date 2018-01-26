package com.zipcode.transcurrency.Transcurrency.repositories;

import com.zipcode.transcurrency.Transcurrency.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface
BankAccountRepository extends JpaRepository<BankAccount, Long> {


}
