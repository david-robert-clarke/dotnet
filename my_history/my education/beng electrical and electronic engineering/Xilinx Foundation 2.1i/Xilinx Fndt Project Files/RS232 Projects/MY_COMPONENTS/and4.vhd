-- Created by David Clarke for the RS232 assignment
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

Entity AND4 IS
Port (a, b, c, d : IN std_logic; z : OUT std_logic);
End Entity AND4;

Architecture Behavioural OF AND4 IS
Begin
   z <= a AND b AND c AND d;
End Architecture Behavioural;
