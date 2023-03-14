-- Final Year Project
-- Created by david clarke
library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_arith.all;
use work.matrix_package.all;

entity many_mul is
	PORT (input : in STD_LOGIC_VECTOR (3 DOWNTO 0); output : out byte);
end entity many_mul;
--
architecture structural of many_mul is 

component DECODER IS
	PORT (SEL : IN STD_LOGIC_VECTOR (3 DOWNTO 0); DATA : OUT U_LONG_WORD_x2);
END component DECODER;

component MUL_2BIT IS
	PORT (A, B : IN U_two_bits; Z : OUT nibble);
END component MUL_2BIT;

component Encoder IS
	PORT (bo_selecta : in Long_word_x2; encode_out : out byte);
END component Encoder;

signal dec_mul_signal : U_Long_word_x2;
SIGNAL MUL_ENC_SIGNAL : LONG_WORD_X2;

begin	 

dec_1	: decoder port map (sel => input, data => dec_mul_signal);

mul_0	: mul_2bit PORT MAP(A => dec_mul_signal(63 downto 62), B => dec_mul_signal(61 downto 60),
	            Z => MUL_ENC_SIGNAL(63 DOWNTO 60));

mul_1	: mul_2bit PORT MAP(A => dec_mul_signal(59 downto 58), B => dec_mul_signal(57 downto 56),
	            Z => MUL_ENC_SIGNAL(59 DOWNTO 56));

mul_2	: mul_2bit PORT MAP(A => dec_mul_signal(55 downto 54), B => dec_mul_signal(53 downto 52),
	            Z => MUL_ENC_SIGNAL(55 DOWNTO 52));
	            
mul_3	: mul_2bit PORT MAP(A => dec_mul_signal(51 downto 50), B => dec_mul_signal(49 downto 48),
	            Z => MUL_ENC_SIGNAL(51 DOWNTO 48));
	            
mul_4	: mul_2bit PORT MAP(A => dec_mul_signal(47 downto 46), B => dec_mul_signal(45 downto 44),
	            Z => MUL_ENC_SIGNAL(47 DOWNTO 44));
	            
mul_5	: mul_2bit PORT MAP(A => dec_mul_signal(43 downto 42), B => dec_mul_signal(41 downto 40),
	            Z => MUL_ENC_SIGNAL(43 DOWNTO 40));
	            
mul_6	: mul_2bit PORT MAP(A => dec_mul_signal(39 downto 38), B => dec_mul_signal(37 downto 36),
	            Z => MUL_ENC_SIGNAL(39 DOWNTO 36));
	            
mul_7	: mul_2bit PORT MAP(A => dec_mul_signal(35 downto 34), B => dec_mul_signal(33 downto 32),
	            Z => MUL_ENC_SIGNAL(35 DOWNTO 32));
	            
mul_8	: mul_2bit PORT MAP(A => dec_mul_signal(31 downto 30), B => dec_mul_signal(29 downto 28),
	            Z => MUL_ENC_SIGNAL(31 DOWNTO 28));
	            
mul_9	: mul_2bit PORT MAP(A => dec_mul_signal(27 downto 26), B => dec_mul_signal(25 downto 24),
	            Z => MUL_ENC_SIGNAL(27 DOWNTO 24));

mul_10	: mul_2bit PORT MAP(A => dec_mul_signal(23 downto 22), B => dec_mul_signal(21 downto 20),
	            Z => MUL_ENC_SIGNAL(23 DOWNTO 20));

mul_11	: mul_2bit PORT MAP(A => dec_mul_signal(19 downto 18), B => dec_mul_signal(17 downto 16),
	            Z => MUL_ENC_SIGNAL(19 DOWNTO 16));
	            
mul_12	: mul_2bit PORT MAP(A => dec_mul_signal(15 downto 14), B => dec_mul_signal(13 downto 12),
	            Z => MUL_ENC_SIGNAL(15 DOWNTO 12));
	            
mul_13	: mul_2bit PORT MAP(A => dec_mul_signal(11 downto 10), B => dec_mul_signal(9 downto 8),
	            Z => MUL_ENC_SIGNAL(11 DOWNTO 8));
	            
mul_14	: mul_2bit PORT MAP(A => dec_mul_signal(7 downto 6), B => dec_mul_signal(5 downto 4),
	            Z => MUL_ENC_SIGNAL(7 DOWNTO 4));
	            
mul_15	: mul_2bit PORT MAP(A => dec_mul_signal(3 downto 2), B => dec_mul_signal(1 downto 0),
	            Z => MUL_ENC_SIGNAL(3 DOWNTO 0));
	            
enc_1	: Encoder port map (BO_SELECTA => MUL_ENC_SIGNAL, ENCODE_OUT => OUTPUT);
	
end architecture structural;

