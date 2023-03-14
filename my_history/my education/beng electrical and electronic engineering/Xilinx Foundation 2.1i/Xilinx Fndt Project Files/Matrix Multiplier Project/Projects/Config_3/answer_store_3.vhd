-- Final Year Project
-- By David Clarke
-- Created on 14_12_2000
-- Updated on 20_12_2000
Library IEEE;
Use IEEE.STD_LOGIC_1164.ALL;
USE WORK.MATRIX_PACKAGE.ALL;
--
Entity Answer_Store IS
     Port (CLK, RESET  : IN  ONE_BIT;
     	   D           : IN  TWENTY_BITS;  	
           Q           : OUT TWENTY_BITS);
End Entity Answer_Store;
--
Architecture Behavioural OF Answer_Store IS
     Begin
          
          Process(CLK, RESET, D) IS 
               Begin
               		IF RISING_EDGE(CLK) THEN
               		    IF RESET = '1' THEN
               		        Q <= X"00000";
               		    ELSE
                                Q <= D;
                            END IF;
	                END IF;
	       End Process;
     End Architecture Behavioural;
	       
		    
