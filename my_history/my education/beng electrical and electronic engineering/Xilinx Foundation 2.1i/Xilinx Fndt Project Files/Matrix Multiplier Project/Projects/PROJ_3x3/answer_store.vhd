-- Final Year Project
-- Xilinx Project "proj_3x3"
-- Created 10_02_2001
-- By David Clarke
Library IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
USE IEEE.STD_LOGIC_ARITH.ALL;
USE WORK.MATRIX_PACKAGE.ALL;
--
ENTITY Answer_Store IS
PORT (EN, CLK, RESET : IN ONE_BIT; 
      INPUT : IN  U_FORTY5_BITS;
      ANSWER: OUT U_FORTY5_BITS);
-- The answer will be a total of 45 bits wide
END ENTITY Answer_Store;

ARCHITECTURE BEHAVIOURAL OF Answer_Store IS

BEGIN

	PROCESS (INPUT, CLK, RESET, EN)
	BEGIN
	
	    IF reset = '1' THEN
	       ANSWER <= "000000000000000000000000000000000000000000000"; 
	    ELSE
	        IF rising_edge(CLK) THEN
	        -- WHEN THE ENABLE SIGNAL IS
	            CASE EN IS
	            WHEN '1' =>
	                ANSWER <= INPUT;
	            WHEN OTHERS =>
	                ANSWER <= "000000000000000000000000000000000000000000000";
	            END CASE;
	       END IF;
	    END IF;
	END PROCESS;
	
END ARCHITECTURE BEHAVIOURAL;
	        
	        
