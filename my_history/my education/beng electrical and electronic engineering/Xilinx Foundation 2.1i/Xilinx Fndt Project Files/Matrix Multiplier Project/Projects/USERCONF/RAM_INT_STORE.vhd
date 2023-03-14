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
-- This is a behaviorial model only and cannot be synthesized.
------------------------------------------------------
LIBRARY IEEE;
USE IEEE.std_logic_1164.ALL;
LIBRARY logiblox;
USE logiblox.mvlutil.ALL;
USE logiblox.mvlarith.ALL;
USE logiblox.logiblox.ALL;

ENTITY RAM_INT_STORE IS
  PORT(
    A: IN std_logic_vector(3 DOWNTO 0);
    DO: OUT std_logic_vector(7 DOWNTO 0);
    DI: IN std_logic_vector(7 DOWNTO 0);
    WR_EN: IN std_logic);
END RAM_INT_STORE;

ARCHITECTURE sim OF RAM_INT_STORE IS
  SIGNAL START_PULSE: std_logic := '1';
  TYPE mem_data IS ARRAY (15 DOWNTO 0) OF std_logic_vector(7 DOWNTO 0);
BEGIN
  PROCESS
  VARIABLE VD: mem_data;
  VARIABLE first_time: BOOLEAN := TRUE;
  BEGIN
    IF (first_time) THEN
      VD(0) := ('0','0','0','0','0','0','0','0');
      VD(1) := ('0','0','0','0','0','0','0','0');
      VD(2) := ('0','0','0','0','0','0','0','0');
      VD(3) := ('0','0','0','0','0','0','0','0');
      VD(4) := ('0','0','0','0','0','0','0','0');
      VD(5) := ('0','0','0','0','0','0','0','0');
      VD(6) := ('0','0','0','0','0','0','0','0');
      VD(7) := ('0','0','0','0','0','0','0','0');
      VD(8) := ('0','0','0','0','0','0','0','0');
      VD(9) := ('0','0','0','0','0','0','0','0');
      VD(10) := ('0','0','0','0','0','0','0','0');
      VD(11) := ('0','0','0','0','0','0','0','0');
      VD(12) := ('0','0','0','0','0','0','0','0');
      VD(13) := ('0','0','0','0','0','0','0','0');
      VD(14) := ('0','0','0','0','0','0','0','0');
      VD(15) := ('0','0','0','0','0','0','0','0');
      first_time := FALSE;
    END IF;
    IF (WR_EN='1') AND (A'EVENT) THEN 
         ASSERT (FALSE)
         REPORT "Value on address line should not change when write enable is high"
         SEVERITY WARNING;
         DO <= ('X','X','X','X','X','X','X','X');
    ELSE
      IF (mvlvec_not01(A) OR mvlbit_not01(WR_EN)) THEN
        DO <= ('X','X','X','X','X','X','X','X');
      ELSE
        IF (WR_EN='1') THEN
          VD(mvlvec2int(A)) := stdvec2mvl(DI);
        END IF;
        DO <= VD(mvlvec2int(A));
      END IF;
    END IF;
      WAIT ON A, DI, WR_EN, START_PULSE;
  END PROCESS;
END sim;
