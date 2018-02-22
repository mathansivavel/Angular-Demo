package angular.service;

import angular.model.Bank;

public interface BankService {

	Bank search(int bankId);
	int saveBank(Bank bank);
	
}