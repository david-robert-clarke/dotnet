-- Created by David Clarke for the RS232 assignment
library IEEE;
use IEEE.std_logic_1164.all;

entity INV is
    port (a: in STD_LOGIC; z: out STD_LOGIC);
end INV;

architecture behavioural of INV is
begin
  
  z <= NOT a;
  
end behavioural;
