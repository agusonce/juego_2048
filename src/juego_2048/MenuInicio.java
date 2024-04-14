package juego_2048;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;


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
		setBackground(Style.COLOR_2);
		
		FLabel lbTitulo = new FLabel("2048");
		lbTitulo.setFont(Style.createFont(55));
		int posicionX = aligment.getPosicionX(aligment.getScreenWidth(), 1, 0, Aligment.CENTER);
		lbTitulo.setBounds(posicionX
				, 100
				,aligment.getScreenWidth()
				,100);
		
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lbTitulo);
		
		crearBotonInicio();
		
	}
	
	private void crearBotonInicio() {
		
		FButton btnIniciar = new FButton("Iniciar juego");
		
		int btnWidth = aligment.getScreenWidth()/3;
		
		btnIniciar.setBounds(aligment.getPosicionX(btnWidth, 3, 1, Aligment.CENTER)
							, aligment.getPosicionY(100, 4, 2, Aligment.CENTER)
							,btnWidth
							,100);

		btnIniciar.setFont(Style.createFont(25));
		btnIniciar.setForeground(Color.WHITE);
		
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showJuego();
			}
		});
		
		getContentPane().add(btnIniciar);
	}
	
	public void showJuego() {
		int windowHeight = getContentPane().getHeight();
		Router.finishWindows(this, new Juego(new Aligment(windowHeight, windowHeight)),false);
	}
}
