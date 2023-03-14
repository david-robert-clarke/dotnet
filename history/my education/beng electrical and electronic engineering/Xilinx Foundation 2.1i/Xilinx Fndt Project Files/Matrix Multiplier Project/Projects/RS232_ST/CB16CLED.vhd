-- ACTIVE-CAD-2-VHDL, 2.5.5.70, Thu Nov 23 22:18:26 2000

library IEEE;
use IEEE.std_logic_1164.all;
-- Simulation netlist only
-- synopsys translate_off
library UNISIM;
use UNISIM.vcomponents.all;
-- synopsys translate_on

entity CB16CLED is port (
	D : in STD_LOGIC_VECTOR (15 downto 0);
	Q : out STD_LOGIC_VECTOR (15 downto 0);
	C : in STD_LOGIC;
	CE : in STD_LOGIC;
	CEO : out STD_LOGIC;
	CLR : in STD_LOGIC;
	L : in STD_LOGIC;
	TC : out STD_LOGIC;
	UP : in STD_LOGIC
); end CB16CLED;

architecture SCHEMATIC of CB16CLED is

--COMPONENTS

component AND2 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component OR2 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component AND2B1 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component AND3B2 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component AND3 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component AND4 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	I3 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component AND4B3 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	I3 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component AND5B4 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	I3 : in STD_LOGIC;
	I4 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component AND5 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	I3 : in STD_LOGIC;
	I4 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component AND2B2 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component VCC port (
	P : out STD_LOGIC
); end component;

component AND4B4 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	I3 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component AND3B3 port (
	I0 : in STD_LOGIC;
	I1 : in STD_LOGIC;
	I2 : in STD_LOGIC;
	O : out STD_LOGIC
); end component;

component FTCLEX port (
	C : in STD_LOGIC;
	CE : in STD_LOGIC;
	CLR : in STD_LOGIC;
	D : in STD_LOGIC;
	L : in STD_LOGIC;
	Q : out STD_LOGIC;
	T : in STD_LOGIC
); end component;

component M2_1B1 port (
	D0 : in STD_LOGIC;
	D1 : in STD_LOGIC;
	O : out STD_LOGIC;
	S0 : in STD_LOGIC
); end component;

component M2_1 port (
	D0 : in STD_LOGIC;
	D1 : in STD_LOGIC;
	O : out STD_LOGIC;
	S0 : in STD_LOGIC
); end component;

--SIGNALS

signal X36_NET00334_X95 : STD_LOGIC;
signal OR_CE_L : STD_LOGIC;
signal T1 : STD_LOGIC;
signal T10 : STD_LOGIC;
signal T10_DN : STD_LOGIC;
signal T10_UP : STD_LOGIC;
signal T11 : STD_LOGIC;
signal T11_DN : STD_LOGIC;
signal T11_UP : STD_LOGIC;
signal T12 : STD_LOGIC;
signal T12_DN : STD_LOGIC;
signal T12_UP : STD_LOGIC;
signal T13 : STD_LOGIC;
signal T13_DN : STD_LOGIC;
signal T13_UP : STD_LOGIC;
signal T14 : STD_LOGIC;
signal T14_DN : STD_LOGIC;
signal T14_UP : STD_LOGIC;
signal T15 : STD_LOGIC;
signal T15_DN : STD_LOGIC;
signal T15_UP : STD_LOGIC;
signal T2 : STD_LOGIC;
signal T2_DN : STD_LOGIC;
signal T2_UP : STD_LOGIC;
signal T3 : STD_LOGIC;
signal T3_DN : STD_LOGIC;
signal T3_UP : STD_LOGIC;
signal T4 : STD_LOGIC;
signal T4_DN : STD_LOGIC;
signal T4_UP : STD_LOGIC;
signal T5 : STD_LOGIC;
signal T5_DN : STD_LOGIC;
signal T5_UP : STD_LOGIC;
signal T6 : STD_LOGIC;
signal T6_DN : STD_LOGIC;
signal T6_UP : STD_LOGIC;
signal T7 : STD_LOGIC;
signal T7_DN : STD_LOGIC;
signal T7_UP : STD_LOGIC;
signal T8 : STD_LOGIC;
signal T8_DN : STD_LOGIC;
signal T8_UP : STD_LOGIC;
signal T9 : STD_LOGIC;
signal T9_DN : STD_LOGIC;
signal T9_UP : STD_LOGIC;
signal TC_DN : STD_LOGIC;
signal TC_UP : STD_LOGIC;
signal Q15_ASSIGN_I0 : STD_LOGIC;
signal TC_ASSIGN_I1 : STD_LOGIC;
signal Q14_ASSIGN_I0 : STD_LOGIC;
signal Q13_ASSIGN_I0 : STD_LOGIC;
signal Q12_ASSIGN_I0 : STD_LOGIC;
signal Q11_ASSIGN_I0 : STD_LOGIC;
signal Q10_ASSIGN_I0 : STD_LOGIC;
signal Q9_ASSIGN_I0 : STD_LOGIC;
signal Q8_ASSIGN_I0 : STD_LOGIC;
signal Q7_ASSIGN_I0 : STD_LOGIC;
signal Q6_ASSIGN_I0 : STD_LOGIC;
signal Q5_ASSIGN_I0 : STD_LOGIC;
signal Q4_ASSIGN_I0 : STD_LOGIC;
signal Q3_ASSIGN_I0 : STD_LOGIC;
signal Q2_ASSIGN_I0 : STD_LOGIC;
signal Q1_ASSIGN_I0 : STD_LOGIC;
signal Q0_ASSIGN_D0 : STD_LOGIC;

--ATRIBUTES





begin

--SIGNAL ASSIGNMENTS

Q(15) <= Q15_ASSIGN_I0;
TC <= TC_ASSIGN_I1;
Q(14) <= Q14_ASSIGN_I0;
Q(13) <= Q13_ASSIGN_I0;
Q(12) <= Q12_ASSIGN_I0;
Q(11) <= Q11_ASSIGN_I0;
Q(10) <= Q10_ASSIGN_I0;
Q(9) <= Q9_ASSIGN_I0;
Q(8) <= Q8_ASSIGN_I0;
Q(7) <= Q7_ASSIGN_I0;
Q(6) <= Q6_ASSIGN_I0;
Q(5) <= Q5_ASSIGN_I0;
Q(4) <= Q4_ASSIGN_I0;
Q(3) <= Q3_ASSIGN_I0;
Q(2) <= Q2_ASSIGN_I0;
Q(1) <= Q1_ASSIGN_I0;
Q(0) <= Q0_ASSIGN_D0;

--COMPONENT INSTANCES

X36_1I120 : AND2 port map(
	I0 => CE,
	I1 => TC_ASSIGN_I1,
	O => CEO
);
X36_1I130 : OR2 port map(
	I0 => CE,
	I1 => L,
	O => OR_CE_L
);
X36_1I53 : AND2B1 port map(
	I0 => Q8_ASSIGN_I0,
	I1 => T8,
	O => T9_DN
);
X36_1I54 : AND3B2 port map(
	I0 => Q9_ASSIGN_I0,
	I1 => Q8_ASSIGN_I0,
	I2 => T8,
	O => T10_DN
);
X36_1I55 : AND3 port map(
	I0 => Q9_ASSIGN_I0,
	I1 => Q8_ASSIGN_I0,
	I2 => T8,
	O => T10_UP
);
X36_1I56 : AND4 port map(
	I0 => Q10_ASSIGN_I0,
	I1 => Q9_ASSIGN_I0,
	I2 => Q8_ASSIGN_I0,
	I3 => T8,
	O => T11_UP
);
X36_1I57 : AND4B3 port map(
	I0 => Q10_ASSIGN_I0,
	I1 => Q9_ASSIGN_I0,
	I2 => Q8_ASSIGN_I0,
	I3 => T8,
	O => T11_DN
);
X36_1I58 : AND5B4 port map(
	I0 => Q11_ASSIGN_I0,
	I1 => Q10_ASSIGN_I0,
	I2 => Q9_ASSIGN_I0,
	I3 => Q8_ASSIGN_I0,
	I4 => T8,
	O => T12_DN
);
X36_1I59 : AND5 port map(
	I0 => Q11_ASSIGN_I0,
	I1 => Q10_ASSIGN_I0,
	I2 => Q9_ASSIGN_I0,
	I3 => Q8_ASSIGN_I0,
	I4 => T8,
	O => T12_UP
);
X36_1I60 : AND2 port map(
	I0 => Q8_ASSIGN_I0,
	I1 => T8,
	O => T9_UP
);
X36_1I61 : AND2B1 port map(
	I0 => Q12_ASSIGN_I0,
	I1 => T12,
	O => T13_DN
);
X36_1I62 : AND3B2 port map(
	I0 => Q13_ASSIGN_I0,
	I1 => Q12_ASSIGN_I0,
	I2 => T12,
	O => T14_DN
);
X36_1I63 : AND3 port map(
	I0 => Q13_ASSIGN_I0,
	I1 => Q12_ASSIGN_I0,
	I2 => T12,
	O => T14_UP
);
X36_1I64 : AND4 port map(
	I0 => Q14_ASSIGN_I0,
	I1 => Q13_ASSIGN_I0,
	I2 => Q12_ASSIGN_I0,
	I3 => T12,
	O => T15_UP
);
X36_1I65 : AND4B3 port map(
	I0 => Q14_ASSIGN_I0,
	I1 => Q13_ASSIGN_I0,
	I2 => Q12_ASSIGN_I0,
	I3 => T12,
	O => T15_DN
);
X36_1I66 : AND5B4 port map(
	I0 => Q15_ASSIGN_I0,
	I1 => Q14_ASSIGN_I0,
	I2 => Q13_ASSIGN_I0,
	I3 => Q12_ASSIGN_I0,
	I4 => T12,
	O => TC_DN
);
X36_1I68 : AND5 port map(
	I0 => Q15_ASSIGN_I0,
	I1 => Q14_ASSIGN_I0,
	I2 => Q13_ASSIGN_I0,
	I3 => Q12_ASSIGN_I0,
	I4 => T12,
	O => TC_UP
);
X36_1I69 : AND2 port map(
	I0 => Q12_ASSIGN_I0,
	I1 => T12,
	O => T13_UP
);
X36_1I70 : AND2 port map(
	I0 => Q4_ASSIGN_I0,
	I1 => T4,
	O => T5_UP
);
X36_1I71 : AND5 port map(
	I0 => Q7_ASSIGN_I0,
	I1 => Q6_ASSIGN_I0,
	I2 => Q5_ASSIGN_I0,
	I3 => Q4_ASSIGN_I0,
	I4 => T4,
	O => T8_UP
);
X36_1I72 : AND5B4 port map(
	I0 => Q7_ASSIGN_I0,
	I1 => Q6_ASSIGN_I0,
	I2 => Q5_ASSIGN_I0,
	I3 => Q4_ASSIGN_I0,
	I4 => T4,
	O => T8_DN
);
X36_1I73 : AND4B3 port map(
	I0 => Q6_ASSIGN_I0,
	I1 => Q5_ASSIGN_I0,
	I2 => Q4_ASSIGN_I0,
	I3 => T4,
	O => T7_DN
);
X36_1I74 : AND4 port map(
	I0 => Q6_ASSIGN_I0,
	I1 => Q5_ASSIGN_I0,
	I2 => Q4_ASSIGN_I0,
	I3 => T4,
	O => T7_UP
);
X36_1I77 : AND3 port map(
	I0 => Q5_ASSIGN_I0,
	I1 => Q4_ASSIGN_I0,
	I2 => T4,
	O => T6_UP
);
X36_1I83 : AND3B2 port map(
	I0 => Q5_ASSIGN_I0,
	I1 => Q4_ASSIGN_I0,
	I2 => T4,
	O => T6_DN
);
X36_1I84 : AND2B1 port map(
	I0 => Q4_ASSIGN_I0,
	I1 => T4,
	O => T5_DN
);
X36_1I86 : AND2 port map(
	I0 => Q1_ASSIGN_I0,
	I1 => Q0_ASSIGN_D0,
	O => T2_UP
);
X36_1I87 : AND2B2 port map(
	I0 => Q1_ASSIGN_I0,
	I1 => Q0_ASSIGN_D0,
	O => T2_DN
);
X36_1I90 : VCC port map(
	P => X36_NET00334_X95
);
X36_1I94 : AND4B4 port map(
	I0 => Q3_ASSIGN_I0,
	I1 => Q2_ASSIGN_I0,
	I2 => Q1_ASSIGN_I0,
	I3 => Q0_ASSIGN_D0,
	O => T4_DN
);
X36_1I95 : AND3B3 port map(
	I0 => Q2_ASSIGN_I0,
	I1 => Q1_ASSIGN_I0,
	I2 => Q0_ASSIGN_D0,
	O => T3_DN
);
X36_1I96 : AND3 port map(
	I0 => Q2_ASSIGN_I0,
	I1 => Q1_ASSIGN_I0,
	I2 => Q0_ASSIGN_D0,
	O => T3_UP
);
X36_1I99 : AND4 port map(
	I0 => Q3_ASSIGN_I0,
	I1 => Q2_ASSIGN_I0,
	I2 => Q1_ASSIGN_I0,
	I3 => Q0_ASSIGN_D0,
	O => T4_UP
);
Q0_COMP : FTCLEX port map(
	C => C,
	CE => OR_CE_L,
	CLR => CLR,
	D => D(0),
	L => L,
	Q => Q0_ASSIGN_D0,
	T => X36_NET00334_X95
);
Q1_COMP : FTCLEX port map(
	C => C,
	CE => OR_CE_L,
	CLR => CLR,
	D => D(1),
	L => L,
	Q => Q1_ASSIGN_I0,
	T => T1
);
Q10_COMP : FTCLEX port map(
	C => C,
	CE => OR_CE_L,
	CLR => CLR,
	D => D(10),
	L => L,
	Q => Q10_ASSIGN_I0,
	T => T10
);
Q11_COMP : FTCLEX port map(
	C => C,
	CE => OR_CE_L,
	CLR => CLR,
	D => D(11),
	L => L,
	Q => Q11_ASSIGN_I0,
	T => T11
);
Q12_COMP : FTCLEX port map(
	C => C,
	CE => OR_CE_L,
	CLR => CLR,
	D => D(12),
	L => L,
	Q => Q12_ASSIGN_I0,
	T => T12
);
Q13_COMP : FTCLEX port map(
	C => C,
	CE => OR_CE_L,
	CLR => CLR,
	D => D(13),
	L => L,
	Q => Q13_ASSIGN_I0,
	T => T13
);
Q14_COMP : FTCLEX port map(
	C => C,
	CE => OR_CE_L,
	CLR => CLR,
	D => D(14),
	L => L,
	Q => Q14_ASSIGN_I0,
	T => T14
);
Q15_COMP : FTCLEX port map(
	C => C,
	CE => OR_CE_L,
	CLR => CLR,
	D => D(15),
	L => L,
	Q => Q15_ASSIGN_I0,
	T => T15
);
Q2_COMP : FTCLEX port map(
	C => C,
	CE => OR_CE_L,
	CLR => CLR,
	D => D(2),
	L => L,
	Q => Q2_ASSIGN_I0,
	T => T2
);
Q3_COMP : FTCLEX port map(
	C => C,
	CE => OR_CE_L,
	CLR => CLR,
	D => D(3),
	L => L,
	Q => Q3_ASSIGN_I0,
	T => T3
);
Q4_COMP : FTCLEX port map(
	C => C,
	CE => OR_CE_L,
	CLR => CLR,
	D => D(4),
	L => L,
	Q => Q4_ASSIGN_I0,
	T => T4
);
Q5_COMP : FTCLEX port map(
	C => C,
	CE => OR_CE_L,
	CLR => CLR,
	D => D(5),
	L => L,
	Q => Q5_ASSIGN_I0,
	T => T5
);
Q6_COMP : FTCLEX port map(
	C => C,
	CE => OR_CE_L,
	CLR => CLR,
	D => D(6),
	L => L,
	Q => Q6_ASSIGN_I0,
	T => T6
);
Q7_COMP : FTCLEX port map(
	C => C,
	CE => OR_CE_L,
	CLR => CLR,
	D => D(7),
	L => L,
	Q => Q7_ASSIGN_I0,
	T => T7
);
Q8_COMP : FTCLEX port map(
	C => C,
	CE => OR_CE_L,
	CLR => CLR,
	D => D(8),
	L => L,
	Q => Q8_ASSIGN_I0,
	T => T8
);
Q9_COMP : FTCLEX port map(
	C => C,
	CE => OR_CE_L,
	CLR => CLR,
	D => D(9),
	L => L,
	Q => Q9_ASSIGN_I0,
	T => T9
);
T1_COMP : M2_1B1 port map(
	D0 => Q0_ASSIGN_D0,
	D1 => Q0_ASSIGN_D0,
	O => T1,
	S0 => UP
);
T10_COMP : M2_1 port map(
	D0 => T10_DN,
	D1 => T10_UP,
	O => T10,
	S0 => UP
);
T11_COMP : M2_1 port map(
	D0 => T11_DN,
	D1 => T11_UP,
	O => T11,
	S0 => UP
);
T12_COMP : M2_1 port map(
	D0 => T12_DN,
	D1 => T12_UP,
	O => T12,
	S0 => UP
);
T13_COMP : M2_1 port map(
	D0 => T13_DN,
	D1 => T13_UP,
	O => T13,
	S0 => UP
);
T14_COMP : M2_1 port map(
	D0 => T14_DN,
	D1 => T14_UP,
	O => T14,
	S0 => UP
);
T15_COMP : M2_1 port map(
	D0 => T15_DN,
	D1 => T15_UP,
	O => T15,
	S0 => UP
);
T2_COMP : M2_1 port map(
	D0 => T2_DN,
	D1 => T2_UP,
	O => T2,
	S0 => UP
);
T3_COMP : M2_1 port map(
	D0 => T3_DN,
	D1 => T3_UP,
	O => T3,
	S0 => UP
);
T4_COMP : M2_1 port map(
	D0 => T4_DN,
	D1 => T4_UP,
	O => T4,
	S0 => UP
);
T5_COMP : M2_1 port map(
	D0 => T5_DN,
	D1 => T5_UP,
	O => T5,
	S0 => UP
);
T6_COMP : M2_1 port map(
	D0 => T6_DN,
	D1 => T6_UP,
	O => T6,
	S0 => UP
);
T7_COMP : M2_1 port map(
	D0 => T7_DN,
	D1 => T7_UP,
	O => T7,
	S0 => UP
);
T8_COMP : M2_1 port map(
	D0 => T8_DN,
	D1 => T8_UP,
	O => T8,
	S0 => UP
);
T9_COMP : M2_1 port map(
	D0 => T9_DN,
	D1 => T9_UP,
	O => T9,
	S0 => UP
);
TC_COMP : M2_1 port map(
	D0 => TC_DN,
	D1 => TC_UP,
	O => TC_ASSIGN_I1,
	S0 => UP
);

end SCHEMATIC;