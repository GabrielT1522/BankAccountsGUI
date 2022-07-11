package its.InputAccount;


import its.BankAccountDriver.BankAccountsPanel;
import its.OutputAccount.OutputAccountPanel;
import its.Welcome.WelcomePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputAccountListener implements ActionListener
{
    private InputAccountPanel inputAccountPanel;
    private BankAccountsPanel bankAccountsPanel;
    private OutputAccountPanel outputAccountPanel;
    private WelcomePanel welcomePanel;

    public InputAccountListener(InputAccountPanel wp)
    {
        inputAccountPanel = wp;
    }
    public void actionPerformed(ActionEvent evt)
    {
        String actionCommand = evt.getActionCommand();

        welcomePanel = new WelcomePanel();
        inputAccountPanel = new InputAccountPanel();
        //outputAccountPanel = new OutputAccountPanel();

        inputAccountPanel.processAccount();
        //inputAccountPanel.setAccountNumLabel();
        //outputAccountPanel.updateOutputAccount();
        if (actionCommand.equals("Submit")) {
            System.out.println("Num of accounts: "+welcomePanel.getNumOfAccounts());
            System.out.println("Submit button selected.");
        }
    }
}

