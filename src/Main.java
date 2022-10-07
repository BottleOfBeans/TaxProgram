public class Main {
    public static void main(String[] args) {
        //Testing by creating accounts with information
        account test = new account(0, 25900, false, 0);
        account test2 = new account(1,25900, true, 2);

        //Testing getting the information for each account
        test.getInfo();
        test2.getInfo();

        //Calcualting taxes for each acccount
        System.out.println(test.taxCalculator());


    }




}