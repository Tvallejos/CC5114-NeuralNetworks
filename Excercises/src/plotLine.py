import matplotlib.pyplot as plt

def triada(line):
    xydesired = line.split(" ")
    for i in range(len(xydesired)):
        xydesired[i] = float(xydesired[i])
    print(xydesired)
    return xydesired

def plotLine(data):
    redx = []
    redy = []
    bluex = []
    bluey = []

    for line in lines:
        line = line.replace('\n',"")
        actual = triada(line)
        color = actual[2]

        if(color==0.0):
            redx.append(actual[0])
            redy.append(actual[1])
        elif(color==1.0):
            bluex.append(actual[0])
            bluey.append(actual[1])

    plt.plot(redx,redy,'ro',bluex,bluey,'bo')
    plt.axis([0,1,0,1])
    plt.show()

File = open("../20190812_192722.txt",'r')
lines = File.readlines()
plotLine(lines)

input()
        
    

    