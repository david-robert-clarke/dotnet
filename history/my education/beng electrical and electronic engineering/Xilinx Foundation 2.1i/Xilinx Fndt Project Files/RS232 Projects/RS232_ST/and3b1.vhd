-- Created by David Clarke for the RS232 assignment
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

Entity AND3B1 IS
Port (a, b, c : IN std_logic; z : OUT std_logic);
End Entity AND3B1;

Architecture Behavioural OF AND3B1 IS
Begin
   z <= a AND b AND (NOT c);
End Architecture Behavioural;
