package its.InputAccount;

import its.BankAccountDriver.BankAccountsPanel;
import its.DefaultFrame.DefaultFrame;

public class InputAccountFrame extends DefaultFrame {
    private BankAccountsPanel basePanel;
    public InputAccountFrame()
    {
        InputAccountPanel inputAccountPanel= new InputAccountPanel();
        this.getContentPane().add(inputAccountPanel);
        this.pack();
    }

}
