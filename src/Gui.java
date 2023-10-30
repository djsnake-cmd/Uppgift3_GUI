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
    private Point emptyLocal = new Point(); //Point för att peka var den tomma rutan är på griden


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
        for (int i = 0; i < 4; i++) { //Kollar varje square i griden och lägger ut siffror i squares
            for (int j = 0; j < 4; j++) {
                if (count <= 15) {
                    numberButton = new JButton("" + (count));
                    buttons[i][j] = numberButton;
                    buttonList.add(numberButton);
                    southPanel.add(numberButton);
                    numberButton.addActionListener(this);
                    count++;

                } else { //Lägger ut den sista, tomma, squaren
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
        if (e.getSource() == newGameButton) { //Klickades det på newGameButton? Isf shuffla
            randomizeButtons();
        } else { //Klickades något annat än nGB? Kör nedanstående
            for (int i = 0; i < 4; i++) { //Kollar varje square i grid.
                for (int j = 0; j < 4; j++) {
                    if (e.getSource() == buttons[i][j] && adjacent(i, j)) { //Om klickad square är i,j och om square är bredvid tom square (adjacent)
                        swap(i, j); //Om true, byt plats
                        return;
                    }
                }
            }
        }
    }
    private boolean adjacent(int x, int y) { //Metod för att avgöra om en ruta är bredvid den tomma rutan.
        return Math.abs(x - emptyLocal.x) + Math.abs(y - emptyLocal.y) == 1; // Math.abs-metoden tar bort kravet - eller + och avgör bara om den tomma rutan är bredvid på en x, y axis
    }

    private void swap(int x, int y) {
        JButton temp = buttons[x][y]; //Skapar temporär placeholder för x,y
        buttons[x][y] = buttons[emptyLocal.x][emptyLocal.y]; //Gör buttons[][] tom
        buttons[emptyLocal.x][emptyLocal.y] = temp; //Fyller med temp

        southPanel.removeAll();
        for (int i = 0; i < 4; i++) { //Lägger tillbaka alla squares i den nya ordningen
            for (int j = 0; j < 4; j++) {
                southPanel.add(buttons[i][j]);
            }

        }
        southPanel.revalidate();
        southPanel.repaint();
        emptyLocal.setLocation(x, y); //Kommer ihåg ny tom square

    }

    private void randomizeButtons() {
        southPanel.removeAll();
        Collections.shuffle(buttonList); //Collections för att blanda om squares

        int index = 0;
        for (int i = 0; i < 4; i++) { //Sätter ut alla squares
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = buttonList.get(index++);
                southPanel.add(buttons[i][j]);
                if (buttons[i][j] == emptyButton) { //Sätter ut tom square
                    emptyLocal.setLocation(i, j);
                }
            }
        }
        southPanel.revalidate();
        southPanel.repaint();
    }
}

