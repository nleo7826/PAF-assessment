package paf.assessment.repositories;

public class Queries {
    
    public static final String FIND_ALL_ACCOUNTS = "SELECT * FROM accounts";
    public static final String FIND_ACCOUNT_BY_ID = "SELECT * FROM accounts WHERE account_id = ?";
    public static final String UPDATE_BALANCE = "UPDATE accounts SET balance = ? WHERE account_id = ?";
}
