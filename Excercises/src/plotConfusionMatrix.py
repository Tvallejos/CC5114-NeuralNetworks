import matplotlib.pyplot as plt

fig = plt.figure()
ax = fig.add_subplot(111)
y = [1, 2, 3, 4, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1]    
col_labels = ['Gold-Iris-setosa', 'Gold-Iris-versicolor', 'Gold-Iris-virginica']
row_labels = ['Predicted-Iris-setosa', 'Predicted-Iris-versicolor', 'Predicted-Iris-virginica']
File = open("../Confusion.txt",'r')
lines = File.readlines()
table = []
for line in lines:
	line =line.replace('\n',"")
	line=line.split(" ")
	for i in range(len(line)):
		line[i] = int(line[i])
	table.append(line)
		
# Draw table
the_table = plt.table(cellText=table,
                      colWidths=[0.3] * 3,
                      rowLabels=row_labels,
                      colLabels=col_labels,
                      loc='center')
the_table.auto_set_font_size(False)
the_table.set_fontsize(24)
the_table.scale(4, 4)

plt.title('Confusion Matrix for 200 epoch and 70% of the dataset to train',fontsize=40)
# Removing ticks and spines enables you to get the figure only with table
plt.tick_params(axis='x', which='both', bottom=False, top=False, labelbottom=False)
plt.tick_params(axis='y', which='both', right=False, left=False, labelleft=False)
for pos in ['right','top','bottom','left']:
    plt.gca().spines[pos].set_visible(False)
plt.savefig('matplotlib-table.png', bbox_inches='tight', pad_inches=0.05)