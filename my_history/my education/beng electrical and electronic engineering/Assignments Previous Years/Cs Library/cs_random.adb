WITH U_Rand;

PACKAGE BODY CS_Random IS

   PROCEDURE GetNextRandom(Number : OUT Integer;
                           MaxRand : IN IntRange := MaxRange) IS
   BEGIN
      Number := Integer(U_Rand.Next * Float(MaxRand));
   END GetNextRandom;

   PROCEDURE GetNextRandom(Number : OUT Float) IS
   BEGIN
      Number := U_Rand.Next;
   END GetNextRandom;

END CS_Random;



