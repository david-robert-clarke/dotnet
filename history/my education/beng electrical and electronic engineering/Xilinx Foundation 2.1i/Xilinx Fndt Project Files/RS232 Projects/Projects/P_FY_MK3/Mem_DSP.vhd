-- Final Year Project
-- By David.R.Clarke
-- 12_12_2000
Library IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
USE IEEE.STD_LOGIC_ARITH.ALL;
--
Entity Mem_DSP IS
Port (ADDR: in INTEGER range 3 downto 0;
      CE, CLR : IN STD_LOGIC;
      LATCH_MEM : IN STD_LOGIC_VECTOR (3 downto 0); 
      A0B0_A1B2, A0B1_A1B3, A2B0_A3B2, A2B1_A3B3 : OUT STD_LOGIC_VECTOR (4 downto 0));
End Entity Mem_DSP;
--
Architecture Structural OF Mem_DSP IS

COMPONENT Data_Store IS
PORT (ADDR: in INTEGER range 3 downto 0;
      DATA: out unsigned (7 downto 0));
END COMPONENT Data_Store;

COMPONENT DSP IS
PORT (CE, CLR : IN STD_LOGIC;
      MAT_A_D_IN_1, MAT_A_D_IN_0, MAT_B_D_IN_1, MAT_B_D_IN_0 : IN UNSIGNED (1 downto 0);
      LATCH_MEM : IN STD_LOGIC_VECTOR (3 downto 0); 
      A0B0_A1B2, A0B1_A1B3, A2B0_A3B2, A2B1_A3B3 : OUT STD_LOGIC_VECTOR (4 downto 0));
END COMPONENT DSP;

Signal Elem_DBUS : UNSIGNED (7 downto 0);

Begin

Data_Store_1 : Data_Store PORT MAP (ADDR => ADDR, DATA => Elem_DBUS);
DSP_1        : DSP        PORT MAP (CE => CE, CLR => CLR, MAT_A_D_IN_1 => Elem_DBUS(7 downto 6), 
                                    MAT_A_D_IN_0 => Elem_DBUS(3 downto 2), MAT_B_D_IN_1 => Elem_DBUS(5 downto 4),
                                    MAT_B_D_IN_0 => Elem_DBUS(1 downto 0), LATCH_MEM => LATCH_MEM, 
                                    A0B0_A1B2 => A0B0_A1B2 , A0B1_A1B3 => A0B1_A1B3, A2B0_A3B2 => A2B0_A3B2, 
                                    A2B1_A3B3 => A2B1_A3B3);
End Architecture Structural; 
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
