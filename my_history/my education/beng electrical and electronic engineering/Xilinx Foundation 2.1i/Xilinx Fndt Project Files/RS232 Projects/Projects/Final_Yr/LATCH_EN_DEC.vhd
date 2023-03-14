-- Created by David Clarke
-- Final Year Project
-- Exploiting Parallelism in FPGA design
-- Date : 4_12_2000
Library IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
--
ENTITY Latch_En_Dec IS
Port (INPUT : IN STD_LOGIC_VECTOR (1 downto 0) ; LATCH_EN_1, LATCH_EN_2, 
      LATCH_EN_3 : OUT STD_LOGIC);
END ENTITY Latch_En_Dec;
--
ARCHITECTURE Behavioural OF Latch_En_Dec IS
BEGIN
    Process (INPUT) IS
    Begin
        IF    INPUT = "01" THEN
           LATCH_EN_1 <= '1';
        ELSIF INPUT = "10" THEN
           LATCH_EN_2 <= '1';
        ELSIF INPUT = "11" THEN
           LATCH_EN_3 <= '1';
        END IF;
    END Process;
END ARCHITECTURE Behavioural;


