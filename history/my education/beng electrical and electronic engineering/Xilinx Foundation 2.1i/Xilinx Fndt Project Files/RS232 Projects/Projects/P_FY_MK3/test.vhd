library IEEE;
USE IEEE.STD_LOGIC_1164.all;

package test is
   function OPERATE (A, B, OPERATION: BIT) return BIT;
end package test;

package body test is

function OPERATE(A, B, OPERATION: BIT) return BIT is
begin
  if (OPERATION = '1') then
    return (A and B);
  else
    return (A or B);
  end if;
end function OPERATE;

end package body test;


