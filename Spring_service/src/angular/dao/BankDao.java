package angular.dao;

import angular.model.Bank;

public interface BankDao {

	Bank search(int bankId);
	int saveBank(Bank bank);
}