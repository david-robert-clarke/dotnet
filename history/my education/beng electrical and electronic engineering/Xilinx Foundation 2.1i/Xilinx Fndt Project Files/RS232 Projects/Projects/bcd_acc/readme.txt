BCD_ACC is a simple Verilog project of 4 digits BCD accumulator

DESIGN TYPE:
        Foundation Series v2.1i Chip (SpartanXL - S05XLPC84 - speed 4)
CONTROLS (Inputs):
	CLK	- external clock input,	
	CLR	- synchronous clear
	IL	- LSD accumulator input
	IH	- MSD accumulator input
OUTPUTS:
	Q0	- LSD accumulator output
	Q1
	Q2
	Q3	- MSD accumulator output

DESCRIPTION:
The proejct consists of 2 BCD adders and two stage BCD synchronous counter. 
The synchronous counter allows to expands accumulator capacity up to 4 digits

TIMINGS:
	BCD_ACCF.TVE - Functional simulation test vector file
	BCD_ACCF.TVE - Timing simulation test vector file

SCRIPT FILES:

	BCD_ACCF.CMD - Functional simulation script file	
	BCD_ACCT.CMD - Timing simulation script file

