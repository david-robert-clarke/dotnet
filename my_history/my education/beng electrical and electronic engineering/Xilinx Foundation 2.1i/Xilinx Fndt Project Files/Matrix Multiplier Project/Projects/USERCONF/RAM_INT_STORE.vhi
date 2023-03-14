library IEEE;
Use IEEE.STD_LOGIC_1164.ALL;

ENTITY RAM_INT_STORAGE IS
PORT (ADDRESS : IN STD_LOGIC_VECTOR(3 downto 0); DATA_IN: IN std_logic_vector(7 DOWNTO 0);
      WRITE_EN: IN std_logic; DATA_OUT: OUT std_logic_vector(7 DOWNTO 0));
END ENTITY RAM_INT_STORAGE;

ARCHITECTURE Structural OF RAM_INT_STORAGE IS
------------------------------------------------------
-- LogiBLOX RAM Module "RAM_INT_STORE"
-- Created by LogiBLOX version C.16
--    on Thu Jan 25 21:16:16 2001
-- Attributes 
--    MODTYPE = RAM
--    BUS_WIDTH = 8
--    DEPTH = 16
--    STYLE = MAX_SPEED
--    USE_RPM = FALSE
------------------------------------------------------
----------------------------------------------------
-- Component Declaration 
----------------------------------------------------
component RAM_INT_STORE
  PORT(
    A: IN std_logic_vector(3 DOWNTO 0);
    DI: IN std_logic_vector(7 DOWNTO 0);
    WR_EN: IN std_logic;
    DO: OUT std_logic_vector(7 DOWNTO 0));
end component;

BEGIN

----------------------------------------------------
-- Component Instantiation 
----------------------------------------------------
Dave : RAM_INT_STORE port map (A => , DI => , WR_EN => ,DO => );

END ARCHITECTURE Structural;





















