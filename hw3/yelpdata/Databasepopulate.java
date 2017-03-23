package yelpdata;



import java.util.List;
import java.util.Set;
import java.io.*;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.sql.Driver;
import java.lang.Object;
import java.nio.file.Files;
import java.nio.file.Paths;


import org.json.*;




public class Databasepopulate
{
	
	 public static void main(String[] args) throws Exception, FileNotFoundException 
	 {
		 
		 	Databasepopulate populate = new Databasepopulate();
		 	populate.populateUsers();
		 	populate.populateCheckins();
		 	populate.populateBusiness();
		 	populate.populateReview();
	// ignore next 10 lines 	 
	// String buffer = ReadFile("yelp_business.json");	
	// File fileName = new File("yelp_business.json");
	// JSONObject  jBusiness= new JSONObject(new JSONTokener(buffer));
	// System.out.println(buffer);
	// Connection conn = SQLConnection();
	// Statement statement = conn.createStatement();
	// PreparedStatement pStatement = conn.prepareStatement("SELECT * FROM YELP_USER;");
	// ResultSet rs = statement.executeQuery("SELECT * FROM YELP_USER");
	// ResultSetMetaData rsmd = rs.getMetaData();
	 
	 
	}
	 
	 public static String ReadFile(String fileName)
	 {
		 
		 String result = "";
		 try
		 {
			 BufferedReader bReader = new BufferedReader(new FileReader(fileName));
		 	 StringBuilder sBuilder = new StringBuilder();
			 String bufferline = bReader.readLine();
			 while(bufferline != null)
			 {
				 sBuilder.append(bufferline);
				 bufferline = bReader.readLine();
				 JSONObject  jBusiness= new JSONObject(bufferline);
				 
			 }
			 result = sBuilder.toString();
			 bReader.close();
		 }
		 catch(Exception je)
		 { 
			 je.printStackTrace();
		 }
		 return result;
	 }
	 
	 
	 

	public void populateBusiness() 
	 {
		// function to populate Business, categories and subcategories related tables

		PreparedStatement businessinsertStatement = null;
		PreparedStatement mainCategoryinsert = null;
		PreparedStatement deleteLatest = null;
		Connection databaseConnection = SQLConnection();
		String deletefulltable; 
		
		String[] mainCategories = {"ActiveLife", "Arts '&'Entertainment", "Automotive", "CarRental", "Cafes", "Beauty &Spas", "ConvenienceStores", "Dentists", "Doctors", "Drugstores", "DepartmentStores", "Education", "Event Planning &Services","Flowers &Gifts","Food","Health &Medical", "HomeServices", "Home &Garden", "Hospitals", "Hotels &Travel", "HardwareStores", "Grocery", "MedicalCenters", "Nurseries &Gardening", "Nightlife2", "Restaurants", "Shopping", "Transportation"};
		try 
		 {
			databaseConnection.setAutoCommit(true);
			deletefulltable = "DELETE from MAINCATEGORY";
			deleteLatest = databaseConnection.prepareStatement(deletefulltable);
			deleteLatest.executeQuery();
			String categories = "INSERT into MAINCATEGORY(CATEGORY_ID, NAME) VALUES (?, ?)";
			
			for(int i = 0; i < mainCategories.length; i++)
			{
				mainCategoryinsert = databaseConnection.prepareStatement(categories);
				mainCategoryinsert.setString(1, "C"+ String.valueOf(i));
				mainCategoryinsert.setString(2, mainCategories[i]);
				mainCategoryinsert.executeUpdate();
			}		
			databaseConnection.commit();
		 } 
		catch (SQLException e) {
			e.printStackTrace();
		}


		List<String> list = new ArrayList<>();
		PreparedStatement sub_category_insert = null;
		PreparedStatement bus_cat_sub_insert = null;
		try (Stream<String> stream = Files.lines(Paths.get("C:/json/yelp_business.json"))) 
		{
				list = stream.collect(Collectors.toList());
			try
			{  
				deletefulltable = "DELETE from BUS_CAT_SUB";
				deleteLatest = databaseConnection.prepareStatement(deletefulltable);
				deleteLatest.executeQuery();
				deletefulltable = "DELETE from SUB_CATEGORY";
				deleteLatest = databaseConnection.prepareStatement(deletefulltable);
				deleteLatest.executeQuery();
				deletefulltable = "DELETE from BUSINESS";
				deleteLatest = databaseConnection.prepareStatement(deletefulltable);
				deleteLatest.executeQuery();
				databaseConnection.setAutoCommit(true);}
			catch(SQLException e){
				e.printStackTrace();
			}
			for (String string : list) 
			{
				try 
				{
						JSONObject jsonObject = new JSONObject(string);
						try
						{
							if (businessinsertStatement == null) 
							{
							
								String sql = "INSERT INTO BUSINESS(BUSINESS_ID, CITY, REVIEW_COUNT, NAME, STARS, STATE)"
										+ " VALUES (?,?,?,?,?,?)";
								businessinsertStatement = databaseConnection.prepareStatement(sql);
							}
							businessinsertStatement.setString(1, jsonObject.get("business_id").toString());
							businessinsertStatement.setString(2, jsonObject.get("city").toString());
							businessinsertStatement.setInt(3, Integer.parseInt(jsonObject.get("review_count").toString()));
							businessinsertStatement.setString(4, jsonObject.get("name").toString());
							businessinsertStatement.setString(5, jsonObject.get("stars").toString());
							businessinsertStatement.setString(6, jsonObject.get("state").toString());
							businessinsertStatement.executeUpdate();
							} 
						catch (SQLException e1) {
								e1.printStackTrace();
						}
						
						List<String> subCategory = new ArrayList<>();
						List<String> mainCat = new ArrayList<>();
						JSONArray category = (JSONArray) jsonObject.get("categories");
						for (Object object : category) 
						{
							if (Arrays.asList(mainCategories).contains(object.toString())) 
							{
								mainCat.add(object.toString());
							}
							else
							{
								subCategory.add(object.toString());
							}
						}
						try
						{
							if (sub_category_insert == null) 
							{
						
								String sql = "INSERT INTO SUB_CATEGORY(SUBCATNAME)" + " VALUES (?)";
								sub_category_insert = databaseConnection.prepareStatement(sql);
							}
						}
						catch (SQLException e1) {
								e1.printStackTrace();
						}
						for(String subcat: subCategory)
						{
							sub_category_insert.setString(1, subcat);
							sub_category_insert.executeUpdate();
						}
					
						try 
						{
							if (bus_cat_sub_insert == null) 
							{	
									String sql = "INSERT INTO BUS_CAT_SUB(Business_Id,CATEGORY_NAME,SUB_CATEGORY_NAME)"
											+ " VALUES (?,?,?)";
									bus_cat_sub_insert = databaseConnection.prepareStatement(sql);
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
						for (String cat : mainCat)
						{
							for (String sub_cat : subCategory) 
							{
								bus_cat_sub_insert.setString(1, jsonObject.get("business_id").toString());
								bus_cat_sub_insert.setString(2, cat);
								bus_cat_sub_insert.setString(3, sub_cat);
								try 
								{
									bus_cat_sub_insert.executeUpdate();
								} 
								catch (SQLException e) {
									e.printStackTrace();
								}
							}
								
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		finally{
		 }
		try
		{			
			if (businessinsertStatement != null)
			{
				businessinsertStatement.close();
				businessinsertStatement = null;
			}
			if (sub_category_insert != null) 
			{
				sub_category_insert.close();
				sub_category_insert = null;
			}
			if (mainCategoryinsert != null) 
			{
				mainCategoryinsert.close();
				mainCategoryinsert = null;
			}
			if (bus_cat_sub_insert != null) 
			{
				bus_cat_sub_insert.close();
				bus_cat_sub_insert = null;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}




	public void populateCheckins() 
	{
		// populating the checkin data into the tables in database
		List<String> checkinList = new ArrayList<>();
		PreparedStatement checkinInsert = null;
		PreparedStatement deleteLatest = null;
		int cnt = 0;
		try (Stream<String> stream = Files.lines(Paths.get("C:/json/yelp_checkin.json")))
		 {
			Connection databaseConnection = SQLConnection();
			
			databaseConnection.setAutoCommit(true);
			String deletefulltable = "DELETE from CHECK_IN";
			deleteLatest = databaseConnection.prepareStatement(deletefulltable);
			deleteLatest.executeQuery();
			checkinList = stream.collect(Collectors.toList());
			for (String string : checkinList) 
			{
				try 
				{
					JSONObject jsonObject = new JSONObject(string);
					if (checkinInsert == null) 
					{
						try 
						{
							String sql = "INSERT INTO CHECK_IN (dayandtime, IN_COUNT, BUSINESS_ID)"
									+ " VALUES (?,?,?)";
							checkinInsert = databaseConnection.prepareStatement(sql);
						} 
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					JSONObject checkinTime = (JSONObject) jsonObject.get("checkin_info");
					Set<String> keys = checkinTime.keySet();
					for (String temp : keys) 
					{
						checkinInsert.setString(2, checkinTime.get(temp).toString());
						String[] hourday = temp.split("-");
						Float fHrsDay = Integer.parseInt(hourday[1]) + Integer.parseInt(hourday[0]) / 24F;
						checkinInsert.setFloat(1, fHrsDay);
						checkinInsert.setString(3, jsonObject.get("business_id").toString());
						checkinInsert.addBatch();
						cnt++;
						if(cnt > 200)
						try 
						{
							checkinInsert.executeBatch();
							cnt = 0;
						} 
						catch (SQLException e) {
							e.printStackTrace();
						}
					}
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally 
		{
			if (checkinInsert != null) 
			{
				try 
				{
					checkinInsert.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				checkinInsert = null;
			}

		}
	}
	
	public void populateUsers() 
	 {
		// Populating the yelp user related tables from the given json
		List<String> userList = new ArrayList<>();
		PreparedStatement userinsertStatement = null;
		PreparedStatement deleteLatest = null;					
		try (Stream<String> stream = Files.lines(Paths.get("C:/json/yelp_user.json"))) 
		{
			 Connection databaseConnection = SQLConnection();
				try 
				{
					// to ensure redundancy is eliminated in storing data
					String deletefulltable = "delete from YELPUSERS";
					deleteLatest = databaseConnection.prepareStatement(deletefulltable);
					deleteLatest.executeQuery();
				}
				catch (SQLException e1) {
						e1.printStackTrace();
				}
				databaseConnection.setAutoCommit(true);
				userList = stream.collect(Collectors.toList());
				for (String string : userList) 
				{
					try 
					{
						JSONObject jsonObject = new JSONObject(string);
						if (userinsertStatement == null) 
						{
							try
							{
								String sql = "INSERT INTO YELPUSERS(YELPING_SINCE, NAME, REVIEW_COUNT, USER_ID, AVG_STARS, FRIENDS_COUNT)"
											+ " VALUES (?,?,?,?,?,?)";
									
								userinsertStatement = databaseConnection.prepareStatement(sql);
							} 
							catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
						java.util.Date parsed = format.parse(jsonObject.get("yelping_since").toString());
						userinsertStatement.setDate(1, new Date(parsed.getTime()));
						userinsertStatement.setString(2, jsonObject.get("name").toString());
						userinsertStatement.setString(3, jsonObject.get("review_count").toString());
						userinsertStatement.setString(4, jsonObject.get("user_id").toString());
						userinsertStatement.setString(5, jsonObject.get("avg_stars").toString());
						JSONArray friends = (JSONArray) jsonObject.get("friends");
						userinsertStatement.setInt(6, friends.length());
						try 
						{
							userinsertStatement.executeUpdate();
						} 
						catch (SQLException e) {
							e.printStackTrace();
						}

					} 
					catch (Exception e) {
						e.printStackTrace();
				}
			}

		}
		catch (Exception e) {
				e.printStackTrace();
		} finally 
		{
			if (userinsertStatement != null) 
			{
				try 
				{
					userinsertStatement.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				userinsertStatement = null;
			}

		}
	}
	
	public void populateReview() 
	{
		// populating the review table with the given json data
		List<String> reviewList = new ArrayList<>();
		PreparedStatement reviewInsert = null;
		PreparedStatement deleteLatest = null;
		int cnt = 0;
		try (Stream<String> stream = Files.lines(Paths.get("C:/json/yelp_review.json")))
		 {
			Connection databaseConnection = SQLConnection();
			databaseConnection.setAutoCommit(true);
			String deletefulltable = "DELETE from REVIEW";
			deleteLatest = databaseConnection.prepareStatement(deletefulltable);
			deleteLatest.executeQuery();
			reviewList = stream.collect(Collectors.toList());
			for (String string : reviewList) 
			{

				try 
				{
					JSONObject jsonObject = new JSONObject(string);
					if (reviewInsert == null) 
					{
						try 
						{
							String sql = "INSERT INTO REVIEW(REVIEW_ID, DATE_OF_REVIEW, STARS, USER_ID, BUSINESS_ID, TEXT,VOTES) "
									+ " VALUES (?,?,?,?,?,?,?)";
							reviewInsert = databaseConnection.prepareStatement(sql);
						} 
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}

					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date parsed = format.parse(jsonObject.get("date").toString());
					reviewInsert.setDate(2, new Date(parsed.getTime()));
					reviewInsert.setString(1, jsonObject.get("review_id").toString());
					reviewInsert.setString(3, jsonObject.get("stars").toString());
					reviewInsert.setString(4, jsonObject.get("user_id").toString());
					reviewInsert.setString(5, jsonObject.get("business_id").toString());
					reviewInsert.setString(6, jsonObject.get("text").toString());
					JSONObject votes = (JSONObject) jsonObject.get("votes");

					int votesCount = 0;
					// System.out.println(votes);
					Set<String> keys = votes.keySet();
					for (String temp : keys) 
					{
						votesCount = votesCount + Integer.parseInt((votes.get(temp).toString()));
					}
					reviewInsert.setInt(7, votesCount);
					reviewInsert.addBatch();
					cnt++;
					try 
					{
						reviewInsert.executeBatch();
						cnt = 0;
					} 
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally 
		{
			if (reviewInsert != null) 
			{
				try 
				{
					reviewInsert.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				reviewInsert = null;
			}

		}
	}
	public static Connection SQLConnection()
	 {
	 // Connecting to oracle database 
		 Connection connection = null;
		 try 
		 {
			 DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection ("jdbc:oracle:thin:localhost:1521:orcl", "kart", "peace");
			 System.out.println("Connection Succesful");
		 }
		 catch (SQLException e) {
			e.printStackTrace();
		 }
		 return connection;		 
	 }
}
