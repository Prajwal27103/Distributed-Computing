import ipaddress

ip=ipaddress.ip_interface(input("Enter ip address:"))

print("Block address=",ip.network)

ip_network=ipaddress.ip_network(ip,strict=False)

print("Broadcast address=",ip_network.broadcast_address)

