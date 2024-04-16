package juego_2048;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import juego_2048.logger.Ranking;

public class PantallaFinal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PantallaFinal(boolean ganaste) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbResult = new JLabel();
		if (ganaste) {
			lbResult.setText("Ganaste");
		} else {
			lbResult.setText("Perdiste");
		}
		lbResult.setBounds(15, 5, 557, 105);
		lbResult.setHorizontalAlignment(SwingConstants.CENTER);
		lbResult.setFont(new Font("Arial", Font.BOLD, 56));
		contentPane.add(lbResult);

		ArrayList<Integer> scores = null;
		try {
			scores = Ranking.readScoresFromFile("Logs");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (scores != null && !scores.isEmpty()) {
			JLabel lblScoresTitle = new JLabel("Top 5 Puntuaciones:");
			lblScoresTitle.setBounds(15, 125, 200, 30);
			lblScoresTitle.setFont(new Font("Arial", Font.BOLD, 20));
			contentPane.add(lblScoresTitle);

			int posY = 165;
			for (int i = 0; i < Math.min(scores.size(), 5); i++) {
				JLabel lblScore = new JLabel((i + 1) + ". " + scores.get(i));
				lblScore.setBounds(25, posY, 150, 20);
				lblScore.setFont(new Font("Arial", Font.PLAIN, 16));
				contentPane.add(lblScore);
				posY += 30;
			}
		}

		JButton btnNewGame = new JButton("Jugar nuevamente");
		btnNewGame.setBounds(15, 478, 200, 50);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irAInicio();
			}
		});
		contentPane.add(btnNewGame);

		JButton btnExit = new JButton("Salir del juego");
		btnExit.setBounds(372, 478, 200, 50);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnExit);
	}

	public void irAInicio() {
		Router.finishWindows(this, new MenuInicio(), false);
	}
}
