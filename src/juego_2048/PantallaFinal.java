package juego_2048;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;


public class PantallaFinal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public PantallaFinal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
			
		JLabel lbResult = new JLabel();
		if(true) {
			lbResult.setText("Ganaste");
		}
		else {
			lbResult.setText("Perdiste");
		}
		
		JButton btnNewGame = new JButton("Jugar nuevamente");
		btnNewGame.setBounds(15, 478, 200, 50);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		JButton btnExit = new JButton("Salir del juego");
		btnExit.setBounds(372, 478, 200, 50);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		lbResult.setBounds(15, 5, 557, 105);
		lbResult.setHorizontalAlignment(SwingConstants.CENTER);
		lbResult.setFont(new Font("Tahoma", Font.PLAIN, 56));
		
		table = new JTable();
		table.setBounds(15, 115, 557, 305);
		
		contentPane.setLayout(null);
		contentPane.add(lbResult);
		contentPane.add(table);
		contentPane.add(btnNewGame);
		contentPane.add(btnExit);
	}
}
