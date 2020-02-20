@0
D = A
@SP
A = M
M = D
@SP
M = M + 1
@0
D = A
@LCL
M = M + D
@SP
M = M - 1
A = M
D = M
@LCL
A = M
M = D
@0
D = A
@LCL
M = M - D
(LOOP_START)
@0
D = A
@ARG
M = M + D
A = M
D = M
@SP
A = M
M = D
@SP
M = M + 1
@0
D = A
@ARG
M = M - D
@0
D = A
@LCL
M = M + D
A = M
D = M
@SP
A = M
M = D
@SP
M = M + 1
@0
D = A
@LCL
M = M - D
@SP
A=M
A=A-1
A=A-1
D=M
A=A+1
D=D+M
@SP
M=M-1
M=M-1
A=M
M=D
@SP
M=M+1
@0	
D = A
@LCL
M = M + D
@SP
M = M - 1
A = M
D = M
@LCL
A = M
M = D
@0	
D = A
@LCL
M = M - D
@0
D = A
@ARG
M = M + D
A = M
D = M
@SP
A = M
M = D
@SP
M = M + 1
@0
D = A
@ARG
M = M - D
@1
D = A
@SP
A = M
M = D
@SP
M = M + 1
@SP
A=M
A=A-1
A=A-1
D=M
A=A+1
D=D-M
@SP
M=M-1
M=M-1
A=M
M=D
@SP
M=M+1
@0
D = A
@ARG
M = M + D
@SP
M = M - 1
A = M
D = M
@ARG
A = M
M = D
@0
D = A
@ARG
M = M - D
@0
D = A
@ARG
M = M + D
A = M
D = M
@SP
A = M
M = D
@SP
M = M + 1
@0
D = A
@ARG
M = M - D
@SP
M = M - 1
A = M
D = M
@LOOP_START
D;JGT
@0
D = A
@LCL
M = M + D
A = M
D = M
@SP
A = M
M = D
@SP
M = M + 1
@0
D = A
@LCL
M = M - D
