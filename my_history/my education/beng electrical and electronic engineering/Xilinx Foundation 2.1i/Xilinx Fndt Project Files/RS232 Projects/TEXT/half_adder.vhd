Library IEEE;
Use IEEE.std_logic_1164.all;

Entity Half_Adder IS
Port (x, y : IN std_logic; sum, carry : out std_logic);
End Entity Half_Adder;

Architecture Structural OF Half_Adder IS

Component xor2 is
port (I0, I1 : in std_logic; O : out std_logic);
end component xor2;

Component And2 is
port (I0, I1 : in std_logic; O : out std_logic);
end Component And2;

Begin 

XOROFICE : xor2 port map (I0 => x, I1 => y, O => Sum);

ANDYB : And2 port map (I0 => x, I1 => y, O => Carry);

End Architecture Structural;
