-- ACTIVE-CAD-2-VHDL, 2.5.5.67, Thu Nov 09 01:05:01 2000

library IEEE;
use IEEE.std_logic_1164.all;
-- Simulation netlist only
-- synopsys translate_off
library UNISIM;
use UNISIM.vcomponents.all;
-- synopsys translate_on

entity CONTROLBEAST is port (
	CLK : in STD_LOGIC;
	CT1Z : in STD_LOGIC;
	RESET : in STD_LOGIC;
	S : in STD_LOGIC;
	CDDEN : out STD_LOGIC;
	CT1EN : out STD_LOGIC;
	DECEN : out STD_LOGIC;
	LOAD : out STD_LOGIC;
	PTEN : out STD_LOGIC;
	UP : out STD_LOGIC
); end CONTROLBEAST;

architecture SCHEMATIC of CONTROLBEAST is

--COMPONENTS

component FDR port (
	C : in STD_LOGIC;
	D : in STD_LOGIC;
	Q : out STD_LOGIC;
	R : in STD_LOGIC
); end component;

component OR3 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component AND2 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component AND4B3 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	I3 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component AND4B2 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	I3 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component AND3 port (
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

component AND4B1 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	I3 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component AND2B1 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component OR6 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	I3 : in STD_LOGIC;
	I4 : in STD_LOGIC;
	I5 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component AND3B1 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component AND3B2 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

--SIGNALS

signal CS0 : STD_LOGIC;
signal CS1 : STD_LOGIC;
signal X36_NET00012_X95 : STD_LOGIC;
signal CS2 : STD_LOGIC;
signal X36_NET00003_X95 : STD_LOGIC;
signal X36_NET00013_X95 : STD_LOGIC;
signal X36_NET00014_X95 : STD_LOGIC;
signal X36_NET00001_X95 : STD_LOGIC;
signal X36_NET00002_X95 : STD_LOGIC;
signal X36_NET00015_X95 : STD_LOGIC;
signal X36_NET00016_X95 : STD_LOGIC;
signal X36_NET00017_X95 : STD_LOGIC;
signal X36_NET00018_X95 : STD_LOGIC;
signal X36_NET00019_X95 : STD_LOGIC;
signal X36_NET00020_X95 : STD_LOGIC;
signal X36_NET00021_X95 : STD_LOGIC;
signal X36_NET00022_X95 : STD_LOGIC;
signal X36_NET00023_X95 : STD_LOGIC;

--ATRIBUTES





begin

--SIGNAL ASSIGNMENTS


--COMPONENT INSTANCES

U1 : FDR port map(
	C => CLK,
	D => X36_NET00001_X95,
	Q => CS2,
	R => RESET
);
U2 : FDR port map(
	C => CLK,
	D => X36_NET00002_X95,
	Q => CS1,
	R => RESET
);
U3 : FDR port map(
	C => CLK,
	D => X36_NET00003_X95,
	Q => CS0,
	R => RESET
);
U4 : OR3 port map(
	I0 => X36_NET00018_X95,
	I1 => X36_NET00012_X95,
	I2 => CS1,
	O => X36_NET00002_X95
);
U5 : AND2 port map(
	I0 => CS1,
	I1 => CS2,
	O => X36_NET00016_X95
);
U6 : AND4B3 port map(
	I0 => CS0,
	I1 => CS1,
	I2 => CS2,
	I3 => S,
	O => X36_NET00021_X95
);
U7 : AND4B3 port map(
	I0 => S,
	I1 => CT1Z,
	I2 => CS2,
	I3 => CS0,
	O => X36_NET00012_X95
);
U8 : AND4B2 port map(
	I0 => S,
	I1 => CS2,
	I2 => CT1Z,
	I3 => CS0,
	O => X36_NET00018_X95
);
U9 : AND3 port map(
	I0 => CS0,
	I1 => CS1,
	I2 => CS2,
	O => X36_NET00022_X95
);
U10 : OR2 port map(
	I0 => X36_NET00017_X95,
	I1 => X36_NET00016_X95,
	O => X36_NET00001_X95
);
U11 : AND4B2 port map(
	I0 => CS1,
	I1 => CS2,
	I2 => CS0,
	I3 => S,
	O => X36_NET00015_X95
);
U12 : AND4B3 port map(
	I0 => S,
	I1 => CS2,
	I2 => CS1,
	I3 => CS0,
	O => X36_NET00019_X95
);
U13 : AND4B1 port map(
	I0 => CS0,
	I1 => CS1,
	I2 => CS2,
	I3 => CT1Z,
	O => X36_NET00020_X95
);
U14 : AND2B1 port map(
	I0 => CS0,
	I1 => CS1,
	O => X36_NET00017_X95
);
U15 : OR6 port map(
	I0 => X36_NET00022_X95,
	I1 => X36_NET00020_X95,
	I2 => X36_NET00013_X95,
	I3 => X36_NET00015_X95,
	I4 => X36_NET00019_X95,
	I5 => X36_NET00021_X95,
	O => X36_NET00003_X95
);
U16 : AND4B2 port map(
	I0 => S,
	I1 => CS2,
	I2 => CS1,
	I3 => CS0,
	O => X36_NET00013_X95
);
U17 : AND2B1 port map(
	I0 => CS0,
	I1 => CS1,
	O => X36_NET00023_X95
);
U18 : AND2B1 port map(
	I0 => CS2,
	I1 => CS1,
	O => X36_NET00014_X95
);
U19 : OR2 port map(
	I0 => X36_NET00014_X95,
	I1 => X36_NET00023_X95,
	O => CT1EN
);
U20 : AND3B1 port map(
	I0 => CS2,
	I1 => CS1,
	I2 => CS0,
	O => UP
);
U21 : AND3B2 port map(
	I0 => CS2,
	I1 => CS0,
	I2 => CS1,
	O => LOAD
);
U22 : AND3 port map(
	I0 => CS0,
	I1 => CS1,
	I2 => CS2,
	O => PTEN
);
U23 : AND3B2 port map(
	I0 => CS2,
	I1 => CS0,
	I2 => CS1,
	O => DECEN
);
U24 : AND3B2 port map(
	I0 => CS2,
	I1 => CS0,
	I2 => CS1,
	O => CDDEN
);

end SCHEMATIC;