import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {

    JPanel panel = new JPanel(new BorderLayout());
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();

    JButton newGameButton = new JButton("New game");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton button10 = new JButton("10");
    JButton button11 = new JButton("11");
    JButton button12 = new JButton("12");
    JButton button13 = new JButton("13");
    JButton button14 = new JButton("14");
    JButton button15 = new JButton("15");


    public Gui(){
        this.add(panel);
        panel.add(northPanel,BorderLayout.NORTH);

        panel.add(southPanel,BorderLayout.SOUTH);
        southPanel.setLayout(new GridLayout(4,4));

        northPanel.add(newGameButton);

        southPanel.add(button1);
        southPanel.add(button2);
        southPanel.add(button3);
        southPanel.add(button4);
        southPanel.add(button5);
        southPanel.add(button6);
        southPanel.add(button7);
        southPanel.add(button8);
        southPanel.add(button9);
        southPanel.add(button10);
        southPanel.add(button11);
        southPanel.add(button12);
        southPanel.add(button13);
        southPanel.add(button14);
        southPanel.add(button15);




        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

