import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            // Input: Take marks obtained in each subject
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();

            int[] subjectMarks = new int[numSubjects];

            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
                subjectMarks[i] = scanner.nextInt();
            }

            // Calculate Total Marks
            int totalMarks = calculateTotalMarks(subjectMarks);

            // Calculate Average Percentage
            double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

            // Grade Calculation
            char grade = calculateGrade(averagePercentage);

            // Display Results
            displayResults(totalMarks, averagePercentage, grade);
        }
    }

    // Calculate Total Marks
    private static int calculateTotalMarks(int[] subjectMarks) {
        int totalMarks = 0;
        for (int marks : subjectMarks) {
            totalMarks += marks;
        }
        return totalMarks;
    }

    // Calculate Average Percentage
    private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    // Grade Calculation
    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else if (averagePercentage >= 50) {
            return 'E';
        } else {
            return 'F';
        }
    }

    // Display Results
    private static void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
    }
}