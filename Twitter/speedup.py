import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
import pandas as pd
import numpy as np
import matplotlib.ticker as mticker

#1000 osservazioni
nodes=(1,2,3,4,5,6)
tempo=(0.98,56,40,32,36,31)
sequenziale=(0.98,0.98,0.98,0.98,0.98,0.98)
speedup=np.array(sequenziale)/np.array(tempo)
print(speedup)
#plot speedup
plt.scatter(nodes,speedup)
plt.plot(nodes,speedup)
plt.title("Speedup plot")
plt.gca().xaxis.set_major_locator(mticker.MultipleLocator(1))
plt.xlabel("Nodes")
plt.ylabel("Speedup")
plt.show()
#histogram
n_bins = 10
y=tempo
x=nodes
plt.bar(x,y,align='center',color="c") # A bar chart
plt.title("Timing esecution")
plt.xlabel('Threads')
plt.ylabel('Seconds')
plt.show()



#dataset normale:
nodes=(2,3,4,5,6)
tempo=(360,361,360,360,361)
sequenziale=(647,647,647,647,647)
speedup=np.array(sequenziale)/np.array(tempo)
print(speedup)
#plot speedup
plt.scatter(nodes,speedup)
plt.plot(nodes,speedup)
plt.title("1 input data")
plt.gca().xaxis.set_major_locator(mticker.MultipleLocator(1))
plt.xlabel("Nodes")
plt.ylabel("Speedup")
plt.show()

#dataset normale con 5 mapper e 5 reducer:
nodes=(2,3,4,5,6)
tempo=(228,197,171,161,157)
sequenziale=(647,647,647,647,647)
speedup=np.array(sequenziale)/np.array(tempo)
print(speedup)
#plot speedup
plt.scatter(nodes,speedup)
plt.plot(nodes,speedup)
plt.title("5 input splits")
plt.gca().xaxis.set_major_locator(mticker.MultipleLocator(1))
plt.xlabel("Nodes")
plt.ylabel("Speedup")
plt.show()


#dataset x3 con 5 mapper e 5 reducer
nodes=(2,3,4,5,6)
tempo=(584,577,500,392,392)
sequenziale=(1941,1941,1941,1941,1941)
speedup=np.array(sequenziale)/np.array(tempo)
print(speedup)
#plot speedup
plt.scatter(nodes,speedup)
plt.plot(nodes,speedup)
plt.title("5 input splits and 4.8M tweets")
plt.gca().xaxis.set_major_locator(mticker.MultipleLocator(1))
plt.xlabel("Nodes")
plt.ylabel("Speedup")
plt.show()


#dataset normale con 10 mapper e 10 reducer:
nodes=(2,3,4,5,6)
tempo=(228,143,120,111,104)
sequenziale=(647,647,647,647,647)
speedup=np.array(sequenziale)/np.array(tempo)
print(speedup)
#plot speedup
plt.scatter(nodes,speedup)
plt.plot(nodes,speedup)
plt.title("10 input splits")
plt.gca().xaxis.set_major_locator(mticker.MultipleLocator(1))
plt.xlabel("Nodes")
plt.ylabel("Speedup")
plt.show()



#dataset x3 con 10 mapper e 10 reducer
nodes=(2,3,4,5,6)
tempo=(524,365,305,226,222)
sequenziale=(1941,1941,1941,1941,1941)
speedup=np.array(sequenziale)/np.array(tempo)
print(speedup)
#plot speedup
plt.scatter(nodes,speedup)
plt.plot(nodes,speedup)
plt.title("10 input splits and 4.8M tweets")
plt.gca().xaxis.set_major_locator(mticker.MultipleLocator(1))
plt.xlabel("Nodes")
plt.ylabel("Speedup")
plt.show()


#dataset x3 con 20 mapper e 10 reducer
nodes=(2,3,4,5,6)
tempo=(698,472,348,258,202)
sequenziale=(1941,1941,1941,1941,1941)
speedup=np.array(sequenziale)/np.array(tempo)
print(speedup)
#plot speedup
plt.scatter(nodes,speedup)
plt.plot(nodes,speedup)
plt.title("20 input splits and 4.8M tweets")
plt.gca().xaxis.set_major_locator(mticker.MultipleLocator(1))
plt.xlabel("Nodes")
plt.ylabel("Speedup")
plt.show()




#k-means sul mio pc
threads=(1,2,3,4,5,6,7)
tempo=(186.833,131.318,128.658,109.824,113.157,111.582,112.294)
sequenziale=(186.833,186.833,186.833,186.833,186.833,186.833,186.833)
speedup=np.array(sequenziale)/np.array(tempo)
print(speedup)
#plot speedup
plt.scatter(threads,speedup)
plt.plot(threads,speedup)
plt.title("500k points with K=3")
plt.gca().xaxis.set_major_locator(mticker.MultipleLocator(1))
plt.xlabel("Threads")
plt.ylabel("Speedup")
plt.show()






















