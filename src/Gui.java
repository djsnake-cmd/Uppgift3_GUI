import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Gui extends JFrame implements ActionListener {

    JPanel panel = new JPanel(new BorderLayout());
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();

    JButton newGameButton = new JButton("New game");
    private JButton[][] buttons;
    JButton emptyButton = new JButton("");
    ArrayList<JButton> buttonList = new ArrayList<>();
    JButton numberButton;


    public Gui(){
        this.add(panel);
        panel.add(northPanel,BorderLayout.NORTH);
        panel.add(southPanel, BorderLayout.SOUTH);
        southPanel.setLayout(new GridLayout(4, 4));

        buttons = new JButton[4][4];

        northPanel.add(newGameButton);
        newGameButton.addActionListener(this);

        int count = 1;
        /*for (int i = 0; i < 15; i++) {
            JButton numberButton = new JButton("" + (i + 1));*/
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (count<=15){
                    numberButton = new JButton("" + (count));
                    buttons[i][j]= numberButton;
                    buttonList.add(numberButton);
                    southPanel.add(numberButton);
                    numberButton.addActionListener(this);
                    count++;

                }else{
                    buttons[i][j] = emptyButton;
                    buttonList.add(emptyButton);
                    southPanel.add(emptyButton);
                }
            }
        }
        randomizeButtons();


        //numberButton.addActionListener(this::actionPerformed);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGameButton){
            randomizeButtons();
        }
    }

    private void randomizeButtons() {
        southPanel.removeAll();
        Collections.shuffle(buttonList);

        for (JButton button : buttonList) {
            southPanel.add(button);
        }
        southPanel.revalidate();
        southPanel.repaint();
    }
}

