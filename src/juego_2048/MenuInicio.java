package juego_2048;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javafx.scene.paint.Color;
import juego_2048.components.FButton;
import juego_2048.components.FLabel;
import juego_2048.components.FrameAbstract;
import juego_2048.components.Juego;
import juego_2048.components.config.Aligment;
import juego_2048.components.config.Style;

public class MenuInicio extends FrameAbstract{

	public MenuInicio(){
		super();
		
		initialize();
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		
		setBounds(0, 0, aligment.getScreenWidth(), aligment.getScreenHeight());
		
		FLabel lbTitulo = new FLabel("2048");
		
		int posicionX = aligment.getPosicionX(aligment.getScreenWidth(), 1, 0, Aligment.CENTER);
		lbTitulo.setBounds(posicionX
				, 100
				,aligment.getScreenWidth()
				,100);
		
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lbTitulo);
		
		FButton btnIniciar = new FButton("Iniciar juego");
		btnIniciar.setBounds(aligment.getScreenWidth()
							, 100
							,Aligment.CENTER);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showJuego();
			}
		});
		getContentPane().add(btnIniciar);
		
	}
	
	public void showJuego() {
		Router.finishWindows(this, new Juego(new Aligment(aligment.getScreenHeight(),aligment.getScreenHeight())));
	}
}
