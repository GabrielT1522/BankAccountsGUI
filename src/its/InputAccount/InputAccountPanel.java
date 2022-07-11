package its.InputAccount;

import its.BankAccountProgram.*;
import its.Welcome.WelcomePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class InputAccountPanel extends JPanel
{
    private JPanel northPanel;
    private JPanel centerPanel;
    private JPanel southPanel;
    private GridLayout gridLayout;
    private JLabel filler;

    public JLabel accountNumLabel;

    private JLabel fNameLabel;
    private JTextField fNameField;

    private ButtonGroup group;
    private JLabel accTypeLabel;
    private JRadioButton savingsButton;
    private JRadioButton checkingButton;

    private JLabel lNameLabel;
    private JTextField lNameField;

    private JLabel extraChargeLabel;
    private JTextField extraChargeField;

    private JLabel inBalanceLabel;
    private JTextField inBalanceField;

    private InputAccountListener inputAccountListener;

    public InputAccountModel inputAccountModel;
    public WelcomePanel welcomePanel;

    public InputAccountPanel()
    {
        inputAccountModel = new InputAccountModel();
        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        gridLayout = new GridLayout(0,2, 10, 5);
        filler = new JLabel(" ");

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        accountNumLabel = new JLabel("Account 1");
        northPanel.add(accountNumLabel);

        fNameLabel = new JLabel("First Name: ");
        fNameField = new JTextField();

        group = new ButtonGroup();
        accTypeLabel = new JLabel("Type of Account? ");
        savingsButton = new JRadioButton("Savings");
        checkingButton = new JRadioButton("Checking");

        lNameLabel = new JLabel("Last Name: ");
        lNameField = new JTextField();

        extraChargeLabel = new JLabel("---");
        extraChargeField = new JTextField();

        inBalanceLabel = new JLabel("Initial Balance: $");
        inBalanceField = new JTextField();

        centerPanel.setSize(new Dimension(100, 250));
        centerPanel.setLayout(gridLayout);

        centerPanel.add(fNameLabel);
        centerPanel.add(fNameField);

        centerPanel.add(lNameLabel);
        centerPanel.add(lNameField);

        centerPanel.add(accTypeLabel);
        centerPanel.add(filler);
        group.add(savingsButton);
        group.add(checkingButton);
        savingsButton.addActionListener(this::actionPerformed);
        checkingButton.addActionListener(this::actionPerformed);
        savingsButton.setSelected(false);
        checkingButton.setSelected(false);

        centerPanel.add(savingsButton);
        centerPanel.add(checkingButton);

        centerPanel.add(extraChargeLabel);
        centerPanel.add(extraChargeField);

        centerPanel.add(inBalanceLabel);
        centerPanel.add(inBalanceField);


        JButton submitButton = new JButton("Submit");
        southPanel.add(submitButton);
        inputAccountListener = new InputAccountListener(this);
        submitButton.addActionListener(inputAccountListener);

        this.add(northPanel);
        this.add(centerPanel);
        this.add(southPanel);
    }


    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == checkingButton)
        {
            inputAccountModel.setAccType(1);
            extraChargeLabel.setText("Enter the fee: $");
            System.out.println("Checking button selected.");
        }

        if (e.getSource() == savingsButton)
        {
            inputAccountModel.setAccType(2);
            extraChargeLabel.setText("Enter the interest rate: $");
            System.out.println("Savings button selected.");
        }
    }


    public void processAccount()
    {
        inputAccountModel = new InputAccountModel();
        welcomePanel = new WelcomePanel();
        int arraySize = welcomePanel.getNumOfAccounts();
        int accType = inputAccountModel.getAccType();
        String firstName = fNameField.getText();
        String lastName = lNameField.getText();
        double balance = Double.parseDouble(inBalanceField.getText());
        double extraCharge = Double.parseDouble(extraChargeField.getText());


        //Account[] accountArrayList = new Account[welcomePanel.getNumOfAccounts()];
        ArrayList<Account> accountArrayList = new ArrayList<>();

        System.out.println("Account type "+inputAccountModel.getAccType());
        for(int i = 0; i < arraySize; i++) {
            inputAccountModel.inputAccounts(accountArrayList, firstName, lastName, balance, accType, extraCharge);
        }
        inputAccountModel.outputAccounts(accountArrayList);

        if (accType == 1) {
            inputAccountModel.setFee(extraCharge);
        }
        else if (accType == 2) {
            inputAccountModel.setInterest(extraCharge);
        }
        else{
            System.out.println("Error setting accType.");
        }

        inputAccountModel.incrementAccount();

        fNameField.setText("");
        lNameField.setText("");
        savingsButton.setSelected(false);
        checkingButton.setSelected(false);
        extraChargeField.setText("");
        inBalanceField.setText("");
    }

    public void setAccountNumLabel(int numOfAccounts){
        this.accountNumLabel.setText("Account" + " " + inputAccountModel.getAccountIndex()+" out of "+numOfAccounts);
        System.out.println("Account" + " " + inputAccountModel.getAccountIndex()+" out of "+numOfAccounts);
    }



}