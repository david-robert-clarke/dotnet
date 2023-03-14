-- ACTIVE-CAD-2-VHDL, 2.5.5.67, Thu Nov 09 01:05:05 2000

library IEEE;
use IEEE.std_logic_1164.all;
-- Simulation netlist only
-- synopsys translate_off
library UNISIM;
use UNISIM.vcomponents.all;
-- synopsys translate_on

entity OR6 is port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	I3 : in STD_LOGIC;
	I4 : in STD_LOGIC;
	I5 : in STD_LOGIC;
	O : out STD_LOGIC
); end OR6;

architecture SCHEMATIC of OR6 is

--COMPONENTS

component OR3 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component OR2 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

--SIGNALS

signal I12 : STD_LOGIC;
signal I35 : STD_LOGIC;

--ATRIBUTES





begin

--SIGNAL ASSIGNMENTS


--COMPONENT INSTANCES

X36_1I69 : OR3 port map(
	I0 => I3,
	I1 => I4,
	I2 => I5,
	O => I35
);
X36_1I84 : OR2 port map(
	I0 => I1,
	I1 => I2,
	O => I12
);
X36_1I85 : OR3 port map(
	I0 => I0,
	I1 => I12,
	I2 => I35,
	O => O
);

end SCHEMATIC;