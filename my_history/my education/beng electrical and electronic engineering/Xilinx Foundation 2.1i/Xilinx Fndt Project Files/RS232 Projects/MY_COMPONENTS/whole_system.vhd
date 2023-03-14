-- Created by David Clarke for the RS232 assignment
Library IEEE;
USE IEEE.std_logic_1164.all;

Entity Whole_system IS
Port (S, CLR, CLK : IN STD_LOGIC; EVEN, ODD, S6, S5, S4, S3, S2, S1, S0 : OUT STD_LOGIC);
End Entity Whole_system;
--
Architecture Structural of Whole_system IS
-- Component declaration area
Component Decoder IS
PORT (DECEN, CLR : IN STD_LOGIC; Q11, Q10, Q9, Q8, Q7, Q6 : IN STD_LOGIC;
	S300, S600, S1200, S2400, S4800, S9600, S19200 : OUT STD_LOGIC);
END Component Decoder;

Component CDDECODE IS
PORT (CDDEN, CLR, S19200, S9600, S4800, S2400, S1200, S600, S300 : IN STD_LOGIC; CNT : OUT STD_LOGIC_VECTOR (15 downto 0));
END Component CDDECODE;

Component Parity_Test IS
PORT (CLR, PTEN, S : IN STD_LOGIC; EVEN, ODD : OUT STD_LOGIC);
END Component Parity_Test;

Component Pinoutdecode IS
Port (CLR, S300, S600, S1200, S2400, S4800, S9600, S19200 : IN STD_LOGIC;
      S6, S5, S4, S3, S2, S1, S0 : OUT STD_LOGIC);
End Component Pinoutdecode;

Component cb16cled IS 
port (D : in STD_LOGIC_VECTOR (15 downto 0); Q : out STD_LOGIC_VECTOR (15 downto 0);
      C, CE, CLR, L, UP : in STD_LOGIC; CEO, TC : out STD_LOGIC);
End Component CB16CLED;

Component RS232_ASM IS
port (CT1Z, S, CLR, CLK : IN STD_LOGIC; CDDEN, UP, LOAD, CT1EN, DECEN, PTEN : OUT STD_LOGIC);
End Component RS232_ASM;

Signal S300, S600, S1200, S2400, S4800, S9600, S19200, CT1Z, CDDEN, UP, LOAD, CT1EN, DECEN, PTEN : STD_LOGIC;
Signal Q : STD_LOGIC_VECTOR (11 downto 6);
Signal CNT : STD_LOGIC_VECTOR (15 downto 0); 
 
Begin
  -- Component instantiation region
  
  PT : Parity_Test port map (PTEN => Pten, S => S, CLR => Clr, EVEN => Even, ODD => Odd);
  -- The parity tester is now physically connected to the Controller
  
  TIME_ENCODER : CDDECODE port map (S300 => s300, S600 => s600, S1200 => s1200, S2400 => s2400, S4800 => s4800,
  				    S9600 => s9600, S19200 => s19200, CDDEN => CDDEN, CLR => CLR, 
  				    CNT(15 downto 0) => CNT (15 downto 0));
  -- The decoder before the counter is completely connected to the other components 
  				    
  CB16CLED_DC : CB16CLED port map (UP => up, L => Load, CE => CT1EN, C => CLK, CLR => CLR, CEO => CT1Z,
  				   D(15 downto 0) => CNT(15 downto 0), Q(11 downto 6) => Q(11 downto 6));
  -- The counter is now connected to the controller
  
  BAUDRATE_DECODE : Decoder port map (Q11 => Q(11), Q10 => Q(10), Q9 => Q(9), Q8 => Q(8), Q7 => Q(7), Q6 => Q(6),
  				      DECEN => DECEN, CLR => CLR, S300 => s300, S600 => s600, S1200 => s1200, 
  				      S2400 => s2400, S4800 => s4800, S9600 => s9600, S19200 => s19200);
  -- The baud rate decoder is now physically connected
  
  LED_DISPLAY : Pinoutdecode port map (S300 => s300, S600 => s600, S1200 => s1200, S2400 => s2400, S4800 => s4800,
  				      S9600 => s9600, S19200 => s19200, S6 => s6, S5 => s5, S4 => s4, S3 => s3, 
  				      S2 => s2, S1 => s1, S0 => s0, CLR => Clr);
  -- The LED display is now physically connected to the system
  
  THE_BEAST : RS232_ASM port map (CT1Z => CT1Z, S => S, CLR => CLR, CLK => CLK, CDDEN => CDDEN, UP => UP, LOAD => Load, 
                                  CT1EN => CT1en, DECEN => DECEN, PTEN => PTEN);
  
End Architecture Structural;

  				   
  				   
  				   
  				   
  				   
  				   
  				   
  				   
  				   
  				   
  				   
  				   
  				   
  				   
  				   
  				   
  				   
  				   
  				   
  				   
  				   
  				   
  				   
