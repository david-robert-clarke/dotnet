-- Created by David Clarke for the RS232 assignment
Library IEEE;
USE IEEE.STD_LOGIC_1164.All;

Entity Pinoutdecode IS
Port (CLR, S300, S600, S1200, S2400, S4800, S9600, S19200 : IN STD_LOGIC;
      S6, S5, S4, S3, S2, S1, S0 : OUT STD_LOGIC);
End Entity Pinoutdecode;
--
Architecture Arch OF Pinoutdecode IS
Begin

	Process (CLR, S300, S600, S1200, S2400, S4800, S9600, S19200)
		
	Begin
		IF CLR = '1' THEN
		   S6 <= '0'; S5 <= '0'; S4 <= '0'; S3 <= '0'; S2 <= '0'; 
		   S1 <= '0'; S0 <= '0'; 
		ELSIF CLR = '0' THEN
		      IF S300 ='1' THEN
		      S6 <= '0'; S5 <= '0'; S4 <= '1'; S3 <= '0'; S2 <= '0'; 
		      S1 <= '1'; S0 <= '0'; 
		   ELSIF S600 = '1' THEN
		      S6 <= '1'; S5 <= '0'; S4 <= '1'; S3 <= '1'; S2 <= '1'; 
		      S1 <= '0'; S0 <= '1';
		   ELSIF S1200 = '1' THEN
		      S6 <= '1'; S5 <= '0'; S4 <= '1'; S3 <= '1'; S2 <= '0'; 
		      S1 <= '1'; S0 <= '1';
		   ELSIF S2400 = '1' THEN
		      S6 <= '0'; S5 <= '1'; S4 <= '1'; S3 <= '1'; S2 <= '0'; 
		      S1 <= '1'; S0 <= '0';
		   ELSIF S4800 = '1' THEN
		      S6 <= '1'; S5 <= '1'; S4 <= '0'; S3 <= '1'; S2 <= '0'; 
		      S1 <= '1'; S0 <= '1';
		   ELSIF S9600 = '1' THEN
		      S6 <= '1'; S5 <= '1'; S4 <= '0'; S3 <= '1'; S2 <= '1'; 
		      S1 <= '1'; S0 <= '1';
		   ELSIF S19200 = '1' THEN
		      S6 <= '1'; S5 <= '0'; S4 <= '1'; S3 <= '0'; S2 <= '0'; 
		      S1 <= '1'; S0 <= '0';
		   END IF;
	        END IF;
	END Process;
END Architecture Arch;

		
			
