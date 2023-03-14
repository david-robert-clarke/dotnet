-- Behavioural ROM
-- Final Year Project
-- By David Clarke
-- Created on 30_1_2001

library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_arith.all;
USE WORK.MATRIX_PACKAGE.ALL;
--
entity DATA_STORAGE_4X4 is
     port (ADDR3; ADDR2; ADDR1; ADDR0: in INTEGER range 3 downto 0;
           ROW_DATA3; ROW_DATA2; ROW_DATA1; ROW_DATA0: out U_BYTE);
end DATA_STORAGE_4X4;

architecture Behavioural of DATA_STORAGE_4X4 is
    subtype ROM_BITS is U_TWO_BITS;
    
    constant A11 : ROM_BITS := "10"; constant A12 : ROM_BITS := "11";  
    constant A13 : ROM_BITS := "10"; constant A14 : ROM_BITS := "01";  
    constant A21 : ROM_BITS := "11"; constant A22 : ROM_BITS := "01";  
    constant A23 : ROM_BITS := "10"; constant A24 : ROM_BITS := "01";  
    constant A31 : ROM_BITS := "10"; constant A32 : ROM_BITS := "10";  
    constant A33 : ROM_BITS := "10"; constant A34 : ROM_BITS := "01";  
    constant A41 : ROM_BITS := "10"; constant A42 : ROM_BITS := "01";  
    constant A43 : ROM_BITS := "11"; constant A44 : ROM_BITS := "01";  
    
    constant B11 : ROM_BITS := "01"; constant B12 : ROM_BITS := "10";  
    constant B13 : ROM_BITS := "01"; constant B14 : ROM_BITS := "10";  
    constant B21 : ROM_BITS := "01"; constant B22 : ROM_BITS := "11";  
    constant B23 : ROM_BITS := "10"; constant B24 : ROM_BITS := "11";  
    constant B31 : ROM_BITS := "01"; constant B32 : ROM_BITS := "10";  
    constant B33 : ROM_BITS := "11"; constant B34 : ROM_BITS := "01";  
    constant B41 : ROM_BITS := "01"; constant B42 : ROM_BITS := "11";  
    constant B43 : ROM_BITS := "00"; constant B44 : ROM_BITS := "10";                                  
                         
begin 

end Behavioural;

