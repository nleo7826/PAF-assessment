package paf.assessment.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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

//     public Boolean save(Account account) {
//         Integer result = jdbcTemplate.update(insertSQL, account.getFullName(), account.getEmail(), account.getPhone(),
//                         account.getConfirmationDate(), account.getComments());

//         return result > 0 ? true : false;
// }

// public Boolean update(RSVP rsvp) {
//         Integer result = jdbcTemplate.update(updateSQL, rsvp.getFullName(), rsvp.getEmail(), rsvp.getPhone(),
//                         rsvp.getConfirmationDate(), rsvp.getComments(), rsvp.getId());
//         return result > 0 ? true : false;
// }

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
