package angular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import angular.dao.BankDao;
import angular.model.Bank;

@Service("BankService")
public class BankServiceImpl implements BankService {

	@Autowired
	BankDao bankDao;
	
	@Transactional
	public Bank search(int bankId) {
	
		return bankDao.search(bankId);
	}

	public int saveBank(Bank bank) {
		
		return bankDao.saveBank(bank);
	}

	
	
}
