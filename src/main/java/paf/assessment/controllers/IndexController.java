package paf.assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import paf.assessment.models.Account;
import paf.assessment.repositories.AccountRepository;

@Controller
public class IndexController {
    
    @Autowired
    private AccountRepository accountRepository;
  
    @GetMapping(path={"/", ""}, produces=MediaType.APPLICATION_JSON_VALUE)
    public String showTransferForm(Model model) {
      List<Account> accounts = accountRepository.findAll(); // Fetch all accounts from the database
      for (Account account : accounts) {
        System.out.println(account.getAccountId() + " " + account.getName() + " " + account.getBalance());
      }
      model.addAttribute("accounts", accounts);
      return "index";
    }
  
    @PostMapping(path={"/transfer"}, produces=MediaType.APPLICATION_JSON_VALUE)
    public String handleTransferFormSubmission(HttpServletRequest request) {
      String payer = request.getParameter("payer");
      String payee = request.getParameter("payee");
      double amount = Double.parseDouble(request.getParameter("quantity"));
      String comments = request.getParameter("comments");
  
      // TODO: Update account balances in the database and handle any errors
  
      return "success"; // Return the name of the Thymeleaf template file to display after the transfer is completed
    }
}
