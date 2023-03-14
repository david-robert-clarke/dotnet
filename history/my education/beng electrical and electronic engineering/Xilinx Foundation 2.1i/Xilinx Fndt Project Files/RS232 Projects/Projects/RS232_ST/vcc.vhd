-- Created by David Clarke for the RS232 assignment
library IEEE;
use IEEE.std_logic_1164.all;

entity VCC is
Port (P : out STD_LOGIC);
end VCC;

architecture Behavioural of VCC is

begin

P <= '1';

end Behavioural;
