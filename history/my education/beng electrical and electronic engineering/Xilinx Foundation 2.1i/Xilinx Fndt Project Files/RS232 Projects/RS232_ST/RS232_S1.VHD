-- ACTIVE-CAD-2-VHDL, 2.5.5.70, Thu Nov 23 22:18:20 2000

library IEEE;
use IEEE.std_logic_1164.all;
-- Simulation netlist only
-- synopsys translate_off
library UNISIM;
use UNISIM.vcomponents.all;
-- synopsys translate_on

entity rs232_s1 is
end rs232_s1;

architecture SCHEMATIC of RS232_S1 is

--COMPONENTS

component CB16CLED port (
	D : in STD_LOGIC_VECTOR (15 downto 0);
	Q : out STD_LOGIC_VECTOR (15 downto 0);
	C : in STD_LOGIC;
	CE : in STD_LOGIC;
	CEO : out STD_LOGIC;
	CLR : in STD_LOGIC;
	L : in STD_LOGIC;
	TC : out STD_LOGIC;
	UP : in STD_LOGIC
); end component;

--SIGNALS

signal X36_I1_Q15_OUT : STD_LOGIC;
signal X36_I1_Q14_OUT : STD_LOGIC;
signal X36_I1_Q13_OUT : STD_LOGIC;
signal X36_I1_Q12_OUT : STD_LOGIC;
signal X36_I1_Q11_OUT : STD_LOGIC;
signal X36_I1_Q10_OUT : STD_LOGIC;
signal X36_I1_Q9_OUT : STD_LOGIC;
signal X36_I1_Q8_OUT : STD_LOGIC;
signal X36_I1_Q7_OUT : STD_LOGIC;
signal X36_I1_Q6_OUT : STD_LOGIC;
signal X36_I1_Q5_OUT : STD_LOGIC;
signal X36_I1_Q4_OUT : STD_LOGIC;
signal X36_I1_Q3_OUT : STD_LOGIC;
signal X36_I1_Q2_OUT : STD_LOGIC;
signal X36_I1_Q1_OUT : STD_LOGIC;
signal X36_I1_Q0_OUT : STD_LOGIC;

--ATRIBUTES





begin


--COMPONENT INSTANCES


end SCHEMATIC;