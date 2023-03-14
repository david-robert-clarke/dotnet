-- FINAL YEAR PROJECT
-- BY DAVID CLARKE
-- CREATED: 17_12_2000
USE WORK.MATRIX_PACKAGE.ALL

ENTITY ELEMENTS_STORE IS
PORT (EN_A, EN B : IN FOUR_BITS;
      A, B : OUT FOUR_BITS);
END ENTITY ELEMENTS_STORE;
--
ARCHITECTURE STRUCTURAL OF ELEMENTS_STORE IS
-- COMPONENT DECLARATION REGION

entity MEM_EL_B3 is
     port (ADDR: in ONE_BIT;
           DATA: out U_TWO_BITS);
end MEM_EL_B3;

entity MEM_EL_B2 is
     port (ADDR: in ONE_BIT;
           DATA: out U_TWO_BITS);
end MEM_EL_B2;

entity MEM_EL_B1 is
     port (ADDR: in ONE_BIT;
           DATA: out U_TWO_BITS);
end MEM_EL_B1;

entity MEM_EL_B0 is
     port (ADDR: in ONE_BIT;
           DATA: out U_TWO_BITS);
end MEM_EL_B0;

entity MEM_EL_A3 is
     port (ADDR: in ONE_BIT;
           DATA: out U_TWO_BITS);
end MEM_EL_A3;

entity MEM_EL_A2 is
     port (ADDR: in ONE_BIT;
           DATA: out U_TWO_BITS);
end MEM_EL_A2;

entity MEM_EL_A1 is
     port (ADDR: in ONE_BIT;
           DATA: out U_TWO_BITS);
end MEM_EL_A1;

entity MEM_EL_A0 is
     port (ADDR: in ONE_BIT;
           DATA: out U_TWO_BITS);
end MEM_EL_A0;

BEGIN

      
