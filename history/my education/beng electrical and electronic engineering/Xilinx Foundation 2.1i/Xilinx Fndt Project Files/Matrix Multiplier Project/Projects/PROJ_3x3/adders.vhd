-- Final Year Project
-- By David Clarke
-- Created 1_2_2001
library IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
USE IEEE.STD_LOGIC_ARITH.ALL;
USE WORK.MATRIX_PACKAGE.ALL;

Entity ADDERS is
Port ( PROD26, PROD25, PROD24, PROD23, PROD22, PROD21, PROD20, PROD19, PROD18, PROD17,
       PROD16, PROD15, PROD14, PROD13, PROD12, PROD11, PROD10, PROD9, PROD8, PROD7,
       PROD6, PROD5, PROD4, PROD3, PROD2, PROD1, PROD0 : IN U_NIBBLE;
       OUTPUT8, OUTPUT7, OUTPUT6, OUTPUT5, OUTPUT4, 
       OUTPUT3, OUTPUT2, OUTPUT1, OUTPUT0 : OUT U_FIVE_BITS);
       -- ANSWER FROM ADDER CAN BE AT MAX AN INTEGER VALUE OF 27 WHICH IS 5-BITS WIDE
End Entity ADDERS;

ARCHITECTURE BEHAVIOURAL OF ADDERS IS
BEGIN

        -- ONE ADDER IS USED PER THREE MULTIPLIERS HENCE NINE ADDERS ARE REQUIRED AS SHOWN 
	PROCESS (PROD26, PROD25, PROD24)
	Begin
        OUTPUT8 <= ('0' & PROD26) + ('0' & PROD25) + ('0' & PROD24);
        END PROCESS;
        
        PROCESS (PROD23, PROD22, PROD21)
	Begin
        OUTPUT7 <= ('0' & PROD23) + ('0' & PROD22) + ('0' & PROD21);
        END PROCESS;
        
        PROCESS (PROD20, PROD19, PROD18)
	Begin
        OUTPUT6 <= ('0' & PROD20) + ('0' & PROD19) + ('0' & PROD18);
        END PROCESS;
        
        PROCESS (PROD17, PROD16, PROD15)
	Begin
        OUTPUT5 <= ('0' & PROD17) + ('0' & PROD16) + ('0' & PROD15);
        END PROCESS;
        
        PROCESS (PROD14, PROD13, PROD12)
	Begin
        OUTPUT4 <= ('0' & PROD14) + ('0' & PROD13) + ('0' & PROD12);
        END PROCESS;
        
        PROCESS (PROD11, PROD10, PROD9)
	Begin
        OUTPUT3 <= ('0' & PROD11) + ('0' & PROD10) + ('0' & PROD9);
        END PROCESS;
        
        PROCESS (PROD8, PROD7, PROD6)
	Begin
        OUTPUT2 <= ('0' & PROD8) + ('0' & PROD7) + ('0' & PROD6);
        END PROCESS;
        
        PROCESS (PROD5, PROD4, PROD3)
	Begin
        OUTPUT1 <= ('0' & PROD5) + ('0' & PROD4) + ('0' & PROD3);
        END PROCESS;

	PROCESS (PROD2, PROD1, PROD0)
	Begin
        OUTPUT0 <= ('0' & PROD2) + ('0' & PROD1) + ('0' & PROD0);
        END PROCESS;

-- '0' & is the concatenation operator which allows the carry to be passed to the output 

END ARCHITECTURE BEHAVIOURAL; 
                                      
                                      
                                       
