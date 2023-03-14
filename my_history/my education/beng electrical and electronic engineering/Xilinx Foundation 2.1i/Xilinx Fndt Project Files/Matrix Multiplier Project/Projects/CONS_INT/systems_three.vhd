-- Final Year Project
-- By David.R.Clarke
-- Created 23_01_2001
Library IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
USE IEEE.STD_LOGIC_ARITH.ALL;
USE WORK.MATRIX_PACKAGE.ALL;
--
Entity SYSTEM is
     Port (CLK, RESET : IN ONE_BIT;
     	   MODE_SEL   : IN TWO_BITS;
           A0B0_A1B2, A0B1_A1B3, A2B0_A3B2, A2B1_A3B3 : OUT FIVE_BITS);
End Entity SYSTEM;

Architecture STRUCTURAL of SYSTEM is
-- Component Declarations

-- Component STARTUP
-- Port (GSR: in std_logic);
-- End Component STARTUP;

Component ASM_CONFIG IS
PORT (CLK, RESET      : IN  ONE_BIT; 
      S               : IN  TWO_BITS;
      DATA_SELECT     : OUT INTEGER RANGE 6 downto 0;
      MEM_SEL_OUT     : OUT THREE_BITS);
END Component ASM_CONFIG;

Component data_store is
     port (ADDR: in INTEGER range 6 downto 0;
           DATA: out U_LONG_WORD);
end Component data_store;

Component DSP_CONFIG IS
PORT (CLK, RESET : IN ONE_BIT;
      SEL        : IN THREE_BITS;
      MAT_A_D_IN_7, MAT_A_D_IN_6, MAT_A_D_IN_5, MAT_A_D_IN_4,  
      MAT_B_D_IN_7, MAT_B_D_IN_6, MAT_B_D_IN_5, MAT_B_D_IN_4,
      MAT_A_D_IN_3, MAT_A_D_IN_2, MAT_A_D_IN_1, MAT_A_D_IN_0,  
      MAT_B_D_IN_3, MAT_B_D_IN_2, MAT_B_D_IN_1, MAT_B_D_IN_0 : IN U_TWO_BITS;
      A0B0_A1B2, A0B1_A1B3, A2B0_A3B2, A2B1_A3B3 : OUT FIVE_BITS);
END Component DSP_CONFIG;     

Signal Data_Sel_Bus   : INTEGER RANGE 6 downto 0;
Signal Elem_DBUS      : U_LONG_WORD;
Signal Mem_Sel_Bus    : THREE_BITS;  
-- SIGNAL GSR_NET        : ONE_BIT;
Begin
-- Component Instantiations

-- U1                : STARTUP  port map   (GSR=> GSR_NET);

Asm_Config_Three  : Asm_Config PORT MAP (S => MODE_SEL, CLK => CLK, RESET => RESET, MEM_SEL_OUT => Mem_Sel_Bus, DATA_SELECT => Data_Sel_Bus);

Data_Store_Three  : Data_Store PORT MAP (ADDR => Data_Sel_Bus, DATA => Elem_DBUS);

DSP_Three         : DSP_CONFIG PORT MAP (CLK => CLK, RESET => RESET, SEL => Mem_Sel_Bus,
					MAT_A_D_IN_7 => Elem_DBUS(31 downto 30), MAT_B_D_IN_7 => Elem_DBUS(29 downto 28),
                                        MAT_A_D_IN_6 => Elem_DBUS(27 downto 26), MAT_B_D_IN_6 => Elem_DBUS(25 downto 24),
                                        MAT_A_D_IN_5 => Elem_DBUS(23 downto 22), MAT_B_D_IN_5 => Elem_DBUS(21 downto 20),
                                        MAT_A_D_IN_4 => Elem_DBUS(19 downto 18), MAT_B_D_IN_4 => Elem_DBUS(17 downto 16),
					MAT_A_D_IN_3 => Elem_DBUS(15 downto 14), MAT_B_D_IN_3 => Elem_DBUS(13 downto 12),
                                        MAT_A_D_IN_2 => Elem_DBUS(11 downto 10), MAT_B_D_IN_2 => Elem_DBUS(9 downto 8),
                                        MAT_A_D_IN_1 => Elem_DBUS(7 downto 6),   MAT_B_D_IN_1 => Elem_DBUS(5 downto 4),
                                        MAT_A_D_IN_0 => Elem_DBUS(3 downto 2),   MAT_B_D_IN_0 => Elem_DBUS(1 downto 0),
                                        A0B0_A1B2 => A0B0_A1B2 , A0B1_A1B3 => A0B1_A1B3, A2B0_A3B2 => A2B0_A3B2, 
                                        A2B1_A3B3 => A2B1_A3B3);

End Architecture STRUCTURAL;



