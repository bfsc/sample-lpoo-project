package br.edu.ifpe.paulista.sample.project.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import br.edu.ifpe.paulista.sample.project.business.UserController;
import br.edu.ifpe.paulista.sample.project.ui.exceptions.BusinessException;
import br.edu.ifpe.paulista.sample.project.ui.exceptions.SystemException;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateUser {

	private JFrame frame;
	private JTextField loginTextField;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirmationField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUser window = new CreateUser();
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
	public CreateUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE USER");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(208, 41, 326, 89);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(214, 227, 75, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(181, 272, 120, 37);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password Confirmation:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(27, 311, 274, 44);
		frame.getContentPane().add(lblNewLabel_3);
		
		loginTextField = new JTextField();
		loginTextField.setBounds(299, 227, 419, 33);
		frame.getContentPane().add(loginTextField);
		loginTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(299, 272, 419, 33);
		frame.getContentPane().add(passwordField);
		
		passwordConfirmationField = new JPasswordField();
		passwordConfirmationField.setBounds(299, 322, 419, 33);
		frame.getContentPane().add(passwordConfirmationField);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = loginTextField.getText();
				String password = new String(passwordField.getPassword());
				String passwordConfirmation = new String(passwordConfirmationField.getPassword());
				
				try {
					UserController controller = new UserController();
					controller.createUser(login, password, passwordConfirmation);
					JOptionPane.showMessageDialog(null, "User created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				} catch (BusinessException | SystemException exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "Failure", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(557, 495, 187, 40);
		frame.getContentPane().add(btnNewButton);
	}
}
