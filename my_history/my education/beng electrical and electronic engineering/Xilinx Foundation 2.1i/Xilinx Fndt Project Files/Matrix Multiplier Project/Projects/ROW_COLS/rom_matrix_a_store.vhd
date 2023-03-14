-- Behavioural ROM
-- Final Year Project
-- By David Clarke
-- Created on 30_1_2001

library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_arith.all;
USE WORK.MATRIX_PACKAGE.ALL;
--
entity ROM_Matrix_A_Store is
     port (ADDR3, ADDR2, ADDR1, ADDR0: in INTEGER range 3 downto 0;
           ROW_DATA3, ROW_DATA2, ROW_DATA1, ROW_DATA0: out U_BYTE);
end ROM_Matrix_A_Store;

architecture Behavioural of ROM_Matrix_A_Store is
    subtype ROM_BITS is U_BYTE;
    type ROM_TABLE is array (3 downto 0) of ROM_BITS;
    constant ROM3: ROM_TABLE := ROM_TABLE'(ROM_BITS'("10111001"),
                                           ROM_BITS'("11011001"),
                                           ROM_BITS'("10101001"),
                                           ROM_BITS'("10011101"));
    
    constant ROM2: ROM_TABLE := ROM_TABLE'(ROM_BITS'("10111001"),
                                           ROM_BITS'("11011001"),
                                           ROM_BITS'("10101001"),
                                           ROM_BITS'("10011101"));
                                           
    constant ROM1: ROM_TABLE := ROM_TABLE'(ROM_BITS'("10111001"),
                                           ROM_BITS'("11011001"),
                                           ROM_BITS'("10101001"),
                                           ROM_BITS'("10011101"));
                                           
    constant ROM0: ROM_TABLE := ROM_TABLE'(ROM_BITS'("10111001"),
                                           ROM_BITS'("11011001"),
                                           ROM_BITS'("10101001"),
                                           ROM_BITS'("10011101"));
 
    -- The ROM is split up into four identical sub-ROMs which output
    -- data in accordance with four select signals                                            
                         
begin 
        ROW_DATA3 <= ROM3(ADDR3);  -- Read from the sub-ROM3
        ROW_DATA2 <= ROM2(ADDR2);  -- Read from the sub-ROM2
        ROW_DATA1 <= ROM1(ADDR1);  -- Read from the sub-ROM1
        ROW_DATA0 <= ROM0(ADDR0);  -- Read from the sub-ROM0
end Behavioural;

