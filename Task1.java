import java.util.Scanner;
// First added user number is 0 and next added user number will be incremnted

//Problem Statement

//Student Grade Tracker
// Develop a program that allows a teacher to enter
// students' grades and compute their average,
// highest, and lowest scores. You can use arrays or
// ArrayLists to store the student data.

class Task1{
    public static void main(String args[]){
        //    System.out.println("Hello World");
        int NumberOfStudents;
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter Number Of Students ");

        NumberOfStudents=scanner.nextInt();

        Student students[]=new Student[NumberOfStudents];

        for(int i=0;i<NumberOfStudents;i++){
            students[i]=new Student();

            students[i].AssignMarks(students[i]);
            
        }
        boolean option=true;

        do{
            int operation;
            int StudentNumber;
            System.out.println("Select operation 1) Student Marks Average 2) Student Lowest Marks 3) Student Highest Marks 4) Exit");
            operation=scanner.nextInt();
           
            if(operation==1){
                System.out.println("Enter Student Number ");
                StudentNumber=scanner.nextInt();

                System.out.println(" Average Marks of Student  "+StudentNumber+" is "+students[StudentNumber].DisplayAverage(students[StudentNumber]));
                option=true;
            }
            else if(operation==2){
                System.out.println("Enter Student Number ");
                StudentNumber=scanner.nextInt();

                System.out.println(" Lowest Marks of Student  "+StudentNumber+" is "+students[StudentNumber].GetLowMarks(students[StudentNumber]));
                option=true;
            }
            else if(operation==3){
                System.out.println("Enter Student Number ");
                StudentNumber=scanner.nextInt();

                System.out.println(" Highest Marks of Student  "+StudentNumber+" is "+students[StudentNumber].GetHighMarks(students[StudentNumber]));
                option=true;

            }
            else if(operation==4){
                option=false;
            }
            else{
                System.out.println("Please provide a valid number  ");
                option=true;
            }

        }while(option);
        // System.out.println("Number Of Students are "+" "+NumberOfStudents);


    }
}

class Student{
     
      float[] marks=new float[6];
      String name=new String();

      public static float DisplayAverage(Student student){
             float Avg=0;
             for(int i=0;i<6;i++){
                Avg+=student.marks[i];
             }
             return Avg/6;
      }

      public static void AssignMarks(Student student){
             Scanner scanner=new Scanner(System.in);
             System.out.println("Enter Name ");

             student.name=scanner.nextLine();
             
             for(int i=0;i<6;i++){
                System.out.println("Enter Subject "+" "+(i+1)+" "+" Marks ");
                student.marks[i]=scanner.nextFloat();
             }

      }

      public static float GetLowMarks(Student student){
             float min_sub=student.marks[0];
             for(int i=0;i<6;i++){
                if(student.marks[i]<min_sub){
                   min_sub=student.marks[i];
                }
             }

             return min_sub;

      }

      public static float GetHighMarks(Student student){
            float max_sub=student.marks[0];
            for(int i=0;i<6;i++){
            if(student.marks[i]>max_sub){
                max_sub=student.marks[i];
            }
            }

            return max_sub;
      }

}