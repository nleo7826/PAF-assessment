package paf.assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import paf.assessment.models.Account;
import paf.assessment.repositories.AccountRepository;

public class IndexController {
    
    @Autowired
    private AccountRepository accountRepository;
  
    @GetMapping("/")
    public String showTransferForm(Model model) {
      List<Account> accounts = accountRepository.findAll(); // Fetch all accounts from the database
      System.out.println(accounts);
      model.addAttribute("accounts", accounts);
      return "index";
    }
  
    @PostMapping("/transfer")
    public String handleTransferFormSubmission(HttpServletRequest request) {
      String payer = request.getParameter("payer");
      String payee = request.getParameter("payee");
      double amount = Double.parseDouble(request.getParameter("quantity"));
      String comments = request.getParameter("comments");
  
      // TODO: Update account balances in the database and handle any errors
  
      return "success"; // Return the name of the Thymeleaf template file to display after the transfer is completed
    }
}
