package its.InputAccount;

import its.DefaultFrame.DefaultFrame;

public class InputAccountFrame extends DefaultFrame {
    public InputAccountFrame()
    {
        InputAccountPanel inputAccountPanel= new InputAccountPanel();
        this.getContentPane().add(inputAccountPanel);
        this.pack();
    }

}
