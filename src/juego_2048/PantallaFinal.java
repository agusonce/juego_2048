package juego_2048;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import juego_2048.components.config.Style;

public class PantallaFinal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public PantallaFinal(boolean ganaste) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lbResult = new JLabel();
		if (ganaste) {
			lbResult.setText("Ganaste");
		} else {
			lbResult.setText("Perdiste");
		}

		JButton btnNewGame = new JButton("Jugar nuevamente");
		btnNewGame.setBounds(15, 478, 200, 50);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irAInicio();
			}
		});

		JButton btnExit = new JButton("Salir del juego");
		btnExit.setBounds(372, 478, 200, 50);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		lbResult.setBounds(15, 5, 557, 105);
		lbResult.setHorizontalAlignment(SwingConstants.CENTER);
		lbResult.setFont(Style.createFont(56));

		table = new JTable();
		table.setBounds(15, 115, 557, 305);

		contentPane.setLayout(null);
		contentPane.add(lbResult);
		contentPane.add(table);
		contentPane.add(btnNewGame);
		contentPane.add(btnExit);
	}

	public void irAInicio() {
		Router.finishWindows(this, new MenuInicio(),false);
	}
}
