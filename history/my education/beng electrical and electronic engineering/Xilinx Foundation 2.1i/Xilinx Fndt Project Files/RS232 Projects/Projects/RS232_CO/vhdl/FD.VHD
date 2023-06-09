-- ACTIVE-CAD-2-VHDL, 2.5.5.67, Thu Nov 09 01:05:07 2000

library IEEE;
use IEEE.std_logic_1164.all;
-- Simulation netlist only
-- synopsys translate_off
library UNISIM;
use UNISIM.vcomponents.all;
-- synopsys translate_on

entity FD is port (
	C : in STD_LOGIC;
	D : in STD_LOGIC;
	Q : out STD_LOGIC
); end FD;

architecture SCHEMATIC of FD is

--COMPONENTS

component FDCE port (
	D : in STD_LOGIC;
	C : in STD_LOGIC;
	CE : in STD_LOGIC;
	CLR : in STD_LOGIC;
	Q : out STD_LOGIC
); end component;

component VCC port (
	P : out STD_LOGIC
); end component;

component GND port (
	G : out STD_LOGIC
); end component;

--SIGNALS

signal X36_NET01050_X95 : STD_LOGIC;
signal X36_NET01051_X95 : STD_LOGIC;

--ATRIBUTES

attribute RLOC : string;
attribute INIT : string;

attribute RLOC of X36_1I37: label is "R0C0";
attribute INIT of X36_1I37: label is "R";



begin

--SIGNAL ASSIGNMENTS


--COMPONENT INSTANCES

X36_1I37 : FDCE port map(
	D => D,
	C => C,
	CE => X36_NET01050_X95,
	CLR => X36_NET01051_X95,
	Q => Q
);
X36_1I40 : VCC port map(
	P => X36_NET01050_X95
);
X36_1I43 : GND port map(
	G => X36_NET01051_X95
);

end SCHEMATIC;