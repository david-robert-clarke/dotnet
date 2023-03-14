-- Created by David Clarke for the RS232 assignment
Library IEEE;
USE IEEE.std_logic_1164.all;

Entity Decoder IS
PORT (DECEN, CLR : IN STD_LOGIC; Q11, Q10, Q9, Q8, Q7, Q6 : IN STD_LOGIC;
	S300, S600, S1200, S2400, S4800, S9600, S19200 : OUT STD_LOGIC);
END Entity Decoder;

ARCHITECTURE Decoder_Arch OF Decoder IS
BEGIN
     Decod : Process (DECEN, CLR, Q11, Q10, Q9, Q8, Q7, Q6) 
     Begin
  	  
  	  IF  CLR = '1' THEN
  	  	  S300 <= '0'; S600 <= '0'; S1200 <= '0'; S2400 <= '0'; S4800 <= '0'; S9600 <= '0'; S19200 <= '0';  
  	  ELSIF CLR = '0' AND DECEN = '1' THEN
  	  	  IF    Q11 = '1' THEN 
	  	  	S300 <= '1';
		  ELSIF Q11 = '0' AND Q10 = '1' THEN 
		  	S600 <= '1';
		  ELSIF Q11 = '0' AND Q10 = '0' AND Q9 = '1' THEN 
		  	S1200 <= '1';
		  ELSIF Q11 = '0' AND Q10 = '0' AND Q9 = '0' AND Q8 = '1' THEN 
		  	S2400 <= '1';
		  ELSIF Q11 = '0' AND Q10 = '0' AND Q9 = '0' AND Q8 = '0' AND Q7 = '1' THEN 
		  	S4800 <= '1';
		  ELSIF Q11 = '0' AND Q10 = '0' AND Q9 = '0' AND Q8 = '0' AND Q7 = '0' AND Q6 = '1' THEN 
		  	S9600 <= '1';
		  ELSIF Q11 = '0' AND Q10 = '0' AND Q9 = '0' AND Q8 = '0' AND Q7 = '0' AND Q6 = '0' THEN 
		  	S19200 <= '1';
	          END IF;
	  END IF;
      End Process Decod; 	
END Architecture Decoder_Arch;
