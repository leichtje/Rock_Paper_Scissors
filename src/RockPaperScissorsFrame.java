import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {

    JPanel mainPnl;

    JPanel btnPnl;
    JButton rockBtn;
    ImageIcon rockIcon;
    JButton paperBtn;
    ImageIcon paperIcon;
    JButton scissorBtn;
    ImageIcon scissorIcon;
    JButton quitBtn;
    ImageIcon quitIcon;


    JPanel statPnl;
    JLabel userWins;
    JTextField userWinsField;
    ImageIcon userIcon;
    JLabel compWins;
    JTextField compWinsField;
    ImageIcon compIcon;
    JLabel tie;
    JTextField tieField;
    ImageIcon tieIcon;

    JPanel resultsPnl;
    JTextArea resultsField;
    JScrollPane resultsScroller;

    Random rnd;
    int playMove = 0;
    int compMove = 0;
    int usrWinsCnt = 0;
    int compWinsCnt = 0;
    int tiesCnt = 0;


    Border bevel, empty;

    public RockPaperScissorsFrame(){

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(3*(screenWidth / 4), 3*(screenHeight / 4));
        setLocationRelativeTo(null);

        add(mainPnl);

        createBtnPnl();
        mainPnl.add(btnPnl,BorderLayout.WEST);

        createStatPnl();
        mainPnl.add(statPnl,BorderLayout.EAST);

        createResultsPnl();
        mainPnl.add(resultsPnl,BorderLayout.NORTH);

    }

    private void createResultsPnl() {
        resultsPnl = new JPanel();

        resultsField = new JTextArea(8, 25);
        resultsField.setFont(new Font("Serif", Font.PLAIN, 16));
        resultsField.setEditable(false);
        resultsScroller = new JScrollPane(resultsField);
        resultsScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        resultsPnl.add(resultsScroller, BorderLayout.CENTER);
    }

    private void createStatPnl() {
        statPnl = new JPanel();
        statPnl.setBackground(Color.WHITE);
        statPnl.setLayout(new GridLayout(0, 1));


        userWins = new JLabel("User Win Count", userIcon, JLabel.CENTER);
        userWins.setFont(new Font("Serif", Font.PLAIN, 16));
        userWins.setVerticalTextPosition(JLabel.BOTTOM);
        userWins.setHorizontalTextPosition(JLabel.CENTER);

        userWinsField = new JTextField();
        userWinsField.setHorizontalAlignment(JTextField.CENTER);
        empty = BorderFactory.createEmptyBorder();
        userWinsField.setBorder(empty);
        userWinsField.setFont(new Font("Monospaced", Font.PLAIN, 18));
        userWinsField.setEditable(false);


        tie = new JLabel("Tie Count", tieIcon, JLabel.CENTER);
        tie.setFont(new Font("Serif", Font.PLAIN, 16));
        tie.setVerticalTextPosition(JLabel.BOTTOM);
        tie.setHorizontalTextPosition(JLabel.CENTER);

        tieField = new JTextField();
        tieField.setHorizontalAlignment(JTextField.CENTER);
        tieField.setBorder(empty);
        tieField.setFont(new Font("Monospaced", Font.PLAIN, 18));
        tieField.setEditable(false);


        compWins = new JLabel("Computer Win Count", compIcon, JLabel.CENTER);
        compWins.setFont(new Font("Serif", Font.PLAIN, 16));
        compWins.setVerticalTextPosition(JLabel.BOTTOM);
        compWins.setHorizontalTextPosition(JLabel.CENTER);

        compWinsField = new JTextField();
        compWinsField.setHorizontalAlignment(JTextField.CENTER);
        compWinsField.setBorder(empty);
        compWinsField.setFont(new Font("Monospaced", Font.PLAIN, 18));
        compWinsField.setEditable(false);

        statPnl.add(userWins);
        statPnl.add(userWinsField);
        statPnl.add(tie);
        statPnl.add(tieField);
        statPnl.add(compWins);
        statPnl.add(compWinsField);
    }

    private void createBtnPnl() {
        btnPnl = new JPanel();
        bevel = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        btnPnl.setBorder(bevel);
        btnPnl.setLayout(new GridLayout(1, 4));

        rockIcon = new ImageIcon("src/rockIcon.png");
        rockBtn = new JButton("ROCK", rockIcon);
        rockBtn.setVerticalTextPosition(JButton.BOTTOM);
        rockBtn.setHorizontalTextPosition(JButton.CENTER);
        rockBtn.setFont(new Font("Dialog", Font.BOLD, 15));
        btnPnl.add(rockBtn);

        rockBtn.addActionListener((ActionEvent ae) ->{
            playMove = 1;
            rnd = new Random();
            compMove = rnd.nextInt(3) + 1;
            if(compMove == 1){
                resultsField.append("Computer chose Rock. Tie Game!\n\n");
                tiesCnt = tiesCnt + 1;
                tieField.setText(String.valueOf(tiesCnt));
            }
            if(compMove == 2){
                resultsField.append("Paper Covers Rock. Computer Wins!\n\n");
                compWinsCnt = compWinsCnt + 1;
                compWinsField.setText(String.valueOf(compWinsCnt));
            }
            if(compMove == 3){
                resultsField.append("Rock Crushes Scissors. You Win!\n\n");
                usrWinsCnt = usrWinsCnt + 1;
                userWinsField.setText(String.valueOf(usrWinsCnt));
            }
        });

        paperIcon = new ImageIcon("src/paperIcon.jpg");
        paperBtn = new JButton("PAPER", paperIcon);
        paperBtn.setVerticalTextPosition(JButton.BOTTOM);
        paperBtn.setHorizontalTextPosition(JButton.CENTER);
        paperBtn.setFont(new Font("Dialog", Font.BOLD, 15));
        btnPnl.add(paperBtn);

        paperBtn.addActionListener((ActionEvent ae) ->{
            playMove = 2;
            rnd = new Random();
            compMove = rnd.nextInt(3) + 1;
            if(compMove == 1){
                resultsField.append("Paper Covers Rock. You Win!\n\n");
                usrWinsCnt = usrWinsCnt + 1;
                userWinsField.setText(String.valueOf(usrWinsCnt));
            }
            if(compMove == 2){
                resultsField.append("Computer chose Paper. Tie Game!\n\n");
                tiesCnt = tiesCnt + 1;
                tieField.setText(String.valueOf(tiesCnt));
            }
            if(compMove == 3){
                resultsField.append("Scissors Cut Paper. Computer Wins!\n\n");
                compWinsCnt = compWinsCnt + 1;
                compWinsField.setText(String.valueOf(compWinsCnt));
            }
        });

        scissorIcon = new ImageIcon("src/scissorIcon.png");
        scissorBtn = new JButton("SCISSORS", scissorIcon);
        scissorBtn.setVerticalTextPosition(JButton.BOTTOM);
        scissorBtn.setHorizontalTextPosition(JButton.CENTER);
        scissorBtn.setFont(new Font("Dialog", Font.BOLD, 15));

        scissorBtn.addActionListener((ActionEvent ae) ->{
            playMove = 3;
            rnd = new Random();
            compMove = rnd.nextInt(3) + 1;
            if(compMove == 1){
                resultsField.append("Rock Crushes Scissors. Computer Wins!\n\n");
                compWinsCnt = compWinsCnt + 1;
                compWinsField.setText(String.valueOf(compWinsCnt));
            }
            if(compMove == 2){
                resultsField.append("Scissors Cut Paper. You win!\n\n");
                usrWinsCnt = usrWinsCnt + 1;
                userWinsField.setText(String.valueOf(usrWinsCnt));
            }
            if(compMove == 3){
                resultsField.append("Computer Chose Scissors. Tie Game!\n\n");
                tiesCnt = tiesCnt + 1;
                tieField.setText(String.valueOf(tiesCnt));
            }
        });

        btnPnl.add(scissorBtn);

        quitIcon = new ImageIcon("src/quitIcon.jpg");
        quitBtn = new JButton("QUIT", quitIcon);
        quitBtn.setVerticalTextPosition(JButton.BOTTOM);
        quitBtn.setHorizontalTextPosition(JButton.CENTER);
        quitBtn.setFont(new Font("Dialog", Font.BOLD, 15));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        btnPnl.add(quitBtn);
    }


}
