import time
import psutil
import matplotlib.animation as animation
import threading
import matplotlib.pyplot as plt
from tkinter import messagebox, Tk

U_THRESHOLD=80
#initialize plotting
fig,ax=plt.subplots()
cpu_usage_data=[]

def update_graph():
    cpu_usage=psutil.cpu_percent(interval=1)
    cpu_usage_data.append(cup_usage)
    
    #limit the displayed data point to 100
    if len(cpu_usage_data)>100:
        cpu_usage_data.pop(0)
    
    ax.clear()
    ax.plot(cpu_usage_data, label='CPU Usage (%)')
    ax.axhline(y=CPU_THRESHOLD,color='r',linestyle='--',label='Threshold')
    ax.legend(loc='upper right')
    ax.set_ylim(0,100)
    ax.set_title('CPU Usage Over Time')
    ax.set_xlabel('Time (s)')
    ax.set_ylabel('CPU Usage (%)')

def monitor_cpu():
    root-Tk()
    root.withdraw()
    while True:
        cpu_usage=psutil.cpu_percent(interval=1)
        if cpu_usage > CPU_THRESHOLD:
            response= messagebox.askyesno("Warning",'High CPU usage detected!\nAre you performing a CPU-intensive task?')
            if not respose:
                messagebox.showinfo("Waring","You may have been cryptojacked.\nPlease cosider the following steps:\n\n","1.Check running processes.\n","2.Reboot the system.\n","3.Check SSH Credentials.\n","4.Scan for malware.\n")
                
        time.sleep(2) #check every 2 seconds

#set up system monitoring in a separate thread
threading.Thread(target=monitor_cpu, deamon=True)
#set up live plot update
ani=animation.FuncAnimation(fig,update_graph,interval=1000)
plt.show
