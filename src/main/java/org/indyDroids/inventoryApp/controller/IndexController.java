package org.indyDroids.inventoryApp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.indyDroids.inventoryApp.beans.Product;
import org.indyDroids.inventoryApp.beans.ProductImage;
import org.indyDroids.inventoryApp.repository.ProductImageRepository;
import org.indyDroids.inventoryApp.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class IndexController {
	
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProductImageRepository productImageRepo;

	@GetMapping("")
	public String index(Model model, HttpServletRequest request) {
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@GetMapping("/products")
	public String home(Model model) {
		model.addAttribute("products", productRepo.findAll());
		return "products";
	}
	
	@GetMapping("/product/create")
	public String productCreate(Model model) {
		
		return "product_create";
	}
	
	@PostMapping("/product/create")
	public String productCreateSave(@ModelAttribute @Valid Product product, Model model) {

		productRepo.save(product);
			return "redirect:/product/" + product.getId();
	}

	@GetMapping("/product/{id}")
	public String product(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Product p = productRepo.findOne(id);
		ProductImage i = productImageRepo.findByProductId(id);
		model.addAttribute("productImage", i);
		model.addAttribute("product", p);
		return "product_detail";
	}

	@GetMapping("/product/{id}/edit")
	public String productEdit(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Product p = productRepo.findOne(id);
		model.addAttribute("product", p);
		return "product_edit";
	}
	
	
	
	@PostMapping("/product/{id}/edit")
	public String productEditSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid Product product,
			BindingResult result, Model model, @RequestParam("file") MultipartFile file,
			@RequestParam(name = "removeImage", defaultValue = "false", required = false) boolean removeImage) {

		if (result.hasErrors()) {
			model.addAttribute("product", product);
			return "product_edit";
		} else {

			if (removeImage) {
				//See if the user even has a user image
				ProductImage image = productImageRepo.findByProductId(id);
				
				if(image != null) {
					productImageRepo.delete(image);
					log.info("Image Removed " + id);
				}
				
			} else if (file != null && !file.isEmpty()) {
				try {
					// Load the file into the proper format (Spring does this)

					// Load or create a UserImage
					ProductImage image = productImageRepo.findByProductId(product.getId());

					if (image == null) {

						image = new ProductImage();
						image.setProductId(id);
					}
					image.setContentType(file.getContentType());
					image.setImage(file.getBytes());

					// Store in the database
					productImageRepo.save(image);
					
				} catch (IOException e) {
					log.error("Failed to upload file", e);
				}

			}
			productRepo.save(product);
			return "redirect:/product/" + product.getId();
		}
	}

}