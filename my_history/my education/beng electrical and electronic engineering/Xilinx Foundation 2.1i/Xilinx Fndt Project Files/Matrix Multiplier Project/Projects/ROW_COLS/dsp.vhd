-- Final Year Project
-- By David Clarke
-- Created 1_2_2001
Library IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
USE IEEE.STD_LOGIC_ARITH.ALL;
USE WORK.MATRIX_PACKAGE.ALL;
--
ENTITY DSP IS
PORT (CLK, RESET, ENABLE : IN STD_LOGIC;
      INPUT_A11, INPUT_A12, INPUT_A13, INPUT_A14, INPUT_B11, INPUT_B12, INPUT_B13, INPUT_B14, 
      INPUT_A21, INPUT_A22, INPUT_A23, INPUT_A24,  INPUT_B21, INPUT_B22, INPUT_B23, INPUT_B24,
      INPUT_A31, INPUT_A32, INPUT_A33, INPUT_A34, INPUT_B31, INPUT_B32, INPUT_B33, INPUT_B34,
      INPUT_A41, INPUT_A42, INPUT_A43, INPUT_A44, INPUT_B41, INPUT_B42, INPUT_B43, INPUT_B44 : IN UNSIGNED (1 downto 0);
      FOURxFOUR: OUT UNSIGNED (95 downto 0));
END ENTITY DSP;
--
ARCHITECTURE STRUCTURAL OF DSP IS
-- COMPONENT DECLARATIONS
Component Multipliers_two_bits_x64 IS
PORT (A11, A12, A13, A14, B11, B12, B13, B14, 
      A21, A22, A23, A24, B21, B22, B23, B24,
      A31, A32, A33, A34, B31, B32, B33, B34,
      A41, A42, A43, A44, B41, B42, B43, B44 : IN UNSIGNED (1 downto 0);

      MUL63, MUL62,  MUL61, MUL60, MUL59, MUL58, MUL57, MUL56,
      MUL55, MUL54, MUL53, MUL52, MUL51, MUL50, MUL49, MUL48,
      MUL47, MUL46, MUL45, MUL44, MUL43, MUL42, MUL41, MUL40,
      MUL39, MUL38, MUL37, MUL36, MUL35, MUL34, MUL33, MUL32,
      MUL31, MUL30, MUL29, MUL28, MUL27, MUL26, MUL25, MUL24,
      MUL23, MUL22, MUL21, MUL20, MUL19, MUL18, MUL17, MUL16,
      MUL15, MUL14, MUL13, MUL12, MUL11, MUL10, MUL9, MUL8,
      MUL7, MUL6, MUL5, MUL4, MUL3, MUL2, MUL1, MUL0 : OUT UNSIGNED (3 downto 0));
END Component Multipliers_two_bits_x64;

Component Adders_six_bits_x16 is
Port (A1, A0, B1, B0, C1, C0, D1, D0, E1, E0, F1, F0, G1, G0, H1, H0, I1, I0, 
      J1, J0, K1, K0, L1, L0, M1, M0, N1, N0, O1, O0, P1, P0, Q1, Q0, R1, R0,
      S1, S0, T1, T0, U1, U0, V1, V0, W1, W0, X1, X0, Y1, Y0, Z1, Z0,
      AA1, AA0, BB1, BB0, CC1, CC0, DD1, DD0, EE1, EE0, FF1, FF0: IN UNSIGNED (3 downto 0);
      OUTPUT15, OUTPUT14, OUTPUT13, OUTPUT12, OUTPUT11, OUTPUT10, OUTPUT9, OUTPUT8,
      OUTPUT7, OUTPUT6, OUTPUT5, OUTPUT4, OUTPUT3, OUTPUT2, OUTPUT1, OUTPUT0 : OUT UNSIGNED (5 downto 0));
End Component Adders_six_bits_x16;

Component Answer_Store IS
PORT (EN, CLK, RESET : IN ONE_BIT; INPUT : IN  UNSIGNED (95 downto 0); ANSWER: OUT UNSIGNED (95 downto 0));
END Component Answer_Store;

-- SIGNAL DECLARATIONS
Signal PROD      : UNSIGNED (255 downto 0);  
Signal SUMOFPROD : UNSIGNED (95 downto 0);

BEGIN

-- COMPONENT INSTANTIATIONS
MUL2x64	: Multipliers_two_bits_x64 PORT MAP (A11 => INPUT_A11, A12 => INPUT_A12, A13 => INPUT_A13, A14 => INPUT_A14, 
	                                     B11 => INPUT_B11, B12 => INPUT_B12, B13 => INPUT_B13, B14 => INPUT_B14, 
      					     A21 => INPUT_A21, A22 => INPUT_A22, A23 => INPUT_A23, A24 => INPUT_A24, 
      					     B21 => INPUT_B21, B22 => INPUT_B22, B23 => INPUT_B23, B24 => INPUT_B24,
      					     A31 => INPUT_A31, A32 => INPUT_A32, A33 => INPUT_A33, A34 => INPUT_A34, 
      					     B31 => INPUT_B31, B32 => INPUT_B32, B33 => INPUT_B33, B34 => INPUT_B34,
      					     A41 => INPUT_A41, A42 => INPUT_A42, A43 => INPUT_A43, A44 => INPUT_A44, 
      					     B41 => INPUT_B41, B42 => INPUT_B42, B43 => INPUT_B43, B44 => INPUT_B44, 
					     -----------------------------------------------------------------------
MUL63  => PROD(255 downto 252), MUL62 =>  PROD(251 downto 248), MUL61 => PROD(247 downto 244), MUL60 => PROD(243 downto 240), 
MUL59  => PROD(239 downto 236), MUL58 =>  PROD(235 downto 232), MUL57 => PROD(231 downto 228), MUL56 => PROD(227 downto 224),
MUL55  => PROD(223 downto 220), MUL54 =>  PROD(219 downto 216), MUL53 => PROD(215 downto 212), MUL52 => PROD(211 downto 208), 
MUL51  => PROD(207 downto 204), MUL50 =>  PROD(203 downto 200), MUL49 => PROD(199 downto 196), MUL48 => PROD(195 downto 192), 
MUL47  => PROD(191 downto 188), MUL46 =>  PROD(187 downto 184), MUL45 => PROD(183 downto 180), MUL44 => PROD(179 downto 176),
MUL43  => PROD(175 downto 172), MUL42 =>  PROD(171 downto 168), MUL41 => PROD(167 downto 164), MUL40 => PROD(163 downto 160),
MUL39  => PROD(159 downto 156), MUL38 =>  PROD(155 downto 152), MUL37 => PROD(151 downto 148), MUL36 => PROD(147 downto 144), 
MUL35  => PROD(143 downto 140), MUL34 =>  PROD(139 downto 136), MUL33 => PROD(135 downto 132), MUL32 => PROD(131 downto 128),
MUL31  => PROD(127 downto 124), MUL30 =>  PROD(123 downto 120), MUL29 => PROD(119 downto 116), MUL28 => PROD(115 downto 112),
MUL27  => PROD(111 downto 108), MUL26 =>  PROD(107 downto 104), MUL25 => PROD(103 downto 100), MUL24 => PROD(99  downto 96), 
MUL23  => PROD(95 downto 92),   MUL22 =>  PROD(91  downto 88),  MUL21 => PROD(87  downto 84),  MUL20 => PROD(83  downto 80),
MUL19  => PROD(79 downto 76),   MUL18 =>  PROD(75  downto 72),  MUL17 => PROD(71  downto 68),  MUL16 => PROD(67  downto 64),
MUL15  => PROD(63 downto 60),   MUL14 =>  PROD(59  downto 56),  MUL13 => PROD(55  downto 52),  MUL12 => PROD(51  downto 48), 
MUL11  => PROD(47 downto 44),   MUL10 =>  PROD(43  downto 40),  MUL9  => PROD(39  downto 36),  MUL8  => PROD(35  downto 32),
MUL7   => PROD(31 downto 28),   MUL6  =>  PROD(27  downto 24),  MUL5  => PROD(23  downto 20),  MUL4  => PROD(19  downto 16),
MUL3   => PROD(15 downto 12),   MUL2  =>  PROD(11  downto 8),   MUL1  => PROD(7   downto 4),   MUL0  => PROD(3   downto 0));

ADD6x16 : Adders_six_bits_x16 PORT MAP      

(A1 => PROD(255 downto 252), A0 =>  PROD(251 downto 248),
 B1 => PROD(247 downto 244), B0 =>  PROD(243 downto 240), 
 C1 => PROD(239 downto 236), C0 =>  PROD(235 downto 232),
 D1 => PROD(231 downto 228), D0 =>  PROD(227 downto 224),
 E1 => PROD(223 downto 220), E0 =>  PROD(219 downto 216),
 F1 => PROD(215 downto 212), F0 =>  PROD(211 downto 208), 
 G1 => PROD(207 downto 204), G0 =>  PROD(203 downto 200),
 H1 => PROD(199 downto 196), H0 =>  PROD(195 downto 192), 
 I1 => PROD(191 downto 188), I0 =>  PROD(187 downto 184),
 J1 => PROD(183 downto 180), J0 =>  PROD(179 downto 176),
 K1 => PROD(175 downto 172), K0 =>  PROD(171 downto 168),
 L1 => PROD(167 downto 164), L0 =>  PROD(163 downto 160),
 M1 => PROD(159 downto 156), M0 =>  PROD(155 downto 152),
 N1 => PROD(151 downto 148), N0 =>  PROD(147 downto 144), 
 O1 => PROD(143 downto 140), O0 =>  PROD(139 downto 136),
 P1 => PROD(135 downto 132), P0 =>  PROD(131 downto 128),
 Q1 => PROD(127 downto 124), Q0 =>  PROD(123 downto 120),
 R1 => PROD(119 downto 116), R0 =>  PROD(115 downto 112),
 S1 => PROD(111 downto 108), S0 =>  PROD(107 downto 104),
 T1 => PROD(103 downto 100), T0 =>  PROD(99  downto 96),
 U1 => PROD(95 downto 92),   U0 =>  PROD(91  downto 88),
 V1 => PROD(87  downto 84),  V0 =>  PROD(83  downto 80),
 W1 => PROD(79 downto 76),   W0 =>  PROD(75  downto 72),
 X1 => PROD(71  downto 68),  X0 =>  PROD(67  downto 64),
 Y1 => PROD(63 downto 60),   Y0 =>  PROD(59  downto 56),
 Z1 => PROD(55  downto 52),  Z0 =>  PROD(51  downto 48), 
 AA1 => PROD(47 downto 44),  AA0 =>  PROD(43  downto 40),
 BB1 => PROD(39  downto 36), BB0 =>  PROD(35  downto 32),
 CC1 => PROD(31 downto 28),  CC0 =>  PROD(27  downto 24),
 DD1 => PROD(23  downto 20), DD0 =>  PROD(19  downto 16),
 EE1 => PROD(15 downto 12),  EE0 =>  PROD(11  downto 8),
 FF1 => PROD(7   downto 4),  FF0 =>  PROD(3   downto 0),
 --------------------------------------------------------------------------------
 OUTPUT15 => SUMOFPROD(95 downto 90), OUTPUT14 => SUMOFPROD(89 downto 84) , 
 OUTPUT13 => SUMOFPROD(83 downto 78), OUTPUT12 => SUMOFPROD(77 downto 72), 
 OUTPUT11 => SUMOFPROD(71 downto 66), OUTPUT10 => SUMOFPROD(65 downto 60), 
 OUTPUT9  => SUMOFPROD(59 downto 54), OUTPUT8  => SUMOFPROD(53 downto 48),
 OUTPUT7  => SUMOFPROD(47 downto 42), OUTPUT6  => SUMOFPROD(41 downto 36), 
 OUTPUT5  => SUMOFPROD(35 downto 30), OUTPUT4  => SUMOFPROD(29 downto 24),
 OUTPUT3  => SUMOFPROD(23 downto 18), OUTPUT2  => SUMOFPROD(17 downto 12), 
 OUTPUT1  => SUMOFPROD(11 downto 6),  OUTPUT0  => SUMOFPROD(5 downto 0));

ANSWER_STORAGE	: Answer_Store PORT MAP  (EN => ENABLE, CLK => CLK, RESET => RESET, 
                                  INPUT => SUMOFPROD, ANSWER => FOURxFOUR);

END ARCHITECTURE STRUCTURAL;
