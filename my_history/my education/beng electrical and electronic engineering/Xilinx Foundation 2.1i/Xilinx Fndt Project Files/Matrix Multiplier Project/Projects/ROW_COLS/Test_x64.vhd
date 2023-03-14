-- Final Year Project
-- By David Clarke
-- Created 30_1_2001
USE WORK.MATRIX_PACKAGE.ALL;

ENTITY Multipliers_two_bits_x64 IS
PORT (AIN,BIN : IN U_X2_Long_word; ZOUT : OUT X4_Long_word);
END ENTITY Multipliers_two_bits_x64;

ARCHITECTURE Structural of Multipliers_two_bits_x64 is

Component MUL_TWO_BITS IS 
	PORT (A, B : IN U_TWO_BITS; Z : OUT NIBBLE);
END Component MUL_TWO_BITS;

Begin
                                 
MUL_63	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_62	: MUL_TWO_BITS port map (a(125 downto 124) => AIN(125 downto 124); 
                                 b(125 downto 124) => BIN(125 downto 124);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_61	: MUL_TWO_BITS port map (a(123 downto 122) => AIN(123 downto 122); 
                                 b(123 downto 122) => BIN(123 downto 122);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_60	: MUL_TWO_BITS port map (a(121 downto 120) => AIN(121 downto 120); 
                                 b(121 downto 120) => BIN(121 downto 120);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_59	: MUL_TWO_BITS port map (a(119 downto 118) => AIN(119 downto 118); 
                                 b(119 downto 118) => BIN(119 downto 118);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_58	: MUL_TWO_BITS port map (a(117 downto 116) => AIN(117 downto 116); 
                                 b(117 downto 116) => BIN(117 downto 116);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_57	: MUL_TWO_BITS port map (a(115 downto 114) => AIN(115 downto 114); 
                                 b(115 downto 114) => BIN(115 downto 114);
                                 z(255 downto 252) => ZOUT(255 downto 252); 
                                 
MUL_56	: MUL_TWO_BITS port map (a(113 downto 112) => AIN(113 downto 112); 
                                 b(113 downto 112) => BIN(113 downto 112);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_55	: MUL_TWO_BITS port map (a(111 downto 110) => AIN(111 downto 110); 
                                 b(111 downto 110) => BIN(111 downto 110);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_54	: MUL_TWO_BITS port map (a(109 downto 108) => AIN(109 downto 108); 
                                 b(109 downto 108) => BIN(109 downto 108);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_53	: MUL_TWO_BITS port map (a(107 downto 106) => AIN(107 downto 106); 
                                 b(107 downto 106) => BIN(107 downto 106);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_52	: MUL_TWO_BITS port map (a(105 downto 104) => AIN(105 downto 104); 
                                 b(105 downto 104) => BIN(105 downto 104);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_51	: MUL_TWO_BITS port map (a(103 downto 102) => AIN(103 downto 102); 
                                 b(103 downto 102) => BIN(103 downto 102);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_50	: MUL_TWO_BITS port map (a(101 downto 100) => AIN(101 downto 100); 
                                 b(101 downto 100) => BIN(101 downto 100);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_49	: MUL_TWO_BITS port map (a(99 downto 98) => AIN(99 downto 98); 
                                 b(99 downto 98) => BIN(99 downto 98);
                                 z(255 downto 252) => ZOUT(255 downto 252);  
                                
MUL_48	: MUL_TWO_BITS port map (a(97 downto 96) => AIN(97 downto 96); 
                                 b(97 downto 96) => BIN(97 downto 96);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_47	: MUL_TWO_BITS port map (a(95 downto 94) => AIN(95 downto 94); 
                                 b(91 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_46	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_45	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_44	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_43	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_42	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_41	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);  
                                 
MUL_40	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_39	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_38	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_37	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_36	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_35	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_34	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_33	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);  
                                 
MUL_32	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_31	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_30	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_29	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_28	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_27	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_26	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_25	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);                                  
                          

MUL_24	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_23	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_22	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_21	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_20	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_19	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_18	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_17	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252); 
                                 
MUL_16	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_15	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_14	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_13	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_12	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_11	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_10	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_9	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);  
                                
MUL_8	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_7	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_6	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_5	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_4	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_3	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_2	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
MUL_1	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);  
                                 
MUL_0	: MUL_TWO_BITS port map (a(127 downto 126) => AIN(127 downto 126); 
                                 b(127 downto 126) => BIN(127 downto 126);
                                 z(255 downto 252) => ZOUT(255 downto 252);
                                 
                                  

	
	
END ARCHITECTURE Structural;
	
	                            
