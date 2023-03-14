library ieee;
use ieee.std_logic_1164.all;

entity structural_rs232 is
port (RS232IN, reset, clk, clr : in std_logic; S6, S5, S4, EVEN, ODD : out std_logic);
end entity structural_rs232;

architecture structural of structural_rs232 is    -- component declaration region

component inv is
port (I : in std_logic; O : out std_logic);
end component inv;

component rs232_asm_cb_pt2 is
port (ct1z, s, clr, clk : in std_logic; cdden, up, load, ct1en, decen, 
      pten : out std_logic);
end component rs232_asm_cb_pt2;

component rs232_baudrate_decode is
port (b11, b10, b9, b8, b7, b6, decen, reset : in std_logic; s300, s600, 
      s1200, s2400, s4800, s9600, s19200 : out std_logic);
end component rs232_baudrate_decode;

component rs232_led_decode is
port (s300, s600, s1200, s2400, s4800, s9600, s19200, reset : in std_logic;
      s6, s5, s4 : out std_logic);
end component rs232_led_decode;

component rs232_parity_tester is
port (pten, s, reset : in std_logic; EVEN, ODD : out std_logic);
end component rs232_parity_tester;

component rs232_precntdwntmr_decode is
port (s300, s600, s1200, s2400, s4800, s9600, s19200, cdden, reset : in std_logic; 
      cnt : out std_logic_vector (15 downto 0)); 
end component rs232_precntdwntmr_decode;

component cb16cled is
port (d : in std_logic_vector (15 downto 0); up, l, ce, c, clr : in std_logic;
      ce0 : out std_logic; q : out std_logic_vector (15 downto 0));
end component cb16cled;

signal s1, s2, s3, s40, s50, s60, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16: std_logic;
signal s0, s17 : std_logic_vector (15 downto 0);

begin      -- component instantiation statements

	A: inv port map (I => RS232IN, O => S1);
	
	B: rs232_asm_cb_pt2 port map (clr => clr, clk => clk, ct1z => s16, s => s1, cdden => s10, 
				up => s11, load => s12, ct1en => s13, decen => s14, pten => s15);
				      
	C: rs232_baudrate_decode port map (reset => clr, decen => s14, b11 => s17(11), b10 => s17(10), 
	               b9 => s17(9), b8 => s17(8), b7 => s17(7), b6 => s17(6), s300 => S2, s600 => s3, 
                                 s1200 => s40, s2400 => s50, s4800 => s60, s9600 => s7, s19200 => s8); 
                              
        D: rs232_led_decode port map (reset => clr, s300 => s2, s600 => s3, s1200 => s40, s2400 => s50, 
        			    s4800 => s60, s9600 => s7, s19200 => s8, s6 => s6, s5 => s5, s4 => s4); 
        			    
        E: rs232_parity_tester port map (pten => s15, s => s1, reset => clr, EVEN => EVEN, ODD => ODD); 
        
        F: rs232_precntdwntmr_decode port map (cdden => s10, reset => clr, s300 => S2, s600 => s3, s1200 => s40, 
                                               s2400 => s50, s4800 => s60, s9600 => s7, s19200 => s8, cnt => s0);
        				      
        G: cb16cled port map (d => s0, up => s11, l => s12, ce => s13, c => clk, clr => clr, ce0 => s16,  
                              q => s17);  
                              
end architecture structural;
	


























