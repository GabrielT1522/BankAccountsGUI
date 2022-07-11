package its.OutputAccount;

import its.InputAccount.InputAccountModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OutputAccountPanel extends JPanel
{
    private InputAccountModel inputAccountModel;
    private OutputAccountModel outputAccountModel;
    private JPanel centerPanel;
    private JPanel southPanel;
    public JLabel headingLabel;
    public JLabel alterBalanceLabel;
    private JRadioButton withdrawButton;
    private JRadioButton depositButton;
    private JTextField alterBalanceField;
    private JButton submitButton;
    private ButtonGroup group;
    private OutputAccountListener outputAccountListener;

    public OutputAccountPanel()
    {
        inputAccountModel = new InputAccountModel();
        outputAccountModel = new OutputAccountModel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        headingLabel = new JLabel("Bank client: "+outputAccountModel.getFullName()+" has $"+outputAccountModel.getBalance());
        centerPanel.add(headingLabel);

        group = new ButtonGroup();
        alterBalanceLabel = new JLabel("Deposit or Withdraw?");
        withdrawButton = new JRadioButton("Withdraw");
        depositButton = new JRadioButton("Deposit");

        centerPanel.add(alterBalanceLabel);
        group.add(withdrawButton);
        group.add(depositButton);
        withdrawButton.addActionListener(this::actionPerformed);
        depositButton.addActionListener(this::actionPerformed);
        withdrawButton.setSelected(false);
        depositButton.setSelected(false);

        centerPanel.setLayout(new GridLayout(0,1, 15, 5));
        centerPanel.add(withdrawButton);
        centerPanel.add(depositButton);

        alterBalanceLabel = new JLabel("---");
        alterBalanceField = new JTextField();
        centerPanel.add(alterBalanceLabel);
        centerPanel.add(alterBalanceField);

        submitButton = new JButton("Submit");
        southPanel.add(submitButton);
        outputAccountListener = new OutputAccountListener(this);
        this.submitButton.addActionListener(outputAccountListener);

        this.setLayout(new GridLayout(0,1, 30, 5));
        this.add(centerPanel);
        this.add(southPanel);
    }

    public int alterType;

    public void updateOutputAccount()
    {
        double alterBalance = Double.parseDouble(alterBalanceField.getText());
        outputAccountModel.processOutputAccount(alterBalance, alterType);

        String updateLabel = "Bank Client: " + inputAccountModel.getFullName() + " has $" + inputAccountModel.getBalance();
        headingLabel.setText(updateLabel);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == withdrawButton)
        {
            alterType = 1;
            alterBalanceLabel.setText("Enter amount to withdraw:");
            System.out.println("Withdraw button selected.");
        }

        if (e.getSource() == depositButton)
        {
            alterType = 2;
            alterBalanceLabel.setText("Enter amount to deposit:");
            System.out.println("Deposit button selected.");
        }
    }
}
