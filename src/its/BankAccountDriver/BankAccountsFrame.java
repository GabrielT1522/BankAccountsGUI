package its.BankAccountDriver;

import its.DefaultFrame.DefaultFrame;
public class BankAccountsFrame extends DefaultFrame
{
    private BankAccountsPanel bankAccountsPanel;
    public BankAccountsFrame()
    {
        bankAccountsPanel = new BankAccountsPanel();
        this.getContentPane().add(bankAccountsPanel);
        this.pack();
    }
}
