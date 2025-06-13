package br.edu.ifpe.paulista.project.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import br.edu.ifpe.paulista.project.business.UserController;
import br.edu.ifpe.paulista.project.exceptions.BusinessException;
import br.edu.ifpe.paulista.project.exceptions.SystemException;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaInicial {

	private JFrame frame;
	private JTextField loginTextField;
	private JPasswordField passwordField;
	private JPasswordField confirmationPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaInicial window = new JanelaInicial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("CADASTRO USUÁRIO");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		titleLabel.setBounds(240, 22, 318, 71);
		frame.getContentPane().add(titleLabel);
		
		JLabel loginLabel = new JLabel("Login:");
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginLabel.setBounds(58, 151, 71, 26);
		frame.getContentPane().add(loginLabel);
		
		loginTextField = new JTextField();
		loginTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginTextField.setBounds(115, 150, 564, 26);
		frame.getContentPane().add(loginTextField);
		loginTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Senha:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordLabel.setBounds(58, 201, 54, 26);
		frame.getContentPane().add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(199, 201, 480, 25);
		frame.getContentPane().add(passwordField);
		
		JLabel passwordConfirmationLabel = new JLabel("Confirmação Senha:");
		passwordConfirmationLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordConfirmationLabel.setBounds(58, 256, 131, 26);
		frame.getContentPane().add(passwordConfirmationLabel);
		
		confirmationPasswordField = new JPasswordField();
		confirmationPasswordField.setBounds(199, 257, 480, 25);
		frame.getContentPane().add(confirmationPasswordField);
		
		JButton registerButton = new JButton("Cadastrar");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = loginTextField.getText();
				String password = String.valueOf(passwordField.getPassword());
				String confirmationPassword = String.valueOf(confirmationPasswordField.getPassword());
				
				try {
					UserController controller = new UserController();
					controller.registerUser(login, password, confirmationPassword);
					JOptionPane.showMessageDialog(JanelaInicial.this.frame, "Sucesso ao cadastrar usuário", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (BusinessException be) {
					JOptionPane.showMessageDialog(JanelaInicial.this.frame, be.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (SystemException se) {
					JOptionPane.showMessageDialog(JanelaInicial.this.frame, se.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		registerButton.setBounds(565, 482, 155, 43);
		frame.getContentPane().add(registerButton);
	}
}
