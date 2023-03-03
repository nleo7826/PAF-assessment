package paf.assessment.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import paf.assessment.models.Account;
import static paf.assessment.repositories.Queries.*;

public class AccountRepository {
    
    private JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Account> findAll() {
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(FIND_ALL_ACCOUNTS);
        List<Account> accounts = new LinkedList<>();
        while (rowSet.next()) {
            String accountId = rowSet.getString("account_id");
            String name = rowSet.getString("name");
            Float balance = rowSet.getFloat("balance");
            accounts.add(new Account(accountId, name, balance));
        }
        return accounts;
    }
    
}
