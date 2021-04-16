package com.example.Project.Loan;

import java.util.Date;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sun.el.parser.ParseException;

@RestController 
public class LoanFileController {               //Loan File Controller handles the REST APIs to the application 
	
	private final LoanService ls;
	
	public LoanFileController(LoanService ls) {
		this.ls = ls;
	}

	@RequestMapping(value="/loadFile", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException,ParseException
	{
		File rec=new File("H:\\"+file.getOriginalFilename());
		BufferedReader br=new BufferedReader(new FileReader(rec));            //fileUpload() method handles the POST request
		String line="";                                                       // from the client and parses the file 
		while((line = br.readLine())!=null)                                   //to extract the data
		{
			String[] parse = line.split(",");
			LoanClass r= new LoanClass(Long.parseLong(parse[0]),
					parse[1],
					Long.parseLong(parse[2]),
					Integer.parseInt(parse[3]),
					Boolean.parseBoolean(parse[4]),
					Long.parseLong(parse[5]),
					Long.parseLong(parse[6]),
					Boolean.parseBoolean(parse[7]),
					parse[8],
					Integer.parseInt(parse[9]),
					Boolean.parseBoolean(parse[10]),
					Integer.parseInt(parse[11]),
					Boolean.parseBoolean(parse[12]),
					Boolean.parseBoolean(parse[13]),
					parse[14],
					parse[15]);
			//System.out.println(r.getId()+" "+r.getName()+" "+r.getCapital());
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
