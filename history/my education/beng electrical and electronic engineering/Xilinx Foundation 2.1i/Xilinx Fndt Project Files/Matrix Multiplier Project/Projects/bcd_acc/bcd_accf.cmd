delete_signals
clpr bcd_acc.out
restart
set_mode FUNCTIONAL

vector IH IH[3:0]
vector IL IL[3:0]
vector Q3 Q3[3:0]
vector Q2 Q2[3:0]
vector Q1 Q1[3:0]
vector Q0 Q0[3:0]
watch  IH IL Q33 Q23 Q13 Q03 CLK CLR

vector sigs IH IL Q3 Q2 Q1 Q0 CLK CLR

break sigs ? do (print > bcd_acc.out)

wfm IH @0ns=9\D
wfm IL @0ns=9\D
wfm CLR @0ns=0 +
        @5.3us=1 +
        @5.4us=0
    


clock CLK 0 1
stepsize 25ns
sim 6us
save_ascii bcd_acc1
save_ascii funct

