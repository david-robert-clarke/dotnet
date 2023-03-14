library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

Entity RS232_ASM IS
Port (CT1Z, S, CLK, CLR : IN STD_LOGIC; CT1EN, UP, DECEN, LOAD, CDDEN, PTEN, S6, S5, S4, ODD, EVEN : OUT STD_LOGIC);
End Entity RS232_ASM;

Architecture Structural of RS232_ASM IS

Component AND2 IS
Port (a, b : IN std_logic; z : OUT std_logic);
END Component AND2;

Component AND2B1 IS
Port (a, b : IN std_logic; z : OUT std_logic);
END Component AND2B1;

Component AND3B1 IS
Port (a, b, c : IN std_logic; z : OUT std_logic);
END Component AND3B1;

Component AND3B2 IS
Port (a, b, c : IN std_logic; z : OUT std_logic);
END Component AND3B2;

Component AND4B2 IS
Port (a, b, c, d : IN std_logic; z : OUT std_logic);
END Component AND4B2;

Component AND4B3 IS
Port (a, b, c, d : IN std_logic; z : OUT std_logic);
END Component AND4B3;

Component OR2 IS
Port (a, b : IN std_logic; z : OUT std_logic);
End Component OR2;

Component OR5 IS
Port (a, b, c, d, e : IN std_logic; z : OUT std_logic);
End Component OR5;

Component OR6 IS
Port (a, b, c, d, e, f : IN std_logic; z : OUT std_logic);
End Component OR6;

Component FDC IS
Port (D, CLK, CLR : IN std_logic; Q : OUT std_logic);
End Component FDC;

Signal CT1Z, CDDEN, UP, LOAD, CT1EN, DECEN, PTEN : std_logic;
-- Signals input/output to/from the controller 
Signal S300, S600, S1200, S2400, S4800, S9600, S19200 : std_logic;
Signal CNT : std_logic_vector (15 downto 0);
-- signals input/output to/from count down timer decoder
Signal Q : std_logic_vector (11 downto 6);
-- signals input/output to/from baud rate decoder

Signal CS2, CS1, CS0, NS2, NS1, NS0 : std_logic;
Signal NS2_OR2_1 : std_logic; 
Signal NS1_OR5_1, NS1_OR5_2, NS1_OR5_3, NS1_OR5_4, NS1_OR5_5 : std_logic;
Signal NS0_OR6_1, NS0_OR6_2, NS0_OR6_3, NS0_OR6_4, NS0_OR6_5, NS0_OR6_6 : std_logic;

Begin

  NS2_AND2B1   : AND2B1 port map (a => CS1, b => CS0, z => NS2_OR2_1);
  NS2_OR2      : OR2    port map (a => CS2, b => NS2_OR2_1, z => NS2);
  -- Conectivity for NS2 combinational logic 
  FDC2         : FDC    port map (D => NS2, CLK => CLK, CLR => CLR, Q => CS2);
  -- The above combinational logic which produced NS2 is input to a latch to produce output CS2
    
  NS1_AND2B1   : AND2B1 port map (a => CS1, b => CT1Z, z => NS1_OR5_1); 
  NS1_AND3B1   : AND3B1 port map (a => CS1, b => CT1Z, c => CS2, z => NS1_OR5_2);
  NS1_AND2B1_2 : AND2B1 port map (a => CS1, b => CS0, z => NS1_OR5_3);
  NS1_AND4B3   : AND4B3 port map (a => CS0, b => CS2, c => CT1Z, d => S, z => NS1_OR5_4);
  NS1_AND4B2   : AND4B2 port map (a => CS0, b => CT1Z, c => CS2, d => S, z => NS1_OR5_5);  
  NS1_OR5      : OR5    port map (a => NS1_OR5_1, b => NS1_OR5_2, c => NS1_OR5_3, 
                                  d => NS1_OR5_4, e => NS1_OR5_5, z => NS1);
  -- Conectivity for NS1 combinational logic
  FDC1         : FDC    port map (D => NS1, CLK => CLK, CLR => CLR, Q => CS1);
  -- The above combinational logic which produced NS2 is input to a latch to produce output CS1  
  
  NS0_AND2     : AND2   port map (a => CS2, b => CS1, z => NS0_OR6_1);
  NS0_AND3B1   : AND3B1 port map (a => CS1, b => CS0, c => S, z => NS0_OR6_2);
  NS0_AND4B3   : AND4B3 port map (a => CS0, b => S, c => CT1Z, d => CS2, z => NS0_OR6_3);
  NS0_AND4B2   : AND4B2 port map (a => CT1Z, b => CS0, c => CS2, d => CS1, z => NS0_OR6_4);
  NS0_AND4B2_2 : AND4B2 port map (a => S, b => CT1Z, c => CS2, d => CS1, z => NS0_OR6_5);
  NS0_AND4B3_2 : AND4B3 port map (a => S, b => CT1Z, c => CS2, d => CS1, z => NS0_OR6_6);
  NS0_OR6      : OR6    port map (a => NS0_OR6_1, b => NS0_OR6_2, c => NS0_OR6_3, d => NS0_OR6_4,
                                  e => NS0_OR6_5, f => NS0_OR6_6, z => NS0);
  --Connectivity for NS0 combinational logic
  FDC0         : FDC    port map (D => NS0, CLK => CLK, CLR => CLR, Q => CS0);
  -- The above combinational logic which produced NS2 is input to a latch to produce output CS0 
  
  OUTPUT_AND2     : AND2   port map (a => CS1, b => CS0, z => CT1EN);
  OUTPUT_AND3B1   : AND3B1 port map (a => CS0, b => CS1, c => CS2, z => UP);
  OUTPUT_AND3B2   : AND3B2 port map (a => CS1, b => CS0, c => CS2, z => DECEN);
  OUTPUT_AND3B1_1 : AND3B1 port map (a => CS2, b => CS1, c => CS0, z => LOAD);
  OUTPUT_AND3B2_2 : AND3B2 port map (a => CS1, b => CS2, c => CS0, z => CDDEN);
  OUTPUT_AND3B1_2 : AND3B1 port map (a => CS2, b => CS0, c => CS1, z => PTEN);
  -- State output logic
   
     Decod : Process (DECEN, CLR) 
     Begin
  	  
  	  IF  CLR = '1' THEN
  	  	  S300 <= '0'; S600 <= '0'; S1200 <= '0'; S2400 <= '0'; S4800 <= '0'; S9600 <= '0'; S19200 <= '0';  
  	  ELSIF CLR = '0' AND DECEN = '1' THEN
  	  	  IF    Q(11) = '1' THEN 
	  	  	S300 <= '1';
		  ELSIF Q(11) = '0' AND Q(10) = '1' THEN 
		  	S600 <= '1';
		  ELSIF Q(11) = '0' AND Q(10) = '0' AND Q(9) = '1' THEN 
		  	S1200 <= '1';
		  ELSIF Q(11) = '0' AND Q(10) = '0' AND Q(9) = '0' AND Q(8) = '1' THEN 
		  	S2400 <= '1';
		  ELSIF Q(11) = '0' AND Q(10) = '0' AND Q(9) = '0' AND Q(8) = '0' AND Q(7) = '1' THEN 
		  	S4800 <= '1';
		  ELSIF Q(11) = '0' AND Q(10) = '0' AND Q(9) = '0' AND Q(8) = '0' AND Q(7) = '0' AND Q(6) = '1' THEN 
		  	S9600 <= '1';
		  ELSIF Q(11) = '0' AND Q(10) = '0' AND Q(9) = '0' AND Q(8) = '0' AND Q(7) = '0' AND Q(6) = '0' THEN 
		  	S19200 <= '1';
	          END IF;
	  END IF;
      End Process Decod; 
      -- Behavioural Model of the baud rate decoder 
      
      	Count : PROCESS (CDDEN, CLR, S19200, S9600, S4800, S2400, S1200, S600, S300)
		BEGIN
		IF CLR = '1' THEN
			CNT <= "0000000000000000";
		
		ELSIF CDDEN = '1' AND CLR = '0' THEN
			IF    S300   = '1' THEN CNT <= "0011101010011000";
			ELSIF S600   = '1' THEN CNT <= "0001110101001100";
			ELSIF S1200  = '1' THEN CNT <= "0000111010100110";
			ELSIF S2400  = '1' THEN CNT <= "0000011101010011";
			ELSIF S4800  = '1' THEN CNT <= "0000001110101001";
			ELSIF S9600  = '1' THEN CNT <= "0000000111010100";
			ELSIF S19200 = '1' THEN CNT <= "0000000011101010";
			END IF;
		END IF;
	END PROCESS Count;
	-- Behavioural Model of the count down timer time decoder
	
        Parity : Process (CLR, PTEN, S)
        Begin
        IF CLR = '1' THEN 
        EVEN <= '0'; ODD <= '0';
        ELSIF PTEN = '1' THEN
     	  IF S = '0' THEN
     	      ODD <= '1'; EVEN <= '0';
     	  ELSIF S = '1' THEN
     	      EVEN <= '1'; ODD <= '0';
     	  END IF;
       END IF;
       END Process Parity;
       -- Behavioural model of the parity tester
       
       LED : Process (CLR, S300, S600, S1200, S2400, S4800, S9600, S19200)
		
       Begin
		IF CLR = '1' THEN
		S6 <= '0'; S5 <= '0'; S4 <= '0';  
		ELSIF CLR = '0' THEN
			IF S300 ='1' THEN
			S6 <= '0'; S5 <= '0'; S4 <= '1'; 
			ELSIF S600 = '1' THEN
			S6 <= '0'; S5 <= '1'; S4 <= '0'; 
			ELSIF S1200 = '1' THEN
			S6 <= '0'; S5 <= '1'; S4 <= '1'; 
			ELSIF S2400 = '1' THEN
			S6 <= '1'; S5 <= '0'; S4 <= '0'; 
			ELSIF S4800 = '1' THEN
			S6 <= '1'; S5 <= '0'; S4 <= '1'; 
			ELSIF S9600 = '1' THEN
			S6 <= '1'; S5 <= '1'; S4 <= '0'; 
			ELSIF S19200 = '1' THEN
			S6 <= '1'; S5 <= '1'; S4 <= '1'; 
			END IF;
		END IF;
       END Process LED;
       -- Behavioural model of the decoder which outputs signals to the LED
	
       
	
	
END Architecture Structural;




















 
