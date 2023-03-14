Library IEEE;
USE IEEE.std_logic_1164.all;

Entity full_adder is
Port (In1, In2, c_in : IN std_logic; 
      sum, c_out : OUT std_logic);
END Entity full_adder;

Architecture dave OF full_adder is
component half_adder is
port (x, y : in std_logic; sum, carry : out std_logic);
end component half_adder;

component or2 is
port (I0, I1 : IN std_logic; O : out std_logic);
end component or2;
	
signal s1, s2, s3 : std_logic;
Begin

H1: half_adder port map (x => In1, y => In2, sum => s1, carry => s3);
	
H2: half_adder port map (x => s1, y => c_in, sum => sum, carry => s2);

A2: or2 port map ( I0 => s2, I1 => s3, O => c_out);
	
End architecture dave;


