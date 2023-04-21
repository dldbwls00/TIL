number=[]

while True:
    print("Enter numbers. (To finish press 'Enter' key)")
    n=input()
    if len(n)==0:
        break
    number.append(float(n))

number.sort()
number_len=len(number)
number_center=int(number_len/2)

if number_len%2==0:
    median=(number[number_center-1]+number[number_center])/2
else:
    median=number[number_center]
minimum=min(number)
maximum=max(number)

print("You entered\n", number, sep='')
print()
print("max : %.1f \nmin : %.1f \nmedian : %.2f" %(maximum, minimum, median))
