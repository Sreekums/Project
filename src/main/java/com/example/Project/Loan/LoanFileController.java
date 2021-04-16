package com.example.Project.Loan;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController 
public class LoanFileController {               //Loan File Controller handles the REST APIs to the application 
	
	private final LoanService ls;
	
	public LoanFileController(LoanService ls) {
		this.ls = ls;
	}

	@RequestMapping(value="/loadFile", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException
	{
		File rec=new File("H:\\"+file.getOriginalFilename());
		BufferedReader br=new BufferedReader(new FileReader(rec));            //fileUpload() method handles the POST request
		String line="";                                                       // from the client and parses the file 
		while((line = br.readLine())!=null)                                   //to extract the data
		{
			String[] parse = line.split(",");
			LoanClass r= new LoanClass(Long.parseLong(parse[0]),parse[1],Long.parseLong(parse[2]));
			System.out.println(r.getId()+" "+r.getName()+" "+r.getCapital());
			if(ls.loanSelection())                                               //loanSelection() method is responsible for implement business logic from the LoanService object to reject loan randomly 
			{
				ls.saveLoan(r);                                                  //saveLoan() method is responsible for saving the accepted loans to the database using LoanService
			}
		}
		br.close();
		
		return "File is uploaded";                                               //Finally returns a message that file was uploaded on complete success
	}
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public List<LoanClass> showLoans()                                           //showLoans() method is responsible to handle GET requests for the application 
	{
		return ls.getLoans();                                                    //getLoans() method is responsible to get the data from the database using LoanService 
	}
}
