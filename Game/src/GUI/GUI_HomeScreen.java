package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Form.GUI_ContactForm;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GUI_HomeScreen extends JFrame {
	private static GUI_HomeScreen INSTANCE;
	private GUI_Game gui;
	private JLayeredPane contentPane;
	private JLabel background;
	private JButton btnStart, btnHelp;

	public GUI_HomeScreen() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 700);
		this.contentPane = new JLayeredPane();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		this.setResizable(false);

		ImageIcon img = new ImageIcon(getClass().getResource("/Resources/PantallaInicio.jpg"));
		background = new JLabel();
		Icon icon = new ImageIcon(
				img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		background.setIcon(icon);
		background.setBounds(0, 0, 1024, 700);
		contentPane.add(background);
		contentPane.setLayer(background, 1);
		background.setVisible(true);

		btnStart = new JButton("Start game");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startGame();
			}
		});
		contentPane.setLayer(btnStart, 2);
		btnStart.setBounds(42, 53, 150, 40);
		contentPane.add(btnStart);
		btnStart.setBackground(Color.BLACK);
		btnStart.setFont(new Font("Unispace", Font.PLAIN, 16));
		btnStart.setBorder(new LineBorder(Color.lightGray.darker(), 2));
		btnStart.setForeground(Color.white);

		btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startHelp();
			}
		});
		contentPane.setLayer(btnHelp, 2);
		btnHelp.setBounds(42, 104, 150, 40);
		contentPane.add(btnHelp);
		btnHelp.setFont(new Font("Unispace", Font.PLAIN, 16));
		btnHelp.setBackground(Color.BLACK);
		btnHelp.setBorder(new LineBorder(Color.lightGray.darker(), 2));
		btnHelp.setForeground(Color.white);

		JButton btnCredits = new JButton("About");
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startAbout();
			}
		});
		contentPane.setLayer(btnCredits, 2);
		btnCredits.setBounds(42, 154, 150, 40);
		contentPane.add(btnCredits);
		btnCredits.setFont(new Font("Unispace", Font.PLAIN, 16));
		btnCredits.setBackground(Color.BLACK);
		btnCredits.setBorder(new LineBorder(Color.lightGray.darker(), 2));
		btnCredits.setForeground(Color.white);

		// Boton Comentarios
		JButton btnComentarios = new JButton("Contact us");
		btnComentarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startComentarios();
			}
		});
		contentPane.setLayer(btnComentarios, 2);
		btnComentarios.setBounds(42, 204, 150, 40);
		contentPane.add(btnComentarios);
		btnComentarios.setFont(new Font("Unispace", Font.PLAIN, 16));
		btnComentarios.setBackground(Color.BLACK);
		btnComentarios.setBorder(new LineBorder(Color.lightGray.darker(), 2));
		btnComentarios.setForeground(Color.white);

		// Boton cerrar sesion

		JButton btnCerrarSesion = new JButton("Cerrar sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarSesion();
			}
		});
		contentPane.setLayer(btnCerrarSesion, 2);
		btnCerrarSesion.setBounds(42, 344, 150, 40);
		contentPane.add(btnCerrarSesion);
		btnCerrarSesion.setFont(new Font("Unispace", Font.PLAIN, 16));
		btnCerrarSesion.setBackground(Color.BLACK);
		btnCerrarSesion.setBorder(new LineBorder(Color.lightGray.darker(), 2));
		btnCerrarSesion.setForeground(Color.white);
	}
	
	private void cerrarSesion() {
		dispose();
	}

	private void startGame() {
		gui = GUI_Game.getInstance();
		gui.setVisible(true);
		this.dispose();
	}

	private void startHelp() {
		GUI_Help help = new GUI_Help(this);
		disableAllComponents();
		this.setContentPane(help.getPanel());
	}

	private void disableAllComponents() {
		this.btnHelp.setEnabled(false);
		this.btnStart.setEnabled(false);
		// this.contentPane.setVisible(false);
	}

	private void startAbout() {
		GUI_About about = new GUI_About(this);
		disableAllComponents();
		this.setContentPane(about.getPanel());
	}

	private void startComentarios() {
		GUI_ContactForm contactForm = new GUI_ContactForm(this);
		disableAllComponents();
		this.setContentPane(contactForm.getPanel());
	}

	public static GUI_HomeScreen getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new GUI_HomeScreen();
		}
		return INSTANCE;
	}

	public void regresar() {
		this.setContentPane(contentPane);
		this.contentPane.setVisible(true);
		this.btnHelp.setEnabled(true);
		this.btnStart.setEnabled(true);
	}

	public void agregarBotonVerComentarios() {
		// Boton Ver Comentarios
		JButton btnVerComentarios = new JButton("Ver comentarios");
		btnVerComentarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startVerComentarios();
			}
		});
		contentPane.setLayer(btnVerComentarios, 2);
		btnVerComentarios.setBounds(42, 254, 190, 40);
		contentPane.add(btnVerComentarios);
		btnVerComentarios.setFont(new Font("Unispace", Font.PLAIN, 16));
		btnVerComentarios.setBackground(Color.BLACK);
		btnVerComentarios.setBorder(new LineBorder(Color.lightGray.darker(), 2));
		btnVerComentarios.setForeground(Color.white);

	}

	private void startVerComentarios() {
		GUI_VerComentarios verComentarios = new GUI_VerComentarios(this);
		disableAllComponents();
		this.setContentPane(verComentarios.getPanel());
	}
}
