-- Created by David Clarke for the RS232 assignment
library IEEE;
Use IEEE.std_logic_1164.all;

Entity FDC0 is
Port (D, CLK, CLR: IN STD_LOGIC; 
      Q  : OUT STD_LOGIC);
End Entity FDC0;

Architecture Behavioural of FDC0 is
Begin
	Tri : Process (D, CLK, CLR) 
	Begin
	  IF CLR = '1' THEN
	    Q <= '0';
	  ELSE 
	      IF CLK = '1' then
	           Q <= D;
	      ELSE 
	           Q <= NOT D;
	      END IF;
	  END IF;
	End Process Tri;
End Architecture Behavioural;

