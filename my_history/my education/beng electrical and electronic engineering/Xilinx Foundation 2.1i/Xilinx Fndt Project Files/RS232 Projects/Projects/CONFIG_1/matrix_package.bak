-- Final Year Project
-- By David Clarke
-- Created on 13_12_2000
-- Updated on 14_12_2000
library IEEE;
USE IEEE.std_logic_1164.ALL;
USE IEEE.std_logic_arith.ALL;

package MATRIX_PACKAGE IS
 subtype One_Bit           is STD_LOGIC;
 subtype Two_Bits          is STD_LOGIC_VECTOR (1 downto 0);
 subtype Three_Bits        is STD_LOGIC_VECTOR (2 downto 0);
 subtype Four_Bits         is STD_LOGIC_VECTOR (3 downto 0);
 subtype Five_Bits         is STD_LOGIC_VECTOR (4 downto 0);
 subtype Six_Bits          is STD_LOGIC_VECTOR (5 downto 0);
 subtype Seven_Bits        is STD_LOGIC_VECTOR (6 downto 0);
 subtype Byte              is STD_LOGIC_VECTOR (7 downto 0);
 subtype Word              is STD_LOGIC_VECTOR (15 downto 0);
 subtype Twenty_Bits       is STD_LOGIC_VECTOR (19 downto 0);
 subtype Long_Word         is STD_LOGIC_VECTOR (31 downto 0);
-- 
 subtype U_Two_Bits        is UNSIGNED (1 downto 0);
 subtype U_Three_Bits      is UNSIGNED (2 downto 0);
 subtype U_Four_Bits       is UNSIGNED (3 downto 0);
 subtype U_Five_Bits       is UNSIGNED (4 downto 0);
 subtype U_Six_Bits        is UNSIGNED (5 downto 0);
 subtype U_Seven_Bits      is UNSIGNED (6 downto 0);
 subtype U_Byte            is UNSIGNED (7 downto 0);
 subtype U_Word            is UNSIGNED (15 downto 0);
 subtype U_Long_Word       is UNSIGNED (31 downto 0);
--
 subtype S_Two_Bits        is SIGNED (1 downto 0);
 subtype S_Three_Bits      is SIGNED (2 downto 0);
 subtype S_Four_Bits       is SIGNED (3 downto 0);
 subtype S_Five_Bits       is SIGNED (4 downto 0);
 subtype S_Six_Bits        is SIGNED (5 downto 0);
 subtype S_Seven_Bits      is SIGNED (6 downto 0);
 subtype S_Byte            is SIGNED (7 downto 0);
 subtype S_Word            is SIGNED (15 downto 0);
 subtype S_Long_Word       is SIGNED (31 downto 0);
--
 type STATE_TYPE is (S0, S1, S2, S3);  
--
 subtype ROM_BITS is U_BYTE; 
 type ROM_TABLE is array (3 downto 0) of ROM_BITS;   
 
end package MATRIX_PACKAGE;
