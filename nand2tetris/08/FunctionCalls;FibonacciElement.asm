@256
D=A
@SP
M=D

@RETURN_LABEL0
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@0
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Sys.init
0;JMP
(RETURN_LABEL0)
(Main.fibonacci)
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
M = M - 1
A = M
D = M
A = A - 1
D = D - M
@LT0
D;JGT
@0
D = A
@SP
A = M - 1
M = D
@SKIPLT0
0;JMP
(LT0)
@1
D = A
@SP
A = M - 1
M =  - D
(SKIPLT0)
@SP
M = M - 1
A = M
D = M
@IF_TRUE
D;JNE
@IF_FALSE
0;JMP
(IF_TRUE)
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
@LCL
D = M
@R11
M = D
@5
A = D - A
D = M
@R12
M = D
@ARG
D = M
@0
D = D + A
@R13
M = D
@SP
AM = M - 1
D = M
@R13
A = M
M = D
@ARG
D = M
@SP
M = D + 1
@R11
D = M - 1
AM = D
D = M
@THAT
M = D
@R11
D = M - 1
AM = D
D = M
@THIS
M = D
@R11
D = M - 1
AM = D
D = M
@ARG
M = D
@R11
D = M - 1
AM = D
D = M
@LCL
M = D
@R12
A = M
0;JMP
(IF_FALSE)
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
A = M
A = A - 1
A = A - 1
D = M
A = A + 1
D = D - M
@SP
M = M - 1
M = M - 1
A = M
M = D
@SP
M = M + 1
@RETURN_LABEL1
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@1
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Main.fibonacci
0;JMP
(RETURN_LABEL1)
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
A = M
A = A - 1
A = A - 1
D = M
A = A + 1
D = D - M
@SP
M = M - 1
M = M - 1
A = M
M = D
@SP
M = M + 1
@RETURN_LABEL2
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@1
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Main.fibonacci
0;JMP
(RETURN_LABEL2)
@SP
A = M
A = A - 1
A = A - 1
D = M
A = A + 1
D = D + M
@SP
M = M - 1
M = M - 1
A = M
M = D
@SP
M = M + 1
@LCL
D = M
@R11
M = D
@5
A = D - A
D = M
@R12
M = D
@ARG
D = M
@0
D = D + A
@R13
M = D
@SP
AM = M - 1
D = M
@R13
A = M
M = D
@ARG
D = M
@SP
M = D + 1
@R11
D = M - 1
AM = D
D = M
@THAT
M = D
@R11
D = M - 1
AM = D
D = M
@THIS
M = D
@R11
D = M - 1
AM = D
D = M
@ARG
M = D
@R11
D = M - 1
AM = D
D = M
@LCL
M = D
@R12
A = M
0;JMP
(Sys.init)
@4
D = A
@SP
A = M
M = D
@SP
M = M + 1
@RETURN_LABEL3
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@1
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Main.fibonacci
0;JMP
(RETURN_LABEL3)
(WHILE)
@WHILE
0;JMP