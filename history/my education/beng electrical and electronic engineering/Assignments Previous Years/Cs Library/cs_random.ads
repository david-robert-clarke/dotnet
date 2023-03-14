PACKAGE CS_Random IS
-- Pseudo-random number generator package

   MaxRange : CONSTANT Integer := 2**24 - 1;

   SUBTYPE IntRange IS Integer RANGE 1 .. MaxRange;

   PROCEDURE GetNextRandom(Number : OUT Integer;
                           MaxRand : IN IntRange := MaxRange);
   -- Produces a random integer in the range 0 .. MaxRand
   -- Largest value of MaxRand allowed is 2**24 - 1 (about 16 million)
   -- Smallest value of MaxRand allowed is 1

   PROCEDURE GetNextRandom(Number : OUT Float);
   -- Produces a random real value between 0 and 1

END CS_Random;
