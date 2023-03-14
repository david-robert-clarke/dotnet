-- Final Year Project
-- Created by david Clarke
library IEEE;
USE IEEE.STD_LOGIC_1164.ALL;
--
ENTITY Encoder IS
	PORT (bo_selecta : in STD_LOGIC_VECTOR (31 DOWNTO 0); encode_out : out STD_LOGIC_VECTOR (7 DOWNTO 0));
END ENTITY Encoder;
--
architecture behavioural of encoder is
begin
	process	(bo_selecta)
	begin
		CASE bo_selecta IS
			WHEN X"00000000" => encode_out <= "00000001";
			WHEN X"00000001" => encode_out <= "00000010";
			WHEN X"00000010" => encode_out <= "00000011";
			WHEN X"00000100" => encode_out <= "00000100";
			WHEN X"00001000" => encode_out <= "00000101";
			WHEN X"00010000" => encode_out <= "00000110";
			WHEN X"00100000" => encode_out <= "00000111";
			WHEN X"01000000" => encode_out <= "00001000";
			WHEN X"10000000" => encode_out <= "00001001";
			WHEN X"01100000" => encode_out <= "00001010";
			WHEN X"00110000" => encode_out <= "00001011";
			WHEN X"00011000" => encode_out <= "00001100";
			WHEN X"00001100" => encode_out <= "00001101";
			WHEN X"00000110" => encode_out <= "00001110";
			WHEN X"00000011" => encode_out <= "00001111";
			WHEN X"00001110" => encode_out <= "00010000";
			WHEN X"00011100" => encode_out <= "00010001";
			WHEN X"00111000" => encode_out <= "00010010";
			WHEN X"01110000" => encode_out <= "00010011";
			WHEN OTHERS      => encode_out <= "11100111";
		END CASE;
	END process;
END ARCHITECTURE behavioural;


			
