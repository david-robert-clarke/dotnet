-- Behavioural 2x8 ROM 
-- Final Year Project
-- By David Clarke
-- Created on 25_1_2001

library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_arith.all;
USE WORK.MATRIX_PACKAGE.ALL;
--
entity ROM_MATRIX_STORE is
     port (ADDR3, ADDR2, ADDR1, ADDR0: in INTEGER range 7 downto 0;
           DATA3, DATA2, DATA1, DATA0: out INTEGER range 3 downto 0);
end ROM_MATRIX_STORE;

architecture Behavioural of ROM_MATRIX_STORE is
    subtype ROM_DATA is INTEGER range 3 downto 0;
    type ROM_TABLE is array (7 downto 0) of ROM_DATA;
    constant ROM: ROM_TABLE := ROM_TABLE'(
                                          ROM_DATA'(2), -- a11
                                          ROM_DATA'(1), -- a12
                                          ROM_DATA'(0), -- a21 
                                          ROM_DATA'(1), -- a22
                                          -- MATRIX_A DATA
                                          ROM_DATA'(1), -- b11
                                          ROM_DATA'(2), -- b12
                                          ROM_DATA'(1), -- b21
                                          ROM_DATA'(0)  -- b22
                                          -- MATRIX_B DATA
                                          );
                      
begin 
        DATA3 <= ROM(ADDR3);  -- Read from the ROM output data on data line 3
        DATA2 <= ROM(ADDR2);  -- Read from the ROM output data on data line 2
        DATA1 <= ROM(ADDR1);  -- Read from the ROM output data on data line 1
        DATA0 <= ROM(ADDR0);  -- Read from the ROM output data on data line 0
end Behavioural;

