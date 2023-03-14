library IEEE;
Use IEEE.std_logic_1164.all;
-- The size comparator was created on 27-11-2000 by David_R_Clarke
-- whilst listening to Christmas Anthems
Entity Size_Comparator IS
Port (Next_byte : in std_logic_vector (15 downto 0);
      Error_Output, FSMCON_EN : out std_logic);
End Entity Size_Comparator;

Architecture Behavioural OF Size_Comparator IS

Signal No_of_Rows_Matrix_A, No_of_Cols_Matrix_A,
       No_of_Rows_Matrix_B, No_of_Cols_Matrix_B : std_logic_vector (3 downto 0);

Begin

	Count_rows_cols_Matrix_A : Process (next_byte) IS

	-- The dimension code for a 3x3 matrix is 120 in decimal, which is 01111000 in binary
	-- This decoder checks the Dimensional Byte value then outputs the appropriate
	-- number of rows and columns 

	Begin

	   CASE next_byte (15 downto 8) IS
	   	WHEN "01100100" => No_of_Rows_Matrix_A <= "0001";
	   		     	   No_of_Cols_Matrix_A <= "0001"; 
	   	WHEN "01100101" => No_of_Rows_Matrix_A <= "0001";
	   		     	   No_of_Cols_Matrix_A <= "0010"; 
	   	WHEN "01100110" => No_of_Rows_Matrix_A <= "0001";
	   		     	   No_of_Cols_Matrix_A <= "0011";
	        WHEN "01100111" => No_of_Rows_Matrix_A <= "0001";
	   		     	   No_of_Cols_Matrix_A <= "0100"; 
	        WHEN "01101000" => No_of_Rows_Matrix_A <= "0001";
	   		     	   No_of_Cols_Matrix_A <= "0101"; 
	        WHEN "01101001" => No_of_Rows_Matrix_A <= "0001";
	   		     	   No_of_Cols_Matrix_A <= "0110"; 
	        WHEN "01101010" => No_of_Rows_Matrix_A <= "0001";
	   		     	   No_of_Cols_Matrix_A <= "0111"; 
	        WHEN "01101011" => No_of_Rows_Matrix_A <= "0001";
	   		     	   No_of_Cols_Matrix_A <= "1000"; 
	        WHEN "01101100" => No_of_Rows_Matrix_A <= "0001";
	   		     	   No_of_Cols_Matrix_A <= "1001";
	   	-- 
	        WHEN "01101101" => No_of_Rows_Matrix_A <= "0010";
	   		     	   No_of_Cols_Matrix_A <= "0001"; 
	   	WHEN "01101110" => No_of_Rows_Matrix_A <= "0010";
	   		     	   No_of_Cols_Matrix_A <= "0010"; 
	   	WHEN "01101111" => No_of_Rows_Matrix_A <= "0010";
	   		     	   No_of_Cols_Matrix_A <= "0011"; 
	   	WHEN "01110000" => No_of_Rows_Matrix_A <= "0010";
	   		     	   No_of_Cols_Matrix_A <= "0100"; 
	   	WHEN "01110001" => No_of_Rows_Matrix_A <= "0010";
	   		     	   No_of_Cols_Matrix_A <= "0101"; 
	   	WHEN "01110010" => No_of_Rows_Matrix_A <= "0010";
	   		     	   No_of_Cols_Matrix_A <= "0110"; 
	   	WHEN "01110011" => No_of_Rows_Matrix_A <= "0010";
	   		     	   No_of_Cols_Matrix_A <= "0111"; 
	   	WHEN "01110100" => No_of_Rows_Matrix_A <= "0010";
	   		     	   No_of_Cols_Matrix_A <= "1000"; 
	   	WHEN "01110101" => No_of_Rows_Matrix_A <= "0010";
	   		     	   No_of_Cols_Matrix_A <= "1001"; 
	   		     	   
	   	WHEN "01110110" => No_of_Rows_Matrix_A <= "0011";
	   		     	   No_of_Cols_Matrix_A <= "0001"; 
	   	WHEN "01110111" => No_of_Rows_Matrix_A <= "0011";
	   		     	   No_of_Cols_Matrix_A <= "0010"; 
	   	WHEN "01111000" => No_of_Rows_Matrix_A <= "0011";
	   		     	   No_of_Cols_Matrix_A <= "0011"; 
	        WHEN "01111001" => No_of_Rows_Matrix_A <= "0011";
	   		     	   No_of_Cols_Matrix_A <= "0100"; 
	   	WHEN "01111010" => No_of_Rows_Matrix_A <= "0011";
	   		     	   No_of_Cols_Matrix_A <= "0101"; 
	   	WHEN "01111011" => No_of_Rows_Matrix_A <= "0011";
	   		     	   No_of_Cols_Matrix_A <= "0110"; 
	   	WHEN "01111100" => No_of_Rows_Matrix_A <= "0011";
	   		     	   No_of_Cols_Matrix_A <= "0111"; 
	   	WHEN "01111101" => No_of_Rows_Matrix_A <= "0011";
	   		     	   No_of_Cols_Matrix_A <= "1000"; 
	        WHEN "01111110" => No_of_Rows_Matrix_A <= "0011";
	   		     	   No_of_Cols_Matrix_A <= "1001"; 
	   		     	   
	   	WHEN "01111111" => No_of_Rows_Matrix_A <= "0100";
	   		     	   No_of_Cols_Matrix_A <= "0001"; 
	   	WHEN "10000000" => No_of_Rows_Matrix_A <= "0100";
	   		     	   No_of_Cols_Matrix_A <= "0010"; 
	   	WHEN "10000001" => No_of_Rows_Matrix_A <= "0100";
	   		     	   No_of_Cols_Matrix_A <= "0011"; 
	        WHEN "10000010" => No_of_Rows_Matrix_A <= "0100";
	   		     	   No_of_Cols_Matrix_A <= "0100"; 
	   	WHEN "10000011" => No_of_Rows_Matrix_A <= "0100";
	   		     	   No_of_Cols_Matrix_A <= "0101"; 
	        WHEN "10000100" => No_of_Rows_Matrix_A <= "0100";
	   		     	   No_of_Cols_Matrix_A <= "0110"; 
	   	WHEN "10000101" => No_of_Rows_Matrix_A <= "0100";
	   		     	   No_of_Cols_Matrix_A <= "0111"; 
	   	WHEN "10000110" => No_of_Rows_Matrix_A <= "0100";
	   		     	   No_of_Cols_Matrix_A <= "1000"; 
	   	WHEN "10000111" => No_of_Rows_Matrix_A <= "0100";
	   		     	   No_of_Cols_Matrix_A <= "1001"; 
	   		     	   
	   	WHEN "10001000" => No_of_Rows_Matrix_A <= "0101";
	   		     	   No_of_Cols_Matrix_A <= "0001"; 
	   	WHEN "10001001" => No_of_Rows_Matrix_A <= "0101";
	   		     	   No_of_Cols_Matrix_A <= "0010"; 
	   	WHEN "10001010" => No_of_Rows_Matrix_A <= "0101";
	   		     	   No_of_Cols_Matrix_A <= "0011"; 
	        WHEN "10001011" => No_of_Rows_Matrix_A <= "0101";
	   		     	   No_of_Cols_Matrix_A <= "0100"; 
	   	WHEN "10001100" => No_of_Rows_Matrix_A <= "0101";
	   		     	   No_of_Cols_Matrix_A <= "0101"; 
	        WHEN "10001101" => No_of_Rows_Matrix_A <= "0101";
	   		     	   No_of_Cols_Matrix_A <= "0110"; 
	   	WHEN "10001110" => No_of_Rows_Matrix_A <= "0101";
	   		     	   No_of_Cols_Matrix_A <= "0111"; 
	   	WHEN "10001111" => No_of_Rows_Matrix_A <= "0101";
	   		     	   No_of_Cols_Matrix_A <= "1000"; 
	        WHEN "10010000" => No_of_Rows_Matrix_A <= "0101";
	   		     	   No_of_Cols_Matrix_A <= "1001"; 
	   		     	   --
	   	WHEN "10010001" => No_of_Rows_Matrix_A <= "0110";
	   		     	   No_of_Cols_Matrix_A <= "0001"; 
	   	WHEN "10010010" => No_of_Rows_Matrix_A <= "0110";
	   		     	   No_of_Cols_Matrix_A <= "0010"; 
	        WHEN "10010011" => No_of_Rows_Matrix_A <= "0110";
	   		     	   No_of_Cols_Matrix_A <= "0011"; 
	   	WHEN "10010100" => No_of_Rows_Matrix_A <= "0110";
	   		     	   No_of_Cols_Matrix_A <= "0100"; 
	   	WHEN "10010101" => No_of_Rows_Matrix_A <= "0110";
	   		     	   No_of_Cols_Matrix_A <= "0101"; 
	   	WHEN "10010110" => No_of_Rows_Matrix_A <= "0110";
	   		     	   No_of_Cols_Matrix_A <= "0110"; 
	   	WHEN "10010111" => No_of_Rows_Matrix_A <= "0110";
	   		     	   No_of_Cols_Matrix_A <= "0111"; 
	   	WHEN "10011000" => No_of_Rows_Matrix_A <= "0110";
	   		     	   No_of_Cols_Matrix_A <= "1000"; 
	   	WHEN "10011001" => No_of_Rows_Matrix_A <= "0110";
	   		     	   No_of_Cols_Matrix_A <= "1001"; 
	   		     	   --
	   	WHEN "10011010" => No_of_Rows_Matrix_A <= "0111";
	   		     	   No_of_Cols_Matrix_A <= "0001"; 
	   	WHEN "10011011" => No_of_Rows_Matrix_A <= "0111";
	   		     	   No_of_Cols_Matrix_A <= "0010"; 
	   	WHEN "10011100" => No_of_Rows_Matrix_A <= "0111";
	   		     	   No_of_Cols_Matrix_A <= "0011"; 
	   	WHEN "10011101" => No_of_Rows_Matrix_A <= "0111";
	   		     	   No_of_Cols_Matrix_A <= "0100"; 
	   	WHEN "10011110" => No_of_Rows_Matrix_A <= "0111";
	   		     	   No_of_Cols_Matrix_A <= "0101"; 
	        WHEN "10011111" => No_of_Rows_Matrix_A <= "0111";
	   		     	   No_of_Cols_Matrix_A <= "0110"; 
	   	WHEN "10100000" => No_of_Rows_Matrix_A <= "0111";
	   		     	   No_of_Cols_Matrix_A <= "0111"; 
	        WHEN "10100001" => No_of_Rows_Matrix_A <= "0111";
	   		     	   No_of_Cols_Matrix_A <= "1000"; 
	   	WHEN "10100010" => No_of_Rows_Matrix_A <= "0111";
	   		     	   No_of_Cols_Matrix_A <= "1001"; 
	   		     	   --
	        WHEN "10100011" => No_of_Rows_Matrix_A <= "1000";
	   		     	   No_of_Cols_Matrix_A <= "0001"; 
	        WHEN "10100100" => No_of_Rows_Matrix_A <= "1000";
	   		     	   No_of_Cols_Matrix_A <= "0010"; 
	        WHEN "10100101" => No_of_Rows_Matrix_A <= "1000";
	   		     	   No_of_Cols_Matrix_A <= "0011"; 
	   	WHEN "10100110" => No_of_Rows_Matrix_A <= "1000";
	   		     	   No_of_Cols_Matrix_A <= "0100"; 
	   	WHEN "10100111" => No_of_Rows_Matrix_A <= "1000";
	   		     	   No_of_Cols_Matrix_A <= "0101"; 
	   	WHEN "10101000" => No_of_Rows_Matrix_A <= "1000";
	   		     	   No_of_Cols_Matrix_A <= "0110"; 
	   	WHEN "10101001" => No_of_Rows_Matrix_A <= "1000";
	   		     	   No_of_Cols_Matrix_A <= "0111"; 
	   	WHEN "10101010" => No_of_Rows_Matrix_A <= "1000";
	   		     	   No_of_Cols_Matrix_A <= "1000"; 
	   	WHEN "10101011" => No_of_Rows_Matrix_A <= "1000";
	   		     	   No_of_Cols_Matrix_A <= "1001"; 
	   		     	   --
	   	WHEN "10101100" => No_of_Rows_Matrix_A <= "1001";
	   		     	   No_of_Cols_Matrix_A <= "0001"; 
	   	WHEN "10101101" => No_of_Rows_Matrix_A <= "1001";
	   		     	   No_of_Cols_Matrix_A <= "0010"; 
	        WHEN "10101110" => No_of_Rows_Matrix_A <= "1001";
	   		     	   No_of_Cols_Matrix_A <= "0011"; 
	   	WHEN "10101111" => No_of_Rows_Matrix_A <= "1001";
	   		     	   No_of_Cols_Matrix_A <= "0100"; 
	   	WHEN "10110000" => No_of_Rows_Matrix_A <= "1001";
	   		     	   No_of_Cols_Matrix_A <= "0101"; 
	   	WHEN "10110001" => No_of_Rows_Matrix_A <= "1001";
	   		     	   No_of_Cols_Matrix_A <= "0110"; 
	   	WHEN "10110010" => No_of_Rows_Matrix_A <= "1001";
	   		     	   No_of_Cols_Matrix_A <= "0111"; 
	   	WHEN "10110011" => No_of_Rows_Matrix_A <= "1001";
	   		     	   No_of_Cols_Matrix_A <= "1000"; 
	   	WHEN "10110100" => No_of_Rows_Matrix_A <= "1001";
	   		     	   No_of_Cols_Matrix_A <= "1001"; 	     	   
	   		     	   
	   		     	 
	  	WHEN OTHERS     => No_of_Rows_Matrix_A <= "0000";	-- WHEN OTHERS SHOULDN'T OCCUR, BUT IF IT DOES
	   		      	   No_of_Cols_Matrix_A <= "0000"; 	-- THE NO OF ROWS AND COLUMNS SHOULD BE DIFFERENT
        	END CASE;						-- TO THAT OF THE process Count_rows_cols_Matrix_X

	End Process Count_rows_cols_Matrix_A;
	
	Count_rows_cols_Matrix_B : Process (next_byte) IS

	-- The dimension code for a 3x3 matrix is 120 in decimal, which is 01111000 in binary
	-- This decoder checks the Dimensional Byte value then outputs the appropriate
	-- number of rows and columns 

	Begin

	   CASE next_byte (7 downto 0) IS
	   	WHEN "01100100" => No_of_Rows_Matrix_B <= "0001";
	   		     	   No_of_Cols_Matrix_B <= "0001"; 
	   	WHEN "01100101" => No_of_Rows_Matrix_B <= "0001";
	   		     	   No_of_Cols_Matrix_B <= "0010"; 
	   	WHEN "01100110" => No_of_Rows_Matrix_B <= "0001";
	   		     	   No_of_Cols_Matrix_B <= "0011";
	        WHEN "01100111" => No_of_Rows_Matrix_B <= "0001";
	   		     	   No_of_Cols_Matrix_B <= "0100"; 
	        WHEN "01101000" => No_of_Rows_Matrix_B <= "0001";
	   		     	   No_of_Cols_Matrix_B <= "0101"; 
	        WHEN "01101001" => No_of_Rows_Matrix_B <= "0001";
	   		     	   No_of_Cols_Matrix_B <= "0110"; 
	        WHEN "01101010" => No_of_Rows_Matrix_B <= "0001";
	   		     	   No_of_Cols_Matrix_B <= "0111"; 
	        WHEN "01101011" => No_of_Rows_Matrix_B <= "0001";
	   		     	   No_of_Cols_Matrix_B <= "1000"; 
	        WHEN "01101100" => No_of_Rows_Matrix_B <= "0001";
	   		     	   No_of_Cols_Matrix_B <= "1001";
	   	-- 
	        WHEN "01101101" => No_of_Rows_Matrix_B <= "0010";
	   		     	   No_of_Cols_Matrix_B <= "0001"; 
	   	WHEN "01101110" => No_of_Rows_Matrix_B <= "0010";
	   		     	   No_of_Cols_Matrix_B <= "0010"; 
	   	WHEN "01101111" => No_of_Rows_Matrix_B <= "0010";
	   		     	   No_of_Cols_Matrix_B <= "0011"; 
	   	WHEN "01110000" => No_of_Rows_Matrix_B <= "0010";
	   		     	   No_of_Cols_Matrix_B <= "0100"; 
	   	WHEN "01110001" => No_of_Rows_Matrix_B <= "0010";
	   		     	   No_of_Cols_Matrix_B <= "0101"; 
	   	WHEN "01110010" => No_of_Rows_Matrix_B <= "0010";
	   		     	   No_of_Cols_Matrix_B <= "0110"; 
	   	WHEN "01110011" => No_of_Rows_Matrix_B <= "0010";
	   		     	   No_of_Cols_Matrix_B <= "0111"; 
	   	WHEN "01110100" => No_of_Rows_Matrix_B <= "0010";
	   		     	   No_of_Cols_Matrix_B <= "1000"; 
	   	WHEN "01110101" => No_of_Rows_Matrix_B <= "0010";
	   		     	   No_of_Cols_Matrix_B <= "1001"; 
	   		     	   
	   	WHEN "01110110" => No_of_Rows_Matrix_B <= "0011";
	   		     	   No_of_Cols_Matrix_B <= "0001"; 
	   	WHEN "01110111" => No_of_Rows_Matrix_B <= "0011";
	   		     	   No_of_Cols_Matrix_B <= "0010"; 
	   	WHEN "01111000" => No_of_Rows_Matrix_B <= "0011";
	   		     	   No_of_Cols_Matrix_B <= "0011"; 
	        WHEN "01111001" => No_of_Rows_Matrix_B <= "0011";
	   		     	   No_of_Cols_Matrix_B <= "0100"; 
	   	WHEN "01111010" => No_of_Rows_Matrix_B <= "0011";
	   		     	   No_of_Cols_Matrix_B <= "0101"; 
	   	WHEN "01111011" => No_of_Rows_Matrix_B <= "0011";
	   		     	   No_of_Cols_Matrix_B <= "0110"; 
	   	WHEN "01111100" => No_of_Rows_Matrix_B <= "0011";
	   		     	   No_of_Cols_Matrix_B <= "0111"; 
	   	WHEN "01111101" => No_of_Rows_Matrix_B <= "0011";
	   		     	   No_of_Cols_Matrix_B <= "1000"; 
	        WHEN "01111110" => No_of_Rows_Matrix_B <= "0011";
	   		     	   No_of_Cols_Matrix_B <= "1001"; 
	   		     	   
	   	WHEN "01111111" => No_of_Rows_Matrix_B <= "0100";
	   		     	   No_of_Cols_Matrix_B <= "0001"; 
	   	WHEN "10000000" => No_of_Rows_Matrix_B <= "0100";
	   		     	   No_of_Cols_Matrix_B <= "0010"; 
	   	WHEN "10000001" => No_of_Rows_Matrix_B <= "0100";
	   		     	   No_of_Cols_Matrix_B <= "0011"; 
	        WHEN "10000010" => No_of_Rows_Matrix_B <= "0100";
	   		     	   No_of_Cols_Matrix_B <= "0100"; 
	   	WHEN "10000011" => No_of_Rows_Matrix_B <= "0100";
	   		     	   No_of_Cols_Matrix_B <= "0101"; 
	        WHEN "10000100" => No_of_Rows_Matrix_B <= "0100";
	   		     	   No_of_Cols_Matrix_B <= "0110"; 
	   	WHEN "10000101" => No_of_Rows_Matrix_B <= "0100";
	   		     	   No_of_Cols_Matrix_B <= "0111"; 
	   	WHEN "10000110" => No_of_Rows_Matrix_B <= "0100";
	   		     	   No_of_Cols_Matrix_B <= "1000"; 
	   	WHEN "10000111" => No_of_Rows_Matrix_B <= "0100";
	   		     	   No_of_Cols_Matrix_B <= "1001"; 
	   		     	   
	   	WHEN "10001000" => No_of_Rows_Matrix_B <= "0101";
	   		     	   No_of_Cols_Matrix_B <= "0001"; 
	   	WHEN "10001001" => No_of_Rows_Matrix_B <= "0101";
	   		     	   No_of_Cols_Matrix_B <= "0010"; 
	   	WHEN "10001010" => No_of_Rows_Matrix_B <= "0101";
	   		     	   No_of_Cols_Matrix_B <= "0011"; 
	        WHEN "10001011" => No_of_Rows_Matrix_B <= "0101";
	   		     	   No_of_Cols_Matrix_B <= "0100"; 
	   	WHEN "10001100" => No_of_Rows_Matrix_B <= "0101";
	   		     	   No_of_Cols_Matrix_B <= "0101"; 
	        WHEN "10001101" => No_of_Rows_Matrix_B <= "0101";
	   		     	   No_of_Cols_Matrix_B <= "0110"; 
	   	WHEN "10001110" => No_of_Rows_Matrix_B <= "0101";
	   		     	   No_of_Cols_Matrix_B <= "0111"; 
	   	WHEN "10001111" => No_of_Rows_Matrix_B <= "0101";
	   		     	   No_of_Cols_Matrix_B <= "1000"; 
	        WHEN "10010000" => No_of_Rows_Matrix_B <= "0101";
	   		     	   No_of_Cols_Matrix_B <= "1001"; 
	   		     	   --
	   	WHEN "10010001" => No_of_Rows_Matrix_B <= "0110";
	   		     	   No_of_Cols_Matrix_B <= "0001"; 
	   	WHEN "10010010" => No_of_Rows_Matrix_B <= "0110";
	   		     	   No_of_Cols_Matrix_B <= "0010"; 
	        WHEN "10010011" => No_of_Rows_Matrix_B <= "0110";
	   		     	   No_of_Cols_Matrix_B <= "0011"; 
	   	WHEN "10010100" => No_of_Rows_Matrix_B <= "0110";
	   		     	   No_of_Cols_Matrix_B <= "0100"; 
	   	WHEN "10010101" => No_of_Rows_Matrix_B <= "0110";
	   		     	   No_of_Cols_Matrix_B <= "0101"; 
	   	WHEN "10010110" => No_of_Rows_Matrix_B <= "0110";
	   		     	   No_of_Cols_Matrix_B <= "0110"; 
	   	WHEN "10010111" => No_of_Rows_Matrix_B <= "0110";
	   		     	   No_of_Cols_Matrix_B <= "0111"; 
	   	WHEN "10011000" => No_of_Rows_Matrix_B <= "0110";
	   		     	   No_of_Cols_Matrix_B <= "1000"; 
	   	WHEN "10011001" => No_of_Rows_Matrix_B <= "0110";
	   		     	   No_of_Cols_Matrix_B <= "1001"; 
	   		     	   --
	   	WHEN "10011010" => No_of_Rows_Matrix_B <= "0111";
	   		     	   No_of_Cols_Matrix_B <= "0001"; 
	   	WHEN "10011011" => No_of_Rows_Matrix_B <= "0111";
	   		     	   No_of_Cols_Matrix_B <= "0010"; 
	   	WHEN "10011100" => No_of_Rows_Matrix_B <= "0111";
	   		     	   No_of_Cols_Matrix_B <= "0011"; 
	   	WHEN "10011101" => No_of_Rows_Matrix_B <= "0111";
	   		     	   No_of_Cols_Matrix_B <= "0100"; 
	   	WHEN "10011110" => No_of_Rows_Matrix_B <= "0111";
	   		     	   No_of_Cols_Matrix_B <= "0101"; 
	        WHEN "10011111" => No_of_Rows_Matrix_B <= "0111";
	   		     	   No_of_Cols_Matrix_B <= "0110"; 
	   	WHEN "10100000" => No_of_Rows_Matrix_B <= "0111";
	   		     	   No_of_Cols_Matrix_B <= "0111"; 
	        WHEN "10100001" => No_of_Rows_Matrix_B <= "0111";
	   		     	   No_of_Cols_Matrix_B <= "1000"; 
	   	WHEN "10100010" => No_of_Rows_Matrix_B <= "0111";
	   		     	   No_of_Cols_Matrix_B <= "1001"; 
	   		     	   --
	        WHEN "10100011" => No_of_Rows_Matrix_B <= "1000";
	   		     	   No_of_Cols_Matrix_B <= "0001"; 
	        WHEN "10100100" => No_of_Rows_Matrix_B <= "1000";
	   		     	   No_of_Cols_Matrix_B <= "0010"; 
	        WHEN "10100101" => No_of_Rows_Matrix_B <= "1000";
	   		     	   No_of_Cols_Matrix_B <= "0011"; 
	   	WHEN "10100110" => No_of_Rows_Matrix_B <= "1000";
	   		     	   No_of_Cols_Matrix_B <= "0100"; 
	   	WHEN "10100111" => No_of_Rows_Matrix_B <= "1000";
	   		     	   No_of_Cols_Matrix_B <= "0101"; 
	   	WHEN "10101000" => No_of_Rows_Matrix_B <= "1000";
	   		     	   No_of_Cols_Matrix_B <= "0110"; 
	   	WHEN "10101001" => No_of_Rows_Matrix_B <= "1000";
	   		     	   No_of_Cols_Matrix_B <= "0111"; 
	   	WHEN "10101010" => No_of_Rows_Matrix_B <= "1000";
	   		     	   No_of_Cols_Matrix_B <= "1000"; 
	   	WHEN "10101011" => No_of_Rows_Matrix_B <= "1000";
	   		     	   No_of_Cols_Matrix_B <= "1001"; 
	   		     	   --
	   	WHEN "10101100" => No_of_Rows_Matrix_B <= "1001";
	   		     	   No_of_Cols_Matrix_B <= "0001"; 
	   	WHEN "10101101" => No_of_Rows_Matrix_B <= "1001";
	   		     	   No_of_Cols_Matrix_B <= "0010"; 
	        WHEN "10101110" => No_of_Rows_Matrix_B <= "1001";
	   		     	   No_of_Cols_Matrix_B <= "0011"; 
	   	WHEN "10101111" => No_of_Rows_Matrix_B <= "1001";
	   		     	   No_of_Cols_Matrix_B <= "0100"; 
	   	WHEN "10110000" => No_of_Rows_Matrix_B <= "1001";
	   		     	   No_of_Cols_Matrix_B <= "0101"; 
	   	WHEN "10110001" => No_of_Rows_Matrix_B <= "1001";
	   		     	   No_of_Cols_Matrix_B <= "0110"; 
	   	WHEN "10110010" => No_of_Rows_Matrix_B <= "1001";
	   		     	   No_of_Cols_Matrix_B <= "0111"; 
	   	WHEN "10110011" => No_of_Rows_Matrix_B <= "1001";
	   		     	   No_of_Cols_Matrix_B <= "1000"; 
	   	WHEN "10110100" => No_of_Rows_Matrix_B <= "1001";
	   		     	   No_of_Cols_Matrix_B <= "1001"; 	     	   
	   	WHEN OTHERS     => No_of_Rows_Matrix_B <= "0000";	-- WHEN OTHERS SHOULDN'T OCCUR, BUT IF IT DOES
	   		      	   No_of_Cols_Matrix_B <= "0000"; 	-- THE NO OF ROWS AND COLUMNS SHOULD BE DIFFERENT
        	END CASE;						-- TO THAT OF THE process Count_rows_cols_Matrix_X
	End Process Count_rows_cols_Matrix_B;
	
	-- The result of the two above processes is compared using this process
	-- If the number of columns in Matrix A is different to the number of
	-- rows in Matrix B then output an error signal, else enable the
	-- finite state machine
	Comparator_Result : Process (No_of_Cols_Matrix_A, No_of_Cols_Matrix_B,
				     No_of_Rows_Matrix_A, No_of_Rows_Matrix_B) IS
	Begin
		
		IF No_of_Cols_Matrix_A = No_of_Rows_Matrix_B THEN
		   FSMCON_EN <= '1'; Error_Output <= '0';

		ELSIF No_of_Cols_Matrix_A /= No_of_Rows_Matrix_B THEN
		   Error_Output <= '1'; FSMCON_EN <= '0';
		   
		END IF;
	END Process Comparator_Result;


End Architecture Behavioural; 
