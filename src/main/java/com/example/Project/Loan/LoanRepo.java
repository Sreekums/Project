package com.example.Project.Loan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepo extends JpaRepository<LoanClass,Long>{   //LoanRepo interface extends JPARepostiory and it's methods to handle and streamline access to database
	
	public List<LoanClass> findByProcess(boolean process);

}
