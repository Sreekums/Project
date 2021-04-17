package com.example.Project.Loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRejectRepo extends JpaRepository<LoanRejectedClass,Long>{       //LoanRepo interface extends JPARepostiory and it's methods to handle and streamline access to database

	   
	

}
