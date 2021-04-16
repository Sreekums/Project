package com.example.Project.Loan;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
	private final LoanRepo loanRepo;
	private final LoanAccpetedRepo loanAcceptedRepo;
	private final LoanRejectRepo loanRejectRepo;
	
	@Autowired
	public LoanService(LoanRepo repo,LoanAccpetedRepo loanAcceptedRepo,LoanRejectRepo loanRejectRpo)    //Constructor initializes the LoanRepo object for database access
	{
		this.loanRepo = repo;
		this.loanAcceptedRepo = loanAcceptedRepo;
		this.loanRejectRepo = loanRejectRpo;
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
	
	public String getLoans()      //getLoans() method uses the predefined findAll() method inherited from JPARepostiory to obtain all records
	{
		return ("Requests:\n" + List.of(loanRepo.findAll()) + "\nApproved:\n" + List.of(loanAcceptedRepo.findAll()) + "\nRejected\n" + List.of(loanRejectRepo.findAll()));
	}
	
	public void saveLoan(LoanClass loan)   //saveLoan() method saves an LoanClass object using save() method inherited from the JPARepostiory
	{
		loanRepo.save(loan);
	}
	
	public void processLoans()               //processLoans() will process the loans and put the rejected loans in a separate table from the accepted ones
	{
		List<LoanClass> records = loanRepo.findAll();
	    while(!records.isEmpty())
	    {
	    	if(loanSelection())
	    	{
	    		loanAcceptedRepo.save(new LoanAcceptedClass(records.get(0)));
	    		records.remove(0);
	    	}
	    	else
	    	{
	    		loanRejectRepo.save(new LoanRejectedClass(records.get(0)));
	    		records.remove(0);
	    	}
	    }
	}

}
