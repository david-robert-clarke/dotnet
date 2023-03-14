package test is
   function OPERATE (A, B, OPERATION: BIT) return BIT;
end test;


package body test is


function OPERATE(A, B, OPERATION: BIT) return BIT is
begin
  if (OPERATION = '1') then
    return (A and B);
  else
    return (A or B);
  end if;
end OPERATE;
end test;


