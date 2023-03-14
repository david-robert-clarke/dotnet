--
-- Behavioural 8x2 ROM 
-- Created 11_12_2000      
-- Updated 14_12_2000

library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_arith.all;
USE WORK.MATRIX_PACKAGE.ALL;
--
entity data_store is
     port (DATA: out U_LONG_WORD);
end data_store;

architecture Behavioural of data_store is 
    constant ROM: U_LONG_WORD := "01101101011011111010010110100111";

    begin
        DATA <= ROM;  -- Read from the ROM
end Behavioural;

