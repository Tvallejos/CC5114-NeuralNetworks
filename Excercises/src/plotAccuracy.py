import matplotlib.pyplot as plt


def triada(line):
    xydesired = line.split(" ")
    for i in range(len(xydesired)):
        xydesired[i] = float(xydesired[i])
    return xydesired


def plotLine(data):
    redx = []
    redy = []
    bluex = []
    bluey = []

    for line in data:
        line = line.replace('\n',"")
        actual = triada(line)
        color = actual[2]

        if color == 0.0:
            redx.append(actual[0])
            redy.append(actual[1])
        elif color == 1.0:
            bluex.append(actual[0])
            bluey.append(actual[1])

    x1 = [0,1]
    y1 = [0,1]

    plt.plot(redx,redy,'ro',bluex,bluey,'bo',x1,y1)
    plt.axis([0,1,0,1])
    plt.show()

def plotAccuracy(data):
    index= []
    accuracy=[]
    for line in data:
        line = line.replace('\n',"")
        line = line.split(" ")
        index.append(int(line[0]))
        accuracy.append(float(line[1]))
    plt.plot(index,accuracy,'ro')
    plt.axis([0,200,0,100])
    plt.xlabel('epoch')
    plt.ylabel('accuracy')
    plt.title('accuracy vs epoch')
    plt.show()

#File = open("./test.txt",'r')
#lines = File.readlines()
#plotLine(lines)

File = open("../Accuracy.txt",'r')
lines = File.readlines()
plotAccuracy(lines)

