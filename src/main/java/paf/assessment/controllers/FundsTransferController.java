package paf.assessment.controllers;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import paf.assessment.models.Account;
import paf.assessment.repositories.AccountRepository;

@Controller
public class FundsTransferController {

    @Autowired
    private AccountRepository accountRepository;
    
    @PostMapping(path = "/transfer", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String handleTransferFormSubmission(@RequestParam("payer") String payer,
    @RequestParam("payee") String payee,
    @RequestParam("amount") BigDecimal amount,
    @RequestParam("comments") String comments, Model model) {
        
        // String[] payerInfo = payer.split("\\(");
        // String[] payeeInfo = payee.split("\\(");
        // Retrieve payer and payee accounts from the database
        Account payerAccount = accountRepository.findById(payer);
        Account payeeAccount = accountRepository.findById(payee);

        if (payer.isEmpty() || payee.isEmpty()) {
            model.addAttribute("errorMessage", "Payer and payee cannot be empty"); 
            return "index";
        }

        if (payer.equals(payee)) {
            model.addAttribute("errorMessage", "Payer and payee cannot be the same"); 
            return "index";
        }

        if (payer.length() != 10 || payee.length() != 10) {
            model.addAttribute("errorMessage", "Invalid account ID"); 
            return "index";
        }
        //Validate minimum transfer amount 10
        if (amount.compareTo(new BigDecimal(10)) < 0) {
            model.addAttribute("errorMessage", "Minimum transfer amount is 10"); 
            return "index";
        }

        //Validate account balance
        BigDecimal payerBalance = payerAccount.getBalance();
        BigDecimal payeeBalance = payeeAccount.getBalance();

        if (amount.compareTo(BigDecimal.ZERO) <= 0 || payerBalance.compareTo(BigDecimal.ZERO) <= 0 || payeeBalance.compareTo(BigDecimal.ZERO) <= 0) {
            model.addAttribute("errorMessage", "Amount must be greater than zero"); 
            return "index";
        }

        if (payerBalance.compareTo(amount) < 0) {
            model.addAttribute("errorMessage", "Insufficient funds"); 
            return "index";
        }
    
        return "transfer";
    }
    
    
}
