package its.Welcome;

import its.InputAccount.InputAccountPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends JPanel
{
    private JPanel centerPanel;
    private JPanel southPanel;
    private JLabel welcomeMessage;
    public JLabel numOfAccountsLabel;
    public JLabel accountsToBeCreatedLabel;
    private JButton submitButton;
    private WelcomeListener welcomeListener;
    public JTextField noOfAccountsField;

    public WelcomePanel()
    {
        centerPanel = new JPanel();
        southPanel = new JPanel();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setPreferredSize(new Dimension(400, 100));

        welcomeMessage = new JLabel("Hello! Welcome to my Bank Application");
        numOfAccountsLabel = new JLabel("Enter the number of accounts you want to create.");
        accountsToBeCreatedLabel = new JLabel("---");
        centerPanel.add(welcomeMessage);
        centerPanel.setBackground(Color.white);

        centerPanel.add(numOfAccountsLabel);

        //centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.setPreferredSize(new Dimension(350, 50));

        noOfAccountsField = new JTextField();
        noOfAccountsField.setPreferredSize(new Dimension(100, 35));
        submitButton = new JButton("Submit");

        //southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.setBackground(Color.lightGray);
        southPanel.add(noOfAccountsField);
        southPanel.add(submitButton);
        southPanel.add(accountsToBeCreatedLabel);
        welcomeListener = new WelcomeListener(this);
        this.submitButton.addActionListener(welcomeListener);

        this.add(centerPanel);
        this.add(southPanel);
    }

    private int numOfAccounts;
    public int getNumOfAccounts(){return numOfAccounts;}
    public void setNumOfAccounts(int numOfAccounts){
        this.numOfAccounts = numOfAccounts;
    }


    InputAccountPanel inputAccountPanel = new InputAccountPanel();

    public class WelcomeListener implements ActionListener
    {

        private WelcomePanel welcomePanel;

        public WelcomeListener(WelcomePanel wp) {
            welcomePanel = wp;
        }

        public void actionPerformed(ActionEvent evt) {
            String actionCommand = evt.getActionCommand();

            if (actionCommand.equals("Submit")) {
                System.out.println("Submit button selected.");
                try {
                    int numOfAccounts = Integer.parseInt(noOfAccountsField.getText());
                    setNumOfAccounts(numOfAccounts);
                }catch (Exception e) {
                    System.out.println("noOfAccountsField is Empty.");
                }

                inputAccountPanel.setAccountNumLabel(numOfAccounts);

                if (getNumOfAccounts() == 1) {
                    accountsToBeCreatedLabel.setText(getNumOfAccounts() + " account will be created.");
                    System.out.println(getNumOfAccounts() + " account will be created.");
                }
                else if (getNumOfAccounts() > 1)
                {
                    accountsToBeCreatedLabel.setText(getNumOfAccounts() + " accounts will be created.");
                    System.out.println(getNumOfAccounts() + " accounts will be created.");
                }
            }
        }
    }


}
