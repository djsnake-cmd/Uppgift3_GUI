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

    private Point emptyLocal = new Point();


    public Gui() {
        this.add(panel);
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(southPanel, BorderLayout.SOUTH);
        southPanel.setLayout(new GridLayout(4, 4));

        buttons = new JButton[4][4];

        northPanel.add(newGameButton);
        newGameButton.addActionListener(this);
        emptyButton.addActionListener(this);

        int count = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (count <= 15) {
                    numberButton = new JButton("" + (count));
                    buttons[i][j] = numberButton;
                    buttonList.add(numberButton);
                    southPanel.add(numberButton);
                    numberButton.addActionListener(this);
                    count++;

                } else {
                    buttons[i][j] = emptyButton;
                    buttonList.add(emptyButton);
                    southPanel.add(emptyButton);
                }
            }
        }
        randomizeButtons();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGameButton) {
            randomizeButtons();
        } else {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (e.getSource() == buttons[i][j] && adjacent(i, j)) {
                        swap(i, j);
                        return;
                    }
                }
            }
        }
    }

    private boolean adjacent(int x, int y) {
        return Math.abs(x - emptyLocal.x) + Math.abs(y - emptyLocal.y) == 1;
    }

    private void swap(int x, int y) {
        JButton temp = buttons[x][y];
        buttons[x][y] = buttons[emptyLocal.x][emptyLocal.y];
        buttons[emptyLocal.x][emptyLocal.y] = temp;

        southPanel.removeAll();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                southPanel.add(buttons[i][j]);
            }

        }
        southPanel.revalidate();
        southPanel.repaint();
        emptyLocal.setLocation(x, y);

    }

    private void randomizeButtons() {
        southPanel.removeAll();
        Collections.shuffle(buttonList);

        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = buttonList.get(index++);
                southPanel.add(buttons[i][j]);
                if (buttons[i][j] == emptyButton) {
                    emptyLocal.setLocation(i, j);
                }
            }
        }
        southPanel.revalidate();
        southPanel.repaint();
    }
}

