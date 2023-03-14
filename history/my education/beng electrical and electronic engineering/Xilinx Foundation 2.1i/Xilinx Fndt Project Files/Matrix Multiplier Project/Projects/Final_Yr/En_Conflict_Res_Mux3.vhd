-- Created by David Clarke
-- Final Year Project
-- Exploiting Parallelism in FPGA design
-- Date : 4_12_2000
Library IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
--
ENTITY En_Conflict_Res_Mux3 IS
PORT (IN2, IN1, IN0 : IN STD_LOGIC; OUT1 : OUT STD_LOGIC);
END ENTITY En_Conflict_Res_Mux3;
--
ARCHITECTURE Behavioural OF En_Conflict_Res_Mux3 IS
BEGIN
    Process (IN2, IN1, IN0)
    Begin
        IF    IN2 = '1' THEN
        OUT1 <= '1';
        ELSIF IN1 = '1' THEN
        OUT1 <= '1';
        ELSIF IN0 = '1' THEN
        OUT1 <= '1';
        END IF;
    END Process;
END ARCHITECTURE Behavioural;

