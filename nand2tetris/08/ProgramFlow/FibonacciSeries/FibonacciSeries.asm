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
M = M - 1
A = M
D = M
@THAT
M = D
@0
D = A
@SP
A = M
M = D
@SP
M = M + 1
@0
D = A
@THAT
M = M + D
@SP
M = M - 1
A = M
D = M
@THAT
A = M
M = D
@0
D = A
@THAT
M = M - D
@1
D = A
@SP
A = M
M = D
@SP
M = M + 1
@1
D = A
@THAT
M = M + D
@SP
M = M - 1
A = M
D = M
@THAT
A = M
M = D
@1
D = A
@THAT
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
@2
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
(MAIN_LOOP_START)
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
@COMPUTE_ELEMENT
D;JGT
@END_PROGRAM
0;JMP
(COMPUTE_ELEMENT)
@0
D = A
@THAT
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
@THAT
M = M - D
@1
D = A
@THAT
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
@THAT
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
@2
D = A
@THAT
M = M + D
@SP
M = M - 1
A = M
D = M
@THAT
A = M
M = D
@2
D = A
@THAT
M = M - D
@THAT
D = M
@SP
A = M
M = D
@SP
M = M + 1
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
D=D+M
@SP
M=M-1
M=M-1
A=M
M=D
@SP
M=M+1
@SP
M = M - 1
A = M
D = M
@THAT
M = D
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
@MAIN_LOOP_START
0;JMP
(END_PROGRAM)
