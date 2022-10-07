public class Main {
    public static void main(String[] args) {
        //Testing by creating accounts with information
        account Zero = new account(0, 9000, false, 0);
        account One = new account(1, 11000, false, 1);
        account Two = new account(2, 50000, false, 2);
        account Three = new account(3, 90000, false, 3);
        account Four = new account(4, 200000, false, 4);
        account Five = new account(5, 500000, false, 5);
        account Six = new account(6, 1000000, false, 6);

        //Testing getting the information for each account
        Zero.getInfo();
        One.getInfo();
        Two.getInfo();
        Three.getInfo();
        Four.getInfo();
        Five.getInfo();
        Six.getInfo();




    }




}