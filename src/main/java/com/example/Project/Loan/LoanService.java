package com.example.Project.Loan;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
	private final LoanRepo loanRepo;
	
	@Autowired
	public LoanService(LoanRepo repo)    //Constructor initializes the LoanRepo object for database access
	{
		this.loanRepo = repo;
	}
	
	public boolean loanSelection()         //loanSelection() method rejects loans by generating random number and checking if it's a prime
	{
		Random rand = new Random();
		int a = rand.nextInt(20);
		//System.out.println("Random Number" + a);
		for(int i=2;i<=(a/2);i++)
		{
			if(a%i==0)
			{
				return false;
			}
		}
		return true;
	}
	
	public List<LoanClass> getLoans()      //getLoans() method uses the predefined findAll() method inherited from JPARepostiory to obtain all records
	{
		return loanRepo.findAll();
	}
	
	public void saveLoan(LoanClass loan)   //saveLoan() method saves an LoanClass object using save() method inherited from the JPARepostiory
	{
		loanRepo.save(loan);
	}

}
