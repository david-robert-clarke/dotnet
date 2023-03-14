Library IEEE;
USE IEEE.std_Logic_1164.all;
USE WORK.ALL; -- Optional, because the VHDL file is attatched to the project, which in turn has libraries 
	      -- attatched to it. The USE WORK.ALL is not needed

Entity Adders is
Port (C, I, I2 : IN STD_LOGIC; S, CO : OUT STD_LOGIC);
End Entity Adders;

Architecture Structural OF Adders IS
	component Full_Adder IS
	Port (C_IN, IN1, IN2 : IN STD_LOGIC; SUM, C_OUT : OUT STD_LOGIC);
	end component Full_Adder;
	
	component Half_Adder IS
	Port (X, Y : IN STD_LOGIC; SUM, CARRY : OUT STD_LOGIC);
	End component Half_Adder;
	
	for DRINK: Full_Adder use entity WORK.Full_Adder(arch); -- don't have to specify target architecture
	for ARSE : Half_Adder use entity WORK.Half_Adder(structural); -- because only one exists for the full and half adders

Begin

	DRINK: Full_Adder port map (C_IN => C, IN1 => I, IN2 => I2, SUM => S, C_OUT => CO);
	ARSE : Half_Adder port map (X => C, Y => I, SUM => S, CARRY => CO);
	
	-- Always remember to instatiate correctly, assign a personally named port to the components
	-- inputs and outputs
End Architecture Structural; 
	
