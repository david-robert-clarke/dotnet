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
     port (ADDR: in INTEGER range 1 downto 0;
           DATA: out U_WORD);
end data_store;

architecture Behavioural of data_store is
    subtype ROM_BITS is U_WORD; 
    type ROM_TABLE is array (1 downto 0) of ROM_BITS;   
    constant ROM: ROM_TABLE := ROM_TABLE'(ROM_BITS'("0110110101101111"),
                                          ROM_BITS'("1010010110100111"));
                                          

    begin
        DATA <= ROM(ADDR);  -- Read from the ROM
end Behavioural;

