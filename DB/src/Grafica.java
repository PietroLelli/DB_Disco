import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;

public class Grafica {

	private Controller controller = new Controller();
	private JFrame frame;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private JTextField txtNome_1;
	private JTextField txtCognome;
	private JTextField txtCf;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JTextField txtDataDiNascita;
	private JTextField txtNome;
	private JTextField txtCognome_1;
	private JTextField txtCf_1;
	private JTextField txtResidenza;
	private JTextField txtIdBar;
	private JTextField txtTelefono_1;
	private JTextField txtMansione;
	private JTextField txtDataDiNascita_1;
	private JTextField textLocale;
	private JTextField txtNomeArte;
	private JTextField txtData;
	private JTextField txtOrarioInizio;
	private JTextField txtOrarioFine;
	private JTextField txtSupplemento;
	private JTextField txtNomeOspite;
	private JTextField txtCognome_2;
	private JTextField txtGenereMusicale;
	private JTable table;
	private JTable tableDipendenti;
	private JTable tableSala;
	private JTable tableClienti;
	private JTable tableEventi;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JTable tableBar;
	private JTextField txtIdlocale;
	private JTextField txtIdlocale_1;
	private JScrollPane scrollPane_4;
	private JTextField txtIdlocale_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafica window = new Grafica();
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
	public Grafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layeredPane.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblTitolo = new JLabel("Database");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setFont(new Font("Verdana Pro Cond Semibold", Font.PLAIN, 30));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel panelLocale = new JPanel();
		tabbedPane.addTab("Locale", null, panelLocale, null);
		
		JButton btnSala = new JButton("Visualizza Sale");
		btnSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Sala> sale = controller.findAllSale();
				DefaultTableModel model = (DefaultTableModel) tableSala.getModel();
				model.setRowCount(0);
				sale.forEach(d ->{
					model.addRow(new Object[] {
							d.getIdSala(), d.getTipoMusica(), d.getCapienza(), d.getIdLocale()
					});
				});
			}
		});
		btnSala.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JButton btnBar = new JButton("Visualizza Bar");
		btnBar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Bar> bar = controller.findAllBar();
				DefaultTableModel model = (DefaultTableModel) tableBar.getModel();
				model.setRowCount(0);
				bar.forEach(d ->{
					model.addRow(new Object[] {
							d.getIdBar(), d.getIdSala()
					});
				});
			}
		});
		
		textLocale = new JTextField();
		textLocale.setHorizontalAlignment(SwingConstants.CENTER);
		textLocale.setText("IdLocale");
		textLocale.setColumns(10);
		
		scrollPane_2 = new JScrollPane();
		
		scrollPane_3 = new JScrollPane();
		GroupLayout gl_panelLocale = new GroupLayout(panelLocale);
		gl_panelLocale.setHorizontalGroup(
			gl_panelLocale.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLocale.createSequentialGroup()
					.addGroup(gl_panelLocale.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelLocale.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBar, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panelLocale.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSala, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panelLocale.createSequentialGroup()
							.addGap(25)
							.addComponent(textLocale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panelLocale.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 710, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelLocale.setVerticalGroup(
			gl_panelLocale.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLocale.createSequentialGroup()
					.addGroup(gl_panelLocale.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLocale.createSequentialGroup()
							.addGap(26)
							.addComponent(textLocale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(118)
							.addComponent(btnSala))
						.addGroup(gl_panelLocale.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panelLocale.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelLocale.createSequentialGroup()
							.addGap(25)
							.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panelLocale.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnBar)
							.addGap(19))))
		);
		
		tableBar = new JTable();
		tableBar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IdBar", "IdSala"
			}
		));
		scrollPane_3.setViewportView(tableBar);
		
		tableSala = new JTable();
		tableSala.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IdSala", "Tipo Musica", "Capienza", "IdLocale"
			}
		));
		scrollPane_2.setViewportView(tableSala);
		panelLocale.setLayout(gl_panelLocale);
		
		JPanel panelEventi = new JPanel();
		tabbedPane.addTab("Eventi", null, panelEventi, null);
		
		JButton btnEventi = new JButton("Visualizza Eventi");
		btnEventi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Evento> eventi = controller.findAllEventi();
				DefaultTableModel model = (DefaultTableModel) tableEventi.getModel();
				model.setRowCount(0);
				eventi.forEach(d ->{
					model.addRow(new Object[] {
							d.getNomeArte(), d.getData(), d.getOrarioInizio(), d.getOrarioFine(), d.getSupplemento(), d.getNome(), d.getCognome(), d.getGenereMusicale(), d.getIdLocale()
					});
				});
			}
		});
		
		txtNomeArte = new JTextField();
		txtNomeArte.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomeArte.setText("Nome d'arte");
		txtNomeArte.setColumns(10);
		
		txtData = new JTextField();
		txtData.setHorizontalAlignment(SwingConstants.CENTER);
		txtData.setText("Data (2021-01-01)");
		txtData.setColumns(10);
		
		txtOrarioInizio = new JTextField();
		txtOrarioInizio.setText("Orario Inizio");
		txtOrarioInizio.setColumns(10);
		
		txtOrarioFine = new JTextField();
		txtOrarioFine.setText("Orario Fine");
		txtOrarioFine.setColumns(10);
		
		txtSupplemento = new JTextField();
		txtSupplemento.setHorizontalAlignment(SwingConstants.CENTER);
		txtSupplemento.setText("Supplemento");
		txtSupplemento.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		txtNomeOspite = new JTextField();
		txtNomeOspite.setText("Nome");
		txtNomeOspite.setColumns(10);
		
		txtCognome_2 = new JTextField();
		txtCognome_2.setText("Cognome");
		txtCognome_2.setColumns(10);
		
		txtGenereMusicale = new JTextField();
		txtGenereMusicale.setText("Genere Musicale");
		txtGenereMusicale.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ospite");
		
		JButton btnNewButton_1 = new JButton("Aggiungi Concerto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Evento evento = new Evento();
				evento.setNomeArte(txtNomeArte.getText());
				Date date = Date.valueOf(txtData.getText());
				evento.setData(date);
				Time time = Time.valueOf(txtOrarioInizio.getText());
				evento.setOrarioInizio(time);
				Time time2 = Time.valueOf(txtOrarioFine.getText());
				evento.setOrarioFine(time2);
				evento.setSupplemento(Float.parseFloat(txtSupplemento.getText()));
				evento.setNome(txtNomeOspite.getText());
				evento.setCognome(txtCognome_2.getText());
				evento.setGenereMusicale(txtGenereMusicale.getText());
				evento.setIdLocale(Integer.parseInt(txtIdlocale_2.getText()));
				
				controller.insertConcerto(evento);
				controller.insertOspite(evento);
			}
		});
		
		scrollPane_4 = new JScrollPane();
		
		txtIdlocale_2 = new JTextField();
		txtIdlocale_2.setText("IdLocale");
		txtIdlocale_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdlocale_2.setColumns(10);
		GroupLayout gl_panelEventi = new GroupLayout(panelEventi);
		gl_panelEventi.setHorizontalGroup(
			gl_panelEventi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEventi.createSequentialGroup()
					.addGroup(gl_panelEventi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelEventi.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelEventi.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelEventi.createSequentialGroup()
									.addGroup(gl_panelEventi.createParallelGroup(Alignment.LEADING)
										.addComponent(txtOrarioFine, 117, 121, Short.MAX_VALUE)
										.addComponent(txtOrarioInizio, 117, 121, Short.MAX_VALUE)
										.addComponent(txtData, 117, 121, Short.MAX_VALUE)
										.addComponent(txtNomeArte, 117, 121, Short.MAX_VALUE)
										.addGroup(gl_panelEventi.createSequentialGroup()
											.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtSupplemento, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnNewButton_1, Alignment.TRAILING)
										.addComponent(btnEventi, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
									.addGap(18))
								.addGroup(gl_panelEventi.createSequentialGroup()
									.addComponent(txtGenereMusicale, 133, 133, 133)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_panelEventi.createSequentialGroup()
									.addComponent(txtCognome_2, 117, 133, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_panelEventi.createSequentialGroup()
									.addComponent(txtNomeOspite, 117, 133, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(gl_panelEventi.createSequentialGroup()
							.addGap(39)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panelEventi.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtIdlocale_2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
					.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
		);
		gl_panelEventi.setVerticalGroup(
			gl_panelEventi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEventi.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelEventi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelEventi.createSequentialGroup()
							.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panelEventi.createSequentialGroup()
							.addComponent(txtNomeArte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtOrarioInizio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtOrarioFine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtIdlocale_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelEventi.createParallelGroup(Alignment.LEADING)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSupplemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(19)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNomeOspite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtCognome_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtGenereMusicale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
							.addComponent(btnEventi)
							.addGap(8))))
		);
		
		tableEventi = new JTable();
		tableEventi.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ospite", "Data", "OrarioInizio", "OrarioFine", "Supplemento", "Nome", "Cognome", "GenereMusicale", "IdLocale"
			}
		));
		scrollPane_4.setViewportView(tableEventi);
		panelEventi.setLayout(gl_panelEventi);
		
		JPanel panelClienti = new JPanel();
		tabbedPane.addTab("Clienti", null, panelClienti, null);
		
		JButton btnClienti = new JButton("Visualizza Clienti");
		btnClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Cliente> clienti = controller.findAllClienti();
				DefaultTableModel model = (DefaultTableModel) tableClienti.getModel();
				model.setRowCount(0);
				clienti.forEach(d ->{
					model.addRow(new Object[] {
							d.getCF(), d.getNome(), d.getCognome(), d.getDataNascita(), d.getEmail(), d.getTelefono(), d.getIdLocale()
					});
				});
			}
		});
		
		JButton btnRegistraCliente = new JButton("Registra");
		btnRegistraCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cli = new Cliente();
				cli.setCF(txtCf.getText());
				cli.setNome(txtNome_1.getText());
				cli.setCognome(txtCognome.getText());
				Date date = Date.valueOf(txtDataDiNascita.getText());
				cli.setDataNascita(date);
				cli.setEmail(txtEmail.getText());
				cli.setTelefono(txtTelefono.getText());
				cli.setIdLocale(Integer.parseInt(txtIdlocale_1.getText()));
				
				controller.insertCliente(cli);
			}
		});
		
		txtNome_1 = new JTextField();
		txtNome_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtNome_1.setText("Nome");
		txtNome_1.setColumns(10);
		
		txtCognome = new JTextField();
		txtCognome.setHorizontalAlignment(SwingConstants.CENTER);
		txtCognome.setText("Cognome");
		txtCognome.setColumns(10);
		
		txtCf = new JTextField();
		txtCf.setHorizontalAlignment(SwingConstants.CENTER);
		txtCf.setText("CF");
		txtCf.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setText("E-mail");
		txtEmail.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefono.setText("Telefono");
		txtTelefono.setColumns(10);
		
		txtDataDiNascita = new JTextField();
		txtDataDiNascita.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataDiNascita.setText("Data di Nascita");
		txtDataDiNascita.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("N\u00B0 Clienti :");
		
		scrollPane_1 = new JScrollPane();
		
		txtIdlocale_1 = new JTextField();
		txtIdlocale_1.setText("IdLocale");
		txtIdlocale_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdlocale_1.setColumns(10);
		
		JLabel lblNClienti = new JLabel("");
		lblNClienti.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panelClienti = new GroupLayout(panelClienti);
		gl_panelClienti.setHorizontalGroup(
			gl_panelClienti.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelClienti.createSequentialGroup()
					.addGroup(gl_panelClienti.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelClienti.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelClienti.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panelClienti.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panelClienti.createSequentialGroup()
										.addGap(11)
										.addComponent(btnRegistraCliente, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addGap(32))
									.addGroup(gl_panelClienti.createSequentialGroup()
										.addGroup(gl_panelClienti.createParallelGroup(Alignment.TRAILING)
											.addComponent(txtNome_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
											.addComponent(txtDataDiNascita, Alignment.LEADING, 124, 124, Short.MAX_VALUE)
											.addComponent(txtTelefono, Alignment.LEADING, 124, 124, Short.MAX_VALUE)
											.addComponent(txtEmail, Alignment.LEADING, 124, 124, Short.MAX_VALUE)
											.addComponent(txtCf, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
											.addComponent(btnClienti, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
											.addComponent(txtCognome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
											.addComponent(txtIdlocale_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
										.addGap(11))))
							.addGroup(gl_panelClienti.createSequentialGroup()
								.addGap(47)
								.addComponent(lblNClienti)
								.addGap(103)))
						.addGroup(gl_panelClienti.createSequentialGroup()
							.addGap(27)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelClienti.setVerticalGroup(
			gl_panelClienti.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelClienti.createSequentialGroup()
					.addGroup(gl_panelClienti.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelClienti.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
						.addGroup(gl_panelClienti.createSequentialGroup()
							.addGap(28)
							.addComponent(txtNome_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtCognome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtCf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtDataDiNascita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtIdlocale_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(btnRegistraCliente)
							.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
							.addComponent(lblNClienti)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel)
							.addGap(24)
							.addComponent(btnClienti)))
					.addContainerGap())
		);
		
		tableClienti = new JTable();
		tableClienti.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CF", "Nome", "Cognome", "Data Nascita", "Email", "Telefono", "IdLocale"
			}
		));
		scrollPane_1.setViewportView(tableClienti);
		panelClienti.setLayout(gl_panelClienti);
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 864, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_layeredPane.createSequentialGroup()
							.addComponent(lblTitolo, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addGap(355))))
		);
		gl_layeredPane.setVerticalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(23)
					.addComponent(lblTitolo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panelDipendenti = new JPanel();
		tabbedPane.addTab("Dipendenti", null, panelDipendenti, null);
		
		JButton btnDipendenti = new JButton("Visualizza Dipendenti");
		btnDipendenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Dipendente> dipendenti = controller.findAllDipendenti();
				DefaultTableModel model = (DefaultTableModel) tableDipendenti.getModel();
				model.setRowCount(0);
				dipendenti.forEach(d ->{
					model.addRow(new Object[] {
							d.getCF(), d.getNome(), d.getCognome(), d.getResidenza(), d.getDataNascita(), d.getTelefono(), d.getMansione(), d.getIdBar(), d.getIdLocale()
					});
				});
				
				//controller.findAllDipendenti());
				//tableDipendenti
			}
		});
		
		txtNome = new JTextField();
		txtNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtNome.setText("Nome");
		txtNome.setColumns(10);
		
		txtCognome_1 = new JTextField();
		txtCognome_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtCognome_1.setText("Cognome");
		txtCognome_1.setColumns(10);
		
		txtCf_1 = new JTextField();
		txtCf_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtCf_1.setText("CF");
		txtCf_1.setColumns(10);
		
		txtResidenza = new JTextField();
		txtResidenza.setHorizontalAlignment(SwingConstants.CENTER);
		txtResidenza.setText("Residenza");
		txtResidenza.setColumns(10);
		
		txtIdBar = new JTextField();
		txtIdBar.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdBar.setText("IdBar (opz.)");
		txtIdBar.setColumns(10);
		
		txtTelefono_1 = new JTextField();
		txtTelefono_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefono_1.setText("Telefono");
		txtTelefono_1.setColumns(10);
		
		txtMansione = new JTextField();
		txtMansione.setHorizontalAlignment(SwingConstants.CENTER);
		txtMansione.setText("Mansione");
		txtMansione.setColumns(10);
		
		txtDataDiNascita_1 = new JTextField();
		txtDataDiNascita_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataDiNascita_1.setText("Data di Nascita");
		txtDataDiNascita_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Registra");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dipendente dip = new Dipendente();
				dip.setCF(txtCf_1.getText());
				dip.setNome(txtNome.getText());
				dip.setCognome(txtCognome_1.getText());
				dip.setResidenza(txtResidenza.getText());
				Date date = Date.valueOf(txtDataDiNascita_1.getText());
				dip.setDataNascita(date);
				dip.setTelefono(txtTelefono_1.getText());
				dip.setMansione(txtMansione.getText());
				dip.setIdLocale(Integer.parseInt(txtIdlocale.getText()));
				dip.setIdBar(Integer.parseInt(txtIdBar.getText()));
				
				controller.insertDipendente(dip);
			}
		});
		
		JScrollBar scrollBar = new JScrollBar();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		scrollPane = new JScrollPane();
		
		tableDipendenti = new JTable();
		scrollPane.setViewportView(tableDipendenti);
		tableDipendenti.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CF", "Nome", "Cognome", "Residenza", "Data Nascita", "Telefono", "Mansione", "IdBar", "IdLocale"
			}
		));
		
		txtIdlocale = new JTextField();
		txtIdlocale.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdlocale.setText("IdLocale");
		txtIdlocale.setColumns(10);
		GroupLayout gl_panelDipendenti = new GroupLayout(panelDipendenti);
		gl_panelDipendenti.setHorizontalGroup(
			gl_panelDipendenti.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDipendenti.createSequentialGroup()
					.addGroup(gl_panelDipendenti.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDipendenti.createSequentialGroup()
							.addGap(47)
							.addComponent(btnNewButton))
						.addGroup(gl_panelDipendenti.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_panelDipendenti.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtIdBar, Alignment.LEADING)
								.addComponent(txtIdlocale)
								.addComponent(txtMansione)
								.addComponent(txtCognome_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
								.addComponent(txtNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
								.addComponent(txtCf_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
								.addComponent(txtResidenza, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
								.addComponent(txtDataDiNascita_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
								.addComponent(btnDipendenti, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtTelefono_1, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
							.addGap(13)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE)
					.addGap(71)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelDipendenti.setVerticalGroup(
			gl_panelDipendenti.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelDipendenti.createSequentialGroup()
					.addGap(43)
					.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtCognome_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtCf_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtResidenza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtDataDiNascita_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtTelefono_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtMansione, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtIdlocale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtIdBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDipendenti)
					.addGap(19))
				.addGroup(gl_panelDipendenti.createSequentialGroup()
					.addGap(93)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelDipendenti.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelDipendenti.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelDipendenti.setLayout(gl_panelDipendenti);
		
		JPanel panelContratti = new JPanel();
		tabbedPane.addTab("Contratti", null, panelContratti, null);
		layeredPane.setLayout(gl_layeredPane);
	}
}
