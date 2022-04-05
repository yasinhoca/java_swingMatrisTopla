package matrisTopla;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class form1 extends JFrame {

	private JPanel contentPane;
	private JTable m1;
	private JTable m2;
	private JTable mt;
	int satir,sutun,alt,ust;
	DefaultTableModel m1model = new DefaultTableModel();
	DefaultTableModel m2model = new DefaultTableModel();
	DefaultTableModel mtmodel = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form1 frame = new form1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public form1() {
		setTitle("MATR\u0130S \u0130\u015ELEMLER\u0130");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sat\u0131r");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 58, 28);
		contentPane.add(lblNewLabel);
		
		JSpinner satirs = new JSpinner();
		satirs.setModel(new SpinnerNumberModel(3, 1, 20, 1));
		satirs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		satirs.setBounds(58, 9, 49, 28);
		contentPane.add(satirs);
		
		JLabel lblStun = new JLabel("S\u00FCtun");
		lblStun.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStun.setBounds(139, 11, 58, 28);
		contentPane.add(lblStun);
		
		JSpinner sutuns = new JSpinner();
		sutuns.setModel(new SpinnerNumberModel(3, 1, 20, 1));
		sutuns.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sutuns.setBounds(193, 10, 49, 28);
		contentPane.add(sutuns);
		
		JButton btnNewButton = new JButton("OLU\u015ETUR");
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(265, 10, 145, 28);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 225, 225);
		contentPane.add(scrollPane);
		
		m1 = new JTable();
		m1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(m1);
		m1.setTableHeader(null);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(245, 65, 223, 225);
		contentPane.add(scrollPane_1);
		
		m2 = new JTable();
		m2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_1.setViewportView(m2);
		m2.setTableHeader(null);
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(505, 65, 221, 225);
		contentPane.add(scrollPane_2);
		
		mt = new JTable();
		mt.setForeground(Color.RED);
		mt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_2.setViewportView(mt);
		mt.setTableHeader(null);
		
		JLabel lblNewLabel_1 = new JLabel("Aral\u0131k");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(505, 10, 45, 23);
		contentPane.add(lblNewLabel_1);
		
		JSpinner alts = new JSpinner();
		alts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		alts.setBounds(563, 10, 49, 27);
		contentPane.add(alts);
		
		JSpinner usts = new JSpinner();
		usts.setModel(new SpinnerNumberModel(new Integer(50), null, null, new Integer(1)));
		usts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usts.setBounds(622, 10, 49, 27);
		contentPane.add(usts);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				satir = (int)satirs.getValue();
				sutun = (int)sutuns.getValue();
				alt = (int)alts.getValue();
				ust = (int)usts.getValue();
				
				m1model.setColumnCount(sutun);
				m1model.setRowCount(satir);
				m2model.setColumnCount(sutun);
				m2model.setRowCount(satir);
				mtmodel.setColumnCount(sutun);
				mtmodel.setRowCount(satir);
							
				
				
				int[][] mt1=Matris.uret(satir, sutun, alt, ust);
				int[][] mt2=Matris.uret(satir, sutun, alt, ust);
				
				int i,j=0;
				
				for(i=0;i<satir;i++) {
					for(j=0;j<sutun;j++) {
						m1model.setValueAt(mt1[i][j], i, j);
						m2model.setValueAt(mt2[i][j], i, j);
						mtmodel.setValueAt(mt1[i][j]+mt2[i][j], i, j);
					}
				}

				m1.setModel(m1model);
				m2.setModel(m2model);
				mt.setModel(mtmodel);
				
			}
		});
	}
}
