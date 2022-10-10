public class Main {
    public static void main(String[] args) {
        //Testing by creating accounts with information
        account test = new account(0, 276529, false, 0, 28000);
        account test2 = new account(1,212576, true, 2, 15728);

        //Testing getting the information for each account
        test.getInfo();
        test2.getInfo();

        //Calcualting taxes for each acccount
        System.out.println(test2.taxCalculator());


    }




}