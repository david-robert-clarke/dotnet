-- ACTIVE-CAD-2-VHDL, 2.5.5.67, Thu Nov 09 01:05:04 2000

library IEEE;
use IEEE.std_logic_1164.all;
-- Simulation netlist only
-- synopsys translate_off
library UNISIM;
use UNISIM.vcomponents.all;
-- synopsys translate_on

entity FDR is port (
	C : in STD_LOGIC;
	D : in STD_LOGIC;
	Q : out STD_LOGIC;
	R : in STD_LOGIC
); end FDR;

architecture SCHEMATIC of FDR is

--COMPONENTS

component FD port (
	C : in STD_LOGIC;
	D : in STD_LOGIC;
	Q : out STD_LOGIC
); end component;

component AND2B1 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

--SIGNALS

signal D_R : STD_LOGIC;

--ATRIBUTES

attribute RLOC : string;

attribute RLOC of X36_1I39: label is "R0C0";



begin

--SIGNAL ASSIGNMENTS


--COMPONENT INSTANCES

X36_1I39 : FD port map(
	C => C,
	D => D_R,
	Q => Q
);
X36_1I41 : AND2B1 port map(
	I0 => R,
	I1 => D,
	O => D_R
);

end SCHEMATIC;