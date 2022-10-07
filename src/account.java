public class account {
    /*
        ID: The identification number for the account
        income: The balance for the account
        taxPercents: shows the percentage for each tax bracket
        maxRates: shows the maximum income for each tax bracket
     */
    public int ID;
    public double income;
    public boolean isMarried;
    public int children;

    public double[] taxPercents = {0.1,0.12,0.22,0.24,0.32,0.35,0.37};
    public double[] maxRates = {10275,41775,89075,170050,215950,539900,539901};

    /*
        Constructors:
        Take in the account ID and balance, and put store them
        If no balance is given then it is put to 0
     */
    public account(int gID, double gBalance, boolean gIsMarried, int gChildren){
        ID = gID;
        income = gBalance;
        isMarried = gIsMarried;
        children = gChildren;
    }
    public account(int gID){
        ID = gID;
        income = 0;
        isMarried = false;
    }

    /*
        getInfo:
        Gets account information in an easy-to-read string format
     */
    public void getInfo(){
        System.out.println(
                "=========\n"
                        +"Account ID: " +ID+
                        "\nIncome: " +income+
                        "\nisMarried: " +isMarried+
                        "\nmaxBracket: "+maxBracket()+
                        "\nchildren: "+children+
                "\n=========");
    }

    /*
        maxBracket:
        Calculates the maximum bracket that the
        income may fall into
     */
    public int maxBracket(){
        int maxBracket =0;
        for(int i=0; i<maxRates.length; i++){
            if(income > maxRates[maxRates.length-1]){
                maxBracket = maxRates.length-1;
                break;
            }
            else if(maxRates[i]<income && maxRates[i+1] > income){
                maxBracket = i;
                break;
            }
        }
        return maxBracket;
    }

    /*
        taxCalculator:
        Using information that is put into the account
        this function calculates:
            total federal income tax
            child tax credit
            total tax owed
            income after taxes
     */
    public String taxCalculator() {
        double incomeTax = 0;
        double childBenefits = children*2000;
        double tempIncome = income;

        for (int x = maxBracket()-1; x > 1; x--) {
                incomeTax += (tempIncome-maxRates[x-1])*taxPercents[x];
                tempIncome -= (tempIncome-maxRates[x-1]);
            }
        incomeTax += tempIncome*taxPercents[0];
        incomeTax -= childBenefits;
        return (
                        "\n===============\n"+
                        "Total Federal Income Tax: $"+incomeTax+"\n"+
                        "Child Tax Credit: $"+(incomeTax+childBenefits)+"\n"+
                        "Total Owed: $"+incomeTax+"\n"+
                        "Paycheck After Federal Tax: $"+(income-incomeTax)+
                        "\n===============\n"
                );
    }
}
