#include "sysinfo.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

float *get_cpu_usage_1_svc(void *argp, struct svc_req *rqstp) {
    static float cpu_usage;
    FILE *fp = popen("top -bn1 | grep 'Cpu(s)' | awk '{print $2}'", "r");
    if (fp) {
        fscanf(fp, "%f", &cpu_usage);
        pclose(fp);
    } else {
        cpu_usage = -1;  // Error case
    }
    return &cpu_usage;
}

float *get_memory_usage_1_svc(void *argp, struct svc_req *rqstp) {
    static float memory_usage;
    FILE *fp = popen("free | grep Mem | awk '{print ($3/$2)*100}'", "r");
    if (fp) {
        fscanf(fp, "%f", &memory_usage);
        pclose(fp);
    } else {
        memory_usage = -1;  // Error case
    }
    return &memory_usage;
}

