-- Final Year Project
-- By David Clarke
-- Created on 26_1_2001
library IEEE;
Use IEEE.STD_LOGIC_1164.ALL;
--
Entity LUT_multiplier is
	Port (A, B : in std_logic_vector (1 downto 0); Z : out std_logic_vector (3 downto 0));
End Entity LUT_multiplier;

Architecture Behavioural of LUT_multiplier is
Begin
	LUT : Process (A, B)
	Begin  
		Z <= "0000";
		IF A = "00" AND B = "00" THEN 
			Z <= "0000";
		ELSIF A = "00" AND B = "01" THEN 
			Z <= "0000";
		ELSIF A = "00" AND B = "10" THEN   
			Z <= "0000";
		ELSIF A = "00" AND B = "11" THEN 
			Z <= "0000";
		ELSIF A = "01" AND B = "00" THEN 
			Z <= "0000";
		ELSIF A = "01" AND B = "01" THEN 
			Z <= "0001";
		ELSIF A = "01" AND B = "10" THEN
			Z <= "0010";
		ELSIF A = "01" AND B = "11" THEN
			Z <= "0011";
		ELSIF A = "10" AND B = "00" THEN  
			Z <= "0000";
		ELSIF A = "10" AND B = "01" THEN  
			Z <= "0010";
		ELSIF A = "10" AND B = "10" THEN 
			Z <= "0100";
		ELSIF A = "10" AND B = "11" THEN  
			Z <= "0110";
		ELSIF A = "11" AND B = "00" THEN 
			Z <= "0000";
		ELSIF A = "11" AND B = "01" THEN   
			Z <= "0011";
		ELSIF A = "11" AND B = "10" THEN
			Z <= "0110";
		ELSIF A = "11" AND B = "11" THEN  
			Z <= "1001";
		END IF;
		
   END PROCESS LUT;
		
END ARCHITECTURE Behavioural;
		
			
			
