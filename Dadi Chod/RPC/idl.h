/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#ifndef _IDL_H_RPCGEN
#define _IDL_H_RPCGEN

#include <tirpc/rpc/rpc.h>
#include <tirpc/rpc/types.h>
#include <tirpc/rpc/xdr.h>
#include <tirpc/netconfig.h>


#ifdef __cplusplus
extern "C" {
#endif


struct operands {
	double op1;
	double op2;
	char operator;
};
typedef struct operands operands;

#define CALCULATOR_PROG 0x23451111
#define CALCULATOR_VERS 1

#if defined(__STDC__) || defined(__cplusplus)
#define CALCULATE 1
extern  double * calculate_1(operands *, CLIENT *);
extern  double * calculate_1_svc(operands *, struct svc_req *);
extern int calculator_prog_1_freeresult (SVCXPRT *, xdrproc_t, caddr_t);

#else /* K&R C */
#define CALCULATE 1
extern  double * calculate_1();
extern  double * calculate_1_svc();
extern int calculator_prog_1_freeresult ();
#endif /* K&R C */

/* the xdr functions */

#if defined(__STDC__) || defined(__cplusplus)
extern  bool_t xdr_operands (XDR *, operands*);

#else /* K&R C */
extern bool_t xdr_operands ();

#endif /* K&R C */

#ifdef __cplusplus
}
#endif

#endif /* !_IDL_H_RPCGEN */