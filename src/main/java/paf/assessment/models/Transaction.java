package paf.assessment.models;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import paf.assessment.repositories.AccountRepository;

public class Transaction {
    
    @Autowired
    private AccountRepository accountRepository;

    private final String transactionId;
    private final String fromAccountId;
    private final String toAccountId;
    private final BigDecimal amount;

    public Transaction(String transactionId, String fromAccountId, String toAccountId, BigDecimal amount) {
        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    @Transactional
    public void transferFunds(Account payer, Account payee, BigDecimal amount, String comments) {
        
        BigDecimal newPayerBalance = payer.getBalance().subtract(amount);
        BigDecimal newPayeeBalance = payee.getBalance().add(amount);
        payer.setBalance(newPayerBalance);
        payee.setBalance(newPayeeBalance);

        // accountRepository.updateBalance(payer, newPayerBalance);
        // accountRepository.updateBalance(payee, newPayeeBalance);

    }
}
