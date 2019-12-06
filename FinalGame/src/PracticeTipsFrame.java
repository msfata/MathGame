import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PracticeTipsFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnEnter;
	private JButton btnClear;
	protected  JTable table;
	protected  DefaultTableModel model;
	private JButton btnHide;
	private JButton button;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PracticeTipsFrame frame = new PracticeTipsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PracticeTipsFrame() {
		setType(Type.UTILITY);
		setBackground(Color.WHITE);
//		PracticeTipsFrame frame = new PracticeTipsFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		setBounds(1270, 0, width-1260,height-280);
		if(MathGameFinal.isSmallScreen) {//setBounds(0, 0, 1280, 800); tablete
			setBounds(0, 0, 1280,800);
		}else if(width==1920 && height==1080){
			setBounds(1270, 0, width-1260,height-280);
		}else {System.out.println("3");
			setBounds(0, 0, width,height);
		}
		
		
		
		
		
//		setBounds(1270, 0, 600, 1100);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.WHITE);
		//contentPane.setBorder(new TitledBorder(new CompoundBorder(new CompoundBorder(new LineBorder(new Color(153, 204, 204), 15), new LineBorder(new Color(204, 204, 255), 9)), new CompoundBorder(new LineBorder(new Color(204, 204, 204), 8), new LineBorder(new Color(204, 204, 255), 4))), "Contact : msfata@me.com      +447421110333", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(211, 211, 211)));
		//contentPane.setBorder(new TitledBorder(new CompoundBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 5), new LineBorder(new Color(204, 204, 255), 4)), new CompoundBorder(new LineBorder(new Color(191, 205, 219), 15), new LineBorder(new Color(204, 204, 255), 9))), "Contact : msfata@me.com      +447421110333", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(211, 211, 211)));
		//contentPane.setBorder(new TitledBorder(new CompoundBorder(new CompoundBorder(new LineBorder(new Color(102, 102, 102), 5), new LineBorder(new Color(153, 153, 153), 4)), new CompoundBorder(new LineBorder(new Color(119, 136, 153), 15), new LineBorder(new Color(230, 230, 250), 9))), "Contact : msfata@me.com      +447421110333", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(211, 211, 211)));
		contentPane.setBorder(new TitledBorder(new CompoundBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 204), 5), new LineBorder(new Color(255, 255, 153), 4)), new CompoundBorder(new LineBorder(new Color(255, 204, 102), 15), new LineBorder(new Color(255, 255, 51), 9))), "Contact : msfata@me.com      +447421110333", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(211, 211, 211)));
		
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(Color.WHITE, 2));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setBorder(new LineBorder(Color.WHITE));
		table.setRowHeight(27);
		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"FIRST NUMBER", "OPERATION", "SECOND NUMBER", "YOUR ANSWER", "CORRECT ANSWER"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		
//		table.getColumn("YOUR ANSWER").setCellRenderer(
//		        new DefaultTableCellRenderer() {
//		            /**
//					 * 
//					 */
//					private static final long serialVersionUID = 1L;
//
//					public Component getTableCellRendererComponent(JTable table, 
//		                                                           Object value, 
//		                                                           boolean isSelected, 
//		                                                           boolean hasFocus, 
//		                                                           int row, 
//		                                                           int column) {
//		                setText(value.toString());
//		                setBackground(isSelected ? Color.yellow : Color.RED);
//		                setFont(new Font("Tahoma", Font.PLAIN, 25));
//		                return this;
//		            }
//		        });
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnClear = new JButton("");
		btnClear.setHorizontalAlignment(SwingConstants.LEFT);
		btnClear.setBackground(Color.WHITE);
		btnClear.setIcon(new ImageIcon(PracticeTipsFrame.class.getResource("/controlButton/c (2).png")));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// model = (DefaultTableModel) table.getModel();
//				 model.setColumnCount(0);
				DefaultTableModel dm = (DefaultTableModel)table.getModel();
				dm.getDataVector().removeAllElements();
				dm.fireTableDataChanged();
				MathGameFinal.answer.requestFocus();
			}
		});
		btnClear.setBorder(null);
		panel.add(btnClear);
		
		btnEnter = new JButton("");
		btnEnter.setIcon(new ImageIcon(PracticeTipsFrame.class.getResource("/controlButton/button_exit1.png")));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				MathGameFinal.tfAnswer.requestFocus();
			    System.exit(0);
			}
		});
		btnEnter.setBackground(Color.WHITE);
		btnEnter.setBorder(null);
		
		button = new JButton("");
		button.setBackground(Color.WHITE);
		button.setBorder(null);
		panel.add(button);
		btnHide = new JButton("");
		btnHide.setIcon(new ImageIcon(PracticeTipsFrame.class.getResource("/controlButton/button_cancel1.png")));
		panel.add(btnHide);
		btnHide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MathGameFinal.answer.requestFocus();
				MathGameFinal.rf.dispose();
				MathGameFinal.tfResult.setText("");
				dispose();
			}
		});
		btnHide.setBorder(null);
		btnHide.setBackground(Color.WHITE);
		setAlwaysOnTop(true);
		panel.add(btnEnter);
		setUndecorated(true);
	}
	
}
