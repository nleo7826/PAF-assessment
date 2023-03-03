package paf.assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import paf.assessment.models.Account;
import paf.assessment.repositories.AccountRepository;

@Controller
public class IndexController {
    
    @Autowired
    private AccountRepository accountRepository;
  
    @GetMapping(path={"/", ""})
    public String showTransferForm(Model model) {
      // Fetch all accounts from the database
      List<Account> accounts = accountRepository.findAll(); 
      model.addAttribute("accounts", accounts);
      return "index";
    }
  
      // TODO: Update account balances in the database and handle any error
}
