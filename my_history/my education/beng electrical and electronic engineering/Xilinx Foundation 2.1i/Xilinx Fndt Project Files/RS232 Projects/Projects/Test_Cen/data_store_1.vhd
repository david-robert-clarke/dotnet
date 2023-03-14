--
-- Behavioural 8x2 ROM 
-- Created 11_12_2000      
-- Updated 14_12_2000

library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_arith.all;
USE WORK.MATRIX_PACKAGE.ALL;
--
entity data_store_1 is
     port (ADDR: in INTEGER range 3 downto 0;
           DATA: out U_BYTE);
end data_store_1;

architecture Behavioural of data_store_1 is 
    subtype ROM_BITS is U_BYTE; 
    type ROM_TABLE is array (3 downto 0) of ROM_BITS;   
    constant ROM: ROM_TABLE := ROM_TABLE'(ROM_BITS'("01101101"),
                                          ROM_BITS'("01101111"),
                                          ROM_BITS'("10100101"),
                                          ROM_BITS'("10100111"));

    begin
        DATA <= ROM(ADDR);  -- Read from the ROM
end Behavioural;

