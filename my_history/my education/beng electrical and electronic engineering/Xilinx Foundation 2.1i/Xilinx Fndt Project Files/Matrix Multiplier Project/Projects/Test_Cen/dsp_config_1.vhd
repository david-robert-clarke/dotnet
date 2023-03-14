-- Final Year Project
-- By David Clarke
-- Created on 14_12_2000
LIBRARY IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
USE WORK.MATRIX_PACKAGE.ALL;
--
Entity DSP_CONFIG_1 IS
Port (CLK, RESET : IN ONE_BIT;
      MAT_A_D_IN_1, MAT_A_D_IN_0, MAT_B_D_IN_1, MAT_B_D_IN_0 : IN U_TWO_BITS;
      MEM_SEL_IN : IN TWO_BITS; 
      A0B0_A1B2, A0B1_A1B3, A2B0_A3B2, A2B1_A3B3 : OUT FIVE_BITS);
End Entity DSP_CONFIG_1;
--
Architecture Structural of DSP_CONFIG_1 IS

COMPONENT MUL2 IS
PORT (A, B : IN U_TWO_BITS; 
         Z : OUT NIBBLE);
END COMPONENT MUL2;

COMPONENT ADD4 IS
PORT (A, B : IN NIBBLE;
      S    : OUT NIBBLE; 
      C3   : OUT ONE_BIT);
END COMPONENT ADD4;

COMPONENT Answer_Store_1 IS
PORT (CLK, RESET  : IN  ONE_BIT;	               
      D           : IN  FIVE_BITS;  
      SEL         : IN  TWO_BITS;  	
      Q           : OUT TWENTY_BITS);
END COMPONENT Answer_Store_1;

SIGNAL P1_BUS, P2_BUS : NIBBLE;
SIGNAL SOP_BUS        : FIVE_BITS;

Begin

M_1     : MUL2           PORT MAP (A => MAT_A_D_IN_1, B => MAT_B_D_IN_1, Z => P1_BUS);
M_2     : MUL2           PORT MAP (A => MAT_A_D_IN_0, B => MAT_B_D_IN_0, Z => P2_BUS);
ADDER_1 : ADD4           PORT MAP (A => P1_BUS, B => P2_BUS, S => SOP_BUS(3 downto 0), C3 => SOP_BUS(4));
MEMORY  : Answer_Store_1 PORT MAP (CLK => CLK, RESET => RESET, D => SOP_BUS, SEL => MEM_SEL_IN, Q(19 DOWNTO 15) => A0B0_A1B2,
                                  Q(14 DOWNTO 10) => A0B1_A1B3, Q(9 DOWNTO 5) => A2B0_A3B2, Q(4 DOWNTO 0) => A2B1_A3B3); 

End Architecture Structural;
