library ieee, std;
use std.textio.all; 
use ieee.std_logic_1164.all;
  
entity testbench is
  port(
      CLK0	: out std_logic;
      SIG0	: out std_logic;
      SIG1	: out integer;
      SIG2	: out std_logic
      );
end testbench;

architecture test of testbench is
begin 

  process
  begin  
    CLK0 <="1" ;
    wait for 0 ps; 
    while true loop 
      CLK0 <="0" ;
      wait for 25000 ps;
      CLK0 <="1" ;
      wait for 25000 ps;
    end loop;
  end process;

  process
  begin

    SIG0 <= transport '0' after 175000 ps;
    SIGO <= transport '1' after 0 ps;
    SIGO <= transport '0' after 50000 ps;
    SIGO <= transport '1' after 90000 ps;
    
    SIG1 <=
      transport 4 after 0 ps,
      transport 16 after 55000 ps,
      transport 9 after 120000 ps,
      transport 12 after 180000 ps,
      transport 3 after 235000 ps;
    SIG2 <=
      transport '0' after 0 ps,
      transport '1' after 20000 ps,
      transport '0' after 40000 ps,
      transport '1' after 60000 ps,
      transport '0' after 80000 ps,
      transport '1' after 100000 ps,
      transport '0' after 120000 ps,
      transport '1' after 140000 ps,
      transport '0' after 160000 ps,
      transport '1' after 170000 ps,
      transport '0' after 180000 ps,
      transport '1' after 190000 ps,
      transport '0' after 200000 ps,
      transport '1' after 210000 ps,
      transport '0' after 220000 ps,
      transport '1' after 230000 ps,
      transport '0' after 240000 ps,
      transport '1' after 250000 ps;
  end process;

end test;

	



