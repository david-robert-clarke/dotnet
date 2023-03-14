-- Final Year Project
-- By David Clarke
-- Created on 14_12_2000
Library IEEE;
Use IEEE.STD_LOGIC_1164.ALL;
USE WORK.MATRIX_PACKAGE.ALL;
--
Entity Answer_Store IS
     Port (-- RESET       : IN  ONE_BIT;	-- Entity Controlled by top level clk and reset signal
     	   D           : IN  FIVE_BITS;  
           SEL         : IN  TWO_BITS;  -- The SEL input selects the correct set of latches	
           Q           : OUT TWENTY_BITS);
End Entity Answer_Store;
--
Architecture Behavioural OF Answer_Store IS
     Begin
          
          Process(D, SEL) IS -- RESET
               Begin
                    --	IF RESET = '1' THEN
                    	    -- Q <= X"00000";
                    --	ELSE
                             IF    SEL = "11" THEN  
                                  Q(19 downto 15) <= D; 
                             ELSIF SEL = "10" THEN 
                                  Q(14 downto 10) <= D;
                             ELSIF SEL = "01" THEN 
                                  Q(9 downto 5)   <= D; 
	       	             ELSIF SEL = "00" THEN
	       	                  Q(4 downto 0)   <= D; 
	                     END IF;
	             --   END IF;
	       End Process;
     End Architecture Behavioural;
	       
		    
