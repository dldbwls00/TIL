def saveWords():
    print("Enter word to save. Press 'Enter' to finish")
    print()
    while True:
        word=input("Word : ")
        if word=='':
            print()
            break
        if word in dic:
            print("Already Exist")
            continue
        mean=input("Mean : ")
        dic[word]=mean
        
def deleteWords():
    print("Enter word to delete")
    print()
    while True:
        word=input("Word : ")
        if word not in dic:
            print("No such words")
            continue
        else:
            del dic[word]
            print("Deletion is completed")
            print()
            break

def printWords():
    print()
    for i in dic:
        print(i, '\t', dic[i])
    print()

def searchWords():
    print("Enter word to search")
    print()
    while True:
        word=input("word : ")
        if word not in dic:
            print(word, "is not found")
            print()
            break
        else:
            print(word, '\t', dic[word])
            print()
            break
        
def wordTest():
    sc=0
    for i in dic:
        print(i, end='')
        mean=input(" : ")
        if mean==dic[i]:
            print("Correct!")
            sc=sc+1
        else:
            print("Wrong..")
        print()
    print("You got", sc, "answers")
    score.append(sc)
    print()
            
def testScore():
    print("    ScoreBoard    ")
    print("==================")
    score.sort(reverse=True)
    for i in range(len(score)):
        print(i+1,"rank\t", score[i], "answers")
    print()

dic={}
score=[]


while True:
    print("****************************************")
    print("*         Sookmyung Dictionary         *")
    print("****************************************")
    print("           1. Save words                ")
    print("           2. Delete words              ")
    print("           3. Print all words           ")
    print("           4. Search word               ")
    print("           5. Word Test                 ")
    print("           6. Show Test Score           ")
    print("           7. Exit                      ")
    print("========================================")

    num=int(input("Select >> "))
    if num==1:
        saveWords()
    elif num==2:
        deleteWords()
    elif num==3:
        printWords()
    elif num==4:
        searchWords()
    elif num==5:
        wordTest()
    elif num==6:
        testScore()
    elif num==7:
        print("Thanks for using dictionary")
        break
