package Stopwatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch implements ActionListener {
    private JFrame frame = new JFrame();
    JLabel timeLabel = new JLabel();
    private JButton startButton = new JButton("START");
    private JButton resetButton = new JButton("RESET");
    private int elapsedTime = 0;
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    private boolean started = false;
    private String seconds_string = String.format("%02d", seconds);
    private String minutes_string = String.format("%02d", minutes);
    private String hours_string = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime = elapsedTime + 1000;
            hours = (elapsedTime / 3600_000);
            minutes = (elapsedTime / 60_000) % 60;
            seconds = (elapsedTime / 1_000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        }
    });


    public Stopwatch() {

        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(100, 200, 100, 50);
        startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(200, 200, 100, 50);
        resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setTitle("Stopwatch");

        frame.add(timeLabel);
        frame.add(startButton);
        frame.add(resetButton);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (started == false) {
                started = true;
                startButton.setText("STOP");
                start();
            } else {
                started = false;
                startButton.setText("START");
                stop();
            }
        } else if (e.getSource() == resetButton) {
            started = false;
            startButton.setText("START");
            reset();
        }
    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();
        elapsedTime=0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
    }
}
