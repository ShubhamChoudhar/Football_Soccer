create table COUNTRY (
	Country_Name VARCHAR(20) NOT NULL,
	Population DECIMAL(10,2) NOT NULL,
	No_of_Worldcup_won INT NOT NULL,
	Manager VARCHAR(20) NOT NULL,
	PRIMARY KEY (Country_Name)
);

create table PLAYERS(
	Player_id INT,
	Name VARCHAR (40),
	Fname VARCHAR (20),
	Lname VARCHAR (35),
	DOB DATE,
	Country VARCHAR(20),
	Height INT,
	Club VARCHAR(30),
	Position VARCHAR(10),
	Caps_for_Country INT,
	IS_CAPTAIN VARCHAR(5),
	PRIMARY KEY (Player_id),
	FOREIGN KEY (Country) REFERENCES COUNTRY (Country_Name)
);

create table MATCH_RESULTS(
	Match_id INT,
	Date_of_Match DATE,
	Start_Time_Of_Match TIMESTAMP,
	Team1 VARCHAR(20),
	Team2 VARCHAR(20),
	Team1_score INT,
	Team2_score INT,
	Stadium_Name VARCHAR(35),
	Host_City VARCHAR(20),
	PRIMARY KEY (Match_id),
	FOREIGN KEY (Team1) REFERENCES COUNTRY (Country_Name),
	FOREIGN KEY (Team2) REFERENCES COUNTRY (Country_Name)
);

create table PLAYER_CARD(
	Player_id INT,
	Yellow_Cards INT,
	Red_Cards INT,
	PRIMARY KEY (Player_id),
	FOREIGN KEY(Player_id) REFERENCES PLAYERS (Player_id)
);

create table PLAYER_ASSISTS_GOALS (
	Player_id INT,
	No_of_Matches INT,
	Goals INT,
	Assists INT,
	Minutes_Played INT,
	PRIMARY KEY (Player_id),
	FOREIGN KEY(Player_id) REFERENCES PLAYERS (Player_id)
);