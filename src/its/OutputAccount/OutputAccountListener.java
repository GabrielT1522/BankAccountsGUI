package its.OutputAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OutputAccountListener implements ActionListener
{
    private OutputAccountPanel outputAccountPanel;

    public OutputAccountListener(OutputAccountPanel oap) {
        outputAccountPanel = oap;
    }

    public void actionPerformed(ActionEvent evt) {
        String actionCommand = evt.getActionCommand();
        outputAccountPanel = new OutputAccountPanel();

        if (actionCommand.equals("Submit")) {

            outputAccountPanel.updateOutputAccount();
            System.out.println("Output account submit button selected.");
        }
    }

}