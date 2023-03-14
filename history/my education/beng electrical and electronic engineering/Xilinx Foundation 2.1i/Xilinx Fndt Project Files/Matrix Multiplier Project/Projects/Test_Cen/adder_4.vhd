-- Final Year Project
-- By David Clarke
-- Created: 18_12_2000
LIBRARY IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
USE IEEE.STD_LOGIC_ARITH.ALL;
USE WORK.MATRIX_PACKAGE.ALL;
--
ENTITY ADDER_4 IS
PORT (A, B  : IN U_FOUR_BITS;  S : OUT U_FOUR_BITS; C3 : OUT STD_LOGIC);
END ENTITY ADDER_4;
--
ARCHITECTURE BEHAVIOURAL OF ADDER_4 IS

SIGNAL C2 : std_logic;
SIGNAL C1 : std_logic;
SIGNAL C0 : std_logic;

BEGIN

       S(0) <= A(0) XOR B(0);
       C0   <= A(0) AND B(0);
       
       S(1) <= A(1)  XOR B(1) XOR C0;
       C1   <= (A(1) AND B(1)) OR (A(1) AND C0) OR (B(1) AND C0); 
       
       S(2) <= A(2)  XOR B(2) XOR C1;
       C2   <= (A(2) AND B(2)) OR (A(2) AND C1) OR (B(2) AND C1); 
       
       S(3) <= A(3)  XOR B(3) XOR C2;
       C3   <= (A(3) AND B(3)) OR (A(3) AND C2) OR (B(3) AND C2); 

END ARCHITECTURE BEHAVIOURAL;
  
