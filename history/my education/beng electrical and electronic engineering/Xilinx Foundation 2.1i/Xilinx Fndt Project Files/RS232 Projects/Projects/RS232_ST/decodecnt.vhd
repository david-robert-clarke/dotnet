-- Created by David Clarke for the RS232 assignment
library IEEE;
USE IEEE.STD_LOGIC_1164.all;

ENTITY CDDECODE IS
PORT (CDDEN, CLR, S19200, S9600, S4800, S2400, S1200, S600, S300 : IN STD_LOGIC; CNT : OUT STD_LOGIC_VECTOR (15 downto 0));
END ENTITY CDDECODE;
--
ARCHITECTURE CDDECODE_ARCH OF CDDECODE IS
	BEGIN
	
	PROCESS (CDDEN, CLR, S19200, S9600, S4800, S2400, S1200, S600, S300)
		BEGIN
		IF CLR = '1' THEN
			CNT <= "0000000000000000";
		
		ELSIF CDDEN = '1' AND CLR = '0' THEN
			IF    S300   = '1' THEN CNT <= "0011101010011000";
			ELSIF S600   = '1' THEN CNT <= "0001110101001100";
			ELSIF S1200  = '1' THEN CNT <= "0000111010100110";
			ELSIF S2400  = '1' THEN CNT <= "0000011101010011";
			ELSIF S4800  = '1' THEN CNT <= "0000001110101001";
			ELSIF S9600  = '1' THEN CNT <= "0000000111010100";
			ELSIF S19200 = '1' THEN CNT <= "0000000011101010";
			END IF;
		END IF;
	END PROCESS;
END ARCHITECTURE CDDECODE_ARCH;
		