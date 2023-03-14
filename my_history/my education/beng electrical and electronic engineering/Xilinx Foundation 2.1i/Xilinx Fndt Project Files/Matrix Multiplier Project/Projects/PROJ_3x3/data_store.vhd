-- Final Year Project
-- Xilinx Project "proj_3x3"
-- Created 10_02_2001
-- By David Clarke
Library IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
USE IEEE.STD_LOGIC_ARITH.ALL;
USE WORK.MATRIX_PACKAGE.ALL;

ENTITY DATA_STORE IS
PORT (D_IN, LATCH_SEL : IN NIBBLE;
      -- TOTAL OF ONE BYTE OF INPUT DATA CORRESPONDING TO ONE BYTE OF DATA RECIEVED FROM THE PROGRAM
      -- XSPORT
         D_OUT       : OUT THIRTY6_BITS);
      -- EIGTHEEN ELEMENTS, THE MAGNITUDE OF A MATRIX ELEMENT IS TWO BITS WIDE EQUALLING 36 OUTPUT BIT
END ENTITY DATA_STORE;

ARCHITECTURE BEHAVIOURAL OF DATA_STORE IS
BEGIN
	GATHER_IN : PROCESS (D_IN, LATCH_SEL)
	    BEGIN
	    
	    	    D_OUT <= X"000000000";
	    
	    CASE LATCH_SEL IS
	        -- 9 SETS OF FOUR BIT LATCHES, REQUIRES 9 SELECT SIGNALS (8 DOWNTO 0) TO GET DATA TO ITS 
	        -- CORRECT DESTINATION
	        
	            WHEN "1000" => D_OUT(35 downto 34) <= D_IN(3 DOWNTO 2);
	                           D_OUT(33 downto 32) <= D_IN(1 DOWNTO 0);
	                       
	            WHEN "0111" => D_OUT(31 downto 30) <= D_IN(3 DOWNTO 2);
	                           D_OUT(29 downto 28) <= D_IN(1 DOWNTO 0);
	                       
	            WHEN "0110" => D_OUT(27 downto 26) <= D_IN(3 DOWNTO 2);
	                           D_OUT(25 downto 24) <= D_IN(1 DOWNTO 0);
	                       
	            WHEN "0101" => D_OUT(23 downto 22) <= D_IN(3 DOWNTO 2);
	                           D_OUT(21 downto 20) <= D_IN(1 DOWNTO 0);
	                       
	            WHEN "0100" => D_OUT(19 downto 18) <= D_IN(3 DOWNTO 2);
	                           D_OUT(17 downto 16) <= D_IN(1 DOWNTO 0);
	                       
	            WHEN "0011" => D_OUT(15 downto 14) <= D_IN(3 DOWNTO 2);
	                           D_OUT(13 downto 12) <= D_IN(1 DOWNTO 0);
	                       
	            WHEN "0010" => D_OUT(11 downto 10) <= D_IN(3 DOWNTO 2);
	                           D_OUT(9 downto 8) <= D_IN(1 DOWNTO 0);
	                       
	            WHEN "0001" => D_OUT(7 downto 6) <= D_IN(3 DOWNTO 2);
	                           D_OUT(5 downto 4) <= D_IN(1 DOWNTO 0);
	                       
	            WHEN "0000" => D_OUT(3 downto 2) <= D_IN(3 DOWNTO 2);
	                           D_OUT(1 downto 0) <= D_IN(1 DOWNTO 0);
	        
	            WHEN OTHERS => D_OUT <= X"000000000";
	        END CASE;
	    END PROCESS GATHER_IN;
	    
END ARCHITECTURE BEHAVIOURAL;
      		
