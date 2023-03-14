-- Final Year Project
-- By David Clarke
-- Created 1_2_2001
library IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
USE IEEE.STD_LOGIC_ARITH.ALL;

Entity Adders_six_bits_x16 is
Port (A15, A14, A13, A12, A11, A10, A9, A8, A7, A6, A5, A4, A3, A2, A1, A0,
      B15, B14, B13, B12, B11, B10, B9, B8, B7, B6, B5, B4, B3, B2, B1, B0 : IN UNSIGNED (7 downto 0);
      OUTPUT15, OUTPUT14, OUTPUT13, OUTPUT12, OUTPUT11, OUTPUT10, OUTPUT9, OUTPUT8,
      OUTPUT7, OUTPUT6, OUTPUT5, OUTPUT4, OUTPUT3, OUTPUT2, OUTPUT1, OUTPUT0 : OUT UNSIGNED (5 downto 0));
End Entity Adders_six_bits_x16;

ARCHITECTURE STRUCTURAL OF ADDERS_SIX_BITS_x16 IS

Component ADDERS_SIX_BITS_x16 IS
Port (A1, A0  : IN  UNSIGNED (3 downto 0);
      B1, B0  : IN  UNSIGNED (3 downto 0);
      OUTPUT  : OUT UNSIGNED (5 downto 0));
End Component ADDERS_SIX_BITS_x16;

BEGIN

ADD15 : ADDERS_SIX_BITS_x16 PORT MAP (A1 => A15(7 downto 4), A0 => A15(3 downto 0), B1 => B15(7 downto 4),
                                      B0 => B15(3 downto 0), OUTPUT => OUTPUT15);
                                      
ADD14 : ADDERS_SIX_BITS_x16 PORT MAP (A1 => A14(7 downto 4), A0 => A14(3 downto 0), B1 => B14(7 downto 4),
                                      B0 => B14(3 downto 0), OUTPUT => OUTPUT14);
                                     
ADD13 : ADDERS_SIX_BITS_x16 PORT MAP (A1 => A13(7 downto 4), A0 => A13(3 downto 0), B1 => B13(7 downto 4),
                                      B0 => B13(3 downto 0), OUTPUT => OUTPUT13);
                                      
ADD12 : ADDERS_SIX_BITS_x16 PORT MAP (A1 => A12(7 downto 4), A0 => A12(3 downto 0), B1 => B12(7 downto 4),
                                      B0 => B12(3 downto 0), OUTPUT => OUTPUT12);
                                      
ADD11 : ADDERS_SIX_BITS_x16 PORT MAP (A1 => A11(7 downto 4), A0 => A11(3 downto 0), B1 => B11(7 downto 4),
                                      B0 => B11(3 downto 0), OUTPUT => OUTPUT11);
                                      
ADD10 : ADDERS_SIX_BITS_x16 PORT MAP (A1 => A10(7 downto 4), A0 => A10(3 downto 0), B1 => B10(7 downto 4),
                                      B0 => B10(3 downto 0), OUTPUT => OUTPUT10);
                                      
ADD9 : ADDERS_SIX_BITS_x16 PORT MAP  (A1 => A9(7 downto 4), A0 => A9(3 downto 0), B1 => B9(7 downto 4),
                                      B0 => B9(3 downto 0), OUTPUT => OUTPUT9);
                                      
ADD8 : ADDERS_SIX_BITS_x16 PORT MAP  (A1 => A8(7 downto 4), A0 => A8(3 downto 0), B1 => B8(7 downto 4),
                                      B0 => B8(3 downto 0), OUTPUT => OUTPUT8);
                                      
ADD7 : ADDERS_SIX_BITS_x16 PORT MAP  (A1 => A7(7 downto 4), A0 => A7(3 downto 0), B1 => B7(7 downto 4),
                                      B0 => B7(3 downto 0), OUTPUT => OUTPUT7);
                                      
ADD6 : ADDERS_SIX_BITS_x16 PORT MAP  (A1 => A6(7 downto 4), A0 => A6(3 downto 0), B1 => B6(7 downto 4),
                                      B0 => B6(3 downto 0), OUTPUT => OUTPUT6);
                                     
ADD5 : ADDERS_SIX_BITS_x16 PORT MAP  (A1 => A5(7 downto 4), A0 => A5(3 downto 0), B1 => B5(7 downto 4),
                                      B0 => B5(3 downto 0), OUTPUT => OUTPUT5);
                                      
ADD4 : ADDERS_SIX_BITS_x16 PORT MAP  (A1 => A4(7 downto 4), A0 => A4(3 downto 0), B1 => B4(7 downto 4),
                                      B0 => B4(3 downto 0), OUTPUT => OUTPUT4);
                                      
ADD3 : ADDERS_SIX_BITS_x16 PORT MAP  (A1 => A3(7 downto 4), A0 => A3(3 downto 0), B1 => B3(7 downto 4),
                                      B0 => B3(3 downto 0), OUTPUT => OUTPUT3);
                                      
ADD2 : ADDERS_SIX_BITS_x16 PORT MAP  (A1 => A2(7 downto 4), A0 => A2(3 downto 0), B1 => B2(7 downto 4),
                                      B0 => B2(3 downto 0), OUTPUT => OUTPUT2);
                                      
ADD1 : ADDERS_SIX_BITS_x16 PORT MAP  (A1 => A1(7 downto 4), A0 => A1(3 downto 0), B1 => B1(7 downto 4),
                                      B0 => B1(3 downto 0), OUTPUT => OUTPUT1);
                                      
ADD0 : ADDERS_SIX_BITS_x16 PORT MAP  (A1 => A0(7 downto 4), A0 => A0(3 downto 0), B1 => B0(7 downto 4),
                                      B0 => B0(3 downto 0), OUTPUT => OUTPUT0);
                                      
END ARCHITECTURE STRUCTURAL;
                                      
                                      
                                       
