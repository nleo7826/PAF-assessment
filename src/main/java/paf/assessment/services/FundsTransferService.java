package paf.assessment.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import paf.assessment.models.Account;
import paf.assessment.models.Transaction;
import paf.assessment.repositories.AccountRepository;

public class FundsTransferService {
    
    @Autowired
	private AccountRepository accRepo;

	@Transactional(rollbackFor={ TransferException.class }) 
	public void createOrder(Transaction transaction, Account account) throws TransferException {

		String transactionId = UUID.randomUUID().toString().substring(0, 8);

		// try {
		// 	accRepo.insertOrder(transaction);
		// } catch (Exception ex) {
		// 	throw new TransferException(ex.getMessage(), ex);
		// }
	}

}
