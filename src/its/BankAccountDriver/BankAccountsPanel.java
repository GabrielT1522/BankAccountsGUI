package its.BankAccountDriver;


import its.InputAccount.InputAccountPanel;
import its.OutputAccount.OutputAccountPanel;
import its.Welcome.WelcomePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAccountsPanel extends JPanel
{
    private JPanel mainPanel;
    private JPanel southPanel;
    private OutputAccountPanel outputAccountCard;
    private InputAccountPanel inputAccountCard;
    private WelcomePanel welcomeCard;
    private JButton nextButton;
    private BankAccountsListener bankAccountsListener;
    public CardLayout layout;
    public JPanel deck;

    /*public BankAccountsPanel(){
        inputAccountCard = new InputAccountPanel();
        this.setPreferredSize(new Dimension(400, 400));
        this.add(inputAccountCard);
    }*/

    public BankAccountsPanel()
    {

        mainPanel = new JPanel();
        southPanel = new JPanel();

        layout = new CardLayout();
        deck = new JPanel();
        deck.setLayout(layout);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        welcomeCard = new WelcomePanel();
        inputAccountCard = new InputAccountPanel();
        outputAccountCard = new OutputAccountPanel();
        //this.add(welcomeCard);

        deck.add(welcomeCard, "0");
        deck.add(inputAccountCard, "1");
        deck.add(outputAccountCard, "2");


        mainPanel.add(deck);
        layout.show(deck, "0");

        nextButton = new JButton("Next");
        southPanel.add(nextButton);
        bankAccountsListener = new BankAccountsListener(this);
        nextButton.addActionListener(bankAccountsListener);
        southPanel.setBackground(Color.lightGray);


        //this.setLayout(new GridLayout(0, 1));
        this.add(mainPanel);
        this.add(southPanel);
    }


    public class BankAccountsListener implements ActionListener
    {
        private BankAccountsPanel bankAccountsPanel;

        public BankAccountsListener(BankAccountsPanel bap) {
            bankAccountsPanel = bap;
        }

        public void actionPerformed(ActionEvent evt) {
            String actionCommand = evt.getActionCommand();
            bankAccountsPanel = new BankAccountsPanel();

            if (actionCommand.equals("Next")) {
                layout.next(deck);

                System.out.println("Next button selected.");
            }
        }
    }
}
