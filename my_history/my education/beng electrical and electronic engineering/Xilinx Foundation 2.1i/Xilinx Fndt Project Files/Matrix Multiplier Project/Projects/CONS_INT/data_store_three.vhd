-- Behavioural 32x7 ROM 
-- Final Year Project
-- By David Clarke
-- Created on 22_1_2001

library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_arith.all;
USE WORK.MATRIX_PACKAGE.ALL;
--
entity data_store is
     port (ADDR: in INTEGER range 6 downto 0;
           DATA: out U_LONG_WORD);
end data_store;

architecture Behavioural of data_store is
    subtype ROM_BITS is U_LONG_WORD;
    type ROM_TABLE is array (6 downto 0) of ROM_BITS;
    constant ROM: ROM_TABLE := ROM_TABLE'(
                                          ROM_BITS' ("10010101101001000001010100100100"),
                                          -- config_3's data
                                          ROM_BITS'("10010101101001000000000000000000"),
                                          ROM_BITS'("00000000000000000001010100100100"),
                                          -- config_2's data
                                          ROM_BITS'("10010101000000000000000000000000"),
                                          ROM_BITS'("00000000101001000000000000000000"),
                                          ROM_BITS'("00000000000000000001010100000000"),
                                          ROM_BITS'("00000000000000000000000000100100")
                                          );
                                          -- config_1's data
                                          

begin 
        DATA <= ROM(ADDR);  -- Read from the ROM
end Behavioural;

