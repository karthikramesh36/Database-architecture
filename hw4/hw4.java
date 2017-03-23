package hw4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Logger;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.bson.Document;
//import org.json.JSONArray;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

// csulb id - 014837054
// name - karthik ramesh

public class hw4
{
	
	/* Connection to 
	 * MongoDB*
	 */
	   MongoClient mongoClient = new MongoClient("localhost",27017);
	   DB db = mongoClient.getDB("kartt");
	   DBCollection databaseCollection=db.getCollection("business");
	   DBCollection new_temp_coll=db.getCollection("business_database");
		BasicDBObject businessQuery = new BasicDBObject();
		BasicDBObject projection = new BasicDBObject();		
		private JTextField textFieldStars;
		private JTextField textFieldReviews;
	/*Connection 
	 * Established Successfully
	 */
/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{	
			public void run()
			{	try
				{	hw4 window = new hw4();
					window.YelpappKart.setVisible(true);
				} catch (Exception e) 	{ e.printStackTrace(); 	}
			}
		});
	}

	/**
	 * * Create the application.
	 */
	public hw4()
	{
		if(!db.collectionExists("business_database"))
			newTempCollection();
		initialize();
		
	}	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		YelpappKart = new JFrame();
		YelpappKart.setTitle("Yelp_Mongo_KART");
		YelpappKart.getContentPane().setForeground(Color.BLACK);
		YelpappKart.setBounds(20, 20, 1050, 650);
		YelpappKart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setMaximumSize(new Dimension(100, 100));
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JLabel lblpointofInt = new JLabel("Point of Interest :");
		lblpointofInt.setForeground(Color.BLUE);
		lblpointofInt.setFont(new Font("Tamil Sangam MN", Font.BOLD, 18));
		
		JLabel lblnoofStars = new JLabel("Proximity (mi) :");
		lblnoofStars.setForeground(Color.BLUE);
		lblnoofStars.setFont(new Font("Tamil Sangam MN", Font.BOLD, 18));
		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setForeground(Color.BLUE);
		lblOptions.setFont(new Font("Tamil Sangam MN", Font.BOLD, 18));
		
		JButton searchBtn = new JButton("Bus.Search");
		searchBtn.setForeground(Color.RED);
		searchBtn.setFont(new Font("Tamil Sangam MN", Font.BOLD, 13));
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OnClickSearch();
			}
		});
		comboBox_pointOfInt = new JComboBox();
		
		addressPOIclass address1 = new addressPOIclass("372 East Tropicana Avenue\nEastside\nLas Vegas, NV 89169", -115.138026, 36.089494000000002);
		addressPOIclass address2 = new addressPOIclass("MGM Grand Hotel and Casino\n3799 Las Vegas Blvd S\nEastside\nLas Vegas, NV 89109",  -115.167725, 36.103399000000003);
		addressPOIclass address3 = new addressPOIclass("1230 S Longmore\nMesa, AZ 85202", -111.86520360410201, 33.391840708657803);
		addressPOIclass address4 = new addressPOIclass("227 State St\nCapitol\nMadison, WI 53703",   -89.388973100000001, 43.074678599999999);
		addressPOIclass address5 = new addressPOIclass("21172 S Ellsworth Loop Rd\nQueen Creek, AZ 85142", -111.63954435121499, 33.254313669979197);
		
		comboBox_pointOfInt.setModel(new DefaultComboBoxModel<String>(new String[] {"NONE", address1.AddressPOI,address2.AddressPOI,address3.AddressPOI ,address4.AddressPOI ,address5.AddressPOI}));
		
		comboBox_Proximity = new JComboBox();
		comboBox_Proximity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OnClickSearch();
			}
		});
		comboBox_Proximity.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "5", "10", "20", "30", "50"}));
		
		comboBox_Searchfor = new JComboBox();
		comboBox_Searchfor.setModel(new DefaultComboBoxModel(new String[] {"NONE", "OR", "AND"}));
		
	
		
		
		textFieldStars = new JTextField();
		textFieldStars.setColumns(10);
		
		JLabel lblNoofStars = new JLabel("No: of Stars :");
		lblNoofStars.setForeground(Color.BLUE);
		lblNoofStars.setFont(new Font("Tamil Sangam MN", Font.BOLD, 18));
		
		JPanel panelUser = new JPanel();
		panelUser.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelUser.setName("User");
		panelUser.setToolTipText("User");
		
		JLabel lblNewLabel = new JLabel("Main Categories");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tamil Sangam MN", Font.BOLD, 18));
		
		JLabel lblSubcatTIT = new JLabel("Sub - Categories");
		lblSubcatTIT.setForeground(Color.BLUE);
		lblSubcatTIT.setFont(new Font("Tamil Sangam MN", Font.BOLD, 18));
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		GroupLayout groupLayout = new GroupLayout(YelpappKart.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSubcatTIT)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblpointofInt, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(12)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblOptions)
										.addComponent(lblNoofStars, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblnoofStars))))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(comboBox_Searchfor, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addGap(47)
									.addComponent(searchBtn, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addComponent(comboBox_Proximity, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_pointOfInt, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldStars, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(105)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
							.addComponent(panelUser, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
							.addGap(32))))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(lblSubcatTIT))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
							.addGap(24))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
							.addGap(18)))
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblpointofInt)
										.addComponent(comboBox_pointOfInt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(20)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblnoofStars)
										.addComponent(comboBox_Proximity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(26)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNoofStars, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldStars, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(57)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBox_Searchfor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblOptions)
										.addComponent(searchBtn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
								.addComponent(panelUser, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
							.addGap(11))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		JLabel lblNoOfreviews = new JLabel("No. of Reviews");
		lblNoOfreviews.setForeground(Color.BLUE);
		lblNoOfreviews.setFont(new Font("Tamil Sangam MN", Font.BOLD, 18));
		
		textFieldReviews = new JTextField();
		textFieldReviews.setColumns(10);
		
		JLabel lblMemberSince = new JLabel("Member since");
		lblMemberSince.setForeground(Color.BLUE);
		lblMemberSince.setFont(new Font("Tamil Sangam MN", Font.BOLD, 18));
		
		
		comboBoxFrom = new JComboBox<String>();
		
		comboBox_1 = new JComboBox<String>();
		for(int i = 0; i <16; i++)
		{
		comboBoxFrom.addItem(new Integer(2000+i).toString());
		}

		
		
		comboBox_1_1 = new JComboBox<String>();
		comboBox_1_1.setBounds(20, 372, 51, 24);
		
		
		
	
		comboBox_1_1.addItem("01");
		comboBox_1_1.addItem("02");
		comboBox_1_1.addItem("03");
		comboBox_1_1.addItem("04");
		comboBox_1_1.addItem("05");
		comboBox_1_1.addItem("06");
		comboBox_1_1.addItem("07");
		comboBox_1_1.addItem("08");
		comboBox_1_1.addItem("09");
		comboBox_1_1.addItem("10");
		comboBox_1_1.addItem("11");			
		comboBox_1_1.addItem("12");
		
		JButton btnUsersearch = new JButton("UserSearch");
		btnUsersearch.setForeground(Color.RED);
		btnUsersearch.setFont(new Font("Tamil Sangam MN", Font.PLAIN, 13));
		btnUsersearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				YelpUser(arg0);
			}
		});
		GroupLayout gl_panelUser = new GroupLayout(panelUser);
		gl_panelUser.setHorizontalGroup(
			gl_panelUser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUser.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panelUser.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUser.createSequentialGroup()
							.addComponent(btnUsersearch, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panelUser.createSequentialGroup()
							.addGroup(gl_panelUser.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNoOfreviews, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblMemberSince, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
							.addGap(26)
							.addGroup(gl_panelUser.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBoxFrom, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldReviews, Alignment.TRAILING))
							.addGap(18)
							.addComponent(comboBox_1_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(7, Short.MAX_VALUE))))
		);
		gl_panelUser.setVerticalGroup(
			gl_panelUser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUser.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panelUser.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNoOfreviews)
						.addComponent(textFieldReviews, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelUser.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxFrom, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMemberSince)
						.addComponent(comboBox_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addComponent(btnUsersearch, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		panelUser.setLayout(gl_panelUser);
		
		businessTableResults = new JTable();
		businessTableResults.setToolTipText("");
		scrollPane_2.setViewportView(businessTableResults);
		businessTableResults.addMouseListener(new java.awt.event.MouseAdapter()
		{@Override
			public void mouseClicked(MouseEvent evt)
			{ 	
				int rowID = businessTableResults.rowAtPoint(evt.getPoint());
				String business_name = businessTableResults.getModel().getValueAt(rowID, 0).toString();
				
				
				DBCollection dbcollection=db.getCollection("business_database");
				BasicDBObject businessQuery=new BasicDBObject();
				BasicDBObject businessProjection=new BasicDBObject();
				businessQuery.put("name",business_name);
				businessProjection.put("b_id", 1);
				DBCursor cursor=dbcollection.find(businessQuery,businessProjection);
				String business_Id="";
				while(cursor.hasNext()){
					DBObject result=cursor.next();
					business_Id=(String) result.get("b_id");
					}
				if (rowID >= 0)
				{
					JFrame reviewframe = new JFrame();
					reviewframe.setSize(600, 600);
					reviewframe.setTitle("Reviews Table");
					reviewframe.setVisible(true);
						reviewTable = new JTable();
						DBCollection dbCollection=db.getCollection("review");
						BasicDBObject reviewQuery=new BasicDBObject();
						BasicDBObject reviewProjection=new BasicDBObject();
						
						if(businessTableResults.getModel().getColumnName(3) == "User ID")
						{
							
							String user_id = (String) businessTableResults.getModel().getValueAt(rowID, 3);
									reviewQuery.put("user_id", user_id);
									reviewProjection.put("business_id", 1);
						}
						else
						{
						reviewQuery.put("business_id", business_Id);
						reviewProjection.put("user_id", 1);
						}
						reviewProjection.put("date", 1);
						reviewProjection.put("stars", 1);
						reviewProjection.put("text", 1);
						
						reviewProjection.put("votes.useful", 1);
					//	textPane.setText(reviewQuery+","+reviewProjection);
				    //	textPane.repaint();
				    	System.out.println(reviewQuery+","+reviewProjection);
				    	DBCursor cursor1=dbCollection.find(reviewQuery,reviewProjection);
						DBObject result;
						/*Creating
						 * Review table 
						 */
						String[] columnNames = new String[]{"Review Date", "Stars", "Review Text","Name"};
						DefaultTableModel model1 = new DefaultTableModel(columnNames, 0);
						reviewTable.setModel(model1);
						reviewTable.setShowGrid(true);
						String user_name=null;
						   int i=0;
						while(cursor1.hasNext()){
						   i++;
						  // System.out.println("reached reviews");
						   result=cursor1.next();
						   String r_date=(String) result.get("date");
						   String r_text=(String) result.get("text");
						   int r_stars=(int)result.get("stars");
						   String r_user=(String) result.get("user_id");
						 
						   
						   if (businessTableResults.getModel().getColumnName(3) == "User ID") {
							   DBCollection userCollection = db.getCollection("business_database");
								BasicDBObject userQuery = new BasicDBObject();
								BasicDBObject userProjection = new BasicDBObject();
								r_user = (String) result.get("business_id");
								userQuery.put("b_id", r_user);
								userProjection.put("name", 1);
								DBCursor cursor2 = userCollection.find(userQuery, userProjection);
								while (cursor2.hasNext()) {
									result = cursor2.next();
									user_name = (String) result.get("name");
								} 
						   }
						   else{
							DBCollection userCollection = db.getCollection("user");
							BasicDBObject userQuery = new BasicDBObject();
							BasicDBObject userProjection = new BasicDBObject();
							userQuery.put("user_id", r_user);
							userProjection.put("name", 1);
							DBCursor cursor2 = userCollection.find(userQuery, userProjection);
							while (cursor2.hasNext()) {
								result = cursor2.next();
								user_name = (String) result.get("name");
							} 
						}
						model1.addRow(new Object[]{r_date, r_stars, r_text,user_name});
					
						  // System.out.println("[R_date:"+r_date+"] [R_stars:"+r_stars+"] [R_text:"+r_text+"][R_user:"+user_name+"][ R_VotesUseful:"+r_votesUseful+"]");
						    }
					scrollPane_review = new JScrollPane();
					reviewframe.getContentPane().add(scrollPane_review);
					scrollPane_review.add(reviewTable);
					scrollPane_review.setViewportView(reviewTable);
					scrollPane_review.createHorizontalScrollBar();
					scrollPane_review.revalidate();
					scrollPane_review.repaint();
				}
		}
	});
		//scrollPane_review.setViewportView(reviewTable);
				
		panelSubcat = new JPanel();
		panelSubcat.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(panelSubcat);
		
		JPanel panelCAT = new JPanel();
		panelCAT.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCAT.setBackground(Color.WHITE);
		scrollPane.setViewportView(panelCAT);
		YelpappKart.getContentPane().setLayout(groupLayout);
		
		
		   		   
		//Categories Data-28 categories
		String[] categories={"Active Life","Arts & Entertainment","Automotive","Car Rental","Cafes","Beauty & Spas","Convenience Stores",
				 "Dentists", "Doctors", "Drugstores", "Department Stores","Education", "Event Planning & Services", "Flowers & Gifts",
				"Food", "Health & Medical", "Home Services","Home & Garden","Hospitals","Hotels & Travel","Hardware Stores","Grocery",
				"Medical Centers", "Nurseries & Gardening","Nightlife","Restaurants","Shopping","Transportation"};
		JCheckBox checkbox1;
		panelCAT.setLayout(new GridLayout(categories.length, 1, 0, 0));
		for(String s:categories){
			checkbox1=new JCheckBox();
			checkbox1.setText(s);
			checkbox1.addItemListener(new ItemListener()
			{	public void itemStateChanged(ItemEvent e)
				{
				JCheckBox checkbox = (JCheckBox) (e.getItemSelectable());
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					
					selected_categories = checkbox.getText();
					Selected_listCat.add(selected_categories);
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					selected_categories = checkbox.getText();
					Selected_listCat.remove(selected_categories);
				}
				
				try {
					ShowSubCat();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelCAT.add(checkbox1);
		}
		//mongoClient.close();
	}	 	//Main Function End's Here
	
	/*newtempcollection is here on referred as  business_database*/
	
	protected void YelpUser(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int noofReviews = new Integer(textFieldReviews.getText()).intValue();
		String FromYear = comboBoxFrom.getSelectedItem().toString();
		String FromMonth = comboBox_1_1.getSelectedItem().toString();
		
		try{
			DBCollection databaseCollection=db.getCollection("user");
			BasicDBObject reviewQuery=new BasicDBObject();
			BasicDBObject reviewProjection=new BasicDBObject();
			reviewQuery.put("review_count", noofReviews);
			reviewQuery.append("yelping_since", new BasicDBObject("$gt", FromYear+"-"+FromMonth));
			
			reviewProjection.put("review_count", 1);
			reviewProjection.put("name", 1);
			reviewProjection.put("yelping_since", 1);
			reviewProjection.put("user_id", 1);
			
			
			DBCursor cursor=databaseCollection.find(reviewQuery,reviewProjection);
			
			DBObject res;
    	//textPane.setText(reviewQuery+","+reviewProjection);
    	//textPane.repaint();
    	System.out.println(reviewQuery+","+reviewProjection);

    	String[] columnNames = new String[]{"Name", "ReviewCount", "Member Since","User ID"};
    	DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    	businessTableResults.setModel(model);
    	businessTableResults.setShowGrid(true);
        	   
       while(cursor.hasNext()){
    	   
    	   res=cursor.next();
    	   String u_name=(String) res.get("name");
    	   String u_reviewCount= new Integer((int) res.get("review_count")).toString();
    	   String u_memSince=(String) res.get("yelping_since");
    	   String b_stars=(String) res.get("user_id");
    	  
    	   
    	   model.addRow(new Object[]{u_name, u_reviewCount, u_memSince,b_stars});
    	    }
       businessTableResults.setModel(model);
       businessTableResults.setShowGrid(true);
       cursor.close();
      
    	}
    		catch (Exception e) 	{ e.printStackTrace();}
		
		
		
	}
	
	//creating a colection of business

	public void newTempCollection(){
	
	MongoClient mongoClient = new MongoClient("localhost",27017);
	 MongoClient client = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
     DBCollection b_collection = client.getDB("kartt").getCollection("business");
     if(client.getDB("kartt").getCollection("business_database").count() > 0)
     {
    	 BasicDBObject query = new BasicDBObject();
    	 client.getDB("kartt").getCollection("business_database").remove(query);
     }
	 final DBCollection new_temp_coll = client.getDB("kartt").getCollection("business_database");

			           BasicDBObject query = new BasicDBObject();
			           DBCursor cursor = b_collection.find(query);
		            while(cursor.hasNext()){
			        	   try {
			        		   DBObject result = cursor.next();
			                   JSONParser parser = new JSONParser();
			                   JSONObject jsonObject;
			                   jsonObject = (JSONObject)parser.parse(result.toString());
			                   String business_id = (String) jsonObject.get("business_id");
			                   BasicDBObject doc = new BasicDBObject("b_id", business_id);
			                   String full_address = (String)jsonObject.get("full_address");
			                   doc.append("full_address", full_address);
			                   String city = (String) jsonObject.get("city");
			                   doc.append("city", city);
			                   String review_count = jsonObject.get("review_count").toString();
			                   doc.append("review_count", review_count);
			                   String businessName = jsonObject.get("name").toString();
			                   doc.append("name", businessName);
			                   String longitude = jsonObject.get("longitude").toString();
			                   String latitude = jsonObject.get("latitude").toString();
			                   Float[] Loc={Float.parseFloat(longitude),Float.parseFloat(latitude)};
			                   doc.append("Loc",new Document().append("longitude", Float.parseFloat(longitude)).append("latitude",Float.parseFloat(latitude)));
			                   String state = (String) jsonObject.get("state");
			                   doc.append("state", state);
			                   String stars = jsonObject.get("stars").toString();
			                   doc.append("stars", stars);
			                   String bType = (String) jsonObject.get("type");
			                   doc.append("type",bType);
			                   org.json.simple.JSONArray category=(org.json.simple.JSONArray)jsonObject.get("categories");
			                   
			                   List<String> subCategory = new ArrayList<>();
								List<String> mainCat = new ArrayList<>();
								
								String[] categories={"Active Life","Arts & Entertainment","Automotive","Car Rental","Cafes","Beauty & Spas","Convenience Stores",
										 "Dentists", "Doctors", "Drugstores", "Department Stores","Education", "Event Planning & Services", "Flowers & Gifts",
										"Food", "Health & Medical", "Home Services","Home & Garden","Hospitals","Hotels & Travel","Hardware Stores","Grocery",
										"Medical Centers", "Nurseries & Gardening","Nightlife","Restaurants","Shopping","Transportation"};
								for (Object object : category) {
									if (Arrays.asList(categories).contains(object.toString())) {
										mainCat.add(object.toString());
									}
									else
									{
										subCategory.add(object.toString());
									}
								}
								doc.append("subcategories", subCategory);
								doc.append("categories", mainCat);								
								new_temp_coll.insert(doc);
			    			 
			        	   }
			        	   catch( ParseException e){
			        		   e.printStackTrace();
			        		   
			        	   }
		            }
		           }


	public static boolean JsonCheck(String str){
        
        if (str.trim().contains("{") || str.trim().contains("[")) {
            return str.trim().charAt(0) == '{' || str.trim().charAt(0) == '[';
        } else {
            return false;
        }                    
    }
	/*Populating the Sub Categories column*/
	
		@SuppressWarnings("unchecked")
		public void ShowSubCat() throws ParseException{
		//Attributes Data
		DBCollection databaseCollection=db.getCollection("business_database");
		businessQuery.put("categories", new BasicDBObject("$in", Selected_listCat));
		projection.put("subcategories",1);
		projection.put("_id",0);
		
		DBCursor current_cursor=databaseCollection.find(businessQuery,projection);
		DBObject result;
		   HashMap<String, String> attr=new HashMap<>();
		   Set<String> attributes = new HashSet<String>();
		   Set<String> mySet = new HashSet<String>();
		   String[] categories={"Active Life","Arts & Entertainment","Automotive","Car Rental","Cafes","Beauty & Spas","Convenience Stores",
					 "Dentists", "Doctors", "Drugstores", "Department Stores","Education", "Event Planning & Services", "Flowers & Gifts",
					"Food", "Health & Medical", "Home Services","Home & Garden","Hospitals","Hotels & Travel","Hardware Stores","Grocery",
					"Medical Centers", "Nurseries & Gardening","Nightlife","Restaurants","Shopping","Transportation"};
		   ArrayList<String> temp = new ArrayList<String>();
		   while (current_cursor.hasNext())
			{
			   result=current_cursor.next();
			   temp = (ArrayList<String>)result.get("subcategories");
			  
			  if(temp!= null)
				  mySet.addAll(temp);                
				
		   }  
		  listattributes = new ArrayList<String>(new LinkedHashSet<String>(mySet));
		 
		  
		  JCheckBox checkbox2;
		  panelSubcat.removeAll();
			panelSubcat.setLayout(new GridLayout(listattributes.size(), 1, 0, 0));
			for(String s:listattributes){
				checkbox2=new JCheckBox();
				checkbox2.setText(s);
				checkbox2.addItemListener(new ItemListener()
				{	public void itemStateChanged(ItemEvent e)
					{	JCheckBox checkboxAttr = (JCheckBox) (e.getItemSelectable());
					if (e.getStateChange() == ItemEvent.SELECTED)
					{	Selected_listSubCatg.add(checkboxAttr.getText());
					}else if (e.getStateChange() == ItemEvent.DESELECTED) {
						Selected_listSubCatg.remove(checkboxAttr.getText());
					}
				}
			});
				panelSubcat.add(checkbox2);
				panelSubcat.revalidate();
				panelSubcat.repaint();
			}
			
	}
	public void OnClickSearch(){
			try{
	DBCollection databaseCollection=db.getCollection("business_database");
	if (((comboBox_pointOfInt.getSelectedItem().toString())=="NONE") || (comboBox_pointOfInt.getSelectedIndex())=='1'){
		businessQuery.remove("full_address");
		businessQuery.remove("Loc");
		if(!Selected_listCat.isEmpty())
			businessQuery.put("categories", new BasicDBObject("$in", Selected_listCat));
    	if((comboBox_Searchfor.getSelectedItem().toString() == "OR")||((comboBox_Searchfor.getSelectedItem().toString() == "NONE"))){
    		if(!Selected_listSubCatg.isEmpty())
    			businessQuery.append("subcategories", new BasicDBObject("$in", Selected_listSubCatg));
    	} else if ((comboBox_Searchfor.getSelectedItem().toString() == "AND") ){		
    businessQuery.append("attr_keys", new BasicDBObject("$in", listattributes));	
	}
	}
	if(!textFieldStars.getText().isEmpty() || textFieldStars.getText() == "")
	{
		businessQuery.append("stars", textFieldStars.getText());
	}
	else
	{
		textFieldStars.removeAll();
		businessQuery.remove("stars");
	}
	if((comboBox_pointOfInt.getSelectedItem()) != null && (comboBox_pointOfInt.getSelectedItem()) != "NONE"){
			//&& (comboBox_pointOfInterest.getSelectedItem())!="NONE"){
    String pointOfInterested_Value=comboBox_pointOfInt.getSelectedItem().toString();
    //businessQuery.append("full_address", pointOfInterested_Value);
    	
    	BasicDBObject full=new BasicDBObject();
    	full.append("full_address", pointOfInterested_Value);
    	BasicDBObject proj=new BasicDBObject();
    	proj.put("Loc", 1);
    	DBCursor current_cursor = databaseCollection.find(full,proj);
    	DBObject res;
    	float latitude = 0;
    	float longitude = 0;
    	while(current_cursor.hasNext()){
    	res=current_cursor.next();
    		
    		DBObject report=(DBObject) res.get("Loc");
    		latitude=Float.parseFloat(report.get("latitude").toString().trim());
    		longitude=Float.parseFloat(report.get("longitude").toString().trim());
    		
    	}
    	BasicDBList geoCoord = new BasicDBList();
        geoCoord.add(longitude);
        geoCoord.add(latitude);

        BasicDBList geoParams = new BasicDBList();
        geoParams.add(geoCoord);
        geoParams.add(Float.parseFloat(comboBox_Proximity.getSelectedItem().toString())/3963.2);

        BasicDBObject query = new BasicDBObject("Loc", new BasicDBObject("$geoWithin", new BasicDBObject("$centerSphere", geoParams)));
        if((comboBox_Proximity.getSelectedItem()) != null ){
	        businessQuery.append("Loc", new BasicDBObject("$geoWithin", new BasicDBObject("$centerSphere", geoParams)));
	        DBCursor cursor_geo = databaseCollection.find(query);   	
	        DBObject res_geo;
	        while(cursor_geo.hasNext()){
	        	res_geo= cursor_geo.next();
	        	
	   
	        }
        }
	}
	projection.clear();
	projection.put("name",1);
	projection.put("state",1);
	projection.put("city",1);
	projection.put("stars",1);
	
	//textPane.setText(businessQuery+","+projection);
	//textPane.repaint();
	System.out.println(businessQuery+","+projection);

	DBCursor cursorReference_table=databaseCollection.find(businessQuery,projection);
	DBObject results_table;
	
	/*Table 
	 * creating for BUSINESS*/
	String[] columnNames = new String[]{"Name", "City", "State","Stars"};
	DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	businessTableResults.setModel(model);
	businessTableResults.setShowGrid(true);
    	   
   while(cursorReference_table.hasNext()){
	   //System.out.println("reached");
	   results_table=cursorReference_table.next();
	   String b_name=(String) results_table.get("name");
	   String b_city=(String) results_table.get("city");
	   String b_state=(String) results_table.get("state");
	   String b_stars=(String) results_table.get("stars");
	   String b_id=(String) results_table.get("b_id");
	   listofBusinessId.add(b_id);
	   model.addRow(new Object[]{b_name, b_city, b_state,b_stars});
	    }
   businessTableResults.setModel(model);
   businessTableResults.setShowGrid(true);
   cursorReference_table.close();
  
	}
		catch (Exception e) 	{ e.printStackTrace();}
}
	public class addressPOIclass{
		public String AddressPOI;
		public double longitude;
		public double Latitude;
		public addressPOIclass(String AddressPOI, double d, double e){
			this.AddressPOI = AddressPOI;
			this.longitude = d;
			this.Latitude = e;
		}
	}
	private JFrame YelpappKart;
	private JTable businessTableResults;
	private JPanel panelSubcat;
	private JComboBox<String> comboBox_pointOfInt;
	private JTable reviewTable;
	private String selected_categories;
	private JComboBox<String> comboBox_Searchfor; 
	private JScrollPane scrollPane_review ;
	private JComboBox<String> comboBox_Proximity ;
	private  List<String> listattributes ;
	ArrayList<String> Selected_listCat = new ArrayList<String>();
	ArrayList<String> Selected_listSubCatg = new ArrayList<String>();
	List<String> listofBusinessId = new ArrayList<String>();
	JComboBox<String> comboBoxFrom;
	JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_1_1;
	
}