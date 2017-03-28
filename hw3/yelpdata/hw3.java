package yelpdata;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLayeredPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.SwingConstants;

public class hw3 {

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hw3 window = new hw3();
					window.frmYelpUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public hw3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmYelpUI = new JFrame();
		frmYelpUI.setTitle("YELP_UI");
		frmYelpUI.setBounds(100, 100, 734, 726);
		frmYelpUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmYelpUI.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelBusiness = new JPanel();
		panelBusiness.setName("main_category");
		panelBusiness.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panelBusiness.setSize(new Dimension(50, 50));
		tabbedPane.addTab("Business", null, panelBusiness, null);
			panelBusiness.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setName("Main Category");
			scrollPane.setMaximumSize(new Dimension(200, 100));
			scrollPane.setViewportBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
			scrollPane.setSize(new Dimension(50, 100));
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panelBusiness.add(scrollPane);
			
			panelcat = new JPanel();
			panelcat.setMaximumSize(new Dimension(200, 300));
			panelcat.setSize(new Dimension(5, 10));
			panelcat.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			panelcat.setBounds(new Rectangle(0, 0, 50, 100));
			panelcat.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			scrollPane.setViewportView(panelcat);
			scrollPane.setBounds(10, 11, 200, 229);;
			panelcat.setLayout(new BoxLayout(panelcat, BoxLayout.Y_AXIS));
			
			JCheckBox chckbxCategory = new JCheckBox(mainCategories[0]);
			panelcat.add(chckbxCategory);
			
			JCheckBox cbMainCategory_1 = new JCheckBox(mainCategories[1]);
			panelcat.add(cbMainCategory_1);
			
			JCheckBox cbMainCategory_2 = new JCheckBox(mainCategories[2]);
			panelcat.add(cbMainCategory_2);
			
			JCheckBox cbMainCategory_3 = new JCheckBox(mainCategories[3]);
			panelcat.add(cbMainCategory_3);
			JCheckBox cbMainCategory_4 = new JCheckBox(mainCategories[4]);
			panelcat.add(cbMainCategory_4);
			JCheckBox cbMainCategory_5 = new JCheckBox(mainCategories[5]);
			panelcat.add(cbMainCategory_5);
			JCheckBox cbMainCategory_6 = new JCheckBox(mainCategories[6]);
			panelcat.add(cbMainCategory_6);
			JCheckBox cbMainCategory_7 = new JCheckBox(mainCategories[7]);
			panelcat.add(cbMainCategory_7);
			JCheckBox cbMainCategory_8 = new JCheckBox(mainCategories[8]);
			cbMainCategory_8.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panelcat.add(cbMainCategory_8);
			JCheckBox cbMainCategory_9 = new JCheckBox(mainCategories[9]);
			panelcat.add(cbMainCategory_9);
			JCheckBox cbMainCategory_10 = new JCheckBox(mainCategories[10]);
			panelcat.add(cbMainCategory_10);
			JCheckBox cbMainCategory_11 = new JCheckBox(mainCategories[11]);
			panelcat.add(cbMainCategory_11);
			JCheckBox cbMainCategory_12 = new JCheckBox(mainCategories[12]);
			panelcat.add(cbMainCategory_12);
			JCheckBox cbMainCategory_13 = new JCheckBox(mainCategories[13]);
			panelcat.add(cbMainCategory_13);
			JCheckBox cbMainCategory_14 = new JCheckBox(mainCategories[14]);
			panelcat.add(cbMainCategory_14);
			JCheckBox cbMainCategory_15 = new JCheckBox(mainCategories[15]);
			panelcat.add(cbMainCategory_15);
			JCheckBox cbMainCategory_16 = new JCheckBox(mainCategories[16]);
			panelcat.add(cbMainCategory_16);
			JCheckBox cbMainCategory_17 = new JCheckBox(mainCategories[17]);
			panelcat.add(cbMainCategory_17);
			JCheckBox cbMainCategory_18 = new JCheckBox(mainCategories[18]);
			panelcat.add(cbMainCategory_18);
			JCheckBox cbMainCategory_19 = new JCheckBox(mainCategories[19]);
			panelcat.add(cbMainCategory_19);
			JCheckBox cbMainCategory_20 = new JCheckBox(mainCategories[20]);
			panelcat.add(cbMainCategory_20);
			JCheckBox cbMainCategory_21 = new JCheckBox(mainCategories[21]);
			panelcat.add(cbMainCategory_21);
			JCheckBox cbMainCategory_22 = new JCheckBox(mainCategories[22]);
			panelcat.add(cbMainCategory_22);
			JCheckBox cbMainCategory_23 = new JCheckBox(mainCategories[23]);
			panelcat.add(cbMainCategory_23);
			JCheckBox cbMainCategory_24 = new JCheckBox(mainCategories[24]);
			panelcat.add(cbMainCategory_24);
			JCheckBox cbMainCategory_25 = new JCheckBox(mainCategories[25]);
			panelcat.add(cbMainCategory_25);
			JCheckBox cbMainCategory_26 = new JCheckBox(mainCategories[26]);
			panelcat.add(cbMainCategory_26);
			JCheckBox cbMainCategory_27 = new JCheckBox(mainCategories[27]);
			panelcat.add(cbMainCategory_27);
			
			
			
			
			JButton btngetSub = new JButton(">>");
			btngetSub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getSubcategories(arg0);
				}
			});
			btngetSub.setBounds(219, 96, 60, 47);
			panelBusiness.add(btngetSub);
			
			JScrollPane scrollPanesub = new JScrollPane();
			scrollPanesub.setBounds(289, 11, 414, 229);
			panelBusiness.add(scrollPanesub);
			
			panelsub = new JPanel();
			panelsub.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			scrollPanesub.setViewportView(panelsub);
			GroupLayout gl_panelsub = new GroupLayout(panelsub);
			gl_panelsub.setHorizontalGroup(
				gl_panelsub.createParallelGroup(Alignment.LEADING)
					.addGap(0, 221, Short.MAX_VALUE)
			);
			gl_panelsub.setVerticalGroup(
				gl_panelsub.createParallelGroup(Alignment.LEADING)
					.addGap(0, 229, Short.MAX_VALUE)
			);
			panelsub.setLayout(gl_panelsub);
			
			JPanel panelCheckin = new JPanel();
			panelCheckin.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			panelCheckin.setBounds(10, 251, 233, 124);
			panelBusiness.add(panelCheckin);
			
			DropBox1 = new JComboBox<String>();
			DropBox1.addItem(">");
			DropBox1.addItem(">=");
			DropBox1.addItem("=");
			DropBox1.addItem("<");
			DropBox1.addItem("<=");
			DropBox1.setSelectedIndex(2);
			
			text_Vote = new JTextField();
			text_Vote.setColumns(10);
			
			JLabel lblFrom = new JLabel("From :");
			
			DropBox2 = new JComboBox<String>();
			DropBox2.setToolTipText("Day");
			DropBox2.addItem("Sun");
			DropBox2.addItem("Mon");
			DropBox2.addItem("Tue");
			DropBox2.addItem("Wed");
			DropBox2.addItem("Thur");
			DropBox2.addItem("Fri");
			DropBox2.addItem("Sat");
			DropBox2.setSelectedIndex(0);
			
			JLabel lblTo = new JLabel("To:");
			
			DropBox3 = new JComboBox<String>();
			DropBox3.setToolTipText("Day");
			DropBox3.addItem("Sun");
			DropBox3.addItem("Mon");
			DropBox3.addItem("Tue");
			DropBox3.addItem("Wed");
			DropBox3.addItem("Thur");
			DropBox3.addItem("Fri");
			DropBox3.addItem("Sat");
			DropBox3.setSelectedIndex(0);
			
			DropBox10 = new JComboBox<String>();
			DropBox10.setToolTipText("Hour");
			for (int i = 0; i<24; i++)
			{
				DropBox10.addItem(new Integer(i).toString());
			}
			DropBox11 = new JComboBox<String>();
			DropBox11.setToolTipText("Hour");
			for (int i = 0; i<24; i++)
			{
				DropBox11.addItem(new Integer(i).toString());
			}
			
			JLabel lblNewLabel = new JLabel("No. of Check ins");
			GroupLayout gl_panelCheckin = new GroupLayout(panelCheckin);
			gl_panelCheckin.setHorizontalGroup(
				gl_panelCheckin.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelCheckin.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelCheckin.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panelCheckin.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addGap(17))
							.addGroup(gl_panelCheckin.createSequentialGroup()
								.addGroup(gl_panelCheckin.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblTo)
									.addComponent(lblFrom))
								.addGap(18)))
						.addGroup(gl_panelCheckin.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelCheckin.createSequentialGroup()
								.addGap(1)
								.addComponent(DropBox1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panelCheckin.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelCheckin.createParallelGroup(Alignment.LEADING)
									.addComponent(DropBox2, 0, 50, Short.MAX_VALUE)
									.addComponent(DropBox3, 0, 50, Short.MAX_VALUE))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelCheckin.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelCheckin.createSequentialGroup()
								.addComponent(DropBox11, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap())
							.addGroup(gl_panelCheckin.createSequentialGroup()
								.addComponent(DropBox10, 0, 45, Short.MAX_VALUE)
								.addContainerGap())
							.addGroup(gl_panelCheckin.createSequentialGroup()
								.addComponent(text_Vote, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addGap(23))))
			);
			gl_panelCheckin.setVerticalGroup(
				gl_panelCheckin.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelCheckin.createSequentialGroup()
						.addGap(28)
						.addGroup(gl_panelCheckin.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelCheckin.createSequentialGroup()
								.addGroup(gl_panelCheckin.createParallelGroup(Alignment.BASELINE)
									.addComponent(DropBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(text_Vote, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(9)
								.addGroup(gl_panelCheckin.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblFrom)
									.addComponent(DropBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(DropBox10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelCheckin.createParallelGroup(Alignment.LEADING)
									.addComponent(DropBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(DropBox11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panelCheckin.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
								.addComponent(lblTo)
								.addGap(7)))
						.addGap(67))
			);
			panelCheckin.setLayout(gl_panelCheckin);
			JScrollPane scrollPaneSQLquery = new JScrollPane();
			scrollPaneSQLquery.setBounds(264, 251, 439, 103);
			panelBusiness.add(scrollPaneSQLquery);
			
			JPanel panelSQLquery = new JPanel();
			scrollPaneSQLquery.setViewportView(panelSQLquery);
			panelSQLquery.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			panelSQLquery.setLayout(null);
			
			JScrollPane scrollPaneSQLdisplay = new JScrollPane();
			scrollPaneSQLdisplay.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			scrollPaneSQLdisplay.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneSQLdisplay.setBounds(0, 0, 437, 101);
			panelSQLquery.add(scrollPaneSQLdisplay);
			
			
			textAreaSQLBusiness = new JTextArea();
			textAreaSQLBusiness.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			textAreaSQLBusiness.setLineWrap(true);
			textAreaSQLBusiness.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			textAreaSQLBusiness.setFont(new Font("Calibri", Font.ITALIC, 13));
			textAreaSQLBusiness.setEditable(false);
			textAreaSQLBusiness.setEnabled(false);
			textAreaSQLBusiness.setDisabledTextColor(Color.BLACK);
			scrollPaneSQLdisplay.setViewportView(textAreaSQLBusiness);
			
			JButton btnExecuteQuery = new JButton("Execute Query");
			btnExecuteQuery.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ExecuteBusinessQuery(arg0);
				}
			});
			btnExecuteQuery.setBounds(63, 620, 127, 28);
			panelBusiness.add(btnExecuteQuery);
			
			DropBox5 = new JComboBox<String>();
			DropBox5.setBounds(220, 154, 59, 28);
			panelBusiness.add(DropBox5);
			
			JPanel panelDisplay = new JPanel();
			panelDisplay.setBounds(266, 365, 437, 260);
			panelBusiness.add(panelDisplay);
			panelDisplay.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			panelDisplay.setLayout(null);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 11, 417, 212);
			panelDisplay.add(scrollPane_1);
			
			ResultBusiness = new JTable();
			ResultBusiness.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					BusinessSelect(arg0);
				}
			});
			scrollPane_1.setViewportView(ResultBusiness);
			
			
			lblBusinessName = new JLabel("Result");
			lblBusinessName.setLabelFor(ResultBusiness);
			lblBusinessName.setHorizontalTextPosition(SwingConstants.CENTER);
			lblBusinessName.setHorizontalAlignment(SwingConstants.CENTER);
			lblBusinessName.setBounds(10, 223, 417, 26);
			panelDisplay.add(lblBusinessName);
			
			JPanel panelStars = new JPanel();
			panelStars.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panelStars.setBounds(10, 386, 233, 38);
			panelBusiness.add(panelStars);
			panelStars.setLayout(null);
			
			DropBox4 = new JComboBox<String>();
			DropBox4.setBounds(105, 11, 50, 20);
			panelStars.add(DropBox4);
			DropBox4.addItem(">");
			DropBox4.addItem(">=");
			DropBox4.addItem("=");
			DropBox4.addItem("<");
			DropBox4.addItem("<=");
			DropBox4.setSelectedIndex(2);
			
			DropBoxReviewStars = new JComboBox<String>();
			DropBoxReviewStars.addItem(">");
			DropBoxReviewStars.addItem(">=");
			DropBoxReviewStars.addItem("=");
			DropBoxReviewStars.addItem("<");
			DropBoxReviewStars.addItem("<=");
			DropBoxReviewStars.setSelectedIndex(2);
			
			DropBoxVotes = new JComboBox<String>();
			
			DropBoxVotes.addItem(">");
			DropBoxVotes.addItem(">=");
			DropBoxVotes.addItem("=");
			DropBoxVotes.addItem("<");
			DropBoxVotes.addItem("<=");
			DropBoxVotes.setSelectedIndex(2);
			
			
			
			JLabel lblStars = new JLabel("Stars");
			lblStars.setBounds(10, 14, 50, 14);
			panelStars.add(lblStars);
			
			text_Stars = new JTextField();
			text_Stars.setBounds(165, 11, 45, 20);
			panelStars.add(text_Stars);
			text_Stars.setColumns(10);
			
			JPanel panelReview = new JPanel();
			panelReview.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			panelReview.setBounds(10, 435, 246, 174);
			panelBusiness.add(panelReview);
			
			JLabel lblVotes = new JLabel("Votes");
			
			JLabel label_1 = new JLabel("To:");
			
			JLabel label_2 = new JLabel("From :");
			
			comboBoxFromYear = new JComboBox<String>();
			comboBoxFromYear.setToolTipText("Year");
		
			
			comboBoxToYear = new JComboBox<String>();
			comboBoxToYear.setToolTipText("Year");
			
			
			
			
			textField_Vote = new JTextField();
			textField_Vote.setColumns(10);
			
			DropBoxFromHour = new JComboBox<String>();
			DropBoxFromHour.setToolTipText("Month");
			
			DropBoxToMonth = new JComboBox<String>();
			DropBoxToMonth.setToolTipText("Month");
			
			JLabel label = new JLabel("Stars");
			
			
			
			
			textField_ReviewStars = new JTextField();
			textField_ReviewStars.setColumns(10);
			
			DropBoxFromDay = new JComboBox<String>();
			DropBoxFromDay.setToolTipText("day");
			
			DropBoxToDay = new JComboBox<String>();
			DropBoxToDay.setToolTipText("Day");
			GroupLayout gl_panelReview = new GroupLayout(panelReview);
			gl_panelReview.setHorizontalGroup(
				gl_panelReview.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelReview.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelReview.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelReview.createSequentialGroup()
								.addGroup(gl_panelReview.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelReview.createSequentialGroup()
										.addComponent(lblVotes)
										.addGap(18)
										.addComponent(DropBoxVotes, 0, 44, Short.MAX_VALUE))
									.addGroup(gl_panelReview.createSequentialGroup()
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(DropBoxReviewStars, 0, 42, Short.MAX_VALUE)))
								.addGap(37)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelReview.createParallelGroup(Alignment.LEADING)
									.addComponent(textField_ReviewStars, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
									.addComponent(textField_Vote, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
								.addGap(48))
							.addGroup(gl_panelReview.createSequentialGroup()
								.addGroup(gl_panelReview.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panelReview.createSequentialGroup()
										.addComponent(label_1)
										.addGap(33)
										.addComponent(comboBoxToYear, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(gl_panelReview.createSequentialGroup()
										.addComponent(label_2)
										.addGap(18)
										.addComponent(comboBoxFromYear, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelReview.createParallelGroup(Alignment.LEADING, false)
									.addComponent(DropBoxToMonth, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(DropBoxFromHour, 0, 52, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panelReview.createParallelGroup(Alignment.TRAILING)
									.addComponent(DropBoxToDay, 0, 51, Short.MAX_VALUE)
									.addComponent(DropBoxFromDay, Alignment.LEADING, 0, 51, Short.MAX_VALUE))))
						.addContainerGap())
			);
			gl_panelReview.setVerticalGroup(
				gl_panelReview.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panelReview.createSequentialGroup()
						.addGap(23)
						.addGroup(gl_panelReview.createParallelGroup(Alignment.BASELINE)
							.addComponent(label)
							.addComponent(DropBoxReviewStars, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_ReviewStars, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelReview.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblVotes)
							.addComponent(DropBoxVotes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_Vote, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelReview.createParallelGroup(Alignment.BASELINE)
							.addComponent(DropBoxFromDay, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_2)
							.addComponent(comboBoxFromYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(DropBoxFromHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelReview.createParallelGroup(Alignment.BASELINE)
							.addComponent(DropBoxToDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_1)
							.addComponent(comboBoxToYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(DropBoxToMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18))
			);
			panelReview.setLayout(gl_panelReview);

			
			DropBox5.addItem("OR");
			DropBox5.addItem("AND");
			
			JPanel panelUser = new JPanel();
			tabbedPane.addTab("User", null, panelUser, null);
			panelUser.setLayout(null);
			
			JPanel panelUserAttr = new JPanel();
			panelUserAttr.setBounds(10, 11, 200, 441);
			panelUser.add(panelUserAttr);
			panelUserAttr.setLayout(null);
			
			JLabel lblNoOfFriends = new JLabel("No. of Friends");
			lblNoOfFriends.setBounds(10, 112, 93, 14);
			panelUserAttr.add(lblNoOfFriends);
			
			DropBox7 = new JComboBox<String>();
			DropBox7.setBounds(20, 137, 67, 20);
			panelUserAttr.add(DropBox7);
			DropBox7.addItem(">");
			DropBox7.addItem(">=");
			DropBox7.addItem("=");
			DropBox7.addItem("<");
			DropBox7.addItem("<=");
			DropBox7.setSelectedIndex(2);
			
			text_Friends = new JTextField();
			text_Friends.setBounds(97, 137, 61, 20);
			panelUserAttr.add(text_Friends);
			text_Friends.setColumns(10);
			
			JLabel lblAverageStars = new JLabel("Average Stars");
			lblAverageStars.setBounds(10, 182, 93, 14);
			panelUserAttr.add(lblAverageStars);
			
			DropBox8 = new JComboBox<String>();
			DropBox8.setBounds(20, 207, 67, 20);
			panelUserAttr.add(DropBox8);
			DropBox8.addItem(">");
			DropBox8.addItem(">=");
			DropBox8.addItem("=");
			DropBox8.addItem("<");
			DropBox8.addItem("<=");
			DropBox8.setSelectedIndex(2);
			
			textAvgStar = new JTextField();
			textAvgStar.setBounds(97, 207, 61, 20);
			panelUserAttr.add(textAvgStar);
			textAvgStar.setColumns(10);
			
			JLabel lblNoOfReviews = new JLabel("No. of Reviews");
			lblNoOfReviews.setBounds(10, 256, 93, 14);
			panelUserAttr.add(lblNoOfReviews);
			
			text_Reviewno = new JTextField();
			text_Reviewno.setBounds(97, 281, 61, 20);
			panelUserAttr.add(text_Reviewno);
			text_Reviewno.setColumns(10);
			
			DropBox9 = new JComboBox<String>();
			DropBox9.setBounds(20, 281, 67, 20);
			panelUserAttr.add(DropBox9);
			DropBox9.addItem(">");
			DropBox9.addItem(">=");
			DropBox9.addItem("=");
			DropBox9.addItem("<");
			DropBox9.addItem("<=");
			DropBox9.setSelectedIndex(2);
			
			JLabel lblMemberSince = new JLabel("Member Since ");
			lblMemberSince.setBounds(10, 347, 93, 14);
			panelUserAttr.add(lblMemberSince);
			
			 DropBoxYear = new JComboBox<String>();
			DropBoxYear.setBounds(81, 372, 77, 24);
			panelUserAttr.add(DropBoxYear);
			for(int i = 0; i <16; i++)
			{
			DropBoxYear.addItem(new Integer(2000+i).toString());
			}
			
			for(int i = 0; i <=16; i++)
			{
			comboBoxFromYear.addItem(new Integer(2000+i).toString());
			}
			for(int i = 0; i <=16; i++)
			{
			comboBoxToYear.addItem(new Integer(2000+i).toString());
			}
			
			
			DropBoxMonth = new JComboBox<String>();
			DropBoxMonth.setBounds(20, 372, 51, 24);
			panelUserAttr.add(DropBoxMonth);
			
			
			DropBox12 = new JComboBox<String>();
			DropBox12.setBounds(67, 53, 61, 29);
			panelUserAttr.add(DropBox12);
			DropBoxMonth.addItem("01");
			DropBoxMonth.addItem("02");
			DropBoxMonth.addItem("03");
			DropBoxMonth.addItem("04");
			DropBoxMonth.addItem("05");
			DropBoxMonth.addItem("06");
			DropBoxMonth.addItem("07");
			DropBoxMonth.addItem("08");
			DropBoxMonth.addItem("09");
			DropBoxMonth.addItem("10");
			DropBoxMonth.addItem("11");			
			DropBoxMonth.addItem("12");
			
			DropBoxFromHour.addItem("01");
			DropBoxFromHour.addItem("02");
			DropBoxFromHour.addItem("03");
			DropBoxFromHour.addItem("04");
			DropBoxFromHour.addItem("05");
			DropBoxFromHour.addItem("06");
			DropBoxFromHour.addItem("07");
			DropBoxFromHour.addItem("08");
			DropBoxFromHour.addItem("09");
			DropBoxFromHour.addItem("10");
			DropBoxFromHour.addItem("11");			
			DropBoxFromHour.addItem("12");
			
			DropBoxToMonth.addItem("01");
			DropBoxToMonth.addItem("02");
			DropBoxToMonth.addItem("03");
			DropBoxToMonth.addItem("04");
			DropBoxToMonth.addItem("05");
			DropBoxToMonth.addItem("06");
			DropBoxToMonth.addItem("07");
			DropBoxToMonth.addItem("08");
			DropBoxToMonth.addItem("09");
			DropBoxToMonth.addItem("10");
			DropBoxToMonth.addItem("11");			
			DropBoxToMonth.addItem("12");
			
			DropBoxToDay.addItem("01");
			DropBoxToDay.addItem("02");
			DropBoxToDay.addItem("03");
			DropBoxToDay.addItem("04");
			DropBoxToDay.addItem("05");
			DropBoxToDay.addItem("06");
			DropBoxToDay.addItem("07");
			DropBoxToDay.addItem("08");
			DropBoxToDay.addItem("09");
			DropBoxToDay.addItem("10");
			DropBoxToDay.addItem("11");			
			DropBoxToDay.addItem("12");			
			DropBoxToDay.addItem("13");
			DropBoxToDay.addItem("14");
			DropBoxToDay.addItem("15");
			DropBoxToDay.addItem("16");
			DropBoxToDay.addItem("17");
			DropBoxToDay.addItem("18");
			DropBoxToDay.addItem("19");
			DropBoxToDay.addItem("20");
			DropBoxToDay.addItem("21");
			DropBoxToDay.addItem("22");
			DropBoxToDay.addItem("23");			
			DropBoxToDay.addItem("24");
			DropBoxToDay.addItem("25");
			DropBoxToDay.addItem("26");
			DropBoxToDay.addItem("27");
			DropBoxToDay.addItem("28");
			DropBoxToDay.addItem("29");
			DropBoxToDay.addItem("30");
			DropBoxToDay.addItem("31");
			
			DropBoxFromDay.addItem("01");
			DropBoxFromDay.addItem("02");
			DropBoxFromDay.addItem("03");
			DropBoxFromDay.addItem("04");
			DropBoxFromDay.addItem("05");
			DropBoxFromDay.addItem("06");
			DropBoxFromDay.addItem("07");
			DropBoxFromDay.addItem("08");
			DropBoxFromDay.addItem("09");
			DropBoxFromDay.addItem("10");
			DropBoxFromDay.addItem("11");			
			DropBoxFromDay.addItem("12");			
			DropBoxFromDay.addItem("13");
			DropBoxFromDay.addItem("14");
			DropBoxFromDay.addItem("15");
			DropBoxFromDay.addItem("16");
			DropBoxFromDay.addItem("17");
			DropBoxFromDay.addItem("18");
			DropBoxFromDay.addItem("19");
			DropBoxFromDay.addItem("20");
			DropBoxFromDay.addItem("21");
			DropBoxFromDay.addItem("22");
			DropBoxFromDay.addItem("23");			
			DropBoxFromDay.addItem("24");
			DropBoxFromDay.addItem("25");
			DropBoxFromDay.addItem("26");
			DropBoxFromDay.addItem("27");
			DropBoxFromDay.addItem("28");
			DropBoxFromDay.addItem("29");
			DropBoxFromDay.addItem("30");
			DropBoxFromDay.addItem("31");
			
			
			comboBoxFromYear.setSelectedIndex(0);
			comboBoxToYear.setSelectedIndex(16);
			DropBoxFromHour.setSelectedIndex(0);
			DropBoxToMonth.setSelectedIndex(11);
			DropBoxFromDay.setSelectedIndex(0);
			DropBoxToDay.setSelectedIndex(30);
			
			DropBox12.addItem("AND");
			DropBox12.addItem("OR");
			
			JScrollPane scrollPaneSql = new JScrollPane();
			scrollPaneSql.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneSql.setBounds(220, 11, 446, 115);
			panelUser.add(scrollPaneSql);
			
			
			textSqlQuery2 = new JTextArea();
			textSqlQuery2.setDisabledTextColor(Color.BLACK);
			textSqlQuery2.setForeground(Color.BLACK);
			textSqlQuery2.setLineWrap(true);
			textSqlQuery2.setFont(new Font("Calibri", Font.ITALIC, 13));
			textSqlQuery2.setEditable(false);
			scrollPaneSql.setViewportView(textSqlQuery2);
			
			JScrollPane scrollPaneDisplay2 = new JScrollPane();
			scrollPaneDisplay2.setBounds(220, 137, 446, 316);
			panelUser.add(scrollPaneDisplay2);
			
			JPanel panelDisplay2 = new JPanel();
			scrollPaneDisplay2.setViewportView(panelDisplay2);
			panelDisplay2.setLayout(null);
			
			JScrollPane scrollPaneResultUser = new JScrollPane();
			scrollPaneResultUser.setBounds(10, 11, 424, 256);
			panelDisplay2.add(scrollPaneResultUser);
			
			Resultuser = new JTable();
			Resultuser.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					UserSelected(e);
				}
			});
			scrollPaneResultUser.setViewportView(Resultuser);
			
			
			lblUserName = new JLabel("Result");
			lblUserName.setHorizontalTextPosition(SwingConstants.CENTER);
			lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
			lblUserName.setBounds(10, 271, 424, 32);
			panelDisplay2.add(lblUserName);
			
			JButton btnNewButton = new JButton("Execute Query");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ExecuteUserQuery(arg0);
				}
			});
			btnNewButton.setBounds(178, 497, 145, 36);
			panelUser.add(btnNewButton);
			
			
			
	}
	
	 protected void UserSelected(MouseEvent e) {
		// TODO Auto-generated method stub
		 String userName = (String) Resultuser.getValueAt(Resultuser.getSelectedRow(), 1);
		 String YID = (String) Resultuser.getValueAt(Resultuser.getSelectedRow(), 3);
		 String rQuery = "select r.DATE_OF_REVIEW as \"Date\", r.TEXT as \"Reviews\", b.NAME as \"Business\"  from   REVIEW r, BUSINESS b where r.BUSINESS_ID = b.BUSINESS_ID and r.USER_ID = '" + YID+"'";
		 Connection con = null;
	        try {
	            con = SQLConnection();
	            textSqlQuery2.setText(rQuery);
	            PreparedStatement stmt = null;
	           	stmt = con.prepareStatement(rQuery);
			
			ResultSet rs = stmt.executeQuery();
			DefaultTableModel model = null;
			String str;
			
			  if (rs.next()){
	              ResultSetMetaData rsmd = rs.getMetaData();
	          model = new DefaultTableModel();
	          model.setColumnCount(rsmd.getColumnCount());
	          Vector<String> cols = new Vector<String>();
	          for (int i = 0; i < rsmd.getColumnCount(); i++) {
	              cols.add(rsmd.getColumnName(i + 1));
	          }
	          model.setColumnIdentifiers(cols);
	          do {
	              cols = new Vector<String>();
	              
	              for (int i = 0; i < rsmd.getColumnCount(); i++) {
	            	  str = rs.getString(rsmd.getColumnName(i+1));
	                  cols.add(str);
	              }
	              model.addRow(cols);
	              
	          }while(rs.next());
			  }
			  Resultuser.setModel(model);
			  lblUserName.setText(userName + "'s reviews");
			  Resultuser.setRowSelectionAllowed(false);
			  Resultuser.setCellSelectionEnabled(false);
			}catch( SQLException e1)
	              {
	            	  e1.printStackTrace();
	              }	        
		 lblBusinessName.setText(userName + "Reviews");		
	}

	protected void BusinessSelect(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(!flagReviewtableup)
		{
		String bName = (String) ResultBusiness.getValueAt(ResultBusiness.getSelectedRow(), 5);
		 String bID = (String) ResultBusiness.getValueAt(ResultBusiness.getSelectedRow(), 0);
		 String rQuery = "select r.DATE_OF_REVIEW as \"Date\", r.TEXT as \"Reviews\", r.STARS as \"Stars\", u.NAME as \"Author\"  from review r, users u where r.USER_ID = u.USER_ID and r.BUSINESS_ID = '" + bID+"'";
		 Connection con = null;
		 textAreaSQLBusiness.setText(rQuery);
	        try {
	            con = SQLConnection();
	            PreparedStatement stmt;	
	      	stmt = con.prepareStatement(rQuery);
			
			ResultSet rs = stmt.executeQuery();
			DefaultTableModel model = null;
			
			  while (rs.next()){
	          ResultSetMetaData rsmd = rs.getMetaData();
	          model = new DefaultTableModel();
	          model.setColumnCount(rsmd.getColumnCount());
	          Vector<String> cols = new Vector<String>();
	          for (int i = 0; i < rsmd.getColumnCount(); i++) {
	              cols.add(rsmd.getColumnName(i + 1));
	          }
	          model.setColumnIdentifiers(cols);
	          do{
	              cols = new Vector<String>();
	              for (int i = 0; i < rsmd.getColumnCount(); i++) {
	                  cols.add(rs.getString(rsmd.getColumnName(i + 1)));
	              }
	              model.addRow(cols);
	          }while (rs.next()) ;
			  }
			  ResultBusiness.setModel(model);
			  ResultBusiness.setRowSelectionAllowed(false);
			  ResultBusiness.setCellSelectionEnabled(false);
			  flagReviewtableup = true;

			}catch( SQLException e1)
	              {
	            	  e1.printStackTrace();
	              }
	        
		 lblBusinessName.setText(bName);
		 
		  
		}
	}

	protected void ExecuteUserQuery(ActionEvent arg0) {
		// TODO Auto-generated method stub
		 String operatorFriends = null;
		 String noOfFriends = null;
		 String operatorStars = null;
		 String noOfStars = null;
		 String operatorReviews = null;
		 String noOfReviews = null;
		 String year = null;
		 String month = null;
		operatorFriends = DropBox7.getSelectedItem().toString();
		 noOfFriends = text_Friends.getText();
		 operatorStars = DropBox8.getSelectedItem().toString();
		 noOfStars = textAvgStar.getText();
		 operatorReviews = DropBox9.getSelectedItem().toString();
		 noOfReviews = text_Reviewno.getText();
		 year = DropBoxYear.getSelectedItem().toString();
		 month = DropBoxMonth.getSelectedItem().toString();
		 String operator = DropBox12.getSelectedItem().toString();
		 try{
			  String yelping_since = year+"-"+month;
			  BigDecimal count = new BigDecimal(noOfReviews);
			 BigDecimal star =new BigDecimal(noOfStars);
			 BigDecimal friends_count=new BigDecimal(noOfFriends);
			
			if(!noOfReviews.isEmpty() && !noOfStars.isEmpty() && !noOfFriends.isEmpty())
			{
			String query1 = null;
			query1 = "SELECT * from  USERS WHERE to_char((YELPING_SINCE),'YYYY-MM') "+"> "+"'"+yelping_since+"' " + operator +" REVIEW_COUNT "+operatorReviews+" '"
			  +count+"' "+ operator  + " AVERAGE_STARS "+operatorStars+" '"+star+"' " + operator+ " FRIENDS_COUNT "+operatorFriends+" '"+friends_count+"'";
			    System.out.println(query1);
			    textSqlQuery2.setText(query1);
			    Connection con = SQLConnection();
			    PreparedStatement stmt = con.prepareStatement(query1);
			    ResultSet rs = stmt.executeQuery();
			    DefaultTableModel model = new DefaultTableModel();
			    while(rs.next()){			       
			      ResultSetMetaData rsmd = rs.getMetaData();
			            
			            model.setColumnCount(rsmd.getColumnCount());
			            Vector<String> cols = new Vector<String>();
			            for (int i = 0; i < rsmd.getColumnCount(); i++) {
			                cols.add(rsmd.getColumnName(i + 1));
			            }
			            model.setColumnIdentifiers(cols);
			            do {
			                cols = new Vector<String>();
			                for (int i = 0; i < rsmd.getColumnCount(); i++) {
			                    cols.add(rs.getString(rsmd.getColumnName(i + 1)));
			                }
			                model.addRow(cols);
			            }while (rs.next());
			            Resultuser.setModel(model);
			            Resultuser.setRowSelectionAllowed(true);
			   
			        }
			        
			 }
		 }catch (SQLException ex) {
			            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
			        
			        } 
		 
		 DropBox7.setSelectedIndex(2);
		 DropBox8.setSelectedIndex(2);
		 DropBox9.setSelectedIndex(2);
		 text_Friends.setText("");
		 text_Reviewno.setText("");
		 textAvgStar.setText("");

		
	}

	protected void ExecuteBusinessQuery(ActionEvent arg0){
		// TODO Auto-generated method stub
		 ArrayList<String> categoryList = new ArrayList<String>();
		 ArrayList<String> subcategoryList = new ArrayList<String>(); 
		 
		 for(Component c : panelcat.getComponents())
		 {
			 if (c.getClass().equals(JCheckBox.class)) {
                 JCheckBox jcb = (JCheckBox) c;
                 if (jcb.isSelected()) {
                     categoryList.add(jcb.getText());
                     flagCat = false;
                 }
			 	}
			 
		 }
		 if(categoryList.isEmpty()){
			 flagCat = true;
		 }
		 
		 for(Component c : panelsub.getComponents())
		 {
			 if (c.getClass().equals(JCheckBox.class)) {
                 JCheckBox jscb = (JCheckBox) c;
                 if (jscb.isSelected()) {
                     subcategoryList.add(jscb.getText().substring(0, jscb.getText().length()-1 ));
                     flagCat = false;
                 }
			 	}
			 
		 }
		 String noOfVotes = null;
		 noOfVotes= text_Vote.getText();
		 String operVotes = null;
		 String operatorStars = null;
		 operVotes = DropBox1.getSelectedItem().toString();
		 operatorStars = DropBox4.getSelectedItem().toString();
		 int dayFrom;
		 int dayTo;
		 String noOfStars = null;
		 noOfStars = text_Stars.getText();
		 dayFrom = DropBox2.getSelectedIndex();
		 dayTo = DropBox3.getSelectedIndex();
		 int HourFrom;
		 String operator = DropBox5.getSelectedItem().toString();
		 HourFrom = (int)Integer.parseInt(DropBox10.getSelectedItem().toString());
		 int HourTo;
		 HourTo = (int)Integer.parseInt(DropBox11.getSelectedItem().toString());
		 if((DropBox2.getSelectedIndex() < DropBox3.getSelectedIndex()) || (DropBox2.getSelectedIndex() == DropBox3.getSelectedIndex() && DropBox10.getSelectedIndex() < DropBox11.getSelectedIndex()))
			 flagCheckin = true;
		 else
			 flagCheckin = false;
		 if(noOfVotes.isEmpty())
			 flagCheckin = true;
		 else
			 flagCheckin = false;
		 if(noOfStars.isEmpty())
			 flagStar  = true;
		 else
			 flagStar = false;
		 if(textField_ReviewStars.getText().isEmpty() && text_Vote.getText().isEmpty() && ((comboBoxFromYear.getSelectedIndex() < comboBoxToYear.getSelectedIndex()) || (comboBoxFromYear.getSelectedIndex() == comboBoxToYear.getSelectedIndex() && DropBoxFromHour.getSelectedIndex() < DropBoxToMonth.getSelectedIndex())))
			 flagReview  = true;
		 else
			 flagReview = false;
		 
		 
		 
		 String Query = null;
		 Query = "SELECT * FROM BUSINESS WHERE ";
		 
		 if(!flagStar)
		 {
			 Query += "STARS " + operatorStars + " " + noOfStars + " "; 
		 }
		 
		 
		 if(!flagCat)
		 {
			 if(!flagStar)
			 {
				 Query += operator +" ";
			 }
			 Query = Query + "BUSINESS_ID IN (SELECT BUSINESS_ID FROM BUSINESS_CAT_SUB WHERE ";
		 
			 if (categoryList.size() > 0) {
				 
				 for (int i = 0; i < categoryList.size(); i++) {
		                if (i == categoryList.size() - 1 && subcategoryList.isEmpty()) {
		                    Query = Query + " CATEGORY_NAME = '" + categoryList.get(i) + "' ";
		                } else {
		                    Query = Query + " CATEGORY_NAME = '" + categoryList.get(i) + "' " + operator + " ";
		                }
		            }
				 
		 }
			 if (subcategoryList.size() > 0) {
				 	 for (int i = 0; i < subcategoryList.size(); i++) {
		                if (i == subcategoryList.size() - 1) {
		                    Query = Query + " SUB_CATEGORY_NAME = '" + subcategoryList.get(i) + "' ";
		                } else {
		                    Query = Query + " SUB_CATEGORY_NAME = '" + subcategoryList.get(i) + "' " + operator + " ";
		                }
		            }		 
		 }
			 
		}
		if(!flagCheckin)
		{
			if(!flagCat)
			{
				Query += " UNION ";
			}
			else 
			{
				if(!flagStar)
				{
					Query += operator;
				}
				Query += " BUSINESS_ID IN ( "; 
			}
			
			Query += "SELECT BUSINESS_ID FROM CHECK_IN WHERE ";
			
				Float floatFrom = dayFrom + HourFrom/24F;
				Float floatTo = dayTo + HourTo/24F;
				
				Query += "DAYANDTIME >= " + floatFrom.toString() + " AND DAYANDTIME <= " + floatTo.toString(); 
				if(!noOfVotes.isEmpty())
					Query += " AND IN_COUNT " + operVotes + text_Vote.getText() ;  
				
				}
	
		if(!flagReview)
		{
			if(!flagCat || !flagCheckin)
			{
				Query += " UNION ";
			}
			else 
			{
				if(!flagStar)
				{
					Query += operator;
				}
				Query += " BUSINESS_ID IN ( "; 
			}
			
			Query += "SELECT BUSINESS_ID FROM REVIEW WHERE ";
				if(!textField_ReviewStars.getText().isEmpty())
					Query += "STARS " + DropBoxReviewStars.getSelectedItem().toString() + " " +textField_ReviewStars.getText() + " AND ";
				if(!textField_Vote.getText().isEmpty())
					Query += "VOTES " + DropBoxVotes.getSelectedItem().toString() + " " +textField_Vote.getText() + " AND ";
				Query += "DATE_OF_REVIEW BETWEEN TO_DATE('" +comboBoxFromYear.getSelectedItem().toString()+"-"+DropBoxFromHour.getSelectedItem().toString()+"-"+DropBoxFromDay.getSelectedItem().toString()+"','YYYY-MM-DD') AND TO_DATE('" +comboBoxToYear.getSelectedItem().toString()+"-"+DropBoxFromHour.getSelectedItem().toString()+"-"+DropBoxToDay.getSelectedItem().toString()+"','YYYY-MM-DD')";  
				
				}
		if (!flagCat || !flagCheckin || !flagReview)
			Query += ")";
		textAreaSQLBusiness.setText("");
		textAreaSQLBusiness.setText(Query);
		DropBox1.setSelectedIndex(2);
		 DropBox2.setSelectedIndex(0);
		 DropBox3.setSelectedIndex(0);
		 DropBox4.setSelectedIndex(2);
		 DropBox10.setSelectedIndex(0);
		 DropBox11.setSelectedIndex(0);
		 text_Stars.setText("");
		 text_Vote.setText("");
		 textField_ReviewStars.setText("");
		 textField_Vote.setText("");
		 lblBusinessName.setText("Result");
		 for(Component c : panelcat.getComponents())
		 {
			 if (c.getClass().equals(JCheckBox.class)) {
                 JCheckBox jcb = (JCheckBox) c;
                 if (jcb.isSelected()) {
                     jcb.setSelected(false);
                     
                 }
			 	}
			 
		 }
		 
		panelsub.removeAll();
		panelsub.repaint();
		 flagCat = false;
		 flagCheckin = false;
		 flagStar = false;
		 Connection dbConnection = SQLConnection();
		PreparedStatement stmt;
		try {
			stmt = dbConnection.prepareStatement(Query);
			
		System.out.println(Query);
		
		ResultSet rs = stmt.executeQuery();
		
		  while (rs.next()){
              ResultSetMetaData rsmd = rs.getMetaData();
          DefaultTableModel model = new DefaultTableModel();
          model.setColumnCount(rsmd.getColumnCount());
          Vector<String> cols = new Vector<String>();
          for (int i = 0; i < rsmd.getColumnCount(); i++) {
              cols.add(rsmd.getColumnName(i + 1));
          }
          model.setColumnIdentifiers(cols);
          do {
              cols = new Vector<String>();
              for (int i = 0; i < rsmd.getColumnCount(); i++) {
                  cols.add(rs.getString(rsmd.getColumnName(i + 1)));
              }
              model.addRow(cols);
          }while (rs.next());
		  
          ResultBusiness.removeAll();
          ResultBusiness.setModel(model);
          ResultBusiness.setRowSelectionAllowed(true);
          ResultBusiness.repaint();
          flagReviewtableup = false;
         
     
          
 
      }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
   }
      

	public static Connection SQLConnection(){
		 Connection connection = null;
		 try {
			 DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection ("jdbc:oracle:thin:localhost:1521:orcl", databasename, databasepassword);
			 System.out.println("Connection Succesful");
			 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		 
		 
	 }

	protected void getSubcategories(java.awt.event.ActionEvent evt) {
		Connection con = null;
        try {
            con = SQLConnection();
            String sQuery = "";
            ArrayList<String> BusnSel = new ArrayList<String>();
            for (Component c : panelcat.getComponents()) {
                if (c.getClass().equals(javax.swing.JCheckBox.class)) {
                    JCheckBox jcb = (JCheckBox) c;
                    if (jcb.isSelected()) {
                        BusnSel.add(jcb.getText());
                    }
                }
            }
           sQuery = sQuery + "SELECT DISTINCT SUB_CATEGORY_NAME FROM BUSINESS_CAT_SUB WHERE ";
            for (int i = 0; i < BusnSel.size(); i++) {
                if (i == BusnSel.size() - 1) {
                    sQuery = sQuery + " CATEGORY_NAME = ?";
                } else {
                    sQuery = sQuery + " CATEGORY_NAME = ? OR";
                }
            }
            panelsub.removeAll();
            PreparedStatement ps = con.prepareStatement(sQuery);
            int iCtr = 1;
            for (String str : BusnSel) {
                ps.setString(iCtr, str);
                iCtr++;
            }
            ResultSet rs = ps.executeQuery();
            subCatList = new ArrayList<JCheckBox>();
            while (rs.next()) {
                String result = rs.getString(1) + "\n";
                JCheckBox newChBox = new JCheckBox();
                newChBox.setText(result);
                subCatList.add(newChBox);
            }
            panelsub.setLayout(new GridLayout(0, 2, 10, 10));
            for (JCheckBox ch : subCatList) {
                panelsub.add(ch);
                panelsub.revalidate();
                panelsub.repaint();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
	JFrame frmYelpUI;
	private String[] mainCategories = {"ActiveLife", "Arts '/&'Entertainment", "Automotive", "CarRental", "Cafes", "Beauty &Spas", "ConvenienceStores", "Dentists", "Doctors", "Drugstores", "DepartmentStores", "Education", "Event Planning &Services","Flowers &Gifts","Food","Health &Medical", "HomeServices", "Home &Garden", "Hospitals", "Hotels &Travel", "HardwareStores", "Grocery", "MedicalCenters", "Nurseries &Gardening", "Nightlife2", "Restaurants", "Shopping", "Transportation"};
	private JPanel panelcat;
	private JPanel panelsub;
	private ArrayList<JCheckBox> subCatList;
	private JRootPane rootPane;
	private JTextField text_Vote;
	private JTextField text_Stars;
	private JTextField text_Friends;
	private JTextField textAvgStar;
	private JTextField text_Reviewno;
	private JTable Resultuser;
	private boolean flagCat = true, flagCheckin = true, flagReview = true;
	private JComboBox<String> DropBox1;
	private JComboBox<String> DropBox2;
	private JComboBox<String> DropBox3;
	private JComboBox<String> DropBox4;
	private JComboBox<String> DropBox5;
	private JComboBox<String> DropBox7;
	private JComboBox<String> DropBox8;
	private JComboBox<String> DropBox9;
	private JComboBox<String> DropBox10;
	private JComboBox<String> DropBox11;
	private JComboBox<String> comboBoxFromYear;
	private JComboBox<String> DropBoxFromHour;
	private JComboBox<String> comboBoxToYear;
	private JComboBox<String> DropBoxToMonth;
	private boolean flagStar = true;
	private JTextArea textAreaSQLBusiness ;
	private JComboBox<String> DropBoxYear;
	private JComboBox<String> DropBoxMonth;
	private JTextArea textSqlQuery2;
	private JTable ResultBusiness;
	private JComboBox<String> DropBox12;
	private JLabel lblBusinessName;
	private JLabel lblUserName;
	private boolean flagReviewtableup = false;
	private JComboBox<String> DropBoxFromDay ;
	private JComboBox<String> DropBoxToDay ;
	

	private static String databasename = "kart";
	private static String databasepassword = "peace";
	private JTextField textField_Vote;
	private JTextField textField_ReviewStars;
	private JComboBox<String> DropBoxVotes;
	private JComboBox<String> DropBoxReviewStars;
}
