//Developed by Aemun Ahmar 1047508
//CSCI 125 M04 Fall 2016
//Professor Wenjia Li
//Homework 2: GPA Calculator 2.0
//Date Created: November 15, 2016

import javax.swing.JOptionPane;

public class SemesterGPACalculator	
{
	public static void main(String[] args)
	{
		//Declaring Variables
		int totalCredits = 0;
		int totalQualityPoints = 0;
		String courseName;
		
		//Explains the program
		PrintExplanation();
		
		//Informing user of sentinel value
		JOptionPane.showMessageDialog(null, "If you finish entering all your courses"
				+ " write 'end' to calculate GPA.");
		
		//Entering the semester
		String inputSemester = JOptionPane.showInputDialog("Enter the semester.");
		System.out.println("GPA information for: " + inputSemester + " semester");
		System.out.print("\n");
		
		//Priming read for entering the name of course
		courseName = JOptionPane.showInputDialog("Enter the name of the course.");
		System.out.println("Name of course: " + courseName);
		
		//Entering grades and calculating GPA
		do
		{
			//Entering the number of credits for the course and calculating total credits
			String inputCredit = "Please enter the number of credits for " + courseName;
			int numCredits = GetValidNumberInput(inputCredit, 1, 4);
			
			System.out.println("Number of credits for the course: " + numCredits);
			
			totalCredits = totalCredits + numCredits;
			
			//Entering the letter grade for the course and converting it to number points
			String letterGrade = "Enter your letter grade for this course";
			int numPoints = ConvertGradeToPoints(letterGrade);
			
			System.out.println("Number of grade points earned for the course: " + numPoints);
			
			//Calculating quality points and total quality points
			int qualityPoints = numCredits * numPoints;
			
			System.out.println("Number of quality points earned for the course: " + qualityPoints);
			System.out.print("\n");
			
			totalQualityPoints = totalQualityPoints + qualityPoints;	
			
			//Entering the name of course
			courseName = JOptionPane.showInputDialog("Enter the name of the course.");
			if(!courseName.equals("end"))
			{
				System.out.println("Name of course: " + courseName);
			}
		}while(!courseName.equals("end"));
		
		
		//Generating the Final GPA Report
		GenerateGPAReport(totalCredits, totalQualityPoints);
	}
		
	public static void PrintExplanation()
	{
		/*****When called by the main method, this method will show a pop up window that explains
		* the overall function of the program*****/
		
		JOptionPane.showMessageDialog(null, "This program will allow you to calculate your GPA for"
				+ " one semester. \nYou will be allowed to enter as many courses as you like."
				+ "\nThe program will then calculate and display the GPA earned for that semester.");
	}
	
	public static int GetValidNumberInput(String promptStr, int lowerNum, int upperNum)
	{
		/*****When called by the main method, this function will take the number entered by the user
		* and check to see if it falls in between the given numbers.*****/
		
		int validNumber;
		do
		{
			//Get user input for number and convert from string to integer
			String userInput = JOptionPane.showInputDialog(promptStr);
			validNumber = Integer.parseInt(userInput);
			
			//If inputed number does not fall in between the given numbers, show error message
			if(lowerNum > validNumber || validNumber > upperNum)
			{
				JOptionPane.showMessageDialog(null, "You entered an invalid number. Enter again");
			}
		}while(lowerNum > validNumber || validNumber > upperNum);
		return validNumber;		
	}
	
	public static void GenerateGPAReport(int totalCredits, int totalQualityPoints)
	{
		/*****When called by the main method, this method will call the CalculateGPA method which 
		* returns the total calculated GPA. Then it will print out total credits, total quality 
		* points, and semester GPA in the DOS Console.*****/
		
		double semesterGPA = CalculateGPA(totalCredits, totalQualityPoints);
		System.out.println("Total number of credits take: " + totalCredits + " Credits"
				+ "\nTotal quality points earned: " + totalQualityPoints + " Quality Points"
				+ "\nOverall GPA for the semester: " + semesterGPA + " GPA");	
	}
	
	public static double CalculateGPA(int totalCredits, int totalQualityPoints)
	{
		/****This method will calculate the total GPA by dividing the total quality points by
		 * the total credits. It will then return the rounded calculation*****/
		
		double totalGPA = (double) totalQualityPoints / (double) totalCredits; 
		return (Math.round(totalGPA * 10.0)) / 10.0;
	}
	
	public static int ConvertGradeToPoints(String grade)
	{
		/****This method will take the user inputed letter grade and return the corresponding
		 * number points. It will determine which number to return through a series of if-else if 
		 * statements *****/
		
		String getGrade = JOptionPane.showInputDialog(grade);
		if(getGrade.equals("A") || getGrade.equals("a"))
		{
			return 4;
		} else if(getGrade.equals("B") || getGrade.equals("b"))
		{
			return 3;
		}else if(getGrade.equals("C") || getGrade.equals("c"))
		{
			return 2;
		}else if(getGrade.equals("D") || getGrade.equals("d"))
		{
			return 1;
		}else
		{
			return 0;
		}
	}
}

