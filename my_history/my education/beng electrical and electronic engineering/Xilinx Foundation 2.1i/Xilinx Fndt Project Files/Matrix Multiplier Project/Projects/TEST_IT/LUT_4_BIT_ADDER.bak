-- Final Year Project test
-- Created 27_1_2001
-- By David Clarke
LIBRARY IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
USE WORK.MATRIX_PACKAGE.ALL;

Entity LUT_4_BIT_ADDER IS
PORT (A, B : IN INTEGER RANGE 9 downto 0; Z : OUT INTEGER RANGE 18 downto 0);
END ENTITY LUT_4_BIT_ADDER;
-- what values can the product at the 2-bit multipliers output be
-- 0, 1, 2, 3, 4, 6, 9 
ARCHITECTURE BEHAVIOURAL OF LUT_4_BIT_ADDER IS
BEGIN
	PROCESS (A, B)
	    BEGIN
	    	Z <= 0;
	        IF A = 0 AND B = 0 THEN
	        Z <= 0;
	        ELSIF A = 0 AND B = 1 THEN
		Z <= 1;
	        ELSIF A = 0 AND B = 2 THEN
	        Z <= 2;
	        ELSIF A = 0 AND B = 3 THEN
	        Z <= 3;
	        ELSIF A = 0 AND B = 4 THEN
	        Z <= 4;
	        ELSIF A = 0 AND B = 6 THEN
	        Z <= 6;
	        ELSIF A = 0 AND B = 9 THEN
	        Z <= 9;
	        
	        ELSIF A = 1 AND B = 0 THEN
	        Z <= 1;
	        ELSIF A = 1 AND B = 1 THEN
	        Z <= 2;
	        ELSIF A = 1 AND B = 2 THEN
	        Z <= 3;
	        ELSIF A = 1 AND B = 3 THEN
	        Z <= 4;
	        ELSIF A = 1 AND B = 4 THEN
	        Z <= 5;
	        ELSIF A = 1 AND B = 6 THEN
	        Z <= 7;
	        ELSIF A = 1 AND B = 9 THEN
	        Z <= 10;
	        
	        ELSIF A = 2 AND B = 0 THEN
	        Z <= 2;
	        ELSIF A = 2 AND B = 1 THEN
	        Z <= 3;
	        ELSIF A = 2 AND B = 2 THEN
	        Z <= 4;
	        ELSIF A = 2 AND B = 3 THEN
	        Z <= 5;
	        ELSIF A = 2 AND B = 4 THEN
	        Z <= 6;
	        ELSIF A = 2 AND B = 6 THEN
	        Z <= 8;
	        ELSIF A = 2 AND B = 9 THEN
	        Z <= 11;
	        
	        ELSIF A = 3 AND B = 0 THEN
	        Z <= 3;
	        ELSIF A = 3 AND B = 1 THEN
	        Z <= 4;
	        ELSIF A = 3 AND B = 2 THEN
	        Z <= 5;
	        ELSIF A = 3 AND B = 3 THEN
	        Z <= 6;
	        ELSIF A = 3 AND B = 4 THEN
	        Z <= 7;
	        ELSIF A = 3 AND B = 6 THEN
	        Z <= 9;
	        ELSIF A = 3 AND B = 9 THEN
	        Z <= 12;
	        
	        ELSIF A = 4 AND B = 0 THEN
	        Z <= 4;
	        ELSIF A = 4 AND B = 1 THEN
	        Z <= 5;
	        ELSIF A = 4 AND B = 2 THEN
	        Z <= 6;
	        ELSIF A = 4 AND B = 3 THEN
	        Z <= 7;
	        ELSIF A = 4 AND B = 4 THEN
	        Z <= 8;
	        ELSIF A = 4 AND B = 6 THEN
	        Z <= 10;
	        ELSIF A = 4 AND B = 9 THEN
	        Z <= 13;
	        
	        ELSIF A = 6 AND B = 0 THEN
	        Z <= 6;
	        ELSIF A = 6 AND B = 1 THEN
	        Z <= 7;
	        ELSIF A = 6 AND B = 2 THEN
	        Z <= 8;
	        ELSIF A = 6 AND B = 3 THEN
	        Z <= 9;
	        ELSIF A = 6 AND B = 4 THEN
	        Z <= 10;
	        ELSIF A = 6 AND B = 6 THEN
	        Z <= 12;
	        ELSIF A = 6 AND B = 9 THEN
	        Z <= 15;
	        
	        ELSIF A = 9 AND B = 0 THEN
	        Z <= 9;
	        ELSIF A = 9 AND B = 1 THEN
	        Z <= 10;
	        ELSIF A = 9 AND B = 2 THEN
	        Z <= 11;
	        ELSIF A = 9 AND B = 3 THEN
	        Z <= 12;
	        ELSIF A = 9 AND B = 4 THEN
	        Z <= 13;
	        ELSIF A = 9 AND B = 6 THEN
	        Z <= 15;
	        ELSIF A = 9 AND B = 9 THEN
	        Z <= 18;
	        END IF;
	  END PROCESS;
END ARCHITECTURE BEHAVIOURAL;
	        

