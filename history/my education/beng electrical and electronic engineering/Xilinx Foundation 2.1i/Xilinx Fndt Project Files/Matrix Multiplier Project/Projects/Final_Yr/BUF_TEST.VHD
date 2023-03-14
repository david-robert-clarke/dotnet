-- ACTIVE-CAD-2-VHDL, 2.5.5.70, Wed Nov 29 19:16:32 2000

library IEEE;
use IEEE.std_logic_1164.all;
-- Simulation netlist only
-- synopsys translate_off
library UNISIM;
use UNISIM.vcomponents.all;
-- synopsys translate_on

entity buf_test is port (
	CLR : in STD_LOGIC;
	CLK : in STD_LOGIC;
	CE : in STD_LOGIC;
	D : in STD_LOGIC;
	OUT_KEYWORD : out STD_LOGIC
); end BUF_TEST;

architecture SCHEMATIC of BUF_TEST is

--COMPONENTS

component FDCE port (
	D : in STD_LOGIC;
	C : in STD_LOGIC;
	CE : in STD_LOGIC;
	CLR : in STD_LOGIC;
	Q : out STD_LOGIC
); end component;

--SIGNALS


--ATRIBUTES

attribute INIT : string;

attribute INIT of X36_I40: label is "R";



begin

--SIGNAL ASSIGNMENTS


--COMPONENT INSTANCES

X36_I40 : FDCE port map(
	D => D,
	C => CLK,
	CE => CE,
	CLR => CLR,
	Q => OUT_KEYWORD
);

end SCHEMATIC;