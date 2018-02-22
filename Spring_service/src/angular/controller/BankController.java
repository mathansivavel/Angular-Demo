package angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.net.httpserver.Authenticator.Success;

import angular.model.Bank;
import angular.service.BankService;

@CrossOrigin
@RestController
public class BankController {

	@Autowired
	BankService bankService;

	@PostMapping("/addBank")
	ResponseEntity<?> saveBank(@RequestBody Bank bank) {

		int x=bankService.saveBank(bank);
		
		System.out.println("SAVED Successfully"+x);
		
		return new ResponseEntity<Success>(HttpStatus.OK);
//		return ResponseEntity.ok().body("VALUE SAVED SUCCESSFULLY TO DB");
	}

	@GetMapping("/findBank/{id}")
	ResponseEntity<?> findBank(@PathVariable("id") int id) {
		Bank b = bankService.search(id);
		if (b != null) {
			System.out.println("VALUE FOUND ");
			return new ResponseEntity<Success>(HttpStatus.OK);
		} else {

			System.out.println("NOT FOUND ");
			return new ResponseEntity<Error>(HttpStatus.CONFLICT);
		}
		// return ResponseEntity.ok().body(b);
	}

}