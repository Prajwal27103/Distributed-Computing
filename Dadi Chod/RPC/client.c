#include "idl.h"
#include <stdio.h>
#include <stdlib.h>  // For atof

int main(int argc, char *argv[]) {
    CLIENT *clnt;
    double *result;
    struct operands ops;

    if (argc != 5) {
        printf("Usage: %s <hostname> <operand1> <operand2> <operator>\n", argv[0]);
        exit(1);
    }

    // Get inputs from the command line
    ops.op1 = atof(argv[2]);
    ops.op2 = atof(argv[3]);
    ops.operator = argv[4][0];  // Use the first character of the operator argument

    // Create a client handle for communication with the server
    clnt = clnt_create(argv[1], CALCULATOR_PROG, CALCULATOR_VERS, "udp");
    if (clnt == NULL) {
        clnt_pcreateerror(argv[1]);
        exit(1);
    }

    // Call the remote procedure 'CALCULATE'
    result = calculate_1(&ops, clnt);
    if (result == NULL) {
        clnt_perror(clnt, argv[1]);
        exit(1);
    }

    // Print the result received from the server
    printf("Result: %f\n", *result);

    // Cleanup client handle
    clnt_destroy(clnt);
    return 0;
}
