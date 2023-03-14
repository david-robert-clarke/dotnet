library IEEE;
use IEEE.std_logic_1164.all;
use WORK.test.all;


entity example5_20 is
   port(
      signal A, B, OPERATION: in BIT;
      signal RETURNED_VALUE: out BIT
      );
end example5_20;


architecture behave of example5_20 is


begin

RETURNED_VALUE <= OPERATE(A, B, OPERATION);

end behave;

