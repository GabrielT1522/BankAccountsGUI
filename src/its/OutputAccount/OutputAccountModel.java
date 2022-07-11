package its.OutputAccount;

import its.InputAccount.InputAccountModel;

public class OutputAccountModel
{
    private InputAccountModel inputAccountModel = new InputAccountModel();

    private String fullName;
    private double balance;
    private double withdraw;
    private double deposit;

    public OutputAccountModel()
    {
        String fullName = getFullName();
        double balance = 0.0;
        double withdraw = 0.0;
        double deposit = 0.0;
    }

    public void processOutputAccount(double newBalance, int alterType)
    {


    }

    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDeposit() {
        return deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }
}
