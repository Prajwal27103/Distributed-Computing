/* idl.x */
struct operands {
    double op1;
    double op2;
    char operator;
};

program CALCULATOR_PROG {
    version CALCULATOR_VERS {
        double CALCULATE(operands) = 1;
    } = 1;
} = 0x23451111;
