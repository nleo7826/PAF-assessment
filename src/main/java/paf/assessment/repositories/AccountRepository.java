package paf.assessment.repositories;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import paf.assessment.models.Account;
import static paf.assessment.repositories.Queries.*;

@Repository
public class AccountRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Account> findAll() {
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(FIND_ALL_ACCOUNTS);
        List<Account> accounts = new LinkedList<>();
        while (rowSet.next()) {
            String accountId = rowSet.getString("account_id");
            String name = rowSet.getString("name");
            BigDecimal balance = rowSet.getBigDecimal("balance");
            Account account = new Account(accountId, name, balance);
            accounts.add(account);

            System.out.println(account.getAccountId() + " " + account.getName() + " " + account.getBalance());
        }
        return accounts;
    }

    // public List<Account> findAll() {
    //     List<Account> accounts = jdbcTemplate.query(sql, new AccountRowMapper());
    //     System.out.println("Found " + accounts.size() + " accounts");
    //     return accounts;
    // }

    // public class AccountRowMapper implements RowMapper<Account> {

    //     @Override
    //     public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
    //         String accountId = rs.getString("account_id");
    //         String name = rs.getString("name");
    //         BigDecimal balance = rs.getBigDecimal("balance");
    //         return new Account(accountId, name, balance);
    //     }
    
    // }
    
}
