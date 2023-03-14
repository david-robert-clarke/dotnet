-- Final Year Project
-- Created by David Clarke
-- Created 11_12_2000 
library IEEE;
Use IEEE.std_logic_1164.all;

Entity FDR is
Port (D, CLK, RST: IN STD_LOGIC; Q: OUT STD_LOGIC);
End Entity FDR;

Architecture Behavioural of FDR is
Begin
	Flipflop : Process (D, CLK, RST) 
	Begin
	  IF rising_edge(clk) then
	    IF RST = '1' THEN
	      Q <= '0';
	    ELSE
	      Q <= D;
	    END IF;
	  END IF;
	End Process Flipflop;
End Architecture Behavioural;

