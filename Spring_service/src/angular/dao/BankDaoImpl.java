package angular.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import angular.model.Bank;

@Repository("BankDao")
public class BankDaoImpl implements BankDao {

	@Autowired
	SessionFactory sf;
	
	public Bank search(int bankId) {
		
		Session s=sf.getCurrentSession();
		Bank bank=s.get(Bank.class, bankId);
		
		return bank;
	}

	public int saveBank(Bank bank) {
		Session s=sf.getCurrentSession();
		s.save(bank);
		return bank.getBankId();
	}

}
