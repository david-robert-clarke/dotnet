-- USE_GSR.VHD Example
-- The signal RESET is connected to the 
-- GSRIN pin of the STARTBUF block
-- May 1997

library IEEE;
library UNISIM;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_unsigned.all;
use UNISIM.all;

entity use_gsr is
port ( CLOCK: in STD_LOGIC;
       RESET: in STD_LOGIC;
       UPCNT: out STD_LOGIC_VECTOR (3 downto 0);
       DNCNT: out STD_LOGIC_VECTOR (3 downto 0));
end use_gsr;

architecture XILINX of use_gsr is

component STARTBUF 
    port (GSRIN: in STD_LOGIC);
          GSROUT: out STD_LOGIC);
end component;

signal RESET_INT: STD_LOGIC;
signal UP_CNT: STD_LOGIC_VECTOR (3 downto 0);
signal DN_CNT: STD_LOGIC_VECTOR (3 downto 0);

begin

    U1: STARTBUF port map(GSRIN=>RESET,
                          GSROUT=>RESET_INT);

    UP_COUNTER: process(CLOCK, RESET_INT)
    begin
        if (RESET_INT = '1') then
            UP_CNT <= "0000";
        elsif CLOCK'event and CLOCK = '1') then
            UP_CNT <= UP_CNT - 1;
        end if;
    end process;

    DN_COUNTER: (CLOCK, RESET_INT) 
    begin
        if (RESET_INT = '1') then
            DN_CNT <= "1111";
        elsif CLOCK'event and CLOCK = '1') then
            DN_CNT <= DN_CNT - 1;
        end if;
    end process;

    UPCNT <= UP_CNT;
    DNCNT <= DN_CNT;

end XILINX;
