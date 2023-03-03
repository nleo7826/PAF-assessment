package paf.assessment.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Account> findByAccountId(String accountId) {

		SqlRowSet rs = jdbcTemplate.queryForRowSet(FIND_ACCOUNT_BY_ID, accountId);
		if (!rs.next()) {
			return Optional.empty();
        }
        else {
            Account account = new Account(rs.getString("accountId"),rs.getString("account_name"), rs.getBigDecimal("balance"));
            return Optional.of(account);
        }
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

}
