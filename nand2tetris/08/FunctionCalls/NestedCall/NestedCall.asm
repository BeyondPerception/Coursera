@Sys.init
0;JMP
(Sys.init)
@4000	//
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
@THIS
M = D
@5000
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
@THAT
M = D
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
@Sys.main
0;JMP
(RETURN_LABEL0)
@SP
M = M - 1
A = M
D = M
@6
M = D
(LOOP)
@LOOP
0;JMP
(Sys.main)
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
@SP
A = M
M = D
@SP
M = M + 1
@4001
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
@THIS
M = D
@5001
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
@THAT
M = D
@200
D = A
@SP
A = M
M = D
@SP
M = M + 1
@1
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
@1
D = A
@LCL
M = M - D
@40
D = A
@SP
A = M
M = D
@SP
M = M + 1
@2
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
@2
D = A
@LCL
M = M - D
@6
D = A
@SP
A = M
M = D
@SP
M = M + 1
@3
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
@3
D = A
@LCL
M = M - D
@123
D = A
@SP
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
@Sys.add12
0;JMP
(RETURN_LABEL1)
@SP
M = M - 1
A = M
D = M
@5
M = D
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
@2
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
@2
D = A
@LCL
M = M - D
@3
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
@3
D = A
@LCL
M = M - D
@4
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
@4
D = A
@LCL
M = M - D
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
(Sys.add12)
@4002
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
@THIS
M = D
@5002
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
@12
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
