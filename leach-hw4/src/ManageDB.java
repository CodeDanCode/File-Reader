// By Daniel Leach

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;

public class ManageDB{
	
	
	private EmployeeDB[] employee;
	
	ManageDB(int number, String fileName){
		
		String readFileString = getClass().getResource(fileName).getFile(); // used to find text file in 
		//the working directory using eclipse
		
		long fileLength;
		String fileString = "No information was read";
		BufferedReader in = null;
		
		try
		{
			File f = new File(readFileString);
			//File f = new File(fileName);
			if (f.exists() == true)
			{
				employee = new EmployeeDB[number]; // creates a reference of an array of Employee objects
				for(int ct = 0;ct<number;ct++) {
					employee[ct] = new EmployeeDB(); // creates new employee object in the array
				}
				
				fileLength = f.length(); // gets file length
				in = new BufferedReader(new FileReader(readFileString)); 
				char[] ch = new char[(int)fileLength]; // creates a new char array of file length
				in.read(ch,0,(int)fileLength);  // reads each char in file starting at 0 till EOF				
				fileString = String.valueOf(ch,0,(int)fileLength); // converts char to String
				fileString = fileString.replaceAll("\\s","");// removes white spaces
				String[] str = fileString.split("\\^"); // splits string based on field indicator
				for(String i : str) {
					if(i.length() == 0) { // checks if string array is empty if so move to next string element
						continue;
						}
					String id = i.substring(0,4); // sets id to the first for chars in string element
					int eq = i.indexOf('='); // finds the index of the equal char
					String field = i.substring(4,eq); //sets the field based on the end of id & beginning of eq
					String data = i.substring(eq+1,i.length()); //sets the data to the rest of the string
					int empID;
					double value = 0;
					try {
						empID = Integer.parseInt(id); // string to integer conversion
						if(field.equals("age")||field.equals("salary")) { // check if field is equal to string
			                value = Double.parseDouble(data); // string to double conversion 
						}
					}catch(NumberFormatException e) {
						continue; // if exception is thrown continue on to next string in string array
					}
					if(empID < 0||empID > (employee.length-1)){ // if employee id is non existent or 
			        	continue;  // more there are to many id than employee object array can store continue
			        	}
					// last three if statements sets data into employee objects based on id
			        if(field.equals("age")){
			        	employee[empID].setAge((int)value);
			        	}
				    if(field.equals("salary")) {
				    	employee[empID].setSalary(value);
				    	}
				    if(field.equals("name")) {
				    	employee[empID].setName(data);
				       }
				}
						
			}
			else
			{
				System.out.println("File does not exist");
			}
		}
		catch (SecurityException e)
		{
			System.out.println("SecurityException when reading the file " + e);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("FileNotFoundException when reading the file " + e);
		}
		catch (IOException e)
		{
			System.out.println("IOException when reading the file " + e);
		}
		finally
		{
			closeReadFile(in);
		}
	}
	
	public static void closeReadFile(BufferedReader in)
	{
		try
		{
			if (in != null)
			{
				in.close();
			}
		}
		catch (IOException e)
		{
			System.out.println("IOException when closing the read file " + e);
		}
	}
	


	
	public String getName(int i) {
		return employee[i].getName();
	}
	public int getAge(int i) {
		return employee[i].getAge();
	}
	public double getSalary(int i) {
		return employee[i].getSalary();
	}
	
}
