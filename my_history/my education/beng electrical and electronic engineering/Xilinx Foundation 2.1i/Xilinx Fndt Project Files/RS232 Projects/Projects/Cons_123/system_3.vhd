-- Final Year Project
-- By David.R.Clarke
-- Created 14_12_2000
-- Updated 20_12_2000
Library IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
USE IEEE.STD_LOGIC_ARITH.ALL;
USE WORK.MATRIX_PACKAGE.ALL;
--
Entity SYSTEM_3 is
     Port (CLK, RESET : IN ONE_BIT;
           A0B0_A1B2, A0B1_A1B3, A2B0_A3B2, A2B1_A3B3 : OUT FIVE_BITS);
End Entity SYSTEM_3;

Architecture STRUCTURAL of SYSTEM_3 is
-- Component Declarations

--Component STARTUP
--Port (GSR: in std_logic);
--End Component;

Component DSP_CONFIG_3 IS
PORT (C, R : IN ONE_BIT;
      MAT_A_D_IN_7, MAT_A_D_IN_6, MAT_A_D_IN_5, MAT_A_D_IN_4,  
      MAT_B_D_IN_7, MAT_B_D_IN_6, MAT_B_D_IN_5, MAT_B_D_IN_4,
      MAT_A_D_IN_3, MAT_A_D_IN_2, MAT_A_D_IN_1, MAT_A_D_IN_0,  
      MAT_B_D_IN_3, MAT_B_D_IN_2, MAT_B_D_IN_1, MAT_B_D_IN_0 : IN U_TWO_BITS;
      A0B0_A1B2, A0B1_A1B3, A2B0_A3B2, A2B1_A3B3 : OUT FIVE_BITS);
END Component DSP_CONFIG_3;     

Component data_store_3 is
     port (DATA: out U_LONG_WORD);
end Component data_store_3;

Component ASM_CONFIG_3 IS
PORT (CLK, RESET      : IN ONE_BIT; 
      DATA_SELECT     : OUT INTEGER range 1 downto 0;
      MEM_SEL_OUT     : OUT ONE_BIT);
END Component ASM_CONFIG_3;

Signal Elem_DBUS      : U_LONG_WORD;
Signal Mem_SelBus     : ONE_BIT;  
-- SIGNAL GSR_NET          : ONE_BIT;
Begin
-- Component Instantiations

-- U1: STARTUP  port map (GSR=>RESET);

DSP_3 : DSP_CONFIG_3          PORT MAP (C => CLK, R => RESET,
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

Data_Store_3A  : Data_Store_3   PORT MAP (DATA => Elem_DBUS);

Asm_Config_3_A : Asm_Config_3 PORT MAP (CLK => CLK, RESET => RESET, MEM_SEL_OUT => Mem_SelBus);

End Architecture STRUCTURAL;



