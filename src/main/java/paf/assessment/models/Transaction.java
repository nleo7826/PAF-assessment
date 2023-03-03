package paf.assessment.models;

public class Transaction {
    
    private final String transactionId;
    private final String fromAccountId;
    private final String toAccountId;
    private final String amount;

    public Transaction(String transactionId, String fromAccountId, String toAccountId, String amount, String transactionDate, String transactionType, String transactionStatus) {
        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    
    
}
