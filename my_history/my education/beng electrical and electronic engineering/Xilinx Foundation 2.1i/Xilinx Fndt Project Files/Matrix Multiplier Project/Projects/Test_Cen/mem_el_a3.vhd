-- Final Year Project
-- By David Clarke
-- Created: 16_12_2000
-- Updated: 17_12_2000
library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_arith.all;
USE WORK.MATRIX_PACKAGE.ALL;
--
entity MEM_EL_A3 is
     port (ADDR: in ONE_BIT;
           DATA: out U_TWO_BITS);
end MEM_EL_A3;

architecture Behavioural of MEM_EL_A3 is
  begin
       Process(ADDR)
       Begin 
            IF ADDR = '1' THEN
                 DATA <= "01";
            ELSE 
                 DATA <= "00";
            END IF;
       End Process;
end Behavioural;

