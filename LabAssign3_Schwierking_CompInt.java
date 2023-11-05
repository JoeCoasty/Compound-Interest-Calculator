/*
 * This program will take the values given by Test_CompInt and calculate
 * what monthly loan payments will be, the overall cost of the loan, and the
 * amount of interest that will be paid for the life of the loan.
 */

/**
 * @author Joseph Schwierking
 * Lab Assignment 3
 */

public class LabAssign3_Schwierking_CompInt 
{
    //declair varables
    private double p;
    private double r;
    private int t;
    private final int N = 12;
   
    
        
    /* This defalt constructor will not work for my program because I force the 
     * the user to provide values for each varable but if someone used
     * this method for something else, it could work */
    public LabAssign3_Schwierking_CompInt()
    {
        p = 400000; //this is the average home price in USA (https://dqydj.com/historical-home-prices/)
        r = .079; //average home loan interest rate (https://www.bankrate.com/mortgages/mortgage-rates/#mortgage-industry-insights)
        t = 30; 
        
    }
    
    public LabAssign3_Schwierking_CompInt(double principal, double rate, int term)
    {
        p = principal; 
        r = rate;
        t = term;
        
    }

     
    public void setP(double principal)
    {
       p = principal; 
    }
    
    public double getP()
    {
       return p;
    }
    
    public void setR(double rate)
    {
        r = rate;
    }
    
    public double getR()
    {
        return r;
    }
    
    public void setT(int term)
    {
        t = term;
    }
    
    public int getT()
    {
        return t;
    }
        
    public double getMonthlyPayment()
    {
        /* The formula for finding compound interest monthly paymens is
        a = (p * (r/N) * (1 + r/N)^N(t))) / ((1 + r/N)^N(t) -1) 
        Where:
        a = monthly amount
        p = initial pricipal balance
        r = interest rate
        N = number of times interest applied per time peroid 
         (12/compounded monthly)
        t = number of years (term)
        */
        double a = (p * (r/N) * (Math.pow((1 + r/N), (N*t)))) 
                / (Math.pow((1 + r/N),(N*t)) -1);
        a = Math.floor(a * 100)/100; // this is some trick I found on line to truncate a double to 2 decimal places.  I dont know how it works
        return a;
    }
    
    public double getOverallCost()
    {
        double overallCost = getMonthlyPayment() * getT() * N;
        overallCost = Math.floor(overallCost * 100)/100;
        return overallCost;
    }
    
    public double getInterestPaid()
    {
        /*To find the amount the bank is going to charge you in interest each
         * month, use the following formula:
         * loan amount * (rate / 12) 
        */
        double InterestPaid = getOverallCost() - getP(); 
        InterestPaid = Math.floor(InterestPaid * 100)/100;
        return InterestPaid;
    }
 
    //double[] intPayment = new double[t*N];
    double[] ip;
    public double[] intPayment() {
        return new double[t*N];
    }
    //double[] princePayment = new double[t*N]; 
    double[] pp;
    public double[] princePayment() {
        return new double[t*N];
    }
    
    //double[] balance = new double[t*N];
    double[] b;
    public double[] balance() {
        return new double[t*N];
    }

       
     public double[] getPaymentReport()
     {
         double loanAmount = getP();
         ip = intPayment();
         pp = princePayment();
         b = balance();
         
         System.out.println(ip.length + " payments to pay off loan");
         for (int i=0; i<ip.length; i++)
         {
             ip[i] = loanAmount * (getR() / N);
             ip[i]= Math.floor(ip[i] * 100)/100;
             pp[i] = getMonthlyPayment() - ip[i];
             pp[i]= Math.floor(pp[i] * 100)/100;
             b[i] = loanAmount - pp[i];
             b[i]= Math.floor(b[i] * 100)/100;
             loanAmount = b[i];
              
         }
         return pp;
     }
     
    
    @Override
     public String toString()
     {
         for (int i=0; i<ip.length; i++)
         {
             System.out.println((i+1) + "             " + pp[i] + 
                     "               " + ip[i] + "              "
                     + b[i]);
         }
         
         return "\n end of report";
                              
     }
    
}