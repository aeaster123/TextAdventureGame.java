import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener {
    private JTextField textField;
    private JTextArea textArea;
    private TextAdventureGame game;

    public MyFrame() {
        super("Text Adventure Game");
        // Initialize text area first
        textArea = new JTextArea();
        textArea.setEditable(false);

        // Set initial text to display in the text area
        textArea.setText("You wake up in a jail cell. You have no idea how you got here.\n" +
                "There is a guard standing outside your cell.\n" +
                "Your options are \"talk,\" \"look\", \"escape\", or \"quit\"");

        // Add scroll pane to the text area
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Set the focus to the text field so the user can start typing immediately
        textField = new JTextField();
        textField.addActionListener(this);
        textField.requestFocusInWindow();

        // Add the text field and scroll pane to the frame
        add(textField, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);

        // Create the game object
        game = new TextAdventureGame();

        // Set the frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 500);
        setVisible(true);

        // Process a default command to display the initial game output
        String output = game.processInput("");
        appendToTextArea("Game: " + output);
    }

    public void actionPerformed(ActionEvent e) {
        String input = textField.getText();
        textField.setText("");
        String output = game.processInput(input);
        appendToTextArea("You: " + input);
        appendToTextArea("Game: " + output);
    }

    private void appendToTextArea(String s) {
        textArea.append("\n" + s);
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
