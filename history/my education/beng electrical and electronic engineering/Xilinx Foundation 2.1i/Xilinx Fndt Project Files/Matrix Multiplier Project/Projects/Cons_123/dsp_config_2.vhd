-- Final Year Project
-- By David Clarke
-- Created on 13_12_2000
library IEEE;
USE IEEE.std_logic_1164.ALL;
USE IEEE.std_logic_arith.ALL;
USE WORK.MATRIX_PACKAGE.ALL;

ENTITY DSP_CONFIG_2 IS
PORT (C, R : IN ONE_BIT;
      MAT_A_D_IN_3, MAT_A_D_IN_2, MAT_A_D_IN_1, MAT_A_D_IN_0,  
      MAT_B_D_IN_3, MAT_B_D_IN_2, MAT_B_D_IN_1, MAT_B_D_IN_0 : IN U_TWO_BITS;
      SEL : IN ONE_BIT;
      A0B0_A1B2, A0B1_A1B3, A2B0_A3B2, A2B1_A3B3 : OUT FIVE_BITS);
END ENTITY DSP_CONFIG_2;    

ARCHITECTURE STRUCTURAL OF DSP_CONFIG_2 IS

COMPONENT MUL2 IS
PORT (A, B : U_TWO_BITS; Z : OUT NIBBLE);
END COMPONENT MUL2;

COMPONENT ADD4 IS
PORT (A, B  : IN NIBBLE;  S : OUT NIBBLE; C3 : OUT ONE_BIT);
END COMPONENT ADD4;

COMPONENT Answer_Store_2 IS
PORT (CLK, RESET  : IN  ONE_BIT;
      D           : IN  TEN_BITS;  
      SEL         : IN  ONE_BIT;  -- The SEL input selects the correct set of outputs	
      Q           : OUT TWENTY_BITS);
END COMPONENT Answer_Store_2;

SIGNAL P4_BUS, P3_BUS, P2_BUS, P1_BUS : NIBBLE;
SIGNAL SOP_BUS_2, SOP_BUS_1 : FIVE_BITS;

BEGIN

M_1      : MUL2 PORT MAP (A => MAT_A_D_IN_3, B => MAT_B_D_IN_3, Z => P4_BUS);
M_2      : MUL2 PORT MAP (A => MAT_A_D_IN_2, B => MAT_B_D_IN_2, Z => P3_BUS);
M_3      : MUL2 PORT MAP (A => MAT_A_D_IN_1, B => MAT_B_D_IN_1, Z => P2_BUS);
M_4      : MUL2 PORT MAP (A => MAT_A_D_IN_0, B => MAT_B_D_IN_0, Z => P1_BUS);
ADD4_1   : ADD4 PORT MAP (A => P4_BUS, B => P3_BUS, S => SOP_BUS_2(3 DOWNTO 0), C3 => SOP_BUS_2(4));
ADD4_2   : ADD4 PORT MAP (A => P2_BUS, B => P1_BUS, S => SOP_BUS_1(3 DOWNTO 0), C3 => SOP_BUS_1(4));
MEM      : ANSWER_STORE_2 PORT MAP (CLK => C, RESET => R, D(9 DOWNTO 5) => SOP_BUS_2, D(4 DOWNTO 0) => SOP_BUS_1, SEL => SEL,
                                  Q(19 DOWNTO 15) => A0B0_A1B2, Q(14 DOWNTO 10) => A0B1_A1B3, Q(9 DOWNTO 5) => A2B0_A3B2, 
                                  Q(4 DOWNTO 0) => A2B1_A3B3); 

END ARCHITECTURE STRUCTURAL;  