program SYSINFO_PROG {
    version SYSINFO_VERS {
        float GET_CPU_USAGE(void) = 1;
        float GET_MEMORY_USAGE(void) = 2;
    } = 1;
} = 0x23456789;

