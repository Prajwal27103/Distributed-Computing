#include "sysinfo.h"
#include <stdio.h>

int main(int argc, char *argv[]) {
    CLIENT *client;
    float *result;

    if (argc != 2) {
        fprintf(stderr, "Usage: %s <hostname>\n", argv[0]);
        return 1;
    }

    client = clnt_create(argv[1], SYSINFO_PROG, SYSINFO_VERS, "udp");
    if (client == NULL) {
        clnt_pcreateerror(argv[1]);
        return 1;
    }

    result = get_cpu_usage_1(NULL, client);
    if (result != NULL) printf("CPU Usage: %.2f%%\n", *result);

    result = get_memory_usage_1(NULL, client);
    if (result != NULL) printf("Memory Usage: %.2f%%\n", *result);

    clnt_destroy(client);
    return 0;
}

