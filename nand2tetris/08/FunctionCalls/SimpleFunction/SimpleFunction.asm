(SimpleFunction.test)
@0
D = A
@SP
A = M
M = D
@SP
M = M + 1
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
@1
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
@1
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
@SP
A = M
A = A - 1
M = !M
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
@1
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
@1
D = A
@ARG
M = M - D
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
@LCL
D=M
@R11
M=D
@5
A=D-A
D=M
@R12
M=D
@ARG
D=M
@0
D=D+A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D
@ARG
D=M
@SP
M=D+1
@R11
D=M-1
AM=D
D=M
@THAT
M=D
@R11
D=M-1
AM=D
D=M
@THIS
M=D
@R11
D=M-1
AM=D
D=M
@ARG
M=D
@R11
D=M-1
AM=D
D=M
@LCL
M=D
@R12
A=M
0;JMP
