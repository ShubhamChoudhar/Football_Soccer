import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

import au.com.bytecode.opencsv.CSVReader;

public class Insertrecord {

	public static void readCsv() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@acaddbprod-2.uta.edu:1523/pcse1p.data.uta.edu", "dxt3485", "Dheerajkumar1045");
			Statement stmt = conn.createStatement();
			String dateformat = "alter session set nls_date_format ='yyyy-MM-dd'";
			stmt.executeQuery(dateformat);

			CSVReader reader1 = new CSVReader(
					new FileReader("C:\\Users\\dheer\\eclipse-workspace\\DataStructures\\Country.csv"), ',');
			String[] nextLine1;
			while ((nextLine1 = reader1.readNext()) != null) {
				String cName = nextLine1[0];
				double population = Double.parseDouble(nextLine1[1]);
				int worldcup = Integer.parseInt(nextLine1[2]);
				String manager = nextLine1[3];
				stmt.executeUpdate("INSERT INTO COUNTRY " + "VALUES (" + cName + ", " + population + ", " + worldcup
						+ ", " + manager + ")");
				System.out.print("inserted");
			}

			CSVReader reader2 = new CSVReader(
					new FileReader("C:\\Users\\dheer\\eclipse-workspace\\DataStructures\\Players.csv"), ',');
			String[] nextLine2;
			while ((nextLine2 = reader2.readNext()) != null) {

				int Player_id = Integer.parseInt(nextLine2[0]);
				String Name = nextLine2[1];
				String Fname = nextLine2[2];
				String Lname = nextLine2[3];
				String DOB = nextLine2[4];
				String Country = nextLine2[5];
				int Height = Integer.parseInt(nextLine2[6]);
				String Club = nextLine2[7];
				String Position = nextLine2[8];
				int Caps_for_Country = Integer.parseInt(nextLine2[9]);
				String IS_CAPTAIN = nextLine2[10];
				stmt.executeUpdate("INSERT INTO PLAYERS " + "VALUES (" + Player_id + ", " + Name + ", " + Fname + ", "
						+ Lname + ", " + TO_DATE(DOB + ",'yyyy/MM/dd'") + ", " + Country + ", " + Height + ", " + Club
						+ ", " + Position + ", " + Caps_for_Country + ", '" + IS_CAPTAIN + "')");
				System.out.println("inserted");
			}

			CSVReader reader3 = new CSVReader(
					new FileReader("C:\\Users\\dheer\\eclipse-workspace\\DataStructures\\Match_results.csv"), ',');
			String[] nextLine3;
			while ((nextLine3 = reader3.readNext()) != null) {
				int Match_id = Integer.parseInt(nextLine3[0]);
				String Date_of_Match = nextLine3[1];
				String Start_Time_Of_Match = nextLine3[2];
				String Team1 = nextLine3[3];
				String Team2 = nextLine3[4];
				int Team1_score = Integer.parseInt(nextLine3[5]);
				int Team2_score = Integer.parseInt(nextLine3[6]);
				String Stadium_Name = nextLine3[7];
				String Host_City = nextLine3[8];
				stmt.executeUpdate("INSERT INTO MATCH_RESULTS " + "VALUES (" + Match_id + ", "
						+ TO_DATE(Date_of_Match + ",'yyyy/MM/dd'") + ", " + Start_Time_Of_Match + ", " + Team1 + ", "
						+ Team2 + ", " + Team1_score + ", " + Team2_score + ", " + Stadium_Name + ", " + Host_City
						+ ")");
				System.out.print("inserted");
			}

			CSVReader reader4 = new CSVReader(
					new FileReader("C:\\Users\\dheer\\eclipse-workspace\\DataStructures\\Player_Cards.csv"), ',');
			String[] nextLine4;
			while ((nextLine4 = reader4.readNext()) != null) {
				int Player_id = Integer.parseInt(nextLine4[0]);
				int Yellow_Cards = Integer.parseInt(nextLine4[1]);
				int Red_Cards = Integer.parseInt(nextLine4[2]);
				stmt.executeUpdate("INSERT INTO PLAYER_CARD " + "VALUES (" + Player_id + ", " + Yellow_Cards + ", "
						+ Red_Cards + ")");
				System.out.print("inserted");
			}

			CSVReader reader5 = new CSVReader(
					new FileReader("C:\\Users\\dheer\\eclipse-workspace\\DataStructures\\PLAYER_ASSISTS_GOALS.csv"),
					',');
			String[] nextLine5;
			while ((nextLine5 = reader5.readNext()) != null) {
				int Player_id = Integer.parseInt(nextLine5[0]);
				int No_of_Matches = Integer.parseInt(nextLine5[1]);
				int goals = Integer.parseInt(nextLine5[2]);
				int Assists = Integer.parseInt(nextLine5[3]);
				int Minutes_Played = Integer.parseInt(nextLine5[4]);
				stmt.executeUpdate("INSERT INTO PLAYER_ASSISTS_GOALS " + "VALUES (" + Player_id + ", " + No_of_Matches
						+ "," + goals + ", " + Assists + ", " + Minutes_Played + ")");
				System.out.print("inserted");
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String TO_DATE(String dOB) {
		return null;
	}

	public static void main(String[] args) {
		readCsv();
	}
}