import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Application extends JFrame {
	String logt;
	String past;
	String loginReader;
	String passwordReader;
	private JMenu file;
	private JMenuBar menuBar;
	private JMenuItem about;
	private JMenuItem quit;
	private JMenu income;
	private JMenu outcome;
	private JMenu predictions;
	private JMenu myAcc;
	private JButton a;
	private JButton b;
	private JButton c;
	private JButton d;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;

	private JFrame frame;
	private JTabbedPane pane;

	private boolean isLogged;

	public Application() {
		super();
		initializeDefaultBackground();
		defaultActions();
		start();
	};

	private void initializeDefaultBackground() {
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		panel1 = new JPanel();
		panel1.setName("         Start         ");
		panel1.setPreferredSize(new Dimension(600, 600));
		tabbedPane.add(panel1);

		panel2 = new JPanel();
		panel2.setName("         My Account         ");
		panel2.setPreferredSize(new Dimension(600, 600));
		tabbedPane.add(panel2);

		panel3 = new JPanel();
		panel3.setName("        Income        ");
		panel3.setPreferredSize(new Dimension(600, 600));
		tabbedPane.add(panel3);

		panel4 = new JPanel();
		panel4.setName("        Outcome        ");
		panel4.setPreferredSize(new Dimension(600, 600));
		tabbedPane.add(panel4);

		panel5 = new JPanel();
		panel5.setName("        Predictions        ");
		panel5.setPreferredSize(new Dimension(600, 600));
		tabbedPane.add(panel5);

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(tabbedPane);
		frame.pack();
		Rectangle tabBounds = tabbedPane.getBoundsAt(0);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(menuBar.getPreferredSize().width, (int) tabBounds.getHeight() - 2));

		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		file = new JMenu("File");
		menuBar = new JMenuBar();
		about = new JMenuItem("About");
		quit = new JMenuItem("Quit");

		file.add(about);
		file.add(quit);
		menuBar.add(file);
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}

	private void defaultActions() {
		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane about = new JOptionPane();

				about.showMessageDialog(null, "Created by:\nMaciej Wojewódzki\nv0.1", "About", 1);
			}

		});

		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int quit = JOptionPane.showConfirmDialog(null, "Do you really want to exit?", "Quit",
						JOptionPane.YES_NO_OPTION);
				if (quit == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else
					JOptionPane.showMessageDialog(null, "Uff", "Uff", 1);

			}

		});
	}

	private void start() {
		// panel1.setLayout(new BorderLayout());
		panel1.setLayout(null);
		JLabel startLabel = new JLabel();
		startLabel.setText("<html><br>Welcome to your account management.<br><br> After login to your account"
				+ " you will get access to all the stuff.<br><br> Good luck!</html>");
		// startLabel.setHorizontalAlignment(JLabel.CENTER);
		// startLabel.setVerticalAlignment(JLabel.NORTH);
		// startLabel.setHorizontalTextPosition(JLabel.CENTER);
		// startLabel.setVerticalTextPosition(JLabel.CENTER);
		startLabel.setSize(350, 100);
		startLabel.setLocation(125, 10);
		startLabel.setVisible(true);
		panel1.add(startLabel);

		JButton login = new JButton("Login");
		login.setSize(100, 30);
		login.setText("Login");
		login.setLocation(250, 250);
		login.setVisible(true);
		panel1.add(login);

		JButton quit = new JButton("Quit");
		quit.setSize(100, 30);
		quit.setText("Quit");
		quit.setLocation(250, 290);
		quit.setVisible(true);
		panel1.add(quit);

		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int opt = JOptionPane.showConfirmDialog(null, "Do you really want to exit?", "Quit",
						JOptionPane.YES_NO_OPTION);
				if (opt == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else
					;

			}

		});

		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// metoda logowania (textfield, przyrownanie do loginu, nowy
				// jpanel, jbutton utworz konto itp)
				JDialog mydialog = new JDialog();
				mydialog.setSize(new Dimension(400, 400));
				mydialog.setTitle("Login to your account");
				// prevent user from doing something else
				mydialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

				JPanel logPan = new JPanel();
				logPan.setLayout(null);
				mydialog.add(logPan);

				JTextField loginTf = new JTextField();
				// tf.setBounds(10, 10, 40, 20);
				loginTf.setSize(100, 20);
				loginTf.setLocation(130, 20);
				logPan.add(loginTf);

				JTextField passwordTf = new JTextField();
				passwordTf.setSize(100, 20);
				passwordTf.setLocation(130, 65);
				logPan.add(passwordTf);

				JLabel logLab = new JLabel();
				logLab.setText("Type your login:");
				logLab.setSize(100, 20);
				logLab.setLocation(135, 1);
				logPan.add(logLab);

				JLabel passLab = new JLabel();
				passLab.setText("Type your password:");
				passLab.setSize(150, 20);
				passLab.setLocation(120, 45);
				logPan.add(passLab);

				JButton loginBtn = new JButton();
				loginBtn.setSize(100, 20);
				loginBtn.setLocation(130, 145);
				loginBtn.setText("LOGIN");

				logPan.add(loginBtn);

				loginBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						// System.out.println(loginReader + " " +
						// passwordReader);

						if (logt == null && past == null){
							loginTf.setEditable(false);
							passwordTf.setEditable(false);
							
						}
						
						loginReader = loginTf.getText();
						passwordReader = passwordTf.getText();
						
						if(loginTf.isEditable() == true && passwordTf.isEditable() == true){
								
								
						if (loginReader.equals(logt.toString()) && passwordReader.equals(past.toString())) {
							System.out.println("good");
							JOptionPane.showMessageDialog(null, "You are logged in!");
							mydialog.dispose();
						} else {
							System.out.println("bad");
							JOptionPane.showMessageDialog(null, "You are not logged in!");
						}
						
					}}
					

				});

				JButton createAcc = new JButton();
				createAcc.setText("Create Account");
				createAcc.setSize(130, 20);
				createAcc.setLocation(115, 185);

				createAcc.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						JDialog creating = new JDialog();
						creating.setSize(400, 300);
						creating.setTitle("Create an account");
						creating.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

						JPanel createAcc = new JPanel();
						createAcc.setLayout(null);
						creating.add(createAcc);

						JTextField loginCreator = new JTextField();
						// tf.setBounds(10, 10, 40, 20);
						loginCreator.setSize(100, 20);
						loginCreator.setLocation(130, 20);
						createAcc.add(loginCreator);

						JTextField passwordCreator = new JTextField();
						passwordCreator.setSize(100, 20);
						passwordCreator.setLocation(130, 65);
						createAcc.add(passwordCreator);

						JLabel logLabCr = new JLabel();
						logLabCr.setText("Create your login:");
						logLabCr.setSize(100, 20);
						logLabCr.setLocation(135, 1);
						createAcc.add(logLabCr);

						JLabel passLabCr = new JLabel();
						passLabCr.setText("Create your password:");
						passLabCr.setSize(150, 20);
						passLabCr.setLocation(120, 45);
						createAcc.add(passLabCr);

						JButton okBtn = new JButton();
						okBtn.setSize(100, 20);
						okBtn.setLocation(130, 145);
						okBtn.setText("OK!");

						okBtn.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								logt = loginCreator.getText().toString();
								past = passwordCreator.getText().toString();
								creating.dispose();

							}

						});

						createAcc.add(okBtn);
						creating.setVisible(true);
					}

				});

				logPan.add(createAcc);
				logPan.setVisible(true);
				mydialog.setVisible(true);

			}

		});

	}

	private void income() {
		panel2.setLayout(null);

		a = new JButton();
		a.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane a = new JOptionPane();
				a.showMessageDialog(null, "You pressed 'a' button");

			}
		});
		a.setOpaque(false);
		a.setSize(50, 20);
		a.setLocation(1, 10);
		a.setVisible(true);

		panel2.add(a);
	}

	private void outcome() {

	}

	private void predictions() {

	}

	private void myAcc() {

	}

}
