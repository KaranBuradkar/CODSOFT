import java.util.Scanner;

class StudentResultCalculator
{
    Scanner s1;
    int No_Of_Subjects;
    Double StudentTotalMarks = 0d,AverageMarks;
    char grade;

    StudentResultCalculator()
    {
        System.out.println("\n");
        s1 = new Scanner(System.in);
        System.out.print("Enter Number of Subject : ");
        No_Of_Subjects = s1.nextInt();
    }
    
    void TotalMarks()
    {
        for(int i=0;i < No_Of_Subjects;i++)
        {
            System.out.print("\nEnter Marks of Subject "+(i+1)+" (Out of 100) : ");
            StudentTotalMarks = StudentTotalMarks + s1.nextInt();
        }
        StudentTotalMarks = (StudentTotalMarks*100)/100;
    }
    void AveragePercentage()
    {
        AverageMarks = StudentTotalMarks/No_Of_Subjects;
    }

    void GradeCalculate()
    {
        grade = 'c';
        if(AverageMarks >= 90) grade ='A';
        else if(AverageMarks >= 80) grade ='B';
        else if(AverageMarks >= 70) grade ='C';
        else if(AverageMarks >= 60) grade ='D';
        else if(AverageMarks >= 50) grade ='E';
        else grade ='F';
    }

    void Display()
    {
        System.out.println("\nResult of The Student : ");
        System.out.println("Total Marks of The Student is "+StudentTotalMarks);
        System.out.println("Average Percentage of The Student is "+AverageMarks+"%");
        System.out.println("Grade Of The Student is "+grade);
        System.out.println("\n\n");
    }

}

public class CodSoft_Task2
{
    public static void main(String[] args) 
    {
        StudentResultCalculator Student = new StudentResultCalculator();
        Student.TotalMarks();
        Student.AveragePercentage();
        Student.GradeCalculate();
        Student.Display();
    }
}