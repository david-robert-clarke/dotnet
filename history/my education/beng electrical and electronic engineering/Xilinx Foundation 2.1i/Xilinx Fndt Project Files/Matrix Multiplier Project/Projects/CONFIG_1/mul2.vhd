-- FINAL YEAR PROJECT MARK III
-- BY DAVID.R.CLARKE
-- DATE 8_12_2000
-- Updated 14_12_2000
LIBRARY IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
USE IEEE.STD_LOGIC_ARITH.ALL;
USE WORK.MATRIX_PACKAGE.ALL;
--
ENTITY MUL2 IS
PORT (A, B : U_TWO_BITS; Z : OUT FOUR_BITS);
END ENTITY MUL2;
-- 
ARCHITECTURE BEHAVIOURAL OF MUL2 IS
SIGNAL A0, B0 : STD_LOGIC;
BEGIN
	Z  <= CONV_STD_LOGIC_VECTOR((A*B), 4);
	 
END ARCHITECTURE BEHAVIOURAL;