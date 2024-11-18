import ipaddress
import math
ip=str(input("Enter IP network-address:"))
n=int(input("Enter number of subnets you need:"))
if(math.log(n,2)+int(ip[-2::])>32):
    print("Subnetting Not Possible")
else:
    ip=ipaddress.ip_network(ip, strict=False)
    new_prefix=ip.prefixlen +int (math.log(n,2))
    subnets=list(ip.subnets(new_prefix=new_prefix))
    for subnet in subnets:
        net_address=subnet.network_address
        dba=subnet.broadcast_address
        print("Subnet:",subnet)
        print("Range:",net_address,"-",dba)
