
//package edu.fau.COT4930;

public class DBTester
{

	public static void main(String args[ ])
	{
		System.out.println("Homework 4 test case results by Daniel Leach");
		
		
		ManageDB m = new ManageDB(5, "EmployeeData.txt");
		boolean result;

		int testCount = 1;  // used to track test numbers

		// test case 1
		result = isSame(23, m.getAge(0));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
		// test case 2
		if (m.getName(0).equals("Jane"))
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
		// test case 3
		result = isSame(1000000.98, m.getSalary(0));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
		// test case 4
		result = isSame(-1, m.getAge(1));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
		// test case 5
		if (m.getName(1).equals("Jerry"))
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
		// test case 6
		result = isSame(100000, m.getSalary(1));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
		// test case 7
		result = isSame(29, m.getAge(2));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
		// test case 8
		if (m.getName(2).equals("Joann"))
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
		// test case 9
		result = isSame(50000.8, m.getSalary(2));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
		// test case 10
		result = isSame(-1, m.getAge(3));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
		// test case 11
		if (m.getName(3).equals(""))
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
		// test case 12
		result = isSame(-1, m.getSalary(3));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
		// test case 13
		result = isSame(25, m.getAge(4));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
		// test case 14
		if (m.getName(4).equals("John"))
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
		// test case 15
		result = isSame(1177.22, m.getSalary(4));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

	}
	private static boolean isSame(double x, double y)
	{
		double error = .00001;
		boolean rv = false;
		if (((x + error) >= y) && ((x - error) <= y))
		{
			rv = true;
		}
		return rv;
	}
}

