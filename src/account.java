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
    public double deductions;

    public double[] taxPercents = {0.1,0.12,0.22,0.24,0.32,0.35,0.37};
    public double[] maxRates = {10275,41775,89075,170050,215950,539900,99999999};
    public double[] minRates = {0,10275,41775,89075,170050,215950,539901};
    public double[] marriedMaxRates ={20550,83550,178150,340100,431900,647850,647850};
    public double[] marriedMinRates ={0,20551,83551,178151,340101,431901,647850};
    /*
        Constructors:
        Take in the account ID and balance, and put store them
        If no balance is given then it is put to 0
     */
    public account(int gID, double gBalance, boolean gIsMarried, int gChildren, int gdeductions){
        ID = gID;
        income = gBalance;
        isMarried = gIsMarried;
        children = gChildren;
        deductions = gdeductions;
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
        double tempIncome = income-deductions;
        int maxBracket =0;
        for(int i=0; i<maxRates.length; i++) {
            if (tempIncome > minRates[i] && tempIncome < maxRates[i]) {
                maxBracket = i;
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
        double tempIncome = income-deductions;

        if(isMarried){
            maxRates = marriedMaxRates;
            minRates = marriedMinRates;
        }
        System.out.println("Max Percent: " + taxPercents[maxBracket()]);

        for(int x = maxBracket(); x>=0; x--){
            /*/
            Debugging print statements, give outs information that was used in the debugging process (irrelevant to the final output)
             */
            System.out.print("Round "+x+": "+ tempIncome + " - " + minRates[x] + " = " +(tempIncome-minRates[x]));
            System.out.print("    @"+taxPercents[x]+"% = "+((tempIncome-minRates[x])*taxPercents[x]));
            System.out.print("\n");

            double tax = (tempIncome-minRates[x])*taxPercents[x];
            incomeTax += tax;
            tempIncome = minRates[x];
        }
        
        incomeTax -= childBenefits;
        return (
                        "\n===============\n"+
                        "Total Federal Income Tax: $"+incomeTax+"\n"+
                        "Child Tax Credit: $"+childBenefits+"\n"+
                        "Total Owed: $"+incomeTax+"\n"+
                        "Paycheck After Federal Tax: $"+(income-incomeTax)+
                        "\n===============\n"
                );
    }
}
