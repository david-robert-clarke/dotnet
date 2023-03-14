--------------------------------------------------------------------------
-- The following is an implementation of a "universal" random number    --
-- generator algorithm developed by Dr. George Marsaglia of the         --
-- Supercomputer Computations Research Institute (SCRI) at Florida      --
-- State University.  This generator has a period of ~2**144 and has    --
-- been tailored for reproducibility in all CPU's with at least         --
-- 16 bit integer arithmetic and 24 bit floating point.  This algorithm --
-- does not generate random numbers < 2**-24.  At the end of this file  --
-- you will find a self test program that checks generated results      --
-- against known expected results and reports any inaccuracies.         --
--                                                                      --
-- Further references: "Toward a Universal Random Number Generator",    --
-- appearing in the Journal of The American Statistical Association.    --
--                                                                      --
-- This code appeared in the March/April publication of SIGAda's        --
-- Ada Letters and is considered public domain.  PCK                    --
--------------------------------------------------------------------------

package U_Rand is
    M1 : constant := 179 ;
    M2 : constant := M1 - 10 ;

    subtype SEED_RANGE_1 is integer range 1..M1-1 ;
    subtype SEED_RANGE_2 is integer range 1..M2-1 ;

    Default_I : constant SEED_RANGE_1 := 12 ;
    Default_J : constant SEED_RANGE_1 := 34 ;
    Default_K : constant SEED_RANGE_1 := 56 ;
    Default_L : constant SEED_RANGE_1 := 78 ;

    procedure Start(New_I : SEED_RANGE_1 := Default_I ;
                    New_J : SEED_RANGE_1 := Default_J ;
                    New_K : SEED_RANGE_1 := Default_K ;
                    New_L : SEED_RANGE_2 := Default_L) ;

    function Next return FLOAT ;
end U_Rand ;
