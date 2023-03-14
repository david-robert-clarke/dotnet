Entity Decoder is
Port (DECEN, RESET, B11, B10, B9, B8, B7, B6 : IN BIT; 
      S300, S600, S1200, S2400, S4800, S9600, S19200 : OUT BIT);
End Entity Decoder;

Architecture Decoder_Arch of Decoder is
Begin
     Decod : Process (DECEN, RESET, B11, B10, B9, B8, B7, B6)
     Begin
     	   IF RESET = '1' THEN
     	      S300 <= '0'; S600 <= '0'; S1200 <= '0'; S2400 <= '0'; 
     	      S4800 <= '0'; S9600 <= '0'; S19200 <= '0';
     	   
     	   ELSIF RESET = '0' AND DECEN = '1' THEN
     	       IF B11 = '1' THEN
     	           S300 <= '1';
     	       ELSIF B11 = '0' AND B10 = '1' THEN
     	           S600 <= '1';
     	       ELSIF B11 = '0' AND B10 = '0' AND B9 = '1' THEN
     	           S1200 <= '1';
     	       ELSIF B11 = '0' AND B10 = '0' AND B9 = '0' AND B8 = '1' THEN
     	           S2400 <= '1';
     	       ELSIF B11 = '0' AND B10 = '0' AND B9 = '0' AND B8 = '0' AND 
     	       B7 = '1' THEN
     	           S4800 <= '1';
     	       ELSIF B11 = '0' AND B10 = '0' AND B9 = '0' AND B8 = '0' AND 
     	       B7 = '0' AND B6 = '1' THEN
     	           S9600 <= '1';
     	       ELSIF B11 = '0' AND B10 = '0' AND B9 = '0' AND B8 = '0' AND 
     	       B7 = '0' AND B6 = '0' THEN
     	           S19200 <= '1';
     	       END IF;
     	   END IF;
     End Process Decod;
END Architecture Decoder_Arch;
