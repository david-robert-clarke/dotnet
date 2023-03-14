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
      A11, A12, A13, B11, B12, B13,
      A21, A22, A23, B21, B22, B23,
      A31, A32, A33, B31, B32, B33,
      ERROR                        : OUT TWO_BITS);
      -- EIGTHEEN ELEMENTS, THE MAGNITUDE OF A MATRIX ELEMENT IS TWO BITS WIDE EQUALLING 36 OUTPUT BIT
      -- THE ERROR OUTPUT IS USED AS AN ERROR DETECTION METHOD, TO SEE IF THE SYSTEM INPUT DATA IS BEHAVING
END ENTITY DATA_STORE;

ARCHITECTURE BEHAVIOURAL OF DATA_STORE IS
BEGIN
	GATHER_IN : PROCESS (D_IN, LATCH_SEL)
	    BEGIN

	        -- 9 SETS OF FOUR BIT LATCHES, REQUIRES 9 SELECT SIGNALS (8 DOWNTO 0) TO GET DATA TO ITS 
	        -- CORRECT DESTINATION
	        CASE LATCH_SEL IS 
	            WHEN "1000" => A11 <= D_IN(3 DOWNTO 2);
	                           A12 <= D_IN(1 DOWNTO 0);
	                       
	            WHEN "0111" => A13 <= D_IN(3 DOWNTO 2);
	                           A21 <= D_IN(1 DOWNTO 0);
	                       
	            WHEN "0110" => A22 <= D_IN(3 DOWNTO 2);
	                           A23 <= D_IN(1 DOWNTO 0);
	                       
	            WHEN "0101" => A31 <= D_IN(3 DOWNTO 2);
	                           A32 <= D_IN(1 DOWNTO 0);
	                       
	            WHEN "0100" => A33 <= D_IN(3 DOWNTO 2);
	                           B11 <= D_IN(1 DOWNTO 0);
	                       
	            WHEN "0011" => B12 <= D_IN(3 DOWNTO 2);
	                           B13 <= D_IN(1 DOWNTO 0);
	                       
	            WHEN "0010" => B21 <= D_IN(3 DOWNTO 2);
	                           B22 <= D_IN(1 DOWNTO 0);
	                       
	            WHEN "0001" => B23 <= D_IN(3 DOWNTO 2);
	                           B31 <= D_IN(1 DOWNTO 0);
	                       
	            WHEN "0000" => B32 <= D_IN(3 DOWNTO 2);
	                           B33 <= D_IN(1 DOWNTO 0);
	            
	            WHEN OTHERS => ERROR <= "00";
	            
	        END CASE;
	    END PROCESS GATHER_IN;

	    
END ARCHITECTURE BEHAVIOURAL;
      		
