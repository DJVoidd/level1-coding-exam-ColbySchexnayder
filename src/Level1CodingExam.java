import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Level1CodingExam implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton[] buttons;
	public void run() {
		frame.add(panel);
		frame.setVisible(true);
		buttons = new JButton[4];
		makeButtons(4);
		frame.pack();
	}

	public void makeButtons(int num) {
		for (int i = 0; i < num; i++) {
			buttons[i] = new JButton();
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
			frame.pack();
		}
		buttons[0].setBackground(Color.YELLOW);
		buttons[0].setOpaque(true);
		buttons[1].setBackground(Color.RED);
		buttons[1].setOpaque(true);
		buttons[2].setBackground(Color.BLUE);
		buttons[2].setOpaque(true);
		buttons[3].setBackground(Color.GREEN);
		buttons[3].setOpaque(true);
	}

	public static void main(String[] arg0) {
		Level1CodingExam code = new Level1CodingExam();
		code.run();
	}

	static void speak(String words) {
		if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
			String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
					+ words + "');\"";
			try {
				Runtime.getRuntime().exec( cmd ).waitFor();
			} catch( Exception e ) {
				e.printStackTrace();
			}
		} else {
			try {
				Runtime.getRuntime().exec( "say " + words ).waitFor();
			} catch( Exception e ) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton check = (JButton) e.getSource();
		if (check == buttons[0]) {
			speak("yellow");
		}
		if (check == buttons[1]) {
			speak("red");
		}
		if (check == buttons[2]) {
			speak("blue");
		}
		if (check == buttons[3]) {
			speak("green");
		}
	}
}
