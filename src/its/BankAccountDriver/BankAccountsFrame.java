package its.BankAccountDriver;

import its.DefaultFrame.DefaultFrame;

import javax.swing.*;

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
