#include "idl.h"
#include <stdio.h>
#include <math.h>  // Include for scientific calculations

double *calculate_1_svc(struct operands *ops, struct svc_req *rqstp) {
    static double result;  // Static to hold the result across RPC calls

    switch (ops->operator) {
        case '+':
            result = ops->op1 + ops->op2;
            break;
        case '-':
            result = ops->op1 - ops->op2;
            break;
        case '*':
            result = ops->op1 * ops->op2;
            break;
        case '/':
            if (ops->op2 != 0)
                result = ops->op1 / ops->op2;
            else
                result = 0;  // Handle division by zero
            break;
        case '^':
            result = pow(ops->op1, ops->op2);  // Power calculation
            break;
        default:
            result = 0;  // Invalid operator
            break;
    }
    return &result;
}
