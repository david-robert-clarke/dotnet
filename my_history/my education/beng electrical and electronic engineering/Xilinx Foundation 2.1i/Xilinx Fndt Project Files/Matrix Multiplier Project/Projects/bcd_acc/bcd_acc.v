module ACC(CLK, CLR, A, Ci, Q, Co);
input CLK,CLR,Ci;
input [3:0] A;
output Co;
output [3:0] Q;
wire Co;
wire [3:0] S;

CD4560 SUM(A,Q,Ci,S,Co);
CD4076 PREG(S,Q,CLK,CLR);
endmodule


module bcd_acc (CLK, CLR, IL, IH, Q0, Q1, Q2, Q3) ;

input CLK ;
input CLR ;
input [3:0] IL ;
input [3:0] IH ;
output [3:0] Q0;
output [3:0] Q1;
output [3:0] Q2;
output [3:0] Q3;
wire C1,C2,C3;

ACC ACC0(CLK, CLR, IL, 1'b0, Q0, C1);
ACC ACC1(CLK, CLR, IH, C1, Q1, C2);
CD4518 CNT2(CLK, CLR, Q2, C3, C2);
CD4518 CNT3(CLK, CLR, Q3, , C3);

endmodule 
