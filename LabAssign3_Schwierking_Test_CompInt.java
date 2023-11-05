/*
 * This program will take user input, test the compound interest
 * calculator, and display a report showing method information calculated from
 * the compound interest calculator
 */

/**
 * @author Joseph Schwierking
 * Lab Assignment 3
 */

import java.util.*;

public class LabAssign3_Schwierking_Test_CompInt 
{

    
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        //declair varables
         
        double p;
        double r;
        int t;
        final int N = 12;
        String bar = "|-----------------------------------------------------------|-----------";
        String bar2 = "|----------------------------------------------------------------------|";

        //user input to initialize varables
        System.out.print("Provide total loan amount => ");
        p = input.nextDouble();
        System.out.print("Provide interest rate in decimal form => ");
        r = input.nextDouble();
        System.out.print("Provide total length of loan in years => ");
        t = input.nextInt();
        
               
        //Create oject to test method LabAssign3_Schwierking_CompInt         
        LabAssign3_Schwierking_CompInt test = new LabAssign3_Schwierking_CompInt(p, r, t);
        
        System.out.println("\n\n");
        System.out.println(bar);
        System.out.println("|              Loan Calculations Report                     |");  
        System.out.println(bar);
        System.out.println("|Your principal loan amount is                              | $" +  
                test.getP());        
        System.out.println(bar);
        System.out.println("|The interest rate of your loan is                          | " +  
                test.getR()*100 + "%");
        System.out.println(bar);
        System.out.println("|The length of your loan is                                 | " +  
                test.getT() + " years");
        System.out.println(bar);
        System.out.println("|Your minimum montly paymants will be                       | $" +  
                test.getMonthlyPayment());
        System.out.println(bar);
        System.out.println("|Over the life of the loan, you will have paid in interest  | $"
                + test.getInterestPaid());
        System.out.println(bar);
        System.out.println("|Total amount paid over the life of the loan                | $" + 
                test.getOverallCost());
        System.out.println(bar);
        
        System.out.println("|                            Payment Schedule                           ");
        System.out.println(bar2);
        System.out.println("|           Principal             Interest             Balance          ");
        System.out.println(bar2);
         
        test.getPaymentReport();
        
        test.toString();
        
        
                  
    }
    
}
