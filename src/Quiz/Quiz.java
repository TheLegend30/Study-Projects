package Quiz;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz implements ActionListener {
    private String[] questions =
            {
                    "Which company created Java?",
                    "Which year was Java created?",
                    "What was Java originally called?",
                    "Who is credited with creating Java?",
                    "Who is the first president of Ukraine",
                    "How do you find this quiz?"
            };
    private String[][] options =
            {
                    {"Sun Microsystems", "Starbucks", "Microsoft", "Alphabet"},
                    {"1989", "1995", "1972", "1492"},
                    {"Apple", "Latte", "Oak", "Kotlin"},
                    {"Steve Jobs", "Bill Gates", "James Gosling", "Mark Zuckerberg"},
                    {"Pedro Roshenko", "Leonid Kravchuk", "Batman", "Darth Vader"},
                    {"Perfect", "Crap", "Meh...", "Could be better"}
            };
    private char[] answers =
            {
                    'A',
                    'B',
                    'C',
                    'C',
                    'B',
                    'A'
            };
    private char answer;
    private int index;
    private int correct_guesses = 0;
    private int total_questions = questions.length;
    private double result;
    private int seconds = 10;

    private JFrame frame = new JFrame();
    private JTextField textField = new JTextField();
    private JTextArea textArea = new JTextArea();
    private JButton buttonA = new JButton("A");
    private JButton buttonB = new JButton("B");
    private JButton buttonC = new JButton("C");
    private JButton buttonD = new JButton("D");
    private JLabel answer_labelA = new JLabel();
    private JLabel answer_labelB = new JLabel();
    private JLabel answer_labelC = new JLabel();
    private JLabel answer_labelD = new JLabel();
    private JLabel time_Label = new JLabel();
    private JLabel seconds_left = new JLabel();
    private JTextField number_right = new JTextField();
    private JTextField percentage = new JTextField();
    private Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            if (seconds <= 0) {
                displayAnswer();
            }
            seconds_left.setText(String.valueOf(seconds));
        }
    });

    public Quiz() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quizza");
        frame.setSize(650, 650);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(141, 25, 25));
        frame.setResizable(false);

        textField.setBounds(0, 0, 650, 50);
        textField.setBackground(new Color(107, 5, 5));
        textField.setForeground(new Color(0, 0, 0));
        textField.setFont(new Font("Liberation Serif", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textArea.setBounds(0, 50, 650, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(107, 5, 5));
        textArea.setForeground(new Color(0, 0, 0));
        textArea.setFont(new Font("Dejavu Serif", Font.BOLD, 25));
        textArea.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        textArea.setEditable(false);

        buttonA.setBounds(0, 100, 100, 100);
        buttonA.setFont(new Font("Liberation Serif", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);

        buttonB.setBounds(0, 200, 100, 100);
        buttonB.setFont(new Font("Liberation Serif", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);

        buttonC.setBounds(0, 300, 100, 100);
        buttonC.setFont(new Font("Liberation Serif", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);

        buttonD.setBounds(0, 400, 100, 100);
        buttonD.setFont(new Font("Liberation Serif", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);


        answer_labelA.setBounds(125, 100, 500, 100);
        answer_labelA.setBackground(new Color(107, 5, 5));
        answer_labelA.setForeground(new Color(0, 0, 0));
        answer_labelA.setFont(new Font("Liberation Serif", Font.PLAIN, 35));

        answer_labelB.setBounds(125, 200, 500, 100);
        answer_labelB.setBackground(new Color(107, 5, 5));
        answer_labelB.setForeground(new Color(0, 0, 0));
        answer_labelB.setFont(new Font("Liberation Serif", Font.PLAIN, 35));

        answer_labelC.setBounds(125, 300, 500, 100);
        answer_labelC.setBackground(new Color(107, 5, 5));
        answer_labelC.setForeground(new Color(0, 0, 0));
        answer_labelC.setFont(new Font("Liberation Serif", Font.PLAIN, 35));

        answer_labelD.setBounds(125, 400, 500, 100);
        answer_labelD.setBackground(new Color(107, 5, 5));
        answer_labelD.setForeground(new Color(0, 0, 0));
        answer_labelD.setFont(new Font("Liberation Serif", Font.PLAIN, 35));

        seconds_left.setBounds(535, 510, 100, 100);
        seconds_left.setBackground(new Color(107, 5, 5));
        seconds_left.setForeground(new Color(0, 0, 0));
        seconds_left.setFont(new Font("Liberation Serif", Font.BOLD, 60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_Label.setBounds(535, 475, 100, 25);
        time_Label.setBackground(new Color(107, 5, 5));
        time_Label.setForeground(new Color(0, 0, 0));
        time_Label.setFont(new Font("Liberation Serif", Font.PLAIN, 20));
        time_Label.setHorizontalAlignment(JTextField.CENTER);
        time_Label.setText("timer");

        number_right.setBounds(225, 225, 200, 100);
        number_right.setBackground(new Color(107, 5, 5));
        number_right.setForeground(new Color(46, 194, 28));
        number_right.setFont(new Font("Liberation Serif", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(225, 325, 200, 100);
        percentage.setBackground(new Color(107, 5, 5));
        percentage.setForeground(new Color(46, 194, 28));
        percentage.setFont(new Font("Liberation Serif", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(seconds_left);
        frame.add(time_Label);
        frame.add(textField);
        frame.add(textArea);
        frame.setVisible(true);

        nextQuestion();
    }

    public void nextQuestion() {
        if (index >= total_questions) {
            results();
        } else {
            textField.setText("Question " + (index + 1));
            textArea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();
        }
    }

    public void displayAnswer() {

        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answers[index] != 'A') {
            answer_labelA.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'B') {
            answer_labelB.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'C') {
            answer_labelC.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'D') {
            answer_labelD.setForeground(new Color(255, 0, 0));
        }

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer_labelA.setForeground(new Color(0, 0, 0));
                answer_labelB.setForeground(new Color(0, 0, 0));
                answer_labelC.setForeground(new Color(0, 0, 0));
                answer_labelD.setForeground(new Color(0, 0, 0));

                answer = ' ';
                seconds = 10;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonC.setEnabled(true);
                buttonB.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();

    }

    public void results() {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int)((correct_guesses / (double) total_questions) * 100);

        textField.setText("Results");
        textArea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
        percentage.setText(result + "%");

        frame.add(percentage);
        frame.add(number_right);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonD.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA) {
            answer = 'A';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonB) {
            answer = 'B';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonC) {
            answer = 'C';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonD) {
            answer = 'D';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        displayAnswer();
    }
}