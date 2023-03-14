Entity Pinoutdecode IS
Port (RESET, S300, S600, S1200, S2400, S4800, S9600, S19200 : IN bit;
      S6, S5, S4 : OUT bit);
End Entity Pinoutdecode;
--
Architecture Arch OF Pinoutdecode IS
Begin

	Process (RESET, S300, S600, S1200, S2400, S4800, S9600, S19200)
		
	Begin
		IF RESET = '1' THEN
		S6 <= '0'; S5 <= '0'; S4 <= '0';  
		ELSIF RESET = '0' THEN
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
	END Process;
END Architecture Arch;

		
			
