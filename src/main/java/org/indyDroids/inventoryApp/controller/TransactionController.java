package org.indyDroids.inventoryApp.controller;

import javax.validation.Valid;


import org.indyDroids.inventoryApp.beans.Transaction;

import org.indyDroids.inventoryApp.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepo;

	@GetMapping("/transactions")
	public String home(Model model) {
		model.addAttribute("transactions", transactionRepo.findAll());
		return "transactions/transactions";
	}

//	@GetMapping("/transaction/{id}")
//	public String product(Model model, @PathVariable(name = "id") long id) {
//		model.addAttribute("id", id);
//		Transaction t = transactionRepo.findOne(id);
//		model.addAttribute("transaction", t);
//		return "transactions/transaction_detail";
//	}
	
	@GetMapping("/transaction/{id}/delete")
	public String transactionDelete(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Transaction t = transactionRepo.findOne(id);
		model.addAttribute("transaction", t);
		return "transactions/transaction_delete";
	}

	@PostMapping("/transaction/{id}/delete")
	public String transactionDeleteSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid Transaction transaction,
			BindingResult result, Model model) {

//		if (result.hasErrors()) {
//			model.addAttribute("transaction", transaction);
//			return "transaction/transaction_delete";
//		} else {
			transactionRepo.delete(transaction);
			return "redirect:/transactions";
//		}

	}

//	@GetMapping("/transaction/{id}/edit")
//	public String transactionEdit(Model model, @PathVariable(name = "id") long id) {
//		model.addAttribute("id", id);
//		Transaction t = transactionRepo.findOne(id);
//		model.addAttribute("transaction", t);
//		model.addAttribute("user", userRepo.findAll());
//		model.addAttribute("products", productRepo.findAll());
//		return "transactions/transaction_edit";
//	}

}
