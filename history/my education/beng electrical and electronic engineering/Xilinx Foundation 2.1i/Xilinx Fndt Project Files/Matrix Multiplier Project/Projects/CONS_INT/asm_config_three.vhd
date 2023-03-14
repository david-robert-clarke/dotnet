-- Final Year Project
-- By David Clarke
-- Created 22_1_2001
Library IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
USE WORK.MATRIX_PACKAGE.ALL; -- USING MY NEW PACKAGE
--
ENTITY ASM_CONFIG IS
PORT (CLK, RESET      : IN  ONE_BIT; 
      S               : IN  TWO_BITS;
      DATA_SELECT     : OUT INTEGER RANGE 6 downto 0;
      MEM_SEL_OUT     : OUT THREE_BITS);
END ENTITY ASM_CONFIG;
--
ARCHITECTURE STATE_MACHINE OF ASM_CONFIG IS
TYPE STATE_TYPE IS (S_INIT, S0, S1, S2, S3, T0, T1, U0);
signal CURRENT_STATE, NEXT_STATE : STATE_TYPE;

BEGIN
    next_state_logic: PROCESS (S, current_state) IS
         Begin   
              CASE current_state IS           
                   WHEN S_INIT => 
                       IF    S = "00" THEN next_state <= S0;
                           ELSIF S = "01" THEN next_state <= T0;
                               ELSIF S = "10" THEN next_state <= U0;
                           ELSE
                       next_state <= S_INIT;
                       END IF;
                       
                   WHEN S0 => next_state <= S1;
                   WHEN S1 => next_state <= S2;
                   WHEN S2 => next_state <= S3;
                   WHEN S3 => next_state <= S3;
                       
                   WHEN T0 => next_state <= T1;
                   WHEN T1 => next_state <= T1;
                            
                   WHEN U0 => next_state <= U0;
                            
               END CASE;
         End Process next_state_logic;
        
    state_update : PROCESS (next_state, RESET, CLK) IS
         Begin
              IF rising_edge(clk) THEN
                 IF RESET = '1' THEN current_state <= S_INIT;
                 ELSE current_state <= next_state;
                 END IF;
              END IF;
         End PROCESS state_update;
         
   output_logic : PROCESS (current_state)
        Begin
             CASE current_state IS
                  WHEN S_INIT  =>    Data_Select <= 0; 
                 		     MEM_SEL_OUT <= "111";
                  
                  WHEN S0      =>    Data_Select <= 0;
                  	             MEM_SEL_OUT <= "000";
                  
                  WHEN S1      =>    Data_Select <= 1;
                  		     MEM_SEL_OUT <= "001";
                  			
                  WHEN S2      =>    Data_Select <= 2;
                  		     MEM_SEL_OUT <= "010"; 
                  		
                  WHEN S3      =>    Data_Select <= 3;
                  		     MEM_SEL_OUT <= "011";   
                  		
                  WHEN T0      =>    Data_Select <= 4;
                  		     MEM_SEL_OUT <= "100";   
                  		
                  WHEN T1      =>    Data_Select <= 5;
                  		     MEM_SEL_OUT <= "101"; 
                  
                  WHEN U0      =>    Data_Select <= 6; 
                                     MEM_SEL_OUT <= "110";  
                    
             END CASE;
        END PROCESS output_logic;     
                   
END ARCHITECTURE STATE_MACHINE;
    
