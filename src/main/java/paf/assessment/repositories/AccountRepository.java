package paf.assessment.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import paf.assessment.models.Account;
import static paf.assessment.repositories.Queries.*;

@Repository
public class AccountRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        accounts = jdbcTemplate.query(FIND_ALL_ACCOUNTS, BeanPropertyRowMapper.newInstance(Account.class));
        return accounts;
    }

    public Account findById(String accountId) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(FIND_ACCOUNT_BY_ID, accountId);
        if (!rs.next()) {
            return null;
        }
        else {
            return new Account(rs.getString("account_id"),rs.getString("name"), rs.getBigDecimal("balance"));
        }
    }

    public void updateBalance(String accountId, BigDecimal newBalance) {
        jdbcTemplate.update(UPDATE_BALANCE, newBalance, accountId);
    }
}