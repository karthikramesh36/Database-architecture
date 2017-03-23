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

public class hw31 {

	private JFrame frmYelpui;
	private String[] Categories_Main = {"ActiveLife", "Arts '/&'Entertainment", "Automotive", "CarRental", "Cafes", "Beauty &Spas", "ConvenienceStores", "Dentists", "Doctors", "Drugstores", "DepartmentStores", "Education", "Event Planning &Services","Flowers &Gifts","Food","Health &Medical", "HomeServices", "Home &Garden", "Hospitals", "Hotels &Travel", "HardwareStores", "Grocery", "MedicalCenters", "Nurseries &Gardening", "Nightlife2", "Restaurants", "Shopping", "Transportation"};
	private JPanel panelcategories;
	private JPanel SubCatPanel;
	private ArrayList<JCheckBox> subCatList;
	private JRootPane rootPane;
	private JTextField textboxVote;
	private JTextField textBoxStars;
	private JTextField textboxFriends;
	private JTextField textboxAvgStar;
	private JTextField textboxReviewno;
	private JTable Resultuser;
	private boolean flag_Category = true, flag_Checkin = true;
	private JComboBox<String> DopBox1;
	private JComboBox<String> DopBox2;
	private JComboBox<String> DopBox3;
	private JComboBox<String> DopBox4;
	private JComboBox<String> DopBox5;
	private JComboBox<String> DopBox7;
	private JComboBox<String> DopBox8;
	private JComboBox<String> DopBox9;
	private JComboBox<String> DopBox10;
	private JComboBox<String> DopBox11;
	private boolean flag_Star = true;
	private JTextArea textBoxAreaSQLBusiness ;
	private JComboBox<String> DopBoxYear;
	private JComboBox<String> DopBoxMonth;
	private JTextArea SqlQuery2text;
	private JTable ResultBusiness;
	private JComboBox<String> DopBox12;
	private JLabel labelBusinessResults;
	private JLabel labelUserResult;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hw31 window = new hw31();
					window.frmYelpui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public hw31() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmYelpui = new JFrame();
		frmYelpui.setTitle("YelpUI");
		frmYelpui.setForeground(Color.BLACK);
		frmYelpui.setBounds(100, 100, 734, 700);
		frmYelpui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmYelpui.getContentPane().add(tabbedPane, BorderLayout.CENTER);;
			for (int i = 0; i<24; i++)
			{
				DopBox10.addItem(new Integer(i).toString());
			}
			for (int i = 0; i<24; i++)
			{
				DopBox11.addItem(new Integer(i).toString());
			}

			/**/
			for(int i = 0; i <26; i++)
			{
			DopBoxYear.addItem(new Integer(1990+i).toString());
			}
			
			JPanel businesstabPanel = new JPanel();
			businesstabPanel.setOpaque(false);
			businesstabPanel.setForeground(Color.BLACK);
			businesstabPanel.setName("main_category");
			businesstabPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			businesstabPanel.setSize(new Dimension(50, 50));
			tabbedPane.addTab("Business", null, businesstabPanel, null);
			businesstabPanel.setLayout(null);
			
			JScrollPane scrollPane1 = new JScrollPane();
			scrollPane1.setName("Main Category");
			scrollPane1.setMaximumSize(new Dimension(200, 100));
			scrollPane1.setViewportBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
			scrollPane1.setSize(new Dimension(50, 100));
			scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			businesstabPanel.add(scrollPane1);
			
			panelcategories = new JPanel();
			panelcategories.setMaximumSize(new Dimension(200, 300));
			panelcategories.setSize(new Dimension(5, 10));
			panelcategories.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			panelcategories.setBounds(new Rectangle(0, 0, 50, 100));
			panelcategories.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			scrollPane1.setViewportView(panelcategories);
			scrollPane1.setBounds(10, 11, 233, 229);
			panelcategories.setLayout(new BoxLayout(panelcategories, BoxLayout.Y_AXIS));
			
			JCheckBox checkboxCategory = new JCheckBox(Categories_Main[0]);
			panelcategories.add(checkboxCategory);
			
			JCheckBox checkboxMainCategory_1 = new JCheckBox(Categories_Main[1]);
			panelcategories.add(checkboxMainCategory_1);
			
			JCheckBox checkboxMainCategory_2 = new JCheckBox(Categories_Main[2]);
			panelcategories.add(checkboxMainCategory_2);
			
			JCheckBox checkboxMainCategory_3 = new JCheckBox(Categories_Main[3]);
			panelcategories.add(checkboxMainCategory_3);
			JCheckBox checkboxMainCategory_4 = new JCheckBox(Categories_Main[4]);
			panelcategories.add(checkboxMainCategory_4);
			JCheckBox checkboxMainCategory_5 = new JCheckBox(Categories_Main[5]);
			panelcategories.add(checkboxMainCategory_5);
			JCheckBox checkboxMainCategory_6 = new JCheckBox(Categories_Main[6]);
			panelcategories.add(checkboxMainCategory_6);
			JCheckBox checkboxMainCategory_7 = new JCheckBox(Categories_Main[7]);
			panelcategories.add(checkboxMainCategory_7);
			JCheckBox checkboxMainCategory_8 = new JCheckBox(Categories_Main[8]);
			checkboxMainCategory_8.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panelcategories.add(checkboxMainCategory_8);
			JCheckBox checkboxMainCategory_9 = new JCheckBox(Categories_Main[9]);
			panelcategories.add(checkboxMainCategory_9);
			JCheckBox checkboxMainCategory_10 = new JCheckBox(Categories_Main[10]);
			panelcategories.add(checkboxMainCategory_10);
			JCheckBox checkboxMainCategory_11 = new JCheckBox(Categories_Main[11]);
			panelcategories.add(checkboxMainCategory_11);
			JCheckBox checkboxMainCategory_12 = new JCheckBox(Categories_Main[12]);
			panelcategories.add(checkboxMainCategory_12);
			JCheckBox checkboxMainCategory_13 = new JCheckBox(Categories_Main[13]);
			panelcategories.add(checkboxMainCategory_13);
			JCheckBox checkboxMainCategory_14 = new JCheckBox(Categories_Main[14]);
			panelcategories.add(checkboxMainCategory_14);
			JCheckBox checkboxMainCategory_15 = new JCheckBox(Categories_Main[15]);
			panelcategories.add(checkboxMainCategory_15);
			JCheckBox checkboxMainCategory_16 = new JCheckBox(Categories_Main[16]);
			panelcategories.add(checkboxMainCategory_16);
			JCheckBox checkboxMainCategory_17 = new JCheckBox(Categories_Main[17]);
			panelcategories.add(checkboxMainCategory_17);
			JCheckBox checkboxMainCategory_19 = new JCheckBox(Categories_Main[19]);
			panelcategories.add(checkboxMainCategory_19);
			JCheckBox checkboxMainCategory_18 = new JCheckBox(Categories_Main[18]);
			panelcategories.add(checkboxMainCategory_18);
			JCheckBox checkboxMainCategory_20 = new JCheckBox(Categories_Main[20]);
			panelcategories.add(checkboxMainCategory_20);
			JCheckBox checkboxMainCategory_21 = new JCheckBox(Categories_Main[21]);
			panelcategories.add(checkboxMainCategory_21);
			JCheckBox checkboxMainCategory_22 = new JCheckBox(Categories_Main[22]);
			panelcategories.add(checkboxMainCategory_22);
			JCheckBox checkboxMainCategory_23 = new JCheckBox(Categories_Main[23]);
			panelcategories.add(checkboxMainCategory_23);
			JCheckBox checkboxMainCategory_24 = new JCheckBox(Categories_Main[24]);
			panelcategories.add(checkboxMainCategory_24);
			JCheckBox checkboxMainCategory_25 = new JCheckBox(Categories_Main[25]);
			panelcategories.add(checkboxMainCategory_25);
			JCheckBox checkboxMainCategory_26 = new JCheckBox(Categories_Main[26]);
			panelcategories.add(checkboxMainCategory_26);
			JCheckBox checkboxMainCategory_27 = new JCheckBox(Categories_Main[27]);
			panelcategories.add(checkboxMainCategory_27);
			
			
			
			
			JButton buttonSubCat = new JButton("Get Subcategories");
			buttonSubCat.setActionCommand("");
			buttonSubCat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ShowSubCat(arg0);
				}
			});
			buttonSubCat.setBounds(253, 96, 135, 28);
			businesstabPanel.add(buttonSubCat);
			
			JScrollPane SubCategoriesScrollPane = new JScrollPane();
			SubCategoriesScrollPane.setBounds(398, 11, 307, 229);
			businesstabPanel.add(SubCategoriesScrollPane);
			
			SubCatPanel = new JPanel();
			SubCatPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			SubCategoriesScrollPane.setViewportView(SubCatPanel);
			GroupLayout gl_SubCatPanel = new GroupLayout(SubCatPanel);
			gl_SubCatPanel.setHorizontalGroup(
				gl_SubCatPanel.createParallelGroup(Alignment.LEADING)
					.addGap(0, 221, Short.MAX_VALUE)
			);
			gl_SubCatPanel.setVerticalGroup(
				gl_SubCatPanel.createParallelGroup(Alignment.LEADING)
					.addGap(0, 229, Short.MAX_VALUE)
			);
			SubCatPanel.setLayout(gl_SubCatPanel);
			
			JPanel checkinPanel = new JPanel();
			checkinPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			checkinPanel.setBounds(10, 313, 233, 198);
			businesstabPanel.add(checkinPanel);
			
			DopBox1 = new JComboBox<String>();
			DopBox1.addItem(">");
			DopBox1.addItem(">=");
			DopBox1.addItem("=");
			DopBox1.addItem("<");
			DopBox1.addItem("<=");
			DopBox1.setSelectedIndex(2);
			
			textboxVote = new JTextField();
			textboxVote.setColumns(10);
			
			JLabel labelFrom = new JLabel("From :");
			
			DopBox2 = new JComboBox<String>();
			DopBox2.setToolTipText("Day");
			DopBox2.addItem("Sun");
			DopBox2.addItem("Mon");
			DopBox2.addItem("Tue");
			DopBox2.addItem("Wed");
			DopBox2.addItem("Thur");
			DopBox2.addItem("Fri");
			DopBox2.addItem("Sat");
			DopBox2.setSelectedIndex(0);
			
			JLabel labelTo = new JLabel("To:");
			
			DopBox3 = new JComboBox<String>();
			DopBox3.setToolTipText("Day");
			DopBox3.addItem("Sun");
			DopBox3.addItem("Mon");
			DopBox3.addItem("Tue");
			DopBox3.addItem("Wed");
			DopBox3.addItem("Thur");
			DopBox3.addItem("Fri");
			DopBox3.addItem("Sat");
			DopBox3.setSelectedIndex(0);
			
			DopBox4 = new JComboBox<String>();
			DopBox4.addItem(">");
			DopBox4.addItem(">=");
			DopBox4.addItem("=");
			DopBox4.addItem("<");
			DopBox4.addItem("<=");
			DopBox4.setSelectedIndex(2);
			
			textBoxStars = new JTextField();
			textBoxStars.setColumns(10);
			
			DopBox10 = new JComboBox<String>();
			DopBox10.setToolTipText("Hour");
			DopBox11 = new JComboBox<String>();
			DopBox11.setToolTipText("Hour");
			
			JLabel labelNewLabelcheckin = new JLabel("No: of Check-ins");
			
			JLabel labelStars = new JLabel("Stars");
			GroupLayout gl_checkinPanel = new GroupLayout(checkinPanel);
			gl_checkinPanel.setHorizontalGroup(
				gl_checkinPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_checkinPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_checkinPanel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_checkinPanel.createSequentialGroup()
								.addComponent(labelNewLabelcheckin)
								.addGap(17))
							.addGroup(gl_checkinPanel.createSequentialGroup()
								.addGroup(gl_checkinPanel.createParallelGroup(Alignment.TRAILING)
									.addComponent(labelTo)
									.addComponent(labelStars)
									.addComponent(labelFrom))
								.addGap(18)))
						.addGroup(gl_checkinPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_checkinPanel.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_checkinPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(DopBox2, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(DopBox3, Alignment.LEADING, 0, 50, Short.MAX_VALUE)))
							.addComponent(DopBox4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_checkinPanel.createSequentialGroup()
								.addGap(1)
								.addComponent(DopBox1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_checkinPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textboxVote, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
							.addComponent(DopBox10, 0, 45, Short.MAX_VALUE)
							.addComponent(DopBox11, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textBoxStars, 0, 0, Short.MAX_VALUE))
						.addGap(23))
			);
			gl_checkinPanel.setVerticalGroup(
				gl_checkinPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_checkinPanel.createSequentialGroup()
						.addGap(28)
						.addGroup(gl_checkinPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_checkinPanel.createSequentialGroup()
								.addGroup(gl_checkinPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(DopBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(textboxVote, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(21)
								.addGroup(gl_checkinPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(DopBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(DopBox10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(labelFrom))
								.addGap(18)
								.addGroup(gl_checkinPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(DopBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(DopBox11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_checkinPanel.createSequentialGroup()
								.addComponent(labelNewLabelcheckin)
								.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
								.addComponent(labelTo)
								.addGap(7)))
						.addGap(11)
						.addGroup(gl_checkinPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(DopBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(labelStars)
							.addComponent(textBoxStars, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(36))
			);
			checkinPanel.setLayout(gl_checkinPanel);
			JScrollPane SQLqueryScrollPane = new JScrollPane();
			SQLqueryScrollPane.setBounds(10, 530, 695, 103);
			businesstabPanel.add(SQLqueryScrollPane);
			
			JPanel SQLqueryPanel = new JPanel();
			SQLqueryScrollPane.setViewportView(SQLqueryPanel);
			SQLqueryPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			SQLqueryPanel.setLayout(null);
			
			JScrollPane scrollPaneSQLdisplay = new JScrollPane();
			scrollPaneSQLdisplay.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			scrollPaneSQLdisplay.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneSQLdisplay.setBounds(-255, 0, 255, 101);
			SQLqueryPanel.add(scrollPaneSQLdisplay);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 2, 693, 99);
			SQLqueryPanel.add(scrollPane);
			
			
			textBoxAreaSQLBusiness = new JTextArea();
			scrollPane.setViewportView(textBoxAreaSQLBusiness);
			textBoxAreaSQLBusiness.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			textBoxAreaSQLBusiness.setLineWrap(true);
			textBoxAreaSQLBusiness.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			textBoxAreaSQLBusiness.setFont(new Font("Calibri", Font.ITALIC, 13));
			textBoxAreaSQLBusiness.setEditable(false);
			textBoxAreaSQLBusiness.setEnabled(false);
			textBoxAreaSQLBusiness.setDisabledTextColor(Color.BLACK);
			
			JButton ExecuteQuerybutton1 = new JButton("Execute Query");
			ExecuteQuerybutton1.setForeground(Color.BLUE);
			ExecuteQuerybutton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					BusinessQueryExecute(arg0);
				}
			});
			ExecuteQuerybutton1.setBounds(116, 265, 127, 28);
			businesstabPanel.add(ExecuteQuerybutton1);
			
			DopBox5 = new JComboBox<String>();
			DopBox5.setBounds(25, 265, 59, 28);
			businesstabPanel.add(DopBox5);
			
			JPanel BusResultsPanelDisplay = new JPanel();
			BusResultsPanelDisplay.setBounds(266, 251, 437, 260);
			businesstabPanel.add(BusResultsPanelDisplay);
			BusResultsPanelDisplay.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			BusResultsPanelDisplay.setLayout(null);
			
			JScrollPane BusResultsScrollPane_1 = new JScrollPane();
			BusResultsScrollPane_1.setBounds(10, 11, 417, 212);
			BusResultsPanelDisplay.add(BusResultsScrollPane_1);
			
			ResultBusiness = new JTable();
			ResultBusiness.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					OnClickBusiness(arg0);
				}
			});
			BusResultsScrollPane_1.setViewportView(ResultBusiness);
			
			
			labelBusinessResults = new JLabel("Output");
			labelBusinessResults.setLabelFor(ResultBusiness);
			labelBusinessResults.setHorizontalTextPosition(SwingConstants.CENTER);
			labelBusinessResults.setHorizontalAlignment(SwingConstants.CENTER);
			labelBusinessResults.setBounds(10, 223, 417, 26);
			BusResultsPanelDisplay.add(labelBusinessResults);
			
			JPanel userPanel = new JPanel();
			tabbedPane.addTab("User", null, userPanel, null);
			userPanel.setLayout(null);
			
			JPanel UserAttrpanel = new JPanel();
			UserAttrpanel.setBounds(10, 12, 200, 402);
			userPanel.add(UserAttrpanel);
			UserAttrpanel.setLayout(null);
			
			JLabel labelNoOfFriends = new JLabel("No: of Friends");
			labelNoOfFriends.setBounds(20, 108, 93, 14);
			UserAttrpanel.add(labelNoOfFriends);
			
			DopBox7 = new JComboBox<String>();
			DopBox7.setBounds(20, 137, 67, 20);
			UserAttrpanel.add(DopBox7);
			DopBox7.addItem(">");
			DopBox7.addItem(">=");
			DopBox7.addItem("=");
			DopBox7.addItem("<");
			DopBox7.addItem("<=");
			DopBox7.setSelectedIndex(2);
			
			textboxFriends = new JTextField();
			textboxFriends.setBounds(97, 137, 61, 20);
			UserAttrpanel.add(textboxFriends);
			textboxFriends.setColumns(10);
			
			JLabel labelAverageStars = new JLabel("Average Stars");
			labelAverageStars.setBounds(10, 182, 93, 14);
			UserAttrpanel.add(labelAverageStars);
			
			DopBox8 = new JComboBox<String>();
			DopBox8.setBounds(20, 207, 67, 20);
			UserAttrpanel.add(DopBox8);
			DopBox8.addItem(">");
			DopBox8.addItem(">=");
			DopBox8.addItem("=");
			DopBox8.addItem("<");
			DopBox8.addItem("<=");
			DopBox8.setSelectedIndex(2);
			
			textboxAvgStar = new JTextField();
			textboxAvgStar.setBounds(97, 207, 61, 20);
			UserAttrpanel.add(textboxAvgStar);
			textboxAvgStar.setColumns(10);
			
			JLabel labelNoOfReviews = new JLabel("No: of Reviews");
			labelNoOfReviews.setBounds(10, 256, 93, 14);
			UserAttrpanel.add(labelNoOfReviews);
			
			DopBox9 = new JComboBox<String>();
			DopBox9.setBounds(20, 281, 67, 20);
			UserAttrpanel.add(DopBox9);
			DopBox9.addItem(">");
			DopBox9.addItem(">=");
			DopBox9.addItem("=");
			DopBox9.addItem("<");
			DopBox9.addItem("<=");
			DopBox9.setSelectedIndex(2);
			
			textboxReviewno = new JTextField();
			textboxReviewno.setBounds(97, 281, 61, 20);
			UserAttrpanel.add(textboxReviewno);
			textboxReviewno.setColumns(10);
			
			JLabel labelYelpUserSince = new JLabel("YelpUser Since ");
			labelYelpUserSince.setBounds(10, 26, 93, 14);
			UserAttrpanel.add(labelYelpUserSince);
			
			 DopBoxYear = new JComboBox<String>();
			 DopBoxYear.setBounds(97, 51, 77, 24);
			 UserAttrpanel.add(DopBoxYear);
			 
			 
			 DopBoxMonth = new JComboBox<String>();
			 DopBoxMonth.setBounds(20, 51, 51, 24);
			 UserAttrpanel.add(DopBoxMonth);
			 
			 
			 DopBox12 = new JComboBox<String>();
			 DopBox12.setBounds(60, 341, 61, 29);
			 UserAttrpanel.add(DopBox12);
			 DopBoxMonth.addItem("01");
			 DopBoxMonth.addItem("02");
			 DopBoxMonth.addItem("03");
			 DopBoxMonth.addItem("04");
			 DopBoxMonth.addItem("05");
			 DopBoxMonth.addItem("06");
			 DopBoxMonth.addItem("07");
			 DopBoxMonth.addItem("08");
			 DopBoxMonth.addItem("09");
			 DopBoxMonth.addItem("10");
			 DopBoxMonth.addItem("11");			
			 DopBoxMonth.addItem("12");
			 
			 DopBox12.addItem("AND");
			 DopBox12.addItem("OR");
			 
			 JScrollPane SqlScrollPane = new JScrollPane();
			 SqlScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			 SqlScrollPane.setBounds(220, 95, 446, 115);
			 userPanel.add(SqlScrollPane);
			 
			 
			 SqlQuery2text = new JTextArea();
			 SqlQuery2text.setDisabledTextColor(Color.BLACK);
			 SqlQuery2text.setForeground(Color.BLACK);
			 SqlQuery2text.setLineWrap(true);
			 SqlQuery2text.setFont(new Font("Calibri", Font.ITALIC, 13));
			 SqlQuery2text.setEditable(false);
			 SqlScrollPane.setViewportView(SqlQuery2text);
			 
			 JScrollPane ResultScrollPaneDisplay2 = new JScrollPane();
			 ResultScrollPaneDisplay2.setBounds(220, 221, 446, 316);
			 userPanel.add(ResultScrollPaneDisplay2);
			 
			 JPanel panelDisplay2 = new JPanel();
			 ResultScrollPaneDisplay2.setViewportView(panelDisplay2);
			 panelDisplay2.setLayout(null);
			 
			 JScrollPane UserResultScrollPane = new JScrollPane();
			 UserResultScrollPane.setBounds(10, 11, 424, 256);
			 panelDisplay2.add(UserResultScrollPane);
			 
			 Resultuser = new JTable();
			 Resultuser.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent e) {
			 		OnClickUser(e);
			 	}
			 });
			 UserResultScrollPane.setViewportView(Resultuser);
			 
			 
			 labelUserResult = new JLabel("Result");
			 labelUserResult.setHorizontalTextPosition(SwingConstants.CENTER);
			 labelUserResult.setHorizontalAlignment(SwingConstants.CENTER);
			 labelUserResult.setBounds(10, 271, 424, 32);
			 panelDisplay2.add(labelUserResult);
			 
			 JButton executequeryButton2 = new JButton("Execute Query");
			 executequeryButton2.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		UserQueryExecute(arg0);
			 	}
			 });
			 executequeryButton2.setBounds(264, 27, 145, 36);
			 userPanel.add(executequeryButton2);
			DopBox5.addItem("OR");
			DopBox5.addItem("AND");
			
			
			
	}
	public static Connection SQLConnection(){
		 Connection connection = null;
		 try {
			 DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection ("jdbc:oracle:thin:localhost:1521:orcl", "kart", "peace");
			 System.out.println("Connection Succesful");
			 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		 
		 
	 }
	
		protected void BusinessQueryExecute(ActionEvent arg0){
			// TODO Auto-generated method stub
			 ArrayList<String> CategoriesList = new ArrayList<String>();
			 ArrayList<String> SubCatList = new ArrayList<String>(); 
			 
			 for(Component c : panelcategories.getComponents())
			 {
				 if (c.getClass().equals(JCheckBox.class)) {
	                 JCheckBox jcb = (JCheckBox) c;
	                 if (jcb.isSelected()) {
	                     CategoriesList.add(jcb.getText());
	                     flag_Category = false;
	                 }
				 	}
				 
			 }
			 if(CategoriesList.isEmpty()){
				 flag_Category = true;
			 }
			 
			 for(Component c : SubCatPanel.getComponents())
			 {
				 if (c.getClass().equals(JCheckBox.class)) {
	                 JCheckBox jscb = (JCheckBox) c;
	                 if (jscb.isSelected()) {
	                     SubCatList.add(jscb.getText().substring(0, jscb.getText().length()-1 ));
	                     flag_Category = false;
	                 }
				 	}
				 
			 }
			 String noOfVotes = null;
			 noOfVotes= textboxVote.getText();
			 String symbolVotes = null;
			 String symbolStars = null;
			 symbolVotes = DopBox1.getSelectedItem().toString();
			 symbolStars = DopBox4.getSelectedItem().toString();
			 int FromDay;
			 int dayTo;
			 String noOfStars = null;
			 noOfStars = textBoxStars.getText();
			 FromDay = DopBox2.getSelectedIndex();
			 dayTo = DopBox3.getSelectedIndex();
			 int FromHour;
			 String operator = DopBox5.getSelectedItem().toString();
			 FromHour = (int)Integer.parseInt(DopBox10.getSelectedItem().toString());
			 int HourTo;
			 HourTo = (int)Integer.parseInt(DopBox11.getSelectedItem().toString());
			 if((DopBox2.getSelectedIndex() < DopBox3.getSelectedIndex()) || (DopBox2.getSelectedIndex() == DopBox3.getSelectedIndex() && DopBox10.getSelectedIndex() < DopBox11.getSelectedIndex()))
				 flag_Checkin = true;
			 else
				 flag_Checkin = false;
			 if(noOfVotes.isEmpty())
				 flag_Checkin = true;
			 else
				 flag_Checkin = false;
			 if(noOfStars.isEmpty())
				 flag_Star  = true;
			 else
				 flag_Star = false;
			 
			 String Query = null;
			 Query = "SELECT * FROM BUSINESS WHERE ";
			 
			 if(!flag_Star)
			 {
				 Query += "STARS " + symbolStars + " " + noOfStars + " "; 
			 }
			 
			 
			 if(!flag_Category)
			 {
				 if(!flag_Star)
				 {
					 Query += operator +" ";
				 }
				 Query = Query + "BUSINESS_ID IN (SELECT BUSINESS_ID FROM BUS_CAT_SUB WHERE ";
			 
				 if (CategoriesList.size() > 0) {
					 
					 for (int i = 0; i < CategoriesList.size(); i++) {
			                if (i == CategoriesList.size() - 1 && SubCatList.isEmpty()) {
			                    Query = Query + " CATEGORY_NAME = '" + CategoriesList.get(i) + "' ";
			                } else {
			                    Query = Query + " CATEGORY_NAME = '" + CategoriesList.get(i) + "' " + operator + " ";
			                }
			            }
					 
			 }
				 if (SubCatList.size() > 0) {
					 	 for (int i = 0; i < SubCatList.size(); i++) {
			                if (i == SubCatList.size() - 1) {
			                    Query = Query + " SUB_CATEGORY_NAME = '" + SubCatList.get(i) + "' ";
			                } else {
			                    Query = Query + " SUB_CATEGORY_NAME = '" + SubCatList.get(i) + "' " + operator + " ";
			                }
			            }		 
			 }
				 
			}
			if(!flag_Checkin)
			{
				if(!flag_Category)
				{
					Query += " UNION ";
				}
				else 
				{
					if(!flag_Star)
					{
						Query += operator;
					}
					Query += " BUSINESS_ID IN ( "; 
				}
				
				Query += "SELECT BUSINESS_ID FROM CHECK_IN WHERE ";
				
					Float floatFrom = FromDay + FromHour/24F;
					Float floatTo = dayTo + HourTo/24F;
					
					Query += "DAYANDTIME >= " + floatFrom.toString() + " AND DAYANDTIME <= " + floatTo.toString() + " AND IN_COUNT " + symbolVotes + textboxVote.getText() ;  
					
					}
			if (!flag_Category || !flag_Checkin)
				Query += ")";
			textBoxAreaSQLBusiness.setText("");
			textBoxAreaSQLBusiness.setText(Query);
			DopBox1.setSelectedIndex(2);
			 DopBox2.setSelectedIndex(0);
			 DopBox3.setSelectedIndex(0);
			 DopBox4.setSelectedIndex(2);
			 DopBox10.setSelectedIndex(0);
			 DopBox11.setSelectedIndex(0);
			 textBoxStars.setText("");
			 textboxVote.setText("");
			 labelBusinessResults.setText("Result");
			 for(Component c : panelcategories.getComponents())
			 {
				 if (c.getClass().equals(JCheckBox.class)) {
	                 JCheckBox jcb = (JCheckBox) c;
	                 if (jcb.isSelected()) {
	                     jcb.setSelected(false);
	                     
	                 }
				 	}
				 
			 }
			 
			 for(Component c : SubCatPanel.getComponents())
			 {
				 if (c.getClass().equals(JCheckBox.class)) {
	                 JCheckBox jscb = (JCheckBox) c;
	                 if (jscb.isSelected()) {
	                     jscb.setSelected(false);
	                 }
				 	}
				 
			 }
			 flag_Category = false;
			 flag_Checkin = false;
			 flag_Star = false;
			 Connection databaseConnection = SQLConnection();
			PreparedStatement stmt;
			try {
				stmt = databaseConnection.prepareStatement(Query);
			
			ResultSet rs = stmt.executeQuery();
			
			  while (rs.next()){
	              ResultSetMetaData rsmd = rs.getMetaData();
	          DefaultTableModel BasicModel = new DefaultTableModel();
	          BasicModel.setColumnCount(rsmd.getColumnCount());
	          Vector<String> columns = new Vector<String>();
	          for (int i = 0; i < rsmd.getColumnCount(); i++) {
	              columns.add(rsmd.getColumnName(i + 1));
	          }
	          BasicModel.setColumnIdentifiers(columns);
	          do {
	              columns = new Vector<String>();
	              for (int i = 0; i < rsmd.getColumnCount(); i++) {
	                  columns.add(rs.getString(rsmd.getColumnName(i + 1)));
	              }
	              BasicModel.addRow(columns);
	          }while (rs.next());
			  
	       
	          ResultBusiness.setModel(BasicModel);
	          ResultBusiness.setRowSelectionAllowed(true);
	          
	         
	     
	          
	 
	      }
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	   }


	protected void UserQueryExecute(ActionEvent arg0) {
		// TODO Auto-generated method stub
		 String symbolFriends = null;
		 String noOfFriends = null;
		 String symbolStars = null;
		 String noOfStars = null;
		 String symbolReviews = null;
		 String noOfReviews = null;
		 String year = null;
		 String month = null;
		symbolFriends = DopBox7.getSelectedItem().toString();
		 noOfFriends = textboxFriends.getText();
		 symbolStars = DopBox8.getSelectedItem().toString();
		 noOfStars = textboxAvgStar.getText();
		 symbolReviews = DopBox9.getSelectedItem().toString();
		 noOfReviews = textboxReviewno.getText();
		 year = DopBoxYear.getSelectedItem().toString();
		 month = DopBoxMonth.getSelectedItem().toString();
		 String operator = DopBox12.getSelectedItem().toString();
		 try{
			  String yelping_since = year+"-"+month;
			  BigDecimal count = new BigDecimal(noOfReviews);
			 BigDecimal star =new BigDecimal(noOfStars);
			 BigDecimal friends_count=new BigDecimal(noOfFriends);
			
			String query1 = null;
			query1 = "SELECT * from  YELPUSERS WHERE to_char((YELPING_SINCE),'YYYY-MM') "+"> "+"'"+yelping_since+"' " + operator +" REVIEW_COUNT "+symbolReviews+" '"
			  +count+"' "+ operator  + " AVG_STARS "+symbolStars+" '"+star+"' " + operator+ " FRIENDS_COUNT "+symbolFriends+" '"+friends_count+"'";
			    System.out.println(query1);
			    SqlQuery2text.setText(query1);
			    Connection con = SQLConnection();
			    PreparedStatement stmt = con.prepareStatement(query1);
			    ResultSet rs = stmt.executeQuery();
			    DefaultTableModel BasicModel = new DefaultTableModel();
			    while(rs.next()){			       
			      ResultSetMetaData rsmd = rs.getMetaData();
			            
			            BasicModel.setColumnCount(rsmd.getColumnCount());
			            Vector<String> columns = new Vector<String>();
			            for (int i = 0; i < rsmd.getColumnCount(); i++) {
			                columns.add(rsmd.getColumnName(i + 1));
			            }
			            BasicModel.setColumnIdentifiers(columns);
			            do {
			                columns = new Vector<String>();
			                for (int i = 0; i < rsmd.getColumnCount(); i++) {
			                    columns.add(rs.getString(rsmd.getColumnName(i + 1)));
			                }
			                BasicModel.addRow(columns);
			            }while (rs.next());
			            Resultuser.setModel(BasicModel);
			            Resultuser.setRowSelectionAllowed(true);
			   
			        } 
			     }catch (SQLException ex) {
			            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
			        }
		 
		 DopBox7.setSelectedIndex(2);
		 DopBox8.setSelectedIndex(2);
		 DopBox9.setSelectedIndex(2);
		 textboxFriends.setText("");
		 textboxReviewno.setText("");
		 textboxAvgStar.setText("");

		
	}
	protected void OnClickBusiness(MouseEvent arg0) {
		// TODO Auto-generated method stub
		 String businessName = (String) ResultBusiness.getValueAt(ResultBusiness.getSelectedRow(), 5);
		 String businessID = (String) ResultBusiness.getValueAt(ResultBusiness.getSelectedRow(), 0);
		 String rQuery = "select r.DATE_OF_REVIEW as \"Date\", r.TEXT as \"Reviews\", r.STARS as \"Stars\", u.NAME as \"Author\"  from review r, users u where r.USER_ID = u.USER_ID and r.BUSINESS_ID = '" + businessID+"'";
		 Connection con = null;
		 textBoxAreaSQLBusiness.setText(rQuery);
	        try {
	            con = SQLConnection();
	            PreparedStatement stmt;	
	      	stmt = con.prepareStatement(rQuery);
			
			ResultSet rs = stmt.executeQuery();
			DefaultTableModel Basicmodel = null;
			
			  while (rs.next()){
	          ResultSetMetaData rsmd = rs.getMetaData();
	          Basicmodel = new DefaultTableModel();
	          Basicmodel.setColumnCount(rsmd.getColumnCount());
	          Vector<String> columns = new Vector<String>();
	          for (int i = 0; i < rsmd.getColumnCount(); i++) {
	              columns.add(rsmd.getColumnName(i + 1));
	          }
	          Basicmodel.setColumnIdentifiers(columns);
	          do{
	              columns = new Vector<String>();
	              for (int i = 0; i < rsmd.getColumnCount(); i++) {
	                  columns.add(rs.getString(rsmd.getColumnName(i + 1)));
	              }
	              Basicmodel.addRow(columns);
	          }while (rs.next()) ;
			  }
			  ResultBusiness.setModel(Basicmodel);
			  ResultBusiness.setRowSelectionAllowed(false);
			  ResultBusiness.setCellSelectionEnabled(false);
			  MouseListener[] tableListeners;
			  tableListeners = ResultBusiness.getMouseListeners();
			  ResultBusiness.removeMouseListener(tableListeners[1]);
			}catch( SQLException e1)
	              {
	            	  e1.printStackTrace();
	              }
	        
		 labelBusinessResults.setText(businessName);
		  
		
	}

	 protected void OnClickUser(MouseEvent e) {
		// TODO Auto-generated method stub
		 String userName = (String) Resultuser.getValueAt(Resultuser.getSelectedRow(), 1);
		 String YelpID = (String) Resultuser.getValueAt(Resultuser.getSelectedRow(), 3);
		 String rQuery = "select r.DATE_OF_REVIEW as \"Date\", r.TEXT as \"Reviews\", b.NAME as \"Business\"  from   REVIEW r, BUSINESS b where r.BUSINESS_ID = b.BUSINESS_ID and r.USER_ID = '" + YelpID+"'";
		 Connection con = null;
	        try {
	            con = SQLConnection();
	            SqlQuery2text.setText(rQuery);
	            PreparedStatement stmt = null;
	           	stmt = con.prepareStatement(rQuery);
			
			ResultSet rs = stmt.executeQuery();
			DefaultTableModel BasicModel = null;
			String str;
			
			  if (rs.next()){
	              ResultSetMetaData rsmd = rs.getMetaData();
	          BasicModel = new DefaultTableModel();
	          BasicModel.setColumnCount(rsmd.getColumnCount());
	          Vector<String> columns = new Vector<String>();
	          for (int i = 0; i < rsmd.getColumnCount(); i++) {
	              columns.add(rsmd.getColumnName(i + 1));
	          }
	          BasicModel.setColumnIdentifiers(columns);
	          do {
	              columns = new Vector<String>();
	              
	              for (int i = 0; i < rsmd.getColumnCount(); i++) {
	            	  str = rs.getString(rsmd.getColumnName(i+1));
	                  columns.add(str);
	              }
	              BasicModel.addRow(columns);
	              
	          }while(rs.next());
			  }
			  Resultuser.setModel(BasicModel);
			  labelUserResult.setText(userName + "'s reviews");
			  Resultuser.setRowSelectionAllowed(false);
			  Resultuser.setCellSelectionEnabled(false);
			}catch( SQLException e1)
	              {
	            	  e1.printStackTrace();
	              }	        
		 labelBusinessResults.setText(userName + "Reviews");		
	}
  


	protected void ShowSubCat(java.awt.event.ActionEvent evt) {
		Connection con = null;
        try {
            con = SQLConnection();
            String sQuery = "";
            ArrayList<String> BusnSel = new ArrayList<String>();
            for (Component c : panelcategories.getComponents()) {
                if (c.getClass().equals(javax.swing.JCheckBox.class)) {
                    JCheckBox jcb = (JCheckBox) c;
                    if (jcb.isSelected()) {
                        BusnSel.add(jcb.getText());
                    }
                }
            }
           sQuery = sQuery + "SELECT DISTINCT SUB_CATEGORY_NAME FROM BUS_CAT_SUB WHERE ";
            for (int i = 0; i < BusnSel.size(); i++) {
                if (i == BusnSel.size() - 1) {
                    sQuery = sQuery + " CATEGORY_NAME = ?";
                } else {
                    sQuery = sQuery + " CATEGORY_NAME = ? OR";
                }
            }
            SubCatPanel.removeAll();
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
            SubCatPanel.setLayout(new GridLayout(0, 2, 10, 10));
            for (JCheckBox ch : subCatList) {
                SubCatPanel.add(ch);
                SubCatPanel.revalidate();
                SubCatPanel.repaint();
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
        
    }//GEN-LAST:event_jButton4ActionPerformed
}
