-- DAVID CLARKE
-- PRODUCED FOR FINAL YEAR PROJECT ON 
-- 30_11_2000
Library IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
--
ENTITY PART_DEC_1 IS
PORT (PAR_EN_DEC : IN STD_LOGIC;
      MAT_IN   :IN STD_LOGIC_VECTOR (3 DOWNTO 0);
      PART_OUT :OUT STD_LOGIC_VECTOR (15 DOWNTO 0));
END ENTITY PART_DEC_1;
--
ARCHITECTURE BEHAVIOURAL OF PART_DEC_1 IS
BEGIN
	ORDER_DATA : PROCESS (MAT_IN) IS
	BEGIN
	    IF PAR_EN_DEC = '1' THEN
	        IF MAT_IN = "0111" THEN
	            PART_OUT(15) <= MAT_IN(3);
	            PART_OUT(14) <= MAT_IN(2);
	            PART_OUT(13) <= MAT_IN(1);
	            PART_OUT(12) <= MAT_IN(0);
	        ELSIF MAT_IN = "1001" THEN
	            PART_OUT(11) <= MAT_IN(3);
	            PART_OUT(10) <= MAT_IN(2);
	            PART_OUT(9) <= MAT_IN(1);
	            PART_OUT(8) <= MAT_IN(0);
	        ELSIF MAT_IN = "1110" THEN
	            PART_OUT(7) <= MAT_IN(3);
	            PART_OUT(6) <= MAT_IN(2);
	            PART_OUT(5) <= MAT_IN(1);
	            PART_OUT(4) <= MAT_IN(0);
	        ELSIF MAT_IN = "0111" THEN
	            PART_OUT(3) <= MAT_IN(3);
	            PART_OUT(2) <= MAT_IN(2);
	            PART_OUT(1) <= MAT_IN(1);
	            PART_OUT(0) <= MAT_IN(0);
	        END IF;
	     END IF;    
	 END PROCESS ORDER_DATA;

END ARCHITECTURE BEHAVIOURAL;
	   

