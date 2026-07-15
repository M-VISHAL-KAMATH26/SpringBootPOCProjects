class DivisionHelper{
    public int[] division(int divident,int divisor){
        if(divisor!=0){
            int quo=divident/divisor;
            int rem=divident%divisor;

            return new int[]{quo,rem};
        }else{
            System.out.println("unable to divide by zero");
            return new int[]{0,-1};
        }
    }
}

public class Division {
    public static void main(String[] args) {
        DivisionHelper dh=new DivisionHelper();
       int[] res= dh.division(20, 10);

       System.out.println("the quoteint is "+res[0]+" and the remainder is "+res[1]);

    }
}
