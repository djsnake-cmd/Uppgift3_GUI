import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui extends JFrame implements ActionListener {

    JPanel panel = new JPanel(new BorderLayout());
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JButton newGameButton = new JButton("New game");
    private JButton[][] buttons;
    ArrayList<JButton> buttonList = new ArrayList<>();
    JButton numberButton;


    public Gui(){
        this.add(panel);
        panel.add(northPanel,BorderLayout.NORTH);

        panel.add(southPanel,BorderLayout.SOUTH);

        buttons = new JButton[4][4];
        southPanel.setLayout(new GridLayout(4,4));

        northPanel.add(newGameButton);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {


            }
            numberButton = new JButton("" + (i+1));
            buttonList.add(numberButton);
            southPanel.add(numberButton);
        }

        numberButton.addActionListener(this::actionPerformed);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        revalidate();
        repaint();
    }
}

