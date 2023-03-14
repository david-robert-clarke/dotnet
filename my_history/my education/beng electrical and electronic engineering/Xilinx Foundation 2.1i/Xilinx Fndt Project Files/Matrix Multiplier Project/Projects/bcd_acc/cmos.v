module CD4076 (D, Q, CLK, CLR) ;

input [3:0] D ;
output [3:0] Q ;
input CLK ;
input CLR ;
//input EN ;
reg [3:0] Q;

always @ (posedge CLK)
begin
  if(CLR==1'b1) Q=4'b0000;    
  else Q=D;      
end
endmodule 



module CD4518 (CLK, CLR, Q, CO, CE) ;
input CLK ;
input CLR ;
output [3:0] Q ;
output CO ;
input CE ;
wire CO;
reg [3:0]Q;

always @(posedge CLK)
begin
  if(CLR)
    Q=4'b0000;
  else
    if(CE) 
      begin     
        if(Q<4'd9) Q=Q+1'b1;
        else Q=4'b0000;
      end  
end

assign
  CO = Q[3] & ~Q[2] & ~Q[1] & Q[0] & CE;
  
endmodule 

module CD4560 (A, B, C0, S, C4) ;

input [3:0] A;
input [3:0] B;
input C0;
//half sum and carry
wire [3:0] HS;
wire HC;
output [3:0] S;
output C4;

// add your declarations here
assign {HC,HS}=A+B+C0;
assign S=(((HS>4'b1001)||(HC==1'b1))? HS+4'd6 : HS);
assign C4=HS[3] & HS[1] | HS[3] & HS[2] | HC;
//(((HS>4'b1001)||(HC==0'b1))? HS+4'd6 : HS);
endmodule 



