dic=[]
while True:
    print("****************************************")
    print("*         Sookmyung Dictionary         *")
    print("****************************************")
    print("           1. Save words                ")
    print("           2. Delete words              ")
    print("           3. Print all words           ")
    print("           4. Exit                      ")
    print("========================================")

    num=int(input("Select >> "))
    if num==1:
        print("Enter word to save (Press 'Enter' key to finish)")
        print()
        while True:
            print("Word : ", end='')
            x=input()
            if len(x)==0:
                break
            if x in dic:
                print("Already Exist")
                continue
            dic.append(x)
        print()

    elif num==2:
        print("Enter word to delete")
        print()
        while True:
            print("Word : ", end='')
            y=input()
            if y in dic:
                dic.remove(y)
                print("Delete complete")
                break
            else:
                print("No Exist")
                continue
        print()
        
    elif num==3:
        print()
        for i in dic:
            print(i)
        print()
        
    elif num==4:
        break
    
    else:
        print("You entered wrong menu")
        print()
        continue
            
        
