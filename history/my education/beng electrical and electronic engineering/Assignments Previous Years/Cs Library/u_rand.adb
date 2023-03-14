
package body U_Rand is
    M3     : constant := 97 ;
    Init_C : constant := 362436.0/16777216.0 ;
    CD     : constant := 7654321.0/16777216.0 ;
    CM     : constant := 16777213.0/16777216.0 ;

    subtype RANGE_1 is INTEGER range 0..M1-1 ;
    subtype RANGE_2 is INTEGER range 0..M2-1 ;
    subtype RANGE_3 is INTEGER range 1..M3 ;

    I, J, K : RANGE_1 ;
    NI, NJ : INTEGER ;
    L : RANGE_2 ;
    C : FLOAT ;
    U : array(RANGE_3) of FLOAT ;

    procedure Start(New_I : SEED_RANGE_1 := Default_I ;
                    New_J : SEED_RANGE_1 := Default_J ;
                    New_K : SEED_RANGE_1 := Default_K ;
                    New_L : SEED_RANGE_2 := Default_L) is
        S, T : FLOAT ;
        M : RANGE_1 ;
    begin
        I := New_I ; J := New_J ; K := New_K ; L := New_L ;
        NI := RANGE_3'last ;
        NJ := (RANGE_3'last/3) + 1 ;
        C := Init_C ;

        for II in RANGE_3 loop 
            S := 0.0 ; T := 0.5 ;
            for JJ in 1..24 loop 
                M := (((J * I) mod M1) * K) mod M1 ;
                I := J ; J := K ; K := M ;
                L := (53 * L + 1) mod M2 ;
                if ((L * M) mod 64) >= 32 then
                    S := S + T ;
                end if ;
                T := 0.5 * T ;
            end loop ;
            U(II) := S ;
        end loop ;
    end Start ;

    function Next return FLOAT is
        Temp : FLOAT ;
    begin
        Temp := U(NI) - U(NJ) ;
        if Temp < 0.0 then
            Temp := Temp + 1.0 ;
        end if ;
        U(NI) := Temp ;
        NI := NI - 1 ;
        if NI = 0 then
            NI := RANGE_3'last ;
        end if ;
        NJ := NJ - 1 ;
        if NJ = 0 then
            NJ := RANGE_3'last ;
        end if ;
        C := C - CD ;
        if C < 0.0 then
            C := C + CM ;
        end if ;
        Temp := Temp - C ;
        if Temp < 0.0 then
            Temp := Temp + 1.0 ;
        end if ;
        return Temp ;
    end Next ;

begin
    Start ; -- initialize table U
end U_Rand ;
